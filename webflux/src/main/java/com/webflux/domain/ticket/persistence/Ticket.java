package com.webflux.domain.ticket.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Builder
@Getter
@ToString
@Table(name = "tbl_ticket")
public class Ticket {
    @Id
    private Long id;

    private String name;

    private Integer count;

    @Column("limit_count")
    private Integer limitCount;

    public void addCount() {
        if (count >= limitCount) {
            throw new RuntimeException();
        }

        this.count++;
    }

}
