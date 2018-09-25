package paint.shapeDAO;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.security.auth.login.Configuration;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.Graphics;

import paint.ShapePanel;
import paint.shape.Circle;
import paint.shape.Line;
import paint.shape.RectAngle;
import paint.shape.Shapes;

public class ShapeDao {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/shapes";

	static final String USER = "root";
	static final String PASS = "";
	static final Graphics Geraphics = null;
	public static Connection conn = null;
	public static Statement stmt = null;
	public static String sql = "";

	@Before
	public void setup() throws SQLException {
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		stmt = conn.createStatement();
	}

	@Test
	public void testIfConnectionNotNull() throws SQLException {
		sql = "SELECT * FROM shapes";
		ResultSet rs = stmt.executeQuery(sql);
		assertTrue(!rs.equals(null));
	}

	@After
	public void teardown() throws SQLException {

		stmt.close();
		conn.close();

	}

	public static ArrayList<Shapes> selectShapes(int id) {

		ArrayList<Shapes> list = new ArrayList<Shapes>();
		Line line = null;
		Circle circle = null;
		RectAngle rect = null;
		Shapes shape = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			sql = "SELECT * FROM shapes WHERE userid=" + id + "";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int x1 = Integer.parseInt(rs.getString("x1"));
				int y1 = Integer.parseInt(rs.getString("y1"));
				int x2 = Integer.parseInt(rs.getString("x2"));
				int y2 = Integer.parseInt(rs.getString("y2"));
				String kind = rs.getString("kind");
				if (kind.equals("circle")) {
					circle = new Circle(x1, y1, x2, y2);
					shape = circle;
				} else if (kind.equals("line")) {
					line = new Line(x1, y1, x2, y2);
					shape = line;
				} else if (kind.equals("rect")) {
					rect = new RectAngle(x1, y1, x2, y2);
					shape = rect;
				}

				list.add(shape);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return list;
	}

	public static void insertShape(int id, int x1, int y1, int x2, int y2, String kind, String color) {
		Connection conn = null;
		Statement stmt = null;
		String sql = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			sql = "INSERT INTO shapes (x1,y1,x2,y2,kind,userid,color) VALUES (" + x1 + "," + y1 + "," + x2 + "," + y2
					+ ",'" + kind + "'," + id + ",'" + color + "')";
			int row = stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public static boolean hasName(String pass, String username) {
		Connection conn = null;
		Statement stmt = null;
		String sql = null;
		boolean s = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			sql = "SELECT username FROM users WHERE password='" + pass + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String user = rs.getString("username");
				if (user.equals(username)) {
					s = true;
				} else {
					s = false;
				}
			}
			rs.close();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return s;

	}

	public static int selectUserid(String username) {
		Connection conn = null;
		Statement stmt = null;
		String sql = null;
		int id1 = 0;
		boolean s = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			sql = "SELECT id FROM users WHERE username='" + username + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				id1 = id;
			}
			rs.close();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return id1;
	}

}
