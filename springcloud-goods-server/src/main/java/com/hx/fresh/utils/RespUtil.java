package com.hx.fresh.utils;

import java.util.HashMap;
import java.util.Map;

public class RespUtil {
	public static Map<String,Object> respMap(int code,Object msg,Object data) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("msg", msg);
		map.put("data", data);
		return map;
	}
	
}
