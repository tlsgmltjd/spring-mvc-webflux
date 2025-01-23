package com.mvc.domain.ticket.application;

import com.mvc.domain.ticket.dto.TicketDto;

public interface TicketService {
    void issue(Long userId, Long ticketId);
    TicketDto queryTicket(Long ticketId);
}
