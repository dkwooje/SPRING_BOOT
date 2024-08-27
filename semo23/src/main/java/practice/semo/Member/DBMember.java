package practice.semo.Member;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import practice.semo.sales.Sales;

import java.util.ArrayList;
import java.util.List;

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

    @ToString.Exclude
    @OneToMany(mappedBy = "member")
    private List<Sales> sales = new ArrayList<>();

}
