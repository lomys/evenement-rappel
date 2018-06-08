package fr.softeam.evenementrappel;

import fr.softeam.evenementrappel.mail.EmailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EvenementRappelApplicationTests {

	@Autowired
	private EmailServiceImpl emailService;

	@Test
	public void contextLoads() {

	}

}
