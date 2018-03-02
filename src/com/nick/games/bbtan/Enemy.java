package com.nick.games.bbtan;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends Sprite implements GameConstants{ 
	
	public Enemy(int x,int y)
	{

	this.w=54;
	this.h=20;
	this.x=x;
	this.y=y;
	}
	
	public void drawEnemy(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(x, y, w, h);
	}
	
	
	

}