package com.zhys.dispatch.dispatch_common.constant;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 系统级错误代码类（包括业务逻辑错误）
 * 
 * 使用过程中可根据需要扩展
 * 
 * @author peak.edge
 *
 */

public class ERRORCODE {
	
	private final static Logger logger = LoggerFactory.getLogger(ERRORCODE.class);
	private final static String SUFFIX="_MSG";

	public static final String ERR_DB_001 = "ERR_DB_001";
	public static final String ERR_BU_001 = "ERR_BU_001";
	
	public static final String ERR_SER_01 = "ERR_SER_01";
	
	public static final String ERR_IO_01 = "ERR_IO_01";
	
	public static final String ERR_PR_01 = "ERR_PR_01";
	
	public static final String ERR_CD_01 = "ERR_CD_01";
	
	public static final String ERR_FLOW_01 = "ERR_FLOW_01";
	
	public static final String ERR_DB_001_MSG = "sql执行错误";
	public static final String ERR_SER_01_MSG = "序列化错误";	
	public static final String ERR_IO_01_MSG = "I/O错误";
	public static final String ERR_PR_01_MSG = "获取系统properties文件参数错误";
	
	public static final String ERR_FLOW_01_MSG = "流程执行错误";
	
	/**
	 * 根据错误编码，获取错误信息
	 * 
	 * @param errorCode
	 * @return
	 */
	public static String getMsg(String errorCode) {
		Class<ERRORCODE> clazz = ERRORCODE.class;
		try {
			Field field = clazz.getDeclaredField(errorCode+SUFFIX);
			return field.get(clazz).toString();
		} catch (Exception e) {
			logger.error(errorCode + ":信息不存在");
		}

		return "";
	}
	
	public static void main(String[] args){
		System.out.println(getMsg("ERR_DB_001"));
	}
}
