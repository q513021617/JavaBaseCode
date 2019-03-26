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
	    JMenu file = new JMenu("文件(F)");
	    JMenu edit = new JMenu("编辑(E)");
	    JMenu format = new JMenu("格式(O)");
	    JMenu help = new JMenu("帮助(H)");
	    JMenuItem create = new JMenuItem("新建");
	    JMenuItem open = new JMenuItem("打开...");
	    JMenuItem save = new JMenuItem("保存");
	    JMenuItem saveAs = new JMenuItem("另存为...");
	    JMenuItem exit = new JMenuItem("退出");
	    JMenuItem undo = new JMenuItem("撤销");
	    JMenuItem cut = new JMenuItem("剪切");
	    JMenuItem copy = new JMenuItem("复制");
	    JMenuItem paste = new JMenuItem("粘贴");
	    JMenuItem findRep = new JMenuItem("查找替换");
	    JMenuItem selectAll = new JMenuItem("全选");
	    JMenuItem font = new JMenuItem("字体");
	    JMenuItem about = new JMenuItem("关于");
	    JMenuItem cut2 = new JMenuItem("剪切(X)");

	    JMenuItem copy2 = new JMenuItem("复制(C)");
	    JMenuItem paste2 = new JMenuItem("粘贴(V)");
	    JMenuItem selectAll2 = new JMenuItem("全选(A)");
	    public static JTextArea textarea = new JTextArea();
	    UndoManager um = new UndoManager();
	    JScrollPane scroll = new JScrollPane(textarea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    JPopupMenu popup = new JPopupMenu();
	    String pathSelect;
	    
	    // 获取屏幕尺寸
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	    public JNotepad() {

	        // 此处定义键盘快捷键
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

	        // 事件监听者
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
	        // 设置撤销文本的管理器
	        textarea.getDocument().addUndoableEditListener(um);
	        textarea.setFont(Format.font);
	        // 文件
	        file.add(create);
	        file.add(open);
	        file.add(save);
	        file.add(saveAs);
	        file.addSeparator();
	        file.add(exit);

	        // 编辑
	        edit.add(undo);
	        edit.addSeparator();
	        edit.add(cut);
	        edit.add(copy);
	        edit.add(paste);
	        edit.addSeparator();
	        edit.add(findRep);
	        edit.addSeparator();
	        edit.add(selectAll);

	        // 格式
	        format.add(font);

	        // 帮助
	        help.add(about);

	        // 菜单栏
	        menubar.add(file);
	        menubar.add(edit);
	        menubar.add(format);
	        menubar.add(help);

	        // 右键菜单
	        popup.add(cut2);
	        popup.add(copy2);
	        popup.add(paste2);
	        popup.addSeparator();
	        popup.add(selectAll2);

	        // 添加到文本域容器
	        textarea.add(popup);

	        // 匿名内部类监听器右键动作
	        textarea.addMouseListener(new MouseAdapter() {
	            public void mouseReleased(MouseEvent e) {
	                if (e.getButton() == MouseEvent.BUTTON3) {
	                    popup.show(textarea, e.getX(), e.getY());
	                }
	            }
	        });

	        // 边界布局
	        this.add(menubar, BorderLayout.NORTH);
	        this.add(scroll, BorderLayout.CENTER);
	        this.setTitle("记事本");
	        this.setSize(500, 400);
	        this.setLocationRelativeTo(null);
	        //this.setIconImage(new ImageIcon(this.getClass().getResource("/icon/notepad.png")).getImage());//图标放在源目录的icon文件夹
	        this.setIconImage(new ImageIcon(this.getClass().getResource("")).getImage());//图标放在源目录的icon文件夹
	        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        this.setVisible(true);

	    }
	    
	    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		 // Event对象发生源
        if (e.getSource() == open) {

            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("文本文档(*.txt)", "txt");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("文件打开");
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

        if (e.getSource() == saveAs) {// 另存为

            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("文本文档(*.txt)", "txt");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("另存为");
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

        if (e.getSource() == save && (pathSelect == null)) {// 保存
            JFileChooser chooser = new JFileChooser();

            chooser.setDialogTitle("保存");
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




