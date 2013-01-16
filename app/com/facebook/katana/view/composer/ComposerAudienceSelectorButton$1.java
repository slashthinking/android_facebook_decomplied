package com.facebook.katana.view.composer;

import android.view.View;
import android.view.View.OnClickListener;

class ComposerAudienceSelectorButton$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if ((ComposerAudienceSelectorButton.a(this.b) == ComposerAudienceSelectorButton.AudienceType.PHOTO_ALBUM) && (ComposerAudienceSelectorButton.b(this.b) != null))
      ComposerAudienceSelectorButton.c(this.b);
    while (true)
    {
      return;
      if (ComposerAudienceSelectorButton.d(this.b))
      {
        this.a.onClick(paramView);
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.composer.ComposerAudienceSelectorButton.1
 * JD-Core Version:    0.6.0
 */