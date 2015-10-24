package perso;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by pierre on 12/10/15.
 */
public class CommunicaTCPClient {

    /* Attributes */
    private Socket socketClient;

    /*Constructeur */
    public CommunicaTCPClient(InetAddress adr, int port) throws IOException {

        try {
            this.socketClient = new Socket(adr,port); // adresse et port de destination
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /* Methodes */
    public BufferedReader getBufferedReader() throws IOException {
        return (new BufferedReader(new InputStreamReader(this.socketClient.getInputStream())));
    }

    public BufferedWriter getBufferedWriter() throws IOException {
        return (new BufferedWriter(new OutputStreamWriter(this.socketClient.getOutputStream())));
    }


}
