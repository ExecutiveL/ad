package Studinfo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import com.github.lgooddatepicker.components.DatePicker;

import net.proteanit.sql.DbUtils;

public class StudentInformationSystem {

	private JFrame StudentInformationSystem;
	private JTable table;
	private JTextField studentid;
	private JTextField Fname;
	private JTextField Lname;
	private JTextField Age;
	private JTextField Mname;
	private JTextField Ftname;
	private JTextField Cpno;
	private JTextField Address;
	private static Connection con;;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				         Class.forName("org.sqlite.JDBC");
				           con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ralp\\Desktop\\StudentInformationSystem.db"); // connecting to our 
			               con.setAutoCommit(false);
			                System.out.println("Connected");
					StudentInformationSystem window = new StudentInformationSystem();
					window.StudentInformationSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentInformationSystem() {
		initialize();
		try { 
			String query = "Select * from StudentInfo";
		    PreparedStatement pst = con.prepareStatement(query);
		    ResultSet resultset = pst.executeQuery();
		    table.setModel (DbUtils.resultSetToTableModel(resultset));
	    } catch (Exception s) {
		    s.printStackTrace();
	   }
	 }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		StudentInformationSystem = new JFrame();
		StudentInformationSystem.getContentPane().setBackground(new Color(176, 224, 230));
		StudentInformationSystem.setBounds(100, 100, 888, 420);
		StudentInformationSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		StudentInformationSystem.getContentPane().setLayout(null);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(249, 21, 613, 349);
		StudentInformationSystem.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBackground(Color.cyan);
		table.setDefaultEditor(Object.class, null);
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
       
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		table.getTableHeader().setReorderingAllowed(false);
		
		JLabel StudentIDLabel = new JLabel("Student ID");
		StudentIDLabel.setBounds(10, 11, 65, 14);
		StudentInformationSystem.getContentPane().add(StudentIDLabel);
		
		JLabel FnameLabel = new JLabel("FirstName");
		FnameLabel.setBounds(10, 37, 53, 14);
		StudentInformationSystem.getContentPane().add(FnameLabel);
		
		JLabel LnameLabel_1 = new JLabel("LastName");
		LnameLabel_1.setBounds(10, 68, 53, 14);
		StudentInformationSystem.getContentPane().add(LnameLabel_1);
		
		JLabel gndr = new JLabel("Gender");
		gndr.setBounds(10, 93, 46, 14);
		
		JLabel AgeLabel_2 = new JLabel("Age");
		AgeLabel_2.setBounds(17, 125, 46, 14);
		StudentInformationSystem.getContentPane().add(AgeLabel_2);
		JLabel Bdate = new JLabel("Birthdate");
		Bdate.setBounds(10, 157, 46, 14);
		StudentInformationSystem.getContentPane().add(Bdate);
		
		JLabel MnameLabel_4 = new JLabel("MotherName");
		MnameLabel_4.setBounds(10, 182, 65, 14);
		StudentInformationSystem.getContentPane().add(MnameLabel_4);
		
		JLabel FnameLabel_5 = new JLabel("FatherName");
		FnameLabel_5.setBounds(10, 207, 65, 14);
		StudentInformationSystem.getContentPane().add(FnameLabel_5);
		
		JLabel CpnoLabel_6 = new JLabel("CellphoneNumber");
		CpnoLabel_6.setBounds(0, 232, 89, 14);
		StudentInformationSystem.getContentPane().add(CpnoLabel_6);
		
		JLabel AddressLabel_7 = new JLabel("Address");
		AddressLabel_7.setBounds(10, 257, 46, 14);
		StudentInformationSystem.getContentPane().add(AddressLabel_7);
		
		JComboBox gender = new JComboBox();
		gender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female","Prefer not to say"}));
		gender.setToolTipText("\r\n");
		gender.setBounds(126, 89, 92, 22);
		StudentInformationSystem.getContentPane().add(gender);
		
		DatePicker bdate = new DatePicker();
		bdate.setBounds(84, 151, 139, 20);
		StudentInformationSystem.getContentPane().add(bdate);
		
