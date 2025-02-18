package isis.projet.backend.controller;

import isis.projet.backend.service.CountryService;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import java.util.Map;

@RestController
@RequestMapping("/rest")
@Slf4j
public class SimpleController {
    private final CountryService countryService;

    public SimpleController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/hello")
    public Map<String, String> sayHello() {
        log.info("Service Hello World");
        return Map.of("message", "Hello, World !");
    }

    @PutMapping("/combienDePays")
    public Map<String, Long> combienDePays() {
        log.info("Service combienDePays");
        // On renverra un objet JSON de la forme {"combien": 123}
        return Map.of("combien", countryService.combienDePays());
    }
}


