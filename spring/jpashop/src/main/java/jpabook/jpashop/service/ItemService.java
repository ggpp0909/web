package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;


    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }


//    @Transactional
//    void update(Item itemParam) { //itemParam: 파리미터로 넘어온 준영속 상태의 엔티티
//        Item findItem = em.find(Item.class, itemParam.getId()); //같은 엔티티를 조회한다.
//        findItem.setPrice(itemParam.getPrice()); //데이터를 수정한다.
//    }



    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
