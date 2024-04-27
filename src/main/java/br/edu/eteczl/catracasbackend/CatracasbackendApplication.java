package br.edu.eteczl.catracasbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CatracasbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatracasbackendApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
	@GetMapping("/ra")
    public String ra(@RequestParam int ra) {
        int[] allowedRAs = {24101, 24115}; 

        for (int allowedRA : allowedRAs) {
            if (ra == allowedRA) {
                return "O RA " + ra + " é válido";
            }
        }
        return "O RA " + ra + " não é válido";
    }
	@GetMapping("/*")
    public String fallback() {
        return String.format("404 Página não encontrada");
    }
	
}
