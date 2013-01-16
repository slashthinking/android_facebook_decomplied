package com.facebook.orca.threadlist;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.contacts.annotations.IsContactsListEnabled;
import com.facebook.contacts.contactslist.ContactsListActivity;
import com.facebook.diagnostics.FPSSupport;
import com.facebook.orca.activity.DivebarEnabledActivity;
import com.facebook.orca.activity.ExportMenuToFbHostActivity;
import com.facebook.orca.activity.ExportMenuToFbHostActivity.CustomFbHostMenuItem;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.annotations.ShouldSkipContactImportNux;
import com.facebook.orca.app.OrcaActivityBroadcaster;
import com.facebook.orca.attachments.AudioRecorder;
import com.facebook.orca.audio.AudioClipPlayerQueue;
import com.facebook.orca.audio.VolumeControlStreamManager;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.ui.titlebar.DivebarController;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.common.ui.titlebar.FbTitleBarUtil;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import com.facebook.orca.common.ui.widgets.SlidingOutSuggestionView;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.contacts.upload.ContactsUploadRunner;
import com.facebook.orca.contacts.upload.ContactsUploadState;
import com.facebook.orca.contacts.upload.ContactsUploadState.Status;
import com.facebook.orca.database.AddressBookPeriodicRunner;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.intents.MessagingIntents;
import com.facebook.orca.notify.NotificationSettingsUtil;
import com.facebook.orca.nux.NuxFindingContactsIntroView;
import com.facebook.orca.nux.NuxFindingContactsView;
import com.facebook.orca.nux.NuxScrimView;
import com.facebook.orca.nux.NuxSmsIntroView;
import com.facebook.orca.nux.OrcaNuxManager;
import com.facebook.orca.nux.ThreadListNuxController;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.sms.MmsSmsLogger;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threadview.ThreadViewFragment;
import com.facebook.widget.ConfirmationView;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Provider;

