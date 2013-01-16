package com.facebook.katana.binding;

import com.facebook.katana.prefs.NativeGdpPrefsKeys;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;

class AppSession$7
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    int i = Integer.parseInt(paramOperationResult.f());
    BLog.b(AppSession.q(), "getNuxStatus Success! " + i);
    this.a.b().a(NativeGdpPrefsKeys.b, i).a();
  }

  public void a(Throwable paramThrowable)
  {
    BLog.e(AppSession.q(), "GetNuxStatus failed.." + paramThrowable.getMessage());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.AppSession.7
 * JD-Core Version:    0.6.0
 */