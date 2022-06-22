package uz.shoxvlogs.shoxvlogs.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.shoxvlogs.shoxvlogs.intity.Yangilik;
import uz.shoxvlogs.shoxvlogs.repository.YangilikRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class YangilikService {

    private final YangilikRepository yangilikRepository;

    public YangilikService(YangilikRepository yangilikRepository) {
        this.yangilikRepository = yangilikRepository;
    }

    public Page<Yangilik> getAll(Pageable pageable) {
        return yangilikRepository.findAll(pageable);
    }
    public Optional<Yangilik> getId(Long id) {
        return yangilikRepository.findById(id);
    }

    public Yangilik create(Yangilik yangilik) {
        if (yangilik.getId() == null) {
            yangilik.setDate(LocalDate.now());
            return yangilikRepository.save(yangilik);
        };
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
