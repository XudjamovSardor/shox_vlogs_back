package uz.shoxvlogs.shoxvlogs.service;

import org.springframework.stereotype.Service;
import uz.shoxvlogs.shoxvlogs.intity.Autho;
import uz.shoxvlogs.shoxvlogs.repository.AuthoRepository;

import java.util.List;

@Service
public class AuthoService {

    private static AuthoRepository authoRepository;

    public AuthoService(AuthoRepository authoRepository) {
        AuthoService.authoRepository = authoRepository;
    }


    public List<Autho> get() {
        return authoRepository.findAll();
    }

    public Autho create(Autho auth) {
        return authoRepository.save(auth);
    }

    public void delete() {
        authoRepository.deleteAll();
    }

    public static Boolean validation(String code) {
        return authoRepository.existsByCode(code);  
    }
}
