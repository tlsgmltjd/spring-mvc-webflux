package com.webflux.domain.ticket.persistence;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface TicketUserRepository extends R2dbcRepository<TicketUser, Long> {
}
