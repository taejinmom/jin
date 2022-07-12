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
	// 파일 업로드 처리 - 
	@PostMapping(value="/uploadpro")
	public String uploadFile(Model m, UpBoardDTO dto,
			HttpServletRequest request) {
		//System.out.println("sub :"+dto.getSub());
		String img_path ="resources\\imgfile";
		// request를 가지고 이미지의 경로를 받아서 출력 
		String r_path = request.getRealPath("/");
		System.out.println("r_path:"+r_path);
		// 업로드 된 이미지의 이름을 받아서 이미지를 복사
		// 이미지 이름 확인
		String oriFn = dto.getMfile().getOriginalFilename();

		// 이미지 사이즈 및 contentType 확인
		// application/vnd.ms-excel
		// application/pdf
		// text/plain
		// application/haansofthwp
		// image/jpeg
		long size = dto.getMfile().getSize();
		String contentType = dto.getMfile().getContentType();
		System.out.println("oriFn:"+oriFn);
		System.out.println("파일 크기 :"+size);
		System.out.println("파일의 type :"+contentType);
		// 메모리상(임시저장장소)에 파일을 우리가 설정한 경로에 복사 하겠다.
		// 이미지가 저장될 경로 만들기
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(img_path).append("\\");
		path.append(oriFn);
		System.out.println("FullPath :"+path);
		
		// 추상경로 (이미지를 저장할 경로) File 객체로 생성
		File f = new File(path.toString());
		
		//  임시 메모리에 담긴 즉  업로드한 파일의 값 -> File클래스의 경로로 복사 
		try {
			dto.getMfile().transferTo(f);
			// 이미지 이름을 db에 저장하기 위해서 DTO 값을 재설정 
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
