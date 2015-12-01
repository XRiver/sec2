package presentation.logisticui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Tempo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Tempo() {
this.setResizable(false);
		JPanel pppp = (JPanel)this.getContentPane();
		// 加载背景图片 
		 ImageIcon img = new ImageIcon("image/0111.jpg");
		JLabel llll=new JLabel(img);
		llll.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
		pppp.setOpaque(false);//最上层透明
			this.getLayeredPane().add(llll,new Integer(Integer.MIN_VALUE));//第二层加图片


			setDefaultCloseOperation(HIDE_ON_CLOSE);



	}
	public void modify(){
		setTitle("修改司机信息");
		setBounds(100, 100, 548, 419);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("司机编号");
		lblNewLabel_2.setBounds(28, 32, 82, 15);
		contentPane.add(lblNewLabel_2);

		textField = new JTextField("001");
		textField.setBounds(120, 29, 162, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("姓名");
		label.setBounds(28, 68, 54, 15);
		contentPane.add(label);

		textField_1 = new JTextField("王翔翔");
		textField_1.setBounds(120, 65, 162, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel label_1 = new JLabel("性别");
		label_1.setBounds(28, 115, 54, 15);
		contentPane.add(label_1);

		textField_2 = new JTextField("男");
		textField_2.setBounds(120, 112, 162, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel = new JLabel("出生日期");
		lblNewLabel.setBounds(28, 161, 82, 15);
		contentPane.add(lblNewLabel);

		textField_3 = new JTextField("2011-11-11");
		textField_3.setBounds(121, 158, 161, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel label_2 = new JLabel("身份证号");
		label_2.setBounds(28, 207, 82, 15);
		contentPane.add(label_2);

		textField_4 = new JTextField("32088888888");
		textField_4.setBounds(120, 204, 162, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel label_3 = new JLabel("手机");
		label_3.setBounds(28, 249, 54, 15);
		contentPane.add(label_3);

		textField_5 = new JTextField("1388888");
		textField_5.setBounds(120, 246, 162, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JLabel label_4 = new JLabel("行驶证期限");
		label_4.setBounds(28, 287, 93, 15);
		contentPane.add(label_4);

		textField_6 = new JTextField("88");
		textField_6.setBounds(120, 284, 162, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		JButton button = new JButton("确认");
		button.setBounds(276, 306, 93, 23);
		contentPane.add(button);
	}
	public void add(){
		setTitle("新增司机");
		setBounds(100, 100, 548, 419);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("司机编号");
		lblNewLabel_2.setBounds(28, 32, 82, 15);
		contentPane.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(120, 29, 162, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("姓名");
		label.setBounds(28, 68, 54, 15);
		contentPane.add(label);

		textField_1 = new JTextField();
		textField_1.setBounds(120, 65, 162, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel label_1 = new JLabel("性别");
		label_1.setBounds(28, 115, 54, 15);
		contentPane.add(label_1);

		textField_2 = new JTextField();
		textField_2.setBounds(120, 112, 162, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel = new JLabel("出生日期");
		lblNewLabel.setBounds(28, 161, 82, 15);
		contentPane.add(lblNewLabel);

		textField_3 = new JTextField();
		textField_3.setBounds(121, 158, 161, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel label_2 = new JLabel("身份证号");
		label_2.setBounds(28, 207, 82, 15);
		contentPane.add(label_2);

		textField_4 = new JTextField();
		textField_4.setBounds(120, 204, 162, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel label_3 = new JLabel("手机");
		label_3.setBounds(28, 249, 54, 15);
		contentPane.add(label_3);

		textField_5 = new JTextField();
		textField_5.setBounds(120, 246, 162, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JLabel label_4 = new JLabel("行驶证期限");
		label_4.setBounds(28, 287, 93, 15);
		contentPane.add(label_4);

		textField_6 = new JTextField();
		textField_6.setBounds(120, 284, 162, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		JButton button = new JButton("确认");
		button.setBounds(276, 306, 93, 23);
		contentPane.add(button);
	}

}
