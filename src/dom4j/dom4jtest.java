package dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class dom4jtest {
	
	

	public static void main(String args[])
	{
	}
	
	@Test
	public void step1()
	{
		try {
			Document document=new SAXReader().read(dom4jtest.class.getClassLoader().getResourceAsStream("dom4j.xml"));
			Element root =document.getRootElement();
			System.out.println(root);
			 //获取root
			
	          listNodes(root);
	          //遍历
	         
	          try {
				writer(root);
				//XML读取
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			

		} catch (DocumentException e) {
	   e.printStackTrace();
		}
	}
	 @SuppressWarnings("unchecked")
	public void getNodes(Element node){    
         
	      //当前节点的名称、文本内容和属性    
	      node.setText("");  
	      List<Attribute> listAttr=node.attributes();//当前节点的所有属性的list    
	      for(Attribute attr:listAttr){//遍历当前节点的所有属性    
	          attr.setText("");  
	      }    
	      //递归遍历当前节点所有的子节点    
	      List<Element> listElement=node.elements();//所有一级子节点的list    
	      for(Element e:listElement){//遍历所有一级子节点    
	          this.getNodes(e);//递归    
	      }    
	    }    
	  public void writer(Element root) throws Exception {  
	        // 紧凑的格式  
	        // OutputFormat format = OutputFormat.createCompactFormat();  
	        // 排版缩进的格式  
	        OutputFormat format = OutputFormat.createPrettyPrint();  
	        // 设置编码  
	        format.setEncoding("UTF-8");  
	        // 创建XMLWriter对象,指定了写出文件及编码格式    
	        XMLWriter writer = new XMLWriter(new OutputStreamWriter(  
	                new FileOutputStream(new File("src/dom4j2.xml")), "UTF-8"), format);  
	        // 写入  
	        writer.write(root);  
	        // 立即写入  
	        writer.flush();  
	        // 关闭操作  
	        writer.close();  
	    }  
	  @SuppressWarnings("unchecked")
	public void listNodes(Element node) {  
	        System.out.println("当前节点的名称：：" + node.getName());  
	        // 获取当前节点的所有属性节点  
	        List<Attribute> list = node.attributes();  
	        // 遍历属性节点  
	        for (Attribute attr : list) {  
	            System.out.println(attr.getText() + "-----" + attr.getName()  
	                    + "---" + attr.getValue());  
	        }  
	  
	        if (!(node.getTextTrim().equals(""))) {  
	            System.out.println("文本内容：：：：" + node.getText());  
	        }  
	  
	        // 当前节点下面子节点迭代器  
	        Iterator<Element> it = node.elementIterator();  
	        // 遍历  
	        while (it.hasNext()) {  
	            // 获取某个子节点对象  
	            Element e = it.next();  
	            // 对子节点进行遍历  
	            listNodes(e);  
	        }  
	    }  

	  
}