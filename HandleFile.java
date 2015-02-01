
/**
 *
 * @author DinaSu
 */

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

public class HandleFile {

	private UserInterface _form;
	private Map<Integer, DataInput> _phoneBook;
        File _file; 
	
	public void startMemoProsses() {
		_phoneBook = new HashMap<>();
		initMemoMap();
		_form = new UserInterface(this);
		_form.setVisible(true);
		_form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

        
        private void initMemoMap() {
		
		try {
			ObjectInputStream input = new ObjectInputStream(_file);
			try {
				_phoneBook = (Map<Integer,DataInput>) input.readObject();
			} catch (ClassNotFoundException e) {
				System.out.println("could not find the object being read");
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("please create a text file named phoneBook.txt in the dir C:\temp");
		} catch (IOException e) {
			System.out.println("could not read the specified file");
		}
	}

        
	public void saveMemo(DataInput data) {
		_phoneBook.put(1,data);//change the 1 to hash TODO !!!!
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("phoneBook.txt"));
			output.writeObject(_phoneBook);
			output.flush();
			output.close();
		} catch (IOException e) {
			System.out.println("could not write to the phoneBook.txt file");
		}
		
	}

	public void loadMemo(DataInput data) {
		_form.set_phoneList(data.get_name()+data.get_phoneNumber());
		
	}
        

}
