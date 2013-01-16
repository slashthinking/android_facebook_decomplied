package com.facebook.orca.photos.view;

import android.net.Uri;
import com.facebook.orca.threads.Message;

public class PhotoMessageItem
{
  private final Uri a;
  private final Message b;

  public PhotoMessageItem(Uri paramUri, Message paramMessage)
  {
    this.a = paramUri;
    this.b = paramMessage;
  }

  public Uri a()
  {
    return this.a;
  }

  public Message b()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.view.PhotoMessageItem
 * JD-Core Version:    0.6.0
 */