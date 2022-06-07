package API.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PendingStakingRewardBalanceResponse {

    private String height;
    private Result result;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {

        private List<Rewards> rewards;
        private List<Total> total;

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Rewards {
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Total {
            private String denom;
            private String amount;
        }

    }

}
