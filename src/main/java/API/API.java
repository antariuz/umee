package API;

import util.httpclient.AppHttpResponse;

public interface API {
    AppHttpResponse getAvailableBalanceResponse(String umeeAddress) throws Exception;

    AppHttpResponse getStakedBalanceResponse(String umeeAddress) throws Exception;

    AppHttpResponse getPendingStakingRewardBalanceResponse(String umeeAddress) throws Exception;
}
