package hello.servlet.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Member member = new Member("hello", 20);

        Member saveMember = memberRepository.save(member);

        Member findMember = memberRepository.findById(saveMember.getId());
        org.assertj.core.api.Assertions.assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findAll() {
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();

        org.assertj.core.api.Assertions.assertThat(result.size()).isEqualTo(2);
        org.assertj.core.api.Assertions.assertThat(result).contains(member1, member2);
    }
}