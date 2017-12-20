package ru.java2e;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Road extends JPanel implements ActionListener, Runnable{  // �������� ������ ������
  
	Timer mainTimer = new Timer(10, this); // ������� ������

    Image img = new ImageIcon("�������/doroga.jpg").getImage(); //��� 
    Player p = new Player();//��������� ������ ������ �� ������
    Thread PLFactory = new Thread(this); // ������ ����� ������

    List<PL> pl = new ArrayList<PL>(); // ������� ����� ������

    public Road(){
        mainTimer.start(); //��������� ������
        PLFactory.start();
        addKeyListener(new myKeyAdapter());
        setFocusable(true);
       
    }

    @Override
    public void run() { // ����� ���������� ��������� ������ �� ������
        while(true) {
            Random rand = new Random();
            try {
                Thread.sleep(rand.nextInt(3500));
                pl.add(new PL(rand.nextInt(800),0, rand.nextInt(1),this));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class myKeyAdapter extends KeyAdapter{// ���������� �������
        public void keyPressed (KeyEvent e){
            p.keyPressed(e);
        }
        public void keyReleased (KeyEvent e) {
            p.keyReleased(e);
        }
    }

    public void paint(Graphics g) { // ������ �������, ����� �������������� ���� ������� ����� ����������
        g = (Graphics2D) g ;// ���������� �����
        g.drawImage(img,0,p.layer1,null); // ������ ������
        g.drawImage(img,0,p.layer2,null);
        g.drawImage(p.img , p.x ,p.y, null);// �����
        g.setColor(Color.YELLOW); // ��������� �����
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + p.s, 30,100 );

        Iterator<PL> i = pl.iterator();  // ������ ������, � ���������� ������� ���������
        while (i.hasNext()){
            PL e = i.next();
            if(e.x >= 800|| e.x <=200 ){
                i.remove();}
                else{ 
                e.move();
            g.drawImage(e.img,e.x,e.y,null);}}
                }
    
        
            
    
public void actionPerformed(ActionEvent e) {// ������� 
    p.move(); //��������
    repaint(); //�����������
    testCollisionWithPL();

    
   
}

    private void testCollisionWithPL() { //������������� ������������
        Iterator<PL> i = pl.iterator();
        while (i.hasNext()){
            PL e = i.next();
            if(p.getRect().intersects(e.getRect())){
                JOptionPane.showMessageDialog(null,"Game over");
                System.exit(1);
            }
        }
    }
}
