package com.facebook.orca.mutators;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.orca.activity.ConfirmActionActivity;
import com.facebook.orca.activity.ConfirmActionParams;
import com.facebook.orca.activity.ConfirmActionParams.ButtonStyle;
import com.facebook.orca.common.dialogs.ErrorDialogBuilder;
import com.facebook.orca.ops.DialogBasedProgressIndicator;
import com.facebook.orca.ops.OrcaServiceFragment;
import com.facebook.orca.ops.OrcaServiceOperation.State;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.DeleteMessagesParams;
import com.facebook.orca.server.OperationResult;
import com.google.common.collect.ImmutableSet;

public class DeleteMessagesActivity extends ConfirmActionActivity
  implements AnalyticsActivity
{
  private OrcaServiceFragment n;
  private String o;
  private ImmutableSet<String> p;

  private void a(ServiceException paramServiceException)
  {
    ErrorDialogBuilder.a(this).a(2131362339).a(paramServiceException).a(this).a();
  }

  private void a(OperationResult paramOperationResult)
  {
    finish();
  }

  private ConfirmActionParams c(int paramInt)
  {
    ConfirmActionParams localConfirmActionParams = new ConfirmActionParams();
    Resources localResources = getResources();
    localConfirmActionParams.a(localResources.getQuantityString(2131427352, paramInt));
    localConfirmActionParams.b(localResources.getQuantityString(2131427353, paramInt));
    localConfirmActionParams.c(localResources.getQuantityString(2131427354, paramInt));
    localConfirmActionParams.a(ConfirmActionParams.ButtonStyle.DELETE);
    return localConfirmActionParams;
  }

  private void l()
  {
    if (this.n.b() != OrcaServiceOperation.State.INIT);
    while (true)
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("deleteMessagesParams", new DeleteMessagesParams(this.o, this.p));
      this.n.a("delete_messages", localBundle);
    }
  }

  public String a()
  {
    return "delete_messages";
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    Intent localIntent = getIntent();
    this.o = localIntent.getStringExtra("thread_id");
    this.p = ImmutableSet.a(localIntent.getStringArrayListExtra("message_ids"));
    int i = this.p.size();
    a(c(i));
    this.n = OrcaServiceFragment.a(this, "deleteMessagesOperation");
    this.n.a(new DeleteMessagesActivity.1(this));
    String str = getResources().getQuantityString(2131427355, i);
    this.n.a(new DialogBasedProgressIndicator(this, str));
  }

  protected void i()
  {
    l();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mutators.DeleteMessagesActivity
 * JD-Core Version:    0.6.0
 */