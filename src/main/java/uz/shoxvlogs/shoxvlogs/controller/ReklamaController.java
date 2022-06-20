package uz.shoxvlogs.shoxvlogs.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.shoxvlogs.shoxvlogs.intity.Reklama;
import uz.shoxvlogs.shoxvlogs.service.AuthoService;
import uz.shoxvlogs.shoxvlogs.service.ReklamaSerivce;

@RestController
@RequestMapping("api/reklama")
@CrossOrigin(maxAge = 3600, value = "*")
public class ReklamaController {

    private final ReklamaSerivce reklamaSerivce;
    private final AuthoService authoService;

    public ReklamaController(ReklamaSerivce reklamaSerivce, AuthoService authoService) {
        this.reklamaSerivce = reklamaSerivce;
        this.authoService = authoService;
    }

    @GetMapping
    public Page<Reklama> getAll(Pageable pageable) {
        return reklamaSerivce.getAll(pageable);
    }

    @PostMapping
    public Reklama create(@RequestBody Reklama yangilik) {
        return reklamaSerivce.create(yangilik);
    }

    @PutMapping
    public Reklama update(@RequestBody Reklama yangilik) {
        return reklamaSerivce.update(yangilik);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        reklamaSerivce.deleteById(id);
    }
}
