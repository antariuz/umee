package service;

import API.API;
import API.APIImpl;
import API.model.AvailableBalanceResponse;
import API.model.PendingStakingRewardBalanceResponse;
import API.model.StakedBalanceResponse;
import model.Wallet;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class WalletService {

    private final API api = new APIImpl();
    private final Integer U = 1_000_000;

    private Double getAvailableBalance(String umeeAddress) throws Exception {
        AvailableBalanceResponse response = api.getAvailableBalanceResponse(umeeAddress).getInstanceOf(AvailableBalanceResponse.class);
        return response.getResult().isEmpty() ? 0 : (Double.parseDouble(response.getResult().get(0).getAmount()) / U);
    }

    private Double getStakedBalance(String umeeAddress) throws Exception {
        StakedBalanceResponse response = api.getStakedBalanceResponse(umeeAddress).getInstanceOf(StakedBalanceResponse.class);
        return response.getResult().isEmpty() ? 0 : (Double.parseDouble(response.getResult().get(0).getBalance().getAmount()) / U);
    }

    private Double getPendingStakingRewardBalance(String umeeAddress) throws Exception {
        PendingStakingRewardBalanceResponse response = api.getPendingStakingRewardBalanceResponse(umeeAddress).getInstanceOf((PendingStakingRewardBalanceResponse.class));
        return response.getResult().getTotal().isEmpty() ? 0 : (Double.parseDouble(response.getResult().getTotal().get(0).getAmount()) / U);
    }

    public Wallet getWalletInfo(String walletName, String umeeAddress) throws Exception {
        Wallet wallet = new Wallet();
        wallet.setName(walletName);
        wallet.setAddress(umeeAddress);
        wallet.setAvailableBalance(getAvailableBalance(umeeAddress));
        wallet.setStakedBalance(getStakedBalance(umeeAddress));
        wallet.setPendingStakingRewardBalance(getPendingStakingRewardBalance(umeeAddress));
        return wallet;
    }

    public List<Wallet> getWalletsInfo(String filePath) throws Exception {
        List<Wallet> wallets = new ArrayList<>();
        for (String line : Files.readAllLines(new File("src/main/resources/" + filePath).toPath())) {
            String[] splitLine = line.split(";");
            Wallet wallet = getWalletInfo(splitLine[0], splitLine[1]);
            wallets.add(wallet);
        }
        return wallets;
    }

}
