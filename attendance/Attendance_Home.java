package attendance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Attendance_Home extends JFrame{
	JButton bt1,bt2,bt3;
	public Attendance_Home() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		bt1=new JButton("Add New Student");
		bt2=new JButton("Today's Attendance");
		bt3=new JButton("Flush Students Database");
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Add_New_Student abc=new Add_New_Student();
				
				
				
			}
		});
		bt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new View_Students();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		setResizable(false);
		bt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					PrintWriter pr=new PrintWriter("Students.txt");
					pr.append("");
					pr.close();
					JOptionPane.showMessageDialog(bt3, "Database Emptied");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		bt1.setBounds(65, 70, 200, 40);
		bt2.setBounds(65, 120, 200, 40);
		bt3.setBounds(65, 170, 200, 40);
		add(bt1);
		add(bt2);
		add(bt3);
		setLayout(null);
		setSize(350,340);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		Attendance_Home v=new Attendance_Home();
		

	}

}
