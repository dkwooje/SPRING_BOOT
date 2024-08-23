package practice.semo.item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Integer> {

    Page<Item> findPageBy(Pageable page);//파라미터!!!!
    // Slice<Item> findPageBy(Pageable page);//사용가능

    List<Item> findAllBytitleContains(String title);


    //full text index
    @Query(value = "select * from item where match(title) against(?1) ", nativeQuery = true)
    List<Item> rawQuery1(String text);


}
//rawQuery1(3);
//rawQuery1(3);