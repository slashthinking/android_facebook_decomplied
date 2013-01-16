package android_src.mms.transaction;

import android.content.Context;

public class DefaultRetryScheme extends AbstractRetryScheme
{
  private static final int[] b = { 0, 60000, 300000, 600000, 1800000 };

  public DefaultRetryScheme(Context paramContext, int paramInt)
  {
    super(paramInt);
    int i;
    if (this.a < 0)
    {
      i = 0;
      this.a = i;
      if (this.a < b.length)
        break label53;
    }
    label53: for (int j = -1 + b.length; ; j = this.a)
    {
      this.a = j;
      return;
      i = this.a;
      break;
    }
  }

  public int a()
  {
    return b.length;
  }

  public long b()
  {
    return b[this.a];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.transaction.DefaultRetryScheme
 * JD-Core Version:    0.6.0
 */