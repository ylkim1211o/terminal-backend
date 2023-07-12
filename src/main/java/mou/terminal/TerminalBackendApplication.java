package mou.terminal;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;

@SpringBootApplication
public class TerminalBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TerminalBackendApplication.class, args);

	}
}
