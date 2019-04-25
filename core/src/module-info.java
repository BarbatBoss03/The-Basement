module core {
	requires lwjgl;
	requires lwjgl.util;
	requires transitive java.se;
	exports display;
	exports utils;
	exports shaders;
	exports data;
}