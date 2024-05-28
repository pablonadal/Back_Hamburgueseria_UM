package solo.Hamburgueseria.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import solo.Hamburgueseria.entity.Hamburguesa;
import solo.Hamburgueseria.service.HamburguesaService;

import java.util.List;

@RestController
@RequestMapping("/api/hamburguesas")
public class HamburguesaController {
    @Autowired
    private HamburguesaService service;

    @GetMapping
    public List<Hamburguesa> getAllHamburguesas() {
        return service.getAllHamburguesas();
    }

    @PostMapping
    public Hamburguesa createHamburguesa(@RequestBody Hamburguesa hamburguesa) {
        return service.saveHamburguesa(hamburguesa);
    }

    @PutMapping("/{id}")
    public Hamburguesa updateHamburguesa(@PathVariable Long id, @RequestBody Hamburguesa hamburguesa) {
        return service.updateHamburguesa(id, hamburguesa);
    }

    @DeleteMapping("/{id}")
    public void deleteHamburguesa(@PathVariable Long id) {
        service.deleteHamburguesa(id);
    }
}
