/**
 * 
 */
package com.trusdom.fdip.vo.cbip;

import java.lang.reflect.Field;

import org.springframework.web.client.RestTemplate;

/**
 * @author  zhihuayang E-mail:425273175@qq.com 
 * @date 创建时间：2016年6月29日 下午4:40:59
 * @version 1.0 
 * @parameter  
 * @return  
*/
/**
 * @author lenovo
 *
 */
public class Test {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				try {
//					Thread.sleep(2000);
//					System.out.println(111111);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}).start();
//		System.out.println(1);
//		CapitalAllocationVo capitalAllocationVo=new CapitalAllocationVo();
//		System.out.println(capitalAllocationVo);
//		IgnoreNull(capitalAllocationVo);
//		System.out.println(capitalAllocationVo);
//		RestTemplate restTemplate=new RestTemplate();
//		String result=restTemplate.getForObject("https://testkxgz.trusdom.com/", String.class);
//		System.out.println(result);
		String test="tets..............11222211";
		System.out.println(String.valueOf(test.hashCode()));
		Test test1=new Test();
		Test test2=test1;
		System.out.println(test2==test1);
	}
	
	public static   void IgnoreNull(Object object) throws IllegalArgumentException, IllegalAccessException{
		Class<?> c =object.getClass();
	for(Field field:c.getDeclaredFields()){
		field.setAccessible(true);
		Class<?> type=field.getType();
//		System.out.println(field.getName());
//		System.out.println(type.getName());
		Object val=field.get(object);
		if(val==null&&type.getName().endsWith("String")){
			field.set(object, "");
		}
		
//		System.out.println(field.get(object));
//		if(type.getName().lastIndexOf("String")!=-1&&c.getDeclaredMethod(name, parameterTypes)==null){
//			
//		}
	}
	}
}
