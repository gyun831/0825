package com.gms.web.domain;

import lombok.Data;

@Data
public class StudentBean {
	private String no,id,name,pw,ssn,regdate,phone,email,title;

	@Override
	public String toString() {
		return "StudentBean [num=" + no + ", id=" + id + ", name=" + name + ", ssn=" + ssn + ", regdate=" + regdate
				+ ", phone=" + phone + ", email=" + email + ", title=" + title + "]";
	}
}
