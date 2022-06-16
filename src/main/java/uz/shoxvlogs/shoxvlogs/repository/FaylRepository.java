package uz.shoxvlogs.shoxvlogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.shoxvlogs.shoxvlogs.intity.Fayl;

@Repository
public interface FaylRepository extends JpaRepository<Fayl, Long> {
}