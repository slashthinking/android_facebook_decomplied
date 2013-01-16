package com.facebook.katana;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class FeedComposerActivity$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    EditText localEditText = (EditText)this.a.findViewById(2131296697);
    ((InputMethodManager)this.a.getSystemService("input_method")).showSoftInput(localEditText, 0);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.FeedComposerActivity.1
 * JD-Core Version:    0.6.0
 */