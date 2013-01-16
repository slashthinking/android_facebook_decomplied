package com.facebook.katana.activity.events;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.facebook.debug.Assert;

class EventCreationActivity$2
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Assert.a(-2, paramInt);
    EventCreationActivity.a(this.a, null);
    EventCreationActivity.e(this.a).setText("");
    EventCreationActivity.f(this.a).setText("");
    EventCreationActivity.e(this.a).setHint(2131362925);
    EventCreationActivity.f(this.a).setHint(2131362926);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.events.EventCreationActivity.2
 * JD-Core Version:    0.6.0
 */