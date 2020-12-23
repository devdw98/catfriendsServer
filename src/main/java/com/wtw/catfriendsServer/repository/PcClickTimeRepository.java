package com.wtw.catfriendsServer.repository;

import com.wtw.catfriendsServer.domain.user.pc.PcClickTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PcClickTimeRepository extends JpaRepository<PcClickTime, Long> {
}
