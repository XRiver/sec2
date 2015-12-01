/**
 * 库存盘点界面
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
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;







import presentation.util.FileChoose;
import util.ResultMsg;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanDian extends JPanel {
private JFrame frame;
	/**
	 * Create the panel.
	 */
	public PanDian(JFrame frame) {
		this.frame=frame;
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
	        { "批次批号", "快递编号",  "入库日期", "目的地","存储位置"};  
	  
	        /* 
	         * 初始化JTable里面各项的值 
	         */  
	        Object[][] obj = new Object[1][5];  
	        for (int i = 0; i < 1; i++)  
	        {  
	            for (int j = 0; j < 5; j++)  
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
	               
	                }  
	            }  
	        }  
	          
	          
	        /* 
	         * JTable的其中一种构造方法 
	         */  
	        JTable table = new JTable(obj, columnNames);  
	        /* 
	         * 设置JTable的列默认的宽度和高度 
	         */  
	        TableColumn column = null;  
	        int colunms = table.getColumnCount();  
	        for(int i = 0; i < colunms; i++)  
	        {  
	            column = table.getColumnModel().getColumn(i);  
	            column.setPreferredWidth(200);  
	        }  
	        /* 
	         * 设置JTable自动调整列表的状态，此处设置为关闭 
	         */  
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
	          
	        /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
	        JScrollPane scroll = new JScrollPane(table);  
	        scroll.setLocation(10, 40);
	        scroll.setSize(1095, 272);  
	          
	          
	        add(scroll);  
	        
	        JLabel label = new JLabel("库存盘点");
	        label.setBounds(10, 10, 103, 15);
	        add(label);
	        
	        JButton btnNewButton_3 = new JButton("生成库存快照");
	        btnNewButton_3.setBounds(357, 7, 121, 23);
	        add(btnNewButton_3);
	        
	        JButton btnexcel = new JButton("导出excel");
	        btnexcel.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		new FileChoose();
	        	}
	        });
	        btnexcel.setBounds(521, 6, 93, 23);
	        add(btnexcel);
	        this.setVisible(true);  
	        
	    }  
	    public void paintComponent(Graphics g) {
			 super.paintComponents(g);
			 ImageIcon img = new ImageIcon("image/0111.jpg");
			 g.drawImage(img.getImage(), 0, 0, null);
			}


		


		
}
