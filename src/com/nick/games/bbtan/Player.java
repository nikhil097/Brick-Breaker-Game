package com.nick.games.bbtan;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Player extends Sprite implements GameConstants{
	

	public Player()
	{
		this.w=this.h=100;
		this.x=GAME_WIDTH/2-w/2;
		this.y=GAME_HEIGHT-h;
		img=new ImageIcon(Board.class.getResource("paddle.png")).getImage();
	}
	
	public void drawPlayer(Graphics g)
	{
		g.drawImage(img, x, y,w,h, null);
	}

	public void movePaddle()
	{
		this.x=x+speed;
	}
	
}
