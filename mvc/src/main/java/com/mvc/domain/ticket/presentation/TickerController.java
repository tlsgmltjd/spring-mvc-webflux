package com.mvc.domain.ticket.presentation;

import com.mvc.domain.ticket.application.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TickerController {

    private final TicketService ticketService;

    @PostMapping("/issue")
    public ResponseEntity<Void> issue(
            @RequestParam Long userId,
            @RequestParam Long ticketId
    ) {
        ticketService.issue(userId, ticketId);
        return ResponseEntity.ok().build();
    }

}
