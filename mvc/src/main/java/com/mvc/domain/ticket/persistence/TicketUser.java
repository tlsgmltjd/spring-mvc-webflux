package com.mvc.domain.ticket.persistence;

import com.mvc.domain.user.persistence.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_ticket_user")
public class TicketUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime createTime;

    public static TicketUser of(User user) {
        return TicketUser.builder()
                .user(user)
                .createTime(LocalDateTime.now())
                .build();
    }

}
