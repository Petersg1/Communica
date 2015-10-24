import perso.*;

import java.io.*;
import java.util.Scanner;

/**
 * Created by pierre on 12/10/15.
 */
public class HelloCommunicaServer {

    public static void main(String args[]) throws IOException {

        int port;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Port d'écoute : ");
        port = scanner.nextInt();


        System.out.println("*En attente de connexion*");
        CommunicaTCPServer communicaTCPServer = new CommunicaTCPServer(port);
        System.out.println("-> Demarrage du chat");
        Communica a = new Communica(communicaTCPServer.getBufferedReader(), communicaTCPServer.getBufferedWriter());

    }
}
