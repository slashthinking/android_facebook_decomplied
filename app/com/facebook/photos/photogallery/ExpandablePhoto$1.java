package com.facebook.photos.photogallery;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

class ExpandablePhoto$1 extends AnimatorListenerAdapter
{
  public void a(Animator paramAnimator)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      ExpandablePhoto.b(this.a).setLayerType(0, null);
      ExpandablePhoto.c(this.a).setLayerType(0, null);
      ExpandablePhoto.d(this.a).setLayerType(0, null);
    }
    ExpandablePhoto.b(this.a, ExpandablePhoto.a(this.a));
  }

  public void b(Animator paramAnimator)
  {
    ExpandablePhoto.a(this.a, ExpandablePhoto.a(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.ExpandablePhoto.1
 * JD-Core Version:    0.6.0
 */