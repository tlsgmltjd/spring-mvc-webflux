package com.mvc.domain.ticket.presentation;

import com.mvc.domain.ticket.application.TicketService;
import com.mvc.domain.ticket.dto.TicketIssueDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TickerController {

    private final TicketService ticketService;

    @PostMapping("/issue")
    public ResponseEntity<Void> issue(
            @RequestBody TicketIssueDto dto
    ) {
        ticketService.issue(dto);
        return ResponseEntity.ok().build();
    }

}
