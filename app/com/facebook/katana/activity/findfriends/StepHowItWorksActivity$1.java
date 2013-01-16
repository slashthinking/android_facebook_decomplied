package com.facebook.katana.activity.findfriends;

import android.content.Intent;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.IntentUriHandler;

class StepHowItWorksActivity$1 extends ClickableSpan
{
  public void onClick(View paramView)
  {
    Intent localIntent = IntentUriHandler.a(this.a, Constants.URL.o(this.a));
    this.a.startActivity(localIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.StepHowItWorksActivity.1
 * JD-Core Version:    0.6.0
 */