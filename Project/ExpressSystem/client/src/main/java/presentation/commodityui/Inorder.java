/**
 * 入库主界面
 * 
 * @author wqy
 *
 */
package presentation.commodityui;

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

public class Inorder extends JPanel {
	private JTextField codef;
	private JTextField dataf;
	private JTextField tof;
	private JTextField areaf;
	private JTextField rowf;
	private JTextField jiahaof;
	private JTextField weihaof;
	private JTable table;
	private DefaultTableModel model;
	private JButton button_2;
	/**
	 * Create the panel.
	 */
	public Inorder() {
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
	        { "序号", "快递编号", "入库日期", "目的地", "区号","排号" ,"架号","位号"};  
	  
	        /* 
	         * 初始化JTable里面各项的值 
	         */  
	        Object[][] obj = new Object[1][8];  
	        for (int i = 0; i < 1; i++)  
	        {  
	            for (int j = 0; j < 8; j++)  
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
	                case 7:
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
	        	codef.setText(oa.toString());
	        	Object ob=model.getValueAt(selectedRow, 1);
	        	dataf.setText(ob.toString());
	        	Object oc=model.getValueAt(selectedRow, 2);
	        	tof.setText(oc.toString());
	        	Object od=model.getValueAt(selectedRow, 3);
	        	areaf.setText(od.toString());
	        	Object oe=model.getValueAt(selectedRow, 4);
	        	rowf.setText(oe.toString());
	        	Object of=model.getValueAt(selectedRow, 5);
	        	jiahaof.setText(of.toString());
	        	Object og=model.getValueAt(selectedRow, 6);
	        	weihaof.setText(og.toString());
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
	        scroll.setSize(810, 272);  
	          
	          
	        add(scroll);  
	        
	       
	        
	        
	        JLabel label = new JLabel("输入入库单");
	        label.setBounds(26, 10, 103, 15);
	        add(label);
	        
	        JButton button_1 = new JButton("提交");
	        button_1.setBounds(685, 359, 93, 23);
	        add(button_1);
	        
	        JLabel label_2 = new JLabel("货物信息");
	        label_2.setBounds(950, 10, 103, 15);
	        add(label_2);
	        
	        JLabel varib = new JLabel("快递编号");
	        varib.setBounds(878, 57, 99, 15);
	        add(varib);
	        
	        JLabel label_4 = new JLabel("入库日期");
	        label_4.setBounds(878, 108, 99, 15);
	        add(label_4);
	        
	        JLabel label_5 = new JLabel("目的地");
	        label_5.setBounds(878, 147, 66, 15);
	        add(label_5);
	        
	        JLabel label_6 = new JLabel("区号");
	        label_6.setBounds(878, 189, 54, 15);
	        add(label_6);
	        
	        JLabel label_7 = new JLabel("排号");
	        label_7.setBounds(878, 234, 66, 15);
	        add(label_7);
	        
	        JLabel label_8 = new JLabel("架号");
	        label_8.setBounds(878, 280, 87, 15);
	        add(label_8);
	        
	        JLabel label_9 = new JLabel("位号");
	        label_9.setBounds(878, 316, 87, 15);
	        add(label_9);
	        
	       button_2 = new JButton("加入");
	        button_2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		int rowCount=table.getRowCount()+1;
	        		String[] rowValues={rowCount+"",codef.getText(),dataf.getText(),
	        				tof.getText(),areaf.getText(),rowf.getText(),
	        				jiahaof.getText(),weihaof.getText()};
	        	model.addRow(rowValues);
	        	
	        	}
	        });
	        button_2.setBounds(1063, 380, 66, 23);
	        add(button_2);
	        
	        codef = new JTextField();
	        codef.setBounds(987, 54, 133, 28);
	        add(codef);
	        codef.setColumns(10);
	        
	        dataf = new JTextField();
	        dataf.setBounds(987, 105, 133, 28);
	        add(dataf);
	        dataf.setColumns(10);
	        
	        tof = new JTextField();
	        tof.setBounds(987, 144, 133, 28);
	        add(tof);
	        tof.setColumns(10);
	        
	        areaf = new JTextField();
	        areaf.setBounds(987, 186, 133, 28);
	        add(areaf);
	        areaf.setColumns(10);
	        
	        rowf = new JTextField();
	        rowf.setBounds(987, 231, 133, 28);
	        add(rowf);
	        rowf.setColumns(10);
	        
	        jiahaof = new JTextField();
	        jiahaof.setBounds(987, 277, 133, 28);
	        add(jiahaof);
	        jiahaof.setColumns(10);
	        
	        weihaof = new JTextField();
	        weihaof.setBounds(987, 313, 133, 28);
	        add(weihaof);
	        weihaof.setColumns(10);
	        
	        JButton btnModify = new JButton("MODIFY");
	        btnModify.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        	int selectedRow =table.getSelectedRow();
	        	if(selectedRow!=-1){
	        		
	        		model.setValueAt(selectedRow,selectedRow, 0);
	        		model.setValueAt(codef.getText(),selectedRow, 1);
		        	model.setValueAt(dataf.getText(),selectedRow, 2);
		        	model.setValueAt(tof.getText(),selectedRow, 3);
		        	model.setValueAt(areaf.getText(),selectedRow, 4);
		        	model.setValueAt(rowf.getText(),selectedRow, 5);
		        	model.setValueAt(jiahaof.getText(),selectedRow, 6);
		        	model.setValueAt(weihaof.getText(),selectedRow, 7);
	        	}
	        	
	        	}
	        });
	        btnModify.setBounds(966, 380, 87, 23);
	        add(btnModify);
	        
	        JButton btnNewButton = new JButton("delete");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        	int seletedRow=table.getSelectedRow();
	        		if(seletedRow!=-1)
	        			model.removeRow(seletedRow);
	        	}
	        });
	        btnNewButton.setBounds(851, 380, 93, 23);
	        add(btnNewButton);
	        this.setVisible(true);  
	        
	    }  
	    public void paintComponent(Graphics g) {
			 super.paintComponents(g);
			 ImageIcon img = new ImageIcon("image/0111.jpg");
			 g.drawImage(img.getImage(), 0, 0, null);
			}
}
