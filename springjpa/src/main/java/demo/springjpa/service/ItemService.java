package demo.springjpa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.springjpa.domain.item.Item;
import demo.springjpa.repository.ItemRepository;
import lombok.RequiredArgsConstructor;

// 여러 Repository를 사용하는 코드가 하나의 트랜잭션으로 처리가 되도록 함
@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor // 생성자 주입
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional // 준영속성: merge
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional // 준영속성: dirty checking
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        Item findItem = itemRepository.findOne(itemId);
        findItem.setPrice(price);
        findItem.setName(name);
        findItem.setStockQuantity(stockQuantity);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

}
