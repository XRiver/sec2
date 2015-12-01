/**
 * 出库主界面
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OutOrder extends JPanel {
	private JTextField codef;
	private JTextField dataf;
	private JTextField tof;
	private JComboBox typef;
	private JTextField bianhaof;
	private JTable table;
	private DefaultTableModel model;
	/**
	 * Create the panel.
	 */
	public OutOrder() {
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
	        { "序号", "快递编号", "出库日期", "目的地", "装运形式","中转单编号" };  
	  
	        /* 
	         * 初始化JTable里面各项的值 
	         */  
	        Object[][] obj = new Object[1][6];  
	        for (int i = 0; i < 1; i++)  
	        {  
	            for (int j = 0; j < 6; j++)  
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
	                    obj[i][j] = "铁路";  
	                    break;  
	                case 5:  
	                    obj[i][j] = "1388888";  
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
		        	Object oa=model.getValueAt(selectedRow, 1);
		        	codef.setText(oa.toString());
		        	Object ob=model.getValueAt(selectedRow, 2);
		        	dataf.setText(ob.toString());
		        	Object oc=model.getValueAt(selectedRow, 3);
		        	tof.setText(oc.toString());
		        	Object od=model.getValueAt(selectedRow, 4);
		        	typef.setSelectedItem(od.toString());
		        	Object oE=model.getValueAt(selectedRow, 5);
		        	bianhaof.setText(oE.toString());
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
	        scroll.setSize(630, 272);  
	          
	          
	        add(scroll);  
	        
	        JLabel label = new JLabel("输入出库单");
	        label.setBounds(10, 10, 103, 15);
	        add(label);
	        
	        JButton button_1 = new JButton("提交");
	        button_1.setBounds(550, 359, 93, 23);
	        add(button_1);
	        
	        JLabel label_2 = new JLabel("货物信息");
	        label_2.setBounds(878, 10, 93, 15);
	        add(label_2);
	        
	        JLabel label_3 = new JLabel("快递编号");
	        label_3.setBounds(775, 60, 87, 15);
	        add(label_3);
	        
	        JLabel label_4 = new JLabel("出库日期");
	        label_4.setBounds(775, 111, 87, 15);
	        add(label_4);
	        
	        JLabel label_5 = new JLabel("目的地");
	        label_5.setBounds(775, 153, 87, 15);
	        add(label_5);
	        
	        JButton button_2 = new JButton("加入");
	        button_2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		int rowCount=table.getRowCount()+1;
	        		String[] rowValues={rowCount+"",codef.getText(),dataf.getText(),
	        				tof.getText(),typef.getSelectedItem().toString(),bianhaof.getText()};
	        	model.addRow(rowValues);
	        	}
	        });
	        button_2.setBounds(981, 319, 93, 23);
	        add(button_2);
	        
	        codef = new JTextField();
	        codef.setBounds(850, 54, 127, 28);
	        add(codef);
	        codef.setColumns(10);
	        
	        dataf = new JTextField();
	        dataf.setBounds(850, 105, 127, 28);
	        add(dataf);
	        dataf.setColumns(10);
	        
	        bianhaof = new JTextField();
	        bianhaof.setBounds(878, 247, 185, 28);
	        add(bianhaof);
	        bianhaof.setColumns(10);
	        
	        JLabel lblNewLabel = new JLabel("装运形式");
	        lblNewLabel.setBounds(777, 203, 73, 15);
	        add(lblNewLabel);
	        this.setVisible(true);  
	        
	        
	        String[] orderType = { "铁路", "公路","空运"};
			typef = new JComboBox(orderType);
			typef.setBounds(850, 200, 127, 21);
			typef.insertItemAt("请选择", 0);
			typef.setSelectedIndex(0);
			typef.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
				}
				});
			add(typef);
	        
			

	        String[] orderType1 = { "中转单编号", "汽运编号"};
			JComboBox comboBox1 = new JComboBox(orderType1);
			comboBox1.setBounds(775, 250, 93, 21);
			comboBox1.setSelectedIndex(0);
			comboBox1.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
				}
				});
			add(comboBox1);
			
			tof = new JTextField();
			tof.setBounds(850, 150, 127, 28);
			add(tof);
			tof.setColumns(10);
			
			JButton btnModify = new JButton("modify");
			btnModify.setBounds(878, 319, 93, 23);
			add(btnModify);
			
			JButton btnDelete = new JButton("delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
					int seletedRow=table.getSelectedRow();
	        		if(seletedRow!=-1)
	        			model.removeRow(seletedRow);
				}
			});
			btnDelete.setBounds(775, 319, 93, 23);
			add(btnDelete);
			
	    }  
	    public void paintComponent(Graphics g) {
			 super.paintComponents(g);
			 ImageIcon img = new ImageIcon("image/0111.jpg");
			 g.drawImage(img.getImage(), 0, 0, null);
			}
}
