package edu.smith.cs.csc212.aquarium;

import java.awt.Graphics2D;
import java.util.Random;

public class BubbleSystem {
	int num;
	Bubble[] bubbles;
	
	public BubbleSystem (int num) {
		this.num = num; //number of bubbles
		//create an array of num bubbles
		Bubble[] bubbles = new Bubble[this.num];
		for(int i=0; i<this.num; i++) {
			Random rand = new Random();
			int x = rand.nextInt(70) + 350;
			int y = i * 40 + rand.nextInt(5) + 450;
			int r = rand.nextInt(20) + 10;
			int speed = rand.nextInt(3) + 1;
			//System.out.println(y);
			Bubble bubble = new Bubble(x, y, r, speed);
			bubbles[i] = bubble;

		}
		this.bubbles = bubbles;
		//System.out.println(bubbles);
	}
	public void draw(Graphics2D g) {
		for(int i = 0; i<this.num; i++) {
			bubbles[i].draw(g);
		}
	}
	public void rise() {
		for(int i = 0; i<this.num; i++) {
			bubbles[i].rise();
		}
	}
	
	public void wiggle() {
		for(int i = 0; i<this.num; i++) {
			bubbles[i].wiggle();
		}
	}

}
