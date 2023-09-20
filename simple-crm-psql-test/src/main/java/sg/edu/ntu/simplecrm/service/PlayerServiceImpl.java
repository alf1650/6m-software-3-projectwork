package sg.edu.ntu.simplecrm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sg.edu.ntu.simplecrm.entity.player;
import sg.edu.ntu.simplecrm.entity.KeyStatistics;
import sg.edu.ntu.simplecrm.exception.playerNotFoundException;
import sg.edu.ntu.simplecrm.repository.playerRepository;
import sg.edu.ntu.simplecrm.repository.KeyStatisticsRepository;

@Service
@AllArgsConstructor
public class playerServiceImpl implements playerService {

  private playerRepository playerRepository;
  private KeyStatisticsRepository KeyStatisticsRepository;

  // Create
  @Override
  public player createplayer(player player) {
    // return player;
    return playerRepository.save(player);
  }

  // Get One
  @Override
  public player getplayer(Long id) {

    return playerRepository.findById(id).orElseThrow(() -> new playerNotFoundException(id));
  }

  // Get All
  @Override
  public List<player> getAllplayers() {
    List<player> allplayers = playerRepository.findAll();
    return allplayers;
  }

  // Update
  @Override
  public player updateplayer(Long id, player player) {

    // Retrieve player from DB
    player playerToUpdate = playerRepository.findById(id).orElseThrow(() -> new playerNotFoundException(id));

    // Update the fields
    playerToUpdate.setFirstName(player.getFirstName());
    playerToUpdate.setLastName(player.getLastName());
    playerToUpdate.setEmail(player.getEmail());
    playerToUpdate.setContactNo(player.getContactNo());
    playerToUpdate.setJobTitle(player.getJobTitle());
    playerToUpdate.setYearOfBirth(player.getYearOfBirth());
    return playerRepository.save(playerToUpdate);
  }

  // Delete
  @Override
  public void deleteplayer(Long id) {
    playerRepository.deleteById(id);
  }

  @Override
  public KeyStatistics addKeyStatisticsToplayer(Long id, KeyStatistics KeyStatistics) {
    // Retrieve player
    player selectedplayer = playerRepository.findById(id).orElseThrow(() -> new playerNotFoundException(id));

    // add the player to the KeyStatistics
    KeyStatistics.setplayer(selectedplayer);
    return KeyStatisticsRepository.save(KeyStatistics);

  }

  @Override
  public List<player> searchplayers(String firstName) {
    List<player> foundplayers = playerRepository.findByFirstName(firstName);
    return foundplayers;

  }

}