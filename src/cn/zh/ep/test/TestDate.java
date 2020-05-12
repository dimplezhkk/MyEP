
package cn.zh.ep.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 

* @author 作者 郑豪: 

* @version 创建时间：2020年3月7日 下午2:32:31 

* 说明 ：

*/

public class TestDate {
	
	public static void main(String[] args) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date()));
	}

}
