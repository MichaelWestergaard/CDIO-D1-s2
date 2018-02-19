package dal;
import java.io.IOException;

import dto.UserDTO;

public interface IUserDAO {

	UserDTO getUser(int userId) throws DALException;
	void createUser(int userID, String userName, String ini, String role, String cpr) throws DALException, IOException;
	void updateUser(UserDTO user) throws DALException;
	void deleteUser(int userId) throws DALException, IOException;
	
	
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
