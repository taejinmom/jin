package kr.co.kosmo.mvc.controller.upload;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.co.kosmo.mvc.dao.UpBoardDaoInter;
import kr.co.kosmo.mvc.vo.UpBoardDTO;

@Controller
@RequestMapping(value="/upload")
public class UploadDemoController {
	@Autowired
	private UpBoardDaoInter upBoardDaoInter;
	
	@GetMapping(value="/upform")
	public String upform() {
		return "updemo/upform";
	}
	// ���� ���ε� ó�� - 
	@PostMapping(value="/uploadpro")
	public String uploadFile(Model m, UpBoardDTO dto,
			HttpServletRequest request) {
		//System.out.println("sub :"+dto.getSub());
		String img_path ="resources\\imgfile";
		// request�� ������ �̹����� ��θ� �޾Ƽ� ��� 
		String r_path = request.getRealPath("/");
		System.out.println("r_path:"+r_path);
		// ���ε� �� �̹����� �̸��� �޾Ƽ� �̹����� ����
		// �̹��� �̸� Ȯ��
		String oriFn = dto.getMfile().getOriginalFilename();

		// �̹��� ������ �� contentType Ȯ��
		// application/vnd.ms-excel
		// application/pdf
		// text/plain
		// application/haansofthwp
		// image/jpeg
		long size = dto.getMfile().getSize();
		String contentType = dto.getMfile().getContentType();
		System.out.println("oriFn:"+oriFn);
		System.out.println("���� ũ�� :"+size);
		System.out.println("������ type :"+contentType);
		// �޸𸮻�(�ӽ��������)�� ������ �츮�� ������ ��ο� ���� �ϰڴ�.
		// �̹����� ����� ��� �����
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(img_path).append("\\");
		path.append(oriFn);
		System.out.println("FullPath :"+path);
		
		// �߻��� (�̹����� ������ ���) File ��ü�� ����
		File f = new File(path.toString());
		
		//  �ӽ� �޸𸮿� ��� ��  ���ε��� ������ �� -> FileŬ������ ��η� ���� 
		try {
			dto.getMfile().transferTo(f);
			// �̹��� �̸��� db�� �����ϱ� ���ؼ� DTO ���� �缳�� 
			dto.setImgn(oriFn);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		upBoardDaoInter.addUpBoard(dto);
		
		return "redirect:/main";
	}
	@RequestMapping("/upboardList")
	public String upBoardList(Model model,String cPage) {
		//List<UpBoardDTO> list = (List<UpBoardDTO>) upBoardDaoInter.getList(map);
		int totalRecord = upBoardDaoInter.getCnt();
		//model.addAttribute("list", list);
		model.addAttribute("totalRecord", totalRecord);
		
		return  "updemo/upboardList";
	}
}
