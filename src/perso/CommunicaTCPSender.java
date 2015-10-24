package perso;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by pierre on 24/10/15.
 */
public class CommunicaTCPSender {

    private BufferedWriter writer;

    public CommunicaTCPSender(BufferedWriter writer){
        this.writer = writer;
    }

    public void sendMessage(String newMessage) {
        try {
            this.writer.write(newMessage);
            this.writer.newLine();
            this.writer.flush();
        } catch (IOException e) {
            System.out.println("Erreur lors de l'envoi.");
        }
    }


}
