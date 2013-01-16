package com.facebook.katana.activity.media;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.facedetection.NativeFDCrashHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class Fb4aPhotosModule$NativeFDCrashHandlerProvider extends AbstractProvider<NativeFDCrashHandler>
{
  private Fb4aPhotosModule$NativeFDCrashHandlerProvider(Fb4aPhotosModule paramFb4aPhotosModule)
  {
  }

  public NativeFDCrashHandler a()
  {
    return new NativeFDCrashHandler(Fb4aPhotosModule.a(this.a), (FbErrorReporter)b(FbErrorReporter.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.Fb4aPhotosModule.NativeFDCrashHandlerProvider
 * JD-Core Version:    0.6.0
 */