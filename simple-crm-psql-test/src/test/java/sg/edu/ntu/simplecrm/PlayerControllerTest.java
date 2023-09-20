package sg.edu.ntu.simplecrm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import sg.edu.ntu.simplecrm.entity.Player;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @DisplayName("Get player by Id")
  @Test
  public void getPlayerByIdTest() throws Exception {
    // Step 1: Build a request
    RequestBuilder request = MockMvcRequestBuilders.get("/player/1");

    // Step 2: Perform the request, get the response and assert
    mockMvc.perform(request)
        // Assert that the status code is 200 OK
        .andExpect(status().isOk())
        // Assert the content is JSON
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        // Assert that the id returned is 1
        .andExpect(jsonPath("$.id").value(1));

  }

  @Test
  public void getAllPlayerTest() throws Exception {
    // Step 1: Build a GET request to /players
    RequestBuilder request = MockMvcRequestBuilders.get("/player");

    // Step 2: Perform the request, get the response and assert
    mockMvc.perform(request)
        // Assert that the status code is 200 OK
        .andExpect(status().isOk())
        // Assert that the content is JSON
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        // Assert that the size of the response is 3
        .andExpect(jsonPath("$.size()").value(3));
  }

  @Test
  public void validPlayerCreationTest() throws Exception {
    // Step 1: Create a player object
    Player player = player.builder().firstName("Kai").lastName("Havertz").footballClub("Arsenal")
    .age("24").playerPosition("Forward").nationality("German").build();

    // Step 2: Convert the Java objec to JSON using ObjectMapper
    String newPlayerAsJSON = objectMapper.writeValueAsString(player);

    // Step 3: Build the request
    RequestBuilder request = MockMvcRequestBuilders.post("/player")
        .contentType(MediaType.APPLICATION_JSON)
        .content(newPlayerAsJSON);

    // Step 4: Perform the request, get response and assert
    mockMvc.perform(request)
        .andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id").value(4))
        .andExpect(jsonPath("$.firstName").value("Kai"))
        .andExpect(jsonPath("$.lastName").value("Havertz"));
  }

  @Test
  public void invalidPlayerCreationTest() throws Exception {
    // Step 1: Create a player with invalid fields
    Player invalidPlayer = player.builder().firstName("Kai").lastName("Havertz").footballClub("Arsenal")
    .age("24").playerPosition("Forward").nationality("German").build();

    // Step 2: Convert the Java object to JSON
    String invalidPlayerAsJSON = objectMapper.writeValueAsString(invalidPlayer);

    // Step 3: Build the request
    RequestBuilder request = MockMvcRequestBuilders.post("/player")
        .contentType(MediaType.APPLICATION_JSON)
        .content(invalidPlayerAsJSON);

    // Step 4: Perform the request and get the response and assert
    mockMvc.perform(request)
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }

}
