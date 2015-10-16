import perso.*;

import java.io.*;

/**
 * Created by pierre on 12/10/15.
 */
public class HelloCommunica {

    public static void main(String args[]) {
        File a2b = new File("a2b.txt");
        File b2a = new File("b2a.txt");
        FileWriter aWriter = null;
        FileReader aReader = null;
        FileWriter bWriter = null;
        FileReader bReader = null;
        try {
            aWriter = new FileWriter(a2b);
            bWriter = new FileWriter(b2a);
            aReader = new FileReader(b2a);
            bReader = new FileReader(a2b);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        Communica a = new Communica(new BufferedReader(aReader), new BufferedWriter(aWriter));
        Communica b = new Communica(new BufferedReader(bReader),new BufferedWriter(bWriter));
    }
}
