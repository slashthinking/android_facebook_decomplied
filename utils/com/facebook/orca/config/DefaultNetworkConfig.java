package com.facebook.orca.config;

import com.facebook.base.BuildConstants;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.prefs.InternalHttpPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.OnSharedPreferenceChangeListener;
import com.google.common.base.Objects;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.http.HttpHost;

public class DefaultNetworkConfig
  implements NetworkConfig
{
  private final OrcaSharedPreferences a;
  private final CopyOnWriteArrayList<NetworkConfig.Listener> b;
  private final OrcaSharedPreferences.OnSharedPreferenceChangeListener c;
  private boolean d = true;
  private HttpHost e = null;

  public DefaultNetworkConfig(OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.a = paramOrcaSharedPreferences;
    this.b = new CopyOnWriteArrayList();
    this.c = new DefaultNetworkConfig.1(this);
    this.a.a(this.c);
    this.a.a(new DefaultNetworkConfig.2(this));
  }

  private void c()
  {
    int i = 1;
    boolean bool1 = d();
    boolean bool2 = this.d;
    int j = 0;
    if (bool1 != bool2)
    {
      this.d = bool1;
      j = i;
    }
    HttpHost localHttpHost = e();
    if (!Objects.equal(this.e, localHttpHost))
      this.e = localHttpHost;
    while (true)
    {
      if (i != 0)
        f();
      return;
      i = j;
    }
  }

  private boolean d()
  {
    boolean bool = true;
    if (this.a.a())
      bool = this.a.a(InternalHttpPrefKeys.f, bool);
    return bool;
  }

  private HttpHost e()
  {
    boolean bool1 = BuildConstants.a();
    HttpHost localHttpHost = null;
    if (!bool1);
    while (true)
    {
      return localHttpHost;
      String str = this.a.a(InternalHttpPrefKeys.g, null);
      boolean bool2 = StringUtil.a(str);
      localHttpHost = null;
      if (!bool2)
      {
        int i = str.indexOf(':');
        localHttpHost = null;
        if (i != -1)
        {
          int j = Integer.parseInt(str.substring(i + 1));
          localHttpHost = new HttpHost(str.substring(0, i), j);
        }
      }
    }
  }

  private void f()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((NetworkConfig.Listener)localIterator.next()).a();
  }

  public HttpHost a()
  {
    return this.e;
  }

  public void a(NetworkConfig.Listener paramListener)
  {
    this.b.add(paramListener);
  }

  public boolean b()
  {
    return this.d;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.config.DefaultNetworkConfig
 * JD-Core Version:    0.6.2
 */