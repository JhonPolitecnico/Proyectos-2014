package gui.property.list;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class List extends JFrame {

	private static final long serialVersionUID = 5759811461465050437L;

	protected JPanel contentPane;
	protected JTable table;
	protected JMenu mnUser;
	protected JMenuBar menuBar;
	protected JMenuItem mntmViewProfile;
	protected JMenuItem mntmEditProfile;
	protected JMenuItem mntmViewEstate;
	protected JMenuItem mntmAddEstate;

	/**
	 * Create the frame.
	 */
	public List() {
		setTitle("Inmuebles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 480);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnUser = new JMenu("Usuario");
		menuBar.add(mnUser);

		mntmViewProfile = new JMenuItem("Ver perfil");
		mnUser.add(mntmViewProfile);

		mntmEditProfile = new JMenuItem("Editar perfil");
		mnUser.add(mntmEditProfile);

		JSeparator separator = new JSeparator();
		mnUser.add(separator);

		mntmViewEstate = new JMenuItem("Ver inmuebles");
		mnUser.add(mntmViewEstate);

		mntmAddEstate = new JMenuItem("Agregar inmueble");
		mnUser.add(mntmAddEstate);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(scrollPane, Alignment.LEADING)
										.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)).addGap(1)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane.createSequentialGroup().addComponent(panel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE).addGap(0)));

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblBusquedaYFiltros = new JLabel("Busqueda y Filtros");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(
				gl_panel.createSequentialGroup().addContainerGap(333, Short.MAX_VALUE).addComponent(lblBusquedaYFiltros).addGap(330)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(
				gl_panel.createSequentialGroup().addContainerGap(45, Short.MAX_VALUE).addComponent(lblBusquedaYFiltros).addGap(44)));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
