package ekindergardenserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AuthenticationResponse {
    private String data;
    private ResponseStatuses responseStatuses;

    public AuthenticationResponse(String data, ResponseStatuses responseStatuses) {
        this.data = data;
        this.responseStatuses = responseStatuses;
    }
}
