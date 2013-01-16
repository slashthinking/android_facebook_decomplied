package com.facebook.katana.c2dm;

import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.AlertDialogs;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.orca.annotations.AuthNotRequired;
import java.util.Map;
import java.util.Set;

@AuthNotRequired
public class SystemTrayErrorNotificationPostActivity extends BaseFacebookActivity
{
  public static final Set<String> n = new SystemTrayErrorNotificationPostActivity.1();
  private static final Class<?> o = SystemTrayErrorNotificationPostActivity.class;
  private static final String p = o.getSimpleName();
  private final Map<String, SystemTrayErrorNotificationPostActivity.PostActivityDialog> q = new SystemTrayErrorNotificationPostActivity.2(this);

  private DialogInterface.OnClickListener i()
  {
    return new SystemTrayErrorNotificationPostActivity.3(this);
  }

  private void j()
  {
    SystemTrayErrorNotificationPostActivity.4 local4 = new SystemTrayErrorNotificationPostActivity.4(this);
    AlertDialogs.a(this, getResources().getString(2131363415), 17301624, getResources().getString(2131363416), getResources().getString(2131363417), local4, getResources().getString(2131362848), i(), null, false).show();
  }

  private void k()
  {
    AlertDialogs.a(this, getResources().getString(2131363418), 17301624, getResources().getString(2131363419), getResources().getString(2131361888), i(), null, null, null, false).show();
  }

  private void l()
  {
    SystemTrayErrorNotificationPostActivity.5 local5 = new SystemTrayErrorNotificationPostActivity.5(this);
    AlertDialogs.a(this, getResources().getString(2131363420), 17301624, getResources().getString(2131363421), getResources().getString(2131361888), local5, null, null, null, false).show();
  }

  private void m()
  {
    AlertDialogs.a(this, getResources().getString(2131363422), 17301624, getResources().getString(2131363423), getResources().getString(2131361888), i(), null, null, null, false).show();
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    String str = getIntent().getStringExtra("c2dm_error");
    SystemTrayErrorNotificationPostActivity.PostActivityDialog localPostActivityDialog = (SystemTrayErrorNotificationPostActivity.PostActivityDialog)this.q.get(str);
    if (localPostActivityDialog != null)
      localPostActivityDialog.a();
    while (true)
    {
      return;
      ErrorReporting.a(p, "Unrecognized C2DM error: " + str, null, true, 500000);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.c2dm.SystemTrayErrorNotificationPostActivity
 * JD-Core Version:    0.6.0
 */