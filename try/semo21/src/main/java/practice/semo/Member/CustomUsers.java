package practice.semo.Member;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


import java.util.Collection;

public class CustomUsers extends User {
    public String displayName;

    public CustomUsers(  //자동완성 기능으로 만듬
                         String username,
                         String password,
                         Collection<? extends GrantedAuthority> authorities)
    {
        super(username, password, authorities);
    }


}