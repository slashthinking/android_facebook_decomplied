package com.facebook.orca.activity;

import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;

public abstract class ConfirmActionActivity extends FbFragmentActivity
{
  private TextView n;
  private TextView o;
  private Button p;
  private Button q;
  private Button r;

  protected void a(ConfirmActionParams paramConfirmActionParams)
  {
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.type = 1003;
    localWindow.setAttributes(localLayoutParams);
    localWindow.addFlags(131072);
    setContentView(2130903321);
    this.n = ((TextView)f(2131297209));
    this.o = ((TextView)f(2131297210));
    this.p = ((Button)f(2131297211));
    this.q = ((Button)f(2131297212));
    this.r = ((Button)f(2131297213));
    this.n.setText(paramConfirmActionParams.a());
    if (paramConfirmActionParams.b() != null)
    {
      this.o.setText(paramConfirmActionParams.b());
      this.p.setText(paramConfirmActionParams.c());
      if (paramConfirmActionParams.d() == null)
        break label215;
      this.q.setText(paramConfirmActionParams.d());
    }
    while (true)
    {
      this.p.setOnClickListener(new ConfirmActionActivity.1(this));
      this.q.setOnClickListener(new ConfirmActionActivity.2(this));
      this.r.setOnClickListener(new ConfirmActionActivity.3(this));
      return;
      this.o.setVisibility(8);
      break;
      label215: this.q.setVisibility(8);
    }
  }

  protected void i()
  {
  }

  protected void j()
  {
  }

  protected void k()
  {
    finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.activity.ConfirmActionActivity
 * JD-Core Version:    0.6.0
 */