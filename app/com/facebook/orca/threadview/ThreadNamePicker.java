package com.facebook.orca.threadview;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.facebook.orca.common.util.StringUtil;

public class ThreadNamePicker extends AlertDialog
{
  private final String a;
  private InputMethodManager b;
  private ThreadNamePicker.Listener c;
  private EditText d;

  public ThreadNamePicker(Context paramContext, String paramString)
  {
    super(paramContext);
    this.b = ((InputMethodManager)paramContext.getSystemService("input_method"));
    this.a = StringUtil.c(paramString);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2130903412, null);
    setTitle(paramContext.getString(2131362628));
    setMessage(null);
    setView(localView);
    getWindow().setSoftInputMode(4);
    this.d = ((EditText)localView.findViewById(2131297478));
    this.d.setText(this.a);
    setButton(paramContext.getString(2131362629), new ThreadNamePicker.1(this));
    setButton2(paramContext.getString(2131362168), new ThreadNamePicker.2(this));
    if (!StringUtil.a(this.a))
      setButton3(paramContext.getString(2131362630), new ThreadNamePicker.3(this));
  }

  public void a(ThreadNamePicker.Listener paramListener)
  {
    this.c = paramListener;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadNamePicker
 * JD-Core Version:    0.6.0
 */