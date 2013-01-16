package com.facebook.orca.server;

import android.content.Context;
import android.content.Intent;
import com.google.common.collect.Maps;
import java.lang.annotation.Annotation;
import java.util.Map;

public class OrcaServiceRegistry
{
  private final Map<String, Class<? extends Annotation>> a = Maps.c();
  private final Map<Class<? extends Annotation>, Class<? extends OrcaService>> b = Maps.c();
  private final Map<Class<? extends Annotation>, String> c = Maps.c();

  public Intent a(String paramString, Context paramContext)
  {
    Class localClass1 = (Class)this.a.get(paramString);
    Intent localIntent;
    if (localClass1 == null)
      localIntent = null;
    while (true)
    {
      return localIntent;
      Class localClass2 = (Class)this.b.get(localClass1);
      if (localClass2 != null)
      {
        localIntent = new Intent(paramContext, localClass2);
        continue;
      }
      String str = (String)this.c.get(localClass1);
      if (str != null)
      {
        localIntent = new Intent(str);
        continue;
      }
      localIntent = null;
    }
  }

  public Class<? extends OrcaService> a(Class<? extends Annotation> paramClass)
  {
    return (Class)this.b.get(paramClass);
  }

  public Class<? extends Annotation> a(String paramString)
  {
    return (Class)this.a.get(paramString);
  }

  public void a(Class<? extends Annotation> paramClass, Class<? extends OrcaService> paramClass1)
  {
    this.b.put(paramClass, paramClass1);
  }

  public void a(Class<? extends Annotation> paramClass, String paramString)
  {
    this.c.put(paramClass, paramString);
  }

  public void a(String paramString, Class<? extends Annotation> paramClass)
  {
    this.a.put(paramString, paramClass);
  }

  public Class<? extends OrcaService> b(String paramString)
  {
    Class localClass1 = (Class)this.a.get(paramString);
    if (localClass1 == null);
    for (Class localClass2 = null; ; localClass2 = (Class)this.b.get(localClass1))
      return localClass2;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.OrcaServiceRegistry
 * JD-Core Version:    0.6.0
 */