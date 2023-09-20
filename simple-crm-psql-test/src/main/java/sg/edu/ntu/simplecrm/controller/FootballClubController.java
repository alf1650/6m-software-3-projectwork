package sg.edu.ntu.simplecrm.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sg.edu.ntu.simplecrm.entity.KeyStatistics;
import sg.edu.ntu.simplecrm.service.KeyStatisticsService;

@RestController
@RequestMapping("/api/football-clubs")
@AllArgsConstructor
public class FootballClubController {
    @Autowired
    private FootballClubRepository clubRepository;

    // Create
    @PostMapping("/create")
    public FootballClub createClub(@RequestBody FootballClub club) {
        return clubRepository.save(club);
    }

    // Read one
    @GetMapping("/{id}")
    public FootballClub getClubById(@PathVariable Long id) {
        return clubRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Club not found"));
    }

    // Update
    @PutMapping("/update/{id}")
    public FootballClub updateClub(@PathVariable Long id, @RequestBody FootballClub updatedClub) {
     return clubRepository.update(updatedClub);
   }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClub(@PathVariable Long id) {
     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }

}
