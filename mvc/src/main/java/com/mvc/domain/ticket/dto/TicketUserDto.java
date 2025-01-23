package com.mvc.domain.ticket.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class TicketUserDto {
    private Long userId;
    private String name;
}
