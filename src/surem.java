

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;



import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

public class surem extends JDialog {


	  	JDialog jd;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public surem() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	jd=new JDialog();
	jd.setModal(true);
		jd.setResizable(false);
		jd.setFocusTraversalPolicyProvider(true);
		jd.setAutoRequestFocus(false);
		jd.setAlwaysOnTop(true);
		jd.setType(Type.POPUP);
		jd.setAlwaysOnTop(true);

		jd.getContentPane().setBackground(new Color(153, 153, 153));
		jd.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 94, 328, 22);
		jd.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jd.dispose();
				
			}
		});
		btnCancel.setBounds(229, 0, 89, 23);
		panel.add(btnCancel);
		
		JButton btnYes = new JButton("Yes");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnYes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		btnYes.setBounds(138, 0, 89, 23);
		panel.add(btnYes);
		
		JLabel lblNewLabel = new JLabel("ARE YO SURE");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 29));
		lblNewLabel.setBounds(61, 11, 209, 56);
		
		
		jd.getContentPane().add(lblNewLabel);
		
		jd.setUndecorated(true);jd.setOpacity(0.89f);
		jd.setBounds(300, 500, 328, 116);
		jd.getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
			
				jd.setLocation(e.getXOnScreen()-250, e.getYOnScreen()-10);
			
			}
		}); 
		
		
	}
}
