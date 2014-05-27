package user;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
import user.mask.Flag;

public class Owner extends User implements Rol {

	public Owner(String name, String surname, int phone, int cellphone, int dni, String nick, String password, String email) {
		super(name, surname, phone, cellphone, dni, nick, password, email);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getFlags() {
		return Flag.VIEW | Flag.USER_EDIT | Flag.USER_DELETE;
	}

}