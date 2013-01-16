package com.facebook.katana.activity.composer;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElements;

class ComposerActivity$8
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    ComposerActivity.a(this.a, FB4A_AnalyticEntities.UIElements.a);
    if (ComposerActivity.q(this.a).getVisibility() == 0)
    {
      paramView.clearAnimation();
      paramView.setVisibility(8);
      if (!ComposerActivity.r(this.a))
        this.a.p();
    }
    while (true)
    {
      return;
      this.a.launchPlacesNearby(paramView);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerActivity.8
 * JD-Core Version:    0.6.0
 */