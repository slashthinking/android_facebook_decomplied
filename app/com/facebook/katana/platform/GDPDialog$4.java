package com.facebook.katana.platform;

import com.facebook.katana.prefs.NativeGdpPrefsKeys;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;

class GDPDialog$4
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    int i = Integer.parseInt(paramOperationResult.f());
    GDPDialog.d(this.a).b().a(NativeGdpPrefsKeys.b, i).a();
    BLog.b(GDPDialog.L(), "UpdateNuxStatus succeeded: count=" + i);
  }

  public void a(Throwable paramThrowable)
  {
    BLog.e(GDPDialog.L(), "UpdateNuxStatus failed.." + paramThrowable.getMessage());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.GDPDialog.4
 * JD-Core Version:    0.6.0
 */