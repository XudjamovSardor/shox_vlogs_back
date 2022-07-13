package uz.shoxvlogs.shoxvlogs.config;

import org.springframework.stereotype.Component;
import uz.shoxvlogs.shoxvlogs.intity.Lavozim;
import uz.shoxvlogs.shoxvlogs.intity.User;
import uz.shoxvlogs.shoxvlogs.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitDB {
    private final UserRepository userRepository;

    public InitDB(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void DB() {
        if(!userRepository.findByLogin("admin123").isPresent()){
            User u = new User();
            u.setIsm("Administrator");
            u.setAktiv(true);
            Set<Lavozim> lavozims = new HashSet<>();
            lavozims.add(Lavozim.ADMIN);
            u.setLavozimlar(lavozims);
            u.setLogin("admin123");
            u.setParol("admin123");
            userRepository.save(u);
        }
    }
}
