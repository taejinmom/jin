package kr.co.kosmo.mvc.controller.upload;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.UpBoardDaoInter;
import kr.co.kosmo.mvc.vo.UpBoardDTO;

@Controller
@RequestMapping("/upload")
public class UploadDemoController {
	
	@Autowired
	private UpBoardDaoInter upBoardDaoInter;
	
	@GetMapping(value = "/upform")
	public String upform() {
		return "updemo/upform";
	}
	
	@PostMapping(value = "/uploadpro")
	public String uploadFile(Model m, UpBoardDTO dto, HttpServletRequest request) {
//		System.out.println("Sub : "+dto.getSub());
		String img_path = "resources\\imgfile";
		// request研 亜走壱 戚耕走税 井稽研 閤焼辞 窒径
		String r_path = request.getRealPath("/");
		System.out.println("r_path : "+r_path);
		// 穣稽球 吉 戚耕走税 戚硯聖 閤焼辞 戚耕走研 差紫
		String oriFn = dto.getMfile().getOriginalFilename();
		
		// 戚耕走 紫戚綜 貢 contentType 溌昔
		long size = dto.getMfile().getSize();
		String contentType = dto.getMfile().getContentType();
		System.out.println("oriFn : "+oriFn);
		System.out.println("督析 滴奄 : "+size);
		System.out.println("contentType : "+contentType);
		
		// 五乞軒雌(績獣煽舌舌社)税 督析聖 酔軒亜 竺舛廃 井稽拭 差紫馬畏陥,,
		// 戚耕走亜 煽舌吃 井稽 幻級奄
		
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(img_path).append("\\");
		path.append(oriFn);
		System.out.println("FullPath : "+path);
		
		// 蓄雌井稽 (戚耕走研 煽舌拝 井稽) File 梓端稽 持失
		File f = new File(path.toString());
		
		// 績獣五乞軒拭 眼延 穣稽球廃 督析税 葵 (dto.getMfile()) -> File 適掘什税 井稽稽 差紫
		try {
			dto.getMfile().transferTo(f);
			// 戚耕走 戚硯聖 DB拭 煽舌馬奄 是背辞 DTO拭 葵聖 仙竺舛
			dto.setImgn(oriFn);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		upBoardDaoInter.addUpBoard(dto);
		
		return "redirect:/main";
	}

	
//	@GetMapping(value = "/uplist")
//	public ModelAndView uploadList(Model m, String cPage) {
//        ModelAndView mav = new ModelAndView();
//        totalRecord = upBoardDaoInter.getCnt();
//        totalPage = (int) Math.ceil(totalRecord / (double) numPerPage);
//        totalBlock = (int) Math.ceil((double) totalPage / pagePerBlock);
//        if (cPage != null) {
//            nowPage = Integer.parseInt(cPage);
//        }
//        beginPerPage = (nowPage - 1) * numPerPage + 1;
//        endPerPage = (beginPerPage - 1) + numPerPage;
//        Map<String, Integer> map = new HashMap<String, Integer>();
//        map.put("begin", beginPerPage);
//        map.put("end", endPerPage);
//        List<UpBoardDTO> list = upBoardDaoInter.getList(map);
////        request.setAttribute("mlist", list);
//        int startPage = (int) ((nowPage - 1) / pagePerBlock) * pagePerBlock + 1;
//        int endPage = startPage + pagePerBlock - 1;
//        if (endPage > totalPage) {
//            endPage = totalPage;
//        }
//        mav.addObject("list", list);
//        mav.setViewName("updemo/uplist");
//        mav.addObject("startPage", startPage);
//        mav.addObject("endPage", endPage);
//        mav.addObject("nowPage", nowPage);
//        mav.addObject("pagePerBlock", pagePerBlock);
//        mav.addObject("totalPage", totalPage);
//		return mav;
//	}
	
	@RequestMapping("/uplist")
	public String upBoardList(Model m, String cPage) {
		System.out.println("ししし");
		int totalRecord = upBoardDaoInter.getCnt();
		System.out.println("ししし");
		m.addAttribute("totalRecord", totalRecord);
		
		return "updemo/uplist";
	}
	
	@GetMapping(value = "/updetail")
	public String upDetail(Model m, int num) {
		upBoardDaoInter.viewCount(num);
		System.out.println("ししし");
		UpBoardDTO dto = upBoardDaoInter.getDetail(num);
		m.addAttribute("uvo", dto);
		return "updemo/updetail";
	}
}
