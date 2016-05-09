package Game;

import java.io.IOException;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.openal.*;
import org.newdawn.slick.openal.*;
import org.newdawn.slick.util.*;


public class Jukebox extends BasicGameState{

	//Music[] songs;
	public Image jukebox;
	public int select=0; 
	public boolean isPlaying=false;
	public int xpos;
	public int ypos;
	boolean playHover=false;
	boolean pauseHover=false;
	boolean prevHover=false;
	boolean nextHover=false;
	
	private Boolean quit=false;
	
	private Music chickenSounds;
	
	
	
	
	public Jukebox(int state){
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		jukebox = new Image("res/jukeBox.png");

		chickenSounds = new Music("res/sound/chicken_sounds.wav");
		
		
		
		
	}

	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		
		g.drawImage(jukebox, 0, 0);
		
		
		
		
		//(Start X, Start Y, Width, Height)
		if(prevHover)g.fillRect(90, 265, 60, 60);//Prev
		if(nextHover)g.fillRect(190, 265, 60, 60);//Next
		if(playHover)g.fillRect(92, 365, 60, 60);//Play
		if(pauseHover)g.fillRect(190, 365, 60, 60);//Pause
		
		
		g.drawString("Current Track : #"+select+"\nPlaying? :"+chickenSounds.playing(), 75, 175);
		g.drawString("X:"+xpos+" Y: "+(600-ypos)+" Mouse Y: "+ypos, 100, 10);
		
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
		xpos = Mouse.getX();
		ypos = Mouse.getY();
		
		
		
		//chickenSounds.play();
		
		//Play
		if((xpos>92 && xpos<152) && (ypos>175 && ypos<235)){
			playHover = true;
			if(input.isMousePressed(0)){
				isPlaying=true;
			}
		}else{playHover = false;}
		
		//Prev
		if((xpos>90 && xpos<150) && (ypos>265 && ypos<325) && select>0){
			prevHover = true;
			if(input.isMousePressed(0)){
				select--;
			}
		}else{prevHover = false;}
		
		//Next
		if((xpos>190 && xpos<250) && (ypos>265 && ypos<325)){
			nextHover = true;
			if(input.isMousePressed(0)){
				select++;
			}
		}else{nextHover = false;}
		//Pause
		if((xpos>190 && xpos<250) && (ypos>175 && ypos<235)){
			pauseHover = true;
			if(input.isMousePressed(0)){
				isPlaying=false;
			}
		}else{pauseHover = false;}
		
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
		return 3;
	}
	
	
}