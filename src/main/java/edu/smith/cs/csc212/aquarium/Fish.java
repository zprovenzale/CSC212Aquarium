package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

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
		
		this.destX = this.x;
		this.destY = this.y;
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
		if (this.x == this.destX || this.y == this.destY) {
			Random rand = new Random();
			this.destX = rand.nextInt(500);
			this.destY = rand.nextInt(500);
			if (this.x > this.destX) {
				this.facingLeft = true;
			} else if (this.x < this.destX) {
				this.facingLeft = false;
			}
		}
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
