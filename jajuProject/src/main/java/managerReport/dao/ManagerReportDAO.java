package managerReport.dao;

import java.util.List;
import java.util.Map;

import member.bean.MemberDTO;
import report.bean.CommentDTO;
import report.bean.ReportDTO;

public interface ManagerReportDAO {
	
	public List<ReportDTO> getManagerReportList(Map<String, String> map);

	public int getReportTotalA();

	public ReportDTO getReport(String report_seq);
	
	public void getShowList(String sale_seq);
	
	public List<ReportDTO> getReportSearchList(Map<String, String> map);
	
	public int getTotalSearchA(Map<String, String> map);

	public void managerReportDelete(int[] check, int[]sale_check);
	//public void managerReportDelete(String sale_seq, Map<String, String[]> map);
	
	public void commentWriteShow(Map<String, String> map);
	public void commentWriteHide(Map<String, String> map);

	public List<CommentDTO> getCommentList(String report_seq);

	public CommentDTO getComment(String comment_seq);

	public void commentModify(CommentDTO commentDTO);

	public void commentDelete(Map<String, String> map);

}
