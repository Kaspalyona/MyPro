package ru.java2e;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class Main {


	public static final int PLCount = 4;
	public static int xPL[] = new int[PLCount];
    public static int yPL[] = new int[PLCount];
	
	public static void main(String[] args) {
		
        JFrame f = new JFrame( "Need for speed.неизданное"); // создаем окно
        
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE); // закрытие окна
       
        f.setSize(1100,700); //задаем размер
        f.add(new Road()); // класс дорога добавляем в окно
        f.setVisible(true); // делаем видимым
        
       

//координаті врагов    
	for (int i = 0; i < Main.PLCount; ++i) {
        xPL[i] = (int) ((Math.random() * 5000) + 5000);
}}}