package sun.cn.common.utils;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 扩展StringUtils
 * 
 * @author sunlingao@58.com
 * @date 2016年4月17日
 * @desc
 */
public final class StringExtendUtils extends StringUtils {

	/**
	 * 首字母大写
	 * 
	 * <pre>
	 * ex:index to Index
	 * </pre>
	 * 
	 * @param str
	 * @return String
	 */
	public static String toUpperCaseFirstOne(String str) {
		if (isEmpty(str)) {
			return null;
		}
		char[] cs = str.toCharArray();
		cs[0] -= 32;
		return new String(cs);
	}

	/**
	 * 利用26+数字个生成随机字母组合
	 * 
	 * @Description:
	 * @return
	 */
	public static String randStr(int maxLength) {
		return RandomStringUtils.randomAlphanumeric(maxLength);
	}

}
