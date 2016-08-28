package sun.cn.common.model;

import java.util.Calendar;
import java.util.Date;


import sun.cn.common.annotaions.FieldMapper;

public class TestModel {
	
	@FieldMapper(name = "age1")
	private String age;
	@FieldMapper(mapperCls=Date.class)
	private long time;
	@FieldMapper(mapperCls=Integer.class,isMapper=false)
	private int t;
	@FieldMapper(isMapper=false)
	private String k;
	
	public String getK() {
		return k;
	}

	public void setK(String k) {
		this.k = k;
	}

	public int getT() {
		return t;
	}

	public void setT(int t) {
		this.t = t;
	}

	public Date getTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		return calendar.getTime();
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
