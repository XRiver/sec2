/**
 * 仓库管理员主界面
 * 
 * @author wqy
 *
 */
package presentation.commodityui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JLabel;

import java.awt.SystemColor;

import javax.swing.UIManager;
import javax.swing.ImageIcon;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;




import presentation.logisticui.PayMent;

import java.awt.Toolkit;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

import javax.swing.border.EtchedBorder;

public class Commodity extends JFrame {
	private JFrame frame=this;
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1280;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 720;
	/**
	 * MIDDLE宽度
	 */
	private static final int WIDTHM = 1152;
	
	/**
	 * MIDDLE高度
	 */
	private static final int HEIGHTM = 446;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Commodity.changeLook();
					Commodity.changeFont();
					Commodity frame = new Commodity();
					frame.setCaiDanLan();
					frame.setVisible(true);
					frame.setClose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * 更改外观
	 */
	private static void changeLook() {
	    try {
	    	BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	        // 关闭右上角设置
	       UIManager.put("RootPane.setupButtonVisible", false);
	    } catch(Exception e) {
	    }
	}
	/**
	 * 更改默认字体
	 */
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
	
	/**
	 * 设置关闭按钮
	 */
	private  void setClose() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				int result = JOptionPane.showConfirmDialog(Commodity.this, "确认退出？","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					return;
				}
			}
		});
	}
	//设置菜单栏
public void setCaiDanLan(){
	
	
	JMenuBar menuBar = new JMenuBar();
	menuBar.setBounds(0, 80, WIDTH, 34);
	getContentPane().add(menuBar);
	
	JMenu mns = new JMenu("系统(S)");
	menuBar.add(mns);
	
	JMenu mns_1 = new JMenu("功能(F)");
	menuBar.add(mns_1);
	
	
	
}
	/**
	 * Create the frame.
	 */
	public Commodity() {
	
		this.setResizable(false);//不可调整大小
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/0010.jpg"));
		setTitle("快递物流系统");
		this.setSize(WIDTH, HEIGHT);
		((JComponent) this.getContentPane()).setOpaque(true);//不透明
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((screenWidth-WIDTH)>>1, (screenHeight-HEIGHT)>>1);
		//this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 0, WIDTH, 78);
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
	
		
		JLabel lblNewLabel = new JLabel("MinJW快递物流系统");
		lblNewLabel.requestFocus();
		lblNewLabel.setBounds(0, 0, 1280, 100);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("image/0000.jpg"));
		
		final JPanel middle = new JPanel(){
			public void paintComponent(Graphics g) {
				 super.paintComponent(g);
				 ImageIcon img = new ImageIcon("image/0111.jpg");
				 g.drawImage(img.getImage(), 0, 0, null);
				}
				}; 
		middle.setBounds(138, 125, WIDTHM, HEIGHTM);
		middle.setBackground(Color.YELLOW);
		contentPane.add(middle);
		middle.setLayout(null);
		
		
		
		
		JPanel QUANXIANW = new JPanel();
		QUANXIANW.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		QUANXIANW.setBounds(0, 570, 350, 124);
		
	
		
		contentPane.add(QUANXIANW);
		QUANXIANW.setLayout(null);
		
		JLabel user = new JLabel("用户：");
		user.setBounds(10, 2, 54, 15);
		QUANXIANW.add(user);
		
		JLabel username = new JLabel("王五");
		username.setBounds(56, 2, 54, 15);
		QUANXIANW.add(username);
		
		JLabel quanxian = new JLabel("权限：");
		quanxian.setBounds(10, 25, 54, 15);
		QUANXIANW.add(quanxian);
		
		JLabel label = new JLabel("库存管理员");
		label.setBounds(56, 25, 129, 15);
		QUANXIANW.add(label);
		
		JLabel label_1 = new JLabel("公告:");
		label_1.setBounds(10, 53, 54, 15);
		QUANXIANW.add(label_1);
		
		JLabel label_2 = new JLabel("快递系统上线试运行，请反馈使用体验");
		label_2.setBounds(56, 53, 284, 15);
		QUANXIANW.add(label_2);
		
		JPanel right = new JPanel();
		right.setBounds(5, 115, 140, 456);
		contentPane.add(right);
		right.setLayout(null);
		
		JButton button = new JButton("输入入库单");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Inorder a=new Inorder();
				a.setBounds(0, 0, 1152, 446);
				a.setVisible(true);
				middle.removeAll();
				middle.add(a);
				middle.repaint();
			}
		});
		button.setBounds(10, 10, 120, 100);
		right.add(button);
		
		JButton button_1 = new JButton("输入出库单");
		button_1.setBounds(10, 120, 120, 100);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OutOrder a=new OutOrder();	a.setBounds(0, 0, 1152, 446);
			a.setVisible(true);
				middle.removeAll();
				middle.add(a);
				middle.repaint();
			}
		});
		right.add(button_1);
		
		JButton button_2 = new JButton("库存查看");
		button_2.setBounds(10, 224, 120, 100);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChaKan a=new ChaKan();
				a.setBounds(0, 0, 1152, 446);
				a.setVisible(true);
				middle.removeAll();
				middle.add(a);
				middle.repaint();
			}
		});
		right.add(button_2);
		
		JButton button_3 = new JButton("库存盘点");
		button_3.setBounds(10, 334, 120, 100);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanDian a=new PanDian(frame);
				a.setBounds(0, 0, 1152, 446);
				a.setVisible(true);
				middle.removeAll();
				middle.add(a);
				middle.repaint();
			}
		});
		right.add(button_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_2.setBounds(341, 570, 939, 124);
		contentPane.add(panel_2);
	}
}
