package studentman;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * @overview UndergradStudent represent someone who is participating in a school's course(s)
 * @attributes
 * id				Integer		int
 * name				String		string 
 * phoneNumber		String		string
 * address			String		string
 * @objects a typical UndergradStudent object is s=<i, n, p, a>, where id(i), name(n), phoneNumber(p), address(a)
 * @abstract_properties
 * P_Student.id /\ min(id) = 10^5 /\ max(id) = 10^8 /\
 * P_Student.name /\
 * P_Student.phoneNumber /\
 * P_Student.address /\
 * 
 * @author Dinh Vu Anh
 * 		https://github.com/VuAnh183/SE_Java
 */
public class UndergradStudent extends Student{
	
	// methods
	// constructor
	/**
	 * @modifies this.id, this.name, this.phoneNumber, this.address
	 * @effects <pre>
	 * if id, name, phoneNumber, address are valid
	 * 		initialize this as (id, name, phoneNumber, address)
	 * else
	 * 		throws new NotPossibleException
	 * </pre>
	 */
	public UndergradStudent(
			@AttrRef("id") int id,
			@AttrRef("name") String name,
			@AttrRef("phoneNumber") String phoneNumber,
			@AttrRef("address") String address)
			throws NotPossibleException {
		//TODO: check attributes validation
		super(id, name, phoneNumber, address);
		if(!validateId(id)) {
			throw new NotPossibleException("Invalid id!");
		}
		
	}
	
	
	// helper - validators
	/**
	 * @effects <pre>
	 * if id is valid
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 * 
	 */
	@Override
	@DomainConstraint(mutable = false, optional = false, min = 10e5, max = 10e8)
	public boolean validateId(int id) {
		System.out.println("ValidateID UndergradStudent");
		//min
		if(id < (int) (Math.pow(10, 5))) {
			return false;
		}
		
		//max
		if(id > (int) (Math.pow(10, 8))) {
			return false;
		}
		
		return true;
		
	}
	
	// toString
	@DOpt(type = OptType.Default) 
	@Override
	public String toString() {
		String temp = super.toString();
		return "Undergrad" + temp;
	}
	
	//toHtmlDoc
	/**
	 * @effects String representation for the current object
	 */
	@DOpt(type = OptType.Default)
	@Override
	public String toHtmlDoc() {
		// TODO Auto-generated method stub
		return String.format(
				"<html>\\n<head><title>Student: %d - %s</title></head>\\n<body>\\n%s %s %s %s\\n</body></html>\",\r\n",
				id, name, id, name, phoneNumber, address
				);
	}	
}
