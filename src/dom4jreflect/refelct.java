package dom4jreflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import dom4j.dom4jtest;
				
public class refelct {			
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
					public void jiexi() throws NoSuchMethodException, SecurityException
					{
						{
							Document document = null;
							try {
								document = new SAXReader().read(dom4jtest.class.getClassLoader().getResourceAsStream("reflect.xml"));
								Element root =document.getRootElement();
								Element servlet = root.element("servlet");
								String personclasss=servlet.elementText("servlet-class");
								Class test=Class.forName(personclasss);
								Object object=test.newInstance();
								Method method=test.getMethod("eat", null);
								method.invoke(object, null);
								//反射执行方法
							} catch (DocumentException | ClassNotFoundException e) {
							
								e.printStackTrace();
							} catch (InstantiationException e) {
								
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								
								e.printStackTrace();
							} catch (IllegalArgumentException e) {
								
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								
								e.printStackTrace();
							}
							
							
						}	
					}
				}
