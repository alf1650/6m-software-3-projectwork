package sg.edu.ntu.simplecrm.service;

import java.util.List;

import sg.edu.ntu.simplecrm.entity.Player;
import sg.edu.ntu.simplecrm.entity.KeyStatistics;

public interface playerService {
  player createplayer(player player);

  player getplayer(Long id);

  List<player> getAllplayers();

  player updateplayer(Long id, player player);

  void deleteplayer(Long id);

  KeyStatistics addKeyStatisticsToplayer(Long id, KeyStatistics KeyStatistics);

  List<player> searchplayers(String firstName);

}
