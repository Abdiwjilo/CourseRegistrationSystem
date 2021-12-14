package miu.edu.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
@Data
public class Address {

    private String street;
    private String city;
    private String postalCode;
    private String state_province;
    private String country_region;
}
