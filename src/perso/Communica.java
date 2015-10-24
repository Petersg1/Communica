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
    //private JButton bReceive;
    private JButton bSend;
    //private JLabel Imessrec;
    //private JLabel Imesssend;
    //private JLabel Ipseudo;
    private JTextArea textRec;
    private JTextField textToSend;
    private JTextField pseudo;
    //private JScrollPane scrollTextRec;
    //private CommunicaTCPListener communicaTCPListener;
    private CommunicaTCPSender communicaTCPSender;


    /*Constructeurs*/
    public Communica(BufferedReader reader, BufferedWriter writer) throws IOException {
        this.initComponents(reader, writer);
    }


    /*methodes*/
    private void  initComponents(BufferedReader reader, BufferedWriter writer) throws IOException {

        //initialisation des attributs
        CommunicaTCPListener communicaTCPListener = new CommunicaTCPListener(this, reader);
        this.communicaTCPSender = new CommunicaTCPSender(writer);
        this.bSend = new JButton("Send");
       // JLabel Imessrec = new JLabel("received message");
        JLabel Imesssend = new JLabel("message to send");
        JLabel Ipseudo = new JLabel("Votre pseudo :");
        this.textRec = new JTextArea("");
        this.textToSend = new JTextField("Ecrivez votre texte ici");
        this.pseudo = new JTextField("");
        JScrollPane scrollTextRec = new JScrollPane(textRec);

        //Mise en place des listeners
        this.bSend.addActionListener(this);
        this.pseudo.addActionListener(this);
        this.textToSend.addActionListener(this);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        communicaTCPListener.start();



        //Mise en place du format de la fenetre
        this.setLayout(new GridLayout(3,2));


        this.textRec.setEditable(false);
        this.textRec.setAutoscrolls(true);


        //Insertion des objects graphiques
        this.add(Ipseudo);
        this.add(pseudo);
        this.add(scrollTextRec); // C'est plus scrolalble, je ne sais pas pk :/
        this.add(textRec); // TO DO : L'AFFICHER SUR TOUTE LA LONGUEUR
        this.add(textToSend);
        this.add(bSend);

        //Compile la partie graphique et l'affiche
        this.pack();
        this.setVisible(true);
    }

    //Envoie le message
    private void sendMessage() {
        System.out.println("Envoi du message");
        String newMessage=this.pseudo.getText() + " : " + this.textToSend.getText();
        this.communicaTCPSender.sendMessage(newMessage);
        this.textToSend.setText(""); //Efface le texte écrit par l'utilisateur
        this.textRec.append(newMessage + "\n");
    }

    public void printReceivedMessage(String messageToPrint) throws IOException {
        this.textRec.append(messageToPrint + "\n");
    }

    //Action faite si objet cliqué
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bSend || e.getSource() == textToSend) { //Envoie message
            this.sendMessage();

        } else if (e.getSource() == pseudo) { //Pseudo rentré
            textToSend.requestFocus();
            System.out.print("coucou");

        } else {
            System.out.println("Autre bouton : " + e.getSource());
        }
    }
}
