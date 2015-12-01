package presentation.logisticui;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import presentation.financeui.PaymentInputPanel;
import presentation.util.checkstyleDialog;
import util.BarcodeAndState;
import util.ResultMsg;
import util.enums.GoodsState;
import vo.ArrivalNoteOnTransitVO;

import javax.swing.JTextArea;

import businesslogicservice.logisticblservice.ArrivalNoteOnTransitBLService;
import businesslogicservice.logisticblservice._Stub.ArrivalNoteOnTransitBLService_Stub;

import java.awt.SystemColor;

public class ArrivalNoteOnTransitPanel extends JPanel {
	private JTextField centrenum1;
	private JTextField date1;
	private JTextField barcode;
	private JTextField departure1;
	private JTextField trannum1;
	private ArrivalNoteOnTransitBLService service;
	private BarcodeAndState brcodeAndState;
	private ResultMsg res;
	private JTextField date2;
	private JTextField centrenum2;
	private JTable table;
	private DefaultTableModel model;
	private Vector name;
	private Vector data;
	private JTextField departure2;
	private JTextField trannum2;
	private ArrivalNoteOnTransitVO arrivalNoteOnTransitVO;
	private ArrayList<BarcodeAndState> barcodeAndStates = new ArrayList<BarcodeAndState>();
	/**
	 * Create the panel.
	 */
	
