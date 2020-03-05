package JAVA.Annotation;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.*;


/*
 * 
 *  自定义注解：
 * 	声明为@interface,自动继承了java.long.annotation.Annotation接口
 * 
 * 没有成员定义的Annotation称为标记，包含成员变量的Annotation称为元数据Annotation
 * 		自定义注解必须配上注解的信息处理流程（反射）才有意义
 * 内部定义成员，通常使用value表示
 * 可以指定成员的默认值，使用default定义
 * 如果自定义注解没有成员，表明是一个标识作用；如果注解有成员，在使用注解时，要指明成员的值
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Inherited
public @interface MyAnnotation {
	String value() default "hellow";
//	String value();
}