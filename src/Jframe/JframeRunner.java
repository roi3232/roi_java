package Jframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

public class JframeRunner {

	public static void main(String[] args) {
		JFrame frame= new JFrame ("MY test");
		frame.setSize(300, 400);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label1=new JLabel();
		label1.setBounds(100,120,200,50);
		frame.add(label1);
		JButton btn=new JButton("test1");
		btn.setBounds(150, 100, 120, 40);
		frame.add(btn);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				label1.setText("test1");
				JUnitCore junit = new JUnitCore();
				junit.addListener(new TextListener (System. out));
				junit.run(label1.class);
				label1.setText("");

			}
		});
		


//
	}
//
}
