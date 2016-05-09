package Game;


import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame{

	public static final String TITLE = "Chicken Logic (Beta Build 0.0.1)";
	public static final int menu = 0; 
	public static final int play = 1;
	public static final int intro = 2;
	public static final int jukebox = 3;
	
	public static final int TILESIZE=32;
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	public static final int TARGET_FPS = 144;
	
	public Game(String gameName) {
		super(gameName);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		this.addState(new Intro(intro));
		this.addState(new Jukebox(jukebox));
		
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(intro).init(gc, this);
		this.getState(jukebox).init(gc, this);
		this.enterState(menu);
		
	}
	
	public static void main(String[] args) {
		AppGameContainer mainWindow;
		
		try{
			
			mainWindow = new AppGameContainer(new Game(TITLE));
			mainWindow.setDisplayMode(WIDTH, HEIGHT, false);
			//mainWindow.setTargetFrameRate(TARGET_FPS);
			mainWindow.start();
			
		}catch(SlickException e){
			e.printStackTrace();
		}	
	}
}
