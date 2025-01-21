package com.webflux.domain.ticket.presentation;


import com.webflux.domain.ticket.application.TicketService;
import com.webflux.domain.ticket.dto.TicketIssueDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/issue")
    public Mono<ResponseEntity<Void>> issueTicket(@RequestBody TicketIssueDto dto) {
        return ticketService.issue(dto)
                .then(Mono.just(ResponseEntity.ok().build()));
    }
}
