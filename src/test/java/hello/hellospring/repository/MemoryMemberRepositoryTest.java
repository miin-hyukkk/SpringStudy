package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    //메모리멤버리포지토리만 테스트하는거니까 인터페이스(MemberRepository)에서 MemoryMemberRepository로 바꿔줄거임
    @AfterEach
    public void afterEach(){
        //테스트 한번할때마다 싹 비워줌
        repository.clearStore();
    }
    @Test
    public  void save(){
        Member member = new Member();
        member.setName("spring");
        repository.save(member);//리포지토리에 멤버를 저장
        Member result = repository.findById(member.getId()).get();
        //저장한거랑 멤버 명단이랑 같으면 참
        //System.out.println("result = " + (result == member));
        //매번 출력할 수 없잖아 그래서 쓰는게 밑에 있는 assertions
        Assertions.assertEquals(member, result); //출력되는거 없지만 밑에 체크표시가 뜨는지 안뜨는지로 확인하는거임
        assertThat(member).isEqualTo(result);//다른 방법
    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        Member result = repository.findByName("spring1").get();
        assertThat(member1).isEqualTo(result);//다른 방법
    }
    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
//테스트의 순서는 보장이 안됨
//순서에 의존적으로 설계하면 절대 안됨
//에러가 나는 이유는 이전에 저장되어있는 객체가 나와버림
//test 하나 끝나면 데이터를 클리어해줘야됨
