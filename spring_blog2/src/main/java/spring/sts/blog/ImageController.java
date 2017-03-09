package spring.sts.blog;

import java.math.BigDecimal;
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

import spring.model.image.ImageDAO;
import spring.model.image.ImageDTO;
import spring.utility.blog.Utility;

@Controller
public class ImageController {
	
	@Autowired
	private ImageDAO dao;
	
	@RequestMapping(value="/imag/reply",method=RequestMethod.POST)
	public String reply(int no, Model model,HttpServletRequest request,String col, String word, String nowPage, ImageDTO dto){
		
		String upDir = request.getRealPath("/imag/storage");	
	

		int filesize = (int)dto.getFileMF().getSize();
		String filename = "";
		if(filesize>0){
			filename = Utility.saveFile(dto.getFileMF(), upDir);
		}
		
		dto.setFilename(filename);
		
		Map map = new HashMap();
		map.put("gno", dto.getGno());
		map.put("ano", dto.getAno());
		dao.upAno(map);
		
		boolean flag = dao.createReply(dto);
		
		if(flag){
			return "redirect:./list";
		}else{
			
			return "error";
		}

	}
	
	@RequestMapping(value="/imag/reply",method=RequestMethod.GET)
	public String reply(int no, Model model){

		model.addAttribute("dto", dao.readReply(no));
		return "/imag/reply";
	}
	
	@RequestMapping(value="/imag/delete",method=RequestMethod.POST)
	public String delete(int no,HttpServletRequest request,String col, String word, String nowPage,String passwd, String filename,Model model){

		String upDir=request.getRealPath("/imag/storage");

			Map map= new HashMap();
			map.put("no",no);
			map.put("passwd",passwd);
	
			
			boolean pflag=dao.passwd(map);

			
			if(pflag){
				if(dao.delete(no)){
					Utility.deleteFile(upDir, filename);
					model.addAttribute("col", col);
					model.addAttribute("word", word);
					model.addAttribute("nowPage", nowPage);
					
					return "redirect:./list";
				}else{
					return "error";
				}
			}else{
				return "passwdError";
			}
	}
	
	@RequestMapping(value="/imag/delete",method=RequestMethod.GET)
	public String delete(int no,Model model){
		boolean check = dao.checkRefno(no);
		model.addAttribute("flag", check);
		
		return "/imag/delete";
	}
	
	@RequestMapping(value="/imag/update",method=RequestMethod.POST)
	public String update(ImageDTO dto, String oldfile, Model model,String col, String word, String nowPage, HttpServletRequest request){


		String upDir = request.getRealPath("/imag/storage");

		String filename = "";
		int size = (int)dto.getFileMF().getSize();
		if(size>0){
			if(oldfile!=null && !oldfile.equals("member.jpg"))
				Utility.deleteFile(upDir, oldfile);
			filename = Utility.saveFile(dto.getFileMF(), upDir);
		}
		dto.setFilename(filename);
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
	
	@RequestMapping(value="/imag/update",method=RequestMethod.GET)
	public String update(int no, Model model){
		model.addAttribute("dto", dao.read(no));
		return "/imag/update";
	}
	
	@RequestMapping("/imag/read")
	public String read(Model model, int no, String col, String word, String nowPage, HttpServletRequest request) {

	ImageDTO dto = dao.read(no);

	Map map = dao.sumnail(no);
	BigDecimal[] noArr = {((BigDecimal)map.get("PRE_NO2")), 
	((BigDecimal)map.get("PRE_NO1")),
	((BigDecimal)map.get("NO")),
	((BigDecimal)map.get("NEX_NO1")),
	((BigDecimal)map.get("NEX_NO2"))
	};

	String[] files = {
	((String)map.get("PRE_FILE2")),
	((String)map.get("PRE_FILE1")),
	((String)map.get("FILENAME")),
	((String)map.get("NEX_FILE1")),
	((String)map.get("NEX_FILE2"))

	};

	String content = dto.getContent();
	content = content.replaceAll("\r\n", "<br>");

	model.addAttribute("col", col);
	model.addAttribute("word", word);
	model.addAttribute("nowPage", nowPage);
	model.addAttribute("dto", dto);
	model.addAttribute("no", no);
	model.addAttribute("files", files);
	model.addAttribute("noArr", noArr);

	return "/imag/read";
	}
	
	@RequestMapping(value="/imag/create",method=RequestMethod.POST)
	public String create(HttpServletRequest request, ImageDTO dto){
		
		String upDir = request.getRealPath("/imag/storage");
		String filename ="";
		int size = (int)dto.getFileMF().getSize();
		if (size > 0) {
			filename = Utility.saveFile(dto.getFileMF(), upDir);
		} else {
			filename = "image.jpg";
		}
		dto.setFilename(filename);
		
		boolean flag = dao.create(dto);
		if(flag){
			return "redirect:./list";
		}else{
			return "error";
		}
	}
	
	@RequestMapping(value="/imag/create",method=RequestMethod.GET)
	public String create(){
		
		return "/imag/create";
	}
	
	@RequestMapping("/imag/list")
	public String list(HttpServletRequest request){
		
		String col = Utility.checkNull(request.getParameter("col"));
		String word = Utility.checkNull(request.getParameter("word"));
		if(col.equals("total")){
			word="";
		}
		
		int nowPage = 1;
		if(request.getParameter("nowPage")!=null)
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		int recordPerPage = 5;
		
		int sno = ((nowPage-1)*recordPerPage)+1;
		int eno = nowPage * recordPerPage;
		
		Map map = new HashMap();
		map.put("col", col);
		map.put("word", word);
		map.put("sno", sno);
		map.put("eno", eno);
		
		
		int total = dao.total(col, word);
		String paging = Utility.paging3(total, nowPage, recordPerPage, col, word);
		List<ImageDTO> list =dao.list(map);
		Iterator<ImageDTO> iter = list.iterator();
		
	
		request.setAttribute("list",list);
		request.setAttribute("iter",iter);
		request.setAttribute("col",col);
		request.setAttribute("word",word);
		request.setAttribute("nowPage",nowPage);
		request.setAttribute("paging",paging);
		
		return "/imag/list";
	}
}
