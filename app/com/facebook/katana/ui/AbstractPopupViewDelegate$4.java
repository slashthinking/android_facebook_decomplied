package com.facebook.katana.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.content.SecureContextHelper;
import com.facebook.katana.activity.notifications.NotificationsSettingsActivity;
import com.facebook.orca.inject.FbInjector;

class AbstractPopupViewDelegate$4
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    ((SecureContextHelper)this.a.a(SecureContextHelper.class)).a(new Intent(this.b.a.getContext(), NotificationsSettingsActivity.class), this.b.a.getContext());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.AbstractPopupViewDelegate.4
 * JD-Core Version:    0.6.0
 */