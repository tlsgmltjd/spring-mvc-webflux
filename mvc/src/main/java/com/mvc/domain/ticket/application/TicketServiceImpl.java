package com.mvc.domain.ticket.application;

import com.mvc.domain.ticket.persistence.Ticket;
import com.mvc.domain.ticket.persistence.TicketRepository;
import com.mvc.domain.ticket.persistence.TicketUser;
import com.mvc.domain.ticket.persistence.TicketUserRepository;
import com.mvc.domain.user.persistence.User;
import com.mvc.domain.user.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;
    private final TicketUserRepository ticketUserRepository;

    @Override
    @Transactional
    public void issue(Long userId, Long ticketId) {
        User user = userRepository.findById(userId)
                .orElseThrow(RuntimeException::new);

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(RuntimeException::new);

        ticket.addCount();
        TicketUser ticketUser = TicketUser.of(user);

        ticketRepository.save(ticket);
        ticketUserRepository.save(ticketUser);
    }

}
