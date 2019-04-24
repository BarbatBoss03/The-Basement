package init;

import display.DisplayManager;
import org.lwjgl.opengl.GL11;

public class MainGameLoop {
	public MainGameLoop(){
		DisplayManager.openDisplay();
		GL11.glClearColor(1.0f,0.0f,0.0f,1.0f);
		while(!DisplayManager.closeRequested()){
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			DisplayManager.updateDisplay();
		}
		DisplayManager.closeDisplay();
	}

	public static void start(){
		new MainGameLoop();
	}
}
