
package cn.zh.ep.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 

* @author ���� ֣��: 

* @version ����ʱ�䣺2020��3��7�� ����2:32:31 

* ˵�� ��

*/

public class TestDate {
	
	public static void main(String[] args) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//�������ڸ�ʽ
		System.out.println(df.format(new Date()));
	}

}
