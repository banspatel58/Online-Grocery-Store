/**
 * 
 */
package Client;

/*************************************************************
 * @author Bansari Patel
 *
 * Factory Producer: This class is responsible for producing
 * factories that execure their respective commands. It is a
 * factory invoker class. It is an added layer of abstraction.
 * It produces factories namely Admin command Factory and the
 * Customer Command Factory.
 *************************************************************/
public class FactoryProducer {


	public FactoryProducer() {

		
		
	}
	
	public static AbstractCommandFactory getFactory(String Type) {
		
        if (Type.equalsIgnoreCase("Admin")) {
        	
            return new AdminCommandFactory();
            
        } else if (Type.equalsIgnoreCase("Customer")) {
        	
            return new CustomerCommandFactory();
            
        }
        
        return null;
        
    }

}
