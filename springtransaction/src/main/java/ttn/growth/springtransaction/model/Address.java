package ttn.growth.springtransaction.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable {

    private int id;
    private String address;
    private String country;
}
