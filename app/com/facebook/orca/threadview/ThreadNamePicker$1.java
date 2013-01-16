package com.facebook.orca.threadview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.facebook.orca.common.dialogs.ErrorDialogBuilder;
import com.facebook.orca.common.util.StringUtil;
import com.google.common.base.Objects;

class ThreadNamePicker$1
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str = ThreadNamePicker.a(this.a).getText().toString().trim();
    if (StringUtil.a(str))
      ErrorDialogBuilder.a(this.a.getContext()).a(2131362339).b(2131362631).a();
    do
    {
      return;
      ThreadNamePicker.b(this.a).hideSoftInputFromWindow(this.a.getWindow().getDecorView().getWindowToken(), 0);
      this.a.dismiss();
    }
    while (ThreadNamePicker.c(this.a) == null);
    if (Objects.equal(str, ThreadNamePicker.d(this.a)));
    for (ThreadNamePicker.Result localResult = ThreadNamePicker.Result.NO_CHANGE; ; localResult = ThreadNamePicker.Result.CHANGE)
    {
      ThreadNamePicker.c(this.a).a(localResult, str);
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadNamePicker.1
 * JD-Core Version:    0.6.0
 */