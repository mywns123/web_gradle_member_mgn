package web_gradle_member_mgn.dao;

import java.util.List;

import web_gradle_member_mgn.dto.Member;

public interface MemberDao {
	
	List<Member> SelectMemberAll();
	
	Member selectMemberById(Member member);
	
	int InsertMember(Member member);
	
	int UpdateMember(Member member);	
	
	int DelMember(Member member); 	
}
