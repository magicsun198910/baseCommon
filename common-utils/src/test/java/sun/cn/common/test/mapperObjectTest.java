package sun.cn.common.test;

import org.junit.Test;

import sun.cn.common.model.Combine;
import sun.cn.common.model.TestModel;
import sun.cn.common.model.TestModel2;
import sun.cn.common.utils.JSONUtils;
import sun.cn.common.utils.ObjectConvertUtils;

/**
 * 类别转换测试类
 * @author sunshine
 * @date 2016年8月4日
 * @desc
 */
public class mapperObjectTest{
	
	@Test
	public void test(){
		TestModel tm = new TestModel();
		tm.setAge("12");
		tm.setTime(1470409311L);
		tm.setT(10);
		tm.setK("haha");
		TestModel2 tm2 = new TestModel2();
		tm2.setT(100);
		Combine con = ObjectConvertUtils.mapperObject(Combine.class,tm,tm2);
		System.out.println(JSONUtils.convertToJSONStr(con));
	}
	
}