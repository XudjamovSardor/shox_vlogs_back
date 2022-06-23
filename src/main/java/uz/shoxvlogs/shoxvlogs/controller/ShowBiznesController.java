package uz.shoxvlogs.shoxvlogs.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.shoxvlogs.shoxvlogs.intity.ShowBiznes;
import uz.shoxvlogs.shoxvlogs.service.AuthoService;
import uz.shoxvlogs.shoxvlogs.service.ShowBiznesSerivce;


@RestController
@RequestMapping("api/starnew")
@CrossOrigin(maxAge = 3600)
public class ShowBiznesController {

    private final ShowBiznesSerivce showBiznesSerivce;
    public ShowBiznesController(ShowBiznesSerivce showBiznesSerivce) {
        this.showBiznesSerivce = showBiznesSerivce;
    }

    @GetMapping
    public Page<ShowBiznes> getAll(Pageable pageable) {
        return showBiznesSerivce.getAll(pageable);
    }

    @PostMapping
    public ShowBiznes create(@RequestBody ShowBiznes showBiznes, @RequestParam(value = "code", required = false) String code) {
        if (AuthoService.validation(code)) return showBiznesSerivce.create(showBiznes);
        return null;
    }

    @PutMapping
    public ShowBiznes update(@RequestBody ShowBiznes showBiznes) {
        return showBiznesSerivce.update(showBiznes);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        showBiznesSerivce.deleteById(id);
    }
}
