package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //
public class SpringConfig {

    @Bean //스프링 빈을 내가 등록할거야!
    public MemberService memberService(){
        return  new MemberService(memberRepository()); //생성자니까 안에 뭐 넣어줘야지
        //안에 지금 멤버리포지토리 넣었잖아 서비스랑 레포지토리 연결해준거지 (컨테이너스캔의 autowired 느낌인거야)
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
        //멤버리포지토리는 인터페이스고  그거의 구현체인 메모리멤버리포지토리를 리턴
    }

}
