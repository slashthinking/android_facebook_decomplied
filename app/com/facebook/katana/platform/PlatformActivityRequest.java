package com.facebook.katana.platform;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class PlatformActivityRequest
{
  private String a;
  private int b;
  private Intent c;

  protected abstract String a();

  protected void a(Intent paramIntent, String paramString, Class<?> paramClass, Object paramObject)
  {
    if (paramObject == null)
      a(paramIntent, "Expected non-null '%s' extra, actual value was null.", new Object[] { paramString });
    while (true)
    {
      return;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = paramClass.getSimpleName();
      arrayOfObject[2] = paramObject.getClass().getSimpleName();
      a(paramIntent, "Expected '%s' extra to be type '%s', actual value was type '%s'.", arrayOfObject);
    }
  }

  protected void a(Intent paramIntent, String paramString, Object[] paramArrayOfObject)
  {
    String str = StringLocaleUtil.a(paramString, paramArrayOfObject);
    b(new PlatformActivityErrorIntentBuilder(a(), "ProtocolError", str).a());
  }

  protected abstract boolean a(Intent paramIntent);

  protected final boolean a(Intent paramIntent, String paramString, boolean paramBoolean, PlatformActivityRequest.Setter<ArrayList<String>> paramSetter)
  {
    Object localObject1 = paramIntent.getExtras().get(paramString);
    if (localObject1 == null)
      if (paramBoolean)
        paramSetter.a(new ArrayList());
    while (true)
    {
      return paramBoolean;
      a(paramIntent, paramString, ArrayList.class, localObject1);
      continue;
      if (!(localObject1 instanceof ArrayList))
      {
        a(paramIntent, paramString, ArrayList.class, localObject1);
        paramBoolean = false;
        continue;
      }
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      while (true)
        if (localIterator.hasNext())
        {
          Object localObject2 = localIterator.next();
          if ((localObject2 instanceof String))
            continue;
          b(paramIntent, paramString, String.class, localObject2);
          paramBoolean = false;
          break;
        }
      paramSetter.a((ArrayList)localObject1);
      paramBoolean = true;
    }
  }

  protected final <TExtra> boolean a(Intent paramIntent, String paramString, boolean paramBoolean, Class<TExtra> paramClass, PlatformActivityRequest.Setter<TExtra> paramSetter)
  {
    Object localObject = paramIntent.getExtras().get(paramString);
    if (localObject == null)
      if (paramBoolean)
        paramSetter.a(null);
    while (true)
    {
      return paramBoolean;
      a(paramIntent, paramString, paramClass, localObject);
      continue;
      if (!paramClass.isAssignableFrom(localObject.getClass()))
      {
        a(paramIntent, paramString, paramClass, localObject);
        paramBoolean = false;
        continue;
      }
      paramSetter.a(localObject);
      paramBoolean = true;
    }
  }

  protected final void b(Intent paramIntent)
  {
    this.c = paramIntent;
  }

  protected void b(Intent paramIntent, String paramString, Class<?> paramClass, Object paramObject)
  {
    if (paramObject == null)
      a(paramIntent, "Expected non-null items in '%s' ArrayList extra, actual item was null.", new Object[] { paramString });
    while (true)
    {
      return;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = paramClass.getSimpleName();
      arrayOfObject[2] = paramObject.getClass().getSimpleName();
      a(paramIntent, "Expected '%s' ArrayList extra to contain items of type '%s', actual was type '%s'.", arrayOfObject);
    }
  }

  public final boolean c(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    Object localObject1 = localBundle.get("com.facebook.platform.protocol.PROTOCOL_VERSION");
    int i;
    if (!(localObject1 instanceof Integer))
    {
      a(paramIntent, "com.facebook.platform.protocol.PROTOCOL_VERSION", Integer.class, localObject1);
      i = 0;
    }
    while (true)
    {
      return i;
      this.b = ((Integer)localObject1).intValue();
      if (!PlatformConstants.a.contains(Integer.valueOf(this.b)))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = "com.facebook.platform.protocol.PROTOCOL_VERSION";
        arrayOfObject[1] = Integer.valueOf(this.b);
        a(paramIntent, "Unknown protocol version extra '%s': %d", arrayOfObject);
        i = 0;
        continue;
      }
      Object localObject2 = localBundle.get("com.facebook.platform.extra.APPLICATION_ID");
      if (!(localObject2 instanceof String))
      {
        a(paramIntent, "com.facebook.platform.extra.APPLICATION_ID", String.class, localObject2);
        i = 0;
        continue;
      }
      this.a = ((String)localObject2);
      if (!a(paramIntent))
      {
        i = 0;
        continue;
      }
      if (localBundle.containsKey("com.facebook.platform.protocol.PROTOCOL_VALIDATE"))
      {
        Object localObject3 = localBundle.get("com.facebook.platform.protocol.PROTOCOL_VALIDATE");
        if (!(localObject3 instanceof Boolean))
        {
          a(paramIntent, "com.facebook.platform.protocol.PROTOCOL_VALIDATE", Boolean.class, localObject3);
          i = 0;
          continue;
        }
        if (((Boolean)localObject3).booleanValue())
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 20121101);
          localIntent.putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", a());
          localIntent.putExtra("com.facebook.platform.protocol.PROTOCOL_VALIDATED", true);
          b(localIntent);
          i = 0;
          continue;
        }
      }
      i = 1;
    }
  }

  public final String d()
  {
    return this.a;
  }

  public final Intent e()
  {
    return this.c;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.PlatformActivityRequest
 * JD-Core Version:    0.6.0
 */