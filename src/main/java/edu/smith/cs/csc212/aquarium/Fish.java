package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;

public class Fish {
	// Every fish has an x which is an int.
	int x;
	int y;
	Color color;
	boolean isLittle;
	boolean facingLeft;
	int destX;
	int destY;
	
	public Fish(Color c, int startX, 
			int startY, boolean isLittle, 
			boolean facingLeft) {
		this.color = c;
		this.x = startX;
		this.y = startY;
		this.isLittle = isLittle;
		
		this.destX = 450;
		this.destY =450;
	}
	
	public void draw(Graphics2D g) {
		if (isLittle == true && facingLeft == true) {
			DrawFish.smallFacingLeft(g, this.color, 
					this.x, this.y);
		} if (isLittle == true && facingLeft == false) {
			DrawFish.smallFacingRight(g, this.color,
					this.x, this.y);
		} if (isLittle == false && facingLeft == true) {
			DrawFish.facingLeft(g, this.color,
					this.x, this.y);
		} if (isLittle == false && facingLeft == false) {
			DrawFish.facingRight(g, this.color,
					this.x, this.y);
		}
	}
	
	public void swim() {
		if (this.y < this.destY) {
		this.y += 1;
		} else if (this.y > this.destY) {
			this.y -= 1;
		} if (this.x < this.destX) {
			this.x += 1;
		} else if (this.x > this.destX) {
			this.x -= 1;
		}
		
	}

}
