package practice.semo.home;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<CostomerData,Long> {
}
