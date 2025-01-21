package com.mvc.domain.ticket.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer count;

    @Column(name = "limit_count")
    private Integer limitCount;

    public void addCount() {
        if (count >= limitCount) {
            throw new RuntimeException();
        }

        count++;
    }

}
