package edu.poly.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;

public class UploadUtils {
	//processUploadField cho phép lấy thông tin trg đc uplaod và ktra
	public static String processUploadField(String fieldName,HttpServletRequest request,
		String storedFolder, String storedFieldName) throws IOException, ServletException {
		Part filePart=request.getPart(fieldName);
		//Nếu có dL đc upload thi tiếp tục thực hiện
		if(filePart == null || filePart.getSize()==0) {
			return "";
		}
		//storedFolder != null giữ nguyên gtri
		//ngc lại lấy tên file + phàn mở rộng của file đc upload tới server
		// ->> Tạo ra nội dung của file cuối cùng
		if(storedFieldName==null) {
			storedFieldName=Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		}else {
			storedFieldName += "." + FilenameUtils.getExtension(Paths.get(filePart.getSubmittedFileName()).toString());
		}
		//Lấy đường dẫn thực tế của hư mục lưu trữ (storedFolder)
		String uploadFolder=request.getServletContext().getRealPath(storedFolder);
		Path uploadPart=Paths.get(uploadFolder);
		if(! Files.exists(uploadPart)) {
			Files.createDirectories(uploadPart);
		}
		//ghi nội dung ra thư mục upload Part
		filePart.write(Paths.get(uploadPart.toString(),storedFieldName).toString());
		
		
		return storedFieldName;
	}
}
