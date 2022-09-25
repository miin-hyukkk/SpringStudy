package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    //저장을 해놔야지 맵으로 , 실무에서는 공유되는 변수면 동시성문제때문에 concurrent 써야되는데 이건 그냥 예제니까 hashmap 사용
    //hashmap: map 인터페이스를 구현한 대표적인 map 컬렉션, 값은 중복저장 가능 키는 중복저장 불가능
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // 0,1,2 키값을 생성해주는 애 , 실무에서는 다른거 쓴다네 동시성 고려로 인해
    @Override
    public Member save(Member member) {
         member.setId(++sequence);
         //store 에 넣기전에 아이디값을 세팅해주고 아까 맴버파일에서 시스템에서 정해주는 id 그거 설정해주는 부분인거임
         store.put(member.getId(),member);
         return member;
    }
    @Override
    public Optional<Member> findById(Long id) {
        //store에서 get으로 꺼내줌
        return Optional.ofNullable(store.get(id));
    }
    @Override
    public Optional<Member> findByName(String name) {
        //람다 사용
        //루프돌리는거임 member.getName()이랑 파리미터로 넘어온 네임이랑 같은지 확인하는거임
        //찾으면 반환, 루프를 다 돌면서 하나 찾으면 걔를 그냥 반환, 끝까지 돌렸는데 없으면 옵셔널을 껴서 널 반환
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }
    @Override
    public List<Member> findAll() {
        //반환 : 자바에서 실무로 list를 많이 사용
        return new ArrayList<>(store.values());
        //values: member들
    }
    public void clearStore(){
        store.clear();
    }
}
