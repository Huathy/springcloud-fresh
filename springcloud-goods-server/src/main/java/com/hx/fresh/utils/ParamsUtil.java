package com.hx.fresh.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 参数处理工具类
 * 1. json格式处理
 * 2. 参数判空
 * 3. 参数大小比较
 * @author Huathy
 * @date 2020年4月5日
 */
public class ParamsUtil {
	public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static Map<String, Object> pageParam(Integer page , Integer rows){
		Map<String, Object> map = new HashMap<>();
		map.put("page", (page-1) * rows);
		map.put("rows", rows);
		return map;
	}
	
	public static Map<String, Object> pageParam(Map<String, Object> map){
		int page = Integer.parseInt(String.valueOf(map.get("page")));
		int rows = Integer.parseInt(String.valueOf(map.get("rows")));
		map.put("page", (page-1) * rows);
		map.put("rows", rows);
		return map;
	}
	
	/**
	 * json数据转为对象
	 * @param jsonData	json格式的数据
	 * @param bean		bean对象
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static <T> T jsonToPojo(String jsonData,Class<T> bean) throws JsonParseException, JsonMappingException, IOException{
		T t = OBJECT_MAPPER.readValue(jsonData, bean);
		return t;
	}
	
	/**
	 * 将json数据转为对象集合
	 * @param jsonData		json格式的字符串
	 * @param beanType		bean对象
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) throws JsonParseException, JsonMappingException, IOException {
		JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
		List<T> list = OBJECT_MAPPER.readValue(jsonData, javaType);
		return list;
	}
	
	/**
	 * json对象转字符串
	 * @param data
	 * @return
	 * @throws JsonProcessingException 
	 */
	public static String objectToJsonStr(Object data) throws JsonProcessingException {
		String string = OBJECT_MAPPER.writeValueAsString(data);
		return string;
	}
	
	/**
	 * 判断字符串是否为空
	 * @param strs
	 * @return
	 */
	public static boolean checkNull(String... strs) {
		if (strs == null || strs.length <= 0) {
			return true;
		} else {
			for (String str : strs) {
				if (str == null || "".equals(str) || "null".equals(str)) {
					return true;
				}
			}
			return false;
		}
	}
	
	/**
	 * 判断对象是否为空，空返回true，否则false
	 * @param strs
	 * @return
	 */
	public static boolean checkNull(Object... strs) {
		if (strs == null || strs.length <= 0) {
			return true;
		} else {
			for (Object str : strs) {
				if (str == null || "".equals( String.valueOf(str) ) ) {
					return true;
				}
			}
			return false;
		}
	}
	
	/**
	 * 判断参数与某个数值的关系
	 * @param contidition	关系  >  <  >=  <=
	 * @param digit		数值
	 * @param nums		参数
	 * @return	
	 * @throws Exception
	 */
	public static boolean checkGreater(String contidition,int digit,Integer... nums) throws Exception{
		for(Integer num : nums){
			if(num == null){
				throw new Exception("包含空参数值！");
			}
			switch(contidition.trim()){
				case ">" : if(num > digit)  return true;
				case ">=" : if(num >= digit)  return true;
				case "<" : if(num < digit)  return true;
				case "<=" : if(num <= digit)  return true;
			}
		}
		return false;
	}
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public static String getTime(){
		return sdf.format(new Date().getTime());
	}
	
	/**
	 * 搜索分词
	 * @param str
	 * @return
	 */
//	@SuppressWarnings("resource")
//	public static List<String> analyzerCnStr(String str) {
//		List<String> list = new ArrayList<String>();
//		try {
//			Analyzer analyzer = new SmartChineseAnalyzer();		//使用中文分词器
//			TokenStream tokenStream = analyzer.tokenStream("field", str);
//			CharTermAttribute term = tokenStream.addAttribute(CharTermAttribute.class);
//			tokenStream.reset();
//			while (tokenStream.incrementToken()) {
//				list.add(term.toString());
//			}
//			tokenStream.end();
//			tokenStream.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
}
//分析器类型				 基本介绍 
//WhitespaceAnalyzer	以空格作为切词标准，不对语汇单元进行其他规范化处理 
//SimpleAnalyzer		以非字母符来分割文本信息，并将语汇单元统一为小写形式，并去掉数字类型的字符 
//StopAnalyzer			该分析器会去除一些常有a,the,an等等，也可以自定义禁用词 
//StandardAnalyzer		Lucene内置的标准分析器，会将语汇单元转成小写形式，并去除停用词及标点符号 
//CJKAnalyzer			能对中，日，韩语言进行分析的分词器，对中文支持效果一般。 
//SmartChineseAnalyzer	对中文支持稍好，但扩展性差 
