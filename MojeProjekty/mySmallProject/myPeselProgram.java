package mySmallProject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberInputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class myPeselProgram extends JFrame implements createJMenuItem{

	private JPanel contentPane;
	private JTextArea jTextArea;
	private JTextField imie,nazwisko,pesel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myPeselProgram frame = new myPeselProgram();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public myPeselProgram() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 470);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JMenu mainMenu = new JMenu("Plik");
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(mainMenu);
		setJMenuBar(menuBar);
		//creatingSubMenu testMenuA = new creatingSubMenu();
		//testMenuA.creatingItems(new JMenuItem("Test"));
		//Creating SubMenu
		JMenuItem openFile = menuOpen("Otwórz plik");
		JMenuItem saveFile = new JMenuItem("Zapisz plik");
		mainMenu.add(openFile);
		contentPane.setLayout(null);
		
		
		jTextArea = new JTextArea();
		
		jTextArea.setBounds(10, 10, 759, 255);
		getContentPane().add(jTextArea);
		//test po commicie
		pesel = new JTextField();
		pesel.setBounds(143, 278, 209, 22);
		getContentPane().add(pesel);
		
		pesel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			String getPesel = pesel.getText();
			//int checkSum = Integer.parseInt(getPesel);
			
			obliczSume(getPesel);
			
			}
		});
		
		
		
	}
	public void obliczSume(String linia)
	{
	String zmLinia = linia;
	int tablicaWartosci[] = {1,3,7,9,1,3,7,9,1,3};
	int suma = 0;
	//Check length pesel field
	
	for(int i = 0, j = 0; i < zmLinia.length()-1 && j < tablicaWartosci.length; i++, j++)
	{
		char c = zmLinia.charAt(i);
		int liczba = Integer.parseInt(String.valueOf(c));
		int nowaLiczba = tablicaWartosci[j] * liczba;
		//jTextArea.append("" + tablicaWartosci[j] + "\n");
		suma += nowaLiczba;
		
	}
	int dzielSuma = suma % 10;
	int Uzupe³K = 10 - dzielSuma;
	
	if(dzielSuma == 0)
	{
		char c = zmLinia.charAt(10);
		int liczba = Integer.parseInt(String.valueOf(c));
		jTextArea.append("Pesel jest poprawny\n");
		
	}
	else
	{
		char c = zmLinia.charAt(10);
		int liczba = Integer.parseInt(String.valueOf(c));
		if(Uzupe³K == liczba)
		{
			jTextArea.append("Pesel jest poprawny\n");
		}
		else
		{
			jTextArea.append("Pesel jest nie poprawny\n");
		}
		//jTextArea.append("" + Integer.parseInt(String.valueOf(c)));
	}
	
	
	
	//jTextArea.append("Pesel nr " + zmLinia +" Suma " + resztaDziel + "\n");
	
	}
	public JMenuItem menuOpen(String tekst)
	{
		String zmienna = tekst;
		JMenuItem item = new JMenuItem(zmienna);
		item.addActionListener(new ActionListener() {
		JFileChooser fileChooser = new JFileChooser("D://");	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				fileChooser.showOpenDialog(myPeselProgram.this);
				File openFiled = fileChooser.getSelectedFile();
				try {
					FileInputStream fis = new FileInputStream(openFiled);
					BufferedReader br = new BufferedReader(new FileReader(openFiled));
					String odczytLinii = "";
					//Using ArrayList for collecting lines
					//ArrayList<String> listString =  new ArrayList<String>();
					String zmiennaTab[];
					while((odczytLinii = br.readLine()) != null)
					{
					//listString.add(odczytLinii);
					//jTextArea.append(odczytLinii);
					String zmPomoc = odczytLinii;
					obliczSume(odczytLinii);
					
					}
					//Reading ArrayList and setting Text to jTextArea
					/*
					Iterator<String> iterator = listString.iterator();
					while(iterator.hasNext())
					{
						jTextArea.append("" + iterator.next());
					}*/
					//jTextArea.setText(listString.get(1));
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				  catch (IOException e2)
				{
					  
				}
				
				//jTextArea.setText(openFiled.getName());
			}
		});
		
		
		return item;
	}
	
	class creatingSubMenu 
	{
		public void creatingItems(JMenuItem item)
		{
			JMenuItem menuItem = new JMenuItem("Test2");
			add(menuItem);
		}
	}

	@Override
	public void creatingItems(JMenuItem menuItem) {
		// TODO Auto-generated method stub
		
	}

}
