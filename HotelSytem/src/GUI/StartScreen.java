package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;

public class StartScreen extends JFrame implements ActionListener{

	private  String[] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
	private String[] months = {"January","Febuary","March","April","May","June","July","Augest","September","October","November","December"};
	private String[] years = {"2014","2015","2016","2017"};
	private  String[] nights = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21"};
	private  String[] rooms = {"1","2","3","4","5","6","7","8","9","10"};
	private  String[] people = {"1","2","3","4","5","6","7","8","9","10"};
	
	private static boolean loggedIn;
	
	private JLabel welcome;
	private JComboBox numNights,numPeople,numRooms,day,month,year;
	private JLabel lblnumNights,lblnumPeople,lblnumRooms,arrivalDate,calendar;
	private JButton login,btnSearch;
	private Font font;
	
	public StartScreen(){
		super("TitanFall Towers");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(515,315);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setLoggedIn(false); //user is not logged in
		
		font = new Font("Veranda",font.ITALIC,20);
		
		welcome = new JLabel("Welcome to TitanFall Towers Hotel");
		welcome.setFont(font);
		welcome.setBounds(78,11,374,33);
		getContentPane().add(welcome);
		
		JPanel userInteraction = new JPanel();
		userInteraction.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		userInteraction.setLayout(new GridLayout(2,0));
		userInteraction.setBounds(10,65,479,167);
		getContentPane().add(userInteraction);
		
		JPanel search = new JPanel();
		search.setLayout(new FlowLayout());
		
		lblnumNights = new JLabel("No. of Nights");
		search.add(lblnumNights);
		
		numNights = new JComboBox(nights);
		search.add(numNights);
		
		arrivalDate = new JLabel("Arrival Date");
		search.add(arrivalDate);
		
		day = new JComboBox(days);
		search.add(day);
		
		month = new JComboBox(months);
		search.add(month);
		
		year = new JComboBox(years);
		search.add(year);
		
		calendar = new JLabel(new ImageIcon(getClass().getResource("calendar1.jpg")));
		search.add(calendar);
		
		lblnumPeople = new JLabel("No. of People");
		search.add(lblnumPeople);
		
		numPeople = new JComboBox(people);
		search.add(numPeople);
		
		lblnumRooms = new JLabel("No. of Rooms");
		search.add(lblnumRooms);
		
		numRooms = new JComboBox(rooms);
		search.add(numRooms);
		
		userInteraction.add(search);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(null);
		userInteraction.add(buttons);
		
		userInteraction.add(buttons);
		
		login = new JButton("Login");
		login.addActionListener(this);
		login.setBounds(10, 47, 89, 23);
		buttons.add(login);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(this);
		btnSearch.setBounds(376, 47, 89, 23);
		buttons.add(btnSearch);
	}
	
	
	
	public static void main(String[] args) {
		StartScreen s = new StartScreen();
		s.setVisible(true);
		

	}



	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login){
			Login l = new Login();
			this.setVisible(false);
			l.setVisible(true);
		}
		else
		{
			Availability a = new Availability();
			this.setVisible(false);
			a.setVisible(true);
		}
	}


	//getter and setter to set the loggedIn value to true or false throughout the system
	public static boolean isLoggedIn() {
		return loggedIn;
	}



	public static void setLoggedIn(boolean loggedIna) {
		loggedIn = loggedIna;
	}
}
