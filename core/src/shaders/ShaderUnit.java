/*
 * Copyright (C) 2019 Dinu Blanovschi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package shaders;

import data.GameData;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import utils.GU;

public class ShaderUnit {
	private int type;
	private String name;
	private String src;
	private int id;

	public ShaderUnit(int type, String name) {
		this.type = type;
		this.name = name;
	}

	public void loadSource() {
		src = GU.content(GameData.input(name));
	}

	public void addTo(ShaderProgram program) {
		id = GL20.glCreateShader(type);
		GL20.glShaderSource(id, src);
		GL20.glCompileShader(id);
		if (GL20.glGetShaderi(id, GL20.GL_COMPILE_STATUS) != GL11.GL_TRUE) {
			System.err.println(GL20.glGetShaderInfoLog(id, 300));
			System.exit(-1);
		}
		GL20.glAttachShader(program.progid, id);
	}
}
