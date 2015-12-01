/**
 * 营业厅派送单界面
 * 
 * @author wqy
 *
 */
package presentation.logisticui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import util.ResultMsg;
import vo.DeliverNoteOnServiceVO;
import businesslogicservice.logisticblservice.ArrivalNoteOnServiceBLService;
import businesslogicservice.logisticblservice._Stub.ArrivalNoteOnServiceBLService_Stub;

public class SendOrder extends JPanel {
	private JTextField data;
	private JTextField sender;
	private JTextField textField_7;
	private JTextField dataf;
	private JTextField textField_11;
	private JTextField senderf;
	private ArrayList<String> BarCode=new ArrayList<String>();
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1152;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 446;
	/**
	 * Create the panel.
	 */
	ArrivalNoteOnServiceBLService arr=new ArrivalNoteOnServiceBLService_Stub();
	private JTextField sendcode;
	private JTextField sendcodef;
	public SendOrder() {
		setSize(WIDTH,HEIGHT);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel label = new JLabel("日期");
		label.setBounds(76, 41, 75, 18);
		add(label);
		
		data = new JTextField();
		data.setEnabled(false);
		data.setEditable(false);
		data.setBounds(161, 37, 123, 28);
		add(data);
		data.setColumns(10);
		
		JLabel label_4 = new JLabel("派件员");
		label_4.setBounds(76, 81, 93, 15);
		add(label_4);
		
		sender = new JTextField();
		sender.setEnabled(false);
		sender.setEditable(false);
		sender.setBounds(161, 75, 123, 28);
		add(sender);
		sender.setColumns(10);
		
		JLabel label_6 = new JLabel("货物编码");
		label_6.setBounds(150, 163, 93, 15);
		add(label_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(226, 188, 147, -51);
		add(scrollPane);
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.setBounds(278, 304, 93, 23);
		add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(58, 188, 334, 99);
		add(scrollPane_1);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setEnabled(false);
		scrollPane_1.setViewportView(textField_7);
		textField_7.setColumns(10);
		
		JLabel label_7 = new JLabel("日期");
		label_7.setBounds(787, 43, 54, 15);
		add(label_7);
		
		dataf = new JTextField();
		dataf.setBounds(863, 40, 159, 28);
		add(dataf);
		dataf.setColumns(10);
		
		JLabel label_13 = new JLabel("派件员");
		label_13.setBounds(787, 132, 82, 15);
		add(label_13);
		
		JButton btnNewButton_1 = new JButton("确认");
		btnNewButton_1.addActionListener(new confirmListener());
		btnNewButton_1.setBounds(953, 174, 93, 23);
		add(btnNewButton_1);
		
		JLabel label_14 = new JLabel("货物编码");
		label_14.setBounds(787, 247, 66, 15);
		add(label_14);
		
		textField_11 = new JTextField();
		textField_11.setBounds(863, 244, 194, 28);
		add(textField_11);
		textField_11.setColumns(10);
		
		JButton button = new JButton("添加");
		button.setBounds(964, 304, 93, 23);
		add(button);
		
	
		
		JLabel label_2 = new JLabel("新增派送单");
		label_2.setBounds(10, 0, 102, 15);
		add(label_2);
		
		senderf = new JTextField();
		senderf.setBounds(863, 129, 159, 28);
		add(senderf);
		senderf.setColumns(10);
		
		JLabel label_1 = new JLabel("派件单编号");
		label_1.setBounds(331, 43, 93, 15);
		add(label_1);
		
		sendcode = new JTextField();
		sendcode.setEnabled(false);
		sendcode.setEditable(false);
		sendcode.setBounds(419, 37, 123, 28);
		add(sendcode);
		sendcode.setColumns(10);
		
		JLabel label_3 = new JLabel("派件单编号");
		label_3.setBounds(775, 81, 94, 15);
		add(label_3);
		
		sendcodef = new JTextField();
		sendcodef.setBounds(863, 78, 159, 28);
		add(sendcodef);
		sendcodef.setColumns(10);

	
	}
	public class confirmListener implements ActionListener{
		DeliverNoteOnServiceVO vo=null;
		public void actionPerformed(ActionEvent e) {
			vo=new DeliverNoteOnServiceVO(sendcodef.getText(),dataf.getText(),BarCode,senderf.getText());
			ResultMsg result=arr.inputHallDeliverDoc(vo);
			if(result.isPass()){//格式检查正确
				sendcode.setText(sendcodef.getText());
			data.setText(dataf.getText());
			sender.setText(senderf.getText());
			}
			else{//格式有误
				int result1 = JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

				}
		}
		
	}
	public void paintComponent(Graphics g) {
		 super.paintComponents(g);
		 ImageIcon img = new ImageIcon("image/0111.jpg");
		 g.drawImage(img.getImage(), 0, 0, null);
		 float lineWidth = 3.0f;
	      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
	      g.drawLine(WIDTH/3*2, 0, WIDTH/3*2, HEIGHT);
		}
}
