package presentation.mainui;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import util.enums.GoodsState;
import vo.OrderVO;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class clientInquiryPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1280;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 720;
	private JTable table;
	private DefaultTableModel model;
	private Vector name;
	private Vector data;
	private JButton btnNewButton;
	
	public clientInquiryPanel(OrderVO vo) {
		setSize(WIDTH,HEIGHT);
		setLayout(null);
		
		
		name = new Vector();
		name.add("时间");
		name.add("物流信息");
		data = new Vector();
		model = new DefaultTableModel();
		model.setDataVector(data,name);
		table = new JTable(model);
		table.setBounds(219, 139, 748, 392);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(222, 158, 826, 328);
		add(scrollPane);
		
	    btnNewButton = new JButton("返回");
		btnNewButton.setBounds(928, 510, 120, 43);
		add(btnNewButton);
		
		//显示vo信息了
		Vector row = new Vector();
		ArrayList<String> history = new ArrayList<String>();
		history = vo.getHistory();
		if(history.isEmpty()){
			row.add("暂无跟踪记录");
			data.add(row.clone());
			row.clear();
			model.setDataVector(data, name);
			table.setModel(model);
			
		}else{
			
		for(int i = 0;i<history.size();i++){
			String[] s = history.get(i).split(" ");
			GoodsState state = vo.getStateOfTransport();
			String historystate = s[1];
			row.add(s[0]);
			row.add(historystate);
			data.add(row.clone());
			row.clear();
			model.setDataVector(data, name);
			table.setModel(model);
			//这里假设history货运状态以“时间＋“ ”＋历史轨迹形式
		}
		}
		

	}
	
	public JButton getButton(){
		return btnNewButton;
	}
	
	
	public void paintComponent(Graphics g) {
		 super.paintComponents(g);		
		 Image img = new ImageIcon("image/chaxun1.png").getImage();
		 g.drawImage(img,0,0,getSize().width,getSize().height,null);
		 g.drawImage(img, 0, 0, null);
		}
	


}
