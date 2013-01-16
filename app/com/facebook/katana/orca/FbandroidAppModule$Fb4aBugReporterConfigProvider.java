package com.facebook.katana.orca;

import android.content.Context;
import com.facebook.katana.features.bugreporter.Fb4aBugReporterConfig;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class FbandroidAppModule$Fb4aBugReporterConfigProvider extends AbstractProvider<Fb4aBugReporterConfig>
{
  private FbandroidAppModule$Fb4aBugReporterConfigProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public Fb4aBugReporterConfig a()
  {
    return new Fb4aBugReporterConfig((Context)b(Context.class, FromApplication.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.Fb4aBugReporterConfigProvider
 * JD-Core Version:    0.6.0
 */