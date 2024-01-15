package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemorMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemorMemberRepository memberRepository = new MemorMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(new MemorMemberRepository(), new FixDiscountPolicy());
        orderService.createOrder(1L, "iteamA", 10000);
    }

}