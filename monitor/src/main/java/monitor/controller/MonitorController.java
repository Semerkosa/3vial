package monitor.controller;

import monitor.model.view.AssetsInfoViewModel;
import monitor.model.view.UsersInfoViewModel;
import monitor.service.MonitorService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/monitor")
public class MonitorController {

    private final ModelMapper modelMapper;
    private final MonitorService monitorService;

    public MonitorController(ModelMapper modelMapper, MonitorService monitorService) {
        this.modelMapper = modelMapper;
        this.monitorService = monitorService;
    }

    @GetMapping("/total_users")
    public ResponseEntity<UsersInfoViewModel> getTotalUsers() {

        return new ResponseEntity<UsersInfoViewModel>(
                modelMapper.map(monitorService.getTotalUsers(), UsersInfoViewModel.class),
                HttpStatus.OK);
    }

    @GetMapping("/total_assets")
    public ResponseEntity<AssetsInfoViewModel> getTotalAssets(
            @RequestParam(name = "currency", defaultValue = "GBP") String currencyType) {

        return new ResponseEntity<AssetsInfoViewModel>(
                modelMapper.map(monitorService.getTotalAssets(currencyType), AssetsInfoViewModel.class),
                HttpStatus.OK);
    }
}
