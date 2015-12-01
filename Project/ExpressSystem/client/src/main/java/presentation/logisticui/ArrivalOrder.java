/**
 * 营业厅到达单界面
 * 
 * @author wqy
 *
 */
package presentation.logisticui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import businesslogicservice.logisticblservice.ArrivalNoteOnServiceBLService;
import businesslogicservice.logisticblservice._Stub.ArrivalNoteOnServiceBLService_Stub;
import util.BarcodeAndState;
import util.ResultMsg;
import util.enums.GoodsState;
import vo.ArrivalNoteOnServiceVO;
import vo.CreditNoteVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class ArrivalOrder extends JPanel {
	ArrivalNoteOnServiceBLService arrive=new ArrivalNoteOnServiceBLService_Stub();
	private JTextField DATA;
	private JTextField FROM;
	private JTextField CODE;
	private JTextField codeee;
	private JTextField dataF;
	private JTextField barcodeF;
	private JTextField fromF;
	private ArrayList<BarcodeAndState> BarcodeAndStates =new ArrayList<BarcodeAndState>();
	private JComboBox state;
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
	private JTextField codeF;
	private JTextField textField;
	private JComboBox typeF;
	/**
	 * Create the panel.
	 */
	public ArrivalOrder() {


		/**
		 * Create the panel.
		 */
		setSize(WIDTH,HEIGHT);
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel label = new JLabel("日期");
		label.setBounds(97, 41, 82, 18);
		add(label);

		DATA = new JTextField();
		DATA.setEnabled(false);
		DATA.setEditable(false);
		DATA.setBounds(189, 37, 87, 28);
		add(DATA);
		DATA.setColumns(10);

		JLabel label_1 = new JLabel("出发地");
		label_1.setBounds(348, 43, 71, 15);
		add(label_1);

		FROM = new JTextField();
		FROM.setEnabled(false);
		FROM.setEditable(false);
		FROM.setBounds(429, 37, 66, 28);
		add(FROM);
		FROM.setColumns(10);

		JLabel lblNewLabel = new JLabel("单据编号");
		lblNewLabel.setBounds(97, 122, 82, 15);
		add(lblNewLabel);

		CODE = new JTextField();
		CODE.setEditable(false);
		CODE.setEnabled(false);
		CODE.setBounds(189, 116, 242, 28);
		add(CODE);
		CODE.setColumns(10);

		JLabel label_6 = new JLabel("货物编码");
		label_6.setBounds(244, 163, 93, 15);
		add(label_6);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(226, 188, 147, -51);
		add(scrollPane);

		JButton btnNewButton = new JButton("提交");
		btnNewButton.setBounds(299, 330, 93, 23);
		btnNewButton.addActionListener(new submitListener());
		add(btnNewButton);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(120, 188, 334, 99);
		add(scrollPane_1);

		codeee = new JTextField();
		codeee.setEditable(false);
		codeee.setEnabled(false);
		scrollPane_1.setViewportView(codeee);
		codeee.setColumns(10);

		JLabel label_7 = new JLabel("日期");
		label_7.setBounds(WIDTHL, 43, 54, 15);
		add(label_7);

		dataF = new JTextField();
		dataF.setBounds(863, 40, 102, 28);
		add(dataF);
		dataF.setColumns(10);

		JLabel label_11 = new JLabel("出发地");
		label_11.setBounds(WIDTHL, 81, 54, 15);
		add(label_11);

		JButton btnNewButton_1 = new JButton("确认");
		btnNewButton_1.setBounds(1025, 223, 93, 23);
		btnNewButton_1.addActionListener(new confirmListener());
		add(btnNewButton_1);

		JLabel label_14 = new JLabel("货物编码");
		label_14.setBounds(787, 265, 66, 15);
		add(label_14);

		barcodeF = new JTextField();
		barcodeF.setBounds(863, 157, 140, 28);
		add(barcodeF);
		barcodeF.setColumns(10);

		JButton button = new JButton("添加");
		button.addActionListener(new addListener());
		button.setBounds(1025, 330, 93, 23);
		add(button);

		fromF = new JTextField();
		fromF.setBounds(863, 78, 102, 28);
		add(fromF);
		fromF.setColumns(10);


		JLabel label_2 = new JLabel("新增到达单");
		label_2.setBounds(10, 0, 102, 15);
		add(label_2);

		JLabel label_3 = new JLabel("单据编号");
		label_3.setBounds(787, 163, 66, 15);
		add(label_3);

		codeF = new JTextField();
		codeF.setBounds(863, 259, 140, 28);
		add(codeF);
		codeF.setColumns(10);

		JLabel label_5 = new JLabel("货物状态");
		label_5.setBounds(787, 308, 76, 15);
		add(label_5);

		state = new JComboBox();
		state.setModel(new DefaultComboBoxModel(new String[] {"完整", "损坏", "丢失"}));
		state.setBounds(873, 305, 130, 21);
		add(state);
		
		JLabel label_4 = new JLabel("编号类型");
		label_4.setBounds(787, 125, 66, 15);
		add(label_4);
		
		 typeF = new JComboBox();
		typeF.setModel(new DefaultComboBoxModel(new String[] {"中转单编号", "汽运编号"}));
		typeF.setBounds(863, 119, 102, 21);
		add(typeF);
		
		JLabel lblNewLabel_1 = new JLabel("编号类型");
		lblNewLabel_1.setBounds(97, 81, 82, 15);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setBounds(189, 81, 87, 28);
		add(textField);
		textField.setColumns(10);



	}
	public class confirmListener implements ActionListener{

		ArrivalNoteOnServiceVO  vo=null;
		//初始化顺序问题
		Boolean isT;
		public void actionPerformed(ActionEvent arg0) {
			if(typeF.getSelectedIndex()==0)
				isT=false;
			else isT=true;
			vo=new ArrivalNoteOnServiceVO (dataF.getText(),isT, codeF.getText(),fromF.getText(),  BarcodeAndStates);
			
			ResultMsg result=arrive.inputHallArrivalDoc(vo);
			if(result.isPass()){//格式检查正确
			DATA.setText(dataF.getText());
			CODE.setText(barcodeF.getText());
			FROM.setText(fromF.getText());
			textField.setText(typeF.getSelectedItem().toString());
			}
			else{//格式有误
				int result1 = JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

				}
		
			
		}
	}
	public class addListener implements ActionListener{
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
