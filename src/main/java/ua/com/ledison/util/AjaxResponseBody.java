package ua.com.ledison.util;

import ua.com.ledison.entity.User;

public class AjaxResponseBody {

	private String msg;
	private String code;
	private User result;

	public AjaxResponseBody() {
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public User getResult() {
		return result;
	}

	public void setResult(User result) {
		this.result = result;
	}
}
