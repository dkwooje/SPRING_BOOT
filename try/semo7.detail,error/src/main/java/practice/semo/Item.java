package practice.semo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // 알아서 ID를 1씩 증가후 저장
    private Integer id;
    private String title;
    private Integer price;



}
//new Item().title
