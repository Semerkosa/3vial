package com.jointrivial.portfolio;

import com.jointrivial.portfolio.model.service.balance.BalanceAmountServiceModel;
import com.jointrivial.portfolio.model.service.balance.BalanceRootServiceModel;
import com.jointrivial.portfolio.model.service.balance.BalanceServiceModel;
import com.jointrivial.portfolio.model.service.balance.UserBalancesServiceModel;
import com.jointrivial.portfolio.model.view.balance.BalanceRootViewModel;
import com.jointrivial.portfolio.model.view.balance.BalanceViewModel;
import com.jointrivial.portfolio.model.view.balance.UserBalancesViewModel;
import com.jointrivial.portfolio.service.ReferenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.List;

@SpringBootTest
class PortfolioApplicationTests {
    @Autowired
    private ReferenceService referenceService;

    @Test
    void testConnectionPortfolioReferenceShouldReturnCorrectData() throws URISyntaxException, IOException, InterruptedException {
        BalanceAmountServiceModel balanceAmountServiceModel1 = new BalanceAmountServiceModel();
        balanceAmountServiceModel1.setAmount(BigDecimal.TEN);
        balanceAmountServiceModel1.setCurrency("EUR");
        BalanceAmountServiceModel balanceAmountServiceModel2 = new BalanceAmountServiceModel();
        balanceAmountServiceModel2.setAmount(BigDecimal.ONE);
        balanceAmountServiceModel2.setCurrency("GBP");
        BalanceServiceModel balanceServiceModel1 = new BalanceServiceModel();
        balanceServiceModel1.setBalanceAmount(balanceAmountServiceModel1);
        BalanceServiceModel balanceServiceModel2 = new BalanceServiceModel();
        balanceServiceModel2.setBalanceAmount(balanceAmountServiceModel2);
        BalanceRootServiceModel balanceRootServiceModel = new BalanceRootServiceModel();
        balanceRootServiceModel.setBalances(List.of(balanceServiceModel1, balanceServiceModel2));
        UserBalancesServiceModel userBalancesServiceModel = new UserBalancesServiceModel();
        userBalancesServiceModel.setUserBalances(List.of(balanceRootServiceModel));
        UserBalancesViewModel viewModel = referenceService.calculateAmountInWantedCurrency("BGN", userBalancesServiceModel);
        for (BalanceRootViewModel userBalance : viewModel.getUserBalances()) {
            for (BalanceViewModel balance : userBalance.getBalances()) {
                assert balance.getBalanceAmount().getAmountInWantedCurrency().compareTo(balance.getBalanceAmount().getAmount()) > 0;
            }
        }
    }

}
