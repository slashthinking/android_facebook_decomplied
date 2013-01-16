package com.facebook.orca.mutators;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.orca.activity.ConfirmActionActivity;
import com.facebook.orca.activity.ConfirmActionParams;
import com.facebook.orca.activity.ConfirmActionParams.ButtonStyle;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.dialogs.ErrorDialogBuilder;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.DialogBasedProgressIndicator;
import com.facebook.orca.ops.OrcaServiceFragment;
import com.facebook.orca.ops.OrcaServiceOperation.State;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.RemoveMemberParams;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.Name;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserKey;

public class RemoveMemberActivity extends ConfirmActionActivity
  implements AnalyticsActivity
{
  private DataCache n;
  private ThreadSummary o;
  private User p;
  private OrcaServiceFragment q;

  private void a(ServiceException paramServiceException)
  {
    ErrorDialogBuilder.a(this).a(2131362339).a(paramServiceException).a(this).a();
  }

  private void a(OperationResult paramOperationResult)
  {
    finish();
  }

  private ConfirmActionParams l()
  {
    ConfirmActionParams localConfirmActionParams = new ConfirmActionParams();
    localConfirmActionParams.a(getString(2131362506));
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.p.d().d();
    localConfirmActionParams.b(getString(2131362507, arrayOfObject));
    localConfirmActionParams.c(getString(2131362508));
    localConfirmActionParams.a(ConfirmActionParams.ButtonStyle.DELETE);
    return localConfirmActionParams;
  }

  private void m()
  {
    if (this.q.b() != OrcaServiceOperation.State.INIT);
    while (true)
    {
      return;
      RemoveMemberParams localRemoveMemberParams = new RemoveMemberParams(this.o.a(), this.p.b());
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("removeMemberParams", localRemoveMemberParams);
      this.q.a("remove_member", localBundle);
    }
  }

  public String a()
  {
    return "remove_member";
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.n = ((DataCache)C().a(DataCache.class));
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("threadid");
    UserKey localUserKey = UserKey.a(localIntent.getStringExtra("user_key"));
    this.o = this.n.b(str);
    this.p = this.n.a(localUserKey);
    if ((this.o == null) || (this.p == null))
      finish();
    while (true)
    {
      return;
      a(l());
      this.q = OrcaServiceFragment.a(this, "removeMemberOperation");
      this.q.a(new RemoveMemberActivity.1(this));
      this.q.a(new DialogBasedProgressIndicator(this, 2131362509));
    }
  }

  protected void i()
  {
    m();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mutators.RemoveMemberActivity
 * JD-Core Version:    0.6.0
 */