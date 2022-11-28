package com.example.Agence.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class ImageWindows {
    public JFrame frame;

    public ImageWindows(String image) throws IOException {

        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 800, 800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        URL url = new URL(image);
        URLConnection conn = url.openConnection();
        conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
        Image images = ImageIO.read(conn.getInputStream());
        JLabel label = new JLabel(new ImageIcon(images));

        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(label);

        JTextField f = new JTextField(image);
        f.setBounds(26, 24, 780, 22);
        f.setEditable(false);
        f.setBackground(null);
        f.setBorder(null);

    }
}
