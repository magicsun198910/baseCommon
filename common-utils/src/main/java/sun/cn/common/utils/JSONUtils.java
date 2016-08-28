package sun.cn.common.utils;

import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * jackson解析
 * 
 * @author sunlingao@58.com
 * @date 2016年4月17日
 * @desc
 */
public class JSONUtils {
	
	private final static Logger logger = LoggerFactory.getLogger(JSONUtils.class);
	private static ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static String convertToJSONStr(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			logger.error("convertToJSONStr", e);
			return "";
		}
	}

	public static <T> T convertToObject(String value, Class<T> cla) {
		try {
			return mapper.readValue(value, cla);
		} catch (Exception e) {
			logger.error("convertToObject", e);
			return null;
		}
	}

	public static ObjectNode createObjectNode() {
		return mapper.createObjectNode();
	}

	public static ArrayNode createArrayNode() {
		return mapper.createArrayNode();
	}

	public static ObjectMapper getMapper() {
		return mapper;
	}

}
