package com.example.Agence.GUI;

import java.awt.*;

import javax.persistence.Entity;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.example.Agence.AgenceApplication;
import com.example.Agence.DTO.OffreDTO;
import com.example.Agence.models.Hotel;
import com.example.Agence.models.Offre;
import java.awt.event.*;

import com.example.Agence.Data.AgenceData;
import com.example.Agence.models.Webservice;
import com.example.Agence.repository.HotelRepository;
import com.toedter.calendar.JDateChooser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EntityScan(basePackages = {
		"com.example.Agence.models",
})

@EnableJpaRepositories(basePackages = {
		"com.example.Agence.repository",
})
@SpringBootApplication(scanBasePackages = {
		"com.example.Agence.controller",
		"com.example.Agence.repository",
		"com.example.Agence.client",
		"com.example.Agence.GUI",
		"com.example.Agence.Data",
		"com.example.Agence.DTO",
})

public class HotelAgencyMain implements ActionListener{
	@Autowired
	private RestTemplate Offreproxy;

	@Autowired
	private HotelRepository hotelRepository;

	private JFrame frmHotelAgency;
	private JTextField textFieldnbr;
	private JTable table;
//	private OffreServiceImpService Offre;
//	private IOffreService proxy;
	private JButton btnReservation;
	private JButton btnImage;
	private JDateChooser dateChooserDeb;
	private JDateChooser dateChooserfin;
//	ReservationServiceImpService res;
//	IReservationService resproxy;
	String currentTableID;

	List<Offre> offreList;
	List<List<Offre>> allOffre=new ArrayList<>();
	//List<List<Reservation>> allResrvation=new ArrayList<>();

//	public List<IOffreService> offreServiceImpServiceList=new ArrayList<>();
//	public List<IReservationService> reservationServiceImpServiceList=new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		var ctx = new SpringApplicationBuilder(HotelAgencyMain.class)
				.headless(false).run(args);

		EventQueue.invokeLater(() -> {
			var ex = ctx.getBean(HotelAgencyMain.class);
			ex.frmHotelAgency.setVisible(true);
		});
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HotelAgencyMain window = new HotelAgencyMain();
//					window.frmHotelAgency.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the application.
	 */
	public HotelAgencyMain() {
		//initWebService();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public void initialize() {
		new AgenceData();
		frmHotelAgency = new JFrame();
		frmHotelAgency.setTitle("Hotel Agency");
		frmHotelAgency.setResizable(false);
		frmHotelAgency.setBounds(100, 100, 900, 454);
		frmHotelAgency.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHotelAgency.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 892, 421);
		frmHotelAgency.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbTitle = new JLabel("HOTEL AGENCY");
		lbTitle.setFont(new Font("Arial", Font.PLAIN, 18));
		lbTitle.setBounds(25, 11, 328, 22);
		panel.add(lbTitle);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(123, 104, 238));
		panel_1.setBounds(25, 44, 195, 10);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(25, 75, 195, 302);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(0, 0, 195, 21);
		panel_2.add(panel_3);
		
		JLabel lblDateDebut = new JLabel("Date de Debut");
		lblDateDebut.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDateDebut.setBounds(10, 32, 175, 14);
		panel_2.add(lblDateDebut);
		
		JLabel lblDateDeFin = new JLabel("Date de Fin");
		lblDateDeFin.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDateDeFin.setBounds(10, 97, 175, 14);
		panel_2.add(lblDateDeFin);
		
		JLabel lblNombreDePersonne = new JLabel("Nombre de personnes");
		lblNombreDePersonne.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombreDePersonne.setBounds(10, 170, 175, 14);
		panel_2.add(lblNombreDePersonne);

		dateChooserDeb = new JDateChooser();
		dateChooserDeb.setBounds(10, 57, 157, 20);
		panel_2.add(dateChooserDeb);

		dateChooserfin = new JDateChooser();
		dateChooserfin.setBounds(10, 122, 157, 20);
		panel_2.add(dateChooserfin);

		textFieldnbr = new JTextField();
		textFieldnbr.setBounds(10, 195, 157, 26);
		panel_2.add(textFieldnbr);
		textFieldnbr.setColumns(10);
		
		JButton btnConsulter = new JButton("Consulter");
		btnConsulter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean check=true;
				int nbrPers = 0;
				if(dateChooserDeb.getDate()==null || dateChooserfin.getDate()==null || textFieldnbr.getText().trim().length()==0){
					JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs correctement","Attention !",JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						nbrPers = Integer.parseInt(textFieldnbr.getText());
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
								getOffre(DateDeb,DateFin,nbrPers);
							}catch (ResourceAccessException re){
								JOptionPane.showMessageDialog(null,"Connexion refuser","Attention !",JOptionPane.ERROR_MESSAGE);
							}
							catch (Exception ex) {
								ex.printStackTrace();
								JOptionPane.showMessageDialog(null,"votre login ou mot de passe est incorrect","Attention !",JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
			}
		});
		btnConsulter.setBounds(10, 257, 175, 34);
		panel_2.add(btnConsulter);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ligne=table.getSelectedRow();
				btnReservation.setEnabled(true);
				btnImage.setEnabled(true);
				String id=table.getModel().getValueAt(ligne, 0).toString();
				currentTableID=id;
			}
		});
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(267, 96, 590, 240);
		panel.add(scrollPane);

		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(267, 75, 590, 22);
		panel.add(panel_4);
		
		JLabel lblNewLabel = new JLabel("Offre Disponible");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		panel_4.add(lblNewLabel);
		
		btnReservation = new JButton("Reservation");
		btnReservation.addActionListener(this);
		btnReservation.setBounds(730, 347, 126, 30);
		panel.add(btnReservation);
		btnReservation.setEnabled(false);

		btnImage = new JButton("Ouvrir l'image de l'offre");
		btnImage.addActionListener(this);
		btnImage.setBounds(270, 347, 200, 30);
		panel.add(btnImage);
		btnImage.setEnabled(false);

		JMenuBar menuBar = new JMenuBar();
		frmHotelAgency.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Administration");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Modifier les informations");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminWindow admin=new AdminWindow();
				admin.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		String col[] = {"Nom","Nom Maitre","Espece","Race","Suivi"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		
		JButton btnSupprimer = new JButton("Supprimer");
	}
