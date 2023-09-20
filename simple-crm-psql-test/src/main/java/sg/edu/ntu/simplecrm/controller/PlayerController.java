package sg.edu.ntu.simplecrm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sg.edu.ntu.simplecrm.entity.Player;
import sg.edu.ntu.simplecrm.entity.KeyStatistics;
import sg.edu.ntu.simplecrm.service.PlayerService;

@RestController
@RequestMapping("/api/players")
@AllArgsConstructor
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    // CREATE
    @PostMapping("/create")
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    // READ (GET ONE)
    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Player not found"));
    }

   // UPDATE
    @PutMapping("{id}")
   public Player updatePlayer(@PathVariable Long id, @RequestBody Player player) {
     return playerRepository.updatePlayer(id, player);
   }

   // DELETE
   @DeleteMapping("{id}")
   public Player deletePlayer(@PathVariable Long id) {
     playerRepository.deletePlayer(id);
     return playerRepository.deletePlayer(HttpStatus.NO_CONTENT);
   }

}
