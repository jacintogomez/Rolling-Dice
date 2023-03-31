package PartIV;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Font;


public class RollDice extends JFrame {
	
	private int score;
    private JButton button;
    private JLabel totalscorelabel;
    private ImagePanel firstdie;
    private ImagePanel seconddie;
    private ImagePanel linepanel;
    private JLabel finishedlabel;

	public int getScore() {
		return score;
	}

	public RollDice() {
    	this.score=0;
    	this.firstdie = new ImagePanel("die1.png");
		this.seconddie = new ImagePanel("die1.png");
    	totalscorelabel = new JLabel("Total Score: "+score);
    	finishedlabel=new JLabel("");
    	finishedlabel.setFont(new Font("Arial", Font.BOLD, 28));
    	JFrame frame=new JFrame();
    	this.setBackground(Color.LIGHT_GRAY);
    	setSize(700,700);
    	createbutton();
    	createpanel();
    }
    
    public void createpanel() {
    	JPanel mainPanel = new JPanel();
    	JPanel middlepanel=new JPanel();
		mainPanel.setLayout(new GridLayout(1,3));
		JPanel temppanel=new JPanel();
		Dimension size = new Dimension(800,180);
		mainPanel.add(firstdie);
		mainPanel.add(seconddie);
		this.add(mainPanel);
        middlepanel.add(button);
        JPanel southpanel = new JPanel(new BorderLayout());
        JPanel datapanel = new JPanel();
        linepanel = new ImagePanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLUE);
                int h=getHeight();
                int w=getWidth();
                System.out.println(h+" and this "+w);
                int os=(w-h)/2;
                g.drawLine(os, h/7, os+h*5/7, h/7);
                g.drawLine(os, 2*h/7, os+h*5/7, 2*h/7);
                g.drawLine(os, 3*h/7, os+h*5/7, 3*h/7);
                g.drawLine(os, 4*h/7, os+h*5/7, 4*h/7);
                g.drawLine(os, 5*h/7, os+h*5/7, 5*h/7);
                g.drawLine(os, 6*h/7, os+h*5/7, 6*h/7);
                g.drawLine(os,h/7,os,h*6/7);
                g.drawLine(os+h/7,h/7,os+h/7,h*6/7);
                g.drawLine(os+2*h/7,h/7,os+2*h/7,h*6/7);
                g.drawLine(os+3*h/7,h/7,os+3*h/7,h*6/7);
                g.drawLine(os+4*h/7,h/7,os+4*h/7,h*6/7);
                g.drawLine(os+5*h/7,h/7,os+5*h/7,h*6/7);
                g.setColor(Color.BLACK);
                System.out.println(score+" for "+((ImagePanel)linepanel).getDotx()+" and "+((ImagePanel)linepanel).getDoty());
                g.fillOval(((ImagePanel)linepanel).getDotx(),((ImagePanel)linepanel).getDoty(),20,20);
            }
        };
        linepanel.setPreferredSize(new Dimension(800, 1));
        datapanel.add(totalscorelabel);
        mainPanel.add(finishedlabel,BorderLayout.SOUTH);
        add(mainPanel,BorderLayout.NORTH);
        add(linepanel, BorderLayout.CENTER);
        southpanel.add(middlepanel, BorderLayout.EAST);
        southpanel.add(totalscorelabel,BorderLayout.WEST);
        add(southpanel,BorderLayout.SOUTH);
        button.setPreferredSize(new Dimension(100, 50));
    }
    			
    
    public void createbutton() {
    	button=new JButton("Roll Dice");
    	
    	class AddRollListener implements ActionListener{
    		public void actionPerformed(ActionEvent event) {
    			int roll1=0,roll2=0;
    			roll1=(int)(Math.random()*6)+1;
    			roll2=(int)(Math.random()*6)+1;
    			firstdie.setimagepath("die"+roll1+".png");
    			seconddie.setimagepath("die"+roll2+".png");
    			firstdie.repaint();
    			seconddie.repaint();
    			linepanel.repaint();
    			//}
    			score+=roll1+roll2;
    			totalscorelabel.setText("Total Score: "+score);
    			((ImagePanel)linepanel).setdots(score);
    			if(score>=24) {
    				finishedlabel.setText("Finished!");
    			}
    		}
    	}
    	button.addActionListener(new AddRollListener());
    }

    public static void main(String[] args) {
    	JFrame rolldice = new RollDice();
        rolldice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rolldice.setVisible(true);    
        rolldice.setResizable(false);
    }
}

