package JAVA.CommonClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

/*
 * 日期、时间常用类
 * 
 * */
public class Date_test {

	@Test
	public void test1() {
		long time = System.currentTimeMillis();//返回当前时间与1970年1月1日的毫秒时间差（时间戳）
		System.out.println(time);
	}

	@Test
	public void test2() {
		Date date1 = new Date();//java.util.Date
		System.out.println(date1.toString());
		System.out.println(date1.getTime());
		
		java.sql.Date date2 = new java.sql.Date(1563652464651L);//java.sql.Date	数据库中的日起类型的变量
		System.out.println(date2.toString());
		System.out.println(date2.getTime());
		
		//多态转换
		Date date3 = new java.sql.Date(13213212131231L);
		java.sql.Date date4 = (java.sql.Date)date3;
		//时间戳转换
		Date date5 = new Date();
		java.sql.Date date6 = new java.sql.Date(date5.getTime());
		
	}
	
	//SimpDateFormat对Date类的操作
	@Test
	public void test3() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat();//默认构造器
//		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMM.dd GGG hh:mm:ss");	
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");	//用带参的构造器指定方式格式化解析
		
		//格式化：日期-->字符串
		Date date = new Date();
		System.out.println(date);
		String format = sdf.format(date);
		System.out.println(format);
		//解析（字符串必须符合对象的创建格式，否则无法解析）：字符串-->日期
		String str = "19-12-2 下午5:27";
		Date date1 = sdf.parse(str);
		System.out.println(date1);
		
		String format1 = sdf1.format(date);
		System.out.println(format1);
	}
	
	//Calendar类（抽象类）
	@Test
	public void test4() {
		//一：创建其子类GregorianCalendar的对象
		//二：调用静态方法getInstance
		Calendar cal = Calendar.getInstance();
		
		int days = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(days);
		
		cal.set(Calendar.DAY_OF_MONTH, 30);
		days = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(days);
		
		cal.add(Calendar.DAY_OF_MONTH, -1);
		days = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(days);
		
		Date date1 = cal.getTime();
		System.out.println(date1);
		
		Date date2= new Date();
		cal.setTime(date2);
		days = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(days);
	}
	
	//LocalDate,LocalTime,LocalDateTime的使用
	@Test
	public void test5() {
		//now()获取当前日期时间
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ld);
		System.out.println(lt);
		System.out.println(ldt);
		
		//***.of()设置指定的日期时间，无偏移量
		LocalDate ld1 =LocalDate.of(2020, 10, 6);
		
		//get_()获取数据
		//with_()设置数据
		//plus_()现有的数据上加
		//minus_()现有的数据上减
	}
	
}
