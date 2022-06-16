package uz.shoxvlogs.shoxvlogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.shoxvlogs.shoxvlogs.intity.Yangilik;

@Repository
public interface YangilikRepository extends JpaRepository<Yangilik, Long> {
}
