package com.pp.auth.utils;

import com.pp.auth.constant.EnumError;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class VoResult<T> implements Serializable {

    private static final long serialVersionUID = 6454850898513635273L;

    /**
     * 处理是否成功
     */
    private boolean success;

    /**
     * 错误代码
     */
    private String code;

    /**
     * 错误提示
     */
    private String message;

    /**
     * 数据
     */
    private T value;

    public static <T> VoResult<T> success() {
        VoResult<T> result = new VoResult<T>();
        result.setSuccess(true);
        result.setValue((T) "success");
        return result;
    }

	public static <T> VoResult<T> success(String message) {
		VoResult<T> result = new VoResult<T>();
		result.setSuccess(true);
		result.setMessage(message);
		return result;
	}

    public static <T> VoResult<T> success(T value) {
        VoResult<T> result = new VoResult<T>();
        result.setValue(value);
        result.setSuccess(true);
        return result;
    }

	public static <T> VoResult<T> failed() {
		VoResult<T> result = new VoResult<T>();
		result.setSuccess(false);
		result.setCode("9999");
		return result;
	}

	public static <T> VoResult<T> failed(T value) {
		VoResult<T> result = new VoResult<T>();
		result.setSuccess(false);
		result.setCode("9999");
		result.setValue(value);
		return result;
	}

    public static <T> VoResult<T> failed(String message) {
        VoResult<T> result = new VoResult<T>();
		result.setSuccess(false);
		result.setCode("9999");
		result.setMessage(message);
        return result;
    }

    public static <T> VoResult<T> error(String code, String message) {
        VoResult<T> result = new VoResult<T>();
		result.setSuccess(false);
		result.setCode(code);
		result.setMessage(message);
        return result;
    }

    public static <T> VoResult<T> error(EnumError error) {
        VoResult<T> result = new VoResult<T>();
		result.setSuccess(false);
		result.setMessage(error.name());
		result.setCode(error.getCode());
        return result;
    }

}
