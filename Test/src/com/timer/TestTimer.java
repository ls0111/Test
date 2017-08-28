package com.timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TestTimer {
	private boolean beep = true;
	public static void main(String[] args) {
		ActionListener listener = (ActionEvent e)->{
			System.out.println("Hello world!!!");
		};
		Timer t = new Timer(5000,listener);
		t.start();
		JOptionPane.showMessageDialog(null, "Exit ?");
		System.exit(0);
		
	}
	
	public A getA(){
		A a = this.new A();
		return new A();
	}
	private class A{
		private boolean in = TestTimer.this.beep;
	}
}
