package midi;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.io.Serializable;
import java.util.HashMap;

public class MIDIPLayList implements Serializable {

	private static final long serialVersionUID = -3060777809404304238L;

	private HashMap<String, MIDIListModel<Song>> lists;

	public MIDIPLayList() {
		this.lists = new HashMap<String, MIDIListModel<Song>>();
	}

	public void addList(String name, MIDIListModel<Song> list) {
		this.lists.put(name, list);
	}

	public void replaceList(String name, MIDIListModel<Song> list) {
		this.lists.replace(name, list);
	}

	public HashMap<String, MIDIListModel<Song>> getLists() {
		return lists;
	}

	public void setLists(HashMap<String, MIDIListModel<Song>> lists) {
		this.lists = lists;
	}

}
