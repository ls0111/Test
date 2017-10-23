package com.smart.web.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 作者 louys:
 * @version 创建时间：2017年9月13日 上午8:51:45 类说明
 */
@Controller
@RequestMapping(value = { "/download" })
public class DownloadController {
	private Logger logger = Logger.getLogger(DownloadController.class);

	@RequestMapping(value = { "/queryAll" })
	public String downFileList(HttpServletRequest request, Model model) {
		String url = request.getServletContext().getRealPath("/WEB-INF/upload");
		logger.info("下载路径：" + url);
		File dir = new File(url);
		File[] fileList = dir.listFiles();
		if (null != fileList && fileList.length > 0) {
			List<String> list = new ArrayList<String>();
			for (File f : fileList) {
				list.add(f.getName());
			}
			model.addAttribute("list", list);
		} else {
			model.addAttribute("error", "没有文件可供下载");
		}
		return "downFileList";
	}

	@RequestMapping(value = { "/file" })
	public String downLoad(HttpServletRequest request, HttpServletResponse response, String fileName, Model model) {
		logger.info("将要下载的文件：" + fileName);
		// 上传的文件都是保存在/WEB-INF/upload目录下的子目录当中
		try {
			String path = request.getServletContext().getRealPath("/WEB-INF/upload");
			// 得到要下载的文件
			File file = new File(path + "\\" + fileName);
			// 如果文件不存在
			if (!file.exists()) {
				model.addAttribute("error", "您要下载的资源已被删除！！");
				return "downFileList";
			}
			// 处理文件名
			String realname = fileName.substring(fileName.indexOf("_") + 1);
			// 设置响应头，控制浏览器下载该文件
			response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
			// 读取要下载的文件，保存到文件输入流
			FileInputStream in = new FileInputStream(path + "\\" + fileName);
			// 创建输出流
			OutputStream out = response.getOutputStream();
			// 创建缓冲区
			byte buffer[] = new byte[1024];
			int len = 0;
			// 循环将输入流中的内容读取到缓冲区当中
			while ((len = in.read(buffer)) > 0) {
				// 输出缓冲区的内容到浏览器，实现文件下载
				out.write(buffer, 0, len);
			}
			// 关闭文件输入流
			in.close();
			// 关闭输出流
			out.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			model.addAttribute("error", "下载出错！不支持的编码格式！");
			return "downFileList";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			model.addAttribute("error", "下载出错！文件已被删除！");
			return "downFileList";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("error", "下载出错！");
			return "downFileList";
		}
		return "downFileList";
	}
}
