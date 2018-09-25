package paint;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import paint.shape.Circle;
import paint.shape.Line;
import paint.shape.RectAngle;
import paint.shape.Shapes;
import paint.shapeDAO.ShapeDao;

import java.awt.event.MouseAdapter;
import java.awt.SystemColor;

public class ShapePanel extends JFrame {

	int x1;
	int y1;
	int y2;
	int x2;
	String kind = null;
	String rang=null;
	Color color;

	Circle circle = new Circle();
	Line line = new Line();
	RectAngle rect = new RectAngle();
	private Shapes shape = null;

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	protected JComponent frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShapePanel frame = new ShapePanel(0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ShapePanel(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				x1 = e.getX();
				y1 = e.getY();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					x2 = e.getX();
					y2 = e.getY();
					shape.addShape(getGraphics(), x1, y1, x2, y2, color);
					ShapeDao.insertShape(id, x1, y1, x2, y2, kind,rang);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		});
		setType(Type.UTILITY);
		setTitle("Shape Painter");
		setBounds(100, 100, 669, 385);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton linebtn = new JButton("\u062E\u0637");
		linebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shape = line;
				kind="line";
			}
		});
		linebtn.setBounds(511, 43, 90, 25);
		contentPane.add(linebtn);

		JButton circlebtn = new JButton("\u062F\u0627\u06CC\u0631\u0647");
		circlebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shape = circle;
				kind="circle";

			}
		});
		circlebtn.setBounds(511, 78, 90, 25);
		contentPane.add(circlebtn);

		JButton rectbtn = new JButton("\u0645\u0633\u062A\u0637\u06CC\u0644");
		rectbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shape = rect;
				kind="rect";
			}
		});
		rectbtn.setBounds(511, 115, 90, 25);
		contentPane.add(rectbtn);

		JRadioButtonMenuItem Red = new JRadioButtonMenuItem("\u0642\u0631\u0645\u0632");
		Red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				color = Red.getForeground();
				rang="RED";
			}
		});
		Red.setForeground(new Color(255, 0, 0));
		buttonGroup.add(Red);
		Red.setBounds(511, 172, 137, 19);
		contentPane.add(Red);

		JRadioButtonMenuItem Blue = new JRadioButtonMenuItem("\u0622\u0628\u06CC");
		Blue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = Blue.getForeground();
				rang="BLUE";
			}
		});
		Blue.setForeground(new Color(0, 191, 255));
		buttonGroup.add(Blue);
		Blue.setBounds(511, 202, 137, 19);
		contentPane.add(Blue);

		JRadioButtonMenuItem Black = new JRadioButtonMenuItem("\u0633\u06CC\u0627\u0647");
		Black.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = Black.getForeground();
				rang="BLACK";
			}
		});
		Black.setForeground(new Color(0, 0, 0));
		buttonGroup.add(Black);
		Black.setBounds(511, 233, 137, 19);
		contentPane.add(Black);

		JRadioButtonMenuItem Green = new JRadioButtonMenuItem("\u0633\u0628\u0632");
		Green.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = Green.getForeground();
				rang="GREEN";
			}
		});
		Green.setForeground(Color.GREEN);
		buttonGroup.add(Green);
		Green.setBounds(511, 264, 137, 19);
		contentPane.add(Green);
		panel.setBackground(UIManager.getColor("Button.highlight"));
		panel.setBounds(24, 12, 450, 320);
		contentPane.add(panel);
		
		JButton exitbtn = new JButton("\u062E\u0631\u0648\u062C");
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}

		});
		exitbtn.setBounds(511, 294, 90, 23);
		contentPane.add(exitbtn);

	}
};
