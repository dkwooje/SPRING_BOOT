
package practice.semo.Member;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import practice.semo.SecurityConfig;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    public void addMember(String username,
                          String password,
                          String displayName){
        DBMember dbMember = new DBMember();
        // var hash = passwordEncoder.encode(password);
        //   member.setPassword(password);
        var hash = new BCryptPasswordEncoder().encode(password);
        dbMember.setPassword(hash);
        dbMember.setUsername(username);
        dbMember.setDisplayName(displayName);
        memberRepository.save(dbMember);



    }

}
