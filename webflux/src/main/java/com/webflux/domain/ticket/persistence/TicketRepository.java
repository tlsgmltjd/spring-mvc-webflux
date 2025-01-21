package com.webflux.domain.ticket.persistence;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface TicketRepository extends R2dbcRepository<Ticket, Long> {
}
