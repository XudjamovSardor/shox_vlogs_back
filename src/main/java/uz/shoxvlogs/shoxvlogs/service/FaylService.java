package uz.shoxvlogs.shoxvlogs.service;

import org.springframework.stereotype.Service;
import uz.shoxvlogs.shoxvlogs.intity.Fayl;
import uz.shoxvlogs.shoxvlogs.repository.FaylRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FaylService {

    private final FaylRepository faylRepository;


    public FaylService(FaylRepository faylRepository) {
        this.faylRepository = faylRepository;
    }

    public List<Fayl> getALl() {
        return faylRepository.findAll();
    }

    public Optional<Fayl> getById(Long id) {
        return faylRepository.findById(id);
    }

    public Fayl create(Fayl fayl) {
        if (fayl.getId() == null) return faylRepository.save(fayl);

        throw new RuntimeException("Id bulmasligi kerak");
    }

    public Fayl update(Fayl fayl) {
        if (fayl.getId() != null) return faylRepository.save(fayl);
        throw new RuntimeException("Id bulishi kerak");
    }

    public void delete(Fayl fayl) {
        faylRepository.delete(fayl);
    }

}
