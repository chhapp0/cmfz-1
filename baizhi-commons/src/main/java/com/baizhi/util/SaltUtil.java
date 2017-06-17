package com.baizhi.util;

import java.util.Random;

/**
 * 生成随机盐的方法
 * @author Lenovo
 *
 */

public class SaltUtil {
	public static String getSalt(int n){
		String str = "QWERTYUIOP[]';LKJHGFDSAZXCVBNM,./!@#$%^&*()_+=-0987654321";
		//把字符串转为字符数组
		char[] charArray = str.toCharArray();
		//创建随机数
		Random rd = new Random();
		//创建字符拼接对象
		StringBuilder sb = new StringBuilder();
		//随机取字符
		for(int i = 0;i<n;i++ ){
			//将随机取到的字符拼接到字符串中
			sb.append(charArray[rd.nextInt(charArray.length)]);
		}
		
		return sb.toString();
		
	}
}
