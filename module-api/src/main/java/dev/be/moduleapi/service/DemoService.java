package dev.be.moduleapi.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DemoService {

    public String save() {
        return "save";
    }

    public String find() {
        return "find";
    }
}
