package com.facebook.katana.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.ClipboardManager;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.facebook.orca.common.util.StringUtil;
import java.io.Serializable;
import java.util.Map;
import java.util.Random;

public class Utils
{
  public static final Random a = new Random();

  public static float a(int paramInt, float paramFloat)
  {
    return paramFloat * paramInt / 160.0F;
  }

  public static Bundle a(Object[] paramArrayOfObject)
  {
    Bundle localBundle = new Bundle();
    int i = 0;
    if (i < paramArrayOfObject.length)
    {
      String str = (String)paramArrayOfObject[i];
      Object localObject = paramArrayOfObject[(i + 1)];
      if ((localObject instanceof String))
        localBundle.putString(str, (String)localObject);
      while (true)
      {
        i += 2;
        break;
        if ((localObject instanceof Long))
        {
          localBundle.putLong(str, ((Long)localObject).longValue());
          continue;
        }
        if ((localObject instanceof Integer))
        {
          localBundle.putInt(str, ((Integer)localObject).intValue());
          continue;
        }
        if ((localObject instanceof Boolean))
        {
          localBundle.putBoolean(str, ((Boolean)localObject).booleanValue());
          continue;
        }
        if (!(localObject instanceof Serializable))
          continue;
        localBundle.putSerializable(str, (Serializable)localObject);
      }
    }
    return localBundle;
  }

  public static <K, V> V a(Map<K, V> paramMap, K paramK, V paramV)
  {
    if (paramMap.containsKey(paramK))
      paramV = paramMap.get(paramK);
    return paramV;
  }

  public static String a(long paramLong, Context paramContext)
  {
    int[] arrayOfInt = { 2131363564, 2131363565, 2131363566, 2131363567, 2131363568, 2131363569 };
    Object[] arrayOfObject2;
    if (paramLong < 1024)
    {
      arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Long.toString(paramLong);
    }
    int i;
    String str1;
    for (String str2 = paramContext.getString(2131363563, arrayOfObject2); ; str2 = paramContext.getResources().getString(arrayOfInt[(i - 1)], new Object[] { str1 }))
    {
      return str2;
      i = (int)(Math.log(paramLong) / Math.log(1024));
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Double.valueOf(paramLong / Math.pow(1024, i));
      str1 = StringUtil.a("%.1f", arrayOfObject1);
    }
  }

  public static String a(Activity paramActivity)
  {
    Intent localIntent = paramActivity.getIntent();
    if (localIntent.hasExtra("extra_launch_uri"));
    for (String str = localIntent.getStringExtra("extra_launch_uri"); ; str = localIntent.getDataString())
      return str;
  }

  public static String a(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getLine1Number();
  }

  public static String a(Bundle paramBundle, String paramString)
  {
    Object localObject = paramBundle.get(paramString);
    if (localObject == null);
    for (String str = null; ; str = localObject.toString())
      return str;
  }

  public static void a(Context paramContext, View paramView)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
    if (localInputMethodManager != null)
      localInputMethodManager.showSoftInput(paramView, 2);
  }

  public static void a(Context paramContext, String paramString)
  {
    ((ClipboardManager)paramContext.getSystemService("clipboard")).setText(paramString);
  }

  public static int b(Object[] paramArrayOfObject)
  {
    long l = c(paramArrayOfObject);
    return (int)(l ^ l >>> 32);
  }

  public static void b(Activity paramActivity)
  {
    if (paramActivity == null);
    while (true)
    {
      return;
      InputMethodManager localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
      if (localInputMethodManager == null)
        continue;
      localInputMethodManager.hideSoftInputFromWindow(paramActivity.getWindow().getDecorView().getWindowToken(), 0);
    }
  }

  public static long c(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    long l1 = 0L;
    int j = 0;
    if (j < i)
    {
      Object localObject = paramArrayOfObject[j];
      long l2 = l1 * 31L;
      if (localObject != null)
        l1 = l2 + localObject.hashCode();
      while (true)
      {
        j++;
        break;
        l1 = l2 + 8795404838907415129L;
      }
    }
    return l1;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.Utils
 * JD-Core Version:    0.6.0
 */