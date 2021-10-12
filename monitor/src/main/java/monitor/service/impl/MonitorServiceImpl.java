package monitor.service.impl;

import monitor.model.service.AssetsInfoServiceModel;
import monitor.model.service.UsersInfoServiceModel;
import monitor.service.MonitorService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MonitorServiceImpl implements MonitorService {


    @Override
    public UsersInfoServiceModel getTotalUsers() {

        // Temporary code used for testing since currently there is no service to reach
        // for the actual user info.
        UsersInfoServiceModel usersInfo = new UsersInfoServiceModel();
        usersInfo.setTotalCount(100);

        return usersInfo;
    }

    @Override
    public AssetsInfoServiceModel getTotalAssets(String currencyType) {

        // Temporary code used for testing since currently there is no service to reach
        // for the actual asset info.
        AssetsInfoServiceModel assetsInfo = new AssetsInfoServiceModel();
        assetsInfo.setAmount(new BigDecimal("100.255"));
        assetsInfo.setCurrencyType(currencyType);

        return assetsInfo;
    }
}
