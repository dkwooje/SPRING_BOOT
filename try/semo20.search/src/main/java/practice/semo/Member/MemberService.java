
package practice.semo.Member;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    public void addMember(String username, String password, String displayName){
        DBMember member =  new DBMember();
        var hash = passwordEncoder.encode(password);
        member.setPassword(hash);
        member.setUsername(username);
        member.setDisplayName(displayName);
        memberRepository.save(member);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //DB에서 username을 가진 유저를 찾아와서
        // return new User(유저아이디, 비번, 권한) 해주세요
        var result = memberRepository.findByUsername(username); //username과 일치하는 행을 가져옴
        if (result.isEmpty()) {
            throw new UsernameNotFoundException("그런 아이디 없음");
        }
        var user = result.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("일반유저")); //나중에 API에서 현재 유저의 정보 출력 가능
        var A = new CustomUser(user.getUsername(),user.getPassword(), authorities);
         A.displayName = user.getDisplayName();
        return A;

        /*
        해시 인코딩을 사용하여 비밀번호 적용
         */

    }
}
