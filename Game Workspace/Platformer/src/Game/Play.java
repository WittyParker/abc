package Game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.*;

public class Play extends BasicGameState {
	
	private static final int P_SIZE = 192;
	
	public static final int THRESH_RIGHT=650;
	public static final int THRESH_LEFT=150;
	
	boolean quit = false;
	
	private Animation chickStill,chickRun,chick;
	private SpriteSheet chickSheet;
	
	private TiledMap map;
	
	//Player positions "Chicken Position"
	float cPosX=0;
	float cPosY=0;
	float shiftX=cPosX+(Game.WIDTH/2);
	float shiftY=cPosY+(Game.HEIGHT/2);

	int threshold;
	
	int mouseX;
	int mouseY;
	
	public Play(int state){
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		
		map = new TiledMap("res/contra.tmx","res");
		
		//Animation Declarations
		chickSheet = new SpriteSheet("res/chickenRun.png",192,192);
		
		
		chickRun=new Animation(chickSheet,100);
		
		chick=chickRun;
	}

	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		map.render((int)cPosX,(int)cPosY);
		
		chick.draw(shiftX-P_SIZE/2,shiftY-P_SIZE/2);
		
		
		g.drawString("Chicken X:"+cPosX+"\n    Y:"+cPosY, 650, 550);
		g.drawString("X:"+mouseX+" Y: "+mouseY, 100, 10);
		
		
		if(quit==true){
			g.clear();
			g.drawString("Resume    (R)", Game.WIDTH/2, Game.HEIGHT/2);
			g.drawString("Main Menu (M)", Game.WIDTH/2, Game.HEIGHT/2+20);
			g.drawString("Quit Game (Q)", Game.WIDTH/2, Game.HEIGHT/2+40);
			if(quit==false){g.clear();}
		}
		
	}

	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		
		mouseY=input.getMouseY();
		mouseX=input.getMouseX();
		
		if(input.isKeyDown(Input.KEY_D))
			cPosX-= delta * .1f;
		
		if(input.isKeyDown(Input.KEY_A))
			cPosX+= delta * .1f;
		
		if(input.isKeyDown(Input.KEY_ESCAPE))
			quit=true;
		
		if(quit&&input.isKeyDown(Input.KEY_R))
			quit=false;
		
		if(quit&&input.isKeyDown(Input.KEY_Q))
			System.exit(0);
		if(quit&&input.isKeyDown(Input.KEY_M)){
			quit=false;
			sbg.enterState(0);
		}
	}

	
	public int getID() {
		return 1;
	}

}
