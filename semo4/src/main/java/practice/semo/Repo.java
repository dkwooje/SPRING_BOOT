package practice.semo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<Item,Integer> {
}
