package com.example.Agence.GUI;

import com.example.Agence.DTO.ReservationDTO;
import com.example.Agence.Data.AgenceData;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;

public class ClientWindows implements ActionListener {
    public JFrame frame;
    private JTextField textFieldNom;
    private JTextField textFieldPrenom;

    private String agence;
    private String password;
    private String id;
    private JTextField textFieldCarte;
    private JButton btnNewButton;
    HotelAgencyMain hotel;

    private RestTemplate resproxy;

    private String link;
    /**
     * Launch the application.
     */


    /**
     * Create the application.
     */
    public ClientWindows(String link, RestTemplate proxy, String agence, String password, String id, HotelAgencyMain hotel) {
        this.agence = agence;
        this.password = password;
        this.id = id;
        this.link=link;
        this.resproxy=proxy;
        this.hotel= hotel;
        initialize();
   }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 393, 450);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 381, 420);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lbTitle = new JLabel("HOTEL AGENCY");
        lbTitle.setFont(new Font("Arial", Font.PLAIN, 18));
        lbTitle.setBounds(26, 24, 328, 22);
        panel.add(lbTitle);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(123, 104, 238));
        panel_1.setBounds(26, 57, 195, 10);
        panel.add(panel_1);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(26, 88, 328, 234);
        panel.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNom = new JLabel("Nom");
        lblNom.setFont(new Font("Arial", Font.PLAIN, 12));
        lblNom.setBounds(10, 11, 308, 14);
        panel_2.add(lblNom);

        textFieldNom = new JTextField();
        textFieldNom.setBounds(20, 36, 201, 30);
        panel_2.add(textFieldNom);
        textFieldNom.setColumns(10);

        JLabel lblPrenom = new JLabel("Prenom");
        lblPrenom.setFont(new Font("Arial", Font.PLAIN, 12));
        lblPrenom.setBounds(10, 72, 308, 14);
        panel_2.add(lblPrenom);

        textFieldPrenom = new JTextField();
        textFieldPrenom.setBounds(20, 97, 201, 30);
        panel_2.add(textFieldPrenom);
        textFieldPrenom.setColumns(10);

        JLabel lblCarte = new JLabel("Carte Banquaire");
        lblCarte.setFont(new Font("Arial", Font.PLAIN, 12));
        lblCarte.setBounds(10, 133, 308, 14);
        panel_2.add(lblCarte);

        textFieldCarte = new JTextField();
        textFieldCarte.setBounds(20, 158, 201, 30);
        panel_2.add(textFieldCarte);
        textFieldCarte.setColumns(10);

        btnNewButton = new JButton("Reserver");
        btnNewButton.setBounds(126, 353, 136, 30);
        btnNewButton.addActionListener(this);
        panel.add(btnNewButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnNewButton){
            if(textFieldNom.getText().trim().length()==0 || textFieldPrenom.getText().trim().length()==0 || textFieldCarte.getText().trim().length()==0)
            {
                JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs correctement","Attention !",JOptionPane.ERROR_MESSAGE);
            }else{
                try {
                    ReservationDTO res=new ReservationDTO(AgenceData.getAgence().getId(), agence,password,id,textFieldNom.getText(),textFieldPrenom.getText(),textFieldCarte.getText());
                    JOptionPane.showMessageDialog(null,resproxy.postForObject(link+"reservation",res,String.class));
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String dateDeb=sdf.format(this.hotel.getDateChooserDeb().getDate());
                    String dateFin=sdf.format(this.hotel.getDateChooserfin().getDate());
                    int nbrPers = Integer.parseInt(this.hotel.getTextFieldnbr().getText());

                    this.hotel.getOffre(dateDeb, dateFin, nbrPers);
                    this.hotel.btnReservation.setEnabled(false);
                    this.hotel.btnImage.setEnabled(false);
                    this.frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                } catch (IllegalArgumentException ie){
                    JOptionPane.showMessageDialog(null,"Donnée entrer non valide","Attention !",JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Erreur de connexion","Attention !",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}

