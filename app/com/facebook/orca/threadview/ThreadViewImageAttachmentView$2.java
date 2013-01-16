package com.facebook.orca.threadview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.facebook.orca.images.UrlImageProcessor;

class ThreadViewImageAttachmentView$2 extends UrlImageProcessor
{
  public Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = this.b.a(paramBitmap);
    Drawable localDrawable = this.d.getResources().getDrawable(this.c);
    return ThreadViewImageAttachmentView.a(this.d, localBitmap, localDrawable);
  }

  public String a()
  {
    return "tviatv_" + this.b.a() + "_" + this.c;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewImageAttachmentView.2
 * JD-Core Version:    0.6.0
 */