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
    @ManyToOne(fetch = FetchType.LAZY) //FetchType.EAGER를 넣으면 "이거 필요없어도 다른 테이블 항상 가져와주세요" 라는 뜻이고
    @JoinColumn(                          // FetchType.LAZY를 넣으면 "게으르게 필요할 때만 가져와주세요"
            name = "member_id",
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)
    ) //제약조건 자동으로 걸지마시오
    private DBMember member;// foreign key
    //private Long memberId;

    @CreationTimestamp
    private LocalDateTime created;
}