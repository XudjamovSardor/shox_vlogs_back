package uz.shoxvlogs.shoxvlogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.shoxvlogs.shoxvlogs.intity.OnlineYangilik;
import uz.shoxvlogs.shoxvlogs.intity.Reklama;

@Repository
public interface ReklamaRepository extends JpaRepository<Reklama, Long> {
}