//	public void initWebService(){
//		new AgenceData();
//		try {
//			for (Webservice ws: AgenceData.getAgence().getHotelPartennaire()
//				 ) {
//				URL url=new URL(ws.getOffre());
//				Offre=new OffreServiceImpService(url);
//				proxy=Offre.getOffreServiceImpPort();
//				offreServiceImpServiceList.add(proxy);
//
//				URL resurl=new URL(ws.getReservation());
//				res=new ReservationServiceImpService(resurl);
//				resproxy=res.getReservationServiceImpPort();
//				reservationServiceImpServiceList.add(resproxy);
//			}
//
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			JOptionPane.showMessageDialog(null,"Impossible de se connecter au service web avec votre url","Attention !",JOptionPane.ERROR_MESSAGE);
//		}   catch (WebServiceException e) {
//			JOptionPane.showMessageDialog(null,"Connexion refuser","Attention !",JOptionPane.ERROR_MESSAGE);
//		}
//	}

	public void getOffre(String datedeb,String datefin,int nbr){
		List<Hotel> h=hotelRepository.findAll();
		AgenceData.getAgence().setHotelPartennaire(h);
		String col[] = {"Reference","Date de Debut","Fin de disponibilite","Prix", "Nombre de lits"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		for (Hotel ws : AgenceData.getAgence().getHotelPartennaire()
			 ) {
			OffreDTO offreDTO=new OffreDTO(AgenceData.getAgence().getId(),AgenceData.getAgence().getPassword(),datedeb,datefin,nbr);
			if(Offreproxy == null){
				JOptionPane.showMessageDialog(null,"Connexion refuser","Attention !",JOptionPane.ERROR_MESSAGE);
			}else{
				String test=Offreproxy.getForObject(ws.getWebservice().getOffre(), String.class);
				System.out.println(test);
				Offre[] offres = Offreproxy.postForObject(ws.getWebservice().getOffre(),offreDTO, Offre[].class);
				Arrays.asList(offres)
						.forEach(System.out::println);

				allOffre.add(List.of(offres));
				table.setModel(tableModel);
				for (Offre f:offres
				) {
					String[] obj= {""+f.getId(),f.getDateDeDisponibiliteDeb(),f.getDateDeDisponibiliteFin(), String.valueOf(f.getPrix()), String.valueOf(f.getNbrLits())};
					tableModel.addRow(obj);
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Webservice currentproxy = AgenceData.getAgence().getHotelPartennaire().get(0).getWebservice();
		Webservice currentOffreproxy;
		int currentnbr=0;
		for (List<Offre> off:allOffre) {
			for (Offre of:off
			) {
				if (("" + of.getId()).equals(currentTableID)) {
					currentproxy = AgenceData.getAgence().getHotelPartennaire().get(currentnbr).getWebservice();
					break;
				}
			}
			currentnbr+=1;
		}
		if(e.getSource()==btnReservation){
			int i=0;
			ClientWindows mywindow = new ClientWindows(currentproxy.getReservation(),Offreproxy,AgenceData.getAgence().getLogin(), AgenceData.getAgence().getPassword(), currentTableID, this);
			mywindow.frame.setVisible(true);
		}

		if (e.getSource()==btnImage){
			String image="";
			ImageWindows mywindow = null;
			for (List<Offre> offres:allOffre
				 ) {
				int i = 0;
				while (i < offres.size() && !offres.get(i).getId().equals(currentTableID)){
					i++;
				}
				//image = offres.get(i).getChambre().getImage();
			}
			try {
				mywindow = new ImageWindows(image);
				mywindow.frame.setVisible(true);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}
	}

	public JDateChooser getDateChooserDeb() {
		return dateChooserDeb;
	}

	public JDateChooser getDateChooserfin() {
		return dateChooserfin;
	}

	public JTextField getTextFieldnbr() {
		return textFieldnbr;
	}
}
