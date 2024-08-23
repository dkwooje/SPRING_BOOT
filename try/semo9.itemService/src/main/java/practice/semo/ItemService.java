package practice.semo;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor

public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItem(String title, Integer price){
        Item item = new Item();
        item.setPrice(price);
        item.setTitle(title);
        itemRepository.save(item);

    }
}

//의존성 주입
//  @Autowired
//  public ItemService(ItemRepository itemRepository){
//      this.itemRepository = itemRepository;
//  }

//  @Autowired
// private  ItemRepository itemRepository;


  /*  @PostMapping("/add")
    String add(String title, Integer price){
        Item item = new Item();
        item.setPrice(price);
        item.setTitle(title);
        itemRepository.save(item);
        return "redirect:/list";
    }
*/