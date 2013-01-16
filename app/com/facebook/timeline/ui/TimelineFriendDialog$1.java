package com.facebook.timeline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

class TimelineFriendDialog$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    int i = this.a.getChildCount();
    for (int j = 0; j < i; j++)
      this.a.getChildAt(j).setVisibility(0);
    paramView.setVisibility(8);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.ui.TimelineFriendDialog.1
 * JD-Core Version:    0.6.0
 */