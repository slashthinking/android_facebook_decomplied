package android_src.mms.transaction;

import android.content.Context;
import android.content.Intent;
import java.io.OutputStream;
import org.apache.http.entity.ByteArrayEntity;

public class ProgressCallbackEntity extends ByteArrayEntity
{
  private final Context a;
  private final byte[] b;
  private final long c;

  public ProgressCallbackEntity(Context paramContext, long paramLong, byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
    this.a = paramContext;
    this.b = paramArrayOfByte;
    this.c = paramLong;
  }

  private void a(int paramInt)
  {
    if (this.c > 0L)
    {
      Intent localIntent = new Intent("com.android.mms.PROGRESS_STATUS");
      localIntent.putExtra("progress", paramInt);
      localIntent.putExtra("token", this.c);
      this.a.sendBroadcast(localIntent);
    }
  }

  public void writeTo(OutputStream paramOutputStream)
  {
    if (paramOutputStream == null)
      throw new IllegalArgumentException("Output stream may not be null");
    while (true)
    {
      int i;
      int j;
      try
      {
        a(-1);
        i = this.b.length;
        j = 0;
        break label88;
        paramOutputStream.write(this.b, j, k);
        paramOutputStream.flush();
        int m = k + j;
        a(m * 100 / i);
        j = m;
        break label88;
        a(100);
        return;
      }
      finally
      {
        a(-2);
      }
      label88: if (j >= i)
        continue;
      int k = i - j;
      if (k <= 4096)
        continue;
      k = 4096;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.transaction.ProgressCallbackEntity
 * JD-Core Version:    0.6.0
 */