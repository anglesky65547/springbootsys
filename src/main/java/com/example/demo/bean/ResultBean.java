package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一返回数据类型ResultBean
 * @author Administrator
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultBean implements Serializable{
	private static final long serialVersionUID = -5559432799894942205L;
	private Integer code;//编号：200成功，其他失败
	private String message;//消息：成功或错误的信息
	private boolean success;//成功与否的标志
	private Object data;//后端返回给前端的页面数据

	public ResultBean(Integer code, String message, boolean success) {
		this.code = code;
		this.message = message;
		this.success = success;
	}
}
