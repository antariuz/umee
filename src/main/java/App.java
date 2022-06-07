import model.Wallet;
import service.WalletService;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        List<Wallet> walletList = new WalletService().getWalletsInfo("ME");
        for (Wallet wallet: walletList) {
            System.out.println(wallet);
        }

    }
}
