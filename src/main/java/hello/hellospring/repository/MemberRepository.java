package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;


@Repository
public interface MemberRepository {
    Member save (Member member);
    Optional<Member> findById(Long id); //없으면 널로 반환되는데 optional로 감싸서 반환하는 방법 선호
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
