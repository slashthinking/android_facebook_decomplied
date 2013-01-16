package com.facebook.orca.app;

import android.telephony.TelephonyManager;
import com.facebook.hardware.CellDiagnosticsSerializer;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$CellDiagnosticsSerializerProvider extends AbstractProvider<CellDiagnosticsSerializer>
{
  private FbBaseModule$CellDiagnosticsSerializerProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public CellDiagnosticsSerializer a()
  {
    return new CellDiagnosticsSerializer((TelephonyManager)b(TelephonyManager.class, FromApplication.class), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.CellDiagnosticsSerializerProvider
 * JD-Core Version:    0.6.0
 */