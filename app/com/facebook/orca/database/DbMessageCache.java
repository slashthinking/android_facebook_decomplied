package com.facebook.orca.database;

import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessagingIdUtil;
import com.google.common.collect.MapMaker;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DbMessageCache
{
  private final Map<String, Message> a = new MapMaker().i().n();

  Message a(String paramString)
  {
    return (Message)this.a.get(paramString);
  }

  public void a()
  {
    this.a.clear();
  }

  void a(Message paramMessage)
  {
    if (paramMessage.v());
    while (true)
    {
      return;
      this.a.put(paramMessage.a(), paramMessage);
    }
  }

  public void b()
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!MessagingIdUtil.i(str)) && (!MessagingIdUtil.h(str)))
        continue;
      localIterator.remove();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.DbMessageCache
 * JD-Core Version:    0.6.0
 */