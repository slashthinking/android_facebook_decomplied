package com.facebook.orca.app;

import android.net.wifi.WifiManager;
import com.facebook.hardware.WifiDiagnosticsSerializer;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$WifiDiagnosticsSerializerProvider extends AbstractProvider<WifiDiagnosticsSerializer>
{
  private FbBaseModule$WifiDiagnosticsSerializerProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public WifiDiagnosticsSerializer a()
  {
    return new WifiDiagnosticsSerializer((WifiManager)b(WifiManager.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.WifiDiagnosticsSerializerProvider
 * JD-Core Version:    0.6.0
 */