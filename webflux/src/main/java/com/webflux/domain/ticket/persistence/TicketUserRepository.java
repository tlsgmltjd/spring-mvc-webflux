package com.webflux.domain.ticket.persistence;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface TicketUserRepository extends ReactiveCrudRepository<TicketUser, Long> {
    @Query("SELECT * FROM tbl_ticket_user ORDER BY id ASC LIMIT 50")
    Flux<TicketUser> find50();
}
