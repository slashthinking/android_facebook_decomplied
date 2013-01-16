package com.facebook.katana.nux;

import android.content.Context;
import android.os.AsyncTask;
import com.facebook.katana.nux.methods.UpdateNuxStatusMethod;
import com.facebook.katana.nux.model.NuxStepResult;
import com.facebook.orca.inject.FbInjector;

public class NuxStepsManager
{
  public static void a(String paramString, NuxStepResult paramNuxStepResult, Context paramContext)
  {
    NuxStepsManager.1 local1 = new NuxStepsManager.1();
    UpdateNuxStatusMethod localUpdateNuxStatusMethod = new UpdateNuxStatusMethod(paramString, paramNuxStepResult);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = localUpdateNuxStatusMethod;
    arrayOfObject[1] = FbInjector.a(paramContext);
    local1.execute(arrayOfObject);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.nux.NuxStepsManager
 * JD-Core Version:    0.6.0
 */