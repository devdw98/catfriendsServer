package com.wtw.catfriendsServer.repository;

import com.wtw.catfriendsServer.domain.user.Chunbae;
import com.wtw.catfriendsServer.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChunbaeRepository extends JpaRepository<Chunbae, Long> {
    public Chunbae findByUser(User user);
}
