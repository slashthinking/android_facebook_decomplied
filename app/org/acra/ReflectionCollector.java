package org.acra;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionCollector
{
  public static String collectConstants(Class<? extends Object> paramClass)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Field[] arrayOfField = paramClass.getFields();
    int i = arrayOfField.length;
    int j = 0;
    while (true)
      if (j < i)
      {
        Field localField = arrayOfField[j];
        localStringBuilder.append(localField.getName()).append("=");
        try
        {
          localStringBuilder.append(localField.get(null).toString());
          localStringBuilder.append("\n");
          j++;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          while (true)
            localStringBuilder.append("N/A");
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          while (true)
            localStringBuilder.append("N/A");
        }
      }
    return localStringBuilder.toString();
  }

  public static String collectStaticGettersResults(Class<? extends Object> paramClass)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Method[] arrayOfMethod = paramClass.getMethods();
    int i = arrayOfMethod.length;
    int j = 0;
    while (true)
    {
      Method localMethod;
      if (j < i)
      {
        localMethod = arrayOfMethod[j];
        if ((localMethod.getParameterTypes().length != 0) || ((!localMethod.getName().startsWith("get")) && (!localMethod.getName().startsWith("is"))) || (localMethod.getName().equals("getClass")));
      }
      try
      {
        localStringBuilder.append(localMethod.getName()).append('=').append(localMethod.invoke(null, (Object[])null)).append("\n");
        label112: j++;
        continue;
        return localStringBuilder.toString();
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        break label112;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        break label112;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        break label112;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.ReflectionCollector
 * JD-Core Version:    0.6.0
 */