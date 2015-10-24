package perso;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pierre on 12/10/15.
 */
public class CommunicaTCPServer {
    /* Attributes */
    private ServerSocket socketServer;
    private Socket clientSocket;


    /* Constructeurs */
    public CommunicaTCPServer(int port) throws IOException {
        try {
            this.socketServer = new ServerSocket(7000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.clientSocket=this.socketServer.accept();
    }

    /* Methodes */
    public BufferedReader getBufferedReader() throws IOException {
        return (new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream())));
    }

    public BufferedWriter getBufferedWriter() throws IOException {
        return (new BufferedWriter(new OutputStreamWriter(this.clientSocket.getOutputStream())));
    }

    public void run() {

    }

}
