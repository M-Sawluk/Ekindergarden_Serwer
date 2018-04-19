package ekindergardenserver.repo;

import ekindergardenserver.domain.Child;
import ekindergardenserver.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepo extends JpaRepository<Child, Long> {

    Child findByPeselAndNameAndSurnameAndEmail(long pesel, String name, String surname, String email);

    Child findByDevice(Device device);
}
