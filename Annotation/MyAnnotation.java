package Annotation;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.*;


/*
 * 
 *  �Զ���ע�⣺
 * 	����Ϊ@interface,�Զ��̳���java.long.annotation.Annotation�ӿ�
 * 
 * û�г�Ա�����Annotation��Ϊ��ǣ�������Ա������Annotation��ΪԪ����Annotation
 * 		�Զ���ע���������ע�����Ϣ�������̣����䣩��������
 * �ڲ������Ա��ͨ��ʹ��value��ʾ
 * ����ָ����Ա��Ĭ��ֵ��ʹ��default����
 * ����Զ���ע��û�г�Ա��������һ����ʶ���ã����ע���г�Ա����ʹ��ע��ʱ��Ҫָ����Ա��ֵ
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Inherited
public @interface MyAnnotation {
	String value() default "hellow";
//	String value();
}