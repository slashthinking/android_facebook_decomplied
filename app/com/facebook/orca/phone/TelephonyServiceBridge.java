package com.facebook.orca.phone;

import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import java.lang.reflect.Method;

public class TelephonyServiceBridge
{
  private Class<?> a;
  private Object b;

  public TelephonyServiceBridge(TelephonyManager paramTelephonyManager)
  {
    Method localMethod = paramTelephonyManager.getClass().getDeclaredMethod("getITelephony", new Class[0]);
    localMethod.setAccessible(true);
    this.b = localMethod.invoke(paramTelephonyManager, new Object[0]);
    this.a = this.b.getClass();
  }

  private void a(String paramString)
  {
    Method localMethod = this.a.getDeclaredMethod(paramString, new Class[0]);
    localMethod.setAccessible(true);
    localMethod.invoke(this.b, new Object[0]);
  }

  private void b(Context paramContext)
  {
    try
    {
      Intent localIntent1 = new Intent("android.intent.action.HEADSET_PLUG");
      localIntent1.addFlags(1073741824);
      localIntent1.putExtra("state", 1);
      localIntent1.putExtra("name", "Headset");
      localIntent1.putExtra("microphone", 0);
      paramContext.sendOrderedBroadcast(localIntent1, null);
      label48: Intent localIntent2 = new Intent("android.intent.action.MEDIA_BUTTON");
      localIntent2.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, 79));
      paramContext.sendOrderedBroadcast(localIntent2, "android.permission.CALL_PRIVILEGED");
      Intent localIntent3 = new Intent("android.intent.action.MEDIA_BUTTON");
      localIntent3.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(1, 79));
      paramContext.sendOrderedBroadcast(localIntent3, "android.permission.CALL_PRIVILEGED");
      try
      {
        Intent localIntent4 = new Intent("android.intent.action.HEADSET_PLUG");
        localIntent4.addFlags(1073741824);
        localIntent4.putExtra("state", 0);
        localIntent4.putExtra("name", "Headset");
        localIntent4.putExtra("microphone", 0);
        paramContext.sendOrderedBroadcast(localIntent4, null);
        label176: return;
      }
      catch (SecurityException localSecurityException2)
      {
        break label176;
      }
    }
    catch (SecurityException localSecurityException1)
    {
      break label48;
    }
  }

  public void a()
  {
    a("endCall");
  }

  public void a(Context paramContext)
  {
    try
    {
      a("answerRingingCall");
      return;
    }
    catch (Exception localException)
    {
      while (true)
        b(paramContext);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.phone.TelephonyServiceBridge
 * JD-Core Version:    0.6.0
 */