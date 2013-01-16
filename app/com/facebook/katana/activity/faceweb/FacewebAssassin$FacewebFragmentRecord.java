package com.facebook.katana.activity.faceweb;

import android.os.SystemClock;
import java.lang.ref.WeakReference;

class FacewebAssassin$FacewebFragmentRecord
{
  public final WeakReference<FacewebFragment> a;
  public final long b;

  FacewebAssassin$FacewebFragmentRecord(FacewebFragment paramFacewebFragment)
  {
    this.a = new WeakReference(paramFacewebFragment);
    this.b = SystemClock.elapsedRealtime();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebAssassin.FacewebFragmentRecord
 * JD-Core Version:    0.6.0
 */