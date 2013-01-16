package android_src.mms.transaction;

import android.net.Uri;

public class TransactionState
{
  private Uri a = null;
  private int b = 0;

  public int a()
  {
    monitorenter;
    try
    {
      int i = this.b;
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  void a(int paramInt)
  {
    monitorenter;
    if ((paramInt < 0) && (paramInt > 2))
      try
      {
        throw new IllegalArgumentException("Bad state: " + paramInt);
      }
      finally
      {
        monitorexit;
      }
    this.b = paramInt;
    monitorexit;
  }

  void a(Uri paramUri)
  {
    monitorenter;
    try
    {
      this.a = paramUri;
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

  public Uri b()
  {
    monitorenter;
    try
    {
      Uri localUri = this.a;
      monitorexit;
      return localUri;
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
 * Qualified Name:     android_src.mms.transaction.TransactionState
 * JD-Core Version:    0.6.0
 */