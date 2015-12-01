package presentation.logisticui;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.Font;

import javax.swing.border.EtchedBorder;

import java.awt.Color;

import javax.swing.JButton;

import presentation.util.SubmitDialog;
import presentation.util.checkstyleDialog;
import util.ResultMsg;
import util.SendDocMsg;
import util.enums.DeliverCategory;
import vo.DeliveryNoteVO;
import businesslogicservice.logisticblservice.DeliveryNoteInputBLService;
import businesslogicservice.logisticblservice._Stub.DeliveryNoteInputBLService_Stub;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MailOrderPanel extends JPanel {
	
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1152;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 446;
	private JTextField receiveName;
	private JTextField receiveAddress;
	private JTextField receivePho;
	private JTextField senderAddress;
	private JTextField name;
	private JTextField weight;
	private JTextField goodsnum;
	private JTextField volum;
	private JTextField money;
	private JTextField predate;
	private DeliveryNoteInputBLService service;
	private JTextField senderPho;
	private JTextField barcode;
	private ResultMsg res;
	private SendDocMsg sdm;
	private DeliverCategory deliverCategory;
    private  JComboBox category;
    private double packprice;
    private JComboBox pack;
    private SubmitDialog sd;
    private DeliveryNoteVO sendDocVO;
    private JTextField senderName;
	/**
	 * Create the panel.
	 */
	
	public void paintComponent(Graphics g) {
		 super.paintComponents(g);
		 ImageIcon img = new ImageIcon("image/0011.jpg");
		g.drawImage(img.getImage(), 0, 0, null);
		 float lineWidth = 3.0f;
	     ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
	      g.drawLine(768, 0, 768, 500);
		}
	
	public MailOrderPanel() {
		setSize(WIDTH,HEIGHT);
		setLayout(null);
		
		JLabel label = new JLabel("收件人姓名");
		label.setBounds(70, 39, 84, 16);
		add(label);
		
		receiveName = new JTextField();
		receiveName.setBounds(218, 33, 150, 28);
		add(receiveName);
		receiveName.setColumns(10);
		
		JLabel label_1 = new JLabel("收件地址");
		label_1.setBounds(70, 88, 61, 16);
		add(label_1);
		
		receiveAddress = new JTextField();
		receiveAddress.setBounds(218, 82, 150, 28);
		add(receiveAddress);
		receiveAddress.setColumns(10);
		
		JLabel label_2 = new JLabel("收件人电话");
		label_2.setBounds(70, 138, 71, 16);
		add(label_2);
		
		receivePho = new JTextField();
		receivePho.setBounds(218, 132, 150, 28);
		add(receivePho);
		receivePho.setColumns(10);
		
		JLabel label_3 = new JLabel("寄件人姓名");
		label_3.setBounds(70, 185, 97, 16);
		add(label_3);
		
		JLabel label_4 = new JLabel("件数");
		label_4.setBounds(70, 364, 61, 16);
		add(label_4);
		
		senderAddress = new JTextField();
		senderAddress.setBounds(218, 223, 150, 28);
		add(senderAddress);
		senderAddress.setColumns(10);
		
		JLabel label_5 = new JLabel("货物名称");
		label_5.setBounds(70, 319, 61, 16);
		add(label_5);
		
		name = new JTextField();
		name.setBounds(218, 313, 150, 28);
		add(name);
		name.setColumns(10);
		
		JLabel label_6 = new JLabel("重量");
		label_6.setBounds(462, 138, 61, 16);
		add(label_6);
		
		weight = new JTextField();
		weight.setBounds(561, 138, 150, 28);
		add(weight);
		weight.setColumns(10);
		
		JLabel label_7 = new JLabel("以千克为计量单位");
		label_7.setBounds(571, 165, 112, 16);
		label_7.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		add(label_7);
		
		JLabel lblNewLabel = new JLabel("条形码");
		lblNewLabel.setBounds(462, 240, 61, 16);
		add(lblNewLabel);
		
		goodsnum = new JTextField();
		goodsnum.setText("1");
		goodsnum.setBounds(218, 358, 150, 28);
		add(goodsnum);
		goodsnum.setColumns(10);
		
		JLabel label_8 = new JLabel("包装方式");
		label_8.setBounds(462, 39, 61, 16);
		add(label_8);
		
		String[] packway = {"快递袋","纸箱","木箱"};
		pack = new JComboBox(packway);
		pack.setBounds(561, 35, 150, 27);
		add(pack);
		
		
		JLabel lblNewLabel_1 = new JLabel("快递种类");
		lblNewLabel_1.setBounds(462, 88, 61, 16);
		add(lblNewLabel_1);
		
		String[] expressType = {"经济快递","标准快递","特快专递"};
		 category = new JComboBox(expressType);
		category.setBounds(561, 84, 150, 27);
		add(category);
		
		JLabel label_9 = new JLabel("体积");
		label_9.setBounds(462, 185, 61, 16);
		add(label_9);
		
		volum = new JTextField();
		volum.setBounds(561, 185, 150, 28);
		add(volum);
		volum.setColumns(10);
		
		JLabel label_10 = new JLabel("以立方米为计量单位");
		label_10.setBounds(571, 210, 112, 16);
		label_10.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		add(label_10);
		
		if(category.getSelectedItem().equals("经济快递"))
			deliverCategory = deliverCategory.ECNOMIC;
		else if(category.getSelectedItem().equals("标准快递"))
			deliverCategory = deliverCategory.NORMAL;
		else 
			deliverCategory = deliverCategory.EXPRESS;
		
		if(pack.getSelectedItem().equals("快递袋"))
			packprice = 1;
		else if(pack.getSelectedItem().equals("纸箱"))
			packprice = 5;
		else
			packprice = 10;
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service = new DeliveryNoteInputBLService_Stub();						
			            sendDocVO = new DeliveryNoteVO(senderName.getText(),senderAddress.getText(),
						senderPho.getText(),receiveName.getText(),receiveAddress.getText(),receivePho.getText(),
						name.getText(),Integer.parseInt(goodsnum.getText()),Double.parseDouble(weight.getText()),
						Double.parseDouble(volum.getText()),deliverCategory,packprice,barcode.getText());
			            
				res = service.inputSendDoc(sendDocVO);
				if(res.isPass()){
					    sd = new SubmitDialog();
					    sd.setVisible(true);
						sd.getOK().addActionListener(new  ActionListener(){
     
							@Override
							public void actionPerformed(ActionEvent e) {
								sdm = service.submitSendDoc(sendDocVO);
								String price = sdm.getPrice()+"";
								money.setText(price);
								predate.setText(sdm.getPredectedDate());
								sd.setVisible(false);								
							}
							
						});
				}else{
					checkstyleDialog checkstyle = new checkstyleDialog(res.getMessage());
					checkstyle.setVisible(true);
				}
				
				
				
			}
		});
		btnNewButton.setBounds(584, 355, 132, 59);
		add(btnNewButton);
		
		JLabel label_11 = new JLabel("寄件价格：");
		label_11.setBounds(896, 39, 82, 16);
		add(label_11);
		
		money = new JTextField();
		money.setBounds(977, 33, 134, 28);
		add(money);
		money.setBackground(Color.LIGHT_GRAY);
		money.setEditable(false);
		money.setEnabled(false);
		money.setColumns(10);
		
		JLabel label_13 = new JLabel("请输入完整的单据信息");
		label_13.setBounds(987, 67, 134, 16);
		add(label_13);
		
		JLabel label_12 = new JLabel("预计到达时间");
		label_12.setBounds(896, 138, 82, 16);
		add(label_12);
		
		predate = new JTextField();
		predate.setBounds(977, 132, 134, 28);
		add(predate);
		predate.setBackground(Color.LIGHT_GRAY);
		predate.setEnabled(false);
		predate.setEditable(false);
		predate.setColumns(10);
		
		JLabel label_14 = new JLabel("请输入完整的单据信息");
		label_14.setBounds(987, 164, 134, 16);
		add(label_14);
		
		JLabel label_15 = new JLabel("寄件人地址");
		label_15.setBounds(70, 229, 84, 16);
		add(label_15);
		
		JLabel label_16 = new JLabel("寄件人电话");
		label_16.setBounds(70, 271, 84, 16);
		add(label_16);
		
		senderPho = new JTextField();
		senderPho.setBounds(218, 267, 150, 28);
		add(senderPho);
		senderPho.setColumns(10);
		
		barcode = new JTextField();
		barcode.setBounds(561, 234, 150, 28);
		add(barcode);
		barcode.setColumns(10);
		
		senderName = new JTextField();
		senderName.setBounds(218, 179, 150, 28);
		add(senderName);
		senderName.setColumns(10);
		
		

	}
}
