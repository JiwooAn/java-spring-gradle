package service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Member;
import repository.MemoryMemberRepository;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;
    
    @BeforeEach
    public void BeforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository); // 직접 new 하지 X. 메모리를 외부에서 넣어줌 -> DI(Dependency Injection, 의존성 주입)
    }

    @AfterEach
    public void afterEact() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        // assertThrows(NullPointerException.class, () -> memberService.join(member2));
        
        // assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다. 초밥 내놔.");
        
        // try {
        //     memberService.join(member2);
        //     fail();
        // } catch (IllegalStateException e) {
        //     assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다. 배고프다. 초밥 달라.");
        // }

        // memberService.join(member2);


        // then
    }

    @Test
    void testFindMembers() {

    }

    @Test
    void testFindOne() {

    }

}
