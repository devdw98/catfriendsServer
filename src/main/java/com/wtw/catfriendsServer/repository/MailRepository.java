package com.wtw.catfriendsServer.repository;

import com.wtw.catfriendsServer.domain.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<Mail, Long> {
    public Mail findByProductCode(String productCode);
}
