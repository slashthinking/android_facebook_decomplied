package com.facebook.katana.activity.composer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import com.facebook.katana.util.ImageUtils;
import com.google.common.base.Preconditions;

class ComposerActivity$VideoThumbnailerTask extends AsyncTask<Void, Void, Bitmap>
{
  private final Context b;
  private final Uri c;

  public ComposerActivity$VideoThumbnailerTask(ComposerActivity paramComposerActivity, Context paramContext, Uri paramUri)
  {
    this.b = ((Context)Preconditions.checkNotNull(paramContext));
    this.c = paramUri;
  }

  protected Bitmap a(Void[] paramArrayOfVoid)
  {
    return ImageUtils.a(this.b, this.c, this.a.getContentResolver(), 3);
  }

  protected void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
      paramBitmap = ((BitmapDrawable)this.a.getResources().getDrawable(2130839034)).getBitmap();
    ComposerActivity.a(this.a, paramBitmap);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerActivity.VideoThumbnailerTask
 * JD-Core Version:    0.6.0
 */