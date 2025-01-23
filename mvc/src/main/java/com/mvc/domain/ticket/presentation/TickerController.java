package com.mvc.domain.ticket.presentation;

import com.mvc.domain.ticket.application.TicketService;
import com.mvc.domain.ticket.dto.TicketDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TickerController {

    private final RestTemplate restTemplate;

    private final TicketService ticketService;

    @PostMapping("/issue")
    public ResponseEntity<Void> issue(
            @RequestParam Long userId,
            @RequestParam Long ticketId
    ) {
        ticketService.issue(userId, ticketId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<TicketDto> queryTicket(
            @RequestParam Long ticketId
    ) {
        TicketDto dto = ticketService.queryTicket(ticketId);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        ResponseEntity<String> response = restTemplate.getForEntity("https://httpbin.org/delay/2", String.class);
        return response;
    }

}
