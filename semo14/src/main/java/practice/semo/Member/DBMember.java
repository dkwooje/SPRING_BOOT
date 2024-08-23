package practice.semo.Member;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity

public class DBMember {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String displayName;
    private String password;
    @Column(unique = true)
    private String username;

}