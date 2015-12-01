package presentation.logisticui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.io.File;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import presentation.mainui.loginFrame;
import presentation.util.welcomPanel;
import vo.ArrivalNoteOnTransitVO;
import vo.LoadNoteOnTransitVO;
import vo.TransitNoteOnTransitVO;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class TransitFrame extends JFrame {

	private JPanel contentPane;
	private welcomPanel welcome;
    private JPanel bankpanel;
    private ArrivalNoteOnTransitVO arrivalNoteOnTransitVO;
    private LoadNoteOnTransitVO loadNoteOnTransitVO;
    private TransitNoteOnTransitVO transitNoteOnTransitVO;
    
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1280;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 720;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransitFrame.changeLook();
					TransitFrame frame = new TransitFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
				int result = JOptionPane.showConfirmDialog(TransitFrame.this, "确认退出？","系统提示",
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
	public TransitFrame() {
		setResizable(false);
		setBackground(new Color(153, 204, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setResizable(false);//不可调整大小
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/0010.jpg"));
		setTitle("快递物流系统");
		this.setSize(WIDTH, HEIGHT);
		((JComponent) this.getContentPane()).setOpaque(true);//不透明
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((screenWidth-WIDTH)>>1, (screenHeight-HEIGHT)>>1);
		
		bankpanel = new JPanel();
		bankpanel.setBounds(138, 125, 1152, 446);
		contentPane.add(bankpanel);
		bankpanel.setLayout(null);
		welcome = new welcomPanel();
		welcome.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		welcome.setBounds(0, 0, 1152, 446);
		bankpanel.add(welcome);
		welcome.setLayout(null);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(168, 6, 865, 94);
		lblNewLabel_1.setIcon(new ImageIcon("/Users/alice/Desktop/sec2-master-3/Project/ExpressSystem/client/image/image1.jpg"));
		panel.add(lblNewLabel_1);
		
		JLabel lblL = new JLabel();
		lblL.setBounds(1075, 280, 0, 0);
		panel.add(lblL);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		panel_1.setBounds(0, 100, 1280, 25);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(6, 0, 132, 22);
		panel_1.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("系统（S）");
		menuBar.add(mnNewMenu);
		
		JMenu mnf = new JMenu("功能（F）");
		menuBar.add(mnf);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.LIGHT_GRAY, Color.GRAY));
		panel_2.setBounds(0, 570, 350, 124);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("系统公告");
		label.setBounds(16, 6, 52, 16);
		panel_2.add(label);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(16, 106, 61, 16);
		panel_2.add(lblNewLabel);
		
		JPanel approve = new JPanel();
		approve.setBounds(347, 570, 933, 124);
		contentPane.add(approve);
		approve.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.LIGHT_GRAY, Color.GRAY));
		approve.setLayout(null);
		
		JButton button = new JButton("查看中转单");
		button.setBounds(560, 89, 117, 29);
		button.setVisible(false);
		approve.add(button);
		
		JButton button_1 = new JButton("查看到达单");
		button_1.setBounds(435, 89, 117, 29);
		button_1.setVisible(false);
		approve.add(button_1);
		
		JButton button_2 = new JButton("查看装车单");
		button_2.setBounds(689, 89, 117, 29);
		button_2.setVisible(false);
		approve.add(button_2);
		
		JButton btnNewButton = new JButton("录入到达单");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrivalNoteOnTransitPanel anot = new ArrivalNoteOnTransitPanel(){
					public void paintComponent(Graphics g) {
						 super.paintComponent(g);
						 ImageIcon img = new ImageIcon("image/0111.jpg");
						 g.drawImage(img.getImage(), 0, 0, null);
						 float lineWidth = 3.0f;
					      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
					      g.drawLine(768, 0, 768, 500);
						}
						}; 
				anot.setBounds(0, 0, 1152, 446);
				bankpanel.removeAll();
				bankpanel.add(anot);
				bankpanel.repaint();
				
			}
		});
		btnNewButton.setBounds(0, 123, 140, 152);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("录入中转单");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TransitNoteInputPanel tni = new TransitNoteInputPanel(){
				public void paintComponent(Graphics g) {
					 super.paintComponent(g);
					 ImageIcon img = new ImageIcon("image/0111.jpg");
					 g.drawImage(img.getImage(), 0, 0, null);
					 float lineWidth = 3.0f;
				      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
				      g.drawLine(768, 0, 768, 500);
					}
					}; 
			tni.setBounds(0, 0, 1152, 446);
			bankpanel.removeAll();
			bankpanel.add(tni);
			bankpanel.repaint();
			
			}
		});
		btnNewButton_1.setBounds(0, 272, 140, 152);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("录入装车单");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadNoteOnTransitPanel lnot = new LoadNoteOnTransitPanel(){
					public void paintComponent(Graphics g) {
						 super.paintComponent(g);
						 ImageIcon img = new ImageIcon("image/0111.jpg");
						 g.drawImage(img.getImage(), 0, 0, null);
						 float lineWidth = 3.0f;
					      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
					      g.drawLine(768, 0, 768, 500);
						}
						}; 
				lnot.setBounds(0, 0, 1152, 446);
				bankpanel.removeAll();
				bankpanel.add(lnot);
				bankpanel.repaint();
			}
		});
		btnNewButton_2.setBounds(0, 420, 140, 152);
		contentPane.add(btnNewButton_2);
		
		
		
		
		
	}
}
