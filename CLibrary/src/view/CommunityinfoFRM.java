package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import pojo.Book;
import pojo.Bookin;
import pojo.Communityinfo;
import pojo.Emp;
import pojo.Supplier;
import dao.BookDao;
import dao.BookinDao;
import dao.CommunityinfoDao;

import dao.EmpDao;
import dao.SupplierDao;
public class CommunityinfoFRM extends JDialog{
	static JTable table=new JTable();
	public CommunityinfoFRM() {
		this.setTitle("ס����ϸ��Ϣ��");
		this.setSize(650,420);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.setModal(true);		
		JScrollPane js=new JScrollPane();
		js.setBounds(20, 20, 600, 280);
		js.add(table);
		js.setViewportView(table);	
		
		JLabel   lbl_img=new JLabel();		
		lbl_img.setIcon(new ImageIcon("src//image//aaa.jpg"));	
		lbl_img.setBounds(0, 0, 1200, 650);
		
		
		//��������ݾ���
		DefaultTableCellRenderer dtr=new DefaultTableCellRenderer();
		dtr.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, dtr);
		
		JButton bnt1=new JButton("����ס��");
		bnt1.setBounds(70, 330, 100, 25);
		bnt1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				AddCommunity add=new AddCommunity();
				add.setVisible(true);
			}
		});		
		JButton bnt2=new JButton("ɾ��ס��");
		bnt2.setBounds(370, 330, 100, 25);
		bnt2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub				
				int row=table.getSelectedRow();
				if(row>=0)
				{
					int coid= (Integer)table.getValueAt(row,0 );
					CommunityinfoDao dao=new CommunityinfoDao();					
					int ch=JOptionPane.showConfirmDialog(null, "�Ƿ����ɾ��", "����", JOptionPane.YES_NO_OPTION);
					//JOptionPane.showMessageDialog(null,did);
					if(ch==JOptionPane.YES_OPTION)
					{
						int n=dao.delCommunityinfo(coid);
						if(n>=1)
						{
							//JOptionPane.showMessageDialog(null, "ɾ���ɹ�!");
							bindCommunity();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "ɾ��ʧ��,��ɾ��Ա�����Ӧ�ļ�¼��");
						}
					}					
					//JOptionPane.showMessageDialog(null,did);					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "δѡ��ɾ�����У�");
				}
				
			}
		});
		bindCommunity();
		this.add(js);
		this.add(bnt1);
		this.add(bnt2);	
		this.add(lbl_img);
	}
public static void  bindCommunity()
		{			
			CommunityinfoDao dao=new CommunityinfoDao();
			ArrayList<Communityinfo> list=dao.getAllCommunityinfo();
			//��ģ��
			DefaultTableModel dtm=new DefaultTableModel(){
				@Override
				public boolean isCellEditable(int row, int column) {
					// TODO Auto-generated method stub
					return false;
				}		
			};
			dtm.addColumn("ס��ID");
			dtm.addColumn("ס������");
			dtm.addColumn("ס�����֤");
			dtm.addColumn("ס��סַ");
			dtm.addColumn("ס����ϵ�绰");	
			dtm.addColumn("����֤���");	
			for (Communityinfo communityinfo : list) {		
				Vector vec=new Vector();
				int coid=communityinfo.getCoid();
				String coname=communityinfo.getConame();
				String cocard=communityinfo.getCocard();
				String coaddress=communityinfo.getCoaddress();
				String cophone=communityinfo.getCophone();
				String libraryid=communityinfo.getLibraryid();
				vec.add(coid);
				vec.add(coname);
				vec.add(cocard);
				vec.add(coaddress);
				vec.add(cophone);
				vec.add(libraryid);
				dtm.addRow(vec);				
		}	
			table.setModel(dtm);
			table.getColumnModel().getColumn(0).setMaxWidth(30);
			table.getColumnModel().getColumn(0).setMinWidth(30);
			table.getColumnModel().getColumn(0).setPreferredWidth(30);
			table.getColumnModel().getColumn(1).setMaxWidth(80);
			table.getColumnModel().getColumn(1).setMinWidth(80);
			table.getColumnModel().getColumn(1).setPreferredWidth(80);
			table.getColumnModel().getColumn(2).setMaxWidth(180);
			table.getColumnModel().getColumn(2).setMinWidth(180);
			table.getColumnModel().getColumn(2).setPreferredWidth(180);
			table.getColumnModel().getColumn(3).setMaxWidth(100);
			table.getColumnModel().getColumn(3).setMinWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(4).setMaxWidth(120);
			table.getColumnModel().getColumn(4).setMinWidth(120);
			table.getColumnModel().getColumn(4).setPreferredWidth(120);
		}
public static void main(String[] args){
	CommunityinfoFRM frm=new CommunityinfoFRM();
	frm.setVisible(true);
}
}
