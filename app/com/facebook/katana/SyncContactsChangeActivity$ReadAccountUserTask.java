package com.facebook.katana;

import android.os.Handler;
import android.widget.TextView;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.platform.FacebookAuthenticationService;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;

class SyncContactsChangeActivity$ReadAccountUserTask extends UserTask
{
  private final String b;

  public SyncContactsChangeActivity$ReadAccountUserTask(SyncContactsChangeActivity paramSyncContactsChangeActivity)
  {
    super(new Handler());
    this.b = SyncContactsChangeActivity.a(paramSyncContactsChangeActivity).b().username;
  }

  protected void a()
  {
    SyncContactsChangeActivity.a(this.a, FacebookAuthenticationService.d(this.a, this.b));
    SyncContactsChangeActivity.b(this.a, FacebookAuthenticationService.c(this.a, this.b));
  }

  protected void b()
  {
    if (this.a.isFinishing())
      return;
    int i;
    if (SyncContactsChangeActivity.b(this.a))
      if (SyncContactsChangeActivity.c(this.a))
        i = 2131297851;
    while (true)
    {
      SyncContactsChangeActivity.a(this.a, i);
      if (i == 2131297857)
        this.a.a(TitleBarButtonSpec.newBuilder().b(this.a.getString(2131362910)).i());
      if (i == 2131297857)
        break;
      ((TextView)this.a.findViewById(2131297858)).setText(this.a.getString(2131363215));
      ((TextView)this.a.findViewById(2131297859)).setText(this.a.getString(2131363216));
      break;
      i = 2131297854;
      continue;
      i = 2131297857;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.SyncContactsChangeActivity.ReadAccountUserTask
 * JD-Core Version:    0.6.0
 */