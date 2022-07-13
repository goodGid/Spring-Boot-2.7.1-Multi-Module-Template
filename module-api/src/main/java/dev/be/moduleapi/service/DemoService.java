package dev.be.moduleapi.service;

import org.springframework.stereotype.Service;

import dev.be.modulecommon.domain.Member;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DemoService {

    public String save() {
        Member member = new Member("goodGid");
        System.out.println(member.getName());
        return "save";
    }

    public String find() {
        return "find";
    }
}
