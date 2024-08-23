package practice.semo;

import jakarta.persistence.*;
import lombok.ToString;


@Entity
@ToString
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // 알아서 ID를 1씩 증가후 저장
    private Integer id;
    private String title;
    private Integer price;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

}
//new Item().title
