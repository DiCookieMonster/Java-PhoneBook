/**
 *
 * @author DinaSu
 */
import java.io.Serializable;



public class DataInput implements Serializable {
	
	private String _name;
	private String _phoneNumber;

	
	public DataInput(String name, String phoneNumber){
		this._name = name;
		this._phoneNumber = phoneNumber;

	}
	
	

	@Override
	public String toString() {
		return "" + this._name + "-" + this._phoneNumber + "-";
	}



	@Override
	public boolean equals(Object obj) {
		if(obj instanceof DataInput){
			DataInput date = (DataInput)obj;
			return this._name == date.get_name() && this.get_phoneNumber() == date.get_phoneNumber();
					
		}
		return false;
	}

	public int hashCode() {
		
		int result = 0;
		result = result + Integer.parseInt(_name + _phoneNumber);
		return result;
	} 



	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String get_phoneNumber() {
		return _phoneNumber;
	}

	public void set_phoneNumber(String _phoneNumber) {
		this._phoneNumber = _phoneNumber;
	}


	
}
