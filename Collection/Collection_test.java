package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/*
 *���Ͽ��
 *
 *Java���������顢���ϵȶԶ�����ݽ��д洢���ڴ���棩�����Ľṹ
 *	
 *Collection�ӿڣ��������ݣ������˴�ȡһ�����ķ����ļ���
 *	List�ӿڣ���̬���飩��Ԫ�����򡢿��ظ������ݼ���
 *		ArrayList����Ҫʵ���࣬�̲߳���ȫ��Ч�ʸߣ��ײ�ʹ��Object[]��˳�򣩴洢
 *			7.0����ʼ��ֱ�Ӵ�������Ϊ10��ָ�����ȵ����顣
 *			8.0����ʼ������Ϊ{}����û�д�������Ϊ10�����飩������һ�ε�����Ӳ������Ŵ����˳���Ϊ10�����飬���������
 *			Ĭ������Ϊ1.5����new = old+(old>>1)��ͬʱ��ԭ�������е�Ԫ�ط����µ�������
 *		LinkedList���ײ�ʹ��˫��������ʽ���洢
 *		Vector������ʵ���࣬�̰߳�ȫ��Ч�ʵͣ��ײ�ʹ��Object[]�洢
 *	Set�ӿڣ����ϣ���Ԫ�����򣨷�����ԣ��������ظ������ݼ���
 *		HashSet����Ҫʵ���࣬�̲߳���ȫ�����Դ洢null
 *			LinkedHashSet�����԰�����ӵ�˳����������������ͬʱ����ά�����������ã���¼ǰ�����ݣ�
 *			7.0����ʼ��ֱ�Ӵ�������Ϊ16��ָ�����ȵ����顣
 *			8.0����ʼ������Ϊ{}����û�д�������Ϊ10�����飩������һ�ε�����Ӳ������Ŵ����˳���Ϊ16�����飬���������
 *			���Ԫ��ʱ�����ø�Ԫ���������hashCode()�����������ϣֵ��ͨ��ɢ�к���������ڵײ��ŵ�λ�ã��жϴ�λ���Ƿ���Ԫ�أ�����������ʽ���ڵĶ��Ԫ�أ�
 *					��û�У���ӳɹ�	�У��Ƚ���Ԫ�صĹ�ϣֵ����ͬ��ϣֵ����equals�����ж�Ԫ���Ƿ���ͬ������
 *			��ʹ���ʳ���0.75������Ϊԭ����2��
 *		TreeSet�����԰�����Ӷ����ָ�����Խ���������Ȼ���򡢶������򣩣��ײ�ʹ�ú������ƽ����������洢
 *
 **/
