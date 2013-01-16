package com.facebook.orca.phone;

import android.graphics.Bitmap;
import android.net.Uri;

class IncallActivity$ContactLookupListener
  implements ContactLookupTask.ContactLookupTaskListener
{
  private IncallActivity$ContactLookupListener(IncallActivity paramIncallActivity)
  {
  }

  public void a(String paramString, Bitmap paramBitmap)
  {
    this.a.runOnUiThread(new IncallActivity.ContactLookupListener.3(this, paramBitmap));
  }

  public void a(String paramString, Uri paramUri)
  {
    this.a.runOnUiThread(new IncallActivity.ContactLookupListener.2(this, paramUri));
  }

  public void a(String paramString1, String paramString2)
  {
    this.a.runOnUiThread(new IncallActivity.ContactLookupListener.1(this, paramString1, paramString2));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.phone.IncallActivity.ContactLookupListener
 * JD-Core Version:    0.6.0
 */