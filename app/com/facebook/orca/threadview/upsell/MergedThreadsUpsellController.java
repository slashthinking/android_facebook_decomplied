package com.facebook.orca.threadview.upsell;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import com.facebook.contacts.models.ContactSummary;
import com.facebook.contacts.models.ContactUtils;
import com.facebook.contacts.models.entry.PhoneEntry;
import com.facebook.contacts.protocol.ContactClaimFormatHelper;
import com.facebook.contacts.server.CreateContactClaimParams;
import com.facebook.contacts.server.DeleteContactClaimParams;
import com.facebook.contacts.server.PrivacyParam;
import com.facebook.orca.annotations.IsMergeThreadsEnabled;
import com.facebook.orca.common.dialogs.ErrorDialogBuilder;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.DialogBasedProgressIndicator;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserKey;
import com.facebook.widget.ConfirmationView;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Provider;

public class MergedThreadsUpsellController
{
  private final Context a;
  private final LoaderManager b;
  private final Provider<Boolean> c;
  private final ContactClaimFormatHelper d;
  private final OrcaServiceOperationFactory e;
  private final ContactUtils f;
  private final ConfirmationView g;
  private ListenableFuture<OperationResult> h;
  private ListenableFuture<OperationResult> i;
  private ThreadSummary j;
  private String k;
  private String l;
  private ContactSummary m;

  public MergedThreadsUpsellController(Context paramContext, LoaderManager paramLoaderManager, ConfirmationView paramConfirmationView)
  {
    this.a = paramContext;
    this.b = paramLoaderManager;
    FbInjector localFbInjector = FbInjector.a(paramContext);
    this.c = localFbInjector.b(Boolean.class, IsMergeThreadsEnabled.class);
    this.d = ((ContactClaimFormatHelper)localFbInjector.a(ContactClaimFormatHelper.class));
    this.e = ((OrcaServiceOperationFactory)localFbInjector.a(OrcaServiceOperationFactory.class));
    this.f = ((ContactUtils)localFbInjector.a(ContactUtils.class));
    this.g = paramConfirmationView;
  }

  private void a()
  {
    this.g.setVisibility(0);
    this.g.setListener(new MergedThreadsUpsellController.2(this));
  }

  private void a(ServiceException paramServiceException)
  {
    ErrorDialogBuilder.a(this.a).a(2131362339).b(2131362714).a();
  }

  private void a(OperationResult paramOperationResult)
  {
    this.g.setMessage("Now you can talk with " + this.k + " in one place over SMS or Facebook.");
    this.g.setNegativeButtonTitle("Undo");
    this.g.setPositiveButtonTitle("OK");
    this.g.setVisibility(0);
    this.g.setListener(new MergedThreadsUpsellController.5(this));
  }

  private void a(String paramString1, String paramString2)
  {
    this.b.a(1, null, new MergedThreadsUpsellController.1(this, paramString1, paramString2));
  }

  private void b()
  {
    if (this.h != null);
    while (true)
    {
      return;
      String str = this.d.a(this.l, 1);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("createContactClaimParams", new CreateContactClaimParams(this.m.getContactId(), this.m.getGraphApiWriteId(), str, PrivacyParam.b));
      OrcaServiceOperationFactory.OrcaServiceOperation localOrcaServiceOperation = this.e.a("create_contact_claim", localBundle);
      localOrcaServiceOperation.a(new DialogBasedProgressIndicator(this.a, 2131362449));
      this.h = localOrcaServiceOperation.d();
      Futures.a(this.h, new MergedThreadsUpsellController.3(this));
    }
  }

  private void c()
  {
    if (this.i != null);
    while (true)
    {
      return;
      PhoneEntry localPhoneEntry = this.f.a(this.m.getContactId(), this.l);
      if (localPhoneEntry == null)
        continue;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("deleteContactClaimParams", new DeleteContactClaimParams(localPhoneEntry.getGraphApiWriteId(), this.m.getGraphApiWriteId(), this.m.getContactId()));
      OrcaServiceOperationFactory.OrcaServiceOperation localOrcaServiceOperation = this.e.a("delete_contact_claim", localBundle);
      localOrcaServiceOperation.a(new DialogBasedProgressIndicator(this.a, 2131362450));
      this.i = localOrcaServiceOperation.d();
      Futures.a(this.i, new MergedThreadsUpsellController.4(this));
    }
  }

  private void d()
  {
    this.g.setVisibility(8);
  }

  public void a(ThreadSummary paramThreadSummary)
  {
    if (paramThreadSummary == this.j);
    do
    {
      return;
      this.j = paramThreadSummary;
    }
    while ((!((Boolean)this.c.b()).booleanValue()) || (!MessagingIdUtil.g(this.j.a())) || (!this.j.g()));
    UserKey localUserKey = this.j.h();
    if (localUserKey.a() == User.Type.PHONE_NUMBER);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.k = this.j.a(localUserKey).f();
      this.l = localUserKey.b();
      a(this.l, this.k);
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.upsell.MergedThreadsUpsellController
 * JD-Core Version:    0.6.0
 */