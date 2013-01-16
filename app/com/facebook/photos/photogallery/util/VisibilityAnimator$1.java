package com.facebook.photos.photogallery.util;

import com.facebook.widget.ViewTransform;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

class VisibilityAnimator$1 extends AnimatorListenerAdapter
{
  public void a(Animator paramAnimator)
  {
    if (VisibilityAnimator.a(this.a).getAlpha() == 0.0F)
      VisibilityAnimator.b(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.util.VisibilityAnimator.1
 * JD-Core Version:    0.6.0
 */