package practice.semo.Member;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void addMember(  String username,
                             String displayName,
                             String password){
        DBMember member = new DBMember();
        var hash = new BCryptPasswordEncoder().encode(password);
        member.setUsername(username);
        member.setDisplayName(displayName);
        member.setPassword(hash);
        memberRepository.save(member);


    }


}
