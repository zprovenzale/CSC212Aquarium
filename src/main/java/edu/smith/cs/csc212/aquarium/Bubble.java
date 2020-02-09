package edu.smith.cs.csc212.aquarium;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import java.awt.Color;

public class Bubble {
	int x;
	int startX;
	int y;
	int r;
	int speed;
	
	public Bubble(int startX, int startY, int r, int speed) {
		this.x = startX;
		this.startX = startX;
		this.y = startY;
		this.r = r;
		this.speed = speed;
	}
	
	public void draw(Graphics2D g) {
		Shape circle = new Ellipse2D.Double(
				this.x, this.y, this.r, this.r);
		
		g.setColor(Color.white);
		g.fill(circle);
		g.draw(circle);
	}
	
	public void rise() {
		//go up at the specified speed, and if it goes
		// well past the top of the tank, reappear
		//below the tank
		this.y -= this.speed;
		if (this.y < -100) {
			this.y = 500;
			
			//Lots of wiggling can make bubbles
			//go to far left or right, so every
			//time the fish goes back to the bottom,
			//restart its x position
			this.x = this.startX;
		}
	}
	
	public void wiggle() {
		Random rand = new Random();
		this.x += rand.nextInt(3) - 1;
		
	}
		

}
