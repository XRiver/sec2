package presentation.util;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SubmitDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
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
			SubmitDialog dialog = new SubmitDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SubmitDialog() {
		setSize(WIDTH , HEIGHT);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblokcancel = new JLabel("确认提交此订单吗？\n");
			lblokcancel.setBounds(144, 56, 127, 57);
			contentPanel.add(lblokcancel);
		}
		{
			JLabel lblNewLabel = new JLabel("若确认请点击“OK”，否则点击“Cancel”");
			lblNewLabel.setBounds(143, 114, 240, 21);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
			    okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((screenWidth-WIDTH)>>1, (screenHeight-HEIGHT)>>1);
	}
	
	public JButton getOK(){
		return okButton;
	}

}
