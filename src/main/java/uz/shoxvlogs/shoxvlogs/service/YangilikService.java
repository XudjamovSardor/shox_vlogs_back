package uz.shoxvlogs.shoxvlogs.service;

import org.springframework.stereotype.Service;
import uz.shoxvlogs.shoxvlogs.intity.Yangilik;
import uz.shoxvlogs.shoxvlogs.repository.YangilikRepository;

import java.util.List;

@Service
public class YangilikService {

    private final YangilikRepository yangilikRepository;

    public YangilikService(YangilikRepository yangilikRepository) {
        this.yangilikRepository = yangilikRepository;
    }

    public List<Yangilik> getAll() {
        return yangilikRepository.findAll();
    }

    public Yangilik create(Yangilik yangilik) {
        if (yangilik.getId() == null) return yangilikRepository.save(yangilik);
        throw new RuntimeException("Id bulmasligi kerak");
    }

    public Yangilik update(Yangilik yangilik) {
        if (yangilik.getId() != null) return yangilikRepository.save(yangilik);
        throw new RuntimeException("Id bulishi kerak");
    }

    public void deleteById(Long id) {
        yangilikRepository.deleteById(id);
    }
}
