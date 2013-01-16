package com.facebook.common.util;

import android.content.Context;
import android.widget.Toast;

public class Toaster
{
  private static String a()
  {
    return new java.lang.Throwable().getStackTrace()[2].getClassName();
  }

  public static void a(Context paramContext, int paramInt)
  {
    a(paramContext, paramContext.getString(paramInt), 0, null, null, a());
  }

  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    String str = a();
    a(paramContext, paramContext.getString(paramInt1), paramInt2, null, null, str);
  }

  public static void a(Context paramContext, CharSequence paramCharSequence)
  {
    a(paramContext, paramCharSequence, 0, null, null, a());
  }

  public static void a(Context paramContext, CharSequence paramCharSequence, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    int i;
    if (paramCharSequence.length() > 60)
    {
      i = 1;
      if (i == 0)
        break label76;
    }
    label76: for (int j = 1; ; j = 0)
    {
      ToastLogger localToastLogger = new ToastLogger(paramContext, paramCharSequence, paramString2, paramString1, paramString3);
      Toast localToast = Toast.makeText(paramContext, paramCharSequence, j);
      if (paramInt != 0)
        localToast.setGravity(paramInt, 0, 0);
      localToast.show();
      localToastLogger.a();
      return;
      i = 0;
      break;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.common.util.Toaster
 * JD-Core Version:    0.6.2
 */