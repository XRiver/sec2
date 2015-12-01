package presentation.mainui;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class lastloginpanel extends JPanel {
	
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1280;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 720;
	private JTextField barcode;
	private JTextField account;
	private JTextField password;

	/**
	 * Create the panel.
	 */
	public lastloginpanel() {
		setSize(WIDTH,HEIGHT);
		setLayout(null);
		
		JLabel label = new JLabel("订单号");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label.setBounds(81, 392, 76, 22);
		add(label);
		
		/*barcode = new JTextField();
		barcode.setBounds(169, 381, 254, 46);
		add(barcode);
		barcode.setColumns(10);
		
		account = new JTextField();
		account.setBounds(660, 342, 245, 46);
		add(account);
		account.setColumns(10);
		
		password = new JTextField();
		password.setBounds(660, 416, 245, 46);
		add(password);
		password.setColumns(10);*/
	
		
		JLabel lblNewLabel = new JLabel("帐号");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setBounds(602, 356, 61, 16);
		add(lblNewLabel);
		
		JLabel label_1 = new JLabel("密码");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_1.setBounds(602, 430, 61, 16);
		add(label_1);
		

	}
	
	public void paintComponent(Graphics g) {
		 super.paintComponents(g);	
		 Image img = new ImageIcon("image/loginpanel.png").getImage();
		 g.drawImage(img,0,0,getSize().width,getSize().height,null);
		 g.drawImage(img, 0, 0, null);
		}
}
