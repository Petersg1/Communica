package perso;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by pierre on 24/10/15.
 */
public class CommunicaTCPListener extends Thread {
    private Communica communica;
    private BufferedReader reader;

    public CommunicaTCPListener(Communica communica, BufferedReader reader) {
        this.communica = communica;
        this.reader = reader;
    }

    public void run() {
        while (true) {
            try {
                String messageToPrint = this.reader.readLine();
                try {
                    if (!messageToPrint.isEmpty())
                        this.communica.printReceivedMessage(messageToPrint);
                } catch (NullPointerException e) {
                    Thread.currentThread().interrupt();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
