package com.facebook.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class ExpandablePhoto$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ExpandablePhoto$2(ExpandablePhoto paramExpandablePhoto)
  {
  }

  public void onGlobalLayout()
  {
    ExpandablePhoto.a(this.a, ExpandablePhoto.b(this.a).getResources().getDisplayMetrics());
    ExpandablePhoto.a(this.a, ExpandablePhoto.c(this.a).widthPixels);
    ExpandablePhoto.b(this.a, ExpandablePhoto.c(this.a).heightPixels - ExpandablePhoto.d(this.a));
    ViewGroup.LayoutParams localLayoutParams = ExpandablePhoto.e(this.a).getLayoutParams();
    localLayoutParams.width = ExpandablePhoto.f(this.a);
    localLayoutParams.height = ExpandablePhoto.g(this.a);
    ExpandablePhoto.e(this.a).setLayoutParams(localLayoutParams);
    ExpandablePhoto.e(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.ExpandablePhoto.2
 * JD-Core Version:    0.6.2
 */