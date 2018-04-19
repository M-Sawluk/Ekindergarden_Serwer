package ekindergardenserver;

import ekindergardenserver.domain.Child;
import ekindergardenserver.repo.ChildRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Main {
	@Autowired
	private ChildRepo childRepo;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@PostConstruct
	private void fillDataBase() {
		childRepo.save(new Child(112233L, "michal@gmail.com", "Michal", "Sawluk"));
	}
}
