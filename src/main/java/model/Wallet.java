package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {

    private String name;
    private String address;
    private Double availableBalance;
    private Double stakedBalance;
    private Double pendingStakingRewardBalance;

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.####");
        return name + ";" + address + ";" + df.format((availableBalance+stakedBalance)) + ";" + df.format(availableBalance) + ";" + df.format(stakedBalance) + ";" + df.format(pendingStakingRewardBalance);
    }
}
