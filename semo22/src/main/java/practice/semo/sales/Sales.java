package practice.semo.sales;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;
import practice.semo.Member.DBMember;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ItemName;
    private Integer price;
    private Integer count;
    @ManyToOne
    @JoinColumn(
            name = "member_id",
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)
    ) //제약조건 자동으로 걸지마시오
    private DBMember member;// foreign key
    //private Long memberId;

    @CreationTimestamp
    private LocalDateTime created;
}