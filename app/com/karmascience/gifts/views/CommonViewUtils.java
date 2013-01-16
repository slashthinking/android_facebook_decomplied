package com.karmascience.gifts.views;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class CommonViewUtils
{
  private static final String a = CommonViewUtils.class.getName();
  private static final NumberFormat b = NumberFormat.getInstance();

  static
  {
    b.setCurrency(Currency.getInstance(Locale.US));
    b.setMaximumFractionDigits(2);
    b.setMinimumFractionDigits(2);
  }

  public static Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("command", 3);
    return localBundle;
  }

  public static Bundle a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("command", 1);
    localBundle.putInt("view_type", paramInt);
    return localBundle;
  }

  public static Bundle a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("command", 11);
    localBundle.putString("recipient_facebook_id", paramString);
    return localBundle;
  }

  public static Bundle a(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("command", 12);
    localBundle.putString("gift_id", paramString);
    localBundle.putBoolean("pay_now_required", paramBoolean);
    return localBundle;
  }

  public static View a(Context paramContext, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    ImageView localImageView = new ImageView(paramContext);
    localImageView.setLayoutParams(paramLayoutParams);
    localImageView.setBackgroundResource(paramInt);
    return localImageView;
  }

  public static String a(int paramInt1, int paramInt2)
  {
    return "$" + b(paramInt1 / 100, paramInt2 / 100);
  }

  public static void a(Context paramContext, IBinder paramIBinder)
  {
    a(paramContext, paramIBinder, null);
  }

  public static void a(Context paramContext, IBinder paramIBinder, ResultReceiver paramResultReceiver)
  {
    ((InputMethodManager)paramContext.getSystemService("input_method")).hideSoftInputFromWindow(paramIBinder, 0, paramResultReceiver);
  }

  public static Bundle b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("command", 4);
    return localBundle;
  }

  public static Bundle b(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    localBundle.putInt("command", 13);
    return localBundle;
  }

  public static String b(int paramInt)
  {
    return "$" + Integer.toString(paramInt / 100);
  }

  public static String b(int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2);
    for (String str = Integer.toString(paramInt1) + '-' + Integer.toString(paramInt2); ; str = Integer.toString(paramInt2))
      return str;
  }

  public static Bundle c(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("command", 2);
    localBundle.putString("breadcrumb", paramString);
    return localBundle;
  }

  public static String c(int paramInt)
  {
    String str = Integer.toString(paramInt);
    if (str.length() > 2)
      str = str.substring(0, -2 + str.length()) + '.' + str.substring(-2 + str.length());
    while (true)
    {
      return "$" + str;
      if (str.length() != 2)
        continue;
      str = "0." + str;
    }
  }

  public static String d(String paramString)
  {
    if ((paramString != null) && (paramString.indexOf(' ') != -1))
      paramString = paramString.substring(0, paramString.indexOf(' '));
    return paramString;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.CommonViewUtils
 * JD-Core Version:    0.6.0
 */