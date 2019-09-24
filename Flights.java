import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Flights {
	static String sqlhost=Login.sqlhost;
	static String sqlusr=Login.sqlusr;
	static String sqlpwd=Login.sqlpwd;
	
	static void InsertFlight() {
		Connection con = null;
		try {
	         Class.forName("com.mysql.jdbc.Driver").newInstance();
	         con = DriverManager.getConnection(sqlhost,sqlusr,sqlpwd);
	      } catch(Exception e) {
	         System.out.println("SQL Error: "+ e);
	      }
		
		try {
	         System.out.println("\nEnter Flight Details: ");
	         Scanner sc = new Scanner(System.in);	 	        
	         System.out.print("Flight Number: "); String fn=sc.nextLine();
	         System.out.print("\nDate: "); String dat=sc.nextLine();
	         System.out.print("\nDeparture Airport: "); String da=sc.nextLine();
	         System.out.print("\nArrival Airport: "); String aa=sc.nextLine();
	         System.out.print("\nDeparture Time: ");  String dt=sc.nextLine();	         
	         System.out.print("\nArrival Time: ");  String aat=sc.nextLine();	         
	         System.out.print("\nPrice(Economy): "); String pe=sc.nextLine();
	         System.out.print("\nPrice(1st Class): "); String pf=sc.nextLine();
	         System.out.print("\nAvailable Seats: "); String av=sc.nextLine();
	         fn.toLowerCase();
	         da.toLowerCase();
	         da.toLowerCase();
	         aa.toLowerCase();
	         dt.toLowerCase();
	         aat.toLowerCase();
	         pe.toLowerCase();
	         pf.toLowerCase();
	         av.toLowerCase();
	         dat.toLowerCase();
	         
	         String sql = "INSERT INTO FlightsDetails VALUES (?,?,?,?,?,?,?,?,?)";
	         PreparedStatement statement = con.prepareStatement(sql);	         
	         statement.setString(1, fn);
	         statement.setString(2, da);
	         statement.setString(3, aa);
	         statement.setString(4, dt);
	         statement.setString(5, aat);
	         statement.setString(6, pe);
	         statement.setString(7, pf);
	         statement.setString(8, av);
	         statement.setString(9, dat);
	         int rowsInserted = statement.executeUpdate();
	         if (rowsInserted > 0) {
	             System.out.println("A new Flight Registered successfully in Database!\n");
	         }
	         
	         sql = "CREATE TABLE "+ fn+"Flight"+
	                   "(SeatNumber VARCHAR(45) not NULL, " +
	                   " Type VARCHAR(45) not NULL, " + 
	                   " Availability VARCHAR(45) not NULL, " + 
	                   " AllocatedUser VARCHAR(45) not NULL, " + 
	                   " PRIMARY KEY (SeatNumber))";
	         
	         Statement stmt=con.createStatement();
	         stmt.executeUpdate(sql);
	         
	         /*
	         String []chr= {"A","B","C","D"};
	         sql = "INSERT INTO "+fn+"Flight" + "VALUES (?,?,?,?)";	 
	         statement = con.prepareStatement(sql);
	         
	         for(int i=0;i<2;i++) {
	         for(int j=0;j<4;j++) {
	         statement.setString(1,chr[i]+(j+1));
	         if(j<2) statement.setString(2,"F"); else statement.setString(2,"E");
	         statement.setString(3,"O");
	         statement.setString(4, null);
	         stmt.executeUpdate(sql);
	         }}
	         */
	         	         
	      } catch(SQLException e) {
	         System.out.println("SQL exception occured: " + e);
	         //e.printStackTrace();
	      }	catch(Exception e) {
	    	  //e.printStackTrace();
	      }
		finally {
			  }
	}

	static String SearchFlight(String bsrc,String bdest, String bdate) {		
		Connection con = null;
		Statement stmt=null;
		String pn=null;
		try {
	         Class.forName("com.mysql.jdbc.Driver").newInstance();
	         con = DriverManager.getConnection(sqlhost,sqlusr,sqlpwd);
	      } catch(Exception e) {
	         System.out.println("SQL Error: "+ e);
	      }
		try {
	         stmt = con.createStatement();
	         //String query = "SELECT * FROM FlightsDetails WHERE FlightNumber='" + bsrc + "'";
	         String query="Select * FROM FlightsDetails WHERE DeptAirport='"+bsrc+"'"
	         		+ "AND ArrAirport='"+bdest+"'";
	         ResultSet rs = stmt.executeQuery(query);        
	        
	         System.out.println("--------------------------------------------------------- ");
	         System.out.println("All Available Flights from "+bsrc+"-->"+bdest+" on "+bdate);
             System.out.println("--------------------------------------------------------- ");
             System.out.println("|\tDate\t|Flight Number| Departure Airport | Arrival Airport | Departure Time | Arrival Time | Price(Economy) | Price(1st Class) | Available Seats |");
	         
	         while (rs.next()) {
	        	 String dat = rs.getString("Date");
	             pn = rs.getString("FlightNumber");
	             String da = rs.getString("DeptAirport");
	             String aa = rs.getString("ArrAirport");
	             String dt = rs.getString("DeptTime");
	             String at = rs.getString("ArrTime");
	             String pe = rs.getString("Price(E)");
	             String pf = rs.getString("Price(F)");
	             String as = rs.getString("AvSeats");
	            
	             System.out.println("|    "+dat+ " |\t"+pn+"    |\t\t" + da+"\t  |\t   "
	             +aa+"  \t   |\t " + dt+" \t   |   "+at+"   |\t " + pe+"  \t|\t  "+ pf+"  \t|\t"+as+"   \t| ");		         	             
	          }
	         //System.out.println("\n");
	         return pn;
	      } catch(SQLException e) {
	         System.out.println("Flight Not Valid!!!!!!\n");
	      }
		return null;
	}
	static boolean DisplaySeats(String fn) {
		Connection con = null;
		Statement stmt=null;
		try {
	         Class.forName("com.mysql.jdbc.Driver").newInstance();
	         con = DriverManager.getConnection(sqlhost,sqlusr,sqlpwd);
	      } catch(Exception e) {
	         System.out.println("SQL Error: "+ e);
	      }
		try {
	         stmt = con.createStatement();
	         String query = "SELECT * FROM "+ fn+"Flight";
	         ResultSet rs = stmt.executeQuery(query);
	         
	         System.out.println("---------------------------- ");
	         System.out.println("All Seats in Flight#"+fn+"");
             System.out.println("---------------------------- ");
             System.out.println("|A1|A2|A3|A4||\t||A5|A6|A7|A8|");
             System.out.println("|B1|B2|B3|B4||\t||B5|B6|B7|B8|");
             System.out.println("|C1|C2|C3|C4||\t||C5|C6|C7|C8|");
             System.out.println("|D1|D2|D3|D4||\t||D5|D6|D7|D8|");
             System.out.println("|E1|E2|E3|E4||\t||E5|E6|E7|E8|\n");
	         
             System.out.print("||\t    Seat Number\t\t   |: | ");
	         while (rs.next()) {
	        	 String sn = rs.getString("SeatNumber");	             	             	             	            
	             System.out.print(sn+" | ");		         
	          }
	         rs.beforeFirst();
	         System.out.print("\n|| Type(E->Economy, F->FirstClass) |: | ");
	         while (rs.next()) {        	 
	             String ty = rs.getString("Type");	             	             	            
	             System.out.print(ty+"  | ");		         
	          }
	         rs.beforeFirst();
	         System.out.print("\n||Availability(X->Reserved,O->Open)|: | ");
	         while (rs.next()) {	        	
	             String av = rs.getString("Availability");	             	             	            
	             System.out.print(av+"  | ");		         
	          }
	         System.out.print("\n\n");
	         con.close();
	         stmt.close();
	         return true;
	      } catch(SQLException e) {    	  
	         System.out.println("Something wrong in Database Query while Displaying Seats!!\n"); return false;
	      }
		
	}		
	
	static void DisplayAllFlights() {
		Connection con = null;
		Statement stmt=null;
		try {
	         Class.forName("com.mysql.jdbc.Driver").newInstance();
	         con = DriverManager.getConnection(sqlhost,sqlusr,sqlpwd);
	      } catch(Exception e) {
	         System.out.println("SQL Error: "+ e);
	      }
		try {
	         stmt = con.createStatement();
	         String query = "SELECT * FROM FlightsDetails";
	         ResultSet rs = stmt.executeQuery(query);
	         
	         System.out.println("--------------------------------------------------- ");
	         System.out.println("All Available Flights in Airline-Reservation System");
             System.out.println("--------------------------------------------------- ");            
             System.out.println("|\tDate\t|Flight Number| Departure Airport | Arrival Airport | Departure Time | Arrival Time | Price(Economy) | Price(1st Class) | Available Seats |");
	         
	         while (rs.next()) {
	        	 String dat = rs.getString("Date");
	             String pn = rs.getString("FlightNumber");
	             String da = rs.getString("DeptAirport");
	             String aa = rs.getString("ArrAirport");
	             String dt = rs.getString("DeptTime");
	             String at = rs.getString("ArrTime");
	             String pe = rs.getString("Price(E)");
	             String pf = rs.getString("Price(F)");
	             String as = rs.getString("AvSeats");
	             
	             //System.out.println(" | "+dat+ " | "+pn+" | " + da+" | "+aa+" | " + dt+" | "+at+" | " + pe+" | "+ pf+" | "+as+" | ");		         
	             //System.out.println("|    "+dat+ " |\t"+pn+"    |\t\t" + da+"\t  |\t   "
	    	     //        +aa+" \t |\t" + dt+"\t |   "+at+"   |\t" + pe+"\t|\t"+ pf+"\t|\t"+as+"\t| ");
	             System.out.println("|    "+dat+ " |\t"+pn+"    |\t\t" + da+"\t  |\t   "
	    	             +aa+"      |\t" + dt+"    \t|  "+at+"  |\t   " + pe+" \t|\t  "+ pf+"  \t|\t"+as+"   \t| ");	
	          }
	         con.close();
	         stmt.close();
	      } catch(SQLException e) {
	         System.out.println("Something wrong in Database Query!!\n");
	      }
	}

	
	public static int BookSeat(String fn,String dt,String src,String dest) {
		Connection con = null;
		PreparedStatement statement = null;
		Statement stmt=null;
		Scanner sc = new Scanner(System.in);
		try {
	         Class.forName("com.mysql.jdbc.Driver").newInstance();
	         con = DriverManager.getConnection(sqlhost,sqlusr,sqlpwd);
	      } catch(Exception e) {
	         System.out.println("SQL Error: "+ e);
	      }
		
		try {			
			System.out.println("Enter the Number of Seats You Want to Book(For Example: 2): ");
        	int nseats=sc.nextInt();
        	System.out.println("Enter Your Basic Information(FirstName,Age,Contact)(For Example: darshan,25,(323)-244-1926):"
        			+ "\nFirstName: ");
        	String fname=sc.next();
        	System.out.println("Age: ");
        	int age=sc.nextInt();
        	System.out.println("Contact: ");
        	String contact=sc.next();
        	String []seat=new String[20];
        	int TotalAmount=500;
        	      	
        	for(int i=0;i<nseats;i++) {
    		System.out.println("Enter the Seat Number You Want to Book(For Example: C3): ");
        	seat[i]=sc.next();
        	seat[i].toUpperCase(); 
        	}
        	/*
        	for(int i=0;i<nseats;i++) {
        	 stmt = con.createStatement();
	         String query = "SELECT * FROM "+flightno+"Flight WHERE SeatNumber='" + seat[i] + "'";
	         ResultSet rs = stmt.executeQuery(query);	         
	         String av = rs.getString("Availability");
	         String p=rs.getString("Type");
	         if(av.compareTo("X")==0) {
	        	 System.out.println("Seat Not Available!! Please Select 'O'->Open Seats\n");
	        	 i--;
	         }
	         if(p.compareTo("F")==0) TotalAmount+=100;
	         else TotalAmount+=50; 
        	}
        	*/
       	
        
	        System.out.println("Confirm Booking and Print Ticket-->Y/N: ");
        	String ch=sc.next();
        	ch.toUpperCase();
        	if(ch.compareTo("Y")==0) {
        		//--------sql----insert booking---------
        	for(int i=0;i<nseats;i++) {
        	String sql = "UPDATE "+fn+"Flight SET Availability=?,AllocatedUser=? WHERE SeatNumber=?";
   	         statement = con.prepareStatement(sql);
   	         statement.setString(1,"X");
   	         statement.setString(2, fname);
   	         statement.setString(3, seat[i]);	           	        
   	         int rowsInserted = statement.executeUpdate();
   	         if (rowsInserted > 0) {
   	             System.out.println("Ticket Booking successful in Database for Seat "+seat[i]+" !\n");
   	         }
   	         }
        		//--------------------Ticket------------------
        		System.out.println("-----------------------------------------------");
        		System.out.println("Airline Reservation System Confirmation Ticket:");
        		System.out.println("------------------------------------------------");
        		System.out.println("| Date: "+dt+"\t| From: "+src+"\t| To: "+dest);
        		System.out.println("| Name: "+fname+"\t| Age: "+age+"\t| Contact Number: "+contact);
        		System.out.print("Confirmed Seats: ");
        		for(int i=0;i<nseats;i++) {
            		System.out.print(seat[i].toUpperCase()+", ");                              	      	
                }
        		System.out.println("\tTotal Price: "+TotalAmount);
        	}
        	System.out.println("---------------------------------------------------");
        	 System.out.println("\n\n");
	         statement.close();
	         con.close();
	      }catch(SQLException e) {
	         System.out.println("SQL exception occured: " + e);
	         System.out.println("Invalid Input\n\n");
	      }	
		finally {
			  }
		return 0;
	}
}
