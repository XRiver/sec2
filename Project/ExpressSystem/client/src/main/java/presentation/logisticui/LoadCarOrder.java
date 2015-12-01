/**
 * 营业厅装车单界面
 * 
 * @author wqy
 *
 */
package presentation.logisticui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import util.ResultMsg;
import vo.LoadNoteOnServiceVO;
import businesslogicservice.logisticblservice.LoadNoteOnServiceBLService;
import businesslogicservice.logisticblservice._Stub.LoadNoteOnServiceBLService_Stub;

public class LoadCarOrder extends JPanel {
	LoadNoteOnServiceBLService load=new LoadNoteOnServiceBLService_Stub();
	private JTextField data;
	private JTextField service;
	private JTextField to;
	private JTextField scar;
	private JTextField car;
	private JTextField superman;
	private JTextField senderman;
	private JTextField code;
	private JTextField dataf;
	private JTextField servicecodef;
	private JTextField carcodef;
	private JTextField codef;
	private JTextField tof;
	private JTextField scarcodef;
	private JTextField supermanf;
	private JTextField sendmanf;
	private ArrayList<String> barcodes=new  ArrayList<String> ();
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1152;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 446;
	/**
	 * 右边标签
	 */
	private static final int WIDTHL = WIDTH/3*2+19;
	/**
	 * 右边field
	 */
	private static final int WIDTHT = WIDTHL+76;

