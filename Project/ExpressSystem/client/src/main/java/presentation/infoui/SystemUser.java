/**
 * 管理系统用户主界面
 * 
 * @author wqy
 *
 */
package presentation.infoui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

public class SystemUser extends JFrame {
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
	private JTextField name;
	private JTextField code;
	private JTextField auth;
	private JTextField pass;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table;
	private DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemUser.changeLook();
					SystemUser.changeFont();
					SystemUser frame = new SystemUser();
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
				int result = JOptionPane.showConfirmDialog(SystemUser.this, "确认退出？","系统提示",
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
	public SystemUser() {
		JPanel pppp = (JPanel)this.getContentPane();
		// 加载背景图片 
		 ImageIcon img = new ImageIcon("image/0111.jpg");
		JLabel llll=new JLabel(img);
		llll.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
		pppp.setOpaque(false);//最上层透明
			this.getLayeredPane().add(llll,new Integer(Integer.MIN_VALUE));//第二层加图片





	
		
		this.setResizable(false);//不可调整大小
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/logo.jpg"));
		setTitle("快递物流系统");
		this.setSize(WIDTH, HEIGHT);
((JComponent) this.getContentPane()).setOpaque(true);//不透明
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((screenWidth-WIDTH)>>1, (screenHeight-HEIGHT)>>1);
		//this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		
		
		
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 0, WIDTH, 78);
		panel.setBackground(Color.LIGHT_GRAY);
		
	
		
		
		
		
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_2.setBounds(341, 570, 939, 124);
		contentPane.add(panel_2);
		
		initComponent();
	}
    private void initComponent()    {  
    	
        /* 
         * 设置JTable的列名 
         */  
        String[] columnNames =  
        { "帐户名", "账号", "权限"};  
  
        /* 
         * 初始化JTable里面各项的值 
         */  
        Object[][] obj = new Object[1][3];  
        for (int i = 0; i < 1; i++)  
        {  
            for (int j = 0; j < 3; j++)  
            {  
                switch (j)  
                {  
                case 0:  
                    obj[i][j] = "001";  
                    break;  
                case 1:  
                    obj[i][j] = "王翔翔";  
                    break;  
                case 2:  
                    obj[i][j] = "男";  
                    break;  
                }  
            }  
        }  
        JPanel middle = new JPanel(){
			public void paintComponent(Graphics g) {
				 super.paintComponent(g);
				 ImageIcon img = new ImageIcon("image/0111.jpg");
				 g.drawImage(img.getImage(), 0, 0, null);
				}
				};
        middle.setBounds(0, 149, 1291, 424);
        contentPane.add(middle);
        middle.setLayout(null);
        model=new DefaultTableModel(obj,columnNames);
        table = new JTable(model);
        table.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent arg0) {
        	int selectedRow= table.getSelectedRow();
        	Object oa=model.getValueAt(selectedRow, 0);
        	name.setText(oa.toString());
        	Object ob=model.getValueAt(selectedRow, 1);
        	code.setText(ob.toString());
        	Object oc=model.getValueAt(selectedRow, 2);
        	auth.setText(oc.toString());
        	//Object od=model.getValueAt(selectedRow, 3);
        	//pass.setText(od.toString());
        	
        	}
        });  
        int colunms = table.getColumnCount();  
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(20, 35, 690, 366);
        middle.add(scroll);
          
        /* 
         * JTable的其中一种构造方法 
         */  
        /* 
         * 设置JTable的列默认的宽度和高度 
         */  
        TableColumn column = null;  
        for(int i = 0; i < colunms; i++)  
        {  
            column = table.getColumnModel().getColumn(i);  
            /*将每一列的默认宽度设置为100*/  
            column.setPreferredWidth(300);  
        }  
        /* 
         * 设置JTable自动调整列表的状态，此处设置为关闭 
         */  
          
        /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
        
       
        
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\SAD\\sec2\\Project\\ExpressSystem\\client\\image\\userlist.png"));
        label.setBounds(10, 10, 185, 20);
        middle.add(label);
        
        JButton button_2 = new JButton("新增");
        button_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		String[] rowValues={name.getText(),code.getText(),
        				auth.getText()};
        	model.addRow(rowValues);
        	}
        });
        button_2.setBounds(766, 260, 99, 30);
        middle.add(button_2);
        
             JLabel label_6 = new JLabel("密码");
             label_6.setBounds(748, 183, 66, 15);
             middle.add(label_6);
             
             JLabel label_5 = new JLabel("权限");
             label_5.setBounds(748, 147, 66, 15);
             middle.add(label_5);
             
             JLabel label_4 = new JLabel("账号");
             label_4.setBounds(748, 112, 99, 15);
             middle.add(label_4);
             
             JLabel label_3 = new JLabel("账户名");
             label_3.setBounds(748, 64, 99, 15);
             middle.add(label_3);
             
               JButton button_3 = new JButton("删除");
               button_3.addActionListener(new ActionListener() {
               	public void actionPerformed(ActionEvent e) {
               		int seletedRow=table.getSelectedRow();
	        		if(seletedRow!=-1)
	        			model.removeRow(seletedRow);
               	}
               });
               button_3.setBounds(875, 260, 99, 30);
               middle.add(button_3);
               
               name = new JTextField();
               name.setBounds(827, 58, 133, 28);
               middle.add(name);
               name.setColumns(10);
               
               code = new JTextField();
               code.setBounds(827, 106, 133, 28);
               middle.add(code);
               code.setColumns(10);
               
               auth = new JTextField();
               auth.setBounds(827, 141, 133, 28);
               middle.add(auth);
               auth.setColumns(10);
               
               pass = new JTextField();
               pass.setBounds(824, 177, 133, 28);
               middle.add(pass);
               pass.setColumns(10);
               
               JButton button_4 = new JButton("修改");
               button_4.addActionListener(new ActionListener() {
               	public void actionPerformed(ActionEvent e) {
               		int selectedRow =table.getSelectedRow();
    	        	if(selectedRow!=-1){
    	        		
    	        		model.setValueAt(name.getText(),selectedRow, 1);
    		        	model.setValueAt(code.getText(),selectedRow, 2);
    		        	model.setValueAt(auth.getText(),selectedRow, 3);

               	}
               	}
               });
               button_4.setBounds(1013, 260, 99, 30);
               middle.add(button_4);
               
               JLabel lblNewLabel = new JLabel("");
               lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\SAD\\sec2\\Project\\ExpressSystem\\client\\image\\logo.png"));
               lblNewLabel.setBounds(0, 0, 862, 73);
               contentPane.add(lblNewLabel);
        
      
        
    }  
    
}
