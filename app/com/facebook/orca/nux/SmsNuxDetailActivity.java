package com.facebook.orca.nux;

import android.os.Bundle;
import android.widget.Button;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.common.ui.titlebar.FbTitleBarUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;

public class SmsNuxDetailActivity extends FbFragmentActivity
{
  private OrcaSharedPreferences n;

  private void i()
  {
    finish();
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903385);
    this.n = ((OrcaSharedPreferences)C().a(OrcaSharedPreferences.class));
    FbTitleBarUtil.a(this);
    ((FbTitleBar)f(2131296299)).setTitle(2131362037);
    ((Button)f(2131297378)).setOnClickListener(new SmsNuxDetailActivity.1(this));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.nux.SmsNuxDetailActivity
 * JD-Core Version:    0.6.0
 */