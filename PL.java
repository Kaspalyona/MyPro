package ru.java2e;


import javax.swing.*;
import java.awt.*;

public class PL {
    int x;
    int y;
    int v;
    Image img = new ImageIcon("ресурсы/car.png").getImage();
 
    Road road;

    public Rectangle getRect() { // добавляем прямоугольник, для проработки столкновений
        return new Rectangle(x,y, 60 ,150);
    }

    public PL(int x, int y, int v, Road road ){
    	
         this.x=x;
        this.y=y;
        this.v=v;
        this.road= this.road; 
        
    }
    public void move (){
         y++ ;
       
      
       
}
}
