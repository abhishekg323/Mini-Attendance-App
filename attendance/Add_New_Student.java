package attendance;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Add_New_Student {
	JFrame frame;
	JTextField tf1;
	JButton bt;
	Container con;
	File f;
	FileWriter writer;
	PrintWriter wr;
	public Add_New_Student() {
		
		frame=new JFrame();
		frame.setResizable(false);
		con=frame.getContentPane();
		frame.setSize(400,400);
		tf1=new JTextField();
		tf1.setBounds(100,100,200,40);
		tf1.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					StudentAdder();
				}
			}
		});
		bt=new JButton("Add ( or Hit Enter)");
		bt.setBounds(100,150,200,40);
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentAdder();
				
			}
		});
		frame.add(bt);
		frame.add(tf1);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	

	protected void StudentAdder() {
		f=new File("Students.txt");
		
		try {
		writer=new FileWriter(f, true);
		String get=tf1.getText();
		if(get.isBlank())
			return;
		writer.append(get);
		writer.write('@');
		writer.close();
		
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		tf1.setText("");
		
	}


	public static void main(String[] args) {
		new Add_New_Student();

	}

}
