package sg.edu.ntu.simplecrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.ntu.simplecrm.entity.player;


public interface PlayerRepository extends JpaRepository<Player, Long> {
  List<Player> findByFirstName(String firstName);
}