		StudentInformationSystem.getContentPane().add(gndr);
		studentid = new JTextField();
		studentid.setBounds(91, 8, 132, 20);
		StudentInformationSystem.getContentPane().add(studentid);
		studentid.setColumns(10);
		((AbstractDocument)studentid.getDocument()).setDocumentFilter(new DocumentFilter() {
		      public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
		        fb.insertString(offset, string.replaceAll("[^0-9]", ""), attr);
		      }
		      
		      public void replace(FilterBypass fb, int offset, int length, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
		        fb.replace(offset, length, string.replaceAll("[^0-9]", ""), attr);
		      }
		    });
		Fname = new JTextField();
		Fname.setBounds(91, 34, 132, 20);
		StudentInformationSystem.getContentPane().add(Fname);
		Fname.setColumns(10);
		
		Lname = new JTextField();
		Lname.setBounds(91, 65, 132, 20);
		StudentInformationSystem.getContentPane().add(Lname);
		Lname.setColumns(10);
		
		Age = new JTextField();
		Age.setBounds(182, 119, 36, 23);
		StudentInformationSystem.getContentPane().add(Age);
		Age.setColumns(10);
		((AbstractDocument)Age.getDocument()).setDocumentFilter(new DocumentFilter() {
		      public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
		        fb.insertString(offset, string.replaceAll("[^0-9]", ""), attr);
		      }
		      
		      public void replace(FilterBypass fb, int offset, int length, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
		        fb.replace(offset, length, string.replaceAll("[^0-9]", ""), attr);
		      }
		    });
		Mname = new JTextField();
		Mname.setBounds(91, 178, 132, 20);
		StudentInformationSystem.getContentPane().add(Mname);
		Mname.setColumns(10);
		
		Ftname = new JTextField();
		Ftname.setBounds(91, 204, 132, 20);
		StudentInformationSystem.getContentPane().add(Ftname);
		Ftname.setColumns(10);
		
		Cpno = new JTextField();
		Cpno.setBounds(91, 229, 132, 20);
		StudentInformationSystem.getContentPane().add(Cpno);
		Cpno.setColumns(10);
		((AbstractDocument)Cpno.getDocument()).setDocumentFilter(new DocumentFilter() {
		      public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
		        fb.insertString(offset, string.replaceAll("[^0-9]", ""), attr);
		      }
		      
		      public void replace(FilterBypass fb, int offset, int length, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
		        fb.replace(offset, length, string.replaceAll("[^0-9]", ""), attr);
		      }
		    });
		Address = new JTextField();
		Address.setBounds(91, 254, 132, 20);
		StudentInformationSystem.getContentPane().add(Address);
		Address.setColumns(10);
		

		JButton AddButton = new JButton("Add");
		AddButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                	String StudentId = studentid.getText();
     				String FirstName = Fname.getText();
     				String LastName = Lname.getText();
     				String Gender = gender.getSelectedItem().toString();
		            String Bdate = bdate.getDateStringOrEmptyString();
     				String age = Age.getText();
     				String mothername = Mname.getText();
     				String fathername = Ftname.getText();
     				String cpno = Cpno.getText();
     				String address = Address.getText();
     				if (StudentId.trim().isEmpty() || FirstName.trim().isEmpty() || LastName.trim().isEmpty() || Gender.trim().isEmpty() ||
     					Bdate.trim().isEmpty() || age.trim().isEmpty() || mothername.trim().isEmpty() || fathername.trim().isEmpty() || cpno.trim().isEmpty()
     					|| address.trim().isEmpty() ) {
     					  return;
     				        }
     				try {
     					String checkKey = "SELECT * FROM StudentInfo WHERE UserID = ?";
    					PreparedStatement stat = con.prepareStatement(checkKey);
    					stat.setString(1, StudentId);
    					ResultSet res = stat.executeQuery();

    					if (res.next()) {
    					    // key exists
    						JOptionPane.showMessageDialog(null, "Student id is already on database!", "ERROR", JOptionPane.ERROR_MESSAGE);
    						return;
    					}
					  //Storing StudentDetails into Database
					 String sql = ("INSERT INTO StudentInfo (UserID,FirstName,LastName,Gender,Age,Birthdate,MotherName,FatherName,CellphoneNumber,Address) VALUES (?,?,?,?,?,?,?,?,?,?)");
				    PreparedStatement statement = con.prepareStatement(sql);
				    statement.setString(1, StudentId);
				    statement.setString(2, FirstName);
				    statement.setString(3, LastName);
				    statement.setString(4, Gender);
				    statement.setString(6, Bdate);
				    statement.setString(5, age);
				    statement.setString(7, mothername);
				    statement.setString(8, fathername);
				    statement.setString(9, cpno);
				    statement.setString(10, address);
				    statement.executeUpdate();
				    con.commit();
				    JOptionPane.showMessageDialog(null, "Student information saved successfuly!", "Saved Successfuly!", JOptionPane.INFORMATION_MESSAGE);
				    String query = "Select * from StudentInfo";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet resultset = pst.executeQuery();
					table.setModel (DbUtils.resultSetToTableModel(resultset));
				} catch (Exception s) {
					s.printStackTrace();
		 }
			
				  }
		});
		AddButton.setBounds(10, 307, 89, 23);
		
		AddButton.setBackground(Color.GREEN);
		StudentInformationSystem.getContentPane().add(AddButton);
		
		JButton UpdateButton = new JButton("Update");
		UpdateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String StudentId = studentid.getText();
 				String FirstName = Fname.getText();
 				String LastName = Lname.getText();
 				String Gender = gender.getSelectedItem().toString();
	            String Bdate = bdate.getDateStringOrEmptyString();
 				String age = Age.getText();
 				String mothername = Mname.getText();
 				String fathername = Ftname.getText();
 				String cpno = Cpno.getText();
 				String address = Address.getText();
 				if (StudentId.trim().isEmpty() || FirstName.trim().isEmpty() || LastName.trim().isEmpty() || Gender.trim().isEmpty() ||
 					Bdate.trim().isEmpty() || age.trim().isEmpty() || mothername.trim().isEmpty() || fathername.trim().isEmpty() || cpno.trim().isEmpty()
 					|| address.trim().isEmpty() ) {
 					JOptionPane.showMessageDialog(null, "All Field must not be empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
 					  return;
 				     }
			   try {
				   String query = "Update StudentInfo set UserID ='"+studentid.getText()+"' ,FirstName='"+Fname.getText()+
				   "' ,LastName='"+Lname.getText()+"', Gender='"+gender.getSelectedItem().toString()+"' ,Age='"+Age.getText()+
				   "' ,Birthdate='"+bdate.getDateStringOrEmptyString()+"' ,MotherName='"+Mname.getText()+"' ,FatherName='"+Mname.getText()+
				   "' ,CellphoneNumber='"+Cpno.getText()+"' ,Address='"+Address.getText()+"' where UserID='"+studentid.getText()+"' "; 
				   
				   PreparedStatement pst = con.prepareStatement(query);
				   
				   pst.execute();
				   
				   JOptionPane.showMessageDialog(null,"Data Updated");
				   
				   
				   pst.close();
				    String que = "Select * from StudentInfo";
					PreparedStatement ps = con.prepareStatement(que);
					ResultSet resultset = ps.executeQuery();
					table.setModel (DbUtils.resultSetToTableModel(resultset));
			   } catch (Exception ex) {
				   ex.printStackTrace();
			   }
			 }
		
		});
		UpdateButton.setBounds(109, 307, 89, 23);
		StudentInformationSystem.getContentPane().add(UpdateButton);
		
		JButton DelButton = new JButton("Delete");
		DelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String query = "DELETE FROM StudentInfo WHERE UserID =?";
					con.commit();
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, studentid.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Data Deleted");	
					
				    String que = "Select * from StudentInfo";
					PreparedStatement ps = con.prepareStatement(que);
					ResultSet resultset = ps.executeQuery();
					table.setModel (DbUtils.resultSetToTableModel(resultset));
				} catch (Exception s) {
					s.printStackTrace();
				 }
				
			}
			
		});
		DelButton.setBounds(109, 341, 89, 23);
		DelButton.setForeground(Color.WHITE);
		DelButton.setBackground(Color.RED);
		StudentInformationSystem.getContentPane().add(DelButton);
		
	}
}