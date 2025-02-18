package isis.projet.backend.service;

import isis.projet.backend.dao.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    private final CountryRepository countryDao;

    public CountryService(CountryRepository countryDao) {
        this.countryDao = countryDao;
    }

    @Transactional
    public long combienDePays() {
        return countryDao.count();
    }
}
