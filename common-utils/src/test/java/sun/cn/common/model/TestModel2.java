package sun.cn.common.model;

import java.util.Date;

import sun.cn.common.annotaions.FieldMapper;

public class TestModel2 {
	
	@FieldMapper(isMapper=false)
	private String age1;
	@FieldMapper(isMapper=false)
	private Date time;
	
	private Integer t;

	public Integer getT() {
		return t;
	}

	public void setT(Integer t) {
		this.t = t;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getAge1() {
		return age1;
	}

	public void setAge1(String age1) {
		this.age1 = age1;
	}

}
