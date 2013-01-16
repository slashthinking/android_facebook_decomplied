package com.facebook.orca.creation;

import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.activity.CheckBeforeLeaveActivity;
import com.facebook.orca.activity.CheckBeforeLeaveActivity.LeaveCheckListener;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.annotations.ForAddressBook;
import com.facebook.orca.annotations.ForFacebookList;
import com.facebook.orca.annotations.ForMergedComposer;
import com.facebook.orca.annotations.IsClientSmsEnabled;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.cache.SendMessageManager;
import com.facebook.orca.common.dialogs.ErrorDialogBuilder;
import com.facebook.orca.common.ui.overlay.OverlayLayout;
import com.facebook.orca.common.ui.titlebar.FbTitleBarUtil;
import com.facebook.orca.common.ui.widgets.CreateThreadCustomLayout;
import com.facebook.orca.compose.ComposeFragment;
import com.facebook.orca.compose.ComposeMode;
import com.facebook.orca.compose.LocationDisabledNuxView;
import com.facebook.orca.compose.LocationNuxController;
import com.facebook.orca.compose.LocationNuxView;
import com.facebook.orca.contacts.picker.ContactPickerFragment;
import com.facebook.orca.contacts.picker.ContactPickerListFilter;
import com.facebook.orca.contacts.picker.ContactPickerListFilter.RowCreator;
import com.facebook.orca.contacts.picker.IContactPickerViewListAdapter;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.intents.MessagingIntents;
import com.facebook.orca.ops.DialogBasedProgressIndicator;
import com.facebook.orca.ops.OrcaServiceFragment;
import com.facebook.orca.ops.OrcaServiceOperation.State;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.prefs.UiCounters;
import com.facebook.orca.presence.PresenceManager;
import com.facebook.orca.server.CreateThreadParams;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.FetchThreadParams;
import com.facebook.orca.server.FetchThreadParamsBuilder;
import com.facebook.orca.server.FetchThreadResult;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.ThreadCriteria;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessageBuilder;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threadview.ThreadViewActivity;
import com.facebook.orca.threadview.ThreadViewUtil;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserIdentifier;
import com.facebook.orca.users.UserIdentifier.IdentifierType;
import com.facebook.orca.users.UserKey;
import com.facebook.orca.users.UserWithIdentifier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import javax.inject.Provider;

