package gui.property.edit;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import gui.property.edit.mouse.AddImage;
import gui.property.edit.mouse.Exit;
import gui.property.edit.mouse.Save;
import utils.Utils;
import property.Property;
import property.list.PropertyTableGUI;
import user.Admin;
import user.Owner;
import user.mask.Flag;

public class Controller extends Edit {

	private static final long serialVersionUID = 1322530645747508580L;

	private PropertyTableGUI owner;
	private gui.login.Controller loginController;
	private Property property;
	private boolean isNew;
	private ImageIcon photo;

	public Controller(PropertyTableGUI owner, gui.login.Controller loginController, Property property) {
		super();
		this.owner = owner;
		this.loginController = loginController;
		this.property = property;
		this.isNew = false;
		this.prepare();
	}

	public Controller(PropertyTableGUI owner, gui.login.Controller loginController) {
		super();
		this.owner = owner;
		this.loginController = loginController;
		this.property = new Property(0D, "", "", 0, 0, 0, 0, "", 0, false, "", "");
		this.isNew = true;
		this.prepare();
	}

	/**
	 * Permissions
	 */
	public void checkPermissions() {
		boolean pass = false;

		pass = Flag.isFlag(this.loginController.getSession().getFlags(), Flag.VIEW);

		/**
		 * Owners
		 */
		if (!(this.loginController.getSession() instanceof Admin)) {

			if (!(this.loginController.getSession() instanceof Owner))
				Utils.fatalExit();

			Owner owner = (Owner) this.loginController.getSession();

			if (!this.isNew)
				pass &= Flag.isFlag(this.loginController.getSession().getFlags(), Flag.PROPERTY_EDIT) & owner.containsProperty(this.property);
			else
				pass &= Flag.isFlag(this.loginController.getSession().getFlags(), Flag.PROPERTY_NEW);
		} else {
			/**
			 * Admins
			 */
			if (!this.isNew)
				pass &= Flag.isFlag(this.loginController.getSession().getFlags(), Flag.ADMIN_PROPERTY_EDIT);
			else
				pass &= false;
		}

		if (!pass)
			Utils.fatalExit();
	}

	private void prepare() {

		/**
		 * Permissions
		 */
		this.checkPermissions();

		/**
		 * Events
		 */
		super.mntmUpdatePhoto.addActionListener(new AddImage(this));
		super.mntmSave.addActionListener(new Save(owner, this, this.loginController));
		super.mntmExit.addActionListener(new Exit(owner, this));

		/**
		 * GUI
		 */
		if (!this.isNew)
			super.setTitle("Editar Inmueble" + Utils.getTitle());
		else
			super.setTitle("Nuevo Inmueble" + Utils.getTitle());

		super.textArea.setText(String.valueOf(this.property.getArea()));
		super.textAddress.setText(this.property.getAddress());
		super.textCity.setText(this.property.getCity());
		super.txtrDescription.setText(this.property.getDescription());
		super.textStratum.setText(String.valueOf(this.property.getStratum()));
		super.textSalePrice.setText(String.valueOf(this.property.getSalePrice()));
		super.textLeasePrice.setText(String.valueOf(this.property.getLeasePrice()));
		super.textTimeBuild.setText(this.property.getTimeBuilt());
		super.textCostOfAdministration.setText(String.valueOf(this.property.getCostOfAdministration()));
		super.chckbxPrivateSecurity.setSelected(this.property.isPrivateSecurity());

		try {
			this.photo = Utils.getPhoto(this.property.getPhoto(), 517, 327);
			super.lblPhoto.setIcon(this.photo);
		} catch (Exception e) {
			try {
				this.photo = Utils.getPhoto("not found.png", 517, 327);
				super.lblPhoto.setIcon(this.photo);
			} catch (Exception e1) {
				super.lblPhoto.setIcon(null);
			}
		}

		Utils.centerFrame(this);
		this.setVisible(true);
	}

	public ImageIcon getPhoto() {
		return photo;
	}

	public void setPhoto(String relativePath) {
		try {
			this.photo = Utils.getPhoto(relativePath, 517, 327);
			super.lblPhoto.setIcon(this.photo);
		} catch (Exception e) {
		}
	}

	public JTextField getTextArea() {
		return super.textArea;
	}

	public JTextField getTextAddress() {
		return super.textAddress;
	}

	public JTextField getTextCity() {
		return super.textCity;
	}

	public JTextField getTextStratum() {
		return super.textStratum;
	}

	public JTextField getTextSalePrice() {
		return super.textSalePrice;
	}

	public JTextField getTextLeasePrice() {
		return super.textLeasePrice;
	}

	public JTextField getTextTimeBuild() {
		return super.textTimeBuild;
	}

	public JTextField getTextCostOfAdministration() {
		return super.textCostOfAdministration;
	}

	public JLabel getLblPhoto() {
		return super.lblPhoto;
	}

	public JCheckBox getChckbxPrivateSecurity() {
		return super.chckbxPrivateSecurity;
	}

	public JTextArea getTxtrDescription() {
		return super.txtrDescription;
	}

	public Property getProperty() {
		return property;
	}

	public boolean isNew() {
		return isNew;
	}
}
