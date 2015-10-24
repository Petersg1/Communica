import perso.Communica;
import perso.CommunicaTCPClient;
import perso.CommunicaTCPServer;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Created by pierre on 21/10/15.
 */
public class HelloCommunicaClient {


    public static void main(String args[]) throws IOException {
        String adr;
        int port;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Adresse serveur : ");
        adr = scanner.nextLine();
        System.out.print("Port utilisé : ");
        port = scanner.nextInt();

        try {
            System.out.println("*En attente de connexion*");
            CommunicaTCPClient communicaTCPClient = new CommunicaTCPClient(InetAddress.getByName(adr), port);
            System.out.println("-> Demarrage du chat");
            Communica a = new Communica(communicaTCPClient.getBufferedReader(), communicaTCPClient.getBufferedWriter());
        } catch (Exception e) {
            System.out.println("Erreur de connexion. Port réservé ?");
        }

    }
}
