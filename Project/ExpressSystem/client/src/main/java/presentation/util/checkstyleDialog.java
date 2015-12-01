package presentation.util;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class checkstyleDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 450;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 300;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			checkstyleDialog dialog = new checkstyleDialog("hh");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public checkstyleDialog(String errors) {
		
	    setSize(WIDTH , HEIGHT);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, WIDTH, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 239, WIDTH, 39);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		{
			JLabel label = new JLabel("格式错误提示：");
			label.setBounds(159, 33, 107, 16);
			getContentPane().add(label);
		}
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBackground(SystemColor.window);
		textField.setText(errors);
		textField.setBounds(55, 61, 312, 146);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((screenWidth-WIDTH)>>1, (screenHeight-HEIGHT)>>1);
	}
}
