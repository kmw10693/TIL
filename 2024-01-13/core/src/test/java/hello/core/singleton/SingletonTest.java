package hello.core.singleton;

import hello.core.member.MemberService;
import hello.core.order.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class SingletonTest {

     @Test
     @DisplayName("스프링 없는 순수한 DI 컨테이너")
     void pureContainer() {
         AppConfig appConfig = new AppConfig();

         MemberService memberService1 = appConfig.memberService();
         MemberService memberService2 = appConfig.memberService();

         Assertions.assertThat(memberService1).isNotSameAs(memberService2);
     }
     @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
         SingletonService S1 = SingletonService.getInstance();
         SingletonService S2 = SingletonService.getInstance();

         Assertions.assertThat(S1).isSameAs(S2);

     }

     @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
         AnnotationConfigApplicationContext ap = new AnnotationConfigApplicationContext(AppConfig.class);

         MemberService memberService1 = ap.getBean("memberService", MemberService.class);
         MemberService memberService2 = ap.getBean("memberService", MemberService.class);

         Assertions.assertThat(memberService1).isSameAs(memberService2);
     }
}
