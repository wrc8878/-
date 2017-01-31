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
import pojo.Emp;
import pojo.Supplier;
import dao.EmpDao;
import dao.SupplierDao;
public class SupplierFRM extends JDialog{
	static JTable table=new JTable();
	public SupplierFRM() {
		this.setTitle("������˾��");
		this.setSize(700,400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.setModal(true);		
		JScrollPane js=new JScrollPane();
		js.setBounds(20, 40, 650, 110);
		js.add(table);
		js.setViewportView(table);		
		
		
		JLabel   lbl_img=new JLabel();		
		lbl_img.setIcon(new ImageIcon("src//image//EmpFRM.jpg"));	
		lbl_img.setBounds(0, 0, 700, 400);
		
		//��������ݾ���
		DefaultTableCellRenderer dtr=new DefaultTableCellRenderer();
		dtr.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, dtr);
		
		
		JButton jb1=new JButton("���ӹ�����˾");
		jb1.setBounds(120, 220, 120, 25);
		jb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddSupplier add=new AddSupplier();
				add.setVisible(true);
			}
		});
		JButton jb2=new JButton("�޸���Ϣ");
		jb2.setBounds(480, 220, 100, 25);
		jb2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				int row=table.getSelectedRow();
				if(row<0)
				{
					JOptionPane.showMessageDialog(null, "δѡ���޸ĵ���");					
				}
				else
				{
					int sid=(Integer)table.getValueAt(row, 0);
					UpdateSupplier frm=new UpdateSupplier(sid);
					frm.setVisible(true);
				}				
			}});			
		bindSupplier();
		this.add(js);
		this.add(jb1);
		this.add(jb2);
		this.add(lbl_img);
	}
public static void  bindSupplier()
		{			
			SupplierDao dao=new SupplierDao();
			ArrayList<Supplier> list=dao.getAllSupplier();
			//JOptionPane.showMessageDialog(null, list.size());
			//��ģ��
			DefaultTableModel dtm=new DefaultTableModel(){
				@Override
				public boolean isCellEditable(int row, int column) {
					// TODO Auto-generated method stub
					return false;
				}		
			};
			dtm.addColumn("������ID");
			dtm.addColumn("��˾");		
			dtm.addColumn("��˾��ַ");
			dtm.addColumn("��ϵ��");
			dtm.addColumn("��ϵ�绰");				
			for (Supplier supplier : list) {		
				Vector vec=new Vector();
				int sid=supplier.getSid();
				String sname=supplier.getSname();				
				String saddress=supplier.getSaddress();
				String slinkname=supplier.getSlinkname();
				String sphone=supplier.getSphone();
				vec.add(sid);
				vec.add(sname);
				vec.add(saddress);
				vec.add(slinkname);
				vec.add(sphone);		
				dtm.addRow(vec);
		}		
			table.setModel(dtm);
			table.getColumnModel().getColumn(0).setMaxWidth(15);
			table.getColumnModel().getColumn(0).setMinWidth(15);
			table.getColumnModel().getColumn(0).setPreferredWidth(15);
			table.getColumnModel().getColumn(2).setMaxWidth(280);
			table.getColumnModel().getColumn(2).setMinWidth(280);
			table.getColumnModel().getColumn(2).setPreferredWidth(280);
			table.getColumnModel().getColumn(3).setMaxWidth(80);
			table.getColumnModel().getColumn(3).setMinWidth(80);
			table.getColumnModel().getColumn(3).setPreferredWidth(80);
		}
public static void main(String[] args){
	SupplierFRM frm=new SupplierFRM();
	frm.setVisible(true);
}
}
