package com.facebook.katana;

import android.os.Handler;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.platform.FacebookAuthenticationService;

class SyncContactsSetupActivity$AddAccountUserTask extends UserTask
{
  private final AppSession b;
  private final String c;
  private final boolean d;
  private final boolean e;

  public SyncContactsSetupActivity$AddAccountUserTask(SyncContactsSetupActivity paramSyncContactsSetupActivity, AppSession paramAppSession, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(new Handler());
    this.b = paramAppSession;
    this.c = paramAppSession.b().username;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
  }

  protected void a()
  {
    FacebookAuthenticationService.a(this.a, this.c, this.d, this.e);
    if (SyncContactsSetupActivity.a(this.a))
      FacebookAuthenticationService.a(this.a.getIntent(), this.c);
  }

  protected void b()
  {
    this.b.e(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.SyncContactsSetupActivity.AddAccountUserTask
 * JD-Core Version:    0.6.0
 */