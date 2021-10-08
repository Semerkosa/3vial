package monitor.model.service;

import java.math.BigDecimal;

public class AssetsInfoServiceModel {

    private String currencyType;
    private BigDecimal amount;

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
