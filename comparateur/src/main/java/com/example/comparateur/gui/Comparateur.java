package com.example.comparateur.gui;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.comparateur.dto.ComparateurDTO;
import com.example.comparateur.dto.OffreComparateurResDTO;
import com.example.comparateur.model.Agence;
import com.example.comparateur.repository.AgenceRepository;
import com.toedter.calendar.JDateChooser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

@EntityScan(basePackages = {
        "com.example.comparateur.model",
})
@EnableJpaRepositories(basePackages = {
        "com.example.comparateur.repository",
})
@SpringBootApplication(scanBasePackages = {
        "com.example.comparateur.controller",
        "com.example.comparateur.client",
        "com.example.comparateur.data"
})
public class Comparateur {

    @Autowired
    private AgenceRepository agenceRepository;
    @Autowired
    private RestTemplate Comparateurproxy;
    private JFrame frmComparateurDeVoyage;
    private JTextField txtnbrPersonne;
    private JTextField txtVille;

    private JLabel lblAgence;


    private List<OffreComparateurResDTO> offres=new ArrayList<>();

    private JTable table;

    private String currentTableID;

    private JPanel Imagepanel;
    /**
     * Launch the application.
     */

    public static void main(String[] args) {
        var ctx = new SpringApplicationBuilder(Comparateur.class)
                .headless(false).run(args);

        EventQueue.invokeLater(() -> {

            var ex = ctx.getBean(Comparateur.class);
            ex.frmComparateurDeVoyage.setVisible(true);
        });

    }

    public Comparateur() {
        initialize();
    }

