package uz.shoxvlogs.shoxvlogs.service;

import org.springframework.stereotype.Service;
import uz.shoxvlogs.shoxvlogs.intity.OnlineYangilik;
import uz.shoxvlogs.shoxvlogs.repository.OnlineYangilikRepository;

import java.util.List;

@Service
public class OnlineYangilikService {

    private final OnlineYangilikRepository onlineYangilikRepository;


    public OnlineYangilikService(OnlineYangilikRepository onlineYangilikRepository) {
        this.onlineYangilikRepository = onlineYangilikRepository;
    }

    public List<OnlineYangilik> getAll() {
        return onlineYangilikRepository.findAll();
    }

    public OnlineYangilik create(OnlineYangilik onlineYangilik) {
        if (onlineYangilik.getId() == null) return onlineYangilikRepository.save(onlineYangilik);
        throw new RuntimeException("Id bulmasligi kerak");
    }

    public OnlineYangilik update(OnlineYangilik onlineYangilik) {
        if (onlineYangilik.getId() != null) return onlineYangilikRepository.save(onlineYangilik);
        throw new RuntimeException("Id bulishi kerak");
    }

    public void deleteById(Long id) {
        onlineYangilikRepository.deleteById(id);
    }
}
