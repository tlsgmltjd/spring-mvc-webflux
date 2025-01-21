package com.mvc.domain.ticket.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketUserRepository extends JpaRepository<TicketUser, Long> {
}
