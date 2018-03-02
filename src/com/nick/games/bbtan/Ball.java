package com.nick.games.bbtan;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Sprite implements GameConstants{

	Ball()
	{
		this.x=240;
		this.y=GAME_HEIGHT-80;
		this.w=15;
		this.h=15;
		
	}

	
	void drawBall(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.fillOval(x, y, 15, 15);
		
	}
	
	public void moveBall()
	{
		this.y=y+yspeed;
		this.x=x+xspeed;
	}
}
