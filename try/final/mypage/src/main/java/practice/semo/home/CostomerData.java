package practice.semo.home;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class CostomerData {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    @Column(nullable = false,unique = true)
    private String a_m_id;
    private String a_m_pw;
    private String a_m_name;
    private String a_m_gender;
    private String a_m_mail;
    private String a_m_phone;



}
