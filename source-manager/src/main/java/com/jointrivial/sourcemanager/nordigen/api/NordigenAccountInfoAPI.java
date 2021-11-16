package com.jointrivial.sourcemanager.nordigen.api;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static com.jointrivial.sourcemanager.nordigen.constants.ApiURLs.*;

public class NordigenAccountInfoAPI extends BaseNordigen {

    // country's 2-digit code(bg, de, gb, ro....). There are some exceptions(gb == gbr, both work)
    public String getAllBanksForCountry(String country) throws IOException, InterruptedException {
        return baseGetHttpRequest(getBaseUrl() + GET_ALL_BANKS_FOR_COUNTRY_URL + country);
    }

    // this step could be skipped
    // by default history data is retrieved for the past 90 days
    public String createEndUserAgreement(String userId, String bankId, int maxHistoricalDays) throws URISyntaxException, IOException, InterruptedException {
        String bodyUrlEncodedString = String.format(
                "max_historical_days=%d&enduser_id=%s&aspsp_id=%s", maxHistoricalDays, userId, bankId);

        return basePostHttpRequest(getBaseUrl() + END_USER_AGREEMENT_URL, bodyUrlEncodedString, "application/x-www-form-urlencoded");
    }

    // 2 more parameters can be set in the URL:
    // - limit(the number of results to return per page)
    // - offset(the initial index from which to return the results)
    public String getAllEndUserAgreementsForUserByUserId(String id) throws IOException, InterruptedException {
        return baseGetHttpRequest(getBaseUrl() + ALL_END_USER_AGREEMENTS_BY_USER_ID_URL + id);
    }

    public String getEndUserAgreementById(String id) throws IOException, InterruptedException {
        return baseGetHttpRequest(getBaseUrl() + END_USER_AGREEMENT_URL + id + "/");
    }

    public void deleteEndUserAgreementById(String id) throws IOException, InterruptedException {
        baseDeleteHttpRequest(getBaseUrl() + END_USER_AGREEMENT_URL, id);
    }

    // language could be set in the body
    public String createRequisition(String userId, String referenceId, String redirectUrl, @NotNull List<String> EuaIDs) throws IOException, InterruptedException {
        String bodyJsonString = String.format("{\n" +
                        "\"enduser_id\": \"%s\",\n" +
                        "\"reference\": \"%s\",\n" +
                        "\"redirect\": \"%s\"",
                userId, referenceId, redirectUrl);

        if (!EuaIDs.isEmpty()) {
            StringBuilder sb = new StringBuilder(bodyJsonString);

            sb.append(",\n\"agreements\": [\n");

            EuaIDs.forEach(id -> sb.append(String.format("\"%s\", ", id)));

            sb.replace(sb.length() - 2, sb.length(), "\n]");

            bodyJsonString = sb.toString();
        }

        return basePostHttpRequest(getBaseUrl() + REQUISITION_URL, bodyJsonString + "\n}", "application/json");
    }

    public void deleteRequisitionById(String id) throws IOException, InterruptedException {
        baseDeleteHttpRequest(getBaseUrl() + REQUISITION_URL, id);
    }

    public String getRequisitionById(String id) throws IOException, InterruptedException {
        System.err.println("IN THE \"accounts\" IN THAT RESPONSE ---> ARE THERE ANY ACCOUNT_IDS?");
        return baseGetHttpRequest(getBaseUrl() + REQUISITION_URL + id + "/");
    }

    // 2 more parameters can be set in the URL:
    // - limit(the number of results to return per page)
    // - offset(the initial index from which to return the results)
    public String getAllRequisitions() throws IOException, InterruptedException {
        return baseGetHttpRequest(getBaseUrl() + REQUISITION_URL);
    }

    public String createBankAuthorizationLinkForRequisition(String requisitionId, String bankId) throws IOException, InterruptedException {
        String bodyUrlEncodedString = String.format(
                "aspsp_id=%s", bankId);

        String linkUrl = getBaseUrl() + REQUISITION_URL + requisitionId + "/links/";

        return basePostHttpRequest(linkUrl, bodyUrlEncodedString, "application/x-www-form-urlencoded");
    }
}
