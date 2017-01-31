package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import pojo.Bookin;
public class MainFRM extends JFrame implements Runnable{
	private String uname;
	JLabel lbl2;
	JLabel lbl1;
	public MainFRM(String uname) {
		this.uname=uname;
		
		 this.setSize(989,663);
		 this.setLocationRelativeTo(null);
		 this.setTitle("С��ͼ���ҹ���ϵͳ");
		// this.setResizable(false);
		 this.setLayout(null);
		 
		 JLabel   lbl_img=new JLabel();
		 lbl_img.setBounds(0, 0, 989, 663);
		 lbl_img.setIcon(new ImageIcon("src//image//Main.jpg"));
		 
		 JMenuBar bar=new JMenuBar();
		 JMenu menu1=new JMenu("����ϵͳ(S)");
		 JMenuItem it11=new JMenuItem("Ա������");	
		 it11.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EmpFRM frm=new EmpFRM();
				frm.setVisible(true);
			}
		 });
		 JMenuItem it12=new JMenuItem("ͼ�����");	
		 it12.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				BookFRM frm=new BookFRM();
				frm.setVisible(true);
			}			 
		 });
		// JMenuItem it00=new JMenuItem("��������");
		// JMenuItem it16=new JMenuItem("�˳�");
		 JMenu menu2=new JMenu("��������(O)");
		 JMenuItem it21=new JMenuItem("�����̹���");
		 it21.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				SupplierFRM frm=new SupplierFRM();
				frm.setVisible(true);
			} 
		 });
		 JMenuItem it22=new JMenuItem("�鼮��������");
		 it22.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					BookinFRM frm=new BookinFRM();
					frm.setVisible(true);
				} 
			 });
		 JMenu menu3=new JMenu("С����Ա��Ϣ(C)");		
		 JMenuItem it31=new JMenuItem("ס������");
		 it31.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					CommunityinfoFRM frm=new CommunityinfoFRM();
					frm.setVisible(true);
				} 
			 });
		 JMenu menu4=new JMenu("ͼ��軹����(B)");
		 JMenuItem it41=new JMenuItem("�軹��");
		 	it41.addActionListener(new ActionListener(){
		 		public void actionPerformed(ActionEvent arg0) {
		 			// TODO Auto-generated method stub
		 			
		 			CommunityoutFRM frm=new CommunityoutFRM();
		 			frm.setVisible(true);
		 		}
		 	});
		
		 	
		
		
		 	JMenu menu6=new JMenu("�˳�ϵͳ(E)");		 	
		 JMenuItem it61=new JMenuItem("��  ��");
		
			 menu1.add(it11);			
			 menu1.add(it12);			
			 menu2.add(it21);
			 menu2.add(it22);
			 menu3.add(it31);			 
			 menu4.add(it41);				 
			 menu6.add(it61);			
		 bar.add(menu1);
		 bar.add(menu2);
		 bar.add(menu3);
		 bar.add(menu4);
		 bar.add(menu6);
		 
				lbl1=new JLabel("��ǰ��¼:"+"\t\t\t\t\t"+uname+"\t");
				 lbl1.setBounds(100, 30, 200, 40);
			 
			 //���߳�����̬����ʾʱ��
			 lbl2=new JLabel("��ǰϵͳʱ��:  "+ getTime());
			 lbl2.setBounds(680, 30, 300, 40);
			 
			
			 this.add(lbl1);
			 this.add(lbl2);
			 this.add(lbl_img);	
		 it61.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
				 
				 System.exit(1);
				 
				/*
				 int ch=JOptionPane.showConfirmDialog(null, "�Ƿ��˳�", "��ʾ!", JOptionPane.YES_NO_OPTION);
				
				 if(ch==JOptionPane.YES_OPTION) //ö��
				 {
					 System.exit(1);
				 }
				 else
				 {
					 
				 }
				 */
		}
		 });
		 
		 this.setJMenuBar(bar);	
		 new Thread(this).start();
	}
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lbl2.setText("��ǰϵͳʱ��:  "+ getTime());
		}
		
	}
	
	public String getTime()
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date date=new Date();
		String a=sdf.format(date);
		return a;
	}
		
}
