package com.facebook.orca.mutators;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.common.dialogs.ErrorDialogBuilder;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.DialogBasedProgressIndicator;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.DeleteThreadParams;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

public class DeleteThreadDialogFragment extends DialogFragment
{
  private ListenableFuture<OperationResult> Y;
  private String Z;
  private OrcaServiceOperationFactory aa;
  private AnalyticsLogger ab;
  private Context ac;

  private void L()
  {
    if (this.Y != null);
    while (true)
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("deleteThreadParams", new DeleteThreadParams(this.Z));
      OrcaServiceOperationFactory.OrcaServiceOperation localOrcaServiceOperation = this.aa.a("delete_thread", localBundle);
      localOrcaServiceOperation.a(new DialogBasedProgressIndicator(p(), 2131362501));
      this.Y = localOrcaServiceOperation.d();
      M();
      Futures.a(this.Y, new DeleteThreadDialogFragment.3(this));
    }
  }

  private void M()
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("delete_thread");
    if ((l() instanceof AnalyticsActivity))
      localHoneyClientEvent.d(((AnalyticsActivity)l()).a());
    localHoneyClientEvent.b("thread_id", this.Z);
    this.ab.a(localHoneyClientEvent);
  }

  public static DeleteThreadDialogFragment a(String paramString)
  {
    DeleteThreadDialogFragment localDeleteThreadDialogFragment = new DeleteThreadDialogFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("threadId", paramString);
    localDeleteThreadDialogFragment.f(localBundle);
    return localDeleteThreadDialogFragment;
  }

  private void a(ServiceException paramServiceException)
  {
    if (this.ac == null);
    while (true)
    {
      return;
      ErrorDialogBuilder.a(this.ac).a(2131362339).a(paramServiceException).a(new DeleteThreadDialogFragment.4(this)).a();
    }
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.Z = m().getString("threadId");
    this.ac = p();
    FbInjector localFbInjector = FbInjector.a(this.ac);
    this.aa = ((OrcaServiceOperationFactory)localFbInjector.a(OrcaServiceOperationFactory.class));
    this.ab = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
  }

  public Dialog c(Bundle paramBundle)
  {
    return new AlertDialog.Builder(p()).setTitle(2131362498).setMessage(2131362499).setPositiveButton(2131362500, new DeleteThreadDialogFragment.2(this)).setNegativeButton(2131362168, new DeleteThreadDialogFragment.1(this)).create();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mutators.DeleteThreadDialogFragment
 * JD-Core Version:    0.6.0
 */