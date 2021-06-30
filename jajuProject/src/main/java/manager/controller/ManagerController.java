package manager.controller;

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

import freeboard.bean.FreeboardCommentDTO;
import freeboard.bean.FreeboardCommentPaging;
import freeboard.bean.FreeboardDTO;
import freeboard.bean.FreeboardPaging;
import manager.service.ManagerService;
import member.bean.MemberDTO;

@Controller
@RequestMapping(value="/manager")
public class ManagerController {
	
	 @Autowired 
	 private ManagerService managerService;
	
	@RequestMapping(value="/managerMember", method=RequestMethod.GET)
	public String loginForm(Model model) {
		model.addAttribute("display", "/manager/managerMember.jsp");
		return "/index";
	}
	
	@RequestMapping(value="/getManagerMember",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getManagerMember(@RequestParam(required = false, defaultValue = "1") String pg) {
		
		List<MemberDTO> list = managerService.getManagerMember(pg);//pg넘겨서 페이징 처리해서 회원 리스트 가져오기 
		//System.out.println("겟메니저맴버= "+list);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		//mav.addObject("managerPaging", managerPaging);
		return mav;
		
	}
	
//---------------------- 게시판 관리	
		@RequestMapping(value="/managerFreeboardList", method=RequestMethod.GET)
		public String managerFreeboardList(Model model) {
			model.addAttribute("display", "/manager/managerFreeboardList.jsp");
			return "/index";
		}
		
		@RequestMapping(value="/getManagerFreeboardList", method=RequestMethod.POST)
		@ResponseBody
		public ModelAndView getManagerFreeboardList(@RequestParam(required=false, defaultValue="1") String pg
													//HttpSession session,
													//HttpServletResponse response
				) {
			
			//1페이지당 
			List<FreeboardDTO> list = managerService.getManagerFreeboardList(pg);
			
			//세션
			//String memId = (String) session.getAttribute("memId");
			
			//페이징 처리
			FreeboardPaging freeboardPaging = managerService.managerfreeboardPaging(pg);
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("pg", pg);
			mav.addObject("list", list);
			//mav.addObject("memId", memId);
			mav.addObject("freeboardPaging", freeboardPaging);
			
			mav.setViewName("jsonView");
			return mav;
			
		}
		
	//뷰
		@RequestMapping(value="/managerFreeboardView", method=RequestMethod.GET)
		public String managerFreeboardView(@RequestParam int board_seq,
											Model model) { //나에게 들어오는 데이터: seq, pg
			//						HttpSession session,
					
					
			//ID 세션 가져오기
			//String memId = (String) session.getAttribute("memId");
			//model.addAttribute("memId", memId);
			model.addAttribute("board_seq", board_seq); //seq를 모델에 넣어줌
					
			model.addAttribute("display","/manager/managerFreeboardView.jsp");
			return "/index";
		}
				
		@RequestMapping(value="/getManagerFreeboardView", method=RequestMethod.POST)
		@ResponseBody
		public ModelAndView getManagerFreeboardView(@RequestParam int board_seq) {
											//HttpSession session,
											//HttpServletResponse response,
											//HttpServletRequest request

//			String memId = (String) session.getAttribute("memId");
		
			ModelAndView mav = new ModelAndView();
					
			FreeboardDTO freeboardDTO = managerService.getManagerFreeboardView(board_seq);
			
			mav.addObject("freeboardDTO", freeboardDTO);
			//mav.addObject("memId", memId);
			mav.setViewName("jsonView");
					
			return mav;
			
				}

	//댓글 가져오기
		@RequestMapping(value="getManagerFreeboardComment", method=RequestMethod.POST)
		@ResponseBody
		public ModelAndView getManagerFreeboardComment(@RequestParam Map<String, String> map) {

			ModelAndView mav = new ModelAndView();
			
			List<FreeboardCommentDTO> list = managerService.getManagerFreeboardComment(map);
			
			FreeboardCommentPaging freeboardCommentPaging = managerService.freeboardCommentPaging(map);
			
			mav.addObject("freeboardCommentPaging", freeboardCommentPaging);
			mav.addObject("list", list);
			mav.setViewName("jsonView");
			
			return mav;
		}
		
		//댓글 1개 불러오기
		@RequestMapping(value="getManagerFreeboardCommentOne", method=RequestMethod.POST)
		@ResponseBody
		public ModelAndView getManagerFreeboardCommentOne(@RequestParam String comment_seq) {

			ModelAndView mav = new ModelAndView();
			
			FreeboardCommentDTO freeboardCommentDTO = managerService.getManagerFreeboardCommentOne(comment_seq);
			
			mav.addObject("freeboardCommentDTO", freeboardCommentDTO);
			mav.setViewName("jsonView");
			
			return mav;
		}
		
	//이전글 다음글
		@RequestMapping(value="getPage", method=RequestMethod.POST)
		@ResponseBody
		public ModelAndView getPage(@RequestParam int board_seq) {
			
			FreeboardDTO freeboardDTO = managerService.getPage(board_seq);
			
			//System.out.println(noticeDTO.getPrev_subject());
			//System.out.println(noticeDTO.getNext_subject());
			ModelAndView mav = new ModelAndView();
			mav.addObject("freeboardDTO", freeboardDTO);
			mav.setViewName("jsonView");
			return mav;
		}

		
		
	//검색
		
	//삭제- 게시물
	
		//삭제-댓글
	

	
}
