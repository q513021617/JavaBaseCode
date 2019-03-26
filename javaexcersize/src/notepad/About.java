package notepad;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class About extends JDialog {
	
	
	  About() {
	        JOptionPane.showMessageDialog(null, "            作者：cjb          版本：v1.5\n\n            联系：cjbi@outlook.com", "关于",
	                JOptionPane.PLAIN_MESSAGE);
	    }
	

}
