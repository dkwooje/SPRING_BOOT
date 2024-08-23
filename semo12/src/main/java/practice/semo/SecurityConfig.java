package practice.semo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity//이 두 에노테이션은 시큐리티 설정을 만들 수 있다.
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable());
        http.authorizeHttpRequests((authorize) ->
                authorize.requestMatchers("/**").permitAll()
        );
        return http.build();
    }
}
// http.csrf((csrf) -> csrf.disable()); csrf보안 끄기
//permitAll: 항상 허용
//FilterChain:유저의 요청과 서버의 응답 사이에 자동으로 실행해주고 싶은 코드 담는 곳
//SecurityFilterChain 특정페이지 검사할지 설정 가능