package gui.main;

/**
 * MIDIPlayer
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import java.awt.EventQueue;

import javax.swing.JList;

import serializer.engine.Serializer;
import utils.Utils;
import gui.main.check.Repeat;
import gui.main.mouse.AddFile;
import gui.main.mouse.DeleteElement;
import gui.main.mouse.EmptyList;
import gui.main.mouse.Exit;
import gui.main.mouse.LoadList;
import gui.main.mouse.PlayAndPause;
import gui.main.mouse.SaveList;
import gui.main.mouse.Stop;
import gui.main.mouse.StopList;
import gui.main.mouse.ViewDetails;
import gui.main.player.MIDIPlayerController;
import gui.main.window.WindowController;
import library.Library;
import midi.MIDITableModel;
import midi.Song;
import midi.MIDIListModel;
import midi.MIDIPLayList;
import midi.SongList;

public class Controller extends Main {

	private static final long serialVersionUID = 6445097674136753468L;

	private MIDIPLayList playList;
	private MIDIListModel<Song> MIDIList;
	private MIDITableModel MIDITable;
	private MIDIPlayerController playerController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller frame = new Controller();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Controller() {
		super();

		/*
		 * Serializer
		 */
		Serializer s = new Serializer(Utils.getLibrary());
		Object object = s.unserialize();

		if (object != null && object instanceof Library) {
			Library library = (Library) object;
			SongList.setInstance(library.getSongList());
			this.playList = library.getPlaylists();
		} else
			this.playList = new MIDIPLayList();

		/*
		 * Modelo
		 */
		this.MIDIList = new MIDIListModel<Song>();
		jList.setModel(this.MIDIList);
		this.playerController = new MIDIPlayerController(this);

		this.MIDITable = new MIDITableModel();

		super.table.setModel(this.MIDITable);

		for (int i = 0; i < 20; i++)
			this.MIDITable.addFile(new java.io.File("files\\avicii-hey_brother.mid"));

		/*
		 * Eventos
		 */

		this.addWindowListener(new WindowController(this));

		mntmAddFile.addActionListener(new AddFile(this));
		mntmLoad.addActionListener(new LoadList(this));
		mntmRemove.addActionListener(new DeleteElement(this));
		mntmSave.addActionListener(new SaveList(this));
		mntmClear.addActionListener(new EmptyList(this));
		mntmProperties.addActionListener(new ViewDetails(this));
		mntmExit.addActionListener(new Exit());

		btnPlayPause.addMouseListener(new PlayAndPause(this));
		btnStop.addMouseListener(new Stop(this));
		btnStopList.addMouseListener(new StopList(this));

		chckbxRepeat.addActionListener(new Repeat(this));

		// Crear frame
		Utils.centerFrame(this);
	}

	/*
	 * Getters & Setters
	 */

	public JList<Song> getList() {
		return this.jList;
	}

	public MIDIPLayList getPlayList() {
		return playList;
	}

	public void setPlayList(MIDIPLayList playList) {
		this.playList = playList;
	}

	public MIDIListModel<Song> getMIDIList() {
		return MIDIList;
	}

	public void setMIDIList(MIDIListModel<Song> mIDIList) {
		MIDIListModel<Song> clon = new MIDIListModel<Song>();

		for (int i = 0; i < mIDIList.getSize(); i++)
			clon.addElement(mIDIList.get(i));

		MIDIList = clon;
		jList.setModel(this.MIDIList);
	}

	public MIDIPlayerController getPlayerController() {
		return playerController;
	}

	public void setPlayerController(MIDIPlayerController playerController) {
		this.playerController = playerController;
	}
}
