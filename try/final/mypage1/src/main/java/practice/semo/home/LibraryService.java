package practice.semo.home;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final LibraryRepository libraryRepository;
    private final PasswordEncoder passwordEncoder;

    public void addperson(String a_m_id,
                          String a_m_pw,
                          String a_m_name,
                          String a_m_gender,
                          String a_m_mail,
                          String a_m_phone){
            CostomerData data = new CostomerData();
        var hash = passwordEncoder.encode(a_m_pw);
            data.setA_m_id(a_m_id);
            data.setA_m_pw(hash);
            data.setA_m_name(a_m_name);
            data.setA_m_gender(a_m_gender);
            data.setA_m_mail(a_m_mail);
            data.setA_m_phone(a_m_phone);
            libraryRepository.save(data);

    }


}
