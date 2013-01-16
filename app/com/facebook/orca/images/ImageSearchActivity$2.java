package com.facebook.orca.images;

import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class ImageSearchActivity$2
  implements TextView.OnEditorActionListener
{
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    int i;
    if (paramInt != 2)
    {
      i = 0;
      if (paramKeyEvent != null)
      {
        int j = paramKeyEvent.getKeyCode();
        i = 0;
        if (j != 66);
      }
    }
    else
    {
      ImageSearchActivity.b(this.a).hideSoftInputFromWindow(ImageSearchActivity.a(this.a).getWindowToken(), 0);
      ImageSearchActivity.c(this.a);
      i = 1;
    }
    return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageSearchActivity.2
 * JD-Core Version:    0.6.0
 */