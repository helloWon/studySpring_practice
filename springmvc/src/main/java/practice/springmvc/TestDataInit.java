package practice.springmvc;

import practice.springmvc.domain.item.Item;
import practice.springmvc.domain.item.ItemRepository;
import practice.springmvc.domain.member.Member;
import practice.springmvc.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final ItemRepository itemRepository = ItemRepository.getInstance();
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @PostConstruct
    public void init() {
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));

        memberRepository.save(new Member("userA", 10));
        memberRepository.save(new Member("userB", 11));
    }

}