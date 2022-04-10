package demo.springjpa;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import demo.springjpa.domain.Address;
import demo.springjpa.domain.Member;
import demo.springjpa.domain.item.Book;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TestDataInit {
    private final InitService initService;

    @PostConstruct // Transactional과 같이 사용 불가 https://sorjfkrh5078.tistory.com/311
    public void init() {
        initService.init();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    private static class InitService {

        private final EntityManager em;

        public void init() {
            createItem();
            createMember();
        }

        private void createItem() {
            Book book = new Book();
            book.setName("Book1");
            book.setPrice(10000);
            book.setStockQuantity(10);
            book.setAuthor("글쟁이");
            book.setIsbn("1111");
            em.persist(book);
        }

        private void createMember() {
            Member member = new Member();
            member.setName("Member1");
            member.setAddress(new Address("분당", "정자대로", "11111"));
            em.persist(member);
        }
    }
}
