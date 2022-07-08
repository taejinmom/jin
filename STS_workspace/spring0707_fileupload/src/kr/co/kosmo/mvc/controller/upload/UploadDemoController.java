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
		// request를 가지고 이미지의 경로를 받아서 출력
		String r_path = request.getRealPath("/");
		System.out.println("r_path : "+r_path);
		// 업로드 된 이미지의 이름을 받아서 이미지를 복사
		String oriFn = dto.getMfile().getOriginalFilename();
		
		// 이미지 사이즈 및 contentType 확인
		long size = dto.getMfile().getSize();
		String contentType = dto.getMfile().getContentType();
		System.out.println("oriFn : "+oriFn);
		System.out.println("파일 크기 : "+size);
		System.out.println("contentType : "+contentType);
		
		// 메모리상(임시저장장소)의 파일을 우리가 설정한 경로에 복사하겠다,,
		// 이미지가 저장될 경로 만들기
		
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(img_path).append("\\");
		path.append(oriFn);
		System.out.println("FullPath : "+path);
		
		// 추상경로 (이미지를 저장할 경로) File 객체로 생성
		File f = new File(path.toString());
		
		// 임시메모리에 담긴 업로드한 파일의 값 (dto.getMfile()) -> File 클래스의 경로로 복사
		try {
			dto.getMfile().transferTo(f);
			// 이미지 이름을 DB에 저장하기 위해서 DTO에 값을 재설정
			dto.setImgn(oriFn);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		upBoardDaoInter.addUpBoard(dto);
		
		return "redirect:/main";
	}
	
    private int nowPage = 1;// 현재 페이지 값
    private int nowBlock = 1;// 현재 블럭
    private int totalRecord = 0;// 총 게시물 수
    private int numPerPage = 10;// 한 페이지당 보여질 게시물 수
    private int pagePerBlock = 5;// 한 블럭당 보여질 페이지 수
    private int totalPage = 0;// 전체 페이지 수 => totalRecord/numPerPage
    private int totalBlock = 0;// 전체 블럭 수
    private int beginPerPage = 0;// 각 페이지별 시작 게시물의 index값
    private int endPerPage = 0;// 각 페이지별 마지막 게시물의 index값
	
	@GetMapping(value = "/uplist")
	public ModelAndView uploadList(Model m, String cPage) {
        ModelAndView mav = new ModelAndView();
        totalRecord = upBoardDaoInter.getCnt();
        totalPage = (int) Math.ceil(totalRecord / (double) numPerPage);
        totalBlock = (int) Math.ceil((double) totalPage / pagePerBlock);
        if (cPage != null) {
            nowPage = Integer.parseInt(cPage);
        }
        beginPerPage = (nowPage - 1) * numPerPage + 1;
        endPerPage = (beginPerPage - 1) + numPerPage;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("begin", beginPerPage);
        map.put("end", endPerPage);
        List<UpBoardDTO> list = upBoardDaoInter.getList(map);
//        request.setAttribute("mlist", list);
        int startPage = (int) ((nowPage - 1) / pagePerBlock) * pagePerBlock + 1;
        int endPage = startPage + pagePerBlock - 1;
        if (endPage > totalPage) {
            endPage = totalPage;
        }
        mav.addObject("list", list);
        mav.setViewName("updemo/uplist");
        mav.addObject("startPage", startPage);
        mav.addObject("endPage", endPage);
        mav.addObject("nowPage", nowPage);
        mav.addObject("pagePerBlock", pagePerBlock);
        mav.addObject("totalPage", totalPage);
		return mav;
	}
	
	@GetMapping(value = "/updetail")
	public String upDetail(Model m, @RequestParam("num") int num) {
		UpBoardDTO dto = upBoardDaoInter.getDetail(num);
		m.addAttribute("uvo", dto);
		return "updemo/updetail";
	}
}
