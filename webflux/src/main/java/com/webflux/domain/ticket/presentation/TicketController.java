package com.webflux.domain.ticket.presentation;


import com.webflux.domain.ticket.application.TicketService;
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
    public Mono<ResponseEntity<Void>> issueTicket(
            @RequestParam Long userId,
            @RequestParam Long ticketId
    ) {
        return ticketService.issue(userId, ticketId)
                .then(Mono.just(ResponseEntity.ok().build()));
    }
}
