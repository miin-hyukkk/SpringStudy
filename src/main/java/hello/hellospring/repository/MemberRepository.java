package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;



public interface MemberRepository {
    Member save (Member member);
    Optional<Member> findById(Long id); //없으면 널로 반환되는데 optional로 감싸서 반환하는 방법 선호
    Optional<Member> findByName(String name);
    List<Member> findAll();
    //이렇게 리포지토리에 네가지 기능을 만듬 그럼 이제 구현체를 만들어야지 ->이게 메모리멤버리포지터리
}
