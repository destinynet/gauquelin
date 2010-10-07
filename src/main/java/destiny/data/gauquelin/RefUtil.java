/**
 * @author smallufo 
 * Created on 2009/3/21 at 上午 12:32:59
 */ 
package destiny.data.gauquelin;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RefUtil
{
  private Object o;
  
  public RefUtil(Object o)
  {
    this.o = o;
  }
  
  @SuppressWarnings("rawtypes")
  public static List<String> getProperties(Class clazz)
  {
    List<String> properties = Collections.synchronizedList(new ArrayList<String>());
    for (Method method : clazz.getDeclaredMethods())
    {
      String methodName = method.getName(); 
      if (methodName.startsWith("get"))
      {
        String first = methodName.substring(3,4);
        String rest = methodName.substring(4);
        String prop = first.toLowerCase() + rest;
        properties.add(prop);
      }
    }
    return properties;
  }
  
  /**
   * 成功則傳回 true , 失敗則 false
   */
  public boolean setValue(String propName , Object value)
  {
    String methodName = "set" + propName.substring(0,1).toUpperCase() + propName.substring(1);
    try
    {
      Method method = o.getClass().getDeclaredMethod(methodName , value.getClass());
      method.invoke(o, value);
      return true;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return false;
    }
  }
  
  public Object getValue(String propName)
  {
    String first = propName.substring(0,1);
    String rest = propName.substring(1);
    String methodName = "get" + first.toUpperCase()+rest;
    //System.out.println(methodName);
    try
    {
      //FIXME : 如果把 null 前面放個 (Class<?>[]) , 就會沒有 warning , 但是 null 可以被 cast 嗎！？
      Method m = o.getClass().getDeclaredMethod(methodName, (Class<?>[]) null);
      //FIXME : 如果把 null 前面放個 (Object[]) , 就會沒有 warning , 但是 null 可以被 cast 嗎？
      Object result = m.invoke(o, (Object[]) null);
      return result;
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return null;
  }

}
