package managerMember.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import managerMember.bean.ManagerMainDTO;
import managerMember.bean.ManagerPaging;
import managerMember.service.ManagerMemberService;
import member.bean.MemberDTO;

@Controller
@RequestMapping(value = "/manager")
public class ManagerMemberController {

	@Autowired
	private ManagerMemberService managerMemberService;
	

	@RequestMapping(value = "managerMember", method = RequestMethod.GET)
	public ModelAndView managerMember(@RequestParam(required = false, defaultValue = "1") String pg) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg",pg);
		mav.setViewName("/manager/managerMember");
		return mav;
	}

	// 화면 띄웠을 때 리스트 가져오기
	@RequestMapping(value = "/getManagerMember", method = RequestMethod.POST)
	@ResponseBody
	
	public ModelAndView getManagerMember(@RequestParam Map<String, String> map,
			@RequestParam(required = false, defaultValue = "1") String pg) {
		System.out.println("관리자 리스트 가져오는 곳 맵 : " + map);

		List<MemberDTO> list = managerMemberService.getManagerMember(map);// pg넘겨서 페이징 처리해서 회원 리스트 가져오기

		ManagerPaging managerPaging = managerMemberService.managerPaging(map);


		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.addObject("managerPaging", managerPaging);
		mav.setViewName("jsonView");
		return mav;
	}

	// 활동정지
	@RequestMapping(value = "changeMemberState", method = RequestMethod.POST)
	// check 안에는 id값이 담겨있음.
	public ModelAndView changeMemberState(String[] check,
			@RequestParam(required = false, defaultValue = "1") String pg) {
		System.out.println("check = " + check[0]);
		managerMemberService.changeMemberState(check);
		return new ModelAndView("redirect:/manager/managerMember");
	}

	// 강제탈퇴
	@RequestMapping(value = "deleteMemberId", method = RequestMethod.POST)
	public ModelAndView deleteMemberId(String[] check) {
		System.out.println("check = " + check[0]);
		managerMemberService.deleteMemberId(check);
		return new ModelAndView("redirect:/manager/managerMember");
	}

	// 검색(아이디,이메일,아디+이멜) 검색 후 결과출력
	@RequestMapping(value = "getSearchMemberInfo", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getSearchMemberInfo(@RequestParam Map<String, String> map,
			@RequestParam(required = false, defaultValue = "1") String pg) {
		//System.out.println("getSearchMemberInfo : " + map);

		List<MemberDTO> list = managerMemberService.getSearchMemberInfo(map);// pg넘겨서 페이징 처리해서 회원 리스트 가져오기
		
		ManagerPaging managerSearchPaging = managerMemberService.managerSearchPaging(map);

		//System.out.println("getSearchMemberInfo= " + list);

		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		mav.addObject("managerSearchPaging", managerSearchPaging);
		return mav;
	}

	// 전체회원 페이지 오픈 하는 곳, pg 1로 넘기기
	@RequestMapping(value = "/managerMemberBlack", method = RequestMethod.GET)
	public String managerMemberBlack(Model model, @RequestParam(required = false, defaultValue = "1") String pg) {
		model.addAttribute("pg", pg);
		model.addAttribute("display", "/manager/managerMemberBlack.jsp");
		return "/index";
	}

	// 블랙리스트 불러오기
	@RequestMapping(value = "/getManagerMemberBlack", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getManagerMemberBlack(@RequestParam Map<String, String> map,
		@RequestParam(required = false, defaultValue = "1") String pg) {
		System.out.println("블랙리스트 맵 : " + map);

		List<MemberDTO> list = managerMemberService.getManagerMemberBlack(map);// pg넘겨서 페이징 처리해서 회원 리스트 가져오기

		// System.out.println("블랙리스트 = "+list);
		ManagerPaging managerPagingBlack = managerMemberService.managerPagingBlack(map);

		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		mav.addObject("managerPagingBlack", managerPagingBlack);
		return mav;
	}

	//changeBlackMemberState 에 대한 변경 컨트롤러 작성하기
	// 활동정지해제~ black-> 일반으로
	@RequestMapping(value = "changeBlackMemberState", method = RequestMethod.POST)
	// check 안에는 id값이 담겨있음.
	public ModelAndView changeBlackMemberState(String[] check,
			@RequestParam(required = false, defaultValue = "1") String pg) {
		System.out.println("check = " + check[0]);
		//managerMemberService.changeBlackMemberState(check); ---> 이거 해결하기~ 
		return new ModelAndView("redirect:/manager/managerMemberBlack");
	}
	
	
	/*------- 차트 구현을 위한 controller --------*/
	@RequestMapping(value = "/getMemberCategory", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getMemberCategory(@RequestParam Map<String, String> map,
		@RequestParam(required = false, defaultValue = "1") String pg) {
		
		List<ManagerMainDTO> list = managerMemberService.getMemberCategory();
		
		System.out.println("차트 카테고리 리스트"+list);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
	}
	//(관리자 확인용 프로필)
	   @RequestMapping(value="/managerMemberHistory", method=RequestMethod.GET)
	   public String managerMemberHistory(Model model,String id,@RequestParam(required = false, defaultValue = "1") String pg) {
	      model.addAttribute("id",id);
	      model.addAttribute("pg",pg);
	      return "/manager/managerMemberHistory";
	   }
	   //(관리자 확인용 프로필_판매완료)
	   @RequestMapping(value="/managerMemberSale", method=RequestMethod.GET)
	   public String managerMemberSale(Model model,String id,@RequestParam(required = false, defaultValue = "1") String pg) {
	      model.addAttribute("id",id);
	      model.addAttribute("pg",pg);
	      return "/manager/managerMemberSale";
	   }
	   //(관리자 확인용 프로필_판매후기)
	   @RequestMapping(value="/managerMemberReview", method=RequestMethod.GET)
	   public String managerMemberReview(Model model,String id,@RequestParam(required = false, defaultValue = "1") String pg) {
	      model.addAttribute("id",id);
	      model.addAttribute("pg",pg);
	      return "/manager/managerMemberReview";
	   }
	   //(관리자 확인용 프로필_구매완료)
	   @RequestMapping(value="/managerMemberBuy", method=RequestMethod.GET)
	   public String managerMemberBuy(Model model,String id,@RequestParam(required = false, defaultValue = "1") String pg) {
	      model.addAttribute("id",id);
	      model.addAttribute("pg",pg);
	      return "/manager/managerMemberBuy";
	   }
	   //(관리자 확인용 프로필_판매중)
	   @RequestMapping(value="/managerMemberDeal", method=RequestMethod.GET)
	   public String managerMemberDeal(Model model,String id,@RequestParam(required = false, defaultValue = "1") String pg) {
	      model.addAttribute("id",id);
	      model.addAttribute("pg",pg);
	      return "/manager/managerMemberDeal";
	   }
	
}
