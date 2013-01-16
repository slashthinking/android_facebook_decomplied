package com.jayway.jsonpath;

import java.util.LinkedList;
import java.util.List;

public class PathUtil
{
  public static List<String> a(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    if (!paramString.startsWith("$."))
      paramString = "$." + paramString;
    String[] arrayOfString = paramString.replace("..", ".~.").replace("[", ".[").replace("@.", "@").replace("['", "").replace("']", "").split("\\.");
    int i = 0;
    if (i < arrayOfString.length)
    {
      if (arrayOfString[i].trim().length() == 0);
      while (true)
      {
        i++;
        break;
        localLinkedList.add(arrayOfString[i].replace("@", "@.").replace("~", ".."));
      }
    }
    return localLinkedList;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.jayway.jsonpath.PathUtil
 * JD-Core Version:    0.6.0
 */