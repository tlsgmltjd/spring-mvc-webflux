package com.mvc.domain.ticket.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketUserRepository extends JpaRepository<TicketUser, Long> {
    @Query(value = "SELECT * FROM tbl_ticket_user ORDER BY id ASC LIMIT 50", nativeQuery = true)
    List<TicketUser> find50();
}
