package Database;

import java.sql.*; // Needed for JDBC classes

import oracle.jdbc.pool.OracleDataSource;

public class CreateTables {
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rset;
	private Queries q = new Queries();
	
	public void buildUserTable() {
		try {
			q.open("local");
			// Get a Statement object.
			Statement stmt = q.getConn().createStatement();

			// Create the table.
			stmt.executeUpdate("CREATE TABLE Users "
					+ "(User_ID	varchar2(50) NOT NULL PRIMARY KEY,UserType varchar2(5),First_Name varchar2(50),Last_Name varchar2(50),HomeAddress varchar2(50), Phone_Number varchar2(50),Email_Address varchar2(50),UserPassword	varchar2(50))");

			// Insert row #1.
			stmt.execute("INSERT INTO users VALUES ('01','G','Derek','Mulhern','Celbridge','088123456','delpeter@gmail.com','PASS1')");
			// Insert row #1.
			stmt.execute("INSERT INTO users VALUES ('02','G','Robert','Kenny','Celbridge','088123457','robertkenny@gmail.com','PASS2')");
			// Insert row #2.
			stmt.execute("INSERT INTO users VALUES ('03','G','Mark','Lordan','Celbridge','088123458','marklordan@gmail.com','PASS3')");
			// Insert row #3.
			stmt.execute("INSERT INTO users VALUES ('04','G','Thomas','Murphy','Celbridge','088123459','thomasmurphy@gmail.com','PASS4')");
			// Insert row #4.
			stmt.execute("INSERT INTO users VALUES ('05','A','Eileen','Costello','Celbridge','088123460','eileencostello@gmail.com','ADMIN1')");
			
			System.out.println("Users table created.");
			
		} catch (SQLException ex) {
			System.out.println("ERROR: buildUserTable" + ex.getMessage());
		}
		q.close();
	}
	
	public void buildHotelTable() {
		try {
			q.open("local");
			// Get a Statement object.
			Statement stmt = q.getConn().createStatement();

			// Create the table.
			stmt.executeUpdate("CREATE TABLE Hotels "
					+ "(Hotel_ID number NOT NULL PRIMARY KEY,Hotel_Name varchar2(50),Hotel_PhoneNumber varchar2(50),Hotel_Address varchar2(50),NumOfRoom number, HotelRating number )");
			// Insert row #1.
			stmt.execute("INSERT INTO hotels VALUES (1001,'TitanFall Tower Hotel','087998877','100 Star Living Street',10,5)");

			
			System.out.println("Hotels table created.");
			
		} 
		catch (SQLException ex) {
			System.out.println("ERROR:  buildHotelTable" + ex.getMessage());
		}
		q.close();
	}
	
	public void queryDB() {
		String sqlStatement = "SELECT * FROM Users";
		try {
			q.open("local");
			Statement stmt = q.getConn().createStatement();
			// Send the statement to the DBMS.
			rset = stmt.executeQuery(sqlStatement);

			// Display the contents of the result set.
			// The result set will have three columns.
			while (rset.next()) {
				System.out.printf("%10s %10s %10s  %10s %10s %10s %10s %10s\n",
						rset.getString("User_ID"),
						rset.getString("UserType"),
						rset.getString("First_Name"),
						rset.getString("Last_Name"),
						rset.getString("HomeAddress"),
						rset.getString("Phone_Number"),
						rset.getString("Email_Address"),
						rset.getString("UserPassword"));
			}
			
		} catch (Exception ex) {
			System.out.println("ERROR: queryDB " + ex.getMessage());
		}
		q.close();
	}
	
	public void closeDB() {
		try {
			stmt.close();
			rset.close();
			conn.close();
			System.out.print("Connection closed");
		} catch (SQLException e) {
			System.out.print("Could not close connection ");
			e.printStackTrace();
		}
	}

}
