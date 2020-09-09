package attendance;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class View_Students extends JFrame {

	private JPanel contentPane;
	File f,day;
	FileWriter write;
	
	Scanner sc;
	WithBtn l[];
	int w;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Students frame= new View_Students();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View_Students() throws Exception {
		setResizable(false);
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					Scanner ab=new Scanner(day);
					if(ab.hasNextLine()) {
						String[] list=ab.nextLine().split("@@");
						ab.close();
						PrintWriter a=new PrintWriter(day);
						String dt="";
						LocalDate d=LocalDate.now();
						DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd MMM YYYY");
						dt=dtf.format(d);
						a.println("##`"+dt+"`");
						a.println("---");
						a.println();
						for(int i=0;i<list.length;i++) {
							a.println(list[i]+"");
							a.println("---");
						}
						a.println();
						a.println("---");
						a.close();
						Runtime runtime =Runtime.getRuntime();
						try {
							runtime.exec("notepad Day.txt");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		setTitle("Attendance");
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		w=450;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		f=new File("Students.txt");
		day=new File("Day.txt");
		write=new FileWriter(day);
		write.write("");
		write.close();
//		write=new PrintWriter(day);
		sc=new Scanner(f);
		String[] st;
		int s;
		setLayout(null);
		if(sc.hasNextLine()) {
			st=sc.nextLine().split("@");
			l=new WithBtn[st.length];
			s=60*st.length;
			setBounds(100, 100, w, 40+s);
			int z=10;
			for(int i=0;i<st.length;++i) {
				l[i]=new WithBtn(st[i]);
				l[i].setBounds(0, z, w, 40);
				z+=50;
				contentPane.add(l[i]);
			}
		}
		else {
			setBounds(100, 100, w, 150);
			JOptionPane.showMessageDialog(this, "No Records Found");
		}
		contentPane.add(new JLabel());
		
		setContentPane(contentPane);
	}
	class WithBtn extends JPanel implements ActionListener{
		JLabel lbl;
		JButton bt1,bt2,bt3;
		int count=0;
		
		WithBtn(String s){
			
			lbl= new JLabel(s);
			lbl.setPreferredSize(new Dimension(70, 30));
			add(lbl);
			bt1=new JButton("Present");
			bt1.addActionListener(this);
			bt2=new JButton("Absent");
			bt3=new JButton("No Class");
			bt2.addActionListener(this);
			bt3.addActionListener(this);
			add(bt1);
			add(bt2);
			add(bt3);
			
			setVisible(true);
		}
		@Override
		public void actionPerformed(ActionEvent e){
			try {
				if(count<1) {
					write=new FileWriter(day,true);
					if(e.getSource()==bt1) {
						write.write(">- ###"+lbl.getText()+" : "+"Present"+"@@");
						bt1.setBackground(Color.GREEN);
					}
					else if(e.getSource()==bt2){
						write.write(">- ###"+lbl.getText()+" : "+"Absent"+"@@");
						bt2.setBackground(Color.RED);
						bt2.setForeground(Color.WHITE);
					}
					else {
						write.write(">- ###"+lbl.getText()+" : "+"No Scheduled Class"+"@@");
						bt3.setBackground(Color.CYAN);
						
					}
					write.close();
					count++;
				}
				else {
					JOptionPane.showMessageDialog(this, "You have already put\nthe Attendance of "+lbl.getText());
				}
			}
			catch(Exception ee) {
				ee.printStackTrace();
			}
			
		}
		
	}

}
