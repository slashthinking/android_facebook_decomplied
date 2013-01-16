package com.facebook.katana.util;

import com.facebook.common.json.jsonmirror.JMAutogen;
import com.facebook.common.json.jsonmirror.JMDictDestination;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FqlQueryBuilderUtils
{
  protected Map<Class<? extends JMDictDestination>, Set<String>> a = new HashMap();

  public String a(String paramString1, String paramString2, Set<String> paramSet)
  {
    StringBuffer localStringBuffer = new StringBuffer("SELECT ");
    localStringBuffer.append(StringUtils.a(",", new Object[] { paramSet })).append(" FROM ").append(paramString1).append(" WHERE ").append(paramString2);
    return localStringBuffer.toString();
  }

  public Set<String> a(Class<? extends JMDictDestination> paramClass)
  {
    monitorenter;
    try
    {
      Set localSet = (Set)this.a.get(paramClass);
      if (localSet != null);
      while (true)
      {
        return localSet;
        localSet = JMAutogen.b(paramClass);
        this.a.put(paramClass, localSet);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.FqlQueryBuilderUtils
 * JD-Core Version:    0.6.0
 */