package com.webflux.domain.ticket.persistence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TicketRepository extends ReactiveCrudRepository<Ticket, Long> {
}
