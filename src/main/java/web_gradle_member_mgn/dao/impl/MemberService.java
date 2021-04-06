package web_gradle_member_mgn.dao.impl;

import java.util.List;

import web_gradle_member_mgn.ds.JndiDs;
import web_gradle_member_mgn.dto.Member;

public class MemberService {
	private MemberDaoImpl dao;	
	
	public MemberService() {
		dao = MemberDaoImpl.getInstance();
		dao.setCon(JndiDs.getConnection());
	}
	
	public List<Member> showMember(){
		return dao.SelectMemberAll();
	}
	
	public Member loginMember(Member member) {
		return dao.selectMemberById(member);
	}
	
	public int InsertMember(Member member) {
		return dao.InsertMember(member);
	}	
	
	public int DeleteMember(Member member) {
		return dao.DelMember(member);
	}
	
	public int UPdateMember(Member member) {
		return dao.UpdateMember(member);
	}
}
