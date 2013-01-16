package com.facebook.katana.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.facebook.orca.annotations.AuthNotRequired;
import java.util.HashMap;

@AuthNotRequired
public class NewUserRegistrationActivity extends BaseFacebookActivity
{
  private static final String r = NewUserRegistrationActivity.class.getSimpleName();
  private NewUserRegistrationActivity.ProgressSpinner n;
  private View o;
  private LinearLayout p;
  private HashMap<String, EditText> q = new HashMap();

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    FrameLayout localFrameLayout = new FrameLayout(this);
    this.n = new NewUserRegistrationActivity.ProgressSpinner(this);
    this.o = new View(this);
    this.o.setBackgroundResource(2130838357);
    this.p = new LinearLayout(this);
    this.p.setBackgroundResource(2130838357);
    this.p.setOrientation(1);
    this.p.setVisibility(8);
    localFrameLayout.addView(this.o);
    localFrameLayout.addView(this.p);
    setContentView(localFrameLayout);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.NewUserRegistrationActivity
 * JD-Core Version:    0.6.0
 */