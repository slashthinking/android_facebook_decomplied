package com.facebook.orca.images;

import android.net.Uri;
import com.facebook.orca.media.MediaResource;
import com.facebook.orca.photos.picking.PickMediaOperation.OnMediaPickedListener;
import java.io.File;

class ThreadIconPickerActivity$1 extends PickMediaOperation.OnMediaPickedListener
{
  public void a()
  {
    this.a.finish();
  }

  public void a(MediaResource paramMediaResource)
  {
    File localFile = new File(paramMediaResource.c().getPath());
    ThreadIconPickerActivity.a(this.a, localFile);
  }

  public void b()
  {
    this.a.finish();
  }

  public void c()
  {
    ThreadIconPickerActivity.a(this.a, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ThreadIconPickerActivity.1
 * JD-Core Version:    0.6.0
 */