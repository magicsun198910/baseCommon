package sun.cn.common.web.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 上下文共享池
 * 
 * @author sunshine
 * @date 2016年4月16日
 * @desc
 */
public class ReqRespContext {

	private final static ThreadLocal<HttpServletRequest> requestLocal = new ThreadLocal<HttpServletRequest>();

	private final static ThreadLocal<HttpServletResponse> responseLocal = new ThreadLocal<HttpServletResponse>();

	private ReqRespContext() {
	}

	public static void set(HttpServletRequest request,
			HttpServletResponse response) {
		requestLocal.set(request);
		responseLocal.set(response);
	}

	public static void setReq(HttpServletRequest value) {
		requestLocal.set(value);
	}

	public static HttpServletRequest getReq() {
		try {
			HttpServletRequest request = requestLocal.get();
			return request;
		} catch (Exception e) {
			return null;
		} finally {
			requestLocal.remove();
		}
	}

	public static void setResp(HttpServletResponse value) {
		responseLocal.set(value);
	}

	public static HttpServletResponse getResp() {
		try {
			HttpServletResponse response = responseLocal.get();
			return response;
		} catch (Exception e) {
			return null;
		} finally {
			responseLocal.remove();
		}
	}
}
