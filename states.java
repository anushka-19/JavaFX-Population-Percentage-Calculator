
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class states{
         String state_name;
	 int num_men;
	 int num_women;
	 int num_child;
	public states(String state_name, int num_men, int num_women, int num_child) {
		super();
                this.state_name = state_name;
		this.num_men = num_men;
		this.num_women = num_women;
		this.num_child = num_child;
	}
	 
	public ArrayList<Object> getData(String state_name)throws ClassNotFoundException, SQLException {
		
                ArrayList<Object> result= new ArrayList<Object>();
                
		String state="";
                int men=0;
		int women=0;
		int child=0;
                
		Class.forName("com.mysql.cj.jdbc.Driver");
                
                
                
                
		Connection con = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/statesdb","dbusername","dbpassword");
		Statement st = con.createStatement();
		ResultSet rs = 
				st.executeQuery("SELECT * FROM states WHERE state_name= '"+ state_name+"';");
		while (rs.next()) {
		
		state=rs.getString("state_name");
		men=rs.getInt("num_men");
		women=rs.getInt("num_women");
                child=rs.getInt("num_child");
		
		}

		st.close();
		con.close();
                
                
                float fmen = men;
                float fwomen = women;
                float fchild = child;
                float permen=(((fmen)*100)/(men+women+child));
                float perwomen=(((fwomen)*100)/(men+women+child));
                float perchild=(((fchild)*100)/(men+women+child));
                        
                result.add(men);
                result.add(permen);
                result.add(women);
                result.add(perwomen);
                result.add(child);
                result.add(perchild);
                
		
		
                return result;
	}
	
	
	
	 
}
