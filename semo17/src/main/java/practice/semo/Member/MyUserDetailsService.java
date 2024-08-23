
package practice.semo.Member;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

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

        var aaa = new CustomUser(user.getUsername(),user.getPassword(),authorities);
        aaa.displayName = user.getDisplayName(); //DB에 있던 유저 이름
        return aaa;


    }
}

class CustomUser extends User{
    public String displayName;

    public CustomUser(  //자동완성 기능으로 만듬
                        String username,
                        String password,
                        Collection<? extends GrantedAuthority> authorities)
    {
        super(username, password, authorities);
    }
}