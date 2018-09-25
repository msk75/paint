package paint;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import paint.shapeDAO.ShapeDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class login {

	private JFrame frmLogin;
	private JTextField usertxt;
	private JPasswordField passtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);

		usertxt = new JTextField();
		usertxt.setBounds(161, 47, 120, 20);
		frmLogin.getContentPane().add(usertxt);
		usertxt.setColumns(10);

		JButton loginbtn = new JButton("login");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ShapeDao.hasName(passtxt.getText(), usertxt.getText())) {
					this.setVisible(false);
					new ShapePanel(ShapeDao.selectUserid(usertxt.getText())).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Your Information Is Incomplete...");
				}

			}

			private void setVisible(boolean b) {
				frmLogin.setVisible(b);

			}
		});
		loginbtn.setBounds(185, 134, 70, 23);
		frmLogin.getContentPane().add(loginbtn);

		JLabel lblUsername = new JLabel("username:");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(89, 50, 80, 14);
		frmLogin.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(89, 91, 80, 14);
		frmLogin.getContentPane().add(lblPassword);
		
		passtxt = new JPasswordField();
		passtxt.setBounds(161, 88, 120, 20);
		frmLogin.getContentPane().add(passtxt);
	}
}
