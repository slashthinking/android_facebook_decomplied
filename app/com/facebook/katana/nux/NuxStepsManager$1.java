package com.facebook.katana.nux;

import android.os.AsyncTask;
import com.facebook.common.util.Log;
import com.facebook.katana.nux.methods.UpdateNuxStatusMethod;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.protocol.base.SingleMethodRunner;

final class NuxStepsManager$1 extends AsyncTask<Object, Void, Boolean>
{
  protected Boolean a(Object[] paramArrayOfObject)
  {
    UpdateNuxStatusMethod localUpdateNuxStatusMethod = (UpdateNuxStatusMethod)paramArrayOfObject[0];
    SingleMethodRunner localSingleMethodRunner = (SingleMethodRunner)((FbInjector)paramArrayOfObject[1]).a(SingleMethodRunner.class);
    try
    {
      localSingleMethodRunner.a(localUpdateNuxStatusMethod, null);
      localBoolean = Boolean.valueOf(true);
      return localBoolean;
    }
    catch (Exception localException)
    {
      while (true)
      {
        Log.a("Failed to update user nux status: " + localException);
        Boolean localBoolean = Boolean.valueOf(false);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.nux.NuxStepsManager.1
 * JD-Core Version:    0.6.0
 */