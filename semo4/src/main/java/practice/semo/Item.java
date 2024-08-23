package practice.semo;

import jakarta.persistence.*;
import lombok.ToString;


@Entity
@ToString
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // 알아서 ID를 1씩 증가후 저장
    public Integer id;
    @Column(nullable = false, unique = true) //not nullm unique
    // @Column(columnDefinition = "TEXT") //컬럼타입 강제 지정
    public String title;
    public Integer price; //컬럼용 변수는 int로 쓰지 않는다.
    //Long price;


}
//new Item().title
