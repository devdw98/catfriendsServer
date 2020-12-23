package com.wtw.catfriendsServer.repository;

import com.wtw.catfriendsServer.domain.user.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
