package com.nick.games.bbtan;

import java.awt.Image;

public class Sprite {

	protected int x;
	protected int y;
	public int getXspeed() {
		return xspeed;
	}
	public void setXspeed(int xspeed) {
		this.xspeed = xspeed;
	}
	public int getYspeed() {
		return yspeed;
	}
	public void setYspeed(int yspeed) {
		this.yspeed = yspeed;
	}
	protected int w;
	protected int h;
	protected int xspeed=-1;
	protected int yspeed;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	Image img;
	protected int speed;
	
}
