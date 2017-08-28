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
}
