package ekindergardenserver.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Child {
    @Id
    @GeneratedValue
    private long id;
    private long pesel;
    private String email;
    private String name;
    private String surname;
    @ManyToOne
    private Device device;

    public Child(long pesel, String email, String name, String surname) {
        this.pesel = pesel;
        this.email = email;
        this.name = name;
        this.surname = surname;
    }

    public Child() {}

    public void setDevice(Device device) {
        this.device = device;
    }
}
