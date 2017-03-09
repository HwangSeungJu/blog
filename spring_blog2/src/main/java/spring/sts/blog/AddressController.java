package spring.sts.blog;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.address.AddressDAO;
import spring.model.address.AddressDTO;
import spring.utility.blog.Utility;

@Controller
public class AddressController {
	
	@Autowired
	private AddressDAO dao;
	
	@RequestMapping(value="/address/delete",method=RequestMethod.POST)
	public String delete(int no,String col, String word, String nowPage, Model model){
		
		boolean flag = dao.delete(no);
		if(flag){
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("col", col);
			model.addAttribute("word", word);
			return "redirect:./list";
		}else{
			return "error";
		}
	}
	
	@RequestMapping(value="/address/delete",method=RequestMethod.GET)
	public String delete(int no, Model model){
		model.addAttribute("flag", dao.delete(no));
		return "/address/delete";
	}
	
	@RequestMapping(value="/address/update", method=RequestMethod.POST)
	public String update(AddressDTO dto, String col, String word, String nowPage, Model model){
		boolean flag = dao.update(dto);
		if(flag){
			model.addAttribute("col", col);
			model.addAttribute("word", word);
			model.addAttribute("nowPage", nowPage);
			return "redirect:./list";
		}else{
			return "error";
		}
	}
	
	@RequestMapping(value="/address/update", method=RequestMethod.GET)
	public String update(int no, Model model){
		model.addAttribute("dto", dao.read(no));
		return "/address/update";
	}
	
	
	@RequestMapping("/address/read")
	public String read(int no, Model model){
		AddressDTO dto = dao.read(no);
		
		model.addAttribute("dto", dto);
		
		return "/address/read";
	}
	
	@RequestMapping(value="/address/create", method=RequestMethod.POST)
	public String create(AddressDTO dto){
		boolean flag = dao.create(dto);
		
		if(flag){
			return "redirect:./list";
		}else{
			return "error";
		}
	}
	
	@RequestMapping(value="/address/create", method=RequestMethod.GET)
	public String create(){
		
		return "/address/create";
	}
	
	
	@RequestMapping("/address/list")
	public String list(HttpServletRequest request){
		
		String col = Utility.checkNull(request.getParameter("col"));
		String word = Utility.checkNull(request.getParameter("word"));

		if(col.equals("total")){
			word = "";
		}
		//---- 페이지 관련-----------
		int nowPage = 1; //현재 보고있는 페이지
		if(request.getParameter("nowPage")!=null){
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}
		int recordPerPage = 5;// 한페이지당 보여줄 레코드 갯수

		//DB에서 가져올 순번--------------------
		int sno = ((nowPage-1)*recordPerPage)+1;
		int eno = nowPage * recordPerPage;

		Map map = new HashMap();
		map.put("col", col);
		map.put("word", word);
		map.put("sno",sno);
		map.put("eno",eno);


		int total = dao.total(col,word);

		List<AddressDTO> list = dao.list(map);
		Iterator<AddressDTO> iter = list.iterator();
		
		String paging = Utility.paging3(total, nowPage, recordPerPage, col, word);
		
		request.setAttribute("list", list);
		request.setAttribute("col", col);
		request.setAttribute("word", word);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("paging", paging);
		
		return "/address/list";
	}

}
