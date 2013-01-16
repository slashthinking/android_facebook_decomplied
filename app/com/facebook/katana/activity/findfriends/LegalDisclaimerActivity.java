package com.facebook.katana.activity.findfriends;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.util.GrowthUtils;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;

public class LegalDisclaimerActivity extends BaseFacebookActivity
  implements NotNewNavEnabled
{
  private Button n;

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903196);
    this.n = ((Button)findViewById(2131296844));
    LegalDisclaimerActivity.1 local1 = new LegalDisclaimerActivity.1(this);
    this.n.setOnClickListener(local1);
    a(TitleBarButtonSpec.newBuilder().b(getString(2131362848)).i());
    if (GrowthUtils.a().c(this))
    {
      ((LinearLayout)findViewById(2131296847)).setVisibility(0);
      findViewById(2131296845).setVisibility(8);
      ((Button)findViewById(2131296848)).setOnClickListener(new LegalDisclaimerActivity.2(this, Uri.parse(Constants.URL.n(this))));
    }
  }

  public String i()
  {
    return getString(2131363374);
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 1:
    }
    for (Object localObject = super.onCreateDialog(paramInt); ; localObject = new AlertDialog.Builder(this).setCancelable(true).setMessage(2131363401).setPositiveButton(2131361888, new LegalDisclaimerActivity.3(this)).create())
      return localObject;
  }

  public void titleBarPrimaryActionClickHandler(View paramView)
  {
    GrowthUtils.a().g(this);
    setResult(0);
    finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.LegalDisclaimerActivity
 * JD-Core Version:    0.6.0
 */