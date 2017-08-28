package com.inner.clazz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class AnonymousInnerClass {
	public static void main(String[] args) {
		TalkingClock tc = new TalkingClock();
		tc.start(1000, true);
		JOptionPane.showConfirmDialog(null, "OK？");
		System.exit(0);
	}
}
class TalkingClock{
	public void start(int interval, boolean beep){
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Date now = new Date();
				System.out.println("At the tone, the time is " + now );
				if(beep){
					System.out.println("bibibibibibibibbi~~~~~~~~~~~~~");
				}
			}
		};
		Timer t = new Timer(interval,listener);
		t.start();
	}
}