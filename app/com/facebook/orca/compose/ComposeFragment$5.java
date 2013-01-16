package com.facebook.orca.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.orca.emoji.IEmojiKeyboardWindowControl;
import javax.inject.Provider;

class ComposeFragment$5
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (ComposeFragment.g(this.a))
    {
      ComposeFragment.b(this.a, "popup_dismiss_button");
      if (ComposeFragment.b(this.a) != null)
        ComposeFragment.b(this.a).a();
    }
    while (true)
    {
      return;
      ComposeFragment.h(this.a);
      continue;
      if (((Boolean)ComposeFragment.i(this.a).b()).booleanValue())
      {
        ComposeFragment.b(this.a, "popup_open_button");
        ComposeFragment.j(this.a);
        continue;
      }
      ComposeFragment.k(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.compose.ComposeFragment.5
 * JD-Core Version:    0.6.0
 */