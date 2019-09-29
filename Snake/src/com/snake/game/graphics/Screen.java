package com.snake.game.graphics;
import com.snake.game.entities.BodyPart;
import com.snake.game.entities.Apple;
import java.applet.AudioClip;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension; 
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;


public class Screen extends JPanel implements Runnable{
    
    //private static final long serialVersionUID = 1L;
    public static final int HEIGHT = 800, WIDTH = 800;
    private Thread thread;
    private boolean running = false;
    private int score = 0;
    private BodyPart b;
    private int var = 1;
    private int j = 0;
    private ArrayList <BodyPart> snake;
    private AudioClip sound1;
    private Apple apple;
    private ArrayList<Apple>apples;
    private Random r;
    private int index = 0, ai = 0;
    private int STOP = 0;
    private int PAUSE = 0;
    private int time = 0;
    private int xCoor = 10, yCoor = 10;
    private int size = 5;
    private int ENTER = 0;
    private int flag=0;
    private boolean isInMenu=true;
    private Menu menu;
    private int savex;
    private int savey;
    private int saves;
    private int savescore;
    private int temp = 0;
    
    public static enum STATE{
        //MENU,
        GAME
    };
    
    public static STATE State=STATE.GAME;
    
    
    
    private boolean right = true, left = false, up = false, down = false;
    
    private int ticks = 0;
    private Key key;
    public Screen(){
       
        setFocusable(true);
        key = new Key();
        r = new Random();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addKeyListener(key);
        
        snake = new ArrayList<BodyPart>();
        apples=new ArrayList<Apple>();
        
        menu=new Menu();
        
        start();
        
        
        
    }
    
    public void tick(){
        if(State==STATE.GAME)
        { 
            if(temp == 1){
                
                b = new BodyPart(savex, savey, 10);
                score = savescore;
            }
           
       if(snake.size()==0){
           b = new BodyPart(xCoor, yCoor, 10);
           snake.add(b);
       }
       
       ticks++;
       if(apples.size()==0)
       {
           int xCoor=r.nextInt(79);
           int yCoor=r.nextInt(79);
           
           apple=new Apple(xCoor,yCoor,10);
           apples.add(apple);
       }
       
        for (int i = 0; i < apples.size(); i++) {
            if(xCoor == apples.get(i).getxCoor() && yCoor == apples.get(i).getyCoor()){
                size++;
                index++;
                ai++;
               score = score + 15;
                apples.remove(i);
                var = var + 50000;
                i--;
            }
            
        }
        
       for(int i = 0; i<snake.size(); i++){
           if(xCoor == snake.get(i).getxCoor() & yCoor == snake.get(i).getyCoor()){
               if(i!=snake.size()-1){
                   stop();
               }
           }
        }
       if(xCoor < 0 || xCoor > 79 || yCoor < 0 || yCoor > 79){
           stop();
       }
       if(ticks > (600000-var)){
           if(right) xCoor++;
           if(left) xCoor--;
           if(up) yCoor--;
           if(down) yCoor++;
           
           ticks = 0;
           
           b = new BodyPart(xCoor, yCoor, 10);
           snake.add(b);
           
       }
       
       if(snake.size()>size){
           snake.remove(0);
       }
        }
    }
    
    @Override
    public void paint(Graphics g){
        
        g.clearRect(0 , 0, WIDTH, HEIGHT);
         
        
        
        g.setColor(Color.BLACK);
        for(int i = 0; i<WIDTH / 10; i++){
            
            
            g.fillRect(i * 10, 0, i*10, HEIGHT);
        }
        for(int i = 0; i<HEIGHT / 10; i++){
            
        
           
             g.fillRect(0, i*10, WIDTH, i*10);
             
        }
        
         if(State==STATE.GAME)
        {
        g.setFont(new Font(TOOL_TIP_TEXT_KEY, score, 20));
        g.setColor(Color.cyan);
        g.drawString("Score: "+score, 700,17); 
        
       
        if(STOP == 1){
            
            g.setColor(Color.red);
            g.setFont(new Font(TOOL_TIP_TEXT_KEY, score , 50));
            g.drawString("GAME OVER!!!", 250, 370);
            g.setFont(new Font(TOOL_TIP_TEXT_KEY, score, 40));
            g.setColor(Color.yellow);
            g.drawString("Score: "+score, 310,430);
            g.setFont(new Font(TOOL_TIP_TEXT_KEY, score, 20));
            g.setColor(Color.white);
            g.drawString("Press enter for menu.....", 410,530);
            
            
        }
        
        if(PAUSE == 1){
            g.setColor(Color.green);
            g.setFont(new Font(TOOL_TIP_TEXT_KEY, score , 50));
            g.drawString("PAUSE", 300, 370);
            
        }
        for(int i = 0; i<snake.size(); i++){
            index = index%10;
            snake.get(i).draw(g,j);
            j++;
            if(j > 9){
                j = 0;
            }
            
        }
        
        for (int i = 0; i < apples.size(); i++) {
            ai = ai%10;
            apples.get(i).draw(g, ai);
            
        }
        }
         else if(State==STATE.MENU)
        {
            menu.render(g);
        }
        
        
    }
    
    public void start(){
        running = true;
        thread = new Thread(this, "New Thread");
        thread.start();
        
    }
     public void stop(){
         
         running = false;
         STOP = 1;
         
         try{
             thread.join();
         }
         catch(InterruptedException c){
             c.printStackTrace();
         }
        
    }
     
     
     public void save(){
         ObjectOutputStream oos= null;
         
         
         savex = xCoor;
         savey = yCoor;
         saves = snake.size();
         savescore = score;
         SaveInfo saveinfo = new SaveInfo(savex, savey, saves, savescore);
         try {
             oos = new ObjectOutputStream(new FileOutputStream("out.txt"));
             oos.writeObject(saveinfo);
             
         } catch (Exception e) {
         }finally{
             try {
                 oos.close();
             } catch (Exception e) {
             }
         }
         
         
     }
     public void load(){
         
         ObjectInputStream ois = null;
         SaveInfo s = null;
         try {
             ois = new ObjectInputStream(new FileInputStream("out.txt"));
             s = (SaveInfo) ois.readObject();
         } catch (Exception e) {
         }
         System.out.println(s);
         xCoor = s.getSavex();
         yCoor = s.getSavey();
         size = s.getSaves();
         score = s.getSavescore();
         
    }
     
    @Override
    public void run(){
        while(running){
            
            tick();
            repaint();
        }
    }
    
    
    


   class Key implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if(State==STATE.GAME)
        {
        
        if(key == KeyEvent.VK_RIGHT && !left){
            up = false;
            down = false;
            right = true;
        }
        
        if(key == KeyEvent.VK_LEFT && !right){
            up = false;
            down = false;
            left = true;
        }
        
        if(key == KeyEvent.VK_UP && !down){
            up = true;
            right = false;
            left = false;
        }
        if(key == KeyEvent.VK_DOWN && !up){
            down = true;
            right = false;
            left = false;
        }
        if(key == KeyEvent.VK_SPACE){
            if(flag==0)
            {   running = false;
                PAUSE = 1;
                flag=1;
            }
        
            else if(flag==1)
            {
                PAUSE = 0;
                flag=0;
            
               start();
            }
        }
        if(key == KeyEvent.VK_ENTER){
           State=STATE.MENU;
           repaint();
        }
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
   }

}
