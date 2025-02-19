package com.mvc.domain.ticket.application;

import com.mvc.domain.ticket.dto.TicketDto;
import com.mvc.domain.ticket.dto.TicketUserDto;
import com.mvc.domain.ticket.persistence.Ticket;
import com.mvc.domain.ticket.persistence.TicketRepository;
import com.mvc.domain.ticket.persistence.TicketUser;
import com.mvc.domain.ticket.persistence.TicketUserRepository;
import com.mvc.domain.user.persistence.User;
import com.mvc.domain.user.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    @Transactional(readOnly = true)
    public TicketDto queryTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(RuntimeException::new);

        List<TicketUserDto> ticketUsersDto = ticketUserRepository.find50()
                .stream().map(t -> TicketUserDto.builder()
                        .userId(t.getUser().getId())
                        .name(t.getUser().getName())
                        .build())
                .toList();

        return TicketDto.builder()
                .ticketId(ticket.getId())
                .ticketName(ticket.getName())
                .count(ticket.getCount())
                .limitCount(ticket.getLimitCount())
                .ticketUsers(ticketUsersDto)
                .build();
    }

}
