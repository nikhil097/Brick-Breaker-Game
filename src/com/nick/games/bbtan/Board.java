package com.nick.games.bbtan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.EventListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements GameConstants
{
	Player player;
	Ball ball;
	Enemy[][] enemies=new Enemy[MAX_LENGTH][9];
	private Timer timer;
	public boolean movingBall;
	void bindEvents()
	{
		addKeyListener(new KeyAdapter() {
@Override
			public void keyPressed(KeyEvent e) {
	       if (e.getKeyCode()==KeyEvent.VK_RIGHT)
	       {
	    	   if(startGame==true)
	    	   {
	    		   if(player.getX()<GAME_WIDTH-player.getW())
	    	   {
	    	   player.setSpeed(10);
	    	   player.movePaddle();
	       }
	       }
	       }
	       else if(e.getKeyCode()==KeyEvent.VK_LEFT)
	       {
	    	if(startGame==true)
	    	{
	    	   if(player.getX()>0)
	    	   {
	    	   player.setSpeed(-10);
	    	   player.movePaddle();
	       }
	       }
	       }
	       
	       else if(e.getKeyCode()==KeyEvent.VK_SPACE)
	       {
	    	startGame();
	    	 
	       }
				// TODO Auto-generated method stub
				super.keyPressed(e);
			}
		});
	}
	
	public void gameLoop()
	{
		timer=new Timer(DELAY,e->{
			repaint();
		checkCollision();
		
		checkcollisionwithpaddle();
		changeDirection();
		
		changedirectionpaddle();
		checkGameOver();
		if(isGameOver==true)
		{
			timer.stop();
		}
			
		});
		timer.start();
	}
	
	int x=0;
	int y=0;
	void prepareBricks()
	{
		for(int i=0;i<enemies.length;i++)
		{
			for(int j=0;j<9;j++)
			{
			enemies[i][j]=new Enemy(x,y);
			x=x+54+1;
		}
		x=0;
		y=y+21;	
		}
	}
	
	boolean changeBallDirection=false;
	
	
void checkCollision()
	{
	for(int i=0;i<enemies.length;i++)
	{
		for(int j=0;j<9;j++)
		{
			if(enemies[i][j]!=null)
			{
			//if(Math.abs((enemies[i][j].getX())+54-(ball.getX()))<54 && Math.abs(-ball.getY()+enemies[i][j].getY())<20 )
			if(enemies[i][j].getX()<ball.getX() && (enemies[i][j].getX())+54>ball.getX() && enemies[i][j].getY()+20>ball.getY())
				{
				//System.out.println("hello");
		        changeBallDirection=true;	
		        enemies[i][j]=null;
			}}
		}
	}}

 void changeDirection()
 {
	 if (changeBallDirection==true)
	 {
	 ball.setYspeed(1);
	 changeBallDirection=false;
      }
	 else if(ball.getX()<10)
	 {
		 ball.setXspeed(1);
	 }
	 else 
		 if(ball.getX()>GAME_WIDTH-15)
		 {
			 ball.setXspeed(-1);
		 }
		 else if (ball.getY()<0)
		 {
			 ball.setYspeed(1);
		 }

 }
 boolean isGameOver;
 
 void checkGameOver()
 {
	 if(ball.getY()>GAME_HEIGHT)
	 {
		 isGameOver=true;
	 }
 }
 
 boolean startGame=false;
 
 public void startGame()
 {
	 ball.setYspeed(-1);
	 startGame=true;
	 movingBall=true;
 }
 
 
 
 int collisionwithpaddle;
 
 void checkcollisionwithpaddle()
 {
	// if	(Math.abs(player.getX()+100-ball.getX())<100 && Math.abs(-ball.getY()+player.getY()+100)<100)
	 if(player.getX()<ball.getX() && player.getX()+30>ball.getX() && ball.getY()>player.getY()+10)
	 {
		 collisionwithpaddle=1;
	 }
	 
	 if(player.getX()+30<=ball.getX() && player.getX()+60>ball.getX() && ball.getY()>player.getY()+10)
	 {
		collisionwithpaddle=2;
	 }
	 if(player.getX()+60<=ball.getX() && player.getX()+100>ball.getX() && ball.getY()>player.getY()+10)
	 {
		 collisionwithpaddle=3;
	 }
 }
 
 void changedirectionpaddle()
 {
	 if(collisionwithpaddle==1)
	 {
		 ball.setYspeed(-1);
		 ball.setXspeed(-1);
		 collisionwithpaddle=0;
	 }
	 
	 else if(collisionwithpaddle==2)
	 {
		 ball.setYspeed(-1);
		 ball.setXspeed(0);
		 collisionwithpaddle=0;
	 }
	 
	 else if(collisionwithpaddle==3)
	 {
		 ball.setYspeed(-1);
		 ball.setXspeed(1);
		 collisionwithpaddle=0;
	 }
 }
 
 
	
	Board()
	{
	setSize(GAME_WIDTH,GAME_HEIGHT);
	setBackground(Color.BLACK);
	player=new Player();
	ball=new Ball();
	prepareBricks();
	setFocusable(true);
    bindEvents();
   //checkCollision();
    gameLoop();
}
	@Override
    public void paintComponent(Graphics g)
    {
    	super.paintComponent(g);
    	player.drawPlayer(g);
    	
    	for(int i=0;i<enemies.length;i++)
		{
			for(int j=0;j<9;j++)
			{
				if(enemies[i][j]!=null)
				{
				enemies[i][j].drawEnemy(g);
    }}
			
			if (movingBall=true && startGame==true)
			{
			ball.drawBall(g);
			ball.moveBall();
		
		}
			if(isGameOver==true)
			{
				g.drawString("Game Over", 220, 400);
			}
			if(startGame==false)
			{
				ball.drawBall(g);
			}
}}}