package presentation.logisticui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import presentation.util.checkstyleDialog;
import util.BarcodesAndLocation;
import util.ResultMsg;
import util.enums.TransitType;
import vo.TransitNoteOnTransitVO;
import dataservice.logisticdataservice.TransitNoteInputDataService;
import businesslogic.logistic.TransitNoteInput;
import businesslogicservice.logisticblservice.TransitNoteInputBLService;
import businesslogicservice.logisticblservice._Stub.TransitNoteInputBLService_Stub;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

public class TransitNoteInputPanel extends JPanel {
	private JTextField date2;
	private JTextField transitnum2;
	private JTextField loader2;
	private JTextField setout2;
	private JTextField arrival2;
	private JTextField date1;
	private JTextField transitnum1;
	private JTextField loader1;
	private JTextField setout1;
	private JTextField arrival1;
	private JTextField barcode;
	private DefaultTableModel model;
	private Vector name;
	private Vector data;
    private JTable table;
    private TransitType transitNoteType;
    private TransitNoteInputBLService service;
    private TransitNoteInputDataService service1;
    private ResultMsg res;
    private JTextField section;
    private JTextField line;
    private JTextField jiahao;
    private JTextField number;
    private JTextField flightNumber2;
    private JTextField flightNumber1;
    private ArrayList<BarcodesAndLocation> barcodesandLocation = new ArrayList<BarcodesAndLocation>();
    private TransitNoteOnTransitVO transitNoteOnTransitVO;
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1152;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 446;
	private JTextField transitType2;

	/**
	 * Create the panel.
	 */
	
