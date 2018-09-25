package paint.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Line extends Shapes {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Color color;

	public Line(int x1, int y1, int x2, int y2) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		
	}

	public Line() {
		super();
	}
	@Override
	public void addShape(Graphics g, int x1, int y1, int x2, int y2, Color color) {
		Graphics2D g2=(Graphics2D) g;
		g2.setColor(color);
		g2.drawLine(x1, y1, x2, y2);
		
	}

	@Override
	public String toString() {
		return "Line [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + "]";
	}

}
