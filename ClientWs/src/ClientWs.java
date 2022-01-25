import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

import java.util.List;

public class ClientWs {
    public static void main(String[] args) {
        BanqueService stubWs = new BanqueWS().getBanqueServicePort();
        System.out.println(stubWs.conversionEuroToDh(100));
        Compte cpt = stubWs.getCompte(3l);
        System.out.println(cpt.getCode());
        List<Compte> compteList = stubWs.listComptes();
        compteList.forEach(c -> {
            System.out.println("-------------------------");
            System.out.println(c.getCode());
            System.out.println(c.getSolde());

        });
    }
}
