package com.webflux.domain.ticket.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(name = "tbl_ticket_user")
@AllArgsConstructor
@Builder
@Getter
@ToString
public class TicketUser {
    @Id
    private Long id;

    private Long userId;

    private LocalDateTime createTime;

    public static TicketUser of(Long userId) {
        return TicketUser.builder()
                .userId(userId)
                .createTime(LocalDateTime.now())
                .build();
    }

}
