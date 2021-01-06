package Jframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

public class JframeRunner {
	static JFrame frame = new JFrame("MY test");
	static JLabel label1 = new JLabel();
	static JLabel label2 = new JLabel();
	static JLabel label4 = new JLabel();

	public static void main(String[] args) {

		frame.setSize(300, 300);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label1.setBounds(95, 50, 210, 110);
		label2.setBounds(95, 120, 210, 110);
		label4.setBounds(70, 190, 210, 110);
		frame.add(label1);
		frame.add(label2);
		frame.add(label4);
		JButton btn = new JButton("test1");
		btn.setBounds(90, 50, 120, 40);
		JButton btn1 = new JButton("test2");
		btn1.setBounds(90, 120, 120, 40);
		JButton btn2 = new JButton("test3");
		btn2.setBounds(90, 190, 120, 40);
		frame.add(btn);
		frame.add(btn1);
		frame.add(btn2);
		btn.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent arg0) {
				try {
					JUnitCore junit = new JUnitCore();
					junit.addListener(new TextListener(System.out));
					junit.run(label1.class);
				} catch (Exception e) {
					e.printStackTrace();
					label1.setText("test 1 fail");
				}

			}
		});
		btn1.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent arg0) {
				try {
					JUnitCore junit = new JUnitCore();
					junit.addListener(new TextListener(System.out));
					junit.run(label2.class);
				} catch (Exception e) {
					e.printStackTrace();
					label2.setText("test 2 fail");
				}

			}
		});
		btn2.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent arg0) {
				try {
					label3.main(null);
				} catch (Exception e) {
					e.printStackTrace();
					label4.setText("test 3 fail");
				}

			}
		});

//
	}
//
}
