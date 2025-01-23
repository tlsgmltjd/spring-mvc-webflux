package com.webflux.domain.ticket.application;

import com.webflux.domain.ticket.dto.TicketDto;
import com.webflux.domain.ticket.dto.TicketUserDto;
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
    public Mono<Void> issue(Long userId, Long ticketId) {
        return Mono.zip(
                        userRepository.findById(userId),
                        ticketRepository.findById(ticketId)
                )
                .flatMap(tuple -> {
                    var user = tuple.getT1();
                    var ticket = tuple.getT2();

                    ticket.addCount();
                    TicketUser ticketUser = TicketUser.of(user.getId());

                    return Mono.zip(
                            ticketRepository.save(ticket),
                            ticketUserRepository.save(ticketUser)
                    ).then();
                });
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<TicketDto> queryTicket(Long ticketId) {
        return ticketRepository.findById(ticketId)
                .flatMap(ticket ->
                        ticketUserRepository.find50()
                                .flatMap(ticketUser ->
                                        userRepository.findById(ticketUser.getUserId())
                                                .map(user -> TicketUserDto.builder()
                                                        .userId(ticketUser.getUserId())
                                                        .name(user.getName())
                                                        .build())
                                )
                                .collectList()
                                .map(ticketUsers -> TicketDto.builder()
                                        .ticketId(ticket.getId())
                                        .ticketName(ticket.getName())
                                        .count(ticket.getCount())
                                        .limitCount(ticket.getLimitCount())
                                        .ticketUsers(ticketUsers)
                                        .build()
                                )
                );
    }
}