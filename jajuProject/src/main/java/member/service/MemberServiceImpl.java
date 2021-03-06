package member.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private HttpSession session;

	@Override
	public MemberDTO login(Map<String, String> map) {
		MemberDTO memberDTO = memberDAO.login(map);
		
		return memberDTO;
	}

	@Override
	public String checkId(String member_id) {
		MemberDTO memberDTO = memberDAO.getMember(member_id);
		
		if(memberDTO != null) {
			return "exist";
		}else {
			return "non_exist";			
		}
	}

	@Override
	public void write(MemberDTO memberDTO) {
		memberDAO.write(memberDTO);
	}
	
	@Override
	public void kakao_write(Map<String, String> map) {
		memberDAO.kakao_write(map);
	}

	@Override
	public String getId(Map<String, String> map) {
		MemberDTO memberDTO = memberDAO.getId(map);
		
		if(memberDTO != null) {
			return memberDTO.getMember_id();
		}else {
			return "fail";			
		}
	}

	@Override
	public String getPwd(Map<String, String> map) {
		MemberDTO memberDTO = memberDAO.getPwd(map);
		
		if(memberDTO != null) {
			return memberDTO.getMember_pwd();
		}else {
			return "fail";			
		}
	}
	
	@Override
	public void modify(MemberDTO memberDTO) {
		memberDAO.modify(memberDTO);
	}

	@Override
	public MemberDTO getMember(String member_id) {
		return memberDAO.getMember(member_id);
	}

	@Override
	public String isBlackList(String member_email) {
		MemberDTO memberDTO = memberDAO.isBlackList(member_email);
		
		if(memberDTO != null) {
			return "blackList";
		}else {
			return "non_blackList";
		}
	}

	@Override
	public void retire(String member_id) {
		memberDAO.retire(member_id);
	}
}
