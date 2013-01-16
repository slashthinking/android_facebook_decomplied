package com.facebook.katana.features.uberbar;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class UberbarActivity$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (UberbarActivity.a(this.a).getText().length() > 0)
      UberbarActivity.a(this.a).setText("");
    while (true)
    {
      return;
      UberbarActivity.b(this.a).hideSoftInputFromWindow(UberbarActivity.a(this.a).getWindowToken(), 0);
      this.a.finish();
      this.a.overridePendingTransition(2130968586, 2130968591);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberbarActivity.1
 * JD-Core Version:    0.6.0
 */