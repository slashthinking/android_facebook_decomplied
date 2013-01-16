package com.facebook.katana.service.method;

import android.os.Handler;
import com.facebook.katana.net.HttpOperation;

public class PlaceSuggestions$PlacePictureUploadHttpListener extends NetworkServiceOperation.NetworkServiceOperationHttpListener
{
  protected PlaceSuggestions$PlacePictureUploadHttpListener(PlaceSuggestions paramPlaceSuggestions)
  {
    super(paramPlaceSuggestions);
  }

  public void a(HttpOperation paramHttpOperation, long paramLong1, long paramLong2)
  {
    if (this.b.q == null);
    while (true)
    {
      return;
      ServiceOperation.n.post(new PlaceSuggestions.PlacePictureUploadHttpListener.1(this, paramLong1, paramLong2));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PlaceSuggestions.PlacePictureUploadHttpListener
 * JD-Core Version:    0.6.0
 */