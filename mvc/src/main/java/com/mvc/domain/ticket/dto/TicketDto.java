package com.mvc.domain.ticket.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class TicketDto {
    private Long ticketId;
    private String ticketName;
    private Integer count;
    private Integer limitCount;
    private List<TicketUserDto> ticketUsers;

}
