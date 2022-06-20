package uz.shoxvlogs.shoxvlogs.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.shoxvlogs.shoxvlogs.intity.OnlineYangilik;
import uz.shoxvlogs.shoxvlogs.service.AuthoService;
import uz.shoxvlogs.shoxvlogs.service.OnlineYangilikService;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/onlinenew")
@CrossOrigin(maxAge = 3600, value = "*")
public class OnlineYangilikController {

    private final OnlineYangilikService onlineYangilikService;
    private final AuthoService authoService;

    public OnlineYangilikController(OnlineYangilikService onlineYangilikService, AuthoService authoService) {
        this.onlineYangilikService = onlineYangilikService;
        this.authoService = authoService;
    }



    @GetMapping
    public List<OnlineYangilik> getAll() {
        return onlineYangilikService.getAll();
    }


    @GetMapping("/{sahifa}")
    public Page<OnlineYangilik> getByBoshSahifa(@PathVariable Boolean sahifa, Pageable pageable, @RequestParam("type") String tur) {
        return onlineYangilikService.getByBoshSahifa(sahifa, tur, pageable);
    }
    @PostMapping
    public OnlineYangilik create(@RequestBody OnlineYangilik onlineYangilik) {
        return onlineYangilikService.create(onlineYangilik);
    }

    @PutMapping
    public OnlineYangilik update(@RequestBody OnlineYangilik onlineYangilik) {
        return onlineYangilikService.update(onlineYangilik);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        onlineYangilikService.deleteById(id);
    }
}
