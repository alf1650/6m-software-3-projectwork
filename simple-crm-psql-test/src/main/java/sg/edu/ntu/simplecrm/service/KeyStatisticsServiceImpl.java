package sg.edu.ntu.simplecrm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sg.edu.ntu.simplecrm.entity.KeyStatistics;
import sg.edu.ntu.simplecrm.exception.KeyStatisticsNotFoundException;
import sg.edu.ntu.simplecrm.repository.KeyStatisticsRepository;

@Service
@AllArgsConstructor
public class KeyStatisticsServiceImpl implements KeyStatisticsService {

  private KeyStatisticsRepository KeyStatisticsRepository;

  @Override
  public KeyStatistics saveKeyStatistics(KeyStatistics KeyStatistics) {
    return KeyStatisticsRepository.save(KeyStatistics);
  }

  @Override
  public KeyStatistics getKeyStatistics(Long id) {
    return KeyStatisticsRepository.findById(id).orElseThrow(() -> new KeyStatisticsNotFoundException(id));
  }

  @Override
  public List<KeyStatistics> getAllKeyStatisticss() {
    return KeyStatisticsRepository.findAll();
  }

  @Override
  public KeyStatistics updateKeyStatistics(Long id, KeyStatistics KeyStatistics) {
    // Load the KeyStatistics
    KeyStatistics KeyStatisticsToUpdate = KeyStatisticsRepository.findById(id)
        .orElseThrow(() -> new KeyStatisticsNotFoundException(id));
    KeyStatisticsToUpdate.setRemarks(KeyStatistics.getRemarks());
    KeyStatisticsToUpdate.setKeyStatisticsDate(KeyStatistics.getKeyStatisticsDate());
    return KeyStatisticsRepository.save(KeyStatisticsToUpdate);
  }

  @Override
  public void deleteKeyStatistics(Long id) {
    KeyStatisticsRepository.deleteById(id);
  }

}
