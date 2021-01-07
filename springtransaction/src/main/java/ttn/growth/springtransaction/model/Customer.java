package ttn.growth.springtransaction.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Customer implements Serializable {
    private int id;
    private String name;
    private Address address;

}