public class Collection_test{
	
//Collection
	@Test
	public void test1() {
		Collection col = new ArrayList();
		//add(Object e)���Ԫ��
		col.add("aa");
		col.add(123);//�Զ�װ��
		//size()��ȡ��ӵ�Ԫ�صĸ���
		System.out.println(col.size());
		//addAll(Collection col1)��col1�е�����Ԫ����ӵ���ǰ����
		Collection col1 = new ArrayList();
		col1.add("bb");
		col1.add(456);
		col.addAll(col1);
		System.out.println(col.size());
		//clear()��ռ���Ԫ��
//		col.clear();
		//isEmpty()�жϵ�ǰ�����Ƿ�Ϊ�գ���Ԫ�أ�
		System.out.println(col.isEmpty());
		//contains(Object e)�жϵ�ǰ�������Ƿ����e���ж�ʱ����ö����������equals()����
		System.out.println(col.contains("bb"));
		//containsAll(Collection co2)�ж�col2�е�����Ԫ���Ƿ񶼴����ڵ�ǰ����
		Collection col2 = Arrays.asList(123 , 456);
		System.out.println(col.containsAll(col2));
		//remove(Object e)�ӵ�ǰ������ɾ��eԪ��
//		col.remove(456);
//		System.out.println(col2);
		//removeAll(Collection col3)�ӵ�ǰ������ɾ��col3�е�����Ԫ��
//		Collection col3 = Arrays.asList("aa" , "bb");
//		col.removeAll(col3);
//		System.out.println(col);
		//retainAll(Collection col4)��ȡ��ǰ���Ϻ�col4�Ľ����������ظ���ǰ����
		Collection col4 = Arrays.asList(123 , "aa");
		col.retainAll(col4);
		System.out.println(col);
		//equals(Object e)�Ƚϵ�ǰ�������βζ����Ԫ���Ƿ����
		Collection col5 = new ArrayList();
		col5.add("aa");
		col5.add(123);
		System.out.println(col.equals(col5));
		//hashCode()���ص�ǰ����Ĺ�ϣֵ
		System.out.println(col.hashCode());
		//toArray()����-->����
		Object[] obj = col.toArray();
		for (int i = 0 ; i < obj.length ; i++) {
			System.out.println(obj[i]);
		}
		System.out.println("***************");
		
		
		//iterator()����Iterator�����������ӿڵ�ʵ�������ڱ�������Ԫ��
		Iterator iterator = col.iterator();
		System.out.println(iterator.next());//��ȡһ��Ԫ��
		while(iterator.hasNext()) {//����Ԫ��
			System.out.println(iterator.next());
		}
	}
	@Test	//��������ϰ
	public void test2() {
		String[] str = new String[] {"MM" , "MM" , "MM"};
		//��ʽһ
		for (int i = 0 ; i < str.length ; i++) {
			str[i] = "GG";
		}
		//��ʽ��
		for (String s : str) {
			s = "GG";
		}
		for (int i = 0 ; i < str.length ; i++) {
			System.out.println(str[i]);
		}
	}
		
//List
	@Test
	public void test3() {
		ArrayList list = new ArrayList();
		//add(Object e)��������
		list.add(123);
		list.add(456);
		list.add("abc");
		//add(int index, Object e)��ָ��λ�ò�������
		list.add(1 , "def");
		//addAll(int index, Object e)��ָ��λ�ÿ�ʼ��list1������Ԫ����ӵ���ǰ����
		List<Integer> list1 =Arrays.asList(1,2,3);
		list.addAll(2, list1);
		//indexOf(Object e)���ص�ǰ�������״γ��ָ�Ԫ�ص�����
		System.out.println(list.indexOf(456));
		//lastIndexOf(Object e)���ص�ǰ���������һ�γ��ָ�Ԫ�ص�����
		System.out.println(list.lastIndexOf(456));
		//remove(int index)�Ƴ�ָ��λ�õ�Ԫ�أ������ظ�Ԫ��
		Object obj = list.remove(2);
		System.out.println(obj);
		//set(int index, Object e)����ָ��λ�õ�Ԫ��Ϊe
		list.set(0, "GG");
		//subList(int fromIndex , int toIndex)����ָ��λ��֮���Ԫ���Ӽ���
		List list2 = list.subList(2, 4);
		System.out.println(list2);
		System.out.println(list);
	}
	
//Set
	@Test
	public void test4() {
		//HashSet
		Set set = new HashSet();
		set.add(456);
		set.add(132);
		set.add(798);
		set.add("aa");
		set.add("aa");
		
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("*******************");
		
		//LinkedHashSet
		Set set1 = new LinkedHashSet();
		set1.add(456);
		set1.add(132);
		set1.add(798);
		set1.add("aa");
		set1.add("aa");
		
		Iterator iterator1 = set1.iterator();
		while(iterator1.hasNext()) {
			System.out.println(iterator1.next());
		}
		
		System.out.println("*******************");
		
		//LinkedHashSet����ӵ���������ͬ���ʵ�����ģ�
		Set set2 = new TreeSet();
		set2.add(456);
		set2.add(132);
		set2.add(798);
		set2.add(2);
		set2.add(8);
		set2.add(5);
		
		Iterator iterator2 = set2.iterator();
		while(iterator2.hasNext()) {
			System.out.println(iterator2.next());
		}
	}
	
}
