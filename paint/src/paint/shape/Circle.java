package paint.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circle extends Shapes {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Color color;

	public Circle(int x1, int y1, int x2, int y2) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;

	}

	public Circle() {
		super();
	}

	@Override
	public void addShape(Graphics g, int x1, int y1, int x2, int y2, Color color) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		g2.drawOval(x1, y1, Math.abs(x2 - x1), Math.abs(x2 - x1));

	}
}
