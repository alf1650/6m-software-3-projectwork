package sg.edu.ntu.simplecrm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import sg.edu.ntu.simplecrm.entity.player;
import sg.edu.ntu.simplecrm.exception.playerNotFoundException;
import sg.edu.ntu.simplecrm.repository.playerRepository;
import sg.edu.ntu.simplecrm.service.playerServiceImpl;

@SpringBootTest
public class playerServiceImplTest {

  @Mock
  private playerRepository playerRepository;

  @InjectMocks
  playerServiceImpl playerService;

  @Test
  public void createplayerTest() {

    // 1. SETUP / ARRANGE
    // player player = new player();
    Player kai = player.builder().firstName("Kai").lastName("Havertz").footballClub("Arsenal")
        .age("24").playerPosition("Forward").nationality("German").build();

    // Mock the save method of player repository
    when(playerRepository.save(player)).thenReturn(player);

    // 2. EXECUTE
    // Call the method that we want to test
    player savedplayer = playerService.createplayer(player);

    // 3. ASSERT
    assertEquals(player, savedplayer, "The saved player should be the same as the input player");

    // Also verify that the save method was called
    verify(playerRepository, times(1)).save(player);
  }

  @Test
  public void getplayerTest() {

    // 1. SETUP
    Player kai = player.builder().firstName("Kai").lastName("Havertz").footballClub("Arsenal")
    .age("24").playerPosition("Forward").nationality("German").build();

    Long playerId = 1L;

    when(playerRepository.findById(playerId)).thenReturn(Optional.of(player));

    // 2. EXECUTE
    player retrievedplayer = playerService.getplayer(playerId);

    // 3. ASSERT
    assertEquals(player, retrievedplayer, "The retrieved player should be the same as the input player");

  }

  @Test
  void getplayerNotFoundTest() {
    Long playerId = 1L;
    when(playerRepository.findById(playerId)).thenReturn(Optional.empty());

    // Assert
    assertThrows(playerNotFoundException.class, () -> playerService.getplayer(playerId));

  }

}
