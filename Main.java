package ru.java2e;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class Main {


	public static final int PLCount = 4;
	public static int xPL[] = new int[PLCount];
    public static int yPL[] = new int[PLCount];
	
	public static void main(String[] args) {
		
        JFrame f = new JFrame( "Need for speed.����������"); // ������� ����
        
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE); // �������� ����
       
        f.setSize(1100,700); //������ ������
        f.add(new Road()); // ����� ������ ��������� � ����
        f.setVisible(true); // ������ �������
        
       

//��������� ������    
	for (int i = 0; i < Main.PLCount; ++i) {
        xPL[i] = (int) ((Math.random() * 5000) + 5000);
}}}