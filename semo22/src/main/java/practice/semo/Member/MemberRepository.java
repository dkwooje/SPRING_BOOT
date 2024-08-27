package practice.semo.Member;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface MemberRepository extends JpaRepository<DBMember,Long> {

  Optional<DBMember> findByUsername(String username);


    //derived query method
    //and,or 조건주기, 특정문자 포함되었는지 검색하기, 특정 숫자 이상/이하인거 검색하기, 정렬하기
}
