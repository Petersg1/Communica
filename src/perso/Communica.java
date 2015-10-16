package perso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * Created by pierre on 12/10/15.
 */

public class Communica extends JFrame implements ActionListener {

    /* Attributes */
    private BufferedWriter writer;
    private BufferedReader reader;
    private JButton bReceive;
    private JButton bSend;
    private JLabel Imessrec;
    private JLabel Imesssend;
    private JLabel Ipseudo;
    private JTextArea textRec;
    private JTextField textToSend;
    private JTextField pseudo;
    private JScrollPane scrollTextRec;


    /*Constructeurs*/
    public Communica(BufferedReader reader, BufferedWriter writer) {
        this.initComponents(reader, writer);
    }


    /*methodes*/
    private void  initComponents(BufferedReader reader, BufferedWriter writer) {

        //initialisation des attributs
        this.reader = reader;
        this.writer = writer;
        this.bReceive = new JButton("receive");
        this.bSend = new JButton("send");
        this.Imessrec = new JLabel("received message");
        this.Imesssend = new JLabel("message to send");
        this.Ipseudo = new JLabel("Votre pseudo :");
        this.textRec = new JTextArea("", 4,4);
        this.textToSend = new JTextField("Ecrivez votre texte ici");
        this.pseudo = new JTextField("");
        this.scrollTextRec = new JScrollPane(textRec);

        //Mise en place des listeners
        this.bReceive.addActionListener(this);
        this.bSend.addActionListener(this);
        this.pseudo.addActionListener(this);
        this.textToSend.addActionListener(this);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);


        //Mise en place du format de la fenetre
        this.setLayout(new GridLayout(4,2));
        this.textRec.setEditable(false);
        this.textRec.setAutoscrolls(true);


        //Insertion des objects graphiques
        this.add(Ipseudo);
        this.add(pseudo);
        this.add(Imesssend);
        this.add(textToSend);
        this.add(bSend);
        this.add(bReceive);
        this.add(Imessrec);
        this.add(scrollTextRec);

        //Compile la partie graphique et l'affiche
        this.pack();
        this.setVisible(true);
    }

    //Envoie le message
    private void sendMessage() {
        System.out.println("Envoi du message");
        try {
            String newMessage=this.pseudo.getText() + " : " + this.textToSend.getText();
            this.writer.write(newMessage);
            this.writer.newLine();
            this.writer.flush();
            this.textToSend.setText(""); //Efface le texte écrit par l'utilisateur
            this.textRec.append(newMessage + "\n");
        } catch (IOException e1) {e1.printStackTrace();}
    }

    //Action faite si objet cliqué
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bSend || e.getSource() == textToSend) { //Envoie message
            this.sendMessage();

        } else if (e.getSource() == bReceive) { //Recoie message
            System.out.println("Oh, j'ai reçu du text");
            try {
                this.textRec.append(this.reader.readLine()+"\n");
            } catch (IOException e1) {e1.printStackTrace();}

        } else if (e.getSource() == pseudo) { //Pseudo rentré
            textToSend.requestFocus();
            System.out.print("coucou");

        } else {
            System.out.println("Autre bouton : " + e.getSource());
        }
    }
}
