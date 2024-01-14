package vttp2023.batch4.paf.day21;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vttp2023.batch4.paf.day21.Repo.BookRepo;
import vttp2023.batch4.paf.day21.Service.SummaryService;


@SpringBootApplication
public class Day21Application implements CommandLineRunner {

	@Autowired
	BookRepo repo;

	@Autowired
	SummaryService svc;
	public static void main(String[] args) {
		SpringApplication.run(Day21Application.class, args);
	}

	@Override
	public void run(String... args) {

		System.out.println("\n----------------------------");
		// this is to check if the shit works.
		//System.out.println(repo.findAllBooks() );

		System.out.println(svc.bookSummary(repo.findAllBooks()));
	}

}