package jp.winschool.spring.jobboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DuplicateKeyException;

import jp.winschool.spring.jobboard.service.AccountService;

@SpringBootApplication
public class JobboardApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JobboardApplication.class, args);
	}

	@Autowired(required = false)
	private AccountService accountService;

	public void run(String... args) throws Exception {
		if (accountService == null) {
			return;
		}
		
		String adminUsername = "admin";
		String adminPassword = "admin";

		try {
			accountService.createAdministratorAccount(adminUsername, adminPassword, true);
		} catch (DuplicateKeyException e) {
		}
	}

}
