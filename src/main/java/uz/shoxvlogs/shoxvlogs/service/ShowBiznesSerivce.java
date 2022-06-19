package uz.shoxvlogs.shoxvlogs.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.shoxvlogs.shoxvlogs.intity.ShowBiznes;
import uz.shoxvlogs.shoxvlogs.repository.ShowBiznesRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShowBiznesSerivce {

    private final ShowBiznesRepository showBiznesRepository;


    public ShowBiznesSerivce(ShowBiznesRepository showBiznesRepository) {
        this.showBiznesRepository = showBiznesRepository;
    }

    public Page<ShowBiznes> getAll(Pageable pageable) {
        return showBiznesRepository.findAll(pageable);
    }

    public ShowBiznes create(ShowBiznes showBiznes) {
        if (showBiznes.getId() == null) {
            showBiznes.setDate(LocalDate.now());
            return showBiznesRepository.save(showBiznes);
        }
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
