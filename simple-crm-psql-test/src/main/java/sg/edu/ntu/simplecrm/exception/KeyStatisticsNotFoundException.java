package sg.edu.ntu.simplecrm.exception;

public class KeyStatisticsNotFoundException extends RuntimeException {
  public KeyStatisticsNotFoundException(Long id) {
    super("Could not find key statistics of player " + id);
  }

}
