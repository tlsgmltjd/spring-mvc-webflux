package com.webflux.domain.ticket.application;

import com.webflux.domain.ticket.dto.TicketIssueDto;
import com.webflux.domain.ticket.persistence.Ticket;
import com.webflux.domain.ticket.persistence.TicketRepository;
import com.webflux.domain.ticket.persistence.TicketUser;
import com.webflux.domain.ticket.persistence.TicketUserRepository;
import com.webflux.domain.user.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;
    private final TicketUserRepository ticketUserRepository;

    @Override
    @Transactional
    public Mono<Void> issue(TicketIssueDto dto) {
        Long userId = dto.getUserId();
        Long ticketId = dto.getTicketId();

        return userRepository.findById(userId)
                .switchIfEmpty(Mono.error(new RuntimeException("User not found")))
                .flatMap(user ->
                        ticketRepository.findById(ticketId)
                                .switchIfEmpty(Mono.error(new RuntimeException("Ticket not found")))
                                .flatMap(ticket -> {
                                    ticket.addCount();
                                    TicketUser ticketUser = TicketUser.of(user.getId());
                                    return ticketRepository.save(ticket)
                                            .then(ticketUserRepository.save(ticketUser));
                                })
                )
                .then();
    }
}
