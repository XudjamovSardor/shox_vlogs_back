package uz.shoxvlogs.shoxvlogs.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.shoxvlogs.shoxvlogs.intity.Autho;

@Repository
public interface AuthoRepository extends JpaRepository<Autho, Long> {
    boolean existsByCode(String example);
}
