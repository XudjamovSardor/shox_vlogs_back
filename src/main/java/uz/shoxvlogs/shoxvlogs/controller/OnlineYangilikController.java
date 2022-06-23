package uz.shoxvlogs.shoxvlogs.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.shoxvlogs.shoxvlogs.intity.OnlineYangilik;
import uz.shoxvlogs.shoxvlogs.service.AuthoService;
import uz.shoxvlogs.shoxvlogs.service.OnlineYangilikService;


import java.util.List;


@RestController
@RequestMapping("api/onlinenew")
@CrossOrigin(maxAge = 3600, value = "*")
public class OnlineYangilikController {

    private final OnlineYangilikService onlineYangilikService;

    public OnlineYangilikController(OnlineYangilikService onlineYangilikService) {
        this.onlineYangilikService = onlineYangilikService;
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
    public OnlineYangilik create(@RequestBody OnlineYangilik onlineYangilik, @RequestParam(value = "code", required = false) String code) {
        if (AuthoService.validation(code)) return onlineYangilikService.create(onlineYangilik);
        return null;
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
