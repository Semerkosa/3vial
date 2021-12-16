package com.jointrivial.sourcemanager.yodlee.controller;

import com.jointrivial.sourcemanager.yodlee.model.request.LinkedProviderRequestModel;
import com.jointrivial.sourcemanager.yodlee.model.view.YodleeTokenViewModel;
import com.jointrivial.sourcemanager.yodlee.service.AccountService;
import com.jointrivial.sourcemanager.yodlee.service.YodleeConnectionIdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/yodlee")
public class YodleeController {

    private final YodleeConnectionIdService yodleeConnectionIdService;
    private final AccountService accountService;

    public YodleeController(YodleeConnectionIdService yodleeConnectionIdService, AccountService accountService) {
        this.yodleeConnectionIdService = yodleeConnectionIdService;
        this.accountService = accountService;
    }

    @GetMapping("/token")
    public ResponseEntity<YodleeTokenViewModel> yodleeConnect(@RequestHeader("User-Token") String userToken) throws InterruptedException, IOException, URISyntaxException {

        String userId = accountService.getUserIdByToken(userToken);

        YodleeTokenViewModel responseObject = new YodleeTokenViewModel();
        responseObject.setToken(yodleeConnectionIdService.getYodleeAuthenticationToken(userId));

        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    @PostMapping("/linked_accounts")
    public HttpStatus saveNewYodleeLinkedAccounts(@RequestHeader("User-Token") String userToken,
                                                  @RequestBody LinkedProviderRequestModel linkedProviderRequestModel) throws InterruptedException, IOException, URISyntaxException {

        String userId = accountService.getUserIdByToken(userToken);

        List<String> accountIds = yodleeConnectionIdService
                .getYodleeAccountsByRequestId(linkedProviderRequestModel.getRequestId(), userId,
                        linkedProviderRequestModel.getProviderAccountId());

        return accountService.saveAccounts(userToken,
                accountIds, linkedProviderRequestModel.getProviderName());
    }

}
