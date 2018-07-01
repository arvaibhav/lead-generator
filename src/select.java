import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class select {

 JFrame frame;
 JButton btnNewButton;	JCheckBox chckbxsuperpage;JCheckBox chckbxMerchantcirclecom;JCheckBox chckbxHotfrogcom;JCheckBox chckbxYelpcom ;
	public select() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBackground(Color.PINK);
		frame.setUndecorated(true);
		frame.setBounds(10, 25, 378, 431);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
	
		lblNewLabel.setIcon(new ImageIcon(select.class.getResource("/img/246x0w [www.imagesplitter.net] (1).png")));
		lblNewLabel.setBounds(41, 57, 101, 104);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chckbxMerchantcirclecom.doClick();
			}
		});
		label.setIcon(new ImageIcon(select.class.getResource("/img/mc [www.imagesplitter.net].jpeg")));
		label.setBounds(234, 57, 101, 104);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chckbxHotfrogcom.doClick();
			}
		});
		label_1.setIcon(new ImageIcon(select.class.getResource("/img/medallion-hotfrog [www.imagesplitter.net].jpeg")));
		label_1.setBounds(41, 247, 101, 104);
		frame.getContentPane().add(label_1);
		
		JLabel label_3 = new JLabel("New label");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chckbxYelpcom.doClick();
			}
		});
		label_3.setIcon(new ImageIcon(select.class.getResource("/img/Yelp_RGB_fullcolor_outline [www.imagesplitter.net].jpeg")));
		label_3.setBounds(222, 247, 113, 104);
		frame.getContentPane().add(label_3);
		
		  chckbxsuperpage = new JCheckBox("Yellowpages.com");
		  chckbxsuperpage.setBackground(Color.LIGHT_GRAY);
		chckbxsuperpage.setBounds(41, 164, 122, 23);
		frame.getContentPane().add(chckbxsuperpage);
		
		  chckbxMerchantcirclecom = new JCheckBox("Merchantcircle.com");
		  chckbxMerchantcirclecom.setBackground(Color.LIGHT_GRAY);
		chckbxMerchantcirclecom.setBounds(234, 164, 128, 23);
		frame.getContentPane().add(chckbxMerchantcirclecom);
		
		  chckbxHotfrogcom = new JCheckBox("Hotfrog.com");
		  chckbxHotfrogcom.setBackground(Color.LIGHT_GRAY);
		chckbxHotfrogcom.setBounds(41, 352, 97, 23);
		frame.getContentPane().add(chckbxHotfrogcom);
		
		  chckbxYelpcom = new JCheckBox("Yelp.com");
		  chckbxYelpcom.setBackground(Color.LIGHT_GRAY);
		chckbxYelpcom.setBounds(232, 352, 97, 23);
		frame.getContentPane().add(chckbxYelpcom);
		JLabel lblNewLabel_1 = new JLabel("   X");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			frame.dispose();
			}
		});
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 26));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(321, 0, 145, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		  btnNewButton = new JButton("Done");
	 
		
		btnNewButton.setBounds(142, 397, 89, 23);
		frame.getContentPane().add(btnNewButton);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				chckbxsuperpage.doClick();
			}
		});
	}
}
