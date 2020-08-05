package com.wtw.catfriendsServer.oauth2.repository;

import com.wtw.catfriendsServer.oauth2.domain.Member;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="oauth2") //내부적으로 restAPI 생성, "/oauth2" uri로 변경
public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {
}
