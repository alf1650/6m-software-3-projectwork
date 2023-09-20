package sg.edu.ntu.simplecrm;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import sg.edu.ntu.simplecrm.entity.player;
import sg.edu.ntu.simplecrm.repository.playerRepository;

@Component
public class DataLoader {

  private PlayerRepository playerRepository;

  public DataLoader(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }

  @PostConstruct
  public void loadData() {
    // Clear the db
    playerRepository.deleteAll();

    // load data
    // playerRepository.save(new Player("Bruce", "Banner"));
    // playerRepository.save(new Player("Peter", "Parker"));
    // playerRepository.save(new Player("Stephen", "Strange"));

    // Define player using builder pattern
    Player kai = player.builder().firstName("Kai").lastName("Havertz").footballClub("Arsenal")
        .age("24").playerPosition("Forward").nationality("German").build();
    Player erling = player.builder().firstName("Erling").lastName("Haaland").footballClub("Manchester City")
        .age("23").playerPosition("Forward").nationality("Norweigan").build();
    Player evan = player.builder().firstName("Evan").lastName("Ferguson").footballClub("Brighton & Hove Albion")
        .age("18").playerPosition("Forward").nationality("Irish").build();
    
        // Save player to db
    playerRepository.save(kai);
    playerRepository.save(erling);
    playerRepository.save(evan);

  }

}
