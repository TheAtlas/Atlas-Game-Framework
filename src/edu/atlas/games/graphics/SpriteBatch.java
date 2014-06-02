package edu.atlas.games.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.nio.ByteBuffer;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

import com.jogamp.opengl.util.awt.TextRenderer;

import edu.atlas.games.Game;
import edu.atlas.games.Rectangle;
import edu.atlas.games.Vector2;

/**
 *
 * @author David Verhaak <david@forcez.nl>
 */
public class SpriteBatch 
{

	private Game game;
	
	public SpriteBatch(Game game)
	{
		this.game = game;
	}
	
	public void drawLine(Vector2 startPos, Vector2 endPos, Color color)
	{
		if(game.getGL() != null)
		{
			GL2 gl = game.getGL();
			gl.glBegin(GL.GL_LINES);
			gl.glColor4d(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
			gl.glVertex2f(startPos.x, startPos.y);
			gl.glVertex2f(endPos.x, endPos.y);
			gl.glEnd();
		}
	}
	
	public void drawPoint(Vector2 point, Color color)
	{
		if(game.getGL() != null)
		{
			GL2 gl = game.getGL();
			gl.glBegin(GL.GL_POINTS);
			gl.glColor4d(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
			gl.glVertex2f(point.x, point.y);
			gl.glEnd();
		}
	}
	
	public void drawCircle(Vector2 center, float radius, Color color)
	{
		if(game.getGL() != null)
		{
			GL2 gl = game.getGL();
			gl.glColor4d(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
			for(float angle = 0; angle < Math.PI * 2; angle += ((Math.PI * 2) / 50))
			{
				gl.glBegin(GL2.GL_POLYGON);
				gl.glVertex2d(center.x, center.y);
				gl.glVertex2d(center.x + Math.cos(angle) * radius, center.y + Math.sin(angle) * radius);
				gl.glVertex2d(center.x + Math.cos(angle + ((Math.PI * 2) / 50)) * radius, center.y + Math.sin(angle + ((Math.PI * 2) / 50)) * radius);
				gl.glEnd();
			}
		}
	}
	
	public void drawRectangle(Rectangle rectangle, Color color)
	{
		if(game.getGL() != null)
		{
			GL2 gl = game.getGL();
			gl.glColor4d(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
			gl.glRectf(rectangle.getLeft(), rectangle.getTop(), rectangle.getRight(), rectangle.getBottom());
		}
	}
	
	public void drawRoundedRectangle(Rectangle rectangle, float arcw, float arch, Color color)
	{
		if(game.getGL() != null)
		{
			GL2 gl = game.getGL();
			gl.glColor4d(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
			RoundRectangle2D.Float rect = new RoundRectangle2D.Float(rectangle.x, rectangle.y, rectangle.width, rectangle.height, arcw, arch);
			for(float x = rect.x; x < (rect.x + rect.width); x++)
			{
				for(float y = rect.y; y < (rect.y + rect.height); y++)
				{
					if(rect.contains(x, y))
					{
						gl.glBegin(GL.GL_POINTS);
						gl.glVertex2f(x, y);
						gl.glEnd();
					}
				}
			}
		}
	}
	
	public void drawString(String string, Vector2 position, Font font, Color color)
	{
		if(game.getGL() != null)
		{
			TextRenderer renderer = new TextRenderer(font);
			renderer.setColor(color);
			renderer.beginRendering(game.getWindow().getCanvas().getWidth(), game.getWindow().getCanvas().getHeight());
			renderer.draw(string, (int) position.x, (int) (game.getSize().y - position.y - renderer.getBounds(string).getHeight()));
			renderer.endRendering();
		}
	}
	
	public void drawString(String string, Vector2 position, Font font)
	{
		drawString(string, position, font, Color.WHITE);
	}
	
	public void drawString(String string, Vector2 position, Color color)
	{
		drawString(string, position, new Font("Arial", Font.PLAIN, 12), color);
	}
	
	public void drawString(String string, Vector2 position)
	{
		drawString(string, position, new Font("Arial", Font.PLAIN, 12), Color.WHITE);
	}
	
	public void draw(Texture2D texture, Vector2 position)
	{
		if(game.getGL() != null)
		{
			GL2 gl = game.getGL();
			WritableRaster raster = Raster.createInterleavedRaster(DataBuffer.TYPE_BYTE, texture.getWidth(), texture.getHeight(), 4, null);
			ComponentColorModel colorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), new int[] {8, 8, 8, 8}, true, false, ComponentColorModel.TRANSLUCENT, DataBuffer.TYPE_BYTE);
			Texture2D image = new Texture2D(colorModel, raster, false, null);
			Graphics2D graphics = image.createGraphics();
			graphics.drawImage(texture, null, null);
			DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();
			byte[] rgba = dataBuffer.getData();
			ByteBuffer buffer = ByteBuffer.wrap(rgba);
			buffer.position(0);
			buffer.mark();
			gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL2.GL_CLAMP);
			gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL2.GL_CLAMP);
			gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_LINEAR);
			gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_LINEAR);
			gl.glTexEnvf(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL.GL_REPLACE);
			gl.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, texture.getWidth(), texture.getHeight(), 0, GL.GL_RGBA, GL.GL_UNSIGNED_BYTE, buffer);
			gl.glEnable(GL.GL_TEXTURE_2D);
			gl.glBindTexture(GL.GL_TEXTURE_2D, 13);
			gl.glBegin(GL2.GL_POLYGON);
			gl.glTexCoord2d(0, 0);
			gl.glVertex2d(position.x, position.y);
			gl.glTexCoord2d(1, 0);
			gl.glVertex2d(position.x + texture.getWidth(), position.y);
			gl.glTexCoord2d(1, 1);
			gl.glVertex2d(position.x + texture.getWidth(), position.y + texture.getHeight());
			gl.glTexCoord2d(0, 1);
			gl.glVertex2d(position.x, position.y + texture.getHeight());
			gl.glEnd();
			gl.glFlush();
		}
	}
}
