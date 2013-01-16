package com.facebook.katana.activity.events;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.facebook.debug.Assert;

class EventCreationActivity$3
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Assert.a(-2, paramInt);
    if (EventCreationActivity.g(this.a).getVisibility() == 0)
    {
      EventCreationActivity.a(this.a, null);
      EventCreationActivity.e(this.a).setText("");
      EventCreationActivity.f(this.a).setText("");
      EventCreationActivity.g(this.a).setVisibility(8);
    }
    EventCreationActivity.a(this.a, true);
    EventCreationActivity.h(this.a).setText("");
    EventCreationActivity.h(this.a).setHint(2131362932);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.events.EventCreationActivity.3
 * JD-Core Version:    0.6.0
 */