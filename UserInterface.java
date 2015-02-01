/** 
 * @author DinaSu
 */


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class UserInterface extends JFrame{

	private JPanel _topPanel;
	private JPanel _centerPanel;
	private JPanel _buttomPanel;
	private JTextField _nameField;
	private JTextField _phoneNumberField;
	private JTextArea _phoneList;
	
	private JButton _save;
	private JButton _load;
	
	public UserInterface(final HandleFile controller) {
		super("Phone Book");
		
		setLayout(new GridLayout(3, 0));
		_topPanel = new JPanel();
		_centerPanel = new JPanel();
		_phoneList = new JTextArea(8, 25);
                _buttomPanel = new JPanel(new GridLayout(4, 4));
		initTextField();
		
                //top panel name and phone input
                _topPanel.add(new JLabel("name:"));
		_topPanel.add(_nameField);
		_topPanel.add(new JLabel("phoneNumber:"));
		_topPanel.add(_phoneNumberField);
                
                
                //clear text area 
		ActionListener newDataInput = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				set_phoneList("");
			}
		};
		_nameField.addActionListener(newDataInput);
		_phoneNumberField.addActionListener(newDataInput);
                // save and load buttons
		_save = new JButton("save");
		_load = new JButton("load");
                _buttomPanel.add(_save);
                _buttomPanel.add(_load);
                

                
		ActionListener pressed = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == _save){
					controller.saveMemo(new DataInput(_nameField.getText(),_phoneNumberField.getText()));
				}else if(e.getSource() == _load){
					controller.loadMemo(_phoneList);
				}
			}
		};
                
		_save.addActionListener(pressed);
		_load.addActionListener(pressed);

		
		add(_topPanel);
		add(_centerPanel);
		add(_buttomPanel);
		setSize(400, 500);
		
		
	}

	private void initTextField() {
		_nameField = new JTextField(10);
		_phoneNumberField = new JTextField(10);
	}

	public void set_phoneList(String text) {
		this._phoneList.setText(text);
	}
	public String get_phoneList() {
		return _phoneList.getText();
	}
}
