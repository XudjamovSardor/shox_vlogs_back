package uz.shoxvlogs.shoxvlogs.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.shoxvlogs.shoxvlogs.intity.OnlineYangilik;

@Repository
public interface OnlineYangilikRepository extends JpaRepository<OnlineYangilik, Long> {
    Page<OnlineYangilik> findAllByBoshSahifagaAndTur(Boolean boshSahifaga, String tur, Pageable pageable);

}