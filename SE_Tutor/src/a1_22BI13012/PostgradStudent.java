package a1_22BI13012;

import utils.*;
import java.lang.Math;

/**
 * @overview PostgradStudent represent someone who has graduate from school
 * @attributes
 * id				Integer		int
 * name				String		string 
 * phoneNumber		String		string
 * address			String		string
 * gpa				Float		float
 * @objects a typical PostgradStudent object is s=<i, n, p, a, g>, where id(i), name(n), phoneNumber(p), address(a), gpa(g)
 * @abstract_properties
 * mutable(id) = false /\ optional(id) = false /\ P_Student.min /\ min(id) = 10^8 + 1 /\ P_Student.max /\ max(id) = 10^9
 * mutable(name) = true /\ optional(name) = false /\ length(name) = 50
 * mutable(phoneNumber) = true /\ optional(phoneNumber) = false /\ length = 10
 * mutable(address) = true /\ optional(address) = false /\ length = 100
 * mutable(gpa) = true /\ optional(gpa) = false /\ min(gpa) = 0.0 /\ max(gpa) = 4.0
 */
public class PostgradStudent extends Student{
	// attributes
	@DomainConstraint(mutable = false, optional = false, min = 10^8 + 1, max = 10^9)
	private int id;
	
	@DomainConstraint(mutable = true, optional = false, length = 50)
	private String name;
	
	@DomainConstraint(mutable = true, optional = false, length = 10)
	private String phoneNumber;
	
	@DomainConstraint(mutable = true, optional = false, length = 100)
	private String address;
	
	@DomainConstraint(mutable = true, optional = false, min = 0.0, max = 4.0)
	private float gpa;
	
	// methods
	// constructor
	/*
	 * @modifies this.id, this.name, this.phoneNumber, this.address
	 * @effects <pre>
	 * if id, name, phoneNumber, address are valid
	 * 		initialize this as <id, name, phoneNumber, address>
	 * else
	 * 		throw NotPossibleException
	 * </pre>
	 */
	public PostgradStudent(
			@AttrRef("id") int id,
			@AttrRef("name") String name,
			@AttrRef("phoneNumber") String phoneNumber,
			@AttrRef("address") String address,
			@AttrRef("gpa") float gpa)
			throws NotPossibleException {
		//TODO: check attributes validation
		super(id, name, phoneNumber, address);
		if(!validateId(id)) {
			throw new NotPossibleException("Invalid id!");
		}
		
		if(!validateName(name)) {
			throw new NotPossibleException("Invalid name!");
		}
		
		if(!validatePhoneNumber(phoneNumber)) {
			throw new NotPossibleException("Invalid phone number!");
		}
		
		if(!validateAddress(address)) {
			throw new NotPossibleException("Invalid address!");
		}
		
		if(!validateGPA(gpa)) {
			throw new NotPossibleException("Invalid GPA");
		}
		
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.gpa = gpa;
	}
	
	// getters 
	/*
	 * @effect return this.id 
	 */
	@DOpt(type = OptType.Observer) @AttrRef("id")
	public int getId() {
		return this.id;
	}
	
	/*
	 * @effect return this.name 
	 */
	@DOpt(type = OptType.Observer) @AttrRef("name")
	public String getName() {
		return this.name;
		
	}
	
	/*
	 * @effect return this.phoneNubmer 
	 */
	@DOpt(type = OptType.Observer) @AttrRef("phoneNumber")
	public String getPhoneNumber() {
		return this.phoneNumber;
		
	}
	
	/*
	 * @effect return this.address 
	 */
	@DOpt(type = OptType.Observer) @AttrRef("address")
	public String getAddress() {
		return this.address;
		
	}
	
	
	//setters
	/*
	 * @effects <pre>
	 * if newName is valid
	 * 		set this.name = newName
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 */
	@DOpt(type = OptType.Mutator) @AttrRef("name")
	public boolean setName(String newName) {
		if(validateName(newName)) {
			this.name = newName;
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * @effects <pre>
	 * if newphoneNumber is valid
	 * 		set this.phoneNumber = newphoneNumber
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 */
	@DOpt(type = OptType.Mutator) @AttrRef("phoneNumber")
	public boolean setPhoneNumber(String newphoneNumber) {
		if(validatePhoneNumber(newphoneNumber)) {
			this.phoneNumber = newphoneNumber;
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * @effects <pre>
	 * if newAddress is valid
	 * 		set this.address = newAddress
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 */
	@DOpt(type = OptType.Mutator) @AttrRef("address")
	public boolean setAddress(String newAddress) {
		if(validateAddress(newAddress)) {
			this.address = newAddress;
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * @effects <pre>
	 * if newGPA is valid
	 * 		set this.gpa = newGPA
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 */
	@DOpt(type = OptType.Mutator) @AttrRef("gpa")
	public boolean setGPA(float newGPA) {
		if(validateGPA(newGPA)) {
			this.gpa = newGPA;
			return true;
		} else {
			return false;
		}
	}
	
	// helper - validators
	/*
	 * @effects <pre>
	 * if id is valid
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 * 
	 */
	public boolean validateId(int id) {
		
		//min
		if(id < Math.pow(10, 8) + 1) {
			return false;
		}
		
		//max
		if(id > Math.pow(10, 9)) {
			return false;
		}
		
		return true;
		
	}
	
	/*
	 * @effects <pre>
	 * if name is valid
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 * 
	 */
	public boolean validateName(String name) {
		
		// optional
		if(name == null || name.length() == 0) {
			return false;
		}
		
		// length
		if(name.length() > 50) {
			return false;
		}
		
		return true;
	}
	
	/*
	 * @effects <pre>
	 * if phoneNumber is valid
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 * 
	 */
	public boolean validatePhoneNumber(String phoneNumber) {
		
		// optional
		if(phoneNumber == null || phoneNumber.length() == 0) {
			return false;
		}
		
		// length
		if(phoneNumber.length() > 10) {
			return false;
		}
		
		return true;
	}
	
	/*
	 * @effects <pre>
	 * if address is valid
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 * 
	 */
	public boolean validateAddress(String address) {
		
		// optional
		if(address == null || address.length() == 0) {
			return false;
		}
		
		// length
		if(address.length() > 100) {
			return false;
		}
		
		return true;
	}
	
	/*
	 * @effects <pre>
	 * if gpa is valid
	 * 		return true
	 * else
	 * 		return false
	 * </pre>
	 * 
	 */
	public boolean validateGPA(float gpa) {
		
		// min
		if(gpa < 0.0) {
			return false;
		}
		
		// max
		if(gpa > 4.0) {
			return false;
		}
		
		return true;
	}
	
	// repOK
	/*
	 * @effects <pre>
	 * if this satisfies abstract properties
	 * 		return true
	 * else 
	 * 		return false
	 * </pre>
	 * 
	 */
	public boolean repOK() {
		if(validateId(this.id) && validateName(this.name) && validatePhoneNumber(this.phoneNumber) && validateAddress(this.address) && validateGPA(this.gpa)) {
			return true;
		} else {
			return false;
		}
	}
	
	// toString
	public String toString() {
		return "PostgradStudent <id="+this.id+", name="+this.name+", phone="+this.phoneNumber+", address="+this.address+", GPA="+this.gpa+">";
	}
}