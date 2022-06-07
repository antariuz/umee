package API.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StakedBalanceResponse {

    private String height;
    private List<Result> result;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {

        private Delegation delegation;
        private Balance balance;

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Delegation {
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Balance {
            private String denom;
            private String amount;
        }

    }

}
