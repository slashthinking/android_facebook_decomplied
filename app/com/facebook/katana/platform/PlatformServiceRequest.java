package com.facebook.katana.platform;

import android.os.Bundle;
import android.os.Message;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.util.List;

public abstract class PlatformServiceRequest
{
  private String a;
  private int b;
  private int c;
  private Message d;

  protected abstract int a();

  protected void a(Message paramMessage, String paramString, Class<?> paramClass, Object paramObject)
  {
    if (paramObject == null)
      a(paramMessage, "Expected non-null '%s' extra, actual value was null.", new Object[] { paramString });
    while (true)
    {
      return;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = paramClass.getSimpleName();
      arrayOfObject[2] = paramObject.getClass().getSimpleName();
      a(paramMessage, "Expected '%s' extra to be type '%s', actual value was type '%s'.", arrayOfObject);
    }
  }

  protected void a(Message paramMessage, String paramString, Object[] paramArrayOfObject)
  {
    String str = StringLocaleUtil.a(paramString, paramArrayOfObject);
    Bundle localBundle = new Bundle();
    localBundle.putString("com.facebook.platform.status.ERROR_TYPE", "ProtocolError");
    localBundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", str);
    Message localMessage = Message.obtain(null, a());
    localMessage.arg1 = 20121101;
    localMessage.arg2 = paramMessage.arg2;
    localMessage.setData(localBundle);
    c(localMessage);
  }

  protected abstract boolean a(Message paramMessage);

  public final String b()
  {
    return this.a;
  }

  public final Message c()
  {
    return this.d;
  }

  protected final void c(Message paramMessage)
  {
    this.d = paramMessage;
  }

  public final boolean d(Message paramMessage)
  {
    Bundle localBundle1 = paramMessage.getData();
    this.b = paramMessage.arg1;
    int i;
    if (!PlatformConstants.a.contains(Integer.valueOf(this.b)))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = "Message.arg1";
      arrayOfObject[1] = Integer.valueOf(this.b);
      a(paramMessage, "Unknown protocol version in '%s': %d", arrayOfObject);
      i = 0;
    }
    while (true)
    {
      return i;
      this.c = paramMessage.arg2;
      Object localObject1 = localBundle1.get("com.facebook.platform.extra.APPLICATION_ID");
      if (!(localObject1 instanceof String))
      {
        a(paramMessage, "com.facebook.platform.extra.APPLICATION_ID", String.class, localObject1);
        i = 0;
        continue;
      }
      this.a = ((String)localObject1);
      if (!a(paramMessage))
      {
        i = 0;
        continue;
      }
      if (localBundle1.containsKey("com.facebook.platform.protocol.PROTOCOL_VALIDATE"))
      {
        Object localObject2 = localBundle1.get("com.facebook.platform.protocol.PROTOCOL_VALIDATE");
        if (!(localObject2 instanceof Boolean))
        {
          a(paramMessage, "com.facebook.platform.protocol.PROTOCOL_VALIDATE", Boolean.class, localObject2);
          i = 0;
          continue;
        }
        if (((Boolean)localObject2).booleanValue())
        {
          Bundle localBundle2 = new Bundle();
          localBundle2.putBoolean("com.facebook.platform.protocol.PROTOCOL_VALIDATED", true);
          Message localMessage = Message.obtain(null, a());
          localMessage.arg1 = 20121101;
          localMessage.arg2 = paramMessage.arg2;
          localMessage.setData(localBundle2);
          c(localMessage);
          i = 0;
          continue;
        }
      }
      i = 1;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.PlatformServiceRequest
 * JD-Core Version:    0.6.0
 */