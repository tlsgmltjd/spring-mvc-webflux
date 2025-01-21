package com.webflux.domain.ticket.application;

import com.webflux.domain.ticket.dto.TicketIssueDto;
import reactor.core.publisher.Mono;

public interface TicketService {
    Mono<Void> issue(TicketIssueDto dto);
}