public class CreateThreadActivity extends FbFragmentActivity
  implements AnalyticsActivity, CheckBeforeLeaveActivity
{
  public static int p;
  public static int q;
  public static int r;
  public static String s;
  private static final Class<?> t = CreateThreadActivity.class;
  private OverlayLayout A;
  private CreateThreadCustomLayout B;
  private LocationNuxController C;
  private LocationNuxView D;
  private LocationDisabledNuxView E;
  private OrcaServiceFragment F;
  private OrcaServiceFragment G;
  private ContactPickerFragment H;
  private ComposeFragment I;
  private ThreadViewUtil J;
  private Message K;
  private ImmutableList<UserWithIdentifier> L;
  private ContactPickerListFilter.RowCreator M;
  private String N;
  private boolean O;
  boolean n;
  boolean o;
  private FragmentManager u;
  private SendMessageManager v;
  private DataCache w;
  private PresenceManager x;
  private Provider<Boolean> y;
  private AnalyticsLogger z;

  static
  {
    p = 0;
    q = 1;
    r = 2;
  }

  private void a(View paramView1, View paramView2)
  {
    BLog.a(t, "onContactPickerFocusChanged");
    ViewParent localViewParent;
    if (paramView2 != null)
      localViewParent = paramView2.getParent();
    while (true)
    {
      if (localViewParent != null)
      {
        if (localViewParent != this.H.A())
          break label42;
        n();
      }
      while (true)
      {
        return;
        localViewParent = null;
        break;
        label42: if (localViewParent != this.I.A())
          break label60;
        p();
      }
      label60: localViewParent = localViewParent.getParent();
    }
  }

  private void a(ServiceException paramServiceException)
  {
    r();
  }

  private void a(OperationResult paramOperationResult)
  {
    ThreadSummary localThreadSummary = ((FetchThreadResult)paramOperationResult.h()).a();
    if (localThreadSummary != null)
      a(localThreadSummary);
    while (true)
    {
      return;
      r();
    }
  }

  private void a(Message paramMessage)
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("create_thread").f(paramMessage.a()).d(a()).b("thread", paramMessage.b()).b("trigger", this.N);
    this.z.a(localHoneyClientEvent);
  }

  private void a(ThreadSummary paramThreadSummary)
  {
    String str = paramThreadSummary.a();
    this.I.c(str);
    Message localMessage = new MessageBuilder().a(this.K).b(paramThreadSummary.a()).v();
    this.v.a(localMessage, a(), this.N);
    if (!this.O)
    {
      Intent localIntent = new Intent(this, ThreadViewActivity.class);
      localIntent.putExtra("thread_id", str);
      startActivity(localIntent);
    }
    setResult(-1);
    finish();
  }

  private void b(ServiceException paramServiceException)
  {
    ErrorDialogBuilder.a(this).a(2131362339).b(2131362539).a(paramServiceException).a();
  }

  private void b(OperationResult paramOperationResult)
  {
    setResult(-1);
    finish();
    String str = ((FetchThreadResult)paramOperationResult.h()).a().a();
    this.I.c(str);
    if (!this.O)
    {
      Intent localIntent = new Intent(this, ThreadViewActivity.class);
      localIntent.putExtra("thread_id", str);
      startActivity(localIntent);
      overridePendingTransition(2130968576, 2130968577);
    }
  }

  private boolean j()
  {
    if ((getIntent().getBooleanExtra(s, false)) && (((Boolean)this.y.b()).booleanValue()));
    for (int i = 1; ; i = 0)
      return i;
  }

  private ContactPickerListFilter.RowCreator k()
  {
    if (this.M == null)
      this.M = new CreateThreadActivity.5(this);
    return this.M;
  }

  private void l()
  {
    FbInjector localFbInjector = C();
    Object localObject1;
    Object localObject2;
    if ((j()) && (this.H.c() == null))
    {
      IContactPickerViewListAdapter localIContactPickerViewListAdapter3 = (IContactPickerViewListAdapter)localFbInjector.a(IContactPickerViewListAdapter.class, ForMergedComposer.class);
      String str3 = getString(2131362523);
      localObject1 = localIContactPickerViewListAdapter3;
      localObject2 = str3;
    }
    while (true)
    {
      ((IContactPickerViewListAdapter)localObject1).d().a(k());
      this.H.a((IContactPickerViewListAdapter)localObject1);
      this.H.a((String)localObject2);
      return;
      if (this.o)
      {
        IContactPickerViewListAdapter localIContactPickerViewListAdapter2 = (IContactPickerViewListAdapter)localFbInjector.a(IContactPickerViewListAdapter.class, ForAddressBook.class);
        String str2 = getString(2131362523);
        localObject1 = localIContactPickerViewListAdapter2;
        localObject2 = str2;
        continue;
      }
      IContactPickerViewListAdapter localIContactPickerViewListAdapter1 = (IContactPickerViewListAdapter)localFbInjector.a(IContactPickerViewListAdapter.class, ForFacebookList.class);
      String str1 = getString(2131362522);
      localObject1 = localIContactPickerViewListAdapter1;
      localObject2 = str1;
    }
  }

  private void m()
  {
    this.H.a(new CreateThreadActivity.6(this));
  }

  private void n()
  {
    if (!this.n);
    while (true)
    {
      return;
      this.H.a(ComposeMode.SHRUNK);
      this.I.a(ComposeMode.SHRUNK);
      this.C.a(ComposeMode.SHRUNK);
      this.B.setComposeMode(ComposeMode.SHRUNK);
      this.n = false;
      this.A.requestLayout();
    }
  }

  private void o()
  {
    if (this.o);
    while (true)
    {
      return;
      this.o = true;
      this.I.a(this.o);
    }
  }

  private void p()
  {
    if (this.n);
    while (true)
    {
      return;
      this.I.a(ComposeMode.EXPANDED);
      this.H.a(ComposeMode.EXPANDED);
      this.C.a(ComposeMode.EXPANDED);
      this.B.setComposeMode(ComposeMode.EXPANDED);
      this.n = true;
      this.A.requestLayout();
    }
  }

  private void q()
  {
    if ((this.G.b() != OrcaServiceOperation.State.INIT) || (this.F.b() != OrcaServiceOperation.State.INIT));
    while (true)
    {
      return;
      this.L = this.H.a();
      if (this.L.isEmpty())
      {
        if (((Boolean)this.y.b()).booleanValue());
        for (int j = 2131362537; ; j = 2131362536)
        {
          ErrorDialogBuilder.a(this).a(2131362339).b(j).a();
          break;
        }
      }
      if (!this.I.L())
        break;
      ErrorDialogBuilder.a(this).a(2131362339).b(2131362538).a();
    }
    this.K = this.I.d();
    this.C.a();
    User localUser;
    if (this.L.size() == 1)
    {
      localUser = ((UserWithIdentifier)this.L.get(0)).a();
      if (localUser.h() == null);
    }
    for (UserKey localUserKey = localUser.c(); ; localUserKey = null)
    {
      if (!this.O);
      for (int i = 1; ; i = 0)
      {
        if ((localUserKey == null) || (i == 0))
          break label293;
        ThreadSummary localThreadSummary = this.w.c(localUserKey);
        if (localThreadSummary == null)
          break label234;
        a(localThreadSummary);
        break;
      }
      label234: FetchThreadParams localFetchThreadParams = new FetchThreadParamsBuilder().a(DataFreshnessParam.STALE_DATA_OKAY).a(ThreadCriteria.a(localUserKey)).h();
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("fetchThreadParams", localFetchThreadParams);
      this.F.a("fetch_thread", localBundle);
      break;
      label293: r();
      break;
    }
  }

  private void r()
  {
    CreateThreadParams localCreateThreadParams = new CreateThreadParams(null, this.K, this.L);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("createThreadParams", localCreateThreadParams);
    this.G.a("create_thread", localBundle);
    a(this.K);
  }

  public String a()
  {
    return "create_thread";
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903334);
    FbInjector localFbInjector = C();
    this.u = ((FragmentManager)localFbInjector.a(FragmentManager.class));
    this.v = ((SendMessageManager)localFbInjector.a(SendMessageManager.class));
    this.w = ((DataCache)localFbInjector.a(DataCache.class));
    this.x = ((PresenceManager)localFbInjector.a(PresenceManager.class));
    this.y = localFbInjector.b(Boolean.class, IsClientSmsEnabled.class);
    this.z = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.J = ((ThreadViewUtil)localFbInjector.a(ThreadViewUtil.class));
    this.A = ((OverlayLayout)f(2131297247));
    this.D = ((LocationNuxView)f(2131297251));
    this.E = ((LocationDisabledNuxView)f(2131297252));
    this.B = ((CreateThreadCustomLayout)f(2131297248));
    FbTitleBarUtil.a(this);
    this.C = new LocationNuxController((UiCounters)localFbInjector.a(UiCounters.class));
    this.C.a(this.D, this.E);
    int i = p;
    Intent localIntent = getIntent();
    UserWithIdentifier localUserWithIdentifier2;
    int j;
    if (paramBundle == null)
    {
      Parcelable localParcelable = localIntent.getParcelableExtra("to");
      if (localParcelable != null)
        if ((localParcelable instanceof UserWithIdentifier))
        {
          localUserWithIdentifier2 = (UserWithIdentifier)localParcelable;
          j = localIntent.getIntExtra("threadType", p);
        }
    }
    for (UserWithIdentifier localUserWithIdentifier1 = localUserWithIdentifier2; ; localUserWithIdentifier1 = null)
    {
      this.O = localIntent.getBooleanExtra("disable_redirect_to_thread_view", false);
      getWindow().getDecorView().getViewTreeObserver().addOnGlobalFocusChangeListener(new CreateThreadActivity.1(this));
      this.F = OrcaServiceFragment.a(this, "fetchCanonicalThread");
      this.F.a(new CreateThreadActivity.2(this));
      this.F.a(new DialogBasedProgressIndicator(this, 2131362535));
      this.G = OrcaServiceFragment.a(this, "createThreadUiOperation");
      this.G.a(new CreateThreadActivity.3(this));
      this.G.a(new DialogBasedProgressIndicator(this, 2131362535));
      this.H = ((ContactPickerFragment)this.u.a(2131297249));
      this.I = ((ComposeFragment)this.u.a(2131297250));
      UserIdentifier.IdentifierType localIdentifierType;
      if (localUserWithIdentifier1 != null)
      {
        if (localIntent.getBooleanExtra("disableContactPicker", false))
          this.H.d();
        localIdentifierType = localUserWithIdentifier1.b().e();
        if (localIdentifierType == UserIdentifier.IdentifierType.PHONE)
          o();
      }
      while (true)
      {
        m();
        l();
        this.I.a(this.C);
        this.I.a(new CreateThreadActivity.4(this));
        if (localUserWithIdentifier1 != null)
          this.H.a(localUserWithIdentifier1);
        this.I.a(MessagingIntents.a(getIntent()));
        return;
        BLog.d(t, "\"to\" extra is not of expected type, ignoring");
        localUserWithIdentifier2 = null;
        break;
        if (localIdentifierType != UserIdentifier.IdentifierType.FBID)
          continue;
        this.I.b(true);
        continue;
        this.I.b(false);
        if (j != r)
          continue;
        o();
      }
      j = i;
    }
  }

  public void a(CheckBeforeLeaveActivity.LeaveCheckListener paramLeaveCheckListener)
  {
    if (this.I.L())
      paramLeaveCheckListener.a(true);
    while (true)
    {
      return;
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
      localBuilder.setTitle(2131362544);
      localBuilder.setMessage(2131362545);
      localBuilder.setNegativeButton(2131362546, new CreateThreadActivity.7(this, paramLeaveCheckListener));
      localBuilder.setPositiveButton(2131362547, new CreateThreadActivity.8(this, paramLeaveCheckListener));
      localBuilder.show();
    }
  }

  public void onBackPressed()
  {
    if (this.I.L())
      finish();
    a(new CreateThreadActivity.9(this));
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (paramBundle.getBoolean("composingSmsThread"))
      o();
    if (paramBundle.getBoolean("composeExpanded"))
      p();
    this.K = ((Message)paramBundle.getParcelable("outgoingMessage"));
    ArrayList localArrayList = paramBundle.getParcelableArrayList("pickedUsers");
    if (localArrayList != null)
      this.L = ImmutableList.a(localArrayList);
    String str = paramBundle.getString("trigger");
    if (str != null)
      this.N = str;
  }

  protected void onResume()
  {
    super.onResume();
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      if (MessagingIntents.a(localIntent, "focus_compose", false))
      {
        p();
        this.I.A().requestFocus();
      }
      String str = MessagingIntents.a(localIntent, "trigger");
      if (str != null)
      {
        this.z.a(new HoneyClientEvent("show_module").d(a()).h(e()).b("trigger", str));
        this.N = str;
      }
    }
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("composeExpanded", this.n);
    paramBundle.putBoolean("composingSmsThread", this.o);
    paramBundle.putParcelable("outgoingMessage", this.K);
    if (this.L != null)
      paramBundle.putParcelableArrayList("pickedUsers", Lists.a(this.L));
    if (this.N != null)
      paramBundle.putString("trigger", this.N);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.creation.CreateThreadActivity
 * JD-Core Version:    0.6.0
 */