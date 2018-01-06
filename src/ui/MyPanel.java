package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements Runnable
{
    int times=0;

    //定义开始
    @Override
	public void paint(Graphics g)
    {
        super.paint(g);
        //g.fillRect(0, 0, 500, 100);//画纯色背景
        if(times%2==0)
        {
            g.setColor(Color.black);
            //开关信息的字体					
            Font myFont=new Font("华文新魏",Font.BOLD,20);
            g.setFont(myFont);
            g.drawString("丁珂", this.getWidth()-85, 20);
            g.setColor(Color.BLUE);
            g.drawString("刘笔余", this.getWidth()-85, 40);
            g.setColor(Color.yellow);
            g.drawString("颜满高", this.getWidth()-85, 60);
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(true)
        {
            //休眠
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                times++;
                //重画
                this.repaint();
        }
    }
}