package CommonClass.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

/*
 * ���ڡ�ʱ�䳣����
 * 
 * */
public class Date_test {

	@Test
	public void test1() {
		long time = System.currentTimeMillis();//���ص�ǰʱ����1970��1��1�յĺ���ʱ��ʱ�����
		System.out.println(time);
	}

	@Test
	public void test2() {
		Date date1 = new Date();//java.util.Date
		System.out.println(date1.toString());
		System.out.println(date1.getTime());
		
		java.sql.Date date2 = new java.sql.Date(1563652464651L);//java.sql.Date	���ݿ��е��������͵ı���
		System.out.println(date2.toString());
		System.out.println(date2.getTime());
		
		//��̬ת��
		Date date3 = new java.sql.Date(13213212131231L);
		java.sql.Date date4 = (java.sql.Date)date3;
		//ʱ���ת��
		Date date5 = new Date();
		java.sql.Date date6 = new java.sql.Date(date5.getTime());
		
	}
	
	//SimpDateFormat��Date��Ĳ���
	@Test
	public void test3() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat();//Ĭ�Ϲ�����
//		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMM.dd GGG hh:mm:ss");	
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");	//�ô��εĹ�����ָ����ʽ��ʽ������
		
		//��ʽ��������-->�ַ���
		Date date = new Date();
		System.out.println(date);
		String format = sdf.format(date);
		System.out.println(format);
		//�������ַ���������϶���Ĵ�����ʽ�������޷����������ַ���-->����
		String str = "19-12-2 ����5:27";
		Date date1 = sdf.parse(str);
		System.out.println(date1);
		
		String format1 = sdf1.format(date);
		System.out.println(format1);
	}
	
	//Calendar�ࣨ�����ࣩ
	@Test
	public void test4() {
		//һ������������GregorianCalendar�Ķ���
		//�������þ�̬����getInstance
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
	
	//LocalDate,LocalTime,LocalDateTime��ʹ��
	@Test
	public void test5() {
		//now()��ȡ��ǰ����ʱ��
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ld);
		System.out.println(lt);
		System.out.println(ldt);
		
		//***.of()����ָ��������ʱ�䣬��ƫ����
		LocalDate ld1 =LocalDate.of(2020, 10, 6);
		
		//get_()��ȡ����
		//with_()��������
		//plus_()���е������ϼ�
		//minus_()���е������ϼ�
	}
	
}
