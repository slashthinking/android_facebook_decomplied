package com.facebook.katana.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.katana.IntentUriHandler;

class AbstractPopupViewDelegate$3
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (this.a.i() != PopupViewDelegate.PopupState.MESSAGES);
    while (true)
    {
      return;
      Intent localIntent = IntentUriHandler.a(this.a.a.getContext(), "fb://messaging/compose/new/group");
      localIntent.putExtra("trigger", "jewel_popup");
      this.a.a.getContext().startActivity(localIntent);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.AbstractPopupViewDelegate.3
 * JD-Core Version:    0.6.0
 */