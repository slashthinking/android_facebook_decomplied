package com.facebook.orca.common.http;

import com.facebook.orca.config.DefaultNetworkConfig;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class OrcaHttpModule$DefaultNetworkConfigProvider extends AbstractProvider<DefaultNetworkConfig>
{
  public DefaultNetworkConfig a()
  {
    return new DefaultNetworkConfig((OrcaSharedPreferences)b(OrcaSharedPreferences.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.OrcaHttpModule.DefaultNetworkConfigProvider
 * JD-Core Version:    0.6.2
 */