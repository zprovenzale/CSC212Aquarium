package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import me.jjfoley.gfx.GFX;
import java.awt.Graphics2D;
import java.awt.Graphics2D;

import java.awt.Graphics2D;

import java.awt.Graphics2D;

/**
 * Aquarium is a graphical "application" that uses some code I built and have
 * shared with you that takes care of opening a window and communicating with
 * the user in a simple way.
 * 
 * The method draw is called 50 times per second, so we make an animation by
 * drawing our fish in one place, and moving that place slightly. The next time
 * draw gets called, our fish looks like it moved!
 * 
 * @author jfoley
 *
 */
public class Aquarium extends GFX {
	/**
	 * This is a static variable that tells us how wide the aquarium is.
	 */
	public static int WIDTH = 500;
	/**
	 * This is a static variable that tells us how tall the aquarium is.
	 */
	public static int HEIGHT = 500;

	/**
	 * Put a snail on the top of the tank.
	 */
	Snail algorithm = new Snail(177, Snail.HEIGHT + 1, "top");

	/**
	 * This is a constructor, code that runs when we make a new Aquarium.
	 */
	public Aquarium() {
		// Here we ask GFX to make our window of size WIDTH and HEIGHT.
		// Don't change this here, edit the variables instead.
		super(WIDTH, HEIGHT);
	}
	
	Fish[] fish = new Fish[2];
	
	Fish aFish = new Fish(Color.magenta, 
			300, 250, true, true);
	//fish[0] = aFish; 
	//fish[1] = new Fish(Color.orange,
	//		100, 100, true, true);
	
	//Shark shark = new Shark(fish);
	Shark shark = new Shark();
	
	//shark.makeFish(1);
	
	Fish nemo = new Fish(Color.magenta,
			250, 250, true, true);
	Fish marlin = new Fish(Color.orange,
			100, 100, true, true);

	//Shark shark = new Shark();
	
	//shark.makeFish(1);
	
	//shark.makeFish(1);



	
	BubbleSystem bubbleSystem = new BubbleSystem(30);
	
	Shape chest = new Rectangle2D.Double(200, -200, 100, 50);

	 
	@Override
	public void draw(Graphics2D g) {
		// Draw the "ocean" background.
		g.setColor(Color.blue);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		//nemo.draw(g);
		//nemo.swim();
		
		//marlin.draw(g);
		//marlin.swim();
		
		shark.draw(g);
		shark.swim();
		
		shark.drawFish(g);
		shark.swimFish();
		
		bubbleSystem.draw(g);
		bubbleSystem.rise();
		bubbleSystem.wiggle();
		
		g.setColor(Color.orange);
		g.fillRect(320, 430, 150, 70);
		

		// Draw our snail!
		algorithm.draw(g);

		}

	public static void main(String[] args) {
		// Uncomment this to make it go slower!
		// GFX.FPS = 10;
		// This is potentially helpful for debugging movement if there are too many print statements!

		// Note that we can store an Aquarium in a variable of type GFX because Aquarium
		// is a very specific GFX, much like 7 can be stored in a variable of type int!
		GFX app = new Aquarium();
		app.start();
	}

}
