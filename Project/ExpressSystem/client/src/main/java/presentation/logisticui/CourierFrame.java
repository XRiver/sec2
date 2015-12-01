package presentation.logisticui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.border.EtchedBorder;

import connection.RMIHelper;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import presentation.mainui.loginFrame;
import presentation.util.welcomPanel;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class CourierFrame extends JFrame {

	private JPanel contentPane;
	private welcomPanel welcome;
    private JPanel bankpanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws RemoteException, NotBoundException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourierFrame.changeLook();
					CourierFrame frame = new CourierFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

        RMIHelper.tryConnect();
	}
    
	private static void changeLook() {
	    try {
	    	BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	        // 关闭右上角设置
	       UIManager.put("RootPane.setupButtonVisible", false);
	    } catch(Exception e) {
	    }
	}
	
	private static void changeFont() {
		Font font = new Font("微软雅黑", Font.PLAIN, 15);   
		@SuppressWarnings("rawtypes")
		java.util.Enumeration keys = UIManager.getDefaults().keys();   
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();   
		    Object value = UIManager.get(key);    
		    if (value instanceof javax.swing.plaf.FontUIResource) {
		    	UIManager.put(key, font);     
		    } 
		} 
	}
	
	public  void setClose() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				int result = JOptionPane.showConfirmDialog(CourierFrame.this, "确认退出？","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					return;
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CourierFrame() {
		setSize(1280,720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setResizable(false);//不可调整大小
		setTitle("MinJW物流管理系统");
		
		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g) {
				 super.paintComponent(g);
				 ImageIcon img = new ImageIcon("image/henfu.png");
				 g.drawImage(img.getImage(), 0, 0, null);
				}
				};
		panel.setBounds(0, 0, 1280, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBounds(0, 100, 1280, 25);
		contentPane.add(panel_1);
		
		bankpanel = new JPanel();
		bankpanel.setBounds(138, 125, 1152, 446);
		contentPane.add(bankpanel);
		bankpanel.setLayout(null);
		welcome = new welcomPanel();
		welcome.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		welcome.setBounds(0, 0, 1152, 446);
		bankpanel.add(welcome);
		welcome.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_3.setBounds(347, 570, 933, 124);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_4.setBounds(0, 570, 350, 124);
		contentPane.add(panel_4);
		
		JButton btnNewButton = new JButton("登记寄件单");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MailOrderPanel mop = new MailOrderPanel(){
					public void paintComponent(Graphics g) {
						 super.paintComponent(g);
						 ImageIcon img = new ImageIcon("image/0111.jpg");
						 g.drawImage(img.getImage(), 0, 0, null);
						 float lineWidth = 3.0f;
					      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
					      g.drawLine(768, 0, 768, 500);
						}
						}; 
				mop.setBounds(0, 0, 1152, 446);
				bankpanel.removeAll();
				bankpanel.add(mop);
				bankpanel.repaint();
				
			}
		});
		btnNewButton.setBounds(0, 123, 140, 152);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("录入收件单");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReceiveOrderPanel rop = new ReceiveOrderPanel(){
					public void paintComponent(Graphics g) {
						 super.paintComponent(g);
						 ImageIcon img = new ImageIcon("image/0111.jpg");
						 g.drawImage(img.getImage(), 0, 0, null);
						}
						}; 
				rop.setBounds(0, 0, 1152, 446);
				bankpanel.removeAll();
				bankpanel.add(rop);
				bankpanel.repaint();
			}
		});
		button.setBounds(0, 272, 140, 152);
		contentPane.add(button);
		
		JButton button_1 = new JButton("查询订单信息");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InquiryPanel ip = new InquiryPanel(){
					public void paintComponent(Graphics g) {
						 super.paintComponent(g);
						 ImageIcon img = new ImageIcon("image/0111.jpg");
						 g.drawImage(img.getImage(), 0, 0, null);
						}
						}; 
				ip.setBounds(0, 0, 1152, 446);
				bankpanel.removeAll();
				bankpanel.add(ip);
				bankpanel.repaint();
				
				ip.getBack().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						bankpanel.removeAll();
						bankpanel.add(welcome);
						bankpanel.repaint();
					}
					
				});
			}
		});
		button_1.setBounds(0, 421, 140, 152);
		contentPane.add(button_1);
		
		
	}
}
