package isis.projet.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.modelmapper.ModelMapper;
import java.sql.SQLException;
import org.h2.tools.Server;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
		// Permet d'injecter un ModelMapper dans les classes qui en ont besoin (@autowired)
	ModelMapper modelMapper() {
		return new ModelMapper();
	}


	// Optionnel : Démarre un serveur H2 en mode TCP
	// Permet d'accéder à la base de données H2 depuis un client externe (comme DBeaver ou IntelliJ IDEA)
	// URL de connexion : jdbc:h2:tcp://localhost:9092/mem:testdb
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server h2Server() throws SQLException {
		return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
	}
}
