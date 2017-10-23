package com.smart.web.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * @author 作者 louys:
 * @version 创建时间：2017年9月13日 上午8:51:45 类说明
 */
@Controller
@RequestMapping(value = { "/upload" })
public class UploadController {
	private Logger logger = Logger.getLogger(UploadController.class);

	@ResponseBody
	@RequestMapping(value = { "/file" })
	public String upload(HttpServletRequest request, HttpServletResponse response) {
		logger.info("Start receiving upload data ...");
		// 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
		String savePath = request.getServletContext().getRealPath("/WEB-INF/upload");
		// 上传时生成的临时文件保存目录
		String tempPath = request.getServletContext().getRealPath("/WEB-INF/temp");
		File tmpFile = new File(tempPath);
		if (!tmpFile.exists()) {
			// 创建临时目录
			tmpFile.mkdir();
		}

		// 消息提示
		String message = "";
		try {
			// 3、判断提交上来的数据是否是上传表单的数据
			if (!ServletFileUpload.isMultipartContent(request)) {
				logger.warn("Upload Data is not MultipartContent!!!");
				// 按照传统方式获取数据
				return "isNotMultipartContent";
			}
			MultipartHttpServletRequest multiReq = (MultipartHttpServletRequest) request;
			List<MultipartFile> files = multiReq.getFiles("file");
			if (files == null || files.isEmpty()) {
				logger.info("上传文件为空！");
				return "上传文件为空！";
			}
			for (MultipartFile item : files) {
				// 获取文件名称
				String name = item.getName();
				String value = item.getOriginalFilename();
				logger.info(name + "=" + value);
				// 得到上传的文件名称，
				String filename = item.getOriginalFilename();
				logger.info("fileName==" + filename);
				if (filename == null || filename.trim().equals("")) {
					continue;
				}
				// 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：
				// c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
				// 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
				filename = filename.substring(filename.lastIndexOf("\\") + 1);
				// 得到上传文件的扩展名
				String fileExtName = filename.substring(filename.lastIndexOf(".") + 1);
				// 如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
				logger.info("上传的文件的扩展名是：" + fileExtName);
				// 获取item中的上传文件的输入流
				InputStream in = item.getInputStream();
				// 得到文件保存的名称
				String saveFilename = makeFileName(filename, fileExtName);
				// 得到文件的保存目录
				String realSavePath = makePath(saveFilename, savePath);
				// 创建一个文件输出流
				FileOutputStream out = new FileOutputStream(realSavePath);
				// 创建一个缓冲区
				byte buffer[] = new byte[1024];
				// 判断输入流中的数据是否已经读完的标识
				int len = 0;
				// 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
				while ((len = in.read(buffer)) > 0) {
					// 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\"
					// + filename)当中
					out.write(buffer, 0, len);
				}
				// 关闭输入流
				in.close();
				// 关闭输出流
				out.close();
				// 删除处理文件上传时生成的临时文件
				// item.delete();
				message = "文件上传成功！";
			}
		} catch (Exception e) {
			logger.error("文件上传失败！", e);
			message = "文件上传失败！";
		}
		request.setAttribute("message", message);
		logger.info("Receiving upload data End ...");
		return "result:" + message;
	}

	private String makePath(String saveFilename, String savePath) {
		return savePath + "/" + saveFilename;
	}

	private String makeFileName(String filename, String fileExtName) {
		return "LYS-" + System.currentTimeMillis() + "." + fileExtName;
	}
}
