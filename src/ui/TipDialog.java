package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TipDialog extends JDialog implements ActionListener{
	JButton bt;
	JLabel tip;
	JFrame j;
	public TipDialog(String info) {
		bt = new JButton("确认");
		tip = new JLabel(info);
		tip.setHorizontalAlignment(SwingConstants.CENTER);
		this.setLayout(new BorderLayout());
		this.add(tip, BorderLayout.CENTER);
		this.add(bt, BorderLayout.SOUTH);
		this.setSize(200,150);
		this.setLocation(300, 400);
		this.setVisible(true);
		bt.addActionListener(this);
	}
	
	public TipDialog(String info, JFrame j) {
		bt = new JButton("确认");
		tip = new JLabel(info);
		tip.setHorizontalAlignment(SwingConstants.CENTER);
		this.setLayout(new BorderLayout());
		this.add(tip, BorderLayout.CENTER);
		this.add(bt, BorderLayout.SOUTH);
		this.setSize(200,150);
		this.setLocation(300, 400);
		this.setVisible(true);
		bt.addActionListener(this);
		j.dispose();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bt) {
			this.dispose();
		}
	}
}