	 public static void main(String[] args){
		JFrame f = new JFrame();
		TransitNoteInputPanel p = new TransitNoteInputPanel();
		p.setVisible(true);
		f.setSize(WIDTH,HEIGHT);
	f.getContentPane().add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public TransitNoteInputPanel() {
		setSize(1152,446);
		setLayout(null);
		
		JLabel label = new JLabel("日期");
		label.setBounds(84, 44, 61, 16);
		add(label);
		
		date2 = new JTextField();
		date2.setEditable(false);
		date2.setBounds(142, 38, 134, 28);
		add(date2);
		date2.setColumns(10);
		
		JLabel label_1 = new JLabel("中转单编号");
		label_1.setBounds(348, 44, 74, 16);
		add(label_1);
		
		transitnum2 = new JTextField();
		transitnum2.setEditable(false);
		transitnum2.setBounds(434, 38, 310, 28);
		add(transitnum2);
		transitnum2.setColumns(10);
		
		JLabel label_2 = new JLabel("监装员");
		label_2.setBounds(84, 115, 61, 16);
		add(label_2);
		
		loader2 = new JTextField();
		loader2.setEditable(false);
		loader2.setBounds(142, 109, 134, 28);
		add(loader2);
		loader2.setColumns(10);
		
		JLabel label_3 = new JLabel("出发地");
		label_3.setBounds(84, 176, 61, 16);
		add(label_3);
		
		setout2 = new JTextField();
		setout2.setEditable(false);
		setout2.setBounds(142, 170, 134, 28);
		add(setout2);
		setout2.setColumns(10);
		
		JLabel label_4 = new JLabel("到达地");
		label_4.setBounds(84, 243, 61, 16);
		add(label_4);
		
		arrival2 = new JTextField();
		arrival2.setEditable(false);
		arrival2.setBounds(142, 237, 134, 28);
		add(arrival2);
		arrival2.setColumns(10);
		
		String[] transitType = {"汽车","火车","飞机"};
		final JComboBox transitType1 = new JComboBox(transitType);
		transitType1.setBounds(891, 176, 78, 27);
		add(transitType1);
		flightNumber1 = new JTextField();
		flightNumber1.setBounds(965, 176, 134, 28);
		add(flightNumber1);
		flightNumber1.setColumns(10);
		
		
		
		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!barcodesandLocation.isEmpty()){
				service = new TransitNoteInputBLService_Stub();
				
					transitNoteOnTransitVO = new TransitNoteOnTransitVO(date2.getText(),transitnum2.getText(),
							flightNumber2.getText(),transitNoteType,setout2.getText(),arrival2.getText(),loader2.getText(),barcodesandLocation);				
				res = service.submitCenterTransitDoc(transitNoteOnTransitVO);
				
				date1.enable(false);
				transitnum1.enable(false);
				flightNumber1.enable(false);
				setout1.enable(false);
				arrival1.enable(false);
				loader1.enable(false);
				barcode.enable(false);
				number.enable(false);
				jiahao.enable(false);
				section.enable(false);
				line.enable(false);
			}else{
				checkstyleDialog checkstyle = new checkstyleDialog("请将中转单填写完整后点击提交");
				checkstyle.setVisible(true);
			}
			}
		});
		button.setBounds(626, 385, 117, 37);
		add(button);
		
		JLabel label_5 = new JLabel("日期");
		label_5.setBounds(818, 44, 61, 16);
		add(label_5);
		
		date1 = new JTextField();
		date1.setColumns(10);
		date1.setBounds(891, 38, 209, 28);
		add(date1);
		
		JLabel lblNewLabel = new JLabel("条形码");
		lblNewLabel.setBounds(818, 295, 61, 16);
		add(lblNewLabel);
		
		JLabel label_6 = new JLabel("中转单编号");
		label_6.setBounds(818, 72, 99, 16);
		add(label_6);
		
		transitnum1 = new JTextField();
		transitnum1.setColumns(10);
		transitnum1.setBounds(891, 66, 209, 28);
		add(transitnum1);
		
		JLabel label_7 = new JLabel("监装员");
		label_7.setBounds(818, 100, 61, 16);
		add(label_7);
		
		loader1 = new JTextField();
		loader1.setColumns(10);
		loader1.setBounds(891, 94, 209, 28);
		add(loader1);
		
		JLabel label_8 = new JLabel("出发地");
		label_8.setBounds(818, 128, 61, 16);
		add(label_8);
		
		JLabel label_9 = new JLabel("到达地");
		label_9.setBounds(818, 156, 61, 16);
		add(label_9);
		
		setout1 = new JTextField();
		setout1.setColumns(10);
		setout1.setBounds(891, 122, 209, 28);
		add(setout1);
		
		arrival1 = new JTextField();
		arrival1.setColumns(10);
		arrival1.setBounds(891, 150, 209, 28);
		add(arrival1);
		
		JButton button_1 = new JButton("确认");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service = new TransitNoteInputBLService_Stub();
				ArrayList<BarcodesAndLocation> mock = new ArrayList<BarcodesAndLocation>();
				 BarcodesAndLocation bal = new  BarcodesAndLocation("1234567890",12,12,12,12);
				 mock.add(bal);
				 
				 if(transitType1.getSelectedItem().equals("汽车"))
					 transitNoteType = transitNoteType.Car;
					else if(transitType1.getSelectedItem().equals("火车"))
						transitNoteType = transitNoteType.Train;
					else
						transitNoteType = transitNoteType.Aircraft;
				 
				 TransitNoteOnTransitVO vo = new TransitNoteOnTransitVO(date1.getText(),transitnum1.getText(),
							flightNumber1.getText(),transitNoteType,setout1.getText(),arrival1.getText(),loader1.getText(),mock);
				 
				 res = service.inputCenterTransitDoc(vo);
				if(res.isPass()){
					date2.setText(date1.getText());
					transitnum2.setText(transitnum1.getText());
					setout2.setText(setout1.getText());
					arrival2.setText(arrival1.getText());
					loader2.setText(loader1.getText());
					transitType2.setText((String)transitType1.getSelectedItem());
					flightNumber2.setText(flightNumber1.getText());
				}else{
					checkstyleDialog checkstyle = new checkstyleDialog(res.getMessage());
					checkstyle.setVisible(true);
				}		
			}
		});
		button_1.setBounds(996, 217, 86, 28);
		add(button_1);
		
		barcode = new JTextField();
		barcode.setColumns(10);
		barcode.setBounds(891, 289, 209, 28);
		add(barcode);
		
		name = new Vector();
		name.add("条形码");
		name.add("区号");
		name.add("排号");
		name.add("架号");
		name.add("位号");
		data = new Vector();
		model = new DefaultTableModel();
		model.setDataVector(data, name);
		table = new JTable(model);
		table.setBounds(328, 92, 369, 281);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(298, 100, 446, 273);
		add(scrollPane);
		
	
		
		JButton button_2 = new JButton("添加");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				service = new TransitNoteInputBLService_Stub();
				ArrayList<BarcodesAndLocation> add = new ArrayList<BarcodesAndLocation>();
				BarcodesAndLocation bal = new BarcodesAndLocation(barcode.getText(),Integer.parseInt(section.getText())
						,Integer.parseInt(line.getText()),Integer.parseInt(jiahao.getText()),Integer.parseInt(number.getText()));
				add.add(bal);
				TransitNoteOnTransitVO vo = new TransitNoteOnTransitVO(date2.getText(),transitnum2.getText(),
						flightNumber2.getText(),transitNoteType,setout2.getText(),arrival2.getText(),loader2.getText(),add);
				res = service.inputCenterTransitDoc(vo);
				if(res.isPass()){
					Vector row  = new Vector();
					row.add(barcode.getText());
					row.add(section.getText());
					row.add(line.getText());
					row.add(jiahao.getText());
					row.add(number.getText());
					data.add(row.clone());
					model.setDataVector(data, name);
					table.setModel(model);
					barcode.setText("");
					section.setText(section.getText());
					line.setText(line.getText());
					jiahao.setText(jiahao.getText());
					number.setText(Integer.parseInt(number.getText())+1+"");
					barcodesandLocation.add(bal);	
				}else{
					checkstyleDialog checkstyle = new checkstyleDialog(res.getMessage());
					checkstyle.setVisible(true);
				}
			
			}
		});
		button_2.setBounds(1006, 394, 86, 28);
		add(button_2);
		
		
		
		
		scrollPane.setViewportView(table);
		
		JLabel label_10 = new JLabel("区号");
		label_10.setBounds(856, 335, 61, 16);
		add(label_10);
		
		section = new JTextField();
		section.setBounds(905, 329, 39, 28);
		add(section);
		section.setColumns(10);
		
		JLabel label_11 = new JLabel("排号");
		label_11.setBounds(996, 333, 61, 16);
		add(label_11);
		
		line = new JTextField();
		line.setBounds(1053, 327, 39, 28);
		add(line);
		line.setColumns(10);
		
		JLabel label_12 = new JLabel("架号");
		label_12.setBounds(856, 370, 61, 16);
		add(label_12);
		
		jiahao = new JTextField();
		jiahao.setBounds(904, 364, 40, 28);
		add(jiahao);
		jiahao.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("位号");
		lblNewLabel_1.setBounds(996, 370, 45, 16);
		add(lblNewLabel_1);
		
		number = new JTextField();
		number.setBounds(1053, 364, 39, 28);
		add(number);
		number.setColumns(10);
		
		JLabel label_13 = new JLabel("运输号");
		label_13.setBounds(84, 289, 117, 28);
		add(label_13);
		
		flightNumber2 = new JTextField();
		flightNumber2.setEditable(false);
		flightNumber2.setEnabled(false);
		flightNumber2.setBounds(142, 289, 134, 28);
		add(flightNumber2);
		flightNumber2.setColumns(10);
		
		JLabel label_14 = new JLabel("运输号");
		label_14.setBounds(818, 182, 88, 16);
		add(label_14);
		
		
		
		
		transitType2 = new JTextField();
		transitType2.setEditable(false);
		transitType2.setEnabled(false);
		transitType2.setBounds(142, 335, 134, 28);
		add(transitType2);
		transitType2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("运输类型");
		lblNewLabel_2.setBounds(69, 341, 61, 16);
		add(lblNewLabel_2);
		
		

	}
	
	public void paintComponent(Graphics g) {
		 super.paintComponents(g);
		 ImageIcon img = new ImageIcon("image/0011.jpg");
		 g.drawImage(img.getImage(), 0, 0, null);
		 float lineWidth = 3.0f;
	      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
	      g.drawLine(768, 0, 768, 500);
		}
	
	public TransitNoteOnTransitVO getVO(){
		return transitNoteOnTransitVO;
	}
}
