package API;

import org.apache.http.message.BasicHeader;
import util.httpclient.AppHttpGetRequest;
import util.httpclient.AppHttpResponse;

import java.util.Arrays;
import java.util.List;

public class APIImpl implements API {

    private final static List<BasicHeader> customHeaders = Arrays.asList(
            new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:47.0) Gecko/20100101 Firefox/47.0"),
            new BasicHeader("Accept", "*/*"),
            new BasicHeader("Content-Type", "application/json"));

    private final String API_URL = "https://api.blue.main.network.umee.cc";

    @Override
    public AppHttpResponse getAvailableBalanceResponse(String umeeAddress) throws Exception {
        return AppHttpGetRequest.newBuilder().setUrl(API_URL + "/bank/balances/" + umeeAddress).setHeaders(customHeaders).build().execute();
    }

    @Override
    public AppHttpResponse getStakedBalanceResponse(String umeeAddress) throws Exception {
        return AppHttpGetRequest.newBuilder().setUrl(API_URL + "/staking/delegators/" + umeeAddress + "/delegations").setHeaders(customHeaders).build().execute();
    }

    @Override
    public AppHttpResponse getPendingStakingRewardBalanceResponse(String umeeAddress) throws Exception {
        return AppHttpGetRequest.newBuilder().setUrl(API_URL + "/distribution/delegators/" + umeeAddress + "/rewards").setHeaders(customHeaders).build().execute();
    }
}
