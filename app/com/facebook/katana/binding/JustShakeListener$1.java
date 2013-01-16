package com.facebook.katana.binding;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.common.util.Log;
import com.facebook.katana.activity.FacebookActivityDelegate;
import java.io.IOException;

class JustShakeListener$1
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    JustShakeListener.a(this.a, false);
    try
    {
      JustShakeListener.a(this.a).n();
      return;
    }
    catch (IOException localIOException)
    {
      Log.d("JustShakeListener", "Error reporting bug: ", localIOException);
    }
    throw new RuntimeException(localIOException);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.JustShakeListener.1
 * JD-Core Version:    0.6.0
 */