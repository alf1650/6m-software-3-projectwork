package sg.edu.ntu.simplecrm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

// import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "player")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Player {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Column(name = "first_name")
  @NotBlank(message = "First name is mandatory")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "footballClub")
  @footballClub(message = "Club should be valid")
  private String footballClub;
  @Column(name = "age")
  @Size(min = 2, max = 2, message = "Age should be valid")
  private String age;
  @Column(name = "playerPosition")
  private String playerPosition;
  @Column(name = "year_of_birth")
  @Max(value = 2005, message = "Year of birth should not be later than 2005")
  @Min(value = 1940, message = "Year of birth should not be earlier than 1940")
  private int yearOfBirth;
  @Column(name = "nationality")
  private String nationality;

  @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
  private List<KeyStatistics> statistics = new ArrayList<>();

  // getters and setters
}

  public Player(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  // Lombok Builder: https://devwithus.com/lombok-builder-annotation/
  @Builder
  public Player(String firstName, String lastName, String footballClub, String age, String playerPosition,
      int yearOfBirth, String nationality) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.footballClub = footballClub;
    this.age = age;
    this.playerPosition = playerPosition;
    this.yearOfBirth = yearOfBirth;
    this.nationality = nationality;
  }
