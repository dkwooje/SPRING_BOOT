package practice.semo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@ToString
@Getter
@Setter
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Integer id;
        @Column(nullable = false, unique = true)
        private String title;
        private Integer price;



}
