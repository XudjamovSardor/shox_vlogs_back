package uz.shoxvlogs.shoxvlogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.shoxvlogs.shoxvlogs.intity.ShowBiznes;

@Repository
public interface ShowBiznesRepository extends JpaRepository<ShowBiznes, Long> {
}