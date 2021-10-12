package monitor.service;

import monitor.model.service.AssetsInfoServiceModel;
import monitor.model.service.UsersInfoServiceModel;

public interface MonitorService {

    UsersInfoServiceModel getTotalUsers();

    AssetsInfoServiceModel getTotalAssets(String currencyType);

}
