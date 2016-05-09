package Game;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState{

	Image background;
	boolean playHover=false;
	boolean exitHover=false;
	boolean jukeboxHover=false;
	public int xpos;
	public int ypos;
	
	
	public Menu(int state){
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("res/menu.png");
	}

	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		//Background Draw
		g.drawImage(background, 0, 0);
		
		if(exitHover==true)g.drawRect(136, 350, 217, 110);
		if(playHover==true)	g.drawRect(100, 235, 210, 110);
		if(jukeboxHover==true)g.drawRect(635, 350, 120, 120);
		
		//Mouse Draw
		g.drawString("X:"+xpos+" Y: "+(600-ypos)+" Mouse Y: "+ypos, 100, 10);
		
		
	}

	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		xpos = Mouse.getX();
		ypos = Mouse.getY();
		
		
		//Play Button
		if((xpos>110 && xpos<310) && (ypos>250 && ypos<350)){
			playHover = true;
			if(input.isMouseButtonDown(0)){
				sbg.enterState(1);
			}
		}else{playHover = false;}
		
		//Exit Button
		if((xpos>145 && xpos<350) && (ypos>140 && ypos<245)){
			exitHover = true;
			if(input.isMouseButtonDown(0)){
				System.exit(0);
			}
		}else{exitHover = false;}
		
		//Jukebox Button
		if((xpos>635 && xpos<780) && (ypos>100 && ypos<245)){
			jukeboxHover = true;
			if(input.isMouseButtonDown(0)){
				sbg.enterState(3);
			}
		}else{jukeboxHover = false;}
	
	}

	
	public int getID() {
		return 0;
	}
	
	

}
