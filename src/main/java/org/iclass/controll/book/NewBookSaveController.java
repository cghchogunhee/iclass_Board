package org.iclass.controll.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.iclass.dao.NewBooksDao;
import org.iclass.vo.NewBooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class NewBookSaveController implements Controller {
	private static final Logger logger = LoggerFactory.getLogger(NewBookSaveController.class); 
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서버에 전송될 위치(파일시스템 경로)
		String path ="D:\\iclass_1020\\upload";
		
		//업로드 가능한 파일 크기
		int maxSize = 10 * 1024 * 1024; //최대 업로드될 파일의 크기10Mb, 1024바이트=1KB
		
		//requset를 파일을 받을 수 있는 requset 사용 : cos 라이브러리 추가
		MultipartRequest multiRequset = new MultipartRequest(request, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		//new DefaultFileRenamePolicy()는 중복된 파일명에 대해 새로 파일명을 부여하는 규칙(파일명 뒤에 일련번호)
		
		//기존 방식처럼 text 타입 등 파라미터 받아오기
		String title = multiRequset.getParameter("title");
		String summary = multiRequset.getParameter("summary");

		//서버로 업로드된 파일의 파일명
		String cover = multiRequset.getFilesystemName("coverfile");
		
		logger.info("::: 파일명-{}, 책제목-{}, 내용-{}:::",cover,title,summary);
		
		//dao의 insert 실행
		NewBooksDao dao = NewBooksDao.getInstance();
		String url = null;
		String userId = request.getParameter("userid");
		NewBooks book = new NewBooks(0, title, summary, null, cover, "admin"); 
		if(dao.insert(book)==1) {
			url="list";
		}else {
			url="new";
		}
		
		
		response.sendRedirect(url);
	}

}
