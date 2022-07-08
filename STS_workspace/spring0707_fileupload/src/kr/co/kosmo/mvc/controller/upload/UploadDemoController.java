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
		// request�� ������ �̹����� ��θ� �޾Ƽ� ���
		String r_path = request.getRealPath("/");
		System.out.println("r_path : "+r_path);
		// ���ε� �� �̹����� �̸��� �޾Ƽ� �̹����� ����
		String oriFn = dto.getMfile().getOriginalFilename();
		
		// �̹��� ������ �� contentType Ȯ��
		long size = dto.getMfile().getSize();
		String contentType = dto.getMfile().getContentType();
		System.out.println("oriFn : "+oriFn);
		System.out.println("���� ũ�� : "+size);
		System.out.println("contentType : "+contentType);
		
		// �޸𸮻�(�ӽ��������)�� ������ �츮�� ������ ��ο� �����ϰڴ�,,
		// �̹����� ����� ��� �����
		
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(img_path).append("\\");
		path.append(oriFn);
		System.out.println("FullPath : "+path);
		
		// �߻��� (�̹����� ������ ���) File ��ü�� ����
		File f = new File(path.toString());
		
		// �ӽø޸𸮿� ��� ���ε��� ������ �� (dto.getMfile()) -> File Ŭ������ ��η� ����
		try {
			dto.getMfile().transferTo(f);
			// �̹��� �̸��� DB�� �����ϱ� ���ؼ� DTO�� ���� �缳��
			dto.setImgn(oriFn);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		upBoardDaoInter.addUpBoard(dto);
		
		return "redirect:/main";
	}
	
    private int nowPage = 1;// ���� ������ ��
    private int nowBlock = 1;// ���� ��
    private int totalRecord = 0;// �� �Խù� ��
    private int numPerPage = 10;// �� �������� ������ �Խù� ��
    private int pagePerBlock = 5;// �� ���� ������ ������ ��
    private int totalPage = 0;// ��ü ������ �� => totalRecord/numPerPage
    private int totalBlock = 0;// ��ü �� ��
    private int beginPerPage = 0;// �� �������� ���� �Խù��� index��
    private int endPerPage = 0;// �� �������� ������ �Խù��� index��
	
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
