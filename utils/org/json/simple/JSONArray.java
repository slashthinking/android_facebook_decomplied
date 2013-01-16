package org.json.simple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JSONArray extends ArrayList
  implements List, JSONAware
{
  private static final long serialVersionUID = 3957988303675231981L;

  public static String a(List paramList)
  {
    if (paramList == null);
    StringBuffer localStringBuffer;
    for (String str = "null"; ; str = localStringBuffer.toString())
    {
      return str;
      int i = 1;
      localStringBuffer = new StringBuffer();
      Iterator localIterator = paramList.iterator();
      localStringBuffer.append('[');
      while (localIterator.hasNext())
      {
        if (i != 0)
          i = 0;
        Object localObject;
        while (true)
        {
          localObject = localIterator.next();
          if (localObject != null)
            break label83;
          localStringBuffer.append("null");
          break;
          localStringBuffer.append(',');
        }
        label83: localStringBuffer.append(JSONValue.a(localObject));
      }
      localStringBuffer.append(']');
    }
  }

  public String a()
  {
    return a(this);
  }

  public String toString()
  {
    return a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     org.json.simple.JSONArray
 * JD-Core Version:    0.6.2
 */