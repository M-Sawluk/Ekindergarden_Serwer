package ekindergardenserver.controller;

import ekindergardenserver.model.AuthenticationResponse;
import ekindergardenserver.model.ResponseStatuses;
import ekindergardenserver.service.ChildService;
import ekindergardenserver.service.DeviceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthenticationController {
    @Autowired
    private ChildService childService;
    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "/authenticate/{pesel}/{name}/{surname}/{email}/{pin}")
    public ResponseEntity authenticate(@PathVariable long pesel, @PathVariable String name, @PathVariable String surname,
                                       @PathVariable String email, @PathVariable int pin) {
        String appId = childService.verifyChild(pesel, name, surname, email, pin);
        if (StringUtils.isNotBlank(appId))
            return ResponseEntity.ok(new AuthenticationResponse(appId, ResponseStatuses.OK));
        else
            return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/authorize/{appId}/{pin}")
    public ResponseEntity authorize(@PathVariable String appId, @PathVariable int pin) {
        return deviceService.auth(appId, pin);
    }
}
