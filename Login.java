import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
	static String sqlhost=null;
	//="jdbc:mysql://localhost:3306/test_db?useSSL=false";
	static String sqlusr=null;
	//="root";
	static String sqlpwd=null;
	//="root";
	static boolean AdminMode=false;
	static String uname=null;
	public String getsqlhostname() {
		return sqlhost;
	}
	
	public String getusr() {
		return sqlusr;
	}
	public String getsqlpwd() {
		return sqlpwd;
	}
    public static void main(String[] a) {

    	@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		try{
		System.out.println("Initial MySQL Database Setup:\n");
		System.out.print("Hostname (For Example my type is-> localhost): ");
		String host=sc.next();
        System.out.print("\nPort Number(For Example my port is->3306): ");
        int port= sc.nextInt();
        System.out.print("\nDatabase Schema Name(For Example my db name->test_db): ");
        String db= sc.next();
        System.out.print("\nDatabase Username(For Example-> root): ");
        String usr= sc.next();
        System.out.print("\nDatabase Password(For Example my password->darshan94): ");
        String pwd= sc.next();
        sqlhost="jdbc:mysql://"+host+":"+port+"/"+db+"?useSSL=false";
        sqlusr=usr;
        sqlpwd=pwd;
        
        Connection conn = DriverManager.getConnection(sqlhost,sqlusr,sqlpwd);
        if(conn!=null) {
        	System.out.println("Successfully connected to Database!\n");
        	System.out.println("-------------------------------------- ");
		    System.out.println("Welcome to Airline-Reservation-System");
		    System.out.println("-------------------------------------- ");
        }
        else{
        	System.out.println("Connection to Database Failed!!\n");
        	System.exit(0);
        }
        } catch(Exception e) {
	         System.out.println("SQL Connection Failed!! Please Enter Correct Details!!\n\n");
	         System.exit(0);
	      }

        while(true){
        System.out.println("Main Menu: (Enter option number)\n1-->Admin\n2-->User\n3->Display all Flights\n4-->Exit");
        int ch= sc.nextInt();
        switch(ch)
        {
        case 1: 
        	System.out.println("Menu: (Enter option number)\n"
        			+ "1-->Login (For Demo use username:admin, password:admin)\n2-->Exit");
            int ch1= sc.nextInt();
            switch(ch1)
            {
            case 1: 
            	boolean check=Login.loginuser();
            	if(check) Login.adminMode();
            	break; 
            default: break;
            } 
            break;
        case 2:       	
        	System.out.println("Menu: (Enter option number)\n1-->Login\n2-->Register(New User)\n3-->Exit");
            int ch2= sc.nextInt();
            switch(ch2)
            {
            case 1: boolean check=Login.loginuser();
            		if(check) Login.UserMode();
            		break;
            case 2: 
            	Login.Register(); break;  
            case 3: 
            	System.exit(0); break;
            }        	
            break;
        case 3:
        	Flights.DisplayAllFlights();
        	break;
        default: 
        	System.out.println("Thank you for Visiting Darshan's Airline-Reservation-System!"
            		+ "\nVisit Again!!");
        	System.exit(0); break;
        	
        }
        } 
        
           
    }

	private static void UserMode() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while(true) {
    		System.out.println("1-->Display All Flights"
    				+ "\n2-->Search Flight to Book\n3-->Logout");
            int ch= sc.nextInt();
            switch(ch)
            {
            case 1: Flights.DisplayAllFlights();           		
            		break;
            case 2:
            	Login.FlightSearch();          	
            	break;
     	
            default: return;
            } 
    		}
		
	}

	private static void adminMode() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);  // Create a Scanner object
		
		if(AdminMode) {
    	while(true) {   		
    		System.out.println("1-->Insert Flight Details"
    				+ "\n2-->Search Flight to Book\n3-->Display all Available Flights"
    				+ "\n4--> Display Seats(For Demo type--> N1)\n5-->Logout");
            int ch= sc.nextInt();
            switch(ch)
            {
            case 1: Flights.InsertFlight();           		
            		break;
            case 2:
            	Login.FlightSearch();
            	break;
            case 3:
            	Flights.DisplayAllFlights();
            	break;
            case 4:
            	String flightnumber=null;
            	System.out.println("Enter flight Number(For Example: N1): ");
            	flightnumber=sc.next();
            	Flights.DisplaySeats(flightnumber);
            	break;
            	
            default: return;
            } 
    		}
    	}
		else
		{
			System.out.println("Please Login In Admin Mode!!!\n");
		}
		
	}

	private static void FlightSearch() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);  // Create a Scanner object
		
		System.out.println("Enter Date(Format-MM/DD/YYYY): ");
    	String dt=sc.next();
    	System.out.println("Enter From(Source Flight Code(Example: LAX)): ");
    	String src=sc.next();
    	System.out.println("Enter To(Destination Flight Code(Example: JFK)): ");
    	String dest=sc.next();
    	System.out.println("Searching for Available Flights from "+src+"-->"+dest+" on "+dt);
    	src.toUpperCase();dest.toUpperCase();dt.toUpperCase();
    	String flightnumber=Flights.SearchFlight(src,dest,dt);
    	if(flightnumber==null) return;
    	System.out.println("\nDo you want to Book Available Flight? Y/N");
    	String ch1=sc.next();
    	if(ch1.compareTo("Y")==0)
    	{
    		boolean fdisplay=Flights.DisplaySeats(flightnumber);
    		if(fdisplay)
    		Flights.BookSeat(flightnumber,dt,src,dest);    		       	    		
    	}
		
	}

	private static void Register() {
		Connection con = null;
		try {
	         Class.forName("com.mysql.jdbc.Driver").newInstance();
	         con = DriverManager.getConnection(sqlhost,sqlusr,sqlpwd);
	      } catch(Exception e) {
	         System.out.println("SQL Error: "+ e);
	      }
		try {
	         System.out.println("\nRegistration\nplease enter new username: ");
	         Scanner sc = new Scanner(System.in);
	         String usr=sc.next();
	         System.out.println("enter new password: ");
	         String pwd=sc.next();
	         usr.toLowerCase();
	         pwd.toLowerCase(); 
	         String sql = "INSERT INTO login (username, password) VALUES (?, ?)";
	         PreparedStatement statement = con.prepareStatement(sql);
	         statement.setString(1, usr);
	         statement.setString(2, pwd);	     
	         int rowsInserted = statement.executeUpdate();
	         if (rowsInserted > 0) {
	             System.out.println("A new user Registered successfully!");
	         }
	         
	      } catch(SQLException e) {
	         System.out.println("SQL exception occured: " + e);
	      }	
		finally {
			  }
	}

	private static boolean loginuser() {
		Connection con = null;
		Statement stmt=null;
		try {
	         Class.forName("com.mysql.jdbc.Driver").newInstance();
	         con = DriverManager.getConnection(sqlhost,sqlusr,sqlpwd);
	      } catch(Exception e) {
	         System.out.println("SQL Error: "+ e);
	      }
		try {
			Scanner sc = new Scanner(System.in);
	        System.out.println("\nLogin\nEnter your username: ");
	       
	         String usr=sc.next();
	         System.out.println("Enter your password: ");
	         String pwd=sc.next();
	         usr.toLowerCase();
	         pwd.toLowerCase();
	         stmt = con.createStatement();
	         String query = "SELECT * FROM login WHERE username='" + usr + "'";
	         ResultSet rs = stmt.executeQuery(query);
	         
	         while (rs.next()) {
	             String pd = rs.getString("password");
	            
	             if(pwd.compareTo(pd)!=0)
	             {
	             System.out.println("Wrong Password!!!\n\n");
	             return false;
	             }
	             else
	             {
	              System.out.println("------------------------------------- ");
		          System.out.println("Welcome to Airline-Reservation-System");
		          System.out.println("------------------------------------- ");
	              System.out.println("Login Successful to user: "+usr+"\n");
	              System.out.println("\n------------------------------------------ ");
	      		  System.out.println("User:"+ usr +"  |  Menu: (Enter option number)");
	      		  System.out.println("------------------------------------------ ");
	             }
	             
	             if(usr.compareTo("admin")==0)
	              AdminMode=true;
	             else
	              AdminMode=false;	             
	          }
	         return true;
	      }catch(SQLException e) {	    	 
	         System.out.println("Wrong Username or Password!!!!!!\n");
	         return false;
	      }
		
	}

}