    private void initialize() {
        frmComparateurDeVoyage = new JFrame();
        frmComparateurDeVoyage.setTitle("Comparateur de voyage");
        frmComparateurDeVoyage.setBounds(100, 100, 1200, 500);
        frmComparateurDeVoyage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmComparateurDeVoyage.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.window);
        panel.setBounds(0, 0, 1184, 461);
        frmComparateurDeVoyage.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lbTitle = new JLabel("COMPARATEUR AGENCY");
        lbTitle.setFont(new Font("Arial", Font.PLAIN, 18));
        lbTitle.setBounds(23, 11, 328, 22);
        panel.add(lbTitle);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(123, 104, 238));
        panel_1.setBounds(23, 44, 231, 10);
        panel.add(panel_1);

        JPanel font = new JPanel();
        font.setLayout(null);
        font.setBounds(23, 75, 195, 362);
        panel.add(font);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(Color.LIGHT_GRAY);
        panel_3.setBounds(0, 0, 195, 21);
        font.add(panel_3);

        JLabel lblDateDebut = new JLabel("Date de Debut");
        lblDateDebut.setFont(new Font("Arial", Font.PLAIN, 12));
        lblDateDebut.setBounds(10, 89, 175, 14);
        font.add(lblDateDebut);

        JLabel lblDateDeFin = new JLabel("Date de Fin");
        lblDateDeFin.setFont(new Font("Arial", Font.PLAIN, 12));
        lblDateDeFin.setBounds(10, 145, 175, 14);
        font.add(lblDateDeFin);

        JLabel lblNombreDePersonne = new JLabel("Nombre de personnes");
        lblNombreDePersonne.setFont(new Font("Arial", Font.PLAIN, 12));
        lblNombreDePersonne.setBounds(10, 206, 175, 14);
        font.add(lblNombreDePersonne);

        txtnbrPersonne = new JTextField();
        txtnbrPersonne.setColumns(10);
        txtnbrPersonne.setBounds(10, 228, 157, 26);
        font.add(txtnbrPersonne);

        JDateChooser dateChooserDeb = new JDateChooser();
        dateChooserDeb.setBounds(10, 114, 157, 20);
        font.add(dateChooserDeb);

        JDateChooser dateChooserfin = new JDateChooser();
        dateChooserfin.setBounds(10, 170, 157, 20);
        font.add(dateChooserfin);

        JLabel lblVille = new JLabel("Ville");
        lblVille.setFont(new Font("Arial", Font.PLAIN, 12));
        lblVille.setBounds(10, 32, 175, 14);
        font.add(lblVille);

        txtVille = new JTextField();
        txtVille.setColumns(10);
        txtVille.setBounds(10, 52, 157, 26);
        font.add(txtVille);

        JLabel Etoile = new JLabel("1");
        Etoile.setBounds(112, 265, 73, 14);
        font.add(Etoile);

        JSlider sliderEtoile = new JSlider(1, 5, 1);
        sliderEtoile.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                Etoile.setText(""+sliderEtoile.getValue());
            }

        });
        sliderEtoile.setBounds(10, 280, 157, 26);
        font.add(sliderEtoile);

        JLabel lblNombreDetoile = new JLabel("Nombre d'etoile :");
        lblNombreDetoile.setFont(new Font("Arial", Font.PLAIN, 12));
        lblNombreDetoile.setBounds(10, 265, 116, 14);
        font.add(lblNombreDetoile);

        JPanel panel_5 = new JPanel();
        panel_5.setBounds(888, 316, 262, 92);
        panel.add(panel_5);
        panel_5.setLayout(null);

        lblAgence = new JLabel("");
        panel_5.add(lblAgence);
        lblAgence.setBounds(30, 10, 262, 92);
        lblAgence.setFont(new Font("Arial", Font.PLAIN, 13));

        Imagepanel = new JPanel();
        Imagepanel.setBounds(888, 74, 262, 217);

        JLabel imageLabel=new JLabel();
        Imagepanel.add(imageLabel);

        panel.add(Imagepanel);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int ligne=table.getSelectedRow();
                String id=table.getModel().getValueAt(ligne, 0).toString();
                lblAgence.setText("Agence: "+offres.get(ligne).getAgence());
                SetImage(imageLabel,offres.get(ligne).getImage());
                currentTableID=id;
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(282, 92, 566, 316);
        panel.add(scrollPane);

        JButton btnConsulter = new JButton("Consulter");
        btnConsulter.setBounds(10, 317, 175, 34);
        font.add(btnConsulter);
        btnConsulter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean check=true;
                int nbrPers = 0;
                if(dateChooserDeb.getDate()==null || dateChooserfin.getDate()==null || txtnbrPersonne.getText().trim().length()==0 || txtVille.getText().trim().length()==0){
                    JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs correctement","Attention !",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    try {
                        nbrPers = Integer.parseInt(txtnbrPersonne.getText());
                    }catch (NumberFormatException e2) {
                        check=false;
                        JOptionPane.showMessageDialog(null,"Entrer un entier valide","Attention !",JOptionPane.ERROR_MESSAGE);
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    if(dateChooserDeb.getDate().after(dateChooserfin.getDate())){
                        JOptionPane.showMessageDialog(null,"La date de debut de votre sejour doit etre avant la date de fin de votre sejour ","Attention !",JOptionPane.ERROR_MESSAGE);
                    }else{
                        if(check){
                            String DateDeb=sdf.format(dateChooserDeb.getDate());
                            String DateFin=sdf.format(dateChooserfin.getDate());
                            try {
                                getAgence(txtVille.getText(),DateDeb,DateFin,nbrPers,sliderEtoile.getValue());
                            }catch (ResourceAccessException re){
                                JOptionPane.showMessageDialog(null,"Connexion refuser","Attention !",JOptionPane.ERROR_MESSAGE);
                            }
                            catch (Exception ex) {
                                ex.printStackTrace();
                                //JOptionPane.showMessageDialog(null,"votre login ou mot de passe est incorrect","Attention !",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            }
        });

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(Color.LIGHT_GRAY);
        panel_4.setBounds(282, 71, 566, 335);
        panel.add(panel_4);

        JLabel lblNewLabel = new JLabel("Offre Disponible");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        panel_4.add(lblNewLabel);



        JPanel panel_6 = new JPanel();
        panel_6.setBackground(Color.GRAY);
        panel_6.setBounds(0, 0, 262, 26);
        panel_5.add(panel_6);

        JLabel lblDescription = new JLabel("Description");
        panel_6.add(lblDescription);
        lblDescription.setFont(new Font("Arial", Font.PLAIN, 13));
    }
    private void SetImage(JLabel limage,String ImageUrl){
        URL url = null;
        java.awt.Image image = null;
        try {
            System.out.println(url);
            url = new URL(ImageUrl);
            image = ImageIO.read(url);

        } catch (MalformedURLException ex) {
            System.out.println("Malformed URL");
        } catch (IOException iox) {
            System.out.println("Can not load file");
        }
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT));
        limage.setIcon(imageIcon);

    }
    private void getAgence(String ville, String dateDeb, String dateFin, int nbrPers, int etoile) {
        lblAgence.setText("");
        List<Agence> agences=agenceRepository.findAll();
        String col[] = {"Reference","Hotel","Pays","Ville","Place","Etoile","Prix ???"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for (Agence ag : agences
        ) {
            String currentAgence=Comparateurproxy.getForObject(ag.getWebService()+"agence",String.class);
            ComparateurDTO comparateurDTO=new ComparateurDTO(ville,dateDeb,dateFin,nbrPers,etoile);
            if(Comparateurproxy == null){
                JOptionPane.showMessageDialog(null,"Connexion refuser","Attention !",JOptionPane.ERROR_MESSAGE);
            }else{
                OffreComparateurResDTO[] usingoffre;
                usingoffre = Comparateurproxy.postForObject(ag.getWebService()+"comparateur",comparateurDTO, OffreComparateurResDTO[].class);
                table.setModel(tableModel);
                for (OffreComparateurResDTO f:usingoffre
                ) {
                    f.setAgence(currentAgence);
                    offres.add(f);
                    String[] adresse=f.getAdresse().trim().split(",");
                    String[] obj= {""+f.getId(),f.getNom_hotel(),adresse[0],adresse[1],""+f.getNbrLits(),""+f.getNbrEtoile(),""+f.getPrix()};
                    tableModel.addRow(obj);
                }
            }
        }
    }


}
