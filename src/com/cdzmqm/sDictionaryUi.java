 package com.cdzmqm;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

class sDictionaryUi extends JFrame{
	private JPanel panel,panel2;
	private JTextField xing,ming,qq,mail,phone,birthday,domain,nickname,other;
	private String sxing,sming,sqq,smail,sphone,sbirthday,sdomain,snickname,sother;
	private String sming1,sming2;
	private BufferedWriter file;
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
		nickname = new JTextField();
		other = new JTextField();
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
		for (String str : list)
		{
			write(Xing+str);
			write(sxing.toLowerCase()+str);
			write(XING+str);
			write(Xing+Ming+str);
			write(Xing+sming.toLowerCase()+str);
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
		for (String str : list)
		{
			write(Ming+str);
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
	}
	private void rulebirthday() throws Exception
	{
		
	}
	private void ruledomain() throws Exception
	{
		
	}
	private void rulenickname() throws Exception
	{
		
	}
	private void ruleother() throws Exception
	{
		
	}
	private void write(String str) throws Exception
	{
		file.write(str);
		file.newLine();
	}
	private void make()
	{
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
			String filename = cho.getSelectedFile().getPath();
			try {
				file = new BufferedWriter(new FileWriter(filename));
				if(result==0)
				{
					if(!sxing.equals("")&&!sming.equals(""))
					{
						this.rulexing();
						this.ruleming();
						Matcher tmp = Pattern.compile("([a-zA-z][a-z].+?)([A-Z][a-z].+?)?").matcher(sming);
						if(tmp.find())
						{
							sming1 = tmp.group(1);
							sming2 = tmp.group(2);
						}
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
					JOptionPane.showMessageDialog(this, "生成成功！","提示",JOptionPane.INFORMATION_MESSAGE);		
					
				} else {
					JOptionPane.showMessageDialog(this, "请选择保存的地址", "提示", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
			snickname = nickname.getText();
			sother = other.getText();
			make();
		}
		
	}
}