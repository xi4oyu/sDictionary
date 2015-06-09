 package com.cdzmqm;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.*;

class sDictionaryUi extends JFrame{
	private JPanel panel,panel2;
	private JTextField xing,ming,qq,mail,phone,birthday,domain,user,pass;
	private String sxing,sming,sqq,smail,sphone,sbirthday,sdomain,suser,spass;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {		
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Toolkit t = Toolkit.getDefaultToolkit();
				Dimension d = t.getScreenSize();
				sDictionaryUi f = new sDictionaryUi();
				f.setLocation((d.width-f.getWidth())/2,(d.height-f.getHeight())/2);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setResizable(false);
				f.setVisible(true);
			}
		});
	}
	public sDictionaryUi()
	{
		this.setTitle("sDictionary");
		this.setSize(452, 352);
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			SwingUtilities.updateComponentTreeUI(sDictionaryUi.this);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		panel = new JPanel();
		panel2 = new JPanel();
		xing = new JTextField();
		ming = new JTextField();
		qq = new JTextField();
		mail = new JTextField();
		phone = new JTextField();
		birthday = new JTextField();
		domain = new JTextField();
		user = new JTextField();
		pass = new JTextField();
		makeLabel("姓:");
		panel.add(xing);
		makeLabel("名:");
		panel.add(ming);
		makeLabel("QQ:");
		panel.add(qq);
		makeLabel("邮箱:");
		panel.add(mail);
		makeLabel("电话:");
		panel.add(phone);
		makeLabel("生日:");
		panel.add(birthday);
		makeLabel("域名:");
		panel.add(domain);
		makeLabel("用户名:");
		panel.add(user);
		makeLabel("密码:");
		panel.add(pass);
		getContentPane().add(panel);
		getContentPane().add(panel2,BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(9, 2, 3, 3));
		panel2.setLayout(new GridLayout(1,0,0,0));
//		panel2.setLayout(new FlowLayout());
		JButton button = new JButton("生成");	
		button.addActionListener(new makeAction());
		panel2.add(button);
//		panel.setBackground(Color.black);
//		panel2.setBackground(Color.YELLOW);
	}
	private void makeLabel(String name)
	{
		JLabel label = new JLabel(name);
		panel.add(label);
	}
	
	private void rulexing()
	{
		
	}
	private void make()
	{
		System.out.println("生成成功");
	}	
	class makeAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			sxing = xing.getText();
			sming = ming.getText();
			sqq = qq.getText();
			smail = mail.getText();
			sphone = phone.getText();
			sbirthday = birthday.getText();
			sdomain = domain.getText();
			suser = user.getText();
			spass = pass.getText();
			make();
			System.out.println(xing.getText());
		}
		
	}
}