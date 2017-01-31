package view;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import dao.BookDao;
import dao.EmpDao;
import dao.UserLoginDao;
import pojo.Book;
import pojo.Emp;
public class EmpFRM extends JDialog{
	static JTable table=new JTable();
	public EmpFRM() {
		this.setTitle("Ա����");
		this.setSize(750,500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.setModal(true);	
		JScrollPane js=new JScrollPane();
		js.setBounds(20, 40, 720, 150);
		//this.add(js, BorderLayout.CENTER);
		js.add(table);
		js.setViewportView(table);
		
		
		JLabel   lbl_img=new JLabel();		
		lbl_img.setIcon(new ImageIcon("src//image//EmpFRM.jpg"));	
		lbl_img.setBounds(0, 0, 750, 500);
		
		//��������ݾ���
		DefaultTableCellRenderer dtr=new DefaultTableCellRenderer();
		dtr.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, dtr);
		
		
		EmpDao dao=new EmpDao();
		ArrayList<Emp> list=dao.getAllEmp();
		
		DefaultTableModel dtm=new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}		
		};
		dtm.addColumn("Ա��ID");
		dtm.addColumn("Ա������");	
		dtm.addColumn("���֤����");
		dtm.addColumn("��ϵ�绰");
		dtm.addColumn("סַ");
		dtm.addColumn("��ְ����");
		dtm.addColumn("�Ƿ���ְ");
		for (Emp emp : list) {		
			Vector vec=new Vector();
			int eid=emp.getEid();						
			String ename=emp.getEname();	
			String ecardid=emp.getEcardid();	
			String ephone=emp.getEphone();	
			String eaddress=emp.getEaddress();	
			String ehiredate=emp.getEhiredate();	
			int eis=emp.getEis();	
			vec.add(eid);
			vec.add(ename);
			vec.add(ecardid);
			vec.add(ephone);
			vec.add(eaddress);
			vec.add(ehiredate);
			vec.add(eis);
			dtm.addRow(vec);
	}		
		//����ͼ��
		JButton bnt1=new JButton("����Ա��");
		bnt1.setBounds(140, 300, 100, 25);
		bnt1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				AddEmp add=new AddEmp();
				add.setVisible(true);
			}
		});		
		//�޸�Ա��
		JButton bnt2=new JButton("�޸�Ա��");
		bnt2.setBounds(440, 300, 100, 25);
		bnt2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int row=table.getSelectedRow();
				if(row<0)
				{
					JOptionPane.showMessageDialog(null, "δѡ���޸ĵ���");
					
				}
				else
				{
					int eid=(Integer)table.getValueAt(row, 0);
					UpdateEmp frm=new UpdateEmp(eid);
					frm.setVisible(true);
				}
				
				
			
			}
		});
		bindEmp();	
		this.add(js);
		this.add(bnt1);
		this.add(bnt2);
		this.add(lbl_img);
	}
	public static void  bindEmp()
	{		
		EmpDao dao=new EmpDao();
		ArrayList<Emp> list=dao.getAllEmp();
		DefaultTableModel dtm=new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}		
		};
		dtm.addColumn("Ա��ID");
		//dtm.addColumn("ͼ������");
		//dtm.addColumn("������");
		dtm.addColumn("����");
		dtm.addColumn("�Ա�");
		dtm.addColumn("���֤����");
		dtm.addColumn("��ϵ�绰");
		dtm.addColumn("��ͥסַ");
		dtm.addColumn("��ְ����");
		dtm.addColumn("�Ƿ���ְ");
					
		for (Emp emp : list) {		
			Vector vec=new Vector();
			int eid=emp.getEid();			
			String ename=emp.getEname();		
			String ecardid=emp.getEcardid();
			String ephone=emp.getEphone();
			String eaddress=emp.getEaddress();			
			String eh=emp.getEhiredate();			
			String ss[]=eh.split(" ");
			String ehiredate=ss[0];
			int a=emp.getEis();
			String ee=(a==1?"��ְ":"����ְ");		
			String sex=null;
			char c=ecardid.charAt(16);			
			int n=Integer.parseInt(c+"");
			if(n%2==0)
			{
				sex="Ů";
			}
			else
			{
				sex="��";
			}
			vec.add(eid);
			vec.add(ename);
			vec.add(sex);
			vec.add(ecardid);
			vec.add(ephone);
			vec.add(eaddress);
			vec.add(ehiredate);
			vec.add(ee);
			dtm.addRow(vec);
	}		
		table.setModel(dtm);		
		table.getColumnModel().getColumn(0).setMaxWidth(20);
		table.getColumnModel().getColumn(0).setMinWidth(20);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);	
		table.getColumnModel().getColumn(1).setMaxWidth(60);
		table.getColumnModel().getColumn(1).setMinWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setMaxWidth(40);
		table.getColumnModel().getColumn(2).setMinWidth(40);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setMaxWidth(150);
		table.getColumnModel().getColumn(3).setMinWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);		
		table.getColumnModel().getColumn(4).setMaxWidth(120);
		table.getColumnModel().getColumn(4).setMinWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getColumnModel().getColumn(5).setMaxWidth(140);
		table.getColumnModel().getColumn(5).setMinWidth(140);
		table.getColumnModel().getColumn(5).setPreferredWidth(140);
		table.getColumnModel().getColumn(6).setMaxWidth(100);
		table.getColumnModel().getColumn(6).setMinWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setMaxWidth(100);
		table.getColumnModel().getColumn(7).setMinWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
			
	}		

	public static void main(String[] args) {
		EmpFRM frm=new EmpFRM();
		frm.setVisible(true);
	}

}
		
	
