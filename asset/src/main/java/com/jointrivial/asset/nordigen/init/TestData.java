package com.jointrivial.asset.nordigen.init;

import com.jointrivial.asset.nordigen.api.NordigenAccountInfoAPI;
import com.jointrivial.asset.nordigen.config.ApplicationProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestData implements CommandLineRunner {

    private final NordigenAccountInfoAPI api;
    private final ApplicationProperties applicationProperties;

    public TestData(NordigenAccountInfoAPI api, ApplicationProperties applicationProperties) {
        this.api = api;
        this.applicationProperties = applicationProperties;
    }

    @Override
    public void run(String... args) throws Exception {
//        printSteps();

        // FIRST METHOD
//        System.out.println(api.createRequisition("Pesho", "PeshoReference", "https://assets.sainsburys-groceries.co.uk/gol/7866708/1/640x640.jpg", new ArrayList<>()));

        // SECOND METHOD
//        System.out.println(api.createBankAuthorizationLinkForRequisition("", "HSBC_HBUKGB4B"));

        // THIRD METHOD
//        System.out.println(api.getRequisitionById(""));


//        System.out.println(applicationProperties.setBaseUrl("someUrl"));
//        System.out.println(applicationProperties.getBaseUrl());

    }

    private void printSteps() {
        System.err.println("---------------------------------");
        System.err.println("1) RUN ONLY THE FIRST METHOD");
        System.err.println("2) SAVE THE ID  --->  PASS AS PARAMETER TO OTHER METHODS");
        System.err.println("3) RUN ONLY THE SECOND METHOD");
        System.err.println("4) FOLLOW THE LINK TO AUTHORISE");
        System.err.println("5) RUN ONLY THE THIRD METHOD");
        System.err.println("If you need to RE-DO, just change the 'reference_id' in the first method to a random value");
        System.err.printf("---------------------------------%n%n");
    }

    private void testMethods() {
//        System.out.println(api.getAllBanksForCountry("bg"));
//
//
//        System.out.println(api.createEndUserAgreement("pesho", "FIBANK_FINVBGSF", 50));
//        System.out.println(api.getEndUserAgreementById(""));
//        System.out.println(api.getAllEndUserAgreementsForUserByUserId("pesho"));
//        api.deleteEndUserAgreementById("");
//
//
//        System.out.println(api.createRequisition("pesho", "peshoRef", "https://assets.sainsburys-groceries.co.uk/gol/7866708/1/640x640.jpg", new ArrayList<>()));
//        System.out.println(api.getAllRequisitions());
//        System.out.println(api.createBankAuthorizationLinkForRequisition("4c8bf6ac-5e3d-4ba2-9e1c-6b8d1e2e51d2", "FIBANK_FINVBGSF"));
//        System.out.println(api.getRequisitionById(""));
//        api.deleteRequisitionById("");


//        System.out.println(api.getAccountMetadata(""));
//        System.out.println(api.getAccountBalances(""));
//        System.out.println(api.getAccountTransactions(""));
//        System.out.println(api.getAccountDetails(""));
    }
}
