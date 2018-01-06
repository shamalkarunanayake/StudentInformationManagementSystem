package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class PicPanel extends JPanel{
	
	Image img;
	public void create_pic(String imgPath) {
		img = Toolkit.getDefaultToolkit().createImage(imgPath);
	}
	public PicPanel(String imgPath) {
		this.create_pic(imgPath);
	}
	
	@Override
	public void paint(Graphics g)
    {
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
