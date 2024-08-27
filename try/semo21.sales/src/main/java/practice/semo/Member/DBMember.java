package practice.semo.Member;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class DBMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long  id;

    @Column(unique = true)
    private String username;
    private String displayName;
    private String password;
}