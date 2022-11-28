package com.example.Agence.GUI;


import com.example.Agence.Data.AgenceData;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class AdminWindow implements ActionListener{

	private JFrame frame;
	private JTextField textFieldLogin;
	private JTextField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminWindow window = new AdminWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 393, 353);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 381, 314);
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
		panel_2.setBounds(26, 88, 328, 174);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lbllogin = new JLabel("Login");
		lbllogin.setFont(new Font("Arial", Font.PLAIN, 12));
		lbllogin.setBounds(10, 11, 308, 14);
		panel_2.add(lbllogin);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(20, 36, 201, 30);
		panel_2.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mot de passe");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 72, 308, 14);
		panel_2.add(lblNewLabel_1);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(20, 97, 201, 30);
		panel_2.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.setBounds(126, 273, 136, 30);
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(textFieldLogin.getText().trim().length()==0 || textFieldPassword.getText().trim().length()==0){
			JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs correctement","Attention !",JOptionPane.ERROR_MESSAGE);
		}else{
			AgenceData.getAgence().setLogin(textFieldLogin.getText());
			AgenceData.getAgence().setPassword(textFieldPassword.getText());
			JOptionPane.showMessageDialog(null,"Vos login et mots de passe on ete modifier","Bravo !",JOptionPane.INFORMATION_MESSAGE);
			this.frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}
	}
}
