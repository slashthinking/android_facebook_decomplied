package com.facebook.katana.activity.media;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;

class CameraReviewActivity$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (CameraReviewActivity.a(this.a).getText().length() > 0)
      CameraReviewActivity.a(this.a).setText("");
    while (true)
    {
      return;
      CameraReviewActivity.b(this.a).setVisibility(8);
      ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(CameraReviewActivity.a(this.a).getWindowToken(), 0);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.CameraReviewActivity.1
 * JD-Core Version:    0.6.0
 */