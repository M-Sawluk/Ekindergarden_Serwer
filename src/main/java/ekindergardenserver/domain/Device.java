package ekindergardenserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Device {
    @Id
    @GeneratedValue
    private long id;
    private String appId;
    private int pin;

    public Device(String appId, int pin) {
        this.appId = appId;
        this.pin = pin;
    }

    public Device() {}
}
