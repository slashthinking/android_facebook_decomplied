package com.facebook.katana.dialog;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.facebook.debug.Assert;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.service.autoupdate.AutoUpdateConstants;
import com.facebook.katana.util.StringUtils;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import java.io.File;

public class InstallNewBuildActivity extends BaseFacebookActivity
  implements NotNewNavEnabled
{
  private boolean n;

  private Intent j()
  {
    return new Intent("android.intent.action.DELETE", Uri.fromParts("package", getApplicationContext().getPackageName(), null));
  }

  private void k()
  {
    ((OrcaSharedPreferences)FbInjector.a(this).a(OrcaSharedPreferences.class)).b().a(AutoUpdateConstants.i).a();
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    String str1 = getIntent().getStringExtra("local_uri");
    Assert.a("local file cannot be null", str1);
    if (str1 == null)
    {
      finish();
      return;
    }
    Uri localUri = Uri.fromFile(new File(str1));
    setContentView(2130903251);
    findViewById(2131297018).setOnClickListener(new InstallNewBuildActivity.1(this, localUri));
    findViewById(2131297021).setOnClickListener(new InstallNewBuildActivity.2(this));
    View localView = findViewById(2131297019);
    String str2 = getIntent().getStringExtra("retry_uri");
    if (StringUtils.c(str2))
    {
      findViewById(2131297020).setVisibility(8);
      localView.setVisibility(8);
    }
    while (true)
    {
      this.n = getIntent().getBooleanExtra("no_cancel", false);
      if (this.n)
        break;
      a(TitleBarButtonSpec.newBuilder().b(getString(2131362848)).i());
      break;
      localView.setOnClickListener(new InstallNewBuildActivity.3(this, str2));
    }
  }

  public String i()
  {
    return getString(2131362967);
  }

  public void onBackPressed()
  {
    if (this.n);
    while (true)
    {
      return;
      k();
      super.onBackPressed();
    }
  }

  public void titleBarPrimaryActionClickHandler(View paramView)
  {
    if (this.n);
    while (true)
    {
      return;
      k();
      finish();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.dialog.InstallNewBuildActivity
 * JD-Core Version:    0.6.0
 */