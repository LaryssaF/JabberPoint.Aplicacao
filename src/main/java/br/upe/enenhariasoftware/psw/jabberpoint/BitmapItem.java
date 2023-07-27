/**
 *UPE - Campus Garanhuns Curso de Bacharelado em Engenharia de Software
 * Disciplina de Projeto de Software - 2023.1
 * 
 * Licensed under the Apache License, Version 2.0
 * https://www.apache.org/licenses/LICENSE-2.0
 * 
 * @author Ian F. Darwin, Helaine Lins
 */
package br.upe.enenhariasoftware.psw.jabberpoint;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BitmapItem extends SlideItem {

	private BufferedImage bufferedImage;
	private String imageName;

	protected static final String FILE_NOT_FOUND = "File not found";

	public BitmapItem(int level, String name) {
		super(level);
		imageName = name;

		try {
			bufferedImage = loadImage(imageName);
		} catch (IOException e) {
			System.err.println(FILE_NOT_FOUND + imageName);
		}

	}

	public BitmapItem() {
		this(0, null);
	}

	public String getName() {
		return imageName;
	}

	public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle) {
		int indent = (int) (myStyle.indent * scale);
        int leading = (int) (myStyle.leading * scale);
        int width = (int) (bufferedImage.getWidth(observer) * scale);
        int height = (int) (bufferedImage.getHeight(observer) * scale);
        return new Rectangle(indent, 0, width, leading + height);
    }

	public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver observer) {
		int width = x + (int) (myStyle.indent * scale);
        int height = y + (int) (myStyle.leading * scale);
        int imageWidth = (int) (bufferedImage.getWidth(observer) * scale);
        int imageHeight = (int) (bufferedImage.getHeight(observer) * scale);
        g.drawImage(bufferedImage, width, height, imageWidth, imageHeight, observer);
    }

	public String toString() {
		return "BitmapItem[" + getLevel() + "," + imageName + "]";
	}

    private BufferedImage loadImage(String fileName) throws IOException {
        File imageFile = new File(fileName);
        return ImageIO.read(imageFile);
    }
}
