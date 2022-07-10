package dev.be.modulecommon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.be.modulecommon.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
