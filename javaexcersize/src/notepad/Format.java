package notepad;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class Format extends JDialog implements ActionListener {

	
	 public static int style = 0; // ȫ�ֱ������ͣ�Ĭ��ֵΪ0
	    public static int size = 16; // ȫ�ֱ��������С��Ĭ��ֵΪ16
	    static Font font = new Font("������", style, size); // ȫ�ֱ������壬Ĭ��ֵΪ������

	    JPanel pn = new JPanel();
	    JPanel okCelPn = new JPanel();
	    JPanel fontPn = new JPanel();
	    JPanel ptPn = new JPanel();
	    JLabel fontLabel = new JLabel("����:   ");
	    JLabel fontStyleLabel = new JLabel("    ����:   ");
	    JLabel ptLabel = new JLabel("       ��ֵ:   ");
	    JButton ok = new JButton("ȷ��");
	    JButton cancel = new JButton("ȡ��");
	    GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();// ��ȡϵͳ�п��õ����������
	    String[] fontName = e.getAvailableFontFamilyNames();// ��ȡϵͳ�п��õ����������
	    String[] fontType = { "����", "��б", "����", "��ƫб��" };
	    JList fontList = new JList(fontName);
	    JList fontTypeList = new JList(fontType);
	    JScrollPane fontScroll = new JScrollPane(fontList);
	    JScrollPane fontTypeScroll = new JScrollPane(fontTypeList);

	    JTextArea textarea;
	    SpinnerModel spinnerModel = new SpinnerNumberModel(size, // initial value
	            0, // min
	            100, // max
	            2 // Step
	    );
	    JSpinner spinner = new JSpinner(spinnerModel);

	    public Format(JTextArea textarea) {
	        this.textarea = textarea;
	        ok.addActionListener(this);
	        cancel.addActionListener(this);

	        pn.setLayout(new GridLayout(2, 1));
	        pn.add(fontPn);
	        pn.add(ptPn);

	        fontPn.add(fontLabel);
	        fontPn.add(fontScroll);
	        fontPn.add(fontStyleLabel);
	        fontPn.add(fontTypeScroll);

	        ptPn.add(ptLabel);
	        ptPn.add(spinner);

	        fontList.setVisibleRowCount(5);
	        fontList.setFixedCellWidth(60);
	        fontList.setSelectedIndex(50);
	        fontList.setSelectedValue(font.getFontName(), true);

	        fontTypeList.setVisibleRowCount(5);
	        fontTypeList.setSelectedIndex(style);
	        okCelPn.add(ok);
	        okCelPn.add(cancel);

	        okCelPn.setLayout(new FlowLayout(FlowLayout.RIGHT));

	        this.add(pn, BorderLayout.CENTER);
	        this.add(okCelPn, BorderLayout.SOUTH);

	        this.setTitle("����");
	        this.pack();
	        this.setLocationRelativeTo(null);
	        this.setResizable(false);
	        this.setVisible(true);
	        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    }
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

        if (e.getSource() == ok) {
            System.out.println(fontList.getSelectedValue());
            style = this.type();
            size = Integer.parseInt(spinner.getValue().toString());
            font = new Font((String) fontList.getSelectedValue(), style, size);
            textarea.setFont(font);
            this.dispose();
            System.out.println(type());
        } else if (e.getSource() == cancel) {
            this.dispose();
        }
    }

    private int type() {
        if (fontTypeList.getSelectedValue().equals("��б")) {
            return 1;
        } else if (fontTypeList.getSelectedValue().equals("����")) {
            return 2;
        } else if (fontTypeList.getSelectedValue().equals("��ƫб��")) {
            return 3;
        } else
            return 0;
    }
	

}
