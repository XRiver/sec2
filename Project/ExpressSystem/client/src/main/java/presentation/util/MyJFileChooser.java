//文件过滤器
package presentation.util;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

@SuppressWarnings("serial")
public class MyJFileChooser extends JFileChooser {
	
	private ArrayList<String> list;

	public MyJFileChooser() {
		list = new ArrayList<String>();
		list.add("xls");
		list.add("xlsx");
		this.setFileFilter(new FileFilter() {
			@Override
			public boolean accept(File f) {
				if (f.isDirectory())
					return true;
				String name = f.getName();
				int p = name.lastIndexOf('.');
				if (p == -1)
					return false;
				String suffix = name.substring(p + 1).toLowerCase();
				return list.contains(suffix);
			}

			@Override
			public String getDescription() {
				return "excel files";
			}
		});
		this.setSelectedFile(new File(".xls"));
	}

}
