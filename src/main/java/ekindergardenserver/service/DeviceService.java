package ekindergardenserver.service;

import ekindergardenserver.domain.Device;
import ekindergardenserver.model.ResponseStatuses;
import ekindergardenserver.repo.ChildRepo;
import ekindergardenserver.repo.DeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {
    private final DeviceRepo deviceRepo;
    private final ChildRepo childRepo;

    @Autowired
    public DeviceService(DeviceRepo deviceRepo, ChildRepo childRepo) {
        this.deviceRepo = deviceRepo;
        this.childRepo = childRepo;
    }

    public ResponseEntity auth(String appId, int pin) {
        Device auth = deviceRepo.findByAppIdAndPin(appId, pin);
        if (auth != null) {
            return ResponseEntity.ok(childRepo.findByDevice(auth));
        } else
            return ResponseEntity.badRequest().build();
    }
}
