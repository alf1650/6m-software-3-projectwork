package sg.edu.ntu.simplecrm.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

// import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "KeyStatistics")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class KeyStatistics {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Column(name ="goals")
  @Size(min = 0, max = 3, message = "Goals should be valid")
  private int goals;
  @Column(name ="assists")
  @Size(min = 0, max = 3, message = "Assists should be valid")
  private int assists;
  @Column(name = "opposition")
  private String opposition;
  @Column(name = "matchDate")
  @PastOrPresent(message = "Match date should not be in the future")
  private LocalDate matchDate;

   // @JsonBackReference
   @ManyToOne
   @JoinColumn(name = "player_id")
   private Player player;
 
 }