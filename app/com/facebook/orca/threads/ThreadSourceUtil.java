package com.facebook.orca.threads;

import android.content.res.Resources;

public class ThreadSourceUtil
{
  private final Resources a;

  public ThreadSourceUtil(Resources paramResources)
  {
    this.a = paramResources;
  }

  public int a(String paramString)
  {
    int i;
    if (("mobile".equals(paramString)) || ("messenger".equals(paramString)) || ("sms".equals(paramString)) || ("mms".equals(paramString)))
      i = 2130838714;
    while (true)
    {
      return i;
      if (("chat".equals(paramString)) || ("web".equals(paramString)))
      {
        i = 2130838711;
        continue;
      }
      if ("email".equals(paramString))
      {
        i = 2130838713;
        continue;
      }
      i = -1;
    }
  }

  public String a(Message paramMessage)
  {
    return b(paramMessage.w());
  }

  public String b(String paramString)
  {
    String str;
    if ("mobile".equals(paramString))
      str = this.a.getString(2131362676);
    while (true)
    {
      return str;
      if ("messenger".equals(paramString))
      {
        str = this.a.getString(2131362675);
        continue;
      }
      if ("chat".equals(paramString))
      {
        str = this.a.getString(2131362677);
        continue;
      }
      if ("email".equals(paramString))
      {
        str = this.a.getString(2131362678);
        continue;
      }
      if ("sms".equals(paramString))
      {
        str = this.a.getString(2131362679);
        continue;
      }
      if ("mms".equals(paramString))
      {
        str = this.a.getString(2131362680);
        continue;
      }
      str = this.a.getString(2131362677);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.ThreadSourceUtil
 * JD-Core Version:    0.6.0
 */