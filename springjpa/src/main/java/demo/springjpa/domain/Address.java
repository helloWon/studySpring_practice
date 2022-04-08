package demo.springjpa.domain;

import javax.persistence.Embeddable;

import lombok.Getter;

@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    public Address(String city, String street, String zipcode) { // FIXME: 꼭 protected로 제어접근자를 설정해야하나?
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
