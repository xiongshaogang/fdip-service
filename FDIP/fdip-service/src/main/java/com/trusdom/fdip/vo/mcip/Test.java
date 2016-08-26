/**
 * 
 */
package com.trusdom.fdip.vo.mcip;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import org.hibernate.validator.internal.util.privilegedactions.GetMethod;

/**
 * @author  zhihuayang E-mail:425273175@qq.com 
 * @date 创建时间：2016年8月9日 上午11:20:31
 * @version 1.0 
 * @parameter  
 * @return  
*/
/**
 * @author lenovo
 *
 */
public class Test {

//	public static  int jie(int i){
//		if(i<=1)
//			return i;
//		else
//			return i*(jie(i-1));
//	}
	public static void main(String[] args) {
//		System.out.println(jie(3));
		Test test=new Test();
		try {
			test.getMethod();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BigDecimal bigDecimal1=new BigDecimal("10.00");
		BigDecimal bigDecimal2=new BigDecimal("10.001");
		System.out.println(bigDecimal1.doubleValue()==bigDecimal2.doubleValue());

	}
	
	public void test1(String name1){
		System.out.println(name1);
		System.out.println("test1");
	}
	public void test2(String name2){
		System.out.println(name2);
		System.out.println("test2");
	}
	
	public  void getMethod() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method method=this.getClass().getDeclaredMethod("test2",String.class);
		method.invoke(this, "haha1");
	}
}
