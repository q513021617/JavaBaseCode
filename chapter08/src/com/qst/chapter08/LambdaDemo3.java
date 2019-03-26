package com.qst.chapter08;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class LambdaDemo3 extends JFrame {
	JPanel p;
	JTextArea ta;
	JButton btn1, btn2;

	public LambdaDemo3() {
		super("Lambda测试");
		p = new JPanel();

		ta = new JTextArea();

		btn1 = new JButton("传统方式");
		btn2 = new JButton("Lambda方式");

		// 添加监听器
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.append("您点击了按钮1\n");
			}
		});

		// Lambda表达式方式
		btn2.addActionListener(e -> ta.append("您点击了按钮2\n"));

		this.add(ta);

		p.add(btn1);
		p.add(btn2);

		this.add(p, BorderLayout.SOUTH);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new LambdaDemo3().setVisible(true);
	}
}
