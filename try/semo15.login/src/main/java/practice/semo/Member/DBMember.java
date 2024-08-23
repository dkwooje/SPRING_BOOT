package practice.semo.Member;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class DBMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer  id;

    @Column(unique = true)
    private String username;
    private String displayName;
    private String password;
}
