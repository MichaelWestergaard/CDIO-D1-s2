package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.UserDTO;

public class UserDTOTest {
	
	UserDTO user = new UserDTO(21,"Bo","ni","Admin","117766-5566","erggggg");
	@Test
	public void testGetUserId() {
		int expected = 21;
		int actual = user.getUserId();

		assertEquals(expected, actual);
		System.out.println(user.getUserId());
	}

	@Test
	public void testGetUserName() {
		String expected = "Bo";
		String actual = user.getUserName();

		assertEquals(expected, actual);
	}

	@Test
	public void testGetIni() {
		String expected = "ni";
		String actual = user.getIni();

		assertEquals(expected, actual);
	}

	@Test
	public void testGetCpr() {
		String expected = "117766-5566";
		String actual = user.getCpr();

		assertEquals(expected, actual);
	}

	@Test
	public void testGetRole() {
		String expected = "Admin";
		String actual = user.getRole();

		assertEquals(expected, actual);
	}

	@Test
	public void testGetPassword() {
		String expected = "erggggg";
		String actual = user.getPassword();

		assertEquals(expected, actual);
	}

}
