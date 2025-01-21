package com.mvc.domain.ticket.application;

public interface TicketService {
    void issue(Long userId, Long ticketId);
}
