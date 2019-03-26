package notepad;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.undo.UndoManager;
import notepad.Format;


public class JNotepad extends JFrame implements ActionListener{

	 JMenuBar menubar = new JMenuBar();
	    JMenu file = new JMenu("�ļ�(F)");
	    JMenu edit = new JMenu("�༭(E)");
	    JMenu format = new JMenu("��ʽ(O)");
	    JMenu help = new JMenu("����(H)");
	    JMenuItem create = new JMenuItem("�½�");
	    JMenuItem open = new JMenuItem("��...");
	    JMenuItem save = new JMenuItem("����");
	    JMenuItem saveAs = new JMenuItem("���Ϊ...");
	    JMenuItem exit = new JMenuItem("�˳�");
	    JMenuItem undo = new JMenuItem("����");
	    JMenuItem cut = new JMenuItem("����");
	    JMenuItem copy = new JMenuItem("����");
	    JMenuItem paste = new JMenuItem("ճ��");
	    JMenuItem findRep = new JMenuItem("�����滻");
	    JMenuItem selectAll = new JMenuItem("ȫѡ");
	    JMenuItem font = new JMenuItem("����");
	    JMenuItem about = new JMenuItem("����");
	    JMenuItem cut2 = new JMenuItem("����(X)");

	    JMenuItem copy2 = new JMenuItem("����(C)");
	    JMenuItem paste2 = new JMenuItem("ճ��(V)");
	    JMenuItem selectAll2 = new JMenuItem("ȫѡ(A)");
	    public static JTextArea textarea = new JTextArea();
	    UndoManager um = new UndoManager();
	    JScrollPane scroll = new JScrollPane(textarea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    JPopupMenu popup = new JPopupMenu();
	    String pathSelect;
	    
	    // ��ȡ��Ļ�ߴ�
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	    public JNotepad() {

	        // �˴�������̿�ݼ�
	        // MenuBar
	        file.setMnemonic(KeyEvent.VK_F);
	        edit.setMnemonic(KeyEvent.VK_E);
	        format.setMnemonic(KeyEvent.VK_O);
	        help.setMnemonic(KeyEvent.VK_H);
	        // MenuItem
	        create.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
	        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
	        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
	        undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
	        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
	        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
	        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
	        findRep.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
	        selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

	        // �¼�������
	        save.addActionListener(this);
	        create.addActionListener(this);
	        open.addActionListener(this);
	        saveAs.addActionListener(this);
	        exit.addActionListener(this);
	        undo.addActionListener(this);
	        cut.addActionListener(this);
	        copy.addActionListener(this);
	        paste.addActionListener(this);
	        selectAll.addActionListener(this);
	        font.addActionListener(this);
	        about.addActionListener(this);
	        cut2.addActionListener(this);
	        copy2.addActionListener(this);
	        paste2.addActionListener(this);
	        selectAll2.addActionListener(this);
	        findRep.addActionListener(this);
	        // ���ó����ı��Ĺ�����
	        textarea.getDocument().addUndoableEditListener(um);
	        textarea.setFont(Format.font);
	        // �ļ�
	        file.add(create);
	        file.add(open);
	        file.add(save);
	        file.add(saveAs);
	        file.addSeparator();
	        file.add(exit);

	        // �༭
	        edit.add(undo);
	        edit.addSeparator();
	        edit.add(cut);
	        edit.add(copy);
	        edit.add(paste);
	        edit.addSeparator();
	        edit.add(findRep);
	        edit.addSeparator();
	        edit.add(selectAll);

	        // ��ʽ
	        format.add(font);

	        // ����
	        help.add(about);

	        // �˵���
	        menubar.add(file);
	        menubar.add(edit);
	        menubar.add(format);
	        menubar.add(help);

	        // �Ҽ��˵�
	        popup.add(cut2);
	        popup.add(copy2);
	        popup.add(paste2);
	        popup.addSeparator();
	        popup.add(selectAll2);

	        // ��ӵ��ı�������
	        textarea.add(popup);

	        // �����ڲ���������Ҽ�����
	        textarea.addMouseListener(new MouseAdapter() {
	            public void mouseReleased(MouseEvent e) {
	                if (e.getButton() == MouseEvent.BUTTON3) {
	                    popup.show(textarea, e.getX(), e.getY());
	                }
	            }
	        });

	        // �߽粼��
	        this.add(menubar, BorderLayout.NORTH);
	        this.add(scroll, BorderLayout.CENTER);
	        this.setTitle("���±�");
	        this.setSize(500, 400);
	        this.setLocationRelativeTo(null);
	        //this.setIconImage(new ImageIcon(this.getClass().getResource("/icon/notepad.png")).getImage());//ͼ�����ԴĿ¼��icon�ļ���
	        this.setIconImage(new ImageIcon(this.getClass().getResource("")).getImage());//ͼ�����ԴĿ¼��icon�ļ���
	        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        this.setVisible(true);

	    }
	    
	    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		 // Event������Դ
        if (e.getSource() == open) {

            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("�ı��ĵ�(*.txt)", "txt");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("�ļ���");
            chooser.showOpenDialog(null);
            chooser.setVisible(true);

            try {
                pathSelect = chooser.getSelectedFile().getPath();
                FileReader wjl = new FileReader(pathSelect);
                BufferedReader hcl = new BufferedReader(wjl);
                String s = "", zfc = "";
                while ((s = hcl.readLine()) != null) {
                    zfc += (s + "\n");
                }
                textarea.setText(zfc);

            } catch (Exception e1) {
            }
        }

        if (e.getSource() == saveAs) {// ���Ϊ

            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("�ı��ĵ�(*.txt)", "txt");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("���Ϊ");
            chooser.showSaveDialog(null);
            chooser.setVisible(true);

            PrintStream ps;
            try {
                String select = chooser.getSelectedFile().getPath();
                ps = new PrintStream(select);
                System.setOut(ps);
                System.out.println(this.textarea.getText());

            } catch (Exception e1) {
            }
        }

        if (e.getSource() == save && (pathSelect == null)) {// ����
            JFileChooser chooser = new JFileChooser();

            chooser.setDialogTitle("����");
            chooser.showSaveDialog(null);
            chooser.setVisible(true);

            PrintStream ps;
            try {
                pathSelect = chooser.getSelectedFile().getPath();
                ps = new PrintStream(pathSelect);
                System.setOut(ps);
                System.out.println(this.textarea.getText());

            } catch (Exception e1) {
            }
        } else if (e.getSource() == save && !(pathSelect == null)) {
            PrintStream ps;
            try {
                ps = new PrintStream(pathSelect);
                System.setOut(ps);
                System.out.println(this.textarea.getText());
            } catch (FileNotFoundException e1) {
            }
        }

        if (e.getSource() == create) {
            textarea.setText("");
            pathSelect = null;
        }

        if (e.getSource() == exit) {
            System.exit(0);
        }

        if (e.getSource() == undo) {
            if (um.canUndo()) {
                um.undo();
            }
        }

        if (e.getSource() == cut || e.getSource() == cut2) {
            textarea.cut();
        } else if (e.getSource() == copy || e.getSource() == copy2) {
            textarea.copy();
        } else if (e.getSource() == paste || e.getSource() == paste2) {
            textarea.paste();
        } else if (e.getSource() == findRep) {
            new FindAndReplace(textarea);
        }

        else if (e.getSource() == selectAll || e.getSource() == selectAll2) {
            textarea.selectAll();
        }
        if (e.getSource() == font) {
            new Format(textarea);
        }
        if (e.getSource() == about) {
            new About();
        }
		
		
		
		
		
	}

	
	
	public static void main(String[] args) {
        new JNotepad();
    }
	
	
	
}




