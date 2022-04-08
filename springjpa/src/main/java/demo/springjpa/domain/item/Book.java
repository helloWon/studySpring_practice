package demo.springjpa.domain.item;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("B")  // 기본값 클래스 이름
@Getter
@Setter
public class Book extends Item {
    private String author;
    private String isbn;
}
