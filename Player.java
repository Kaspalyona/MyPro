package ru.java2e;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player { //�������� ������

    public  static final int MAX_V=100; //����������� ���������� ��������
    public static final int MAX_RIGHT = 800;// ������� �������� ������
    public static final int MAX_LEFT = 190;

    Image img = new ImageIcon ("�������/������.png").getImage();//��������� ����������� ������
int v = 10;//��������
int x = 500;//��������� ����������
int s = 0;// ����� ����
int y = 500;// ��������� ����������
int dx = 0; // �������� 
int n =0;


int layer1 = 0; //������ ������
int layer2 = -700;//������ ������

    public Rectangle getRect() {
        return new Rectangle(x,y, 60 ,150);
    }


    public void move() {
   
s += v; // ���������� ����������
x += dx; // �������� �� ��� �



if ( x<=MAX_LEFT ) x= MAX_LEFT;  //������� ������
if(x>=MAX_RIGHT) x=MAX_RIGHT;
if ( v - layer2 <=0 ){
    layer1=0;
    layer2=-700;
} else {
    layer1 += v;
    layer2 += v; 
}
    }
    public void keyPressed (KeyEvent e){ // �������� ������ ���������� 
       int key = e.getKeyCode();
       if (key == KeyEvent.VK_LEFT) {
           dx = -5;
         
       }
       if (key == KeyEvent.VK_RIGHT){
           dx = 5;
           
       }
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT ) {
            dx = 0 ;
            
        }
    }
}


