package com.facebook.katana.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.common.util.ErrorReporting;

class FacebookActivityDelegate$8
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ErrorReporting.a("Intentional user-triggered soft error", "message accompanying user-triggered soft errorwith embedded new\nline.");
    paramDialogInterface.cancel();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.FacebookActivityDelegate.8
 * JD-Core Version:    0.6.0
 */