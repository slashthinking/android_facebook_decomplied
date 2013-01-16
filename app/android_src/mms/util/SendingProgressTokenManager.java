package android_src.mms.util;

import java.util.HashMap;

public class SendingProgressTokenManager
{
  private static final HashMap<Object, Long> a = new HashMap();

  public static long a(Object paramObject)
  {
    monitorenter;
    try
    {
      Long localLong = (Long)a.get(paramObject);
      if (localLong != null)
      {
        long l2 = localLong.longValue();
        l1 = l2;
        return l1;
      }
      long l1 = -1L;
    }
    finally
    {
      monitorexit;
    }
  }

  public static void b(Object paramObject)
  {
    monitorenter;
    try
    {
      a.remove(paramObject);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.util.SendingProgressTokenManager
 * JD-Core Version:    0.6.0
 */