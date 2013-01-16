package com.facebook.orca.mutators;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.orca.activity.ConfirmActionActivity;
import com.facebook.orca.activity.ConfirmActionParams;
import com.facebook.orca.activity.ConfirmActionParams.ButtonStyle;
import com.facebook.orca.cache.SendMessageManager;
import com.facebook.orca.common.dialogs.ErrorDialogBuilder;
import com.facebook.orca.common.dialogs.ErrorMessageGenerator;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.DialogBasedProgressIndicator;
import com.facebook.orca.ops.OrcaServiceFragment;
import com.facebook.orca.ops.OrcaServiceOperation.State;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.DeleteMessagesParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.threads.Message;
import com.google.common.collect.ImmutableSet;

public class ResendMessageActivity extends ConfirmActionActivity
  implements AnalyticsActivity
{
  private SendMessageManager n;
  private ErrorMessageGenerator o;
  private OrcaServiceFragment p;
  private Message q;

  private void a(ServiceException paramServiceException)
  {
    ErrorDialogBuilder.a(this).a(2131362339).a(paramServiceException).a(this).a();
  }

  private void a(OperationResult paramOperationResult)
  {
    finish();
  }

  private void l()
  {
    if (this.p.b() != OrcaServiceOperation.State.INIT);
    while (true)
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("deleteMessagesParams", new DeleteMessagesParams(this.q.b(), ImmutableSet.b(this.q.a())));
      this.p.a("delete_messages", localBundle);
    }
  }

  public String a()
  {
    return "resend_message";
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    FbInjector localFbInjector = C();
    this.n = ((SendMessageManager)localFbInjector.a(SendMessageManager.class));
    this.o = ((ErrorMessageGenerator)localFbInjector.a(ErrorMessageGenerator.class));
    this.q = ((Message)getIntent().getParcelableExtra("message"));
    if (this.q == null)
      finish();
    while (true)
    {
      return;
      ServiceException localServiceException = this.n.b(this.q.b());
      String str1 = null;
      if (localServiceException != null)
        str1 = this.o.a(localServiceException, false, false);
      ConfirmActionParams localConfirmActionParams = new ConfirmActionParams();
      localConfirmActionParams.a(getString(2131362510));
      localConfirmActionParams.b(str1);
      localConfirmActionParams.c(getString(2131362511));
      localConfirmActionParams.b(ConfirmActionParams.ButtonStyle.DELETE);
      localConfirmActionParams.d(getString(2131362512));
      a(localConfirmActionParams);
      this.p = OrcaServiceFragment.a(this, "deleteMessagesOperation");
      this.p.a(new ResendMessageActivity.1(this));
      String str2 = getResources().getQuantityString(2131427355, 1);
      this.p.a(new DialogBasedProgressIndicator(this, str2));
    }
  }

  protected void i()
  {
    this.n.a(this.q);
    finish();
  }

  protected void j()
  {
    l();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mutators.ResendMessageActivity
 * JD-Core Version:    0.6.0
 */