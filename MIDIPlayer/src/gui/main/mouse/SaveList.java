package gui.main.mouse;

import gui.main.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveList implements ActionListener {

	private Controller controller;

	public SaveList(Controller controller) {
		super();
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent e) {
		new gui.save.Controller(this.controller, this.controller.getMIDIList());
	}

}