package com.fs.applicinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fs.applicinema.service.ICinemaInitService;

@SpringBootApplication
public class ApplicinemaApplication implements CommandLineRunner {
@Autowired
	private ICinemaInitService cineservice;
	public static void main(String[] args) {
		SpringApplication.run(ApplicinemaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		cineservice.initvilles();
		cineservice.initcinemas();
		cineservice.initsalles();
		cineservice.initplaces();
		cineservice.initseances();
		cineservice.initcategories();
		cineservice.initfilms();
		cineservice.initprojections();
		cineservice.inittickets();
	}

}
