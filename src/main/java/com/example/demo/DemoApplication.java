package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@SpringBootApplication

@RestController
public class DemoApplication {

	int count=0;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);


	}

	@GetMapping("/thanks")
	public GreateResponse thanks(
			@RequestParam(value="name",required=false) String name
	)
	{
		



		System.out.println("Hi");
		String message= name==null ||name.isBlank() ? "Hello Unknown" :"Hello "+name;

		GreateResponse response =new GreateResponse(message
				,List.of("Java","Python","Javascript"),
				new Person("Amol"));

		System.out.println(count++);


	return response;

	};


//record ThanksResponse(String t){};
	record Person(String name){}
	record GreateResponse(
			String greet,
			List<String> ProgrammingLanguages, Person person
	){}

}

class Thanks{

	final private String thanks;

	Thanks(String thanks) {
		this.thanks = thanks;
	}



//	public String getThanks() {
//		return thanks;
//	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Thanks thanks1 = (Thanks) o;
		return Objects.equals(thanks, thanks1.thanks);
	}

	@Override
	public int hashCode() {
		return Objects.hash(thanks);
	}

	@Override
	public String toString() {
		return "Thanks{" +
				"thanks='" + thanks + '\'' +
				'}';
	}
}
