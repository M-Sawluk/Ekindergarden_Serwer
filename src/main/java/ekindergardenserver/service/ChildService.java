package ekindergardenserver.service;

import ekindergardenserver.domain.Child;
import ekindergardenserver.domain.Device;
import ekindergardenserver.repo.ChildRepo;
import ekindergardenserver.repo.DeviceRepo;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildService {
    private final ChildRepo childRepo;
    private final DeviceRepo deviceRepo;

    @Autowired
    public ChildService(ChildRepo childRepo, DeviceRepo deviceRepo) {
        this.childRepo = childRepo;
        this.deviceRepo = deviceRepo;
    }

    public String verifyChild(long pesel, String name, String surname, String emial, int pin) {
        Child child = childRepo.findByPeselAndNameAndSurnameAndEmail(pesel, name, surname, emial);
        if(child != null) {
            String appId = RandomStringUtils.random(20, true, true);
            Device device = new Device(appId, pin);
            deviceRepo.save(device);
            child.setDevice(device);
            childRepo.save(child);
            return appId;
        } else {

         return "";
        }
    }
}
