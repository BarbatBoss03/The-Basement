package display;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

public class DisplayManager {
	public static void openDisplay(){
		System.setProperty("org.lwjgl.librarypath", System.getProperty("user.dir") + "/lib/native");
		try {
			Display.setDisplayModeAndFullscreen(new DisplayMode(1680,1050));
			Display.create(new PixelFormat(), new ContextAttribs(3,2).withProfileCore(true).withForwardCompatible(true));
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		GL11.glViewport(0,0,1680,1050);
	}
	public static void updateDisplay(){
		Display.update();
		Display.sync(60);
	}
	public static void closeDisplay(){
		Display.destroy();
	}

	public static boolean closeRequested() {
		return Display.isCloseRequested();
	}
}