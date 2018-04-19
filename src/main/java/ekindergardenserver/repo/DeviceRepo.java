package ekindergardenserver.repo;

import ekindergardenserver.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepo extends JpaRepository<Device, Long>{

    Device findByAppIdAndPin(String appId, int pin);
}
