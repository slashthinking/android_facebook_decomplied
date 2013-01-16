package com.facebook.orca.common.http;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieIdentityComparator;

public class OrcaCookieStore
  implements CookieStore
{
  private final ArrayList<Cookie> a = new ArrayList();
  private final Comparator<Cookie> b = new CookieIdentityComparator();

  public void addCookie(Cookie paramCookie)
  {
    if (paramCookie != null);
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
        if (this.b.compare(paramCookie, localIterator.next()) == 0)
          localIterator.remove();
      if (!paramCookie.isExpired(new Date()))
        this.a.add(paramCookie);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void clear()
  {
    try
    {
      this.a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean clearExpired(Date paramDate)
  {
    boolean bool1 = false;
    if (paramDate == null);
    while (true)
    {
      return bool1;
      try
      {
        Iterator localIterator = this.a.iterator();
        boolean bool2 = false;
        while (localIterator.hasNext())
          if (((Cookie)localIterator.next()).isExpired(paramDate))
          {
            localIterator.remove();
            bool2 = true;
          }
        bool1 = bool2;
      }
      finally
      {
      }
    }
  }

  public List<Cookie> getCookies()
  {
    try
    {
      List localList = Collections.unmodifiableList(this.a);
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String toString()
  {
    return this.a.toString();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.OrcaCookieStore
 * JD-Core Version:    0.6.2
 */