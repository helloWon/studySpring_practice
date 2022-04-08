package demo.springjpa.domain;

import javax.persistence.Entity;

@Entity
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
