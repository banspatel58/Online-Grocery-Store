package Server;

/********************************************************************************
 *  @author Bansari Patel
 * 
 * Modal: DatabaseResult is a serializable object that contains the attribute
 * related to the database result set.
 *********************************************************************************/
public class DatabaseResult implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	public String rs;
	
    public DatabaseResult(String s) { 
    
    	this.rs = s;
    	
    }
    
}

