import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Point;
import javax.swing.JComboBox;



import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.jidesoft.swing.AutoCompletionComboBox;

import javax.swing.JProgressBar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class starting {
boolean yp=true,ye=true,h=true,s=true;
	private JFrame frame;
	  JTextField textField;Timer  timer;
	  private JTable table;
		int count =1;int g;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					starting window = new starting();
					window.frame.setLocation(0, 0);
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
	public starting() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
	
		 System.out.println("helo");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(starting.class.getResource("/img/consumers-list-icon.png")));
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 969, 705);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 25, 183, 624);
		panel.setBackground(new Color(102, 102, 102,100));
		frame.getContentPane().add(panel);
		
		JButton btnGenerateRelatedSearch = new JButton("Generate Related Search");
		btnGenerateRelatedSearch.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnGenerateRelatedSearch.setBounds(10, 25, 163, 85);
		btnGenerateRelatedSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sk ss=new sk();
				ss.frame.setLocation(frame.getLocationOnScreen());
				ss.frame.setVisible(true);		
				
			ss.btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					 
					textField.setText(ss.table.getValueAt(ss.r, 0).toString());
					ss.frame.dispose();
				
				}
			});
		
			
			}
		});
		panel.setLayout(null);
		panel.add(btnGenerateRelatedSearch);
		
		JButton saveAs = new JButton("Default\r\n Excel\r\n Path");
		saveAs.setIcon(null);
		saveAs.setBounds(10, 134, 163, 85);
		saveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc=new JFileChooser();
			fc.setDialogTitle("save the leads at");
		 fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
			fc.showSaveDialog(frame);
				System.out.println(fc.getSelectedFile());
				System.err.println(System.getProperty("user.home"));
			}
		});
		panel.add(saveAs);
		
		JButton btnSelectSites = new JButton("Select Sites");
		btnSelectSites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				select kj=new select();
				kj.frame.setLocation((int)(panel.getLocationOnScreen().getX()-20),(int)panel.getLocationOnScreen().getY());
				kj.frame.setVisible(true);
			
			 
						
						kj.btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
							if(kj.chckbxHotfrogcom.isSelected()==false)
								h=false;
							if(kj.chckbxMerchantcirclecom.isSelected()==false)
								yp=false;
							if(kj.chckbxsuperpage.isSelected()==false)
								s=false;
							if(kj.chckbxYelpcom.isSelected()==false)
								ye=false;
							kj.frame.dispose();
							}
						});
						
						
						
					 
			}});
			 
		 
		btnSelectSites.setBounds(10, 247, 163, 85);
		panel.add(btnSelectSites);
		
		JButton btnNewButton = new JButton("Save as excel");
		btnNewButton.setBounds(10, 370, 163, 77);
		panel.add(btnNewButton);
		
		 
 
		JButton btnGenerate = new JButton("generate");
		btnGenerate.setEnabled(false);
		btnGenerate.setBounds(493, 658, 89, 23);
		
		JProgressBar pbar = new JProgressBar();
		pbar.setBounds(220, 635, 695, 14);
		frame.getContentPane().add(pbar);
		pbar.getGraphicsConfiguration();
		   ActionListener updateProBar = new ActionListener() {
			      public void actionPerformed(ActionEvent actionEvent) {
			        int val = pbar.getValue();
			        			        if (val >= 100) {
			        //  timer.stop();
			        
			          return;
			        }
			        pbar.setValue(++val);
			      }
			    };
			    timer = new Timer(2300, updateProBar);
		
		JLabel statelabel = new JLabel("Location");
		statelabel.setForeground(Color.WHITE);
		statelabel.setBounds(490, 95, 66, 14);
		frame.getContentPane().add(statelabel);
		
		
		
		String path="\\city.txt";String path2="\\state.txt";String path3="\\zip.txt";
		try {
			path = new File(".").getCanonicalPath();   path = path+"\\data\\city.txt"; 
			path2 = new File(".").getCanonicalPath();   path2= path2+"\\data\\state.txt"; 
			path3 = new File(".").getCanonicalPath();   path3 = path3+"\\data\\zip.txt"; 
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	 
 
		BufferedReader input ;
		ArrayList<String> strings = new ArrayList<String>();
		BufferedReader input2 ;
		ArrayList<String> strings2 = new ArrayList<String>();
		BufferedReader input3 ;
		ArrayList<String> strings3 = new ArrayList<String>();
		
		
		try {input = new BufferedReader(new FileReader(path));
		input2 = new BufferedReader(new FileReader(path2));
		input3 = new BufferedReader(new FileReader(path3));
		  String line = null;
		  while (( line = input.readLine()) != null){
		    strings.add(line);
		  }
		    line = null;
		  while (( line = input2.readLine()) != null){
			    strings2.add(line);
			  }
		    line = null;
		  while (( line = input3.readLine()) != null){
			    strings3.add(line);
			  }
		}

		catch (FileNotFoundException e) {
		    System.err.println("Error, file " + "city.txt" + " didn't exist.");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		 
		 /////autocompletebox
		AutoCompletionComboBox comboBox = new AutoCompletionComboBox(strings.toArray(new String[]{})); comboBox.setStrict(false);
	  comboBox.setBounds(296, 91, 146, 22);frame.getContentPane().add(comboBox);
		
		

		 /////autocompletebox
		AutoCompletionComboBox state = new AutoCompletionComboBox(strings2.toArray(new String[]{})); state.setStrict(false);
		state.setBounds(566, 91, 146, 22);frame.getContentPane().add(state);
		 System.out.println(state.getSelectedIndex());
		 System.out.println(state.getSelectedItem().toString());
		
		//
		JLabel ziplabel = new JLabel("Location");
		ziplabel.setForeground(Color.WHITE);
		ziplabel.setBounds(737, 95, 66, 14);
		frame.getContentPane().add(ziplabel);
		
		 
		
		 
		 /////autocompletebox
		AutoCompletionComboBox zip = new AutoCompletionComboBox(strings3.toArray(new String[]{})); zip.setStrict(false);
		zip.setBounds(813, 91, 146, 22);frame.getContentPane().add(zip);
		 System.out.println(zip.getSelectedIndex());
		 System.out.println(zip.getSelectedItem().toString());
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(220, 151, 695, 475);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"S.no", "Name", "Address", "Phone", "Rating if Any", "Website", "Web. working", "Email Id", "Extra", "Link"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(32);
		table.getColumnModel().getColumn(1).setPreferredWidth(126);
		table.getColumnModel().getColumn(2).setPreferredWidth(261);
		table.getColumnModel().getColumn(3).setPreferredWidth(132);
		table.getColumnModel().getColumn(5).setPreferredWidth(125);
		table.getColumnModel().getColumn(6).setPreferredWidth(76);
		scrollPane.setViewportView(table);
		frame.getContentPane().add(btnGenerate);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
			if(textField.getText().isEmpty())
			{btnGenerate.setEnabled(false);
			if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
			btnGenerate.doClick();
			}
			
			else	btnGenerate.setEnabled(true);
				
			
			}
		});
		textField.setBounds(296, 48, 322, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	
		
		JLabel lblKeyword = new JLabel("Keyword");
		lblKeyword.setBounds(220, 51, 66, 14);
		lblKeyword.setForeground(Color.WHITE);
		frame.getContentPane().add(lblKeyword);
		
		JLabel citylabel = new JLabel("Location");
		citylabel.setBounds(220, 95, 66, 14);
		citylabel.setForeground(Color.WHITE);
		frame.getContentPane().add(citylabel);
		

		 
		
	
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 25, 969, 680);
		lblNewLabel.setIcon(new ImageIcon(starting.class.getResource("/img/377772.jpg")));
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		
		panel_1.setBounds(0, 0, 969, 31);
		panel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				///////////////////////
				 
				Point p=e.getLocationOnScreen();
				frame.setLocation(p.x,p.y);
			}
		});
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Leads Generator ");
		lblNewLabel_2.setBounds(22, 0, 151, 27);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(929, 0, 66, 24);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				surem jk=new surem();
				Point pp=lblNewLabel_1.getLocationOnScreen();
				jk.jd.setLocation((int)(pp.getX()-320),(int)pp.getY());
				jk.jd.setVisible(true);
			}
		});
		
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		lblNewLabel_1.setIcon(new ImageIcon(starting.class.getResource("/img/close-icon.png")));
		frame.setOpacity(0.95f);
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pbar.setValue(0);
				 count=1;
				String abc=textField.getText().replaceAll(" ", "-");
				
			timer.start();
				  g=0;
				  if(h)
			 	new Thread(new Runnable() {
				    public void run() {
				work e=new work(); 
				e.start(textField.getText());/////-
				for(int i=0;i<e.name.size();i++) {
				model.addRow(new Object[] {count++,e.name.get(i),e.address.get(i),e.phone.get(i),"not given",e.website.get(i),e.webstate.get(i),e.email.get(i),"none","hotfrog.com"});
				}	g+=20;
				pbar.setValue(g );
				    }
				}).start();
				  if(h)
				new Thread(new Runnable() {
				    public void run() {
				work2 e2=new work2(); 
				e2.start(textField.getText());/////-
				for(int i=0;i<e2.name.size();i++) {
				model.addRow(new Object[] {count ++,e2.name.get(i),e2.address.get(i),e2.phone.get(i),"not given",e2.website.get(i),e2.webstate.get(i),e2.email.get(i),"none 2","hotfrog.com"});
				}g+=20;pbar.setValue(g);
				    }
				}).start();
				if(ye)
				new Thread(new Runnable() {//yale
				    public void run() {
				yelp e22=new yelp();int count2=1;
				e22.start(textField.getText(),zip.getSelectedItem().toString());/////-
				for(int i=0;i<e22.name.size();i++) {
				model.addRow(new Object[] {count ++,e22.name.get(i),e22.address.get(i),e22.phone.get(i),e22.rate.get(i),e22.website.get(i),e22.webstate.get(i),e22.email.get(i),e22.extra.get(i),"YALE.com"});
				}g+=20;pbar.setValue(g);
				    }
				}).start();
				if(s)
				new Thread(new Runnable() {//elocal
				    public void run() {
				elocal e32=new elocal();int count2=1;
				e32.start(textField.getText(),zip.getSelectedItem().toString());/////-
				for(int i=0;i<e32.name.size();i++) {
				model.addRow(new Object[] {count ++,e32.name.get(i),e32.address.get(i),e32.phone.get(i),e32.rate.get(i),e32.website.get(i),e32.webstate.get(i),e32.email.get(i),e32.extra.get(i),"SUPERPAGES"});
				}g+=20;pbar.setValue(g);
				    }
				    
				}).start();
				if(yp)
				new Thread(new Runnable() {//elocal
				    public void run() {
				    	yellow e232=new yellow();
						e232.start(abc, zip.getSelectedItem().toString());
				for(int i=0;i<e232.name.size();i++) {
				model.addRow(new Object[] {count ++,e232.name.get(i),e232.address.get(i),e232.phone.get(i),e232.rate.get(i),e232.website.get(i),e232.webstate.get(i),e232.email.get(i),e232.extra.get(i),"YELLOWPAGE"});
				}g+=20;pbar.setValue(g);
				    }
				}).start();
				
				
			 	
				}
		});
	
		comboBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {	System.out.println(comboBox.getSelectedIndex());
				if(comboBox.getSelectedIndex()>=0)
			 	{state.setSelectedIndex(comboBox.getSelectedIndex());
			 zip.setSelectedIndex(comboBox.getSelectedIndex());
			 	}		
			}
		});
	 
	 
		state.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			 
				if(state.getSelectedIndex()>=0)
			 	{ 
			 zip.setSelectedIndex(state.getSelectedIndex());
			 	}		
			}
		});
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
			
				if(comboBox.getSelectedIndex()>=0)
			 	{ 
			 zip.setSelectedIndex(comboBox.getSelectedIndex());
			 	}
			}
		});
		
		zip.addKeyListener(new KeyListener() {
			
		 
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					btnGenerate.doClick();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		 
		}); 
state.addKeyListener(new KeyListener() {
			
		 
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					btnGenerate.doClick();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		 
		}); 
comboBox.addKeyListener(new KeyListener() {
	
	 
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
			btnGenerate.doClick();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
 
}); 
		
			 
	}	
}

	
