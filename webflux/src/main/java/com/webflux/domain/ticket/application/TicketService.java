package com.webflux.domain.ticket.application;

import com.webflux.domain.ticket.dto.TicketDto;
import reactor.core.publisher.Mono;

public interface TicketService {
    Mono<Void> issue(Long userId, Long ticketId);
    Mono<TicketDto> queryTicket(Long ticketId);
}
