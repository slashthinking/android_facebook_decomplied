package com.facebook.orca.images;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class ImageSearchActivity$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    ImageSearchActivity.b(this.a).hideSoftInputFromWindow(ImageSearchActivity.a(this.a).getWindowToken(), 0);
    ImageSearchActivity.c(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageSearchActivity.1
 * JD-Core Version:    0.6.0
 */