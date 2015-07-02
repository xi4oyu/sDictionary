package com.cdzmqm;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

class sDictionaryUi extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel,panel2;
	private JTextField xing,ming,qq,mail,phone,birthday,domain,nickname,other;
	private String sxing,sming,sqq,smail,sphone,sbirthday,sdomain,snickname,sother;
	private String sming1,sming2;
	private String smail1,smail2;
	private String sbirthday1,sbirthday2;
	private JMenuItem about,readme;
	private JCheckBoxMenuItem box;
	private BufferedWriter file;
	private String filename;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {		
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Toolkit t = Toolkit.getDefaultToolkit();
				Dimension d = t.getScreenSize();
				sDictionaryUi f = new sDictionaryUi();
				f.setIconImage(new ImageIcon(getClass().getResource("/com/cdzmqm/images/logo.png")).getImage());
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
		nickname = new JTextField();
		other = new JTextField();
		textAction textAction = new textAction();
		xing.addKeyListener(textAction);
		ming.addKeyListener(textAction);
		qq.addKeyListener(textAction);
		mail.addKeyListener(textAction);
		phone.addKeyListener(textAction);
		birthday.addKeyListener(textAction);
		domain.addKeyListener(textAction);
		nickname.addKeyListener(textAction);
		other.addKeyListener(textAction);
		makeLabel("姓:    （例如zhang）");
		panel.add(xing);
		makeLabel("名:   （例如wei）");
		panel.add(ming);
		makeLabel("QQ:   （例如354197416）");
		panel.add(qq);
		makeLabel("邮箱:    （例如liping20@163.com）");
		panel.add(mail);
		makeLabel("电话:    (例如13187524460或8412474)");
		panel.add(phone);
		makeLabel("生日:    (例如19781018)");
		panel.add(birthday);
		makeLabel("域名:    (例如baidu.com)");
		panel.add(domain);
		makeLabel("英文名:    (例如selina)");
		panel.add(nickname);
		makeLabel("其他:   （例如江海证券经常使用jhzq）");
		panel.add(other);
		getContentPane().add(panel);
		getContentPane().add(panel2,BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(9, 2, 3, 3));
		panel2.setLayout(new GridLayout(1,0,0,0));
//		panel2.setLayout(new FlowLayout());
		JButton button = new JButton("生成");	
		button.addActionListener(new makeAction());
		panel2.add(button);	
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("菜单");
		menu.setMnemonic('M');
		box = new JCheckBoxMenuItem("截断");
		box.setSelected(true);
		menu.add(box);
		JMenu help = new JMenu("帮助");
		help.setMnemonic('H');
		readme = new JMenuItem("使用说明");
		menuAction menuAction = new menuAction();
		readme.addActionListener(menuAction);
		about = new JMenuItem("关于");
		about.addActionListener(menuAction);
		help.add(readme);
		help.add(about);
		menubar.add(menu);
		menubar.add(help);
		setJMenuBar(menubar);
//		panel.setBackground(Color.black);
//		panel2.setBackground(Color.YELLOW);
	}
	private void makeLabel(String name)
	{
		JLabel label = new JLabel(name);
		panel.add(label);
	}
	
	private void rulexing() throws Exception
	{
		String Xing = !sxing.equals("") ? sxing.replaceFirst(sxing.substring(0, 1),sxing.substring(0, 1).toUpperCase()) : "";
		String Ming = !sming.equals("") ? sming.replaceFirst(sming.substring(0, 1),sming.substring(0, 1).toUpperCase()) : "";
		String XING = !sxing.equals("") ? sxing.toUpperCase() : "";
		ArrayList<String> list = new ArrayList<>();
		list.add("");
		list.add("123");
		list.add("456");
		list.add("789");
		list.add("123456");
		list.add("123456789");
		list.add("1314");
		list.add("520");
		list.add("521");
		list.add("5201314");
		list.add("147258369");
		list.add("147");
		list.add("258");
		list.add("369");
		list.add("888");
		list.add("666");
		list.add("007");
		for (String str : list)
		{
			write(Xing+str);
			write(Xing+"@"+str);
			write(sxing+"@"+str);
			write(sxing.toLowerCase()+str);
			write(XING+str);
			write(Xing+Ming+str);
			write(Xing+sming.toLowerCase()+str);
			write(sming.toLowerCase()+sxing+str);
			write(sxing+Ming+str);
			write(sxing+sming.toLowerCase()+str);
			write(sxing.substring(0,1)+sming.toLowerCase().substring(0,1)+str);
			write(sxing.substring(0,1)+str);
			write(sxing.substring(0,1).toUpperCase()+str);
			if(sming2!=null)
			{
				write(sxing.substring(0,1)+sming1.toLowerCase().substring(0,1)+sming2.toLowerCase().substring(0,1)+str);
			}
		}
		if(!sqq.equals(""))
		{
			write(sxing+sqq);
			write(Xing+sqq);
			write(sxing.substring(0,1)+sqq);
			write(sxing.substring(0,1).toUpperCase()+sqq);
		}
		if(!sphone.equals(""))
		{
			write(sxing+sphone);
			write(Xing+sphone);
			write(sxing.substring(0,1)+sphone);
			write(sxing.substring(0,1).toUpperCase()+sphone);
		}
		write(sxing+"@163.com");
		write(sxing+"@126.com");
		write(sxing+"@aliyun.com");
		write(sxing+"@gmail.com");
		write(sxing+"@sina.com");
		write(sxing+"@sina.cn");
		write(sxing+"@sohu.cn");
		write(sxing+"@139.com");
		write(sxing+"@189.com");
		write(sxing+"@outlook.com");
		write(sxing+"@hotmail.com");
		write(sxing+"@2012");
		write(sxing+"@2013");
		write(sxing+"@2014");
		write(sxing+"@2015");
		write(sxing+"@2016");
		write(sming+"@163.com");
		write(sming+"@126.com");
		write(sming+"@aliyun.com");
		write(sming+"@gmail.com");
		write(sming+"@sina.com");
		write(sming+"@sina.cn");
		write(sming+"@sohu.cn");
		write(sming+"@139.com");
		write(sming+"@189.com");
		write(sming+"@outlook.com");
		write(sming+"@hotmail.com");
		write(sming+"@2012");
		write(sming+"@2013");
		write(sming+"@2014");
		write(sming+"@2015");
		write(sming+"@2016");
	}
	private void ruleming() throws Exception
	{
		String Ming = !sming.equals("") ? sming.replaceFirst(sming.substring(0, 1),sming.substring(0, 1).toUpperCase()) : "";
		String MING = !sming.equals("") ? sming.toUpperCase() : "";
		ArrayList<String> list = new ArrayList<>();
		list.add("123");
		list.add("456");
		list.add("789");
		list.add("123456");
		list.add("123456789");
		list.add("1314");
		list.add("520");
		list.add("521");
		list.add("5201314");
		list.add("147258369");
		list.add("147");
		list.add("258");
		list.add("369");
		list.add("888");
		list.add("666");
		list.add("007");
		for (String str : list)
		{
			write(Ming+str);
			write(Ming+"@"+str);
			write(sming.toLowerCase()+"@"+str);
			write(sming.toLowerCase()+str);
			write(MING+str);
			write(sming.toLowerCase().substring(0,1)+str);
			if(sming2!=null)
			{
				write(sming2.toLowerCase()+str);
				write(sming1.toLowerCase()+str);
				write(sming1.toLowerCase().substring(0,1)+sming2.toLowerCase().substring(0,1)+str);
				write(sming1.toUpperCase().substring(0,1)+sming2.toUpperCase().substring(0,1)+str);
			}
		}
		if(!sqq.equals(""))
		{
			write(sming.toLowerCase()+sqq);
			write(Ming+sqq);
			write(sming.toLowerCase().substring(0,1)+sqq);
			write(sming.substring(0,1).toUpperCase()+sqq);
		}
		if(!sphone.equals(""))
		{
			write(sming.toLowerCase()+sphone);
			write(Ming+sphone);
			write(sming.substring(0,1).toLowerCase()+sphone);
			write(sming.substring(0,1).toUpperCase()+sphone);
		}
	}
	private void ruleqq() throws Exception
	{
		String x = sxing.substring(0,1);
		write(x+sqq);
		write(x.toUpperCase()+sqq);
		write(sming.toLowerCase().substring(0,1)+sqq);
		write(sming.toLowerCase().substring(0,1).toUpperCase()+sqq);
		write(x+sming.toLowerCase().substring(0,1)+sqq);
		write(x.toUpperCase()+sming.toLowerCase().substring(0,1)+sqq);
		write(x+sming.toLowerCase().substring(0,1).toUpperCase()+sqq);
		write(x.toUpperCase()+sming.toLowerCase().substring(0,1).toUpperCase()+sqq);
		write(sqq);
		write("qq"+sqq);
		write("Qq"+sqq);
		write("QQ"+sqq);
		write("qQ"+sqq);
		write(sqq+"qq");
		write(sqq+"Qq");
		write(sqq+"QQ");
		write(sqq+"qQ");
		write("a"+sqq);
		write("A"+sqq);
		write(sqq+"a");
		write(sqq+"A");
		write("abc"+sqq);
		write("zxc"+sqq);
		write("asd"+sqq);
		write("qwe"+sqq);
		if(sming2!=null)
		{
			write(x.substring(0,1)+sming1.toLowerCase().substring(0,1)+sming2.toLowerCase().substring(0,1)+sqq);
			write(x.toUpperCase().substring(0,1)+sming1.toLowerCase().substring(0,1)+sming2.toLowerCase().substring(0,1)+sqq);
			write(x.toUpperCase().substring(0,1)+sming1.toLowerCase().substring(0,1).toUpperCase()+sming2.toLowerCase().substring(0,1)+sqq);
			write(x.toUpperCase().substring(0,1)+sming1.toLowerCase().substring(0,1).toUpperCase()+sming2.toLowerCase().substring(0,1).toUpperCase()+sqq);
			write(sming1.toLowerCase().substring(0,1)+sming2.toLowerCase().substring(0,1)+sqq);
			write(sming1.toLowerCase().substring(0,1).toUpperCase()+sming2.toLowerCase().substring(0,1)+sqq);
			write(sming1.toLowerCase().substring(0,1)+sming2.toLowerCase().substring(0,1).toUpperCase()+sqq);
			write(sming1.toLowerCase().substring(0,1).toUpperCase()+sming2.toLowerCase().substring(0,1).toUpperCase()+sqq);
			write(sqq+x+sming1.toLowerCase().substring(0,1)+sming2.toLowerCase().substring(0,1));
			write(sqq+x.toLowerCase()+sming1.toLowerCase().substring(0,1)+sming2.toLowerCase().substring(0,1));
			write(sqq+x.toUpperCase()+sming1.toLowerCase().substring(0,1).toUpperCase()+sming2.toLowerCase().substring(0,1).toUpperCase());
			write(sqq+sming1.toLowerCase().substring(0,1).toUpperCase()+sming2.toLowerCase().substring(0,1).toUpperCase());
			write(sqq+sming1.toLowerCase().substring(0,1)+sming2.toLowerCase().substring(0,1));
		}

	}
	private void rulemail() throws Exception
	{
		ArrayList<String> list = new ArrayList<>();
		list.add("");
		list.add("123");
		list.add("456");
		list.add("789");
		list.add("123456");
		list.add("123456789");
		list.add("1314");
		list.add("520");
		list.add("521");
		list.add("5201314");
		list.add("147258369");
		list.add("147");
		list.add("258");
		list.add("369");
		list.add("888");
		list.add("666");
		list.add("007");
		for (String str : list)
		{
			write(smail1+str);
			write(smail1.replaceFirst(smail1.substring(0,1), smail1.substring(0,1).toUpperCase())+str);
			write(smail1+"@"+str);
		}
		write(sbirthday+smail1);
		write(smail1+sbirthday);
		write(sxing+smail2);
		write(smail1+"@163.com");
		write(smail1+"@126.com");
		write(smail1+"@aliyun.com");
		write(smail1+"@gmail.com");
		write(smail1+"@sina.com");
		write(smail1+"@sina.cn");
		write(smail1+"@sohu.cn");
		write(smail1+"@139.com");
		write(smail1+"@189.com");
		write(smail1+"@outlook.com");
		write(smail1+"@hotmail.com");
		write(smail1+"@2012");
		write(smail1+"@2013");
		write(smail1+"@2014");
		write(smail1+"@2015");
		write(smail1+"@2016");
		if(sbirthday1!=null)
		{
			write(smail1+sbirthday1);
			write(smail1+sbirthday2);
			write(smail1+"@"+sbirthday1);
			write(smail1+"@"+sbirthday2);
			write(sbirthday1+smail1);
			write(sbirthday2+smail1);
		}
		if(!sxing.equals(""))
		{
			write(sxing+sbirthday1);
			write(sxing+sbirthday2);
			write(sxing+"@"+sbirthday1);
			write(sxing+"@"+sbirthday2);
			write(sbirthday1+sxing);
			write(sbirthday2+sxing);
			write(sbirthday+sxing);
			write(sxing+sbirthday);
		}
		if(!sming.equals(""))
		{
			write(sming+sbirthday1);
			write(sming+sbirthday2);
			write(sming+"@"+sbirthday1);
			write(sming+"@"+sbirthday2);
			write(sbirthday1+sming);
			write(sbirthday2+sming);
			write(sbirthday+sming);
			write(sming+sbirthday);
		}
		
	}
	private void rulephone() throws Exception
	{
		String x = sxing.substring(0,1);
		write(x+sphone);
		write(x.toUpperCase()+sphone);
		write(sming.toLowerCase().substring(0,1)+sphone);
		write(sming.toLowerCase().substring(0,1).toUpperCase()+sphone);
		write(x+sming.toLowerCase().substring(0,1)+sphone);
		write(x.toUpperCase()+sming.toLowerCase().substring(0,1)+sphone);
		write(x+sming.toLowerCase().substring(0,1).toUpperCase()+sphone);
		write(x.toUpperCase()+sming.toLowerCase().substring(0,1).toUpperCase()+sphone);
		write(sphone);
		write("a"+sphone);
		write("A"+sphone);
		write(sphone+"a");
		write(sphone+"A");
		write("abc"+sphone);
		if(sming2!=null)
		{
			write(x.substring(0,1)+sming1.toLowerCase().substring(0,1)+sming2.toLowerCase().substring(0,1)+sphone);
			write(x.toUpperCase().substring(0,1)+sming1.toLowerCase().substring(0,1)+sming2.toLowerCase().substring(0,1)+sphone);
			write(x.toUpperCase().substring(0,1)+sming1.toLowerCase().substring(0,1).toUpperCase()+sming2.toLowerCase().substring(0,1)+sphone);
			write(x.toUpperCase().substring(0,1)+sming1.toLowerCase().substring(0,1).toUpperCase()+sming2.toLowerCase().substring(0,1).toUpperCase()+sphone);
			write(sming1.toLowerCase().substring(0,1)+sming2.toLowerCase().substring(0,1)+sphone);
			write(sming1.toLowerCase().substring(0,1).toUpperCase()+sming2.toLowerCase().substring(0,1)+sphone);
			write(sming1.toLowerCase().substring(0,1)+sming2.toLowerCase().substring(0,1).toUpperCase()+sphone);
			write(sming1.toLowerCase().substring(0,1).toUpperCase()+sming2.toLowerCase().substring(0,1).toUpperCase()+sphone);
			write(sphone+x+sming1.toLowerCase().substring(0,1)+sming2.toLowerCase().substring(0,1));
			write(sphone+x.toLowerCase()+sming1.toLowerCase().substring(0,1)+sming2.toLowerCase().substring(0,1));
			write(sphone+x.toUpperCase()+sming1.toLowerCase().substring(0,1).toUpperCase()+sming2.toLowerCase().substring(0,1).toUpperCase());
			write(sphone+sming1.toLowerCase().substring(0,1).toUpperCase()+sming2.toLowerCase().substring(0,1).toUpperCase());
			write(sphone+sming1.toLowerCase().substring(0,1)+sming2.toLowerCase().substring(0,1));
		}
		if(sphone.length()<11)
		{
			write(sxing+sphone);
			write(sming.toLowerCase()+sphone);
			write(sxing.replaceFirst(sxing.substring(0, 1),sxing.substring(0, 1).toUpperCase())+sphone);
			write(sming.replaceFirst(sming.substring(0, 1),sming.substring(0, 1).toUpperCase())+sphone);
			write(sxing+sming.toLowerCase()+sphone);
		}
	}
	private void rulebirthday() throws Exception
	{
		String x = sxing.substring(0,1);
		write(x+sbirthday);
		write(x.toUpperCase()+sbirthday);
		write(sming.toLowerCase().substring(0,1)+sbirthday);
		write(sming.toLowerCase().substring(0,1).toUpperCase()+sbirthday);
		write(x+sming.toLowerCase().substring(0,1)+sbirthday);
		write(x.toUpperCase()+sming.toLowerCase().substring(0,1)+sbirthday);
		write(x+sming.toLowerCase().substring(0,1).toUpperCase()+sbirthday);
		write(x.toUpperCase()+sming.toLowerCase().substring(0,1).toUpperCase()+sbirthday);
		write(sbirthday);
		write("a"+sbirthday);
		write("A"+sbirthday);
		write(sbirthday+"a");
		write(sbirthday+"A");
		write("abc"+sbirthday);
		if(sming2!=null)
		{
			write(x.substring(0,1)+sming1.toLowerCase().substring(0,1)+sming2.toLowerCase().substring(0,1)+sbirthday);
			write(x.toUpperCase().substring(0,1)+sming1.toLowerCase().substring(0,1)+sming2.toLowerCase().substring(0,1)+sbirthday);
			write(x.toUpperCase().substring(0,1)+sming1.toLowerCase().substring(0,1).toUpperCase()+sming2.toLowerCase().substring(0,1)+sbirthday);
			write(x.toUpperCase().substring(0,1)+sming1.toLowerCase().substring(0,1).toUpperCase()+sming2.toLowerCase().substring(0,1).toUpperCase()+sbirthday);
			write(sming1.toLowerCase().substring(0,1)+sming2.toLowerCase().substring(0,1)+sbirthday);
			write(sming1.toLowerCase().substring(0,1).toUpperCase()+sming2.toLowerCase().substring(0,1)+sbirthday);
			write(sming1.toLowerCase().substring(0,1)+sming2.toLowerCase().substring(0,1).toUpperCase()+sbirthday);
			write(sming1.toLowerCase().substring(0,1).toUpperCase()+sming2.toLowerCase().substring(0,1).toUpperCase()+sbirthday);
			write(sbirthday+x+sming1.toLowerCase().substring(0,1)+sming2.toLowerCase().substring(0,1));
			write(sbirthday+x.toLowerCase()+sming1.toLowerCase().substring(0,1)+sming2.toLowerCase().substring(0,1));
			write(sbirthday+x.toUpperCase()+sming1.toLowerCase().substring(0,1).toUpperCase()+sming2.toLowerCase().substring(0,1).toUpperCase());
			write(sbirthday+sming1.toLowerCase().substring(0,1).toUpperCase()+sming2.toLowerCase().substring(0,1).toUpperCase());
			write(sbirthday+sming1.toLowerCase().substring(0,1)+sming2.toLowerCase().substring(0,1));
		}
		write(sxing+sbirthday);
		write(sming.toLowerCase()+sbirthday);
		write(sxing.replaceFirst(sxing.substring(0, 1),sxing.substring(0, 1).toUpperCase())+sbirthday);
		write(sming.replaceFirst(sming.substring(0, 1),sming.substring(0, 1).toUpperCase())+sbirthday);
		write(sxing+sming.toLowerCase()+sbirthday);
	}
	private void ruledomain() throws Exception
	{
		write("2012@"+sdomain);
		write("2013@"+sdomain);
		write("2014@"+sdomain);
		write("2015@"+sdomain);
		write("2016@"+sdomain);
		ArrayList<String> list = new ArrayList<>();
		list.add("123");
		list.add("456");
		list.add("789");
		list.add("123456");
		list.add("123456789");
		list.add("1314");
		list.add("520");
		list.add("521");
		list.add("5201314");
		list.add("147258369");
		list.add("147");
		list.add("258");
		list.add("369");
		list.add("888");
		list.add("666");
		list.add("007");
		for (String str : list)
		{
			write(str+"@"+sdomain);
		}
		if(!sxing.equals(""))
		{
			write(sxing+"@"+sdomain);
			write(sxing.replaceFirst(sxing.substring(0,1), sxing.substring(0,1).toUpperCase())+"@"+sdomain);
		}
		if(!sming.equals(""))
		{
			write(sming.toLowerCase()+"@"+sdomain);
			write(sming.toLowerCase().replaceFirst(sming.toLowerCase().substring(0,1), sxing.substring(0,1).toUpperCase())+"@"+sdomain);
		}
		write("www."+sdomain);
		write("mail."+sdomain);
		write("admin."+sdomain);
		
	}
	private void rulenickname() throws Exception
	{
		ArrayList<String> list = new ArrayList<>();
		list.add("");
		list.add("123");
		list.add("456");
		list.add("789");
		list.add("123456");
		list.add("123456789");
		list.add("1314");
		list.add("520");
		list.add("521");
		list.add("5201314");
		list.add("147258369");
		list.add("147");
		list.add("258");
		list.add("369");
		list.add("888");
		list.add("666");
		list.add("007");
		for (String str : list)
		{
			write(snickname+str);
			write(snickname+"@"+str);
		}
		if(!sbirthday.equals(""))
		{
			write(sbirthday+snickname);
			write(snickname+sbirthday);
			write(snickname+"@163.com");
			write(snickname+"@126.com");
			write(snickname+"@aliyun.com");
			write(snickname+"@gmail.com");
			write(snickname+"@sina.com");
			write(snickname+"@sina.cn");
			write(snickname+"@sohu.cn");
			write(snickname+"@139.com");
			write(snickname+"@189.com");
			write(snickname+"@outlook.com");
			write(snickname+"@hotmail.com");
			write(snickname+"@2012");
			write(snickname+"@2013");
			write(snickname+"@2014");
			write(snickname+"@2015");
			write(snickname+"@2016");
			if(sbirthday1!=null)
			{
				write(snickname+sbirthday1);
				write(snickname+sbirthday2);
				write(snickname+"@"+sbirthday1);
				write(snickname+"@"+sbirthday2);
				write(sbirthday1+snickname);
				write(sbirthday2+snickname);
			}
		}
	}
	private void ruleother() throws Exception
	{
		ArrayList<String> list = new ArrayList<>();
		list.add("");
		list.add("123");
		list.add("456");
		list.add("789");
		list.add("123456");
		list.add("123456789");
		list.add("1314");
		list.add("520");
		list.add("521");
		list.add("5201314");
		list.add("147258369");
		list.add("147");
		list.add("258");
		list.add("369");
		list.add("888");
		list.add("666");
		list.add("007");
		for (String str : list)
		{
			write(sother+str);
			write(sother+"@"+str);
		}
		if(!sbirthday.equals(""))
		{
			write(sbirthday+sother);
			write(sother+sbirthday);
			write(sother+"@163.com");
			write(sother+"@126.com");
			write(sother+"@aliyun.com");
			write(sother+"@gmail.com");
			write(sother+"@sina.com");
			write(sother+"@sina.cn");
			write(sother+"@sohu.cn");
			write(sother+"@139.com");
			write(sother+"@189.com");
			write(sother+"@outlook.com");
			write(sother+"@hotmail.com");
			write(sother+"@2012");
			write(sother+"@2013");
			write(sother+"@2014");
			write(sother+"@2015");
			write(sother+"@2016");
			if(sbirthday1!=null)
			{
				write(sother+sbirthday1);
				write(sother+sbirthday2);
				write(sother+"@"+sbirthday1);
				write(sother+"@"+sbirthday2);
				write(sbirthday1+sother);
				write(sbirthday2+sother);
			}
		}
	}
	private void write(String str) throws Exception
	{
		file.write(str);
		file.newLine();
	}
	private void make()
	{
		sxing = xing.getText();
		sming = ming.getText();
		sqq = qq.getText();
		smail = mail.getText();
		sphone = phone.getText();
		sbirthday = birthday.getText();
		sdomain = domain.getText();
		snickname = nickname.getText();
		sother = other.getText();
		JFileChooser cho = new JFileChooser();
		cho.setCurrentDirectory(new File("."));
		cho.setSelectedFile(new File("dic.txt"));
		if(sxing.equals("")&&sming.equals("")&&sqq.equals("")&&smail.equals("")&&sphone.equals("")&sbirthday.equals("")&&sdomain.equals("")&&snickname.equals("")&&sother.equals(""))
		{
			JOptionPane.showMessageDialog(this, "至少要填写一个项目", "提示", JOptionPane.ERROR_MESSAGE);
		} 
		else 
		{
			int result = cho.showDialog(panel, "保存");
			filename = cho.getSelectedFile().getPath();
			try {
				file = new BufferedWriter(new FileWriter(filename));
				if(result==0)
				{
					if(!smail.equals(""))
					{
						String[] tmp = smail.split("@");
						smail1 = tmp[0];
						smail2 = tmp[1];
					}
					if(!sbirthday.equals(""))
					{
						Matcher tmp = Pattern.compile("([0-9]{4})([0-9]{4})").matcher(sbirthday);
						if(tmp.find())
						{
							sbirthday1 = tmp.group(1);
							sbirthday2 = tmp.group(2);
						}
					}
					if(!sxing.equals("")&&!sming.equals(""))
					{
						Matcher tmp = Pattern.compile("([a-zA-z][a-z].+?)([A-Z][a-z].+?)?").matcher(sming);
						if(tmp.find())
						{
							sming1 = tmp.group(1);
							sming2 = tmp.group(2);
						}
						this.rulexing();
						this.ruleming();
					}
					if(!sqq.equals(""))
					{
						this.ruleqq();
					}
					
					if(!smail.equals(""))
					{
						this.rulemail();
					}
					if(!sphone.equals(""))
					{
						this.rulephone();
					}
					if(!sbirthday.equals(""))
					{
						this.rulebirthday();
					}
					if(!sdomain.equals(""))
					{
						this.ruledomain();
					}
					if(!snickname.equals(""))
					{
						this.rulenickname();
					}
					if(!sother.equals(""))
					{
						this.ruleother();
					}
					file.flush();
					file.close();
					if(box.isSelected())
					{
						this.cut();
					}
					JOptionPane.showMessageDialog(this, "生成成功！","提示",JOptionPane.INFORMATION_MESSAGE);		
					
				} else {
					JOptionPane.showMessageDialog(this, "请选择保存的地址", "提示", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void cut() throws Exception
	{
		String tmp = "",tmp2 = "";
		BufferedReader br = new BufferedReader(new FileReader(filename));

		while ((tmp=br.readLine())!=null)
		{
			if(tmp.length()>5)
			{
				tmp2 = tmp2+tmp+System.getProperty("line.separator");
			}

		}
		br.close();
		BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
		bw.write(tmp2);
		bw.flush();
		bw.close();
	}
	private void readme()
	{
		JDialog r = new JDialog(sDictionaryUi.this);
		r.add(new JLabel("<html><h1>社会工程学字典<i></i></h1>By Chora</html>"),BorderLayout.CENTER);
		r.setSize(250,150);
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		r.setLocation((d.width-r.getWidth())/2,(d.height-r.getHeight())/2);
		r.setLocation((d.width-r.getWidth())/2,(d.height-r.getHeight())/2);
		r.setResizable(false);
		r.setVisible(true);
	}
	private void about()
	{
		JDialog a = new JDialog(sDictionaryUi.this);
		JLabel help = new JLabel("<html><h4>1、所填写的信息均为小写字母。<br>2、如果姓名是三个字，则后两个字即名的首字母需大写，例如：袁世凯<font color='red'>yuanshikai</font>则需要在名的地方填写:<font color='red'>ShiKai</font>，姓的地方填:<font color='red'>yuan</font>。<br>3、截断功能默认开启，开启的话在生成的时候只会生成（含）6位以上的组合。</h4></html>");
		help.setLayout(new FlowLayout());
		a.add(help);
		a.setSize(250,150);
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		a.setLocation((d.width-a.getWidth())/2,(d.height-a.getHeight())/2);
		a.setLocation((d.width-a.getWidth())/2,(d.height-a.getHeight())/2);
		a.setResizable(false);
		a.setVisible(true);
	}
	class makeAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			make();
		}
	}
	class menuAction implements ActionListener

	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==readme)
			{
				about();
			} 
			else if (e.getSource() == about)
			{
				readme();
			}
		}
		
	}
	class textAction extends KeyAdapter
	{
		public void keyPressed(KeyEvent e)
		{
			if(e.getKeyCode()==10)
			{
				make();
			}
			//System.out.println();
		}
	}
}