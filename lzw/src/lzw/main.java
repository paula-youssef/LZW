package lzw;

import javax.swing.JOptionPane;

import java.io.*;
import java.util.*;
import java.awt.*;  
import java.awt.event.MouseEvent;

import javax.swing.*;  

import java.io.*;  

public class main {
	
	

public static void main(String[] args) {
	String message =JOptionPane.showInputDialog(null,"input the file nsme:","the file directory and name: ",JOptionPane.PLAIN_MESSAGE);
	compression o =new compression();
	o.ReadTheFile(message);
	o.makeMyDictionary();
	o.compress();
	try{o.writeOnFile();}catch(Exception e){}
	//o.ReadTheFile();
	 }
}
