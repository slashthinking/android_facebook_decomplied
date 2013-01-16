package com.facebook.orca.app;

import android.content.pm.PackageInfo;
import com.facebook.orca.common.diagnostics.FbSdcardLogger;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class MessagesModule$FbSdcardLoggerProvider extends AbstractProvider<FbSdcardLogger>
{
  private MessagesModule$FbSdcardLoggerProvider(MessagesModule paramMessagesModule)
  {
  }

  public FbSdcardLogger a()
  {
    return new FbSdcardLogger((PackageInfo)b(PackageInfo.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.FbSdcardLoggerProvider
 * JD-Core Version:    0.6.0
 */