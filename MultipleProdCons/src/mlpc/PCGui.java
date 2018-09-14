package mlpc;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PCGui{
	
	public static JTextArea pText, cText;
	
	public PCGui(Number[] st){
		
		
		JFrame f = new JFrame("PC");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(500, 500, 500, 500);
		f.setResizable(false);
		f.getContentPane().setLayout(null);
		f.setBackground(Color.GRAY);
		f.setVisible(true);
		
		JButton prod = new JButton("Producer");
		prod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread(new Producer(st));
				t.start();
			}
		});
		prod.setBounds(0, 0, 100, 30);
		f.getContentPane().add(prod);
		
		JButton cons = new JButton("Consumer");
		cons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread(new Consumer(st));
				t.start();
			}
		});
		cons.setBounds(400, 0, 100, 30);
		f.getContentPane().add(cons);
		
		JButton end = new JButton("Terminate All");
		end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MPCMain.C.drainPermits();
				MPCMain.P.drainPermits();
				MPCMain.Reads.drainPermits();
				MPCMain.Writes.drainPermits();
			}
		});
		end.setBounds(180,0,120,30);
		f.getContentPane().add(end);
		
		pText = new JTextArea();
		JScrollPane jspPr = new JScrollPane(pText);
		jspPr.setBackground(Color.WHITE);
		jspPr.setBounds(0, 30, 240, 441);
		f.getContentPane().add(jspPr);
		
		cText = new JTextArea();
		JScrollPane jspCo = new JScrollPane(cText);
		jspCo.setBackground(Color.WHITE);
		jspCo.setBounds(260, 30, 234, 441);
		f.getContentPane().add(jspCo);
	}

}
