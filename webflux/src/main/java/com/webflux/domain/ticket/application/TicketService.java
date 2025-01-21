package com.webflux.domain.ticket.application;

import reactor.core.publisher.Mono;

public interface TicketService {
    Mono<Void> issue(Long userId, Long ticketId);
}
