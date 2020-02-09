package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Shark {
	int x;
	int y;
	int speed;
	boolean facingLeft;
	int destX;
	int destY;
	
	Fish[] fish;
	int numFish;
	int fishX;
	int fishY;
	int count;
	//Fish[] fish;
	//Fish fish;
	
	public Shark() { //Fish[] fish) {
		//this.fish = fish;
		
		this.x = 600;
		this.y = 250;
		this.destX = 400;
		this.destY = 250;
		this.numFish = 10;
		this.count = 0;
		
		Fish[] fish = new Fish[this.numFish];
		for(int i=0; i<this.numFish; i++) {
			Random rand = new Random();
			this.fishX = rand.nextInt(500);
			this.fishY = rand.nextInt(500);
			Fish aFish = new Fish(Color.magenta, 
					this.fishX, this.fishY, true, true);
			fish[i] = aFish;
		}
		this.fish = fish;
	}
	
	public void draw(Graphics2D g) {
		if(facingLeft == true) {
			DrawFish.facingLeft(g, Color.gray, this.x, this.y);
		} else {
			DrawFish.facingRight(g, Color.gray, this.x, this.y);
		}
	}
		
	
	/*
	 * public void makeFish(int numFish) { this.numFish = numFish;
	 * 
	 * Fish[] fish = new Fish[this.numFish]; for(int i=0; i<this.numFish; i++) {
	 * Random rand = new Random(); this.fishX = rand.nextInt(500); this.fishY =
	 * rand.nextInt(500); Fish aFish = new Fish(Color.magenta, this.fishX,
	 * this.fishY, true, true); fish[i] = aFish; } this.fish = fish; }
	 */
	
	public void drawFish(Graphics2D g) {
		for(int i=0; i<this.numFish; i++) {
			this.fish[i].draw(g);
		}
	}
	
	public void swimFish() {
		for(int i=0; i<this.numFish; i++) {
			fish[i].swim();
		}
	}
	
	public void swim() {
		if (this.x == this.destX && this.y == this.destY) {
			if(count != numFish) {
				fish[count].active = false;
				count += 1;
			} else {
			//if(count == numFish) {
				this.destX = -100;
			}
		}
		
		//this.destX = fish.x;
		//this.destY = fish.y;

		//go either up or down and left or right
		//depending on where the destination is
		//in relation to the fish and face the
		//destination
		if(count != numFish) {
			this.destX = fish[count].x;
			this.destY = fish[count].y;
		}
		if (this.y < this.destY) {
			this.y += 1;
		} else if (this.y > this.destY) {
			this.y -= 1;
		} if (this.x < this.destX) {
			this.x += 1;
			this.facingLeft = false;
		} else if (this.x > this.destX) {
			this.x -= 1;
			this.facingLeft = true;
		}
	}

}
