package uz.shoxvlogs.shoxvlogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.shoxvlogs.shoxvlogs.intity.Yangilik;

import java.util.Optional;

@Repository
public interface YangilikRepository extends JpaRepository<Yangilik, Long> {
    Optional<Yangilik> findById(Long id);
}