	/**
	 * Create the panel.
	 */
	public LoadCarOrder() {
		setSize(WIDTH,HEIGHT);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel label = new JLabel("日期");
		label.setBounds(58, 41, 54, 18);
		add(label);
		
		data = new JTextField();
		data.setEnabled(false);
		data.setEditable(false);
		data.setBounds(146, 40, 124, 21);
		add(data);
		data.setColumns(10);
		
		JLabel label_1 = new JLabel("营业厅编号");
		label_1.setBounds(324, 43, 84, 15);
		add(label_1);
		
		service = new JTextField();
		service.setEnabled(false);
		service.setEditable(false);
		service.setBounds(418, 40, 124, 21);
		add(service);
		service.setColumns(10);
		
		JLabel label_2 = new JLabel("目的地");
		label_2.setBounds(58, 96, 54, 15);
		add(label_2);
		
		to = new JTextField();
		to.setEnabled(false);
		to.setEditable(false);
		to.setBounds(146, 94, 286, 18);
		add(to);
		to.setColumns(10);
		
		JLabel label_3 = new JLabel("车辆编号");
		label_3.setBounds(58, 150, 78, 15);
		add(label_3);
		
		scar = new JTextField();
		scar.setEnabled(false);
		scar.setEditable(false);
		scar.setBounds(146, 147, 207, 21);
		add(scar);
		scar.setColumns(10);
		
		JLabel label_4 = new JLabel("汽运编号");
		label_4.setBounds(58, 206, 66, 15);
		add(label_4);
		
		car = new JTextField();
		car.setEnabled(false);
		car.setEditable(false);
		car.setBounds(146, 203, 207, 21);
		add(car);
		car.setColumns(10);
		
		JLabel label_5 = new JLabel("监装员");
		label_5.setBounds(58, 251, 66, 15);
		add(label_5);
		
		superman = new JTextField();
		superman.setEnabled(false);
		superman.setEditable(false);
		superman.setBounds(146, 248, 84, 21);
		add(superman);
		superman.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("押运员");
		lblNewLabel.setBounds(58, 304, 54, 15);
		add(lblNewLabel);
		
		senderman = new JTextField();
		senderman.setEnabled(false);
		senderman.setEditable(false);
		senderman.setBounds(146, 301, 84, 21);
		add(senderman);
		senderman.setColumns(10);
		
		JLabel label_6 = new JLabel("货物编码");
		label_6.setBounds(396, 150, 93, 15);
		add(label_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(226, 188, 147, -51);
		add(scrollPane);
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.setBounds(418, 370, 93, 23);
		add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(376, 188, 224, 99);
		add(scrollPane_1);
		
		code = new JTextField();
		code.setEditable(false);
		code.setEnabled(false);
		scrollPane_1.setViewportView(code);
		code.setColumns(10);
		
		JLabel label_7 = new JLabel("日期");
		label_7.setBounds(WIDTHL, 10, 54, 15);
		add(label_7);
		
		dataf = new JTextField();
		dataf.setBounds(880, 7, 101, 28);
		add(dataf);
		dataf.setColumns(10);
		
		JLabel label_8 = new JLabel("营业厅编号");
		label_8.setBounds(787, 43, 93, 15);
		add(label_8);
		
		servicecodef = new JTextField();
		servicecodef.setBounds(880, 40, 239, 28);
		add(servicecodef);
		servicecodef.setColumns(10);
		
		JLabel label_9 = new JLabel("汽运编号");
		label_9.setBounds(787, 81, 93, 15);
		add(label_9);
		
		carcodef = new JTextField();
		carcodef.setBounds(880, 78, 239, 28);
		add(carcodef);
		carcodef.setColumns(10);
		
		JLabel label_10 = new JLabel("目的地");
		label_10.setBounds(787, 122, 78, 15);
		add(label_10);
		
		JLabel label_11 = new JLabel("车辆编号");
		label_11.setBounds(787, 150, 93, 15);
		add(label_11);
		
		JLabel label_12 = new JLabel("监装员");
		label_12.setBounds(787, 188, 78, 15);
		add(label_12);
		
		JLabel label_13 = new JLabel("押运员");
		label_13.setBounds(787, 226, 78, 15);
		add(label_13);
		
		JButton btnNewButton_1 = new JButton("确认");
		btnNewButton_1.addActionListener(new confirmListener());
		btnNewButton_1.setBounds(995, 247, 93, 23);
		add(btnNewButton_1);
		
		JLabel label_14 = new JLabel("货物编码");
		label_14.setBounds(WIDTHL, 281, 78, 15);
		add(label_14);
		
		codef = new JTextField();
		codef.setBounds(880, 280, 239, 28);
		add(codef);
		codef.setColumns(10);
		
		JButton button = new JButton("添加");
		button.setBounds(970, 315, 93, 23);
		add(button);
		
		tof = new JTextField();
		tof.setBounds(880, 116, 239, 28);
		add(tof);
		tof.setColumns(10);
		
		scarcodef = new JTextField();
		scarcodef.setBounds(880, 150, 239, 28);
		add(scarcodef);
		scarcodef.setColumns(10);
		
		supermanf = new JTextField();
		supermanf.setBounds(880, 185, 101, 28);
		add(supermanf);
		supermanf.setColumns(10);
		
		sendmanf = new JTextField();
		sendmanf.setBounds(880, 223, 101, 28);
		add(sendmanf);
		sendmanf.setColumns(10);
		
		JLabel label_15 = new JLabel("新增装车单");
		label_15.setBounds(28, 10, 84, 15);
		add(label_15);

	}
	public class confirmListener implements ActionListener{

		LoadNoteOnServiceVO  vo=null;
		//初始化顺序问题
		Boolean isT;
		public void actionPerformed(ActionEvent arg0) {
			
			vo=new LoadNoteOnServiceVO (dataf.getText(),servicecodef.getText(),carcodef.getText(),tof.getText(),scarcodef.getText(),supermanf.getText(),sendmanf.getText(),barcodes);
			
			ResultMsg result=load.inputHallLoadDoc(vo);
			if(result.isPass()){//格式检查正确
			data.setText(dataf.getText());
			service.setText(servicecodef.getText());
			to.setText(tof.getText());
			scar.setText(scarcodef.getText());
			car.setText(carcodef.getText());
			superman.setText(supermanf.getText());
			senderman.setText(sendmanf.getText());
			}
			else{//格式有误
				int result1 = JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

				}
		
			
		}
	}
	/*public class addListener implements ActionListener{
		String s="";
		GoodsState state1;
		BarcodeAndState bas;
		public void actionPerformed(ActionEvent e) {
			if(state.getSelectedItem().toString().equals("完整"))
				state1=GoodsState.COMPLETE;
			else if(state.getSelectedItem().toString().equals("损坏"))
				state1=GoodsState.DAMAGED;
			else
				state1=GoodsState.LOST;
			bas=new BarcodeAndState(codeF.getText(),state1);
			s=s+codeF.getText()+"状态："+state.getSelectedItem().toString()+"\r\n";
			codeee.setText(s);
			codeF.setText("");
			BarcodeAndStates.add(bas);
		}


	}
	public class submitListener implements ActionListener{
		ArrivalNoteOnServiceVO  vo=null;


		public void actionPerformed(ActionEvent e) {
			vo=new ArrivalNoteOnServiceVO (dataF.getText(),true, codeF.getText(),fromF.getText(),  BarcodeAndStates);
			int result = JOptionPane.showConfirmDialog(null, "确认提交审批？","系统提示",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.YES_OPTION) {
				arrive.submitHallArrivalDoc(vo);

			}
			else {
				return;

			}

		}
	}*/
	public void paintComponent(Graphics g) {
		 super.paintComponents(g);
		 ImageIcon img = new ImageIcon("image/0111.jpg");
		 g.drawImage(img.getImage(), 0, 0, null);
		 float lineWidth = 3.0f;
	      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
	      g.drawLine(WIDTH/3*2, 0, WIDTH/3*2, HEIGHT);
		}
}
