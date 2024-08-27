package practice.semo.item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {

    Page<Item> findPageBy(Pageable page);//파라미터!!!!
    // Slice<Item> findPageBy(Pageable page);// 전체 페이지 갯수가 필요 없다면 사용가능
}
