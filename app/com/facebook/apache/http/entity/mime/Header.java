package com.facebook.apache.http.entity.mime;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Header
  implements Iterable<MinimalField>
{
  private final List<MinimalField> a = new LinkedList();
  private final Map<String, List<MinimalField>> b = new HashMap();

  public MinimalField a(String paramString)
  {
    MinimalField localMinimalField;
    if (paramString == null)
      localMinimalField = null;
    while (true)
    {
      return localMinimalField;
      String str = paramString.toLowerCase(Locale.US);
      List localList = (List)this.b.get(str);
      if ((localList != null) && (!localList.isEmpty()))
      {
        localMinimalField = (MinimalField)localList.get(0);
        continue;
      }
      localMinimalField = null;
    }
  }

  public void a(MinimalField paramMinimalField)
  {
    if (paramMinimalField == null);
    while (true)
    {
      return;
      String str = paramMinimalField.a().toLowerCase(Locale.US);
      Object localObject = (List)this.b.get(str);
      if (localObject == null)
      {
        localObject = new LinkedList();
        this.b.put(str, localObject);
      }
      ((List)localObject).add(paramMinimalField);
      this.a.add(paramMinimalField);
    }
  }

  public Iterator<MinimalField> iterator()
  {
    return Collections.unmodifiableList(this.a).iterator();
  }

  public String toString()
  {
    return this.a.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.apache.http.entity.mime.Header
 * JD-Core Version:    0.6.0
 */