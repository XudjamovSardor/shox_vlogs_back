package uz.shoxvlogs.shoxvlogs.controller;

import org.springframework.web.bind.annotation.*;
import uz.shoxvlogs.shoxvlogs.intity.OnlineYangilik;
import uz.shoxvlogs.shoxvlogs.service.OnlineYangilikService;

import java.util.List;

@RestController
@RequestMapping("api/onlinenew")
@CrossOrigin(maxAge = 3600)
public class OnlineYangilikController {

    private final OnlineYangilikService onlineYangilikService;

    public OnlineYangilikController(OnlineYangilikService onlineYangilikService) {
        this.onlineYangilikService = onlineYangilikService;
    }


    @GetMapping
    public List<OnlineYangilik> getAll() {
        return onlineYangilikService.getAll();
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
