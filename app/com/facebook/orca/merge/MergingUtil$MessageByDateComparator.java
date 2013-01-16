package com.facebook.orca.merge;

import com.facebook.orca.threads.Message;
import java.util.Comparator;

public class MergingUtil$MessageByDateComparator
  implements Comparator<Message>
{
  private long a(Message paramMessage)
  {
    long l;
    if ((paramMessage.d()) && (paramMessage.e() < paramMessage.c()))
      l = paramMessage.e();
    while (true)
    {
      return l;
      l = paramMessage.c();
    }
  }

  public int a(Message paramMessage1, Message paramMessage2)
  {
    long l1 = a(paramMessage1);
    long l2 = a(paramMessage2);
    int i;
    if (l1 > l2)
      i = -1;
    while (true)
    {
      return i;
      if (l1 < l2)
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.merge.MergingUtil.MessageByDateComparator
 * JD-Core Version:    0.6.0
 */