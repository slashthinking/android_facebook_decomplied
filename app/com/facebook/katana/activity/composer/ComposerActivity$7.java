package com.facebook.katana.activity.composer;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import com.facebook.ipc.katana.model.FacebookEvent;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.features.events.AggressiveSuggestionPreferences;

class ComposerActivity$7
  implements CompoundButton.OnCheckedChangeListener
{
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ComposerActivity localComposerActivity = this.a;
    FacebookPlace localFacebookPlace;
    FacebookEvent localFacebookEvent;
    if (paramBoolean)
    {
      localFacebookPlace = ComposerActivity.o(this.a);
      ComposerActivity.a(localComposerActivity, localFacebookPlace);
      this.a.l();
      if (ComposerActivity.p(this.a))
      {
        localFacebookEvent = ComposerActivity.o(this.a).c();
        if (!paramBoolean)
          break label116;
        ComposerActivity.k(this.a).c(localFacebookEvent);
      }
    }
    while (true)
    {
      LinearLayout localLinearLayout = (LinearLayout)this.a.findViewById(2131296528);
      ComposerActivity.a(this.a, localLinearLayout);
      this.a.A();
      ComposerActivity.b(this.a, true);
      return;
      localFacebookPlace = null;
      break;
      label116: ComposerActivity.k(this.a).b(localFacebookEvent);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerActivity.7
 * JD-Core Version:    0.6.0
 */