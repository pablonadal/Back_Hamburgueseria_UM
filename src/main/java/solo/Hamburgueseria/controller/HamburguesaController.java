package solo.Hamburgueseria.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{id}")
    public ResponseEntity<Hamburguesa> getHamburguesaById(@PathVariable Long id) {
        Hamburguesa hamburguesa = service.findById(id);
        if (hamburguesa == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hamburguesa, HttpStatus.OK);
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
