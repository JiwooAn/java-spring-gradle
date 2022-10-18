package com.example.demo.service;

import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.MemoryMemberRepository;

public class MemberServiceIntegrationTest {
    
    @Autowired MemberService memberService;
    @Autowired MemoryMemberRepository memberRepository;


    @AfterEach
    public void afterEach() { memberRepository.clearStore(); }
}
