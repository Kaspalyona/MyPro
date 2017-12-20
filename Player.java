package ru.java2e;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player { //описание игрока

    public  static final int MAX_V=100; //максимально допустимая скорость
    public static final int MAX_RIGHT = 800;// границы движения игрока
    public static final int MAX_LEFT = 190;

    Image img = new ImageIcon ("ресурсы/машина.png").getImage();//добавляем изображение игрока
int v = 10;//скорость
int x = 500;//начальные координаты
int s = 0;// длина пути
int y = 500;// начальная координата
int dx = 0; // движение 
int n =0;


int layer1 = 0; //первая дорога
int layer2 = -700;//вторая дорога

    public Rectangle getRect() {
        return new Rectangle(x,y, 60 ,150);
    }


    public void move() {
   
s += v; // накапление расстояния
x += dx; // движение по оси х



if ( x<=MAX_LEFT ) x= MAX_LEFT;  //дижение дороги
if(x>=MAX_RIGHT) x=MAX_RIGHT;
if ( v - layer2 <=0 ){
    layer1=0;
    layer2=-700;
} else {
    layer1 += v;
    layer2 += v; 
}
    }
    public void keyPressed (KeyEvent e){ // описание метода управления 
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


