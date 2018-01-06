package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class StringPanel extends JPanel{
	
	String string;
	public StringPanel(String string) {
		this.string =  string;
	}
	
	@Override
	public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, 500, 300);
        g.setColor(Color.white);
        Font myFont=new Font("»ªÎÄÐÂÎº",Font.BOLD,30);
        g.setFont(myFont);
        g.drawString(string, 120, 40);
    }
}

