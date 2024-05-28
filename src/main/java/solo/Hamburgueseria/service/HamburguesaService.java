package solo.Hamburgueseria.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solo.Hamburgueseria.entity.Hamburguesa;
import solo.Hamburgueseria.repository.HamburguesaRepository;

import java.util.List;

@Service
public class HamburguesaService {
    @Autowired
    private HamburguesaRepository repository;

    public List<Hamburguesa> getAllHamburguesas() {
        return repository.findAll();
    }

    public Hamburguesa saveHamburguesa(Hamburguesa hamburguesa) {
        return repository.save(hamburguesa);
    }

    public Hamburguesa updateHamburguesa(Long id, Hamburguesa hamburguesa) {
        if (repository.existsById(id)) {
            hamburguesa.setId(id);
            return repository.save(hamburguesa);
        }
        return null;
    }

    public void deleteHamburguesa(Long id) {
        repository.deleteById(id);
    }
}
