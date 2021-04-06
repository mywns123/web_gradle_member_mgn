package web_gradle_member_mgn;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import web_gradle_member_mgn.dao.impl.MemberDaoImpl;
import web_gradle_member_mgn.dto.Member;

public class MemberDaoTest {
	private static Connection con;
	private MemberDaoImpl dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//MemberDaoTest.java 가 수행되기 전 호출
		con = JdbcUtil.getConnection();
	}

	@Before
	public void setUp() throws Exception {
		//Test method가 호출되기 전에 호출
		dao = MemberDaoImpl.getInstance();
		dao.setCon(con);
	}

	@Test
	public void testSelectMemberByIdSuccess() {
		System.out.println("testSelectMemberById()-Success");
		Member member = new Member("1", "1111");
		Member memberLogin = dao.selectMemberById(member);
		System.out.println("memberLogin : " + memberLogin);
		Assert.assertNotNull(memberLogin);
	}

	@Test
	public void testSelectMemberByIdFail() {
		System.out.println("testSelectMemberById()-Fail");
		Member member = new Member("1", "1112");
		Member memberLogin = dao.selectMemberById(member);
		System.out.println("memberLogin : " + memberLogin);
		
		Assert.assertNull(memberLogin);
	}	
	
}
