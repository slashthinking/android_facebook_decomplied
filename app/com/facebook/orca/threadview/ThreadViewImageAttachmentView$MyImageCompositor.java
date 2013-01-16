package com.facebook.orca.threadview;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.facebook.orca.images.UrlImageCompositor;
import java.util.List;

class ThreadViewImageAttachmentView$MyImageCompositor
  implements UrlImageCompositor
{
  private ThreadViewImageAttachmentView$MyImageCompositor(ThreadViewImageAttachmentView paramThreadViewImageAttachmentView)
  {
  }

  public Drawable a(List<Bitmap> paramList)
  {
    BitmapDrawable localBitmapDrawable1 = new BitmapDrawable(this.a.getResources(), (Bitmap)paramList.get(0));
    BitmapDrawable localBitmapDrawable2 = new BitmapDrawable(this.a.getResources(), (Bitmap)paramList.get(1));
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(ThreadViewImageAttachmentView.a(), localBitmapDrawable2);
    localStateListDrawable.addState(ThreadViewImageAttachmentView.b(), localBitmapDrawable1);
    return localStateListDrawable;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewImageAttachmentView.MyImageCompositor
 * JD-Core Version:    0.6.0
 */