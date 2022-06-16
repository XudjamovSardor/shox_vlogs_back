package uz.shoxvlogs.shoxvlogs.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.shoxvlogs.shoxvlogs.intity.Reklama;
import uz.shoxvlogs.shoxvlogs.repository.ReklamaRepository;

@Service
public class ReklamaSerivce {

    private final ReklamaRepository reklamaRepository;

    public ReklamaSerivce(ReklamaRepository reklamaRepository) {
        this.reklamaRepository = reklamaRepository;
    }


    public Page<Reklama> getAll(Pageable pageable) {
        return reklamaRepository.findAll(pageable);
    }

    public Reklama create(Reklama reklama) {
        if (reklama.getId() == null) return reklamaRepository.save(reklama);
        throw new RuntimeException("Id bulmasligi kerak");
    }

    public Reklama update(Reklama reklama) {
        if (reklama.getId() != null) return reklamaRepository.save(reklama);
        throw new RuntimeException("Id bulishi kerak");
    }

    public void deleteById(Long id) {
        reklamaRepository.deleteById(id);
    }
}
