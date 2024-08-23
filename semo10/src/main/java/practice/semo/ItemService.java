package practice.semo;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;


@Service
@RequiredArgsConstructor
public class ItemService {


    private final ItemRepository itemRepository;

    public void saveItem(String title, Integer price){
            Item item = new Item();
            item.setTitle(title);
            item.setPrice(price);
            itemRepository.save(item);
        }

    public void editItem(String title, Integer price,Integer id) {
        Item item = new Item();
        item.setId(id);
        item.setPrice(price);
        item.setTitle(title);
        itemRepository.save(item);
    }

}

