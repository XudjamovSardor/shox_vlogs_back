package uz.shoxvlogs.shoxvlogs.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.shoxvlogs.shoxvlogs.intity.Yangilik;
import uz.shoxvlogs.shoxvlogs.service.YangilikService;

import java.util.List;

@RestController
@RequestMapping("api/new")
@CrossOrigin(maxAge = 3600, value = "*")
public class YangilikController {

    private final YangilikService yangilikService;

    public YangilikController(YangilikService yangilikService) {
        this.yangilikService = yangilikService;
    }


    @GetMapping
    public Page<Yangilik> getAll(Pageable pageable) {
        return yangilikService.getAll(pageable);
    }

    @PostMapping
    public Yangilik create(@RequestBody Yangilik yangilik) {
        return yangilikService.create(yangilik);
    }

    @PutMapping
    public Yangilik update(@RequestBody Yangilik yangilik) {
        return yangilikService.update(yangilik);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        yangilikService.deleteById(id);
    }
}