@FPSSupport
public class ThreadListActivity extends FbFragmentActivity
  implements AnalyticsActivity, DivebarEnabledActivity, ExportMenuToFbHostActivity
{
  private static final Class<?> n = ThreadListActivity.class;
  private ConfirmationView A;
  private MuteGlobalWarningController B;
  private DivebarController C;
  private ContactsUploadRunner D;
  private LocalBroadcastManager E;
  private BroadcastReceiver F;
  private ThreadListNuxController G;
  private NuxFindingContactsView H;
  private NuxFindingContactsIntroView I;
  private NuxScrimView J;
  private NuxSmsIntroView K;
  private ThreadViewFragment L;
  private View M;
  private String N;
  private boolean O;
  private Provider<Boolean> o;
  private DataCache p;
  private AddressBookPeriodicRunner q;
  private AnalyticsLogger r;
  private VolumeControlStreamManager s;
  private AudioClipPlayerQueue t;
  private AudioRecorder u;
  private FbTitleBar v;
  private ThreadListFragment w;
  private VersionUpgradePromoView x;
  private SlidingOutSuggestionView y;
  private SyncDisabledWarningView z;

  private void a(ContactsUploadState paramContactsUploadState)
  {
    if (paramContactsUploadState.a() == ContactsUploadState.Status.FAILED)
    {
      this.A.setVisibility(0);
      this.z.setVisibility(8);
      this.y.setVisibility(8);
    }
    while (true)
    {
      return;
      this.A.setVisibility(8);
      this.z.setVisibility(0);
      this.z.a();
      if (this.z.b())
      {
        this.y.setVisibility(8);
        continue;
      }
      this.y.setVisibility(0);
    }
  }

  private void a(String paramString)
  {
    if (!r());
    while (true)
    {
      return;
      FragmentManager localFragmentManager = g();
      if (!localFragmentManager.c())
        continue;
      b(true);
      FragmentTransaction localFragmentTransaction = localFragmentManager.a();
      localFragmentTransaction.a(2130968603, 2130968604);
      localFragmentTransaction.c(this.L);
      localFragmentTransaction.b(this.w);
      localFragmentTransaction.a();
      localFragmentManager.b();
      this.L.d("threadListFragment");
      this.L.a(paramString);
      if (this.M != null)
        this.M.setVisibility(8);
      this.N = paramString;
      this.L.b(hasWindowFocus());
    }
  }

  private void b(String paramString)
  {
    if (paramString == null);
    while (true)
    {
      return;
      a(paramString);
    }
  }

  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.A.setVisibility(8);
      this.z.setVisibility(8);
      this.y.setVisibility(8);
    }
    while (true)
    {
      return;
      a(this.D.c());
    }
  }

  private void l()
  {
    this.v.setTitle(StringUtil.b(getString(2131362415)));
    this.v.setHasProgressBar(true);
    this.v.setHasBackButton(false);
    this.v.setCustomTitleView(null);
    TitleBarButtonSpec localTitleBarButtonSpec = TitleBarButtonSpec.newBuilder().a(1).a(getResources().getDrawable(2130838593)).i();
    this.v.setButtonSpecs(ImmutableList.a(localTitleBarButtonSpec));
    this.v.setOnToolbarButtonListener(new ThreadListActivity.6(this));
  }

  private void n()
  {
    this.C.a(this);
    this.M = f(2131297449);
    this.M.setVisibility(0);
    this.M.setOnClickListener(new ThreadListActivity.7(this));
    this.C.a(new ThreadListActivity.8(this));
  }

  private void o()
  {
    if (j());
    while (true)
    {
      return;
      if (this.G != null)
      {
        this.G.a(new ThreadListActivity.9(this));
        if (this.G.c())
        {
          setRequestedOrientation(1);
          continue;
        }
        setRequestedOrientation(-1);
        continue;
      }
      setRequestedOrientation(-1);
    }
  }

  private void p()
  {
    startActivity(new Intent(this, ContactsListActivity.class));
  }

  private void q()
  {
    this.N = null;
    FragmentManager localFragmentManager = g();
    if (!localFragmentManager.c());
    while (true)
    {
      return;
      FragmentTransaction localFragmentTransaction = localFragmentManager.a();
      localFragmentTransaction.a(2130968603, 2130968604);
      localFragmentTransaction.c(this.w);
      localFragmentTransaction.b(this.L);
      localFragmentTransaction.a();
      localFragmentManager.b();
      b(false);
      if (this.M != null)
        this.M.setVisibility(0);
      l();
      this.L.O();
    }
  }

  private boolean r()
  {
    int i;
    if (this.L != null)
      i = 1;
    while (true)
    {
      return i;
      FragmentManager localFragmentManager = g();
      this.L = ((ThreadViewFragment)localFragmentManager.a("threadViewFragment"));
      if (this.L != null)
        break;
      if (!localFragmentManager.c())
      {
        i = 0;
        continue;
      }
      this.L = new ThreadViewFragment();
      this.L.a(this.v);
      FragmentTransaction localFragmentTransaction = localFragmentManager.a();
      localFragmentTransaction.a(2131297447, this.L, "threadViewFragment");
      localFragmentTransaction.b(this.L);
      localFragmentTransaction.a();
      localFragmentManager.b();
    }
    while (true)
    {
      this.L.a(new ThreadListActivity.10(this));
      i = 1;
      break;
      this.L.a(this.v);
    }
  }

  private void s()
  {
    if (this.O)
      Looper.myQueue().addIdleHandler(new ThreadListActivity.11(this));
  }

  public String a()
  {
    return "thread_list";
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    BLog.b(n, "ThreadListActivity.onActivityCreate");
    if ((paramBundle != null) && (paramBundle.containsKey("selectedThreadId")));
    for (String str = paramBundle.getString("selectedThreadId"); ; str = null)
    {
      setContentView(2130903405);
      FbInjector localFbInjector = C();
      this.o = localFbInjector.b(Boolean.class, IsContactsListEnabled.class);
      this.p = ((DataCache)localFbInjector.a(DataCache.class));
      this.q = ((AddressBookPeriodicRunner)localFbInjector.a(AddressBookPeriodicRunner.class));
      this.r = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
      this.s = ((VolumeControlStreamManager)localFbInjector.a(VolumeControlStreamManager.class));
      this.t = ((AudioClipPlayerQueue)localFbInjector.a(AudioClipPlayerQueue.class));
      this.u = ((AudioRecorder)localFbInjector.a(AudioRecorder.class));
      this.C = ((DivebarController)localFbInjector.a(DivebarController.class));
      this.D = ((ContactsUploadRunner)localFbInjector.a(ContactsUploadRunner.class));
      this.E = ((LocalBroadcastManager)localFbInjector.a(LocalBroadcastManager.class));
      this.F = new ThreadListActivity.1(this);
      FbTitleBarUtil.a(this);
      this.v = ((FbTitleBar)f(2131296299));
      l();
      FragmentManager localFragmentManager = g();
      this.w = ((ThreadListFragment)localFragmentManager.a(2131297448));
      this.w.a(new ThreadListActivity.2(this));
      this.w.a(a());
      this.w.a(new ThreadListActivity.3(this));
      this.L = ((ThreadViewFragment)localFragmentManager.a("threadViewFragment"));
      if (this.L != null)
        this.L.a(this.v);
      if (MessagingIntents.a(getIntent(), "from_notification", false))
        this.w.a();
      this.x = ((VersionUpgradePromoView)f(2131297445));
      this.y = ((SlidingOutSuggestionView)f(2131297443));
      this.z = ((SyncDisabledWarningView)f(2131297444));
      this.A = ((ConfirmationView)f(2131297446));
      this.A.setListener(new ThreadListActivity.4(this));
      this.w.a(this.v);
      this.I = ((NuxFindingContactsIntroView)f(2131297452));
      this.H = ((NuxFindingContactsView)f(2131297453));
      this.J = ((NuxScrimView)f(2131297450));
      this.K = ((NuxSmsIntroView)f(2131297451));
      OrcaNuxManager localOrcaNuxManager = (OrcaNuxManager)localFbInjector.a(OrcaNuxManager.class);
      if (localOrcaNuxManager.b())
      {
        this.G = new ThreadListNuxController(localOrcaNuxManager, (OrcaActivityBroadcaster)localFbInjector.a(OrcaActivityBroadcaster.class), (OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class), localFbInjector.b(Boolean.class, ShouldSkipContactImportNux.class), (MmsSmsLogger)localFbInjector.a(MmsSmsLogger.class), this.D, this.E, this.r, this.I, this.H, this.J, this.K);
        this.H.setContentOnClickListener(new ThreadListActivity.5(this));
      }
      this.B = new MuteGlobalWarningController((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class), (NotificationSettingsUtil)localFbInjector.a(NotificationSettingsUtil.class), this.y);
      n();
      if ((str == null) && (this.L != null) && (!this.L.w()))
      {
        FragmentTransaction localFragmentTransaction = localFragmentManager.a();
        localFragmentTransaction.b(this.L);
        localFragmentTransaction.a();
        localFragmentManager.b();
      }
      b(str);
      return;
    }
  }

  public void a_(int paramInt)
  {
    if (j())
      this.L.a_(paramInt);
  }

  public List<ExportMenuToFbHostActivity.CustomFbHostMenuItem> b()
  {
    if (j());
    ArrayList localArrayList;
    for (Object localObject = this.L.b(); ; localObject = localArrayList)
    {
      return localObject;
      localArrayList = new ArrayList();
      localArrayList.add(new ExportMenuToFbHostActivity.CustomFbHostMenuItem(2131296325, 2131362581, 2130838622, true, "fb://messages/inbox/archived"));
      localArrayList.add(new ExportMenuToFbHostActivity.CustomFbHostMenuItem(2131296326, 2131362582, 2130838623, true, "fb://messages/inbox/other"));
    }
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((this.s.a(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public String i()
  {
    if (j());
    for (String str = this.L.M(); ; str = null)
      return str;
  }

  public boolean j()
  {
    if ((this.L != null) && (this.N != null));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean k()
  {
    if (this.w.d().getFirstVisiblePosition() > 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public DivebarController m()
  {
    return this.C;
  }

  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getWindow().setFormat(1);
  }

  public void onBackPressed()
  {
    if (this.C.e());
    while (true)
    {
      return;
      if (j())
      {
        if (this.L.N())
          continue;
        q();
        continue;
      }
      if (!g().c())
        continue;
      super.onBackPressed();
    }
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.C.d();
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    boolean bool;
    if (paramMenuItem.getGroupId() != 2131296336)
      bool = super.onContextItemSelected(paramMenuItem);
    ListAdapter localListAdapter;
    while (true)
    {
      return bool;
      localListAdapter = this.w.d().getAdapter();
      if (paramMenuItem.getItemId() == 1)
      {
        Object localObject3 = localListAdapter.getItem(((AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo()).position);
        if (!(localObject3 instanceof ThreadSummary))
          break;
        ThreadSummary localThreadSummary3 = (ThreadSummary)localObject3;
        this.w.c(localThreadSummary3);
        bool = true;
        continue;
      }
      else
      {
        if (paramMenuItem.getItemId() != 0)
          break label156;
        Object localObject2 = localListAdapter.getItem(((AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo()).position);
        if (!(localObject2 instanceof ThreadSummary))
          break;
        ThreadSummary localThreadSummary2 = (ThreadSummary)localObject2;
        this.w.a(localThreadSummary2);
      }
    }
    while (true)
    {
      bool = super.onContextItemSelected(paramMenuItem);
      break;
      label156: if (paramMenuItem.getItemId() != 2)
        continue;
      Object localObject1 = localListAdapter.getItem(((AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo()).position);
      if (!(localObject1 instanceof ThreadSummary))
        continue;
      ThreadSummary localThreadSummary1 = (ThreadSummary)localObject1;
      this.w.b(localThreadSummary1);
    }
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    ListView localListView = this.w.d();
    if (paramView == localListView)
    {
      AdapterView.AdapterContextMenuInfo localAdapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      Object localObject = localListView.getAdapter().getItem(localAdapterContextMenuInfo.position);
      if ((localObject instanceof ThreadSummary))
      {
        paramContextMenu.setHeaderTitle(2131362424);
        paramContextMenu.add(2131296336, 0, 0, 2131362426);
        if (!MessagingIdUtil.g(((ThreadSummary)localObject).a()))
          paramContextMenu.add(2131296336, 2, 2, 2131362427);
        paramContextMenu.add(2131296336, 1, 1, 2131362425);
      }
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    super.onCreateOptionsMenu(paramMenu);
    getMenuInflater().inflate(2131755010, paramMenu);
    if (!((Boolean)this.o.b()).booleanValue())
      paramMenu.removeItem(2131298009);
    return true;
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if (j())
    {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4))
        this.r.a(new HoneyClientEvent("click").d(a()).e("android_button").f("back"));
      if ((this.L.a(paramInt, paramKeyEvent)) || (super.onKeyDown(paramInt, paramKeyEvent)))
        bool = true;
    }
    while (true)
    {
      return bool;
      bool = false;
      continue;
      bool = super.onKeyDown(paramInt, paramKeyEvent);
    }
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131298009)
      p();
    for (boolean bool = true; ; bool = super.onOptionsItemSelected(paramMenuItem))
      return bool;
  }

  protected void onPause()
  {
    super.onPause();
    BLog.b(n, "ThreadListActivity.onPause");
    this.O = false;
    this.w.a(null);
    this.E.a(this.F);
    this.t.a();
    this.u.a();
  }

  protected void onResume()
  {
    super.onResume();
    BLog.b(n, "ThreadListActivity.onResume");
    this.O = true;
    this.q.c();
    this.x.setAppConfig(this.p.f());
    this.B.a();
    IntentFilter localIntentFilter = new IntentFilter("com.facebook.orca.contacts.CONTACTS_UPLOAD_STATE_CHANGED");
    this.E.a(this.F, localIntentFilter);
    if (this.G != null)
      this.G.a();
    o();
    if (!j())
    {
      a(this.D.c());
      l();
    }
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("selectedThreadId", this.N);
  }

  protected void onStop()
  {
    super.onStop();
    BLog.b(n, "ThreadListActivity.onStop");
    if (this.G != null)
      this.G.b();
  }

  public void onUserInteraction()
  {
    super.onUserInteraction();
    if (j())
      this.L.L();
    while (true)
    {
      return;
      if (this.w != null)
      {
        this.w.c();
        continue;
      }
    }
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (j())
      this.L.b(paramBoolean);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadListActivity
 * JD-Core Version:    0.6.0
 */