package com.facebook.orca.nux;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.annotations.AppInitializationNotRequired;
import com.facebook.orca.annotations.AuthNotRequired;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.common.ui.titlebar.FbTitleBarUtil;
import com.facebook.orca.debug.BLog;

@AppInitializationNotRequired
@AuthNotRequired
public class LearnMoreActivity extends FbFragmentActivity
{
  private static final Class<?> n = LearnMoreActivity.class;

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    Intent localIntent = getIntent();
    if (localIntent.hasExtra("layout"))
      setContentView(localIntent.getIntExtra("layout", -1));
    while (true)
    {
      FbTitleBarUtil.a(this);
      ((FbTitleBar)findViewById(2131296299)).setTitle(2131362395);
      return;
      BLog.e(n, "No layout specified for learn more activity!");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.nux.LearnMoreActivity
 * JD-Core Version:    0.6.0
 */