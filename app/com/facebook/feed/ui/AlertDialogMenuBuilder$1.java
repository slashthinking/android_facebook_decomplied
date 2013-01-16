package com.facebook.feed.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.ArrayList;

class AlertDialogMenuBuilder$1
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((DialogInterface.OnClickListener)AlertDialogMenuBuilder.a(this.a).get(paramInt)).onClick(paramDialogInterface, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.AlertDialogMenuBuilder.1
 * JD-Core Version:    0.6.0
 */