package com.facebook.camera.device;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.camera.support.CameraFlowLogger;
import com.facebook.common.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CameraFlash
  implements View.OnTouchListener
{
  public static HashMap<String, Integer> b = new HashMap(3);
  public static HashMap<String, Integer> c = new HashMap(3);
  public boolean a = true;
  private Camera d;
  private final Class<?> e = CameraFlash.class;
  private List<String> f;
  private final String g = "auto";
  private String h = "auto";
  private final CameraFlowLogger i;

  public CameraFlash(SharedPreferences paramSharedPreferences, CameraFlowLogger paramCameraFlowLogger)
  {
    this.i = paramCameraFlowLogger;
    b.put("on", Integer.valueOf(2130837647));
    b.put("off", Integer.valueOf(2130837650));
    b.put("auto", Integer.valueOf(2130837648));
    c.put("on", Integer.valueOf(2130837652));
    c.put("off", Integer.valueOf(2130837651));
    c.put("auto", Integer.valueOf(2130837649));
    this.h = paramSharedPreferences.getString("camera_flash_mode", "auto");
  }

  public Camera.Parameters a(String paramString, Camera.Parameters paramParameters)
  {
    paramParameters.setFlashMode(paramString);
    this.h = paramString;
    this.i.c(paramString);
    return paramParameters;
  }

  public void a(SharedPreferences.Editor paramEditor)
  {
    paramEditor.putString("camera_flash_mode", this.h);
  }

  public void a(Camera paramCamera)
  {
    this.d = paramCamera;
    if (this.d == null)
      this.f = null;
    Camera.Parameters localParameters;
    do
    {
      List localList;
      do
      {
        return;
        this.f = new ArrayList();
        localParameters = this.d.getParameters();
        localList = localParameters.getSupportedFlashModes();
      }
      while (localList == null);
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!b.containsKey(str))
          continue;
        this.f.add(str);
      }
    }
    while (this.f.size() <= 0);
    if (this.f.contains(this.h))
      a(this.h, localParameters);
    while (true)
    {
      try
      {
        this.d.setParameters(localParameters);
      }
      catch (Exception localException)
      {
        this.i.a("setCamera/setParameters failed", localException);
      }
      break;
      if (this.f.contains("auto"))
      {
        a("auto", localParameters);
        continue;
      }
      a((String)this.f.get(0), localParameters);
    }
  }

  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public boolean a()
  {
    int j = 1;
    int k = 0;
    if (this.d == null)
    {
      Log.e(this.e, "Camera was not set yet. Please set camera");
      return k;
    }
    if (this.f.size() > j);
    while (true)
    {
      k = j;
      break;
      j = 0;
    }
  }

  public int b()
  {
    return ((Integer)b.get(this.h)).intValue();
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int j = 0;
    if (this.d == null)
      Log.e(this.e, "camera was not set for flash to work properly");
    while (true)
    {
      return j;
      if (this.f.size() == 0)
      {
        Log.e(this.e, "No flash support found");
        j = 0;
        continue;
      }
      if (!this.a)
      {
        Log.e(this.e, "Camera not ready for flash");
        j = 0;
        continue;
      }
      Camera.Parameters localParameters = this.d.getParameters();
      int k = this.f.indexOf(localParameters.getFlashMode());
      if (paramMotionEvent.getAction() == 0)
      {
        paramView.setBackgroundResource(((Integer)c.get(this.f.get(k))).intValue());
        j = 1;
        continue;
      }
      int m = paramMotionEvent.getAction();
      j = 0;
      if (m != 1)
        continue;
      int n = (k + 1) % this.f.size();
      a((String)this.f.get(n), localParameters);
      paramView.setBackgroundResource(((Integer)b.get(this.f.get(n))).intValue());
      try
      {
        this.d.setParameters(localParameters);
        j = 1;
      }
      catch (Exception localException)
      {
        while (true)
          this.i.a("onTouch/setParameters failed", localException);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.device.CameraFlash
 * JD-Core Version:    0.6.0
 */