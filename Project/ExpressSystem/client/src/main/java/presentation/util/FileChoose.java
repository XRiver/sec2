
package presentation.util;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class FileChoose extends JFrame{
JFrame frame;
JButton button;

	public   FileChoose(){
		
		MyJFileChooser jf=new MyJFileChooser();
				jf.setVisible(true);
				jf.setDialogTitle("导出文件");
				int result=jf.showOpenDialog(jf);
				if(result==JFileChooser.APPROVE_OPTION){
					File fileIn=jf.getSelectedFile();
					if(fileIn.exists()){
						JOptionPane.showMessageDialog(jf, "OPSEN");
					}
					else{
						
					}
				}
				else if(result==JFileChooser.CANCEL_OPTION){
					System.out.println("Cancel!");
				}
				else if(result==JFileChooser.ERROR_OPTION){
					System.out.println("Eroor!");
				}
			}
		
	
	
}
	

