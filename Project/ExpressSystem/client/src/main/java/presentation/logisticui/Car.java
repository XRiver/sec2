/**
 * 管理车辆界面
 * 
 * @author wqy
 *
 */
package presentation.logisticui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Car extends JPanel {
	private JTextField textField;
private JTextField code;
private JTextField name;
private JTextField time;
private JTable table;
private DefaultTableModel model;
	/**
	 * Create the panel.
	 */
	public Car() {
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
	        { "车辆代号", "所属机构编号", "首次服役时间"};  
	  
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
	        	time.setText(oc.toString());
	        	
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
	            column.setPreferredWidth(250);  
	        }  
	        /* 
	         * 设置JTable自动调整列表的状态，此处设置为关闭 
	         */  
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
	          
	        /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
	        JScrollPane scroll = new JScrollPane(table);  
	        scroll.setLocation(10, 40);
	        scroll.setSize(663, 272);  
	          
	          
	        add(scroll);
	        this.setVisible(true); 
	        
	        JLabel label = new JLabel("车辆信息管理");
	        label.setBounds(10, 10, 103, 15);
	        add(label);
	        
	        JLabel label_1 = new JLabel("关键字类型");
	        label_1.setBounds(145, 8, 93, 18);
	        add(label_1);
	        
	        JComboBox comboBox = new JComboBox();
	        comboBox.setModel(new DefaultComboBoxModel(new String[] {"车辆代号", "所属机构编号", "首次服役时间"}));
	        comboBox.setBounds(259, 7, 117, 21);
	        add(comboBox);
	        
	        textField = new JTextField();
	        textField.setText("请输入关键字");
	        textField.setBounds(425, 4, 117, 28);
	        add(textField);
	        textField.setColumns(10);
	        
	        JButton button = new JButton("查询");
	        button.setBounds(568, 7, 63, 23);
	        add(button);
	        
	        JButton btnNewButton = new JButton("新增");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		int rowCount=table.getRowCount()+1;
	        		String[] rowValues={rowCount+"",code.getText(),name.getText(),
	        				time.getText()};
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
			        	model.setValueAt(time.getText(),selectedRow, 2);
			        	
	        	}
	        	}
	        });
	        btnNewButton_2.setBounds(930, 352, 70, 23);
	        add(btnNewButton_2);
	        
	        JLabel label_2 = new JLabel("车辆代号");
	        label_2.setBounds(722, 67, 84, 28);
	        add(label_2);
	        
	        JLabel label_3 = new JLabel("所属机构编号");
	        label_3.setBounds(722, 140, 98, 15);
	        add(label_3);
	        
	        JLabel label_4 = new JLabel("首次服役时间");
	        label_4.setBounds(722, 216, 98, 15);
	        add(label_4);
	        
	        code = new JTextField();
	        code.setBounds(830, 68, 170, 28);
	        add(code);
	        code.setColumns(10);
	        
	        name = new JTextField();
	        name.setColumns(10);
	        name.setBounds(830, 134, 170, 28);
	        add(name);
	        
	        time = new JTextField();
	        time.setColumns(10);
	        time.setBounds(830, 210, 170, 28);
	        add(time);
	        
	       
	        
	    }  
	    public void paintComponent(Graphics g) {
			 super.paintComponents(g);
			 ImageIcon img = new ImageIcon("image/0111.jpg");
			 g.drawImage(img.getImage(), 0, 0, null);
			}
}
