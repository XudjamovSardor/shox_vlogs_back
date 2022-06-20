package uz.shoxvlogs.shoxvlogs.controller;

import org.springframework.web.bind.annotation.*;
import uz.shoxvlogs.shoxvlogs.intity.Autho;
import uz.shoxvlogs.shoxvlogs.service.AuthoService;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("api/autho")
@CrossOrigin(maxAge = 3600)
public class AuthoController {

    private final AuthoService authoService;

    public AuthoController(AuthoService authoService) {
        this.authoService = authoService;
    }

    @GetMapping
    public List<Autho> getAll() {
        return authoService.get();
    }

    @GetMapping("/{code}")
    public Boolean validation(@PathVariable String code) {
        return authoService.validation(code);
    }

    @PostMapping
    public Autho create() {

        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[20];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));

        for(int i = 4; i< 20 ; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }

        Autho autho = new Autho();
        autho.setCode(String.valueOf(password));

        authoService.delete();

        return authoService.create(autho);
    }

    @DeleteMapping
    public void delete() {
        authoService.delete();
    }
}
