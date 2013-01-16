package com.facebook.orca.prefs;

import android.net.Uri;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public class UiCounters
{
  private final OrcaSharedPreferences a;
  private final WeakHashMap<UiCounters.Listener, Integer> b;

  public UiCounters(OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.a = paramOrcaSharedPreferences;
    this.b = new WeakHashMap();
  }

  private void d(String paramString1, String paramString2)
  {
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
      ((UiCounters.Listener)localIterator.next()).a(paramString1, paramString2);
  }

  private PrefKey e(String paramString1, String paramString2)
  {
    PrefKey localPrefKey = (PrefKey)MessagesPrefKeys.x.c(Uri.encode(paramString1));
    if (paramString2 != null)
      localPrefKey = (PrefKey)localPrefKey.c("/" + Uri.encode(paramString2));
    return (PrefKey)localPrefKey.c("/count");
  }

  private PrefKey f(String paramString1, String paramString2)
  {
    PrefKey localPrefKey = (PrefKey)MessagesPrefKeys.x.c(Uri.encode(paramString1));
    if (paramString2 != null)
      localPrefKey = (PrefKey)localPrefKey.c("/" + Uri.encode(paramString2));
    return (PrefKey)localPrefKey.c("/timestamp");
  }

  public int a(String paramString)
  {
    return a(paramString, null);
  }

  public int a(String paramString1, String paramString2)
  {
    PrefKey localPrefKey = e(paramString1, paramString2);
    return this.a.a(localPrefKey, 0);
  }

  public void a(UiCounters.Listener paramListener)
  {
    this.b.put(paramListener, Integer.valueOf(1));
  }

  public void a(String paramString, int paramInt)
  {
    a(paramString, null, paramInt);
  }

  public void a(String paramString1, String paramString2, int paramInt)
  {
    OrcaSharedPreferences.Editor localEditor = this.a.b();
    localEditor.a(e(paramString1, paramString2), paramInt);
    localEditor.a(f(paramString1, paramString2), System.currentTimeMillis());
    localEditor.a();
    d(paramString1, paramString2);
  }

  public long b(String paramString)
  {
    return b(paramString, null);
  }

  public long b(String paramString1, String paramString2)
  {
    PrefKey localPrefKey = f(paramString1, paramString2);
    return this.a.a(localPrefKey, 0L);
  }

  public void c(String paramString)
  {
    c(paramString, null);
  }

  public void c(String paramString1, String paramString2)
  {
    int i = a(paramString1, paramString2);
    OrcaSharedPreferences.Editor localEditor = this.a.b();
    localEditor.a(e(paramString1, paramString2), i + 1);
    localEditor.a(f(paramString1, paramString2), System.currentTimeMillis());
    localEditor.a();
    d(paramString1, paramString2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.UiCounters
 * JD-Core Version:    0.6.0
 */