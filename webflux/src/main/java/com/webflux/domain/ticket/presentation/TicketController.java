package com.webflux.domain.ticket.presentation;

import com.webflux.domain.ticket.application.TicketService;
import com.webflux.domain.ticket.dto.TicketDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final WebClient webClient;

    private final TicketService ticketService;

    @PostMapping("/issue")
    public Mono<ResponseEntity<Void>> issue(
            @RequestParam Long userId,
            @RequestParam Long ticketId
    ) {
        return ticketService.issue(userId, ticketId)
                .map(ResponseEntity::ok);
    }

    @GetMapping
    public Mono<ResponseEntity<TicketDto>> queryTicket(
            @RequestParam Long ticketId
    ) {
        return ticketService.queryTicket(ticketId)
                .map(ResponseEntity::ok);
    }

    @GetMapping("/ping")
    public Mono<String> ping() {
        return webClient.get()
                .uri("/delay/2")
                .retrieve()
                .bodyToMono(String.class);
    }

}

