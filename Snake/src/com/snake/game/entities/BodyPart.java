
package com.snake.game.entities;
import java.awt.Color;
import java.awt.Graphics;

public class BodyPart {
    private int xCoor, yCoor, width, height;
    public Color[] arr = {Color.green,Color.blue, Color.yellow, Color.magenta, Color.orange, Color.cyan, Color.gray, Color.pink, Color.white, Color.red} ;
    
    public BodyPart(int xCoor, int yCoor, int tileSize){
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = tileSize;
        height = tileSize;
    }

    public int getxCoor() {
        return xCoor;
    }

    public void setxCoor(int xCoor) {
        this.xCoor = xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public void setyCoor(int yCoor) {
        this.yCoor = yCoor;
    }
    /*public void tick(){
     
    
    }*/
    public void draw(Graphics g, int i){
        //g.setColor(Color.green);
        //g.drawPolygon(null);
        //g.setColor(Color.black);
        //g.fill3DRect(xCoor*width, yCoor*height, width, height, true);
        //g.fillRect(xCoor*width, yCoor*height, width, height);
       // g.setColor(Color.green);
        //g.fill3DRect(xCoor*width + 2 , yCoor*height + 2, width - 3, height - 3, true);
        
        g.setColor(arr[i]);
        g.drawOval(xCoor*width-1, yCoor*height- 1, width + 2, height + 2);
        g.setColor(arr[i]);
        g.fillOval(xCoor*width, yCoor*height, width, height );
        
        
        
    }
}
