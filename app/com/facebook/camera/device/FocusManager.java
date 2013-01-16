package com.facebook.camera.device;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.camera.facetracking.FaceDetectionIndicatorView;
import com.facebook.camera.facetracking.FaceTracker.TrackedFacesListener;
import com.facebook.camera.facetracking.TrackedFace;
import com.facebook.camera.support.CameraFlowLogger;
import com.facebook.camera.utils.MediaUtil;
import com.facebook.common.util.Log;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class FocusManager
  implements FaceTracker.TrackedFacesListener
{
  private static final Class<?> b = FocusManager.class;
  FocusManager.Listener a;
  private int c = 0;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private Matrix h = null;
  private View i;
  private FocusIndicatorView j;
  private View k;
  private List<Camera.Area> l;
  private List<Camera.Area> m;
  private String n;
  private String[] o;
  private String p;
  private Handler q;
  private boolean r;
  private int s;
  private CameraFlowLogger t;
  private Camera u;
  private Comparator<TrackedFace> v;
  private int w = 0;
  private int x = 0;
  private HashSet<Long> y;

  public FocusManager(String[] paramArrayOfString, CameraFlowLogger paramCameraFlowLogger)
  {
    this.o = paramArrayOfString;
    this.q = new FocusManager.MainHandler(this, null);
    this.t = paramCameraFlowLogger;
  }

  public static Rect a(Rect paramRect)
  {
    return new Rect(Math.max(-1000, (int)Math.floor(1.2D * paramRect.left)), Math.min(1000, (int)Math.floor(1.2D * paramRect.top)), Math.min(1000, (int)Math.floor(1.2D * paramRect.right)), Math.max(-1000, (int)Math.floor(1.2D * paramRect.bottom)));
  }

  private void a(int paramInt1, int paramInt2)
  {
    int i1 = this.i.getWidth();
    int i2 = this.i.getHeight();
    int i3 = this.k.getWidth();
    int i4 = this.k.getHeight();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.i.getLayoutParams();
    localLayoutParams.setMargins(MediaUtil.a(paramInt1 - i1 / 2, 0, i3 - i1), MediaUtil.a(paramInt2 - i2 / 2, 0, i4 - i2), 0, 0);
    localLayoutParams.getRules()[13] = 0;
    this.i.requestLayout();
  }

  public static boolean a(Camera.Parameters paramParameters)
  {
    int i1 = Build.VERSION.SDK_INT;
    int i2 = 0;
    if (i1 < 14);
    while (true)
    {
      return i2;
      if (paramParameters.getMaxNumFocusAreas() <= 0)
      {
        int i3 = paramParameters.getMaxNumMeteringAreas();
        i2 = 0;
        if (i3 <= 0)
          continue;
      }
      i2 = 1;
    }
  }

  private static boolean a(String paramString, List<String> paramList)
  {
    int i1 = 0;
    if (paramList == null);
    while (true)
    {
      return i1;
      int i2 = paramList.indexOf(paramString);
      i1 = 0;
      if (i2 < 0)
        continue;
      i1 = 1;
    }
  }

  private void i()
  {
    Log.d(b, "Start autofocus.");
    this.a.t();
    this.c = 1;
    g();
    this.q.removeMessages(0);
  }

  private void j()
  {
    Log.d(b, "Cancel autofocus.");
    h();
    this.a.u();
    this.c = 0;
    g();
    this.q.removeMessages(0);
  }

  private void k()
  {
    if (this.a.s())
    {
      this.c = 0;
      this.q.removeMessages(0);
    }
  }

  private boolean l()
  {
    String str = f();
    if ((!str.equals("infinity")) && (!str.equals("fixed")) && (!str.equals("edof")));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public void a()
  {
    if (!this.d);
    while (true)
    {
      return;
      if (!this.g)
        this.g = true;
      if ((!l()) || (this.c != 0))
        continue;
      i();
    }
  }

  public void a(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Rect paramRect)
  {
    int i1 = (int)(paramFloat * paramInt1);
    int i2 = (int)(paramFloat * paramInt2);
    int i3 = MediaUtil.a(paramInt3 - i1 / 2, 0, paramInt5 - i1);
    int i4 = MediaUtil.a(paramInt4 - i2 / 2, 0, paramInt6 - i2);
    RectF localRectF = new RectF(i3, i4, i1 + i3, i2 + i4);
    if (this.h == null)
    {
      this.h = new Matrix();
      Matrix localMatrix = new Matrix();
      MediaUtil.a(localMatrix, this.r, this.s, this.k.getWidth(), this.k.getHeight());
      localMatrix.invert(this.h);
    }
    this.h.mapRect(localRectF);
    MediaUtil.a(localRectF, paramRect);
  }

  public void a(Camera paramCamera)
  {
    this.u = paramCamera;
    Camera.Parameters localParameters = paramCamera.getParameters();
    this.e = a("auto", localParameters.getSupportedFocusModes());
    this.f = a(localParameters);
    if (this.f)
    {
      this.w = localParameters.getMaxNumFocusAreas();
      this.x = localParameters.getMaxNumMeteringAreas();
    }
  }

  public void a(View paramView1, View paramView2, FocusManager.Listener paramListener, boolean paramBoolean, int paramInt)
  {
    this.i = paramView1;
    this.j = ((FocusIndicatorView)paramView1.findViewById(2131296870));
    this.k = paramView2;
    this.a = paramListener;
    this.r = paramBoolean;
    this.s = paramInt;
    this.h = null;
    if (CameraHolder.m())
    {
      this.v = new FocusManager.1(this);
      this.y = Sets.a();
    }
    this.d = true;
  }

  public void a(List<TrackedFace> paramList)
  {
    if ((!this.d) || (!this.f) || (this.c == 1) || (this.c == 3) || (this.c == 4));
    while (true)
    {
      return;
      if (paramList != null)
        break;
      this.y.clear();
    }
    ArrayList localArrayList = Lists.a();
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      TrackedFace localTrackedFace3 = (TrackedFace)localIterator1.next();
      if ((!localTrackedFace3.h) || (localTrackedFace3.a() <= 80000) || (localTrackedFace3.k != 5))
        continue;
      localArrayList.add(localTrackedFace3);
    }
    Iterator localIterator2 = localArrayList.iterator();
    int i1 = 0;
    label135: if (localIterator2.hasNext())
    {
      TrackedFace localTrackedFace2 = (TrackedFace)localIterator2.next();
      if (!this.y.contains(Long.valueOf(localTrackedFace2.l)))
        break label587;
    }
    label587: for (int i5 = i1 + 1; ; i5 = i1)
    {
      i1 = i5;
      break label135;
      if ((i1 == this.y.size()) && (i1 == localArrayList.size()))
      {
        g();
        this.q.removeMessages(0);
        this.q.sendEmptyMessageDelayed(0, 10000L);
        break;
      }
      this.y.clear();
      if (localArrayList.size() <= 0)
        break;
      if (this.l == null)
      {
        this.l = Lists.a();
        if (this.m != null)
          break label374;
        this.m = Lists.a();
      }
      TrackedFace[] arrayOfTrackedFace;
      while (true)
      {
        arrayOfTrackedFace = new TrackedFace[localArrayList.size()];
        Iterator localIterator3 = localArrayList.iterator();
        int i4;
        for (int i2 = 0; localIterator3.hasNext(); i2 = i4)
        {
          TrackedFace localTrackedFace1 = (TrackedFace)localIterator3.next();
          i4 = i2 + 1;
          arrayOfTrackedFace[i2] = localTrackedFace1;
          this.y.add(Long.valueOf(localTrackedFace1.l));
        }
        this.l.clear();
        break;
        label374: this.m.clear();
      }
      Arrays.sort(arrayOfTrackedFace, this.v);
      for (int i3 = -1 + arrayOfTrackedFace.length; i3 >= 0; i3--)
      {
        Camera.Area localArea = new Camera.Area(a(arrayOfTrackedFace[i3].f), 1000);
        if (-1 + arrayOfTrackedFace.length - i3 < this.w)
          this.l.add(localArea);
        if (-1 + arrayOfTrackedFace.length - i3 >= this.x)
          continue;
        this.m.add(localArea);
      }
      if (!a(this.l, this.m))
        break;
      Rect localRect = FaceDetectionIndicatorView.a(arrayOfTrackedFace[(-1 + arrayOfTrackedFace.length)], this.k.getWidth(), this.k.getHeight());
      a(localRect.centerX(), localRect.centerY());
      if (this.e)
      {
        i();
        break;
      }
      g();
      this.q.removeMessages(0);
      this.q.sendEmptyMessageDelayed(0, 10000L);
      break;
    }
  }

  public void a(boolean paramBoolean)
  {
    int i1 = 3;
    if (this.c == 2)
      if (paramBoolean)
      {
        this.c = i1;
        g();
        k();
      }
    while (true)
    {
      return;
      this.c = 4;
      break;
      if (this.c == 1)
      {
        if (paramBoolean);
        while (true)
        {
          this.c = i1;
          g();
          this.q.removeMessages(0);
          this.q.sendEmptyMessageDelayed(0, 10000L);
          break;
          i1 = 4;
        }
      }
      if (this.c != 0)
        continue;
    }
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    int i1;
    if ((!this.d) || (this.c == 2))
    {
      i1 = 0;
      return i1;
    }
    if ((this.c == 1) || (this.c == 3) || (this.c == 4))
      j();
    int i2 = Math.round(paramMotionEvent.getX());
    int i3 = Math.round(paramMotionEvent.getY());
    if (this.f)
      a(i2, i3);
    if ((this.e) && (paramMotionEvent.getAction() == 1))
    {
      if (this.f)
      {
        int i4 = this.i.getWidth();
        int i5 = this.i.getHeight();
        int i6 = this.k.getWidth();
        int i7 = this.k.getHeight();
        this.l = new ArrayList();
        this.l.add(new Camera.Area(new Rect(), 1));
        this.m = new ArrayList();
        this.m.add(new Camera.Area(new Rect(), 1));
        a(i4, i5, 1.0F, i2, i3, i6, i7, ((Camera.Area)this.l.get(0)).rect);
        a(i4, i5, 1.5F, i2, i3, i6, i7, ((Camera.Area)this.m.get(0)).rect);
        a(this.m, null);
      }
      i();
    }
    while (true)
    {
      i1 = 1;
      break;
      g();
      this.q.removeMessages(0);
      this.q.sendEmptyMessageDelayed(0, 10000L);
    }
  }

  public boolean a(List<Camera.Area> paramList1, List<Camera.Area> paramList2)
  {
    try
    {
      Camera.Parameters localParameters = this.u.getParameters();
      localParameters.setFocusAreas(paramList1);
      localParameters.setMeteringAreas(paramList2);
      this.u.setParameters(localParameters);
      i1 = 1;
      return i1;
    }
    catch (Exception localException)
    {
      while (true)
      {
        this.t.a("setFocusAndMeteringAreas/setParameters failed", localException);
        this.f = false;
        int i1 = 0;
      }
    }
  }

  public void b()
  {
    if (!this.d);
    while (true)
    {
      return;
      if ((!l()) || (this.c == 3) || (this.c == 4))
      {
        k();
        continue;
      }
      if (this.c == 1)
      {
        this.c = 2;
        continue;
      }
      if (this.c != 0)
        continue;
      k();
    }
  }

  public void c()
  {
    this.c = 0;
  }

  public void d()
  {
    this.c = 0;
    this.q.removeMessages(0);
    g();
  }

  public void e()
  {
    d();
  }

  public String f()
  {
    String str2;
    if (this.p != null)
    {
      str2 = this.p;
      return str2;
    }
    Camera.Parameters localParameters = this.u.getParameters();
    List localList = localParameters.getSupportedFocusModes();
    if ((this.e) && (this.l != null))
    {
      this.n = "auto";
      label50: if (!a(this.n, localList))
        if (!a("auto", localParameters.getSupportedFocusModes()))
          break label144;
    }
    label142: label144: for (this.n = "auto"; ; this.n = localParameters.getFocusMode())
    {
      str2 = this.n;
      break;
      this.n = null;
      String[] arrayOfString = this.o;
      int i1 = arrayOfString.length;
      for (int i2 = 0; ; i2++)
      {
        if (i2 >= i1)
          break label142;
        String str1 = arrayOfString[i2];
        if (!a(str1, localList))
          continue;
        this.n = str1;
        break;
      }
      break label50;
    }
  }

  public void g()
  {
    if (!this.d);
    while (true)
    {
      return;
      int i1 = Math.min(this.k.getWidth(), this.k.getHeight()) / 4;
      ViewGroup.LayoutParams localLayoutParams = this.j.getLayoutParams();
      localLayoutParams.width = i1;
      localLayoutParams.height = i1;
      FocusIndicatorView localFocusIndicatorView = this.j;
      if (this.c == 0)
      {
        if (this.l == null)
        {
          localFocusIndicatorView.d();
          continue;
        }
        localFocusIndicatorView.a();
        continue;
      }
      if ((this.c == 1) || (this.c == 2))
      {
        localFocusIndicatorView.a();
        continue;
      }
      if ("continuous-picture".equals(this.n))
      {
        localFocusIndicatorView.a();
        continue;
      }
      if (this.c == 3)
      {
        localFocusIndicatorView.b();
        continue;
      }
      if (this.c != 4)
        continue;
      localFocusIndicatorView.c();
    }
  }

  public void h()
  {
    if (!this.d);
    while (true)
    {
      return;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.i.getLayoutParams();
      localLayoutParams.getRules()[13] = -1;
      localLayoutParams.setMargins(0, 0, 0, 0);
      if (!this.f)
        continue;
      this.l = null;
      this.m = null;
      Camera.Parameters localParameters = this.u.getParameters();
      localParameters.setFocusAreas(null);
      localParameters.setMeteringAreas(null);
      try
      {
        this.u.setParameters(localParameters);
      }
      catch (Exception localException)
      {
        this.t.a("resetFocus/setParameters failed", localException);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.device.FocusManager
 * JD-Core Version:    0.6.0
 */