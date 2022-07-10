package dev.be.moduleapi.service;

import org.springframework.stereotype.Service;

import dev.be.modulecommon.domain.Member;
import dev.be.modulecommon.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DemoService {

    private final MemberRepository memberRepository;

    public String save() {
        Member newMember = memberRepository.save(Member.builder()
                                                       .name(Thread.currentThread().getName())
                                                       .build());
        return newMember.getName();
    }

    public String find() {
        return String.valueOf(memberRepository.findAll().size());
    }
}
