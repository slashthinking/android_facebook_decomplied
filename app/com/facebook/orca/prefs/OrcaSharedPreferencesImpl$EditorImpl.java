package com.facebook.orca.prefs;

import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class OrcaSharedPreferencesImpl$EditorImpl
  implements OrcaSharedPreferences.Editor
{
  private final Map<PrefKey, Object> b = Maps.a();

  public OrcaSharedPreferencesImpl$EditorImpl(OrcaSharedPreferencesImpl paramOrcaSharedPreferencesImpl)
  {
  }

  public OrcaSharedPreferences.Editor a(PrefKey paramPrefKey)
  {
    monitorenter;
    try
    {
      this.b.put(paramPrefKey, OrcaSharedPreferencesImpl.e());
      monitorexit;
      return this;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public OrcaSharedPreferences.Editor a(PrefKey paramPrefKey, int paramInt)
  {
    monitorenter;
    try
    {
      this.b.put(paramPrefKey, Integer.valueOf(paramInt));
      monitorexit;
      return this;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public OrcaSharedPreferences.Editor a(PrefKey paramPrefKey, long paramLong)
  {
    monitorenter;
    try
    {
      this.b.put(paramPrefKey, Long.valueOf(paramLong));
      monitorexit;
      return this;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public OrcaSharedPreferences.Editor a(PrefKey paramPrefKey, String paramString)
  {
    monitorenter;
    try
    {
      this.b.put(paramPrefKey, paramString);
      monitorexit;
      return this;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public OrcaSharedPreferences.Editor a(PrefKey paramPrefKey, boolean paramBoolean)
  {
    monitorenter;
    try
    {
      this.b.put(paramPrefKey, Boolean.valueOf(paramBoolean));
      monitorexit;
      return this;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void a()
  {
    monitorenter;
    try
    {
      HashMap localHashMap = Maps.a(this.b);
      OrcaSharedPreferencesImpl.a(this.a, localHashMap, true);
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

  public OrcaSharedPreferences.Editor b(PrefKey paramPrefKey)
  {
    monitorenter;
    try
    {
      Iterator localIterator = this.a.b(paramPrefKey).iterator();
      if (localIterator.hasNext())
      {
        PrefKey localPrefKey = (PrefKey)localIterator.next();
        this.b.put(localPrefKey, OrcaSharedPreferencesImpl.e());
      }
    }
    finally
    {
      monitorexit;
    }
    return this;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaSharedPreferencesImpl.EditorImpl
 * JD-Core Version:    0.6.0
 */