package sun.cn.common.web.controllers;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import sun.cn.common.web.context.ReqRespContext;


/**
 * 请求控制层基础类
 * @author sunshine
 * @date 2016年4月16日
 * @desc
 */
public class BaseController{
	
	@Resource
	private SpringValidatorAdapter vaildate;
	
	@ModelAttribute
	public void initContext(HttpServletRequest request,HttpServletResponse response){
		ReqRespContext.set(request, response);
	}
	
	@SuppressWarnings("unchecked")
	private ModelAndView setParams(ModelAndView mv){
		if(getRequest()!=null && getRequest().getParameterMap()!=null){
			Map<String,Object> params = getRequest().getParameterMap();
			for(String key:params.keySet()){
				Object obj = params.get(key);
				if(obj instanceof String[]){
					mv.addObject(key, StringUtils.join(obj, ","));
				}else{
					mv.addObject(key, obj.toString());
				}
			}
		}
		return mv;
	}
	
	/**
	 * 返回视图
	 * @param name
	 * @return
	 * ModelAndView
	 */
	public ModelAndView view(String name){
		return setParams(new ModelAndView(name));
	}
	
	/**
	 * 获取request
	 * @return
	 * HttpServletRequest
	 */
	public HttpServletRequest getRequest(){
		return ReqRespContext.getReq();
	}
	
	/**
	 * 获取response
	 * @return
	 * HttpServletResponse
	 */
	public HttpServletResponse getResponse(){
		return ReqRespContext.getResp();
	}
	
	/**
	 * 获取int类型参数
	 * @param key key
	 * @param defaultValue 默认值
	 * @return
	 * int
	 */
	public int getIntParameter(String key,int defaultValue){
		Object obj = getRequest().getParameter(key);
		return obj==null?defaultValue:Integer.valueOf(String.valueOf(obj));
	}
	
	/**
	 * 获取String参数
	 * @param key
	 * @param defaultValue
	 * @return
	 * String
	 */
	public String getStringParameter(String key,String defaultValue){
		Object obj = getRequest().getParameter(key);
		return obj==null?defaultValue:String.valueOf(getRequest().getParameter(key));
	}

}
