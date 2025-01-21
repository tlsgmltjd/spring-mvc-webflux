package com.mvc.domain.ticket.application;

import com.mvc.domain.ticket.dto.TicketIssueDto;

public interface TicketService {
    void issue(TicketIssueDto dto);
}
