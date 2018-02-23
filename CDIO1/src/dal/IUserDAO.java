package dal;
import java.io.IOException;
import java.util.List;

import dto.UserDTO;

public interface IUserDAO {

	public UserDTO getUser(int userId) throws DALException;

	public List<UserDTO> getUserList() throws DALException, IOException, ClassNotFoundException;

	public void saveUsers() throws IOException;

	public void createUser(int userID, String userName, String ini, String role, String cpr) throws DALException, IOException;

	public boolean checkPassword(String password);

	public boolean checkUserName(String userName);

	public boolean checkIni(String ini);

	public boolean checkRole(String role);

	public boolean checkCPR(String cpr);

	public boolean checkId(int userId);

	public void updateUserName(int userId, String userName) throws DALException, IOException;

	public void updateIni(int userId, String ini) throws DALException, IOException;

	public void updateRole(int userId, String role) throws DALException, IOException;

	public void updateCpr(int userId, String cpr ) throws DALException, IOException;

	public String makePassword(int length);

	public String randomCharacter(String characters);

	public String insertAtRandom(String str, String toInsert);

	public void deleteUser(int userId) throws DALException, IOException;
	
	public class DALException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 7355418246336739229L;

		public DALException(String msg, Throwable e) {
			super(msg,e);
		}

		public DALException(String msg) {
			super(msg);
		}

	}

}
