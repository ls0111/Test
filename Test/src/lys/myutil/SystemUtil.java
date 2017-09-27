package lys.myutil;

public class SystemUtil {
	/**
	 * 获取指定类文件的目录(包括文件名)
	 * @param clazz
	 * @return
	 */
	public static <T> String getFileCatalog(Class<T> clazz) {
		return System.getProperty("user.dir") + "\\src\\" + clazz.getName().replace(".", "\\") + ".java";
	}
	
	/**
	 * 获取指定类文件的目录
	 * @param clazz
	 * @return
	 */
	public static <T> String getCurrentCatalog(Class<T> clazz) {
		return System.getProperty("user.dir") + "\\src\\" + clazz.getPackage().getName().replace(".", "\\");
	}
	
	/**
	 * 获取clazz的当前目录，level为0就指当前目录，1为上一级目录，2，为上两级目录。<br>
	 * @param clazz
	 * @param level
	 * @return
	 */
	public static <T> String getRelativeCatalog(Class<T> clazz,int level){
		if(null == clazz){
			return "";
		}
		String path = getCurrentCatalog(clazz);
		StringBuffer sb = new StringBuffer();
		if(StringUtil.isNotBlank(path)){
			String[] arr = path.split("\\\\");
			if(arr.length<=1 || arr.length<=level){
				return arr[0];
			}
			for(int i=0;i<arr.length-level;i++){
				sb.append(arr[i]).append("/");
			}
		}
		return sb.toString();
	}
}
