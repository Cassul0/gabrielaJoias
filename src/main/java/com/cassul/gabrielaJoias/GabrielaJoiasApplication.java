package com.cassul.gabrielaJoias;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class GabrielaJoiasApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(GabrielaJoiasApplication.class, args);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("admin"));	
	}

	@Override
	public void run(String... args) throws Exception {
	
	}
	
	
}
