package com.mvc.domain.ticket.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TicketIssueDto {
    private Long userId;
    private Long ticketId;
}
