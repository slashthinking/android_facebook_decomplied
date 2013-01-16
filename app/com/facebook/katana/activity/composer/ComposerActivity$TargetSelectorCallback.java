package com.facebook.katana.activity.composer;

import android.content.Intent;
import android.widget.TextView;
import com.facebook.katana.view.composer.ComposerAudienceSelectorButton;

class ComposerActivity$TargetSelectorCallback
{
  private ComposerActivity$TargetSelectorCallback(ComposerActivity paramComposerActivity)
  {
  }

  private void a(Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("extra_target_profile", -1L);
    if (l != -1L)
      ComposerActivity.b(this.a, l);
  }

  private void a(Intent paramIntent, int paramInt)
  {
    TextView localTextView = (TextView)this.a.findViewById(2131296541);
    String str = paramIntent.getStringExtra("extra_target_name");
    localTextView.setText(this.a.getString(paramInt, new Object[] { str }));
  }

  void a(int paramInt, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("post_target", 0);
    ComposerActivity.a(this.a, TargetSelectorActivity.Target.values()[i]);
    switch (ComposerActivity.35.e[ComposerActivity.x(this.a).ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return;
      ComposerActivity.i(this.a).setVisibility(0);
      a(paramIntent, 2131363225);
      continue;
      a(paramIntent);
      ComposerActivity.i(this.a).setVisibility(8);
      a(paramIntent, 2131363227);
      continue;
      a(paramIntent);
      ComposerActivity.i(this.a).setVisibility(8);
      a(paramIntent, 2131363229);
      continue;
      a(paramIntent);
      ComposerActivity.i(this.a).setVisibility(8);
      a(paramIntent, 2131363231);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerActivity.TargetSelectorCallback
 * JD-Core Version:    0.6.0
 */