	 public static void main(String[] args){
		JFrame f = new JFrame();
		ArrivalNoteOnTransitPanel p = new ArrivalNoteOnTransitPanel();
		p.setVisible(true);
		f.setSize(1150,444);
	f.getContentPane().add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public ArrivalNoteOnTransitPanel() {
		setBackground(SystemColor.window);
		setSize(1152,446);									
	    setLayout(null);
	    JLabel lblNewLabel = new JLabel("到达日期");
	    lblNewLabel.setBounds(852, 39, 78, 16);
		add(lblNewLabel);
												
												
		date1 = new JTextField();
		date1.setBounds(970, 32, 156, 30);
		add(date1);
												
		date1.setColumns(10);
												
		JLabel lblNewLabel_1 = new JLabel("中转中心编号");
		lblNewLabel_1.setBounds(852, 88, 106, 16);
		add(lblNewLabel_1);
												
												
		centrenum1= new JTextField();
		centrenum1.setBounds(970, 81, 156, 30);
		add(centrenum1);										
	    centrenum1.setColumns(10);
												
	    JButton btnNewButton = new JButton("确认");
	    btnNewButton.setBounds(1009, 222, 117, 30);
		add(btnNewButton);	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<BarcodeAndState> bas = new ArrayList<BarcodeAndState>();
				BarcodeAndState mock = new BarcodeAndState("1234567890",GoodsState.COMPLETE);
				bas.add(mock);
				ArrivalNoteOnTransitVO vo = new ArrivalNoteOnTransitVO(trannum1.getText(),centrenum1.getText(),date1.getText(),
						departure1.getText(),bas);
				service = new ArrivalNoteOnTransitBLService_Stub();
				//格式检查
			    res = service.inputCenterArrivalDoc(vo);
				//正确则信息填入那边
				if(res.isPass()){
					date2.setText(date1.getText());
					centrenum2.setText(centrenum1.getText());
					trannum2.setText(trannum1.getText());
					departure2.setText(departure1.getText());
				}
				else{
					checkstyleDialog checkstyle = new checkstyleDialog(res.getMessage());
					checkstyle.setVisible(true);
			}
			}
		});
												
        JLabel label = new JLabel("条形码");
        label.setBounds(852, 297, 78, 16);
		add(label);
												
		
		barcode = new JTextField();
		barcode.setBounds(970, 290, 156, 30);
		add(barcode);
		barcode.setColumns(10);
		
		JLabel departture = new JLabel("出发地");
		departture.setBounds(852, 133, 78, 16);
        add(departture);
															
        JLabel label_2 = new JLabel("中转单编号");
        label_2.setBounds(852, 178, 106, 16);
		add(label_2);
		
		JLabel label_1 = new JLabel("货运状态");
		label_1.setBounds(852, 345, 78, 16);
		add(label_1);
		String[] state = {"完好","缺损","丢失"};
		final JComboBox comboBox = new JComboBox(state);
		comboBox.setBounds(970, 341, 156, 27);
		comboBox.setBackground(SystemColor.textHighlight);
		add(comboBox);
																
		departure1 = new JTextField();
		departure1.setBounds(970, 126, 156, 30);
		add(departure1);
	    departure1.setColumns(10);													
																		
	    trannum1 = new JTextField();
	    trannum1.setBounds(970, 171, 156, 30);
		add(trannum1);
		trannum1.setColumns(10);
			
			JButton button = new JButton("添加");
			button.setBounds(1009, 390, 117, 30);
			add(button);
			
			JLabel arrivaldateLabel = new JLabel("到达日期");
			arrivaldateLabel.setBounds(44, 73, 61, 16);
			add(arrivaldateLabel);
			
			date2 = new JTextField();
			date2.setEditable(false);
			date2.setBounds(145, 67, 180, 28);
			add(date2);
			date2.setColumns(10);
			
			JLabel centerNum = new JLabel("中转中心编号");
			centerNum.setBounds(44, 151, 89, 16);
			add(centerNum);
			
			centrenum2 = new JTextField();
			centrenum2.setEditable(false);
			centrenum2.setBounds(145, 145, 180, 28);
			add(centrenum2);
			centrenum2.setColumns(10);
					
			name = new Vector();
			name.add("条形码");
			name.add("货运状态");
			data = new Vector();
			model = new DefaultTableModel();
			model.setDataVector(data,name);
			table = new JTable(model);
			table.setBounds(367, 72, 371, 272);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(367, 72, 371, 272);
			add(scrollPane);
			
			
			JButton button_1 = new JButton("提交");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!barcodeAndStates.isEmpty()){
					arrivalNoteOnTransitVO = new ArrivalNoteOnTransitVO(trannum2.getText(),centrenum2.getText(),date2.getText(),
							departure2.getText(), barcodeAndStates);
					res = service.submitCenterArrivalDoc(arrivalNoteOnTransitVO);
					date1.enable(false);
					centrenum1.enable(false);
					trannum1.enable(false);
					departure1.enable(false);
					barcode.enable(false);
					comboBox.enable(false);
					
					if(res.isPass()){
					}	
					}else{
						checkstyleDialog checkstyle = new checkstyleDialog("请将到达单填写完整后点击提交");
						checkstyle.setVisible(true);
					}
					
				}
			});
			button_1.setBounds(591, 391, 117, 29);
			add(button_1);
			
			JLabel label_3 = new JLabel("出发地");
			label_3.setBounds(44, 228, 61, 16);
			add(label_3);
			
			departure2 = new JTextField();
			departure2.setEditable(false);
			departure2.setBounds(145, 222, 180, 28);
			add(departure2);
			departure2.setColumns(10);
			
			JLabel label_4 = new JLabel("中转单编号");
			label_4.setBounds(44, 297, 75, 16);
			add(label_4);
			
			trannum2 = new JTextField();
			trannum2.setEditable(false);
			trannum2.setBounds(145, 291, 180, 28);
			add(trannum2);
			trannum2.setColumns(10);
			
			
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<BarcodeAndState> bas = new ArrayList<BarcodeAndState>();
					
					if(comboBox.getSelectedItem().equals("完整"))
					    brcodeAndState = new BarcodeAndState(barcode.getText(),GoodsState.COMPLETE);
					else if(comboBox.getSelectedItem().equals("缺损"))
						brcodeAndState = new BarcodeAndState(barcode.getText(),GoodsState.DAMAGED);
					else
						brcodeAndState = new BarcodeAndState(barcode.getText(),GoodsState.LOST);
					bas.add(brcodeAndState);
					
					ArrivalNoteOnTransitVO vo = new ArrivalNoteOnTransitVO(trannum2.getText(),centrenum2.getText(),date2.getText(),
							departure2.getText(),bas);
					
					res = service.inputCenterArrivalDoc(vo);
					if(res.isPass()){
						Vector row = new Vector();
						row.add(barcode.getText());
						row.add(comboBox.getSelectedItem());
						data.add(row.clone());
						model.setDataVector(data, name);
						table.setModel(model);	
						barcode.setText("");
						trannum1.setText("");
						departure1.setText("");
						barcodeAndStates.add( brcodeAndState);		
					}else{
						checkstyleDialog checkstyle = new checkstyleDialog(res.getMessage());
						checkstyle.setVisible(true);
					}
					
				}
			});	
																	
	}
	public void paintComponent(Graphics g) {
		 super.paintComponents(g);
		 ImageIcon img = new ImageIcon("image/0011.jpg");
		g.drawImage(img.getImage(), 0, 0, null);
		 float lineWidth = 3.0f;
	      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
	      g.drawLine(768, 0, 768, 500);
		}
	
	public ArrivalNoteOnTransitVO getVO(){
		return arrivalNoteOnTransitVO;
	}
}
	
	


