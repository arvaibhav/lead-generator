import java.awt.EventQueue;

import javax.swing.JFrame;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class sk  {
	int r=0;
	  JFrame frame;
	  JTable table;
	  JTextField Keyword;
	  JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sk window = new sk();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public sk() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(sk.class.getResource("/img/consumers-list-icon.png")));
		frame.setBounds(100, 100, 452, 666);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("   X");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			frame.dispose();
			}
		});
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 26));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(399, 0, 67, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(41, 94, 351, 491);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
	
		table.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Related Search Keyword"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);
		
		  btnNewButton = new JButton("SELECT");
		
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(168, 596, 109, 39);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Keyword");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 45, 67, 26);
		frame.getContentPane().add(lblNewLabel);
		
		Keyword = new JTextField();
		
		Keyword.setBounds(77, 48, 257, 20);
		frame.getContentPane().add(Keyword);
		Keyword.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Generate");
		btnNewButton_1.setEnabled(false);
		
		btnNewButton_1.setBounds(344, 47, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(sk.class.getResource("/img/377772.jpg")));
		label.setBounds(0, 0, 452, 666);
		frame.getContentPane().add(label);
	
	
		DefaultTableModel model=(DefaultTableModel)table.getModel();
	
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String g=Keyword.getText().replaceAll(" ", "-");
				 
				
				try { 
					 
					Document doc=Jsoup.connect("https://www.hotfrog.com/find/"+g+"/me/").timeout(8000).get();
					 
					model.addRow(new Object[] {"------------------"+g+"------------------------"});
					
					for(Element hint:doc.select(".filtergroup-text").select("li"))
					{
						 
						model.addRow(new Object[] {hint.text()});
					}
					
				}	catch(Exception e)
				{
					model.addRow(new Object[] {"low connection speed OR wrong keyword searched"});
				}
			}
		});
	
	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				  r= table.getSelectedRow();
				btnNewButton.setEnabled(true);;
			}
		});
		 
		Keyword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(Keyword.getText().isEmpty())
					btnNewButton_1.setEnabled(false);
				else 
				{	btnNewButton_1.setEnabled(true);
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
					btnNewButton_1.doClick();
				}
			}
		});
	///
	
		
		 

	///
	}
}
