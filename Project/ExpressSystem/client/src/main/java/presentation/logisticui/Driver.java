/**
 * 管理司机界面
 * 
 * @author wqy
 *
 */
package presentation.logisticui;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class Driver extends JPanel {
	private JTextField textField;
private JTextField code;
private JTextField name;
private JTextField sex;
private JTextField birth;
private JTextField id;
private JTextField phone;
private JTextField qixian;
private JTable table;
private DefaultTableModel model;
	/**
	 * Create the panel.
	 */
	public Driver() {
		setSize(1152,446);
		setLayout(null);
		intiComponent();
	}
	
	  
	    /** 
	     * 初始化窗体组件 
	     */  
	    private void intiComponent()    {  
	        /* 
	         * 设置JTable的列名 
	         */  
	        String[] columnNames =  
	        { "司机编号", "姓名", "性别", "出生日期", "身份证号","手机" ,"行驶证期限"};  
	  
	        /* 
	         * 初始化JTable里面各项的值 
	         */  
	        Object[][] obj = new Object[1][7];  
	        for (int i = 0; i < 1; i++)  
	        {  
	            for (int j = 0; j < 7; j++)  
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
	                case 3:  
	                    obj[i][j] = "2011-11-11";  
	                    break;  
	                case 4:  
	                    obj[i][j] = "32088888888";  
	                    break;  
	                case 5:  
	                    obj[i][j] = "1388888";  
	                    break;  
	                case 6:  
	                    obj[i][j] = "88";  
	                    break; 
	                }  
	            }  
	        }  
	          
	          
	        /* 
	         * JTable的其中一种构造方法 
	         */  
	        model=new DefaultTableModel(obj,columnNames);
	        table = new JTable(model);
	        table.addMouseListener(new MouseAdapter() {
	        	public void mouseClicked(MouseEvent arg0) {
	        	int selectedRow= table.getSelectedRow();
	        	Object oa=model.getValueAt(selectedRow, 0);
	        	code.setText(oa.toString());
	        	Object ob=model.getValueAt(selectedRow, 1);
	        	name.setText(ob.toString());
	        	Object oc=model.getValueAt(selectedRow, 2);
	        	sex.setText(oc.toString());
	        	Object od=model.getValueAt(selectedRow, 3);
	        	birth.setText(od.toString());
	        	Object oe=model.getValueAt(selectedRow, 4);
	        	id.setText(oe.toString());
	        	Object of=model.getValueAt(selectedRow, 5);
	        	phone.setText(of.toString());
	        	Object og=model.getValueAt(selectedRow, 6);
	        	qixian.setText(og.toString());
	        	}
	        });
	        /* 
	         * 设置JTable的列默认的宽度和高度 
	         */  
	        TableColumn column = null;  
	        int colunms = table.getColumnCount();  
	        for(int i = 0; i < colunms; i++)  
	        {  
	            column = table.getColumnModel().getColumn(i);  
	            /*将每一列的默认宽度设置为100*/  
	            column.setPreferredWidth(100);  
	        }  
	        /* 
	         * 设置JTable自动调整列表的状态，此处设置为关闭 
	         */  
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
	          
	        /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
	        JScrollPane scroll = new JScrollPane(table);  
	        scroll.setLocation(10, 40);
	        scroll.setSize(590, 272);  
	          
	          
	        add(scroll);
	        this.setVisible(true); 
	        
	        JLabel label = new JLabel("司机信息管理");
	        label.setBounds(10, 10, 103, 15);
	        add(label);
	        
	        JLabel label_1 = new JLabel("关键字类型");
	        label_1.setBounds(159, 8, 93, 18);
	        add(label_1);
	        
	        JComboBox comboBox = new JComboBox();
	        comboBox.setModel(new DefaultComboBoxModel(new String[] {"司机编号", "姓名", "性别", "出生日期", "身份证号", "手机", "行驶证期限"}));
	        comboBox.setBounds(262, 7, 123, 21);
	        add(comboBox);
	        
	        textField = new JTextField();
	        textField.setText("请输入关键字");
	        textField.setBounds(410, 2, 117, 28);
	        add(textField);
	        textField.setColumns(10);
	        
	        JButton button = new JButton("查询");
	        button.setBounds(537, 6, 63, 23);
	        add(button);
	        
	        JButton btnNewButton = new JButton("新增");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		int rowCount=table.getRowCount()+1;
	        		String[] rowValues={rowCount+"",code.getText(),name.getText(),
	        				sex.getText(),birth.getText(),id.getText(),
	        				phone.getText(),qixian.getText()};
	        	model.addRow(rowValues);
	        	}
	        });
	        btnNewButton.setBounds(685, 352, 70, 23);
	        add(btnNewButton);
	        
	        JButton btnNewButton_1 = new JButton("删除");
	        btnNewButton_1.setBounds(792, 352, 70, 23);
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        	int seletedRow=table.getSelectedRow();
	        		if(seletedRow!=-1)
	        			model.removeRow(seletedRow);
	        	}
	        });
	        add(btnNewButton_1);
	        
	        JButton btnNewButton_2 = new JButton("修改");
	        btnNewButton_2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		int selectedRow =table.getSelectedRow();
		        	if(selectedRow!=-1){
		        		
		        		model.setValueAt(code.getText(),selectedRow, 0);
			        	model.setValueAt(name.getText(),selectedRow, 1);
			        	model.setValueAt(sex.getText(),selectedRow, 2);
			        	model.setValueAt(birth.getText(),selectedRow, 3);
			        	model.setValueAt(id.getText(),selectedRow, 4);
			        	model.setValueAt(phone.getText(),selectedRow, 5);
			        	model.setValueAt(qixian.getText(),selectedRow, 6);
	        	}
	        	}
	        });
	        btnNewButton_2.setBounds(930, 352, 70, 23);
	        add(btnNewButton_2);
	        
	        JLabel label_2 = new JLabel("司机编号");
	        label_2.setBounds(722, 62, 84, 28);
	        add(label_2);
	        
	        JLabel label_3 = new JLabel("姓名");
	        label_3.setBounds(722, 100, 54, 15);
	        add(label_3);
	        
	        JLabel label_4 = new JLabel("性别");
	        label_4.setBounds(722, 138, 54, 15);
	        add(label_4);
	        
	        JLabel label_5 = new JLabel("出生日期");
	        label_5.setBounds(722, 176, 82, 15);
	        add(label_5);
	        
	        JLabel label_6 = new JLabel("身份证号");
	        label_6.setBounds(722, 214, 82, 15);
	        add(label_6);
	        
	        JLabel label_7 = new JLabel("手机");
	        label_7.setBounds(722, 252, 54, 15);
	        add(label_7);
	        
	        JLabel label_8 = new JLabel("行驶证期限");
	        label_8.setBounds(722, 284, 93, 15);
	        add(label_8);
	        
	        code = new JTextField();
	        code.setBounds(792, 56, 170, 28);
	        add(code);
	        code.setColumns(10);
	        
	        name = new JTextField();
	        name.setColumns(10);
	        name.setBounds(792, 94, 170, 28);
	        add(name);
	        
	        sex = new JTextField();
	        sex.setColumns(10);
	        sex.setBounds(792, 132, 170, 28);
	        add(sex);
	        
	        birth = new JTextField();
	        birth.setColumns(10);
	        birth.setBounds(792, 170, 170, 28);
	        add(birth);
	        
	        id = new JTextField();
	        id.setColumns(10);
	        id.setBounds(792, 208, 170, 28);
	        add(id);
	        
	        phone = new JTextField();
	        phone.setColumns(10);
	        phone.setBounds(792, 246, 170, 28);
	        add(phone);
	        
	        qixian = new JTextField();
	        qixian.setColumns(10);
	        qixian.setBounds(792, 284, 170, 28);
	        add(qixian);
	        
	       
	        
	    }  
	    public void paintComponent(Graphics g) {
			 super.paintComponents(g);
			 ImageIcon img = new ImageIcon("image/0111.jpg");
			 g.drawImage(img.getImage(), 0, 0, null);
			}
}
