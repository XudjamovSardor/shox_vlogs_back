package uz.shoxvlogs.shoxvlogs.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import uz.shoxvlogs.shoxvlogs.intity.Yangilik;
import uz.shoxvlogs.shoxvlogs.service.AuthoService;
import uz.shoxvlogs.shoxvlogs.service.YangilikService;

@RestController
@RequestMapping("api/new")
@CrossOrigin(maxAge = 3600, value = "*")
public class YangilikController {

    private final YangilikService yangilikService;
    private final AuthoService authoService;
    ;

    public YangilikController(YangilikService yangilikService, AuthoService authoService) {
        this.yangilikService = yangilikService;
        this.authoService = authoService;
    }


    @GetMapping
    public Page<Yangilik> getAll(Pageable pageable) {
        return yangilikService.getAll(pageable);
    }

    @PostMapping
    public Yangilik create(@RequestBody Yangilik yangilik, @RequestParam("code") String code, HttpRequest request) {
        System.out.println(request);
        if (authoService.validation(code)) return yangilikService.create(yangilik);
        return null;
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
