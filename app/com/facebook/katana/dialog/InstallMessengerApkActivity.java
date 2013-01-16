package com.facebook.katana.dialog;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.util.logging.ActionEvent;
import com.facebook.katana.util.logging.MobileEventLogger;
import com.facebook.orca.common.util.IntentUtil;

public class InstallMessengerApkActivity extends BlackDialogActivity
{
  private static final Intent n = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.facebook.orca"));

  private void a(String paramString)
  {
    ActionEvent localActionEvent = new ActionEvent("action", paramString, "dialog", InstallMessengerApkActivity.class.getSimpleName(), 0L, 0L, null, null);
    MobileEventLogger.a().a(this, localActionEvent);
  }

  public static boolean a(Context paramContext)
  {
    if ((Boolean.TRUE.equals(Gatekeeper.a(paramContext, "fbandroid_messages_interstitial"))) && (InstallMessengerApkActivity.ShortcutGating.a(paramContext).b(paramContext)));
    for (int i = 1; ; i = 0)
      return i;
  }

  private void l()
  {
    InstallMessengerApkActivity.ShortcutGating.a(this).d(this);
    a("OPEN_ACTIVITY");
  }

  protected void a(Bundle paramBundle)
  {
    if (!IntentUtil.a(this, n))
      finish();
    a(new BlackDialogActivity.BlackDialogParameters().b(Integer.valueOf(2130837737)).b(getString(2131363183)).c(getString(2131362848)).a(getString(2131363181)).a(Integer.valueOf(2130903062)));
  }

  protected void i()
  {
    l();
    TextView localTextView = (TextView)f(2131296400);
    ((ImageView)f(2131296401)).setImageResource(2130838922);
    localTextView.setText(getString(2131363182));
  }

  protected void j()
  {
    a("CLICK");
    InstallMessengerApkActivity.ShortcutGating.a(this).c(this);
    startActivity(n);
    finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.dialog.InstallMessengerApkActivity
 * JD-Core Version:    0.6.0
 */