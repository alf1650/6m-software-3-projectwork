package sg.edu.ntu.simplecrm.service;

import java.util.List;

import sg.edu.ntu.simplecrm.entity.KeyStatistics;

public interface KeyStatisticsService {

  KeyStatistics saveKeyStatistics(KeyStatistics KeyStatistics);

  KeyStatistics getKeyStatistics(Long id);

  List<KeyStatistics> getAllKeyStatisticss();

  KeyStatistics updateKeyStatistics(Long id, KeyStatistics KeyStatistics);

  void deleteKeyStatistics(Long id);

}
