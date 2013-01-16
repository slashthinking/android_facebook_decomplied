package com.facebook.orca.entity.mime.content;

import com.facebook.orca.entity.mime.ContentSerializationListener;
import com.google.common.base.Preconditions;

public abstract class ChunkedContentSerializationListener
  implements ContentSerializationListener
{
  private final long a;
  private final long b;
  private long c;

  public ChunkedContentSerializationListener(long paramLong, int paramInt)
  {
    boolean bool2;
    if (paramLong > 0L)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2);
      if (paramInt <= 0)
        break label56;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1);
      this.a = paramLong;
      this.b = (paramLong / paramInt);
      this.c = 0L;
      return;
      bool2 = false;
      break;
      label56: bool1 = false;
    }
  }

  public void a(long paramLong)
  {
    if (paramLong >= 0L);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      if (paramLong >= this.c)
      {
        a(paramLong, this.a);
        this.c = Math.min((paramLong + this.b) / this.b * this.b, this.a);
      }
      return;
    }
  }

  public abstract void a(long paramLong1, long paramLong2);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.entity.mime.content.ChunkedContentSerializationListener
 * JD-Core Version:    0.6.2
 */