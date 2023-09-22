package sg.ntu.edu.simpleplayerstats.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.AllArgsConstructor;
import sg.ntu.edu.simpleplayerstats.entity.Player;
import sg.ntu.edu.simpleplayerstats.entity.Statistic;
import sg.ntu.edu.simpleplayerstats.exception.PlayerNotFoundException;
import sg.ntu.edu.simpleplayerstats.repository.PlayerRepository;
import sg.ntu.edu.simpleplayerstats.repository.StatisticRepository;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private static final Logger logger = LoggerFactory.getLogger(PlayerServiceImpl.class);

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private StatisticRepository statisticRepository;

    // Create
    @Override
    public Player createPlayer(Player player) {
        logger.info("Creating a new player: {}", player.toString());
        return playerRepository.save(player);
    }

    // Get One
    @Override
    public Player getPlayer(Long id) {
        logger.info("Fetching player with ID: {}", id);
        return playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException(id));
    }

    // Get All
    @Override
    public List<Player> getAllPlayers() {
        logger.info("Fetching all players");
        List<Player> allPlayers = playerRepository.findAll();
        return allPlayers;
    }

    // Update
    @Override
    public Player updatePlayer(Long id, Player player) {
        logger.info("Updating player with ID {}: {}", id, player.toString());
        Player playerToUpdate = playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException(id));

        playerToUpdate.setFirstName(player.getFirstName());
        playerToUpdate.setLastName(player.getLastName());
        playerToUpdate.setFootballclub(player.getFootballclub());
        playerToUpdate.setPlayerposition(player.getPlayerposition());
        playerToUpdate.setAge(player.getAge());
        playerToUpdate.setNationality(player.getNationality());
        return playerRepository.save(playerToUpdate);
    }

    // Delete
    @Override
    public void deletePlayer(Long id) {
        logger.info("Deleting player with ID: {}", id);
        playerRepository.deleteById(id);
    }

    @Override
    public Statistic addStatisticToPlayer(Long id, Statistic statistic) {
        logger.info("Adding statistic to player with ID {}: {}", id, statistic.toString());
        Player selectedPlayer = playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException(id));
        
        statistic.setPlayer(selectedPlayer);
        return statisticRepository.save(statistic);
    }

    @Override
    public List<Player> searchPlayers(String firstName) {
        logger.info("Searching for players with first name: {}", firstName);
        List<Player> foundPlayers = playerRepository.findByFirstName(firstName);
        return foundPlayers;
    }


}
