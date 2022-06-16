package uz.shoxvlogs.shoxvlogs.service;

import org.springframework.stereotype.Service;
import uz.shoxvlogs.shoxvlogs.intity.ShowBiznes;
import uz.shoxvlogs.shoxvlogs.repository.ShowBiznesRepository;

import java.util.List;

@Service
public class ShowBiznesSerivce {

    private final ShowBiznesRepository showBiznesRepository;


    public ShowBiznesSerivce(ShowBiznesRepository showBiznesRepository) {
        this.showBiznesRepository = showBiznesRepository;
    }

    public List<ShowBiznes> getAll() {
        return showBiznesRepository.findAll();
    }

    public ShowBiznes create(ShowBiznes showBiznes) {
        if (showBiznes.getId() == null) return showBiznesRepository.save(showBiznes);
        throw new RuntimeException("Id bulmasligi kerak");
    }

    public ShowBiznes update(ShowBiznes showBiznes) {
        if (showBiznes.getId() != null) return showBiznesRepository.save(showBiznes);
        throw new RuntimeException("Id bulishi kerak");
    }

    public void deleteById(Long id) {
        showBiznesRepository.deleteById(id);
    }
}
