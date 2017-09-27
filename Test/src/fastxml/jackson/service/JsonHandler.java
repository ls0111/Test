package fastxml.jackson.service;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fastxml.jackson.bean.User;
import lys.myutil.SystemUtil;

/**
* @author 作者 louys:
* @version 创建时间：2017年9月26日 下午3:34:49
* 类说明
*/
public class JsonHandler {
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static void main(String[] args) {
		String rootPath = SystemUtil.getRelativeCatalog(JsonHandler.class, 1);
		File file = new File(rootPath+"/resource/user.json");
		User user = new User();
		user.setAddress("西安");
		user.setEmail("549014291@qq.com");
		user.setGender("男");
		user.setPassword("123456");
		user.setTelephone("13571231350");
		user.setUserName("lys");
		try {
//			writeJsonString(file,user);
			System.out.println(readJsonString(file, User.class));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 把对象obj以json的形式写入file文件
	 * @param file
	 * @param obj
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static void writeJsonString(File file,Object obj) throws JsonGenerationException, JsonMappingException, IOException{
		mapper.writeValue(file, obj);
	}
	
	/**
	 * 从文件file以json格式读取为clazz的对象
	 * @param file
	 * @param obj
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> T readJsonString(File file,Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(file, clazz);
	}
}
