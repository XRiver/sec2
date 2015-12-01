package presentation.mainui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import dataservice.exception.ElementNotFoundException;
import presentation.commodityui.Commodity;
import presentation.financeui.financeFrame;
import presentation.logisticui.CourierFrame;
import presentation.logisticui.Service;
import presentation.logisticui.TransitFrame;
import presentation.statisticui.ManageFrame;
import presentation.util.checkstyleDialog;
import businesslogicservice.infoblservice.SystemUserManagementBLService;
import businesslogicservice.infoblservice._stub.SystemUserManagementBLService_Stub;
import businesslogicservice.statisticblservice.OrderInquiryBLService;
import businesslogicservice.statisticblservice._stub.OrderInquiryBLService_Stub;
import util.LogInMsg;
import util.ResultMsg;
import util.enums.Authority;
import vo.OrderVO;
import vo.UserVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class loginFrame extends JFrame {
//查询的监听
	private JPanel contentPane;
	private JTextField account;
	private JTextField password;
	private JTextField barcode;
	private JTextField textField_2;
	private JLabel label;
	private LogInMsg lim;
	private ResultMsg res;
	private SystemUserManagementBLService service;
	private Authority authority;
	private OrderInquiryBLService orderService;
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
					loginFrame.changeLook();
					loginFrame.changeFont();
					loginFrame frame = new loginFrame();
					frame.setVisible(true);
					frame.setClose();
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
	
	private  void setClose() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				int result = JOptionPane.showConfirmDialog(loginFrame.this, "确认退出？","系统提示",
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
	public loginFrame() {
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setResizable(false);//不可调整大小
		setTitle("MinJW物流管理系统");
		
		((JComponent) this.getContentPane()).setOpaque(true);//不透明
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((screenWidth-1280)>>1, (screenHeight-720)>>1);
		
		final lastloginpanel llp = new lastloginpanel();
		llp.setBounds(0, 0, 1280, 720);
		contentPane.add(llp);
		llp.setLayout(null);
		
		barcode = new JTextField();
		barcode.setBounds(169, 381, 254, 46);
		llp.add(barcode);
		barcode.setColumns(10);
		
		account = new JTextField();
		account.setBounds(660, 342, 245, 46);
		llp.add(account);
		account.setColumns(10);
		
		password = new JTextField();
		password.setBounds(660, 416, 245, 46);
		llp.add(password);
		password.setColumns(10);
		
		label = new JLabel("请输入正确的订单号，为10位0～9的数字");
		label.setForeground(Color.RED);
		label.setBounds(168, 431, 240, 16);
		label.setVisible(false);
		llp.add(label);
		
		JButton button_1 = new JButton("查询");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderService = new OrderInquiryBLService_Stub();
				res = orderService.inputBarcode(barcode.getText());
				if(res.isPass()){
					OrderVO vo = orderService.submitBarcode(barcode.getText());
		
					clientInquiryPanel cip = new clientInquiryPanel(vo);
					cip.setBounds(0, 0, WIDTH, HEIGHT);
					contentPane.removeAll();
					contentPane.add(cip);
					contentPane.repaint();
					
					cip.getButton().addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
			            contentPane.removeAll();
			            contentPane.add(llp);
			            contentPane.repaint();					
						}
						
					});
				}else{
					label.setVisible(true);
				}
				
				
			}
		});
		button_1.setBounds(335, 505, 88, 37);
		llp.add(button_1);
		
		

		
		final JLabel red = new JLabel("帐号或者密码有误，请检查重新输入");
		red.setForeground(Color.RED);
		red.setBounds(668, 461, 248, 16);
		red.setVisible(false);
		llp.add(red);
		
		
	
		
		JButton button = new JButton("登录");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service = new SystemUserManagementBLService_Stub ();
				lim = service.logIn(account.getText(), password.getText());
				if(lim.isPass()){					
					if(lim.getAuthority().equals(authority.MANAGER)){//总经理登录
						ManageFrame mf = new ManageFrame();
						mf.setVisible(true);
					}else if(lim.getAuthority().equals(authority.ACCOUNTANT_HIGH)){//中转中心业务员登录
						TransitFrame tf = new TransitFrame();
						tf.setClose();
						tf.setVisible(true);
						tf.setClose();;
					}else if(lim.getAuthority().equals(authority.ACCOUNTANT_LOW)){//营业厅业务员登录
						Service s = new Service();
						s.setVisible(true);	
						s.setClose();			
					}else if(lim.getAuthority().equals(authority.WAREHOUSE_MANAGER)){//仓库管理人员登录
						Commodity c = new Commodity();
						c.setVisible(true);								
					}else if(lim.getAuthority().equals(authority.DELIVERY_MAN)){//快递员登录
						CourierFrame cf = new CourierFrame();
						cf.setClose();
						cf.setVisible(true);									
					}else if(lim.getAuthority().equals(authority.Financial_PERSONNEL)){
						financeFrame ff = new financeFrame();
						ff.setClose();
						ff.setVisible(true);
					}else{
						;
					}
					setVisible(false);
				}else{
					red.setVisible(true);
				}
			
				
			}
		});
		button.setBounds(804, 505, 88, 37);
		llp.add(button);	
		
	

	
}
}

