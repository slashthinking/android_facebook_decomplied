package com.facebook.orca.threadlist;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.InteractionLogger.ContentFlags;
import com.facebook.content.SecureContextHelper;
import com.facebook.fragment.NavigableFragment;
import com.facebook.fragment.NavigableFragment.Listener;
import com.facebook.orca.activity.FbActivityish;
import com.facebook.orca.activity.OrcaFragment;
import com.facebook.orca.activity.SafeLocalBroadcastReceiver;
import com.facebook.orca.annotations.CurrentFolderType;
import com.facebook.orca.cache.ArchiveThreadManager;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.cache.SpamThreadManager;
import com.facebook.orca.common.dialogs.ErrorMessageGenerator;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.common.ui.widgets.AnchorableToast;
import com.facebook.orca.common.ui.widgets.AnchorableToast.ToastType;
import com.facebook.orca.common.ui.widgets.refreshablelistview.RefreshableListViewContainer;
import com.facebook.orca.contacts.divebar.DivebarLoader.Result;
import com.facebook.orca.contacts.divebar.DivebarLoaderFactory;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.mutators.DeleteThreadDialogFragment;
import com.facebook.orca.notify.OrcaNotificationManager;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.prefs.UiCounters;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.ErrorCode;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.threads.FolderCounts;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.FolderType;
import com.facebook.orca.threads.ThreadParticipantUtils;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threads.ThreadsCollection;
import com.facebook.orca.threadview.ThreadViewUtil;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserKey;
import com.facebook.widget.BetterListView;
import com.facebook.widget.listview.EmptyListViewItem;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Provider;

public class ThreadListFragment extends OrcaFragment
  implements NavigableFragment
{
  private static final Class<?> a = ThreadListFragment.class;
  private AudioManager Y;
  private FbTitleBar Z;
  private String aA;
  private AnalyticsLogger aB;
  private InteractionLogger aC;
  private boolean aD;
  private String aE;
  private OrcaServiceOperationFactory aa;
  private ThreadListLoader ab;
  private ThreadParticipantUtils ac;
  private LocalBroadcastManager ad;
  private DivebarLoaderFactory ae;
  private SecureContextHelper af;
  private ImmutableList<User> ag = ImmutableList.d();
  private LoaderManager.LoaderCallbacks<DivebarLoader.Result> ah;
  private ListenableFuture<OperationResult> ai;
  private RefreshableListViewContainer aj;
  private BetterListView ak;
  private EmptyListViewItem al;
  private ThreadListEmptyView am;
  private Supplier<ThreadItemView> an;
  private boolean ao = false;
  private Provider<FolderType> ap;
  private FolderName aq;
  private SafeLocalBroadcastReceiver ar;
  private ThreadListLoader.Result as = ThreadListLoader.a;
  private long at = -1L;
  private ThreadListFragment.ThreadListEventListener au;
  private int av = -1;
  private long aw;
  private ErrorCode ax;
  private ThreadViewUtil ay;
  private NavigableFragment.Listener az;
  private DataCache b;
  private OrcaNotificationManager c;
  private ThreadListAdapter d;
  private ArchiveThreadManager e;
  private SpamThreadManager f;
  private AnchorableToast g;
  private ErrorMessageGenerator h;
  private UiCounters i;

  private void M()
  {
    this.ah = new ThreadListFragment.5(this);
    if (N())
      z().a(0, null, this.ah);
  }

  private boolean N()
  {
    if ((this.am.getVisibility() == 0) && (this.ag.size() < 6));
    for (int j = 1; ; j = 0)
      return j;
  }

  private void O()
  {
    a(false);
  }

  private void P()
  {
    a(true);
  }

  private void R()
  {
    if (!this.as.a())
    {
      if (this.au != null)
        this.au.a();
      S();
    }
    while (true)
    {
      return;
      if (!this.ab.b())
      {
        if (this.au != null)
          this.au.a();
        S();
        continue;
      }
    }
  }

  private void S()
  {
    int j = 8;
    ThreadListAdapter.LoadMoreState localLoadMoreState;
    if (this.as.a.c())
      localLoadMoreState = ThreadListAdapter.LoadMoreState.NONE;
    while (true)
    {
      this.al.setVisibility(j);
      ThreadListEmptyView localThreadListEmptyView = this.am;
      if (this.as.a())
        j = 0;
      localThreadListEmptyView.setVisibility(j);
      this.d.a(localLoadMoreState);
      this.d.a(this.as.a.b());
      this.d.notifyDataSetChanged();
      this.aj.setLastLoadedTime(this.as.b);
      this.ak.post(new ThreadListFragment.6(this));
      this.ao = false;
      return;
      if (this.ao)
      {
        localLoadMoreState = ThreadListAdapter.LoadMoreState.LOAD_MORE;
        continue;
      }
      localLoadMoreState = ThreadListAdapter.LoadMoreState.LOAD_MORE_PLACEHOLDER;
    }
  }

  private void T()
  {
    if (this.aE != null);
    while (true)
    {
      return;
      ArrayList localArrayList = Lists.a();
      int j = this.ak.getFirstVisiblePosition();
      int k = this.ak.getLastVisiblePosition();
      for (int m = j; m <= k; m++)
      {
        Object localObject = this.d.getItem(m);
        if (!(localObject instanceof ThreadSummary))
          continue;
        localArrayList.add(((ThreadSummary)localObject).a());
      }
      Intent localIntent = new Intent("com.facebook.orca.THREADS_SHOWN_IN_LIST");
      localIntent.putExtra("threads", localArrayList);
      this.ad.a(localIntent);
    }
  }

  private void U()
  {
    if (this.ai != null);
    while (true)
    {
      return;
      FolderCounts localFolderCounts = this.b.f(this.aq);
      if ((localFolderCounts == null) || (localFolderCounts.b() == 0))
        continue;
      long l = System.currentTimeMillis();
      if (l - this.at < 60000L)
        continue;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("folderName", this.aq);
      this.ai = this.aa.a("mark_folder_seen", localBundle).d();
      Futures.a(this.ai, new ThreadListFragment.9(this));
      this.at = l;
    }
  }

  private void V()
  {
    if (this.ao);
    while (true)
    {
      return;
      int j = this.d.getCount();
      if ((j <= 0) || (this.av != j))
        continue;
      Object localObject = this.d.getItem(-1 + this.av);
      if ((localObject != ThreadListAdapter.d) && (localObject != ThreadListAdapter.c))
        continue;
      this.ab.e();
    }
  }

  private String W()
  {
    String str;
    if (this.aA != null)
      str = this.aA;
    while (true)
    {
      return str;
      if ((n() instanceof AnalyticsActivity))
      {
        str = ((AnalyticsActivity)n()).a();
        continue;
      }
      str = null;
    }
  }

  private void X()
  {
    if (this.Z == null);
    while (true)
    {
      return;
      if ((this.ab.c()) && (!this.ab.d()))
      {
        this.Z.a(true);
        continue;
      }
    }
  }

  private void Y()
  {
    if (this.Z != null)
      this.Z.a(false);
  }

  private void a(DivebarLoader.Result paramResult)
  {
    int j = 1;
    if ((paramResult == null) || (this.ag.size() > 6));
    label148: 
    while (true)
    {
      return;
      ImmutableList localImmutableList1 = paramResult.a();
      ImmutableList localImmutableList2 = paramResult.c();
      ImmutableList localImmutableList3 = paramResult.d();
      HashSet localHashSet = new HashSet();
      ImmutableSet.Builder localBuilder = ImmutableSet.e();
      a(localHashSet, this.ag, localBuilder);
      int k = 0;
      if (localImmutableList1 != null)
      {
        a(localHashSet, localImmutableList1, localBuilder);
        k = j;
      }
      if (localImmutableList2 != null)
      {
        a(localHashSet, localImmutableList2, localBuilder);
        k = j;
      }
      if (localImmutableList3 != null)
        a(localHashSet, localImmutableList3, localBuilder);
      while (true)
      {
        if (j == 0)
          break label148;
        this.ag = localBuilder.b().h();
        this.am.setSuggestedContacts(this.ag);
        break;
        j = k;
      }
    }
  }

  private void a(ServiceException paramServiceException)
  {
    this.g.a(80);
    this.g.a(5000L);
    this.g.a(true);
    this.g.a(g(2131297458), this.h.a(paramServiceException, false, true), AnchorableToast.ToastType.WARNING);
  }

  private void a(DataFreshnessResult paramDataFreshnessResult, String paramString)
  {
    boolean bool = n() instanceof FbActivityish;
    String str = null;
    if (bool)
      str = ((FbActivityish)n()).e();
    InteractionLogger.ContentFlags localContentFlags = InteractionLogger.ContentFlags.UNDEFINED;
    if (paramDataFreshnessResult == DataFreshnessResult.FROM_SERVER)
      localContentFlags = InteractionLogger.ContentFlags.NETWORK_DATA;
    while (true)
    {
      HoneyClientEvent localHoneyClientEvent = this.aC.a(localContentFlags, W(), str, -1L);
      localHoneyClientEvent.b("load_type", paramString);
      this.aB.a(localHoneyClientEvent);
      return;
      if ((paramDataFreshnessResult == DataFreshnessResult.FROM_CACHE_STALE) || (paramDataFreshnessResult == DataFreshnessResult.FROM_CACHE_UP_TO_DATE) || (paramDataFreshnessResult == DataFreshnessResult.FROM_CACHE_INCOMPLETE))
      {
        localContentFlags = InteractionLogger.ContentFlags.LOCAL_DATA;
        continue;
      }
      if (paramDataFreshnessResult != DataFreshnessResult.NO_DATA)
        continue;
      localContentFlags = InteractionLogger.ContentFlags.NO_DATA;
    }
  }

  private void a(ThreadListLoader.Error paramError)
  {
    long l = System.currentTimeMillis();
    ErrorCode localErrorCode = paramError.a.a();
    if ((l - this.aw < 300000L) && (this.ax == localErrorCode) && (!paramError.b));
    while (true)
    {
      return;
      if (v())
      {
        a(paramError.a);
        this.aw = l;
        this.ax = localErrorCode;
        continue;
      }
    }
  }

  private void a(ThreadListLoader.LoadType paramLoadType)
  {
    this.g.a();
    if (paramLoadType == ThreadListLoader.LoadType.THREAD_LIST)
    {
      if (this.as.a())
      {
        this.al.setMessage(q().getString(2131362418));
        this.al.a(true);
        this.al.setVisibility(0);
      }
      this.am.setVisibility(8);
      if (this.ab.d())
        this.aj.b();
      X();
    }
    while (true)
    {
      return;
      if (paramLoadType == ThreadListLoader.LoadType.MORE_THREADS)
      {
        this.d.a(ThreadListAdapter.LoadMoreState.LOADING);
        this.d.notifyDataSetChanged();
        continue;
      }
    }
  }

  private void a(ThreadListLoader.LoadType paramLoadType, ThreadListLoader.Error paramError)
  {
    if (paramLoadType == ThreadListLoader.LoadType.THREAD_LIST)
    {
      this.aj.d();
      Y();
      this.al.setMessage(null);
      this.al.a(false);
      this.am.setVisibility(8);
      a(paramError);
    }
    while (true)
    {
      return;
      if (paramLoadType == ThreadListLoader.LoadType.MORE_THREADS)
      {
        this.ao = true;
        this.d.a(ThreadListAdapter.LoadMoreState.LOAD_MORE);
        this.d.notifyDataSetChanged();
        continue;
      }
    }
  }

  private void a(ThreadListLoader.LoadType paramLoadType, ThreadListLoader.Result paramResult)
  {
    this.as = paramResult;
    if (paramLoadType == ThreadListLoader.LoadType.MORE_THREADS)
      this.ak.smoothScrollBy(0, 0);
    R();
    a(paramResult.d, paramLoadType.toString());
  }

  private void a(Set<String> paramSet, Iterable<User> paramIterable, ImmutableSet.Builder<User> paramBuilder)
  {
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      User localUser = (User)localIterator.next();
      if (paramSet.contains(localUser.c().toString()))
        continue;
      paramSet.add(localUser.c().toString());
      paramBuilder.b(localUser);
    }
  }

  private void a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (ThreadListLoader.Params localParams = new ThreadListLoader.Params(true, true); ; localParams = new ThreadListLoader.Params(false, false))
    {
      this.aq = FolderName.a((FolderType)this.ap.b());
      this.ab.a(this.aq);
      this.ab.a(localParams);
      return;
    }
  }

  private void b(Intent paramIntent)
  {
    if ("com.facebook.orca.ACTION_SMS_ENABLED_CHANGED".equals(paramIntent.getAction()))
      O();
    while (true)
    {
      return;
      if ("com.facebook.orca.ACTION_READ_THREAD_FOR_UI".equals(paramIntent.getAction()))
      {
        String str = paramIntent.getStringExtra("threadid");
        if (str == null)
          continue;
        c(str);
        continue;
      }
      if ("com.facebook.orca.ACTION_PERSISTENT_CHANNEL_STATE_CHANGED".equals(paramIntent.getAction()))
      {
        O();
        continue;
      }
      if ("com.facebook.orca.contacts.CONTACTS_UPLOAD_STATE_CHANGED".equals(paramIntent.getAction()))
      {
        if (!N())
          continue;
        z().b(0, null, this.ah);
        continue;
      }
      long l = paramIntent.getLongExtra("actionid", -1L);
      if ((l == -1L) || (this.as.a()))
      {
        O();
        continue;
      }
      if (this.as.c >= l)
        continue;
      O();
    }
  }

  private void b(ThreadListLoader.LoadType paramLoadType)
  {
    if (paramLoadType == ThreadListLoader.LoadType.THREAD_LIST)
    {
      this.aj.d();
      Y();
    }
  }

  private void b(ThreadListLoader.LoadType paramLoadType, ThreadListLoader.Error paramError)
  {
    if (paramLoadType == ThreadListLoader.LoadType.THREAD_LIST)
      a(paramError);
  }

  private void c(String paramString)
  {
    for (int j = 0; j < this.ak.getChildCount(); j++)
    {
      View localView = this.ak.getChildAt(j);
      if (!(localView instanceof ThreadItemView))
        continue;
      ThreadItemView localThreadItemView = (ThreadItemView)localView;
      if (!paramString.equals(localThreadItemView.getThreadId()))
        continue;
      localThreadItemView.a();
    }
  }

  private void d(ThreadSummary paramThreadSummary)
  {
    this.f.a(paramThreadSummary);
    S();
  }

  private void d(String paramString)
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("click").e("thread").f(paramString);
    localHoneyClientEvent.d(W());
    this.aB.a(localHoneyClientEvent);
  }

  private void e(String paramString)
  {
    this.aB.a(new HoneyClientEvent("click").e("opt_menu_item").f(paramString));
  }

  private void f(int paramInt)
  {
    Object localObject = this.d.getItem(paramInt);
    if ((localObject instanceof ThreadSummary))
    {
      ThreadSummary localThreadSummary = (ThreadSummary)localObject;
      Intent localIntent = new Intent();
      localIntent.putExtra("thread_id", localThreadSummary.a());
      d(localThreadSummary.a());
      localIntent.putExtra("trigger", W());
      this.az.a(this, localIntent);
    }
    while (true)
    {
      return;
      if (localObject == ThreadListAdapter.d)
      {
        this.ab.e();
        continue;
      }
    }
  }

  public void B()
  {
    super.B();
    BLog.b(a, "ThreadListFragment.onResume");
    if (this.aD)
    {
      this.c.a();
      P();
    }
    while (true)
    {
      if (N())
        z().b(0, null, this.ah);
      this.am.b();
      this.ar.a();
      return;
      O();
    }
  }

  public void C()
  {
    super.C();
    BLog.b(a, "ThreadListFragment.onPause");
    this.g.a();
    this.ar.b();
  }

  public void D()
  {
    super.D();
    if (this.g != null)
      this.g.a();
    if (this.ab != null)
      this.ab.a();
    this.ar.b();
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903407, paramViewGroup, false);
    this.aj = ((RefreshableListViewContainer)localView.findViewById(2131297459));
    this.ak = ((BetterListView)localView.findViewById(2131297439));
    this.al = ((EmptyListViewItem)localView.findViewById(2131297460));
    this.am = ((ThreadListEmptyView)localView.findViewById(2131297461));
    ImmutableList localImmutableList = null;
    if (paramBundle != null)
    {
      ArrayList localArrayList = paramBundle.getParcelableArrayList("suggested_contacts_list");
      localImmutableList = null;
      if (localArrayList != null)
        localImmutableList = ImmutableList.a(localArrayList);
    }
    if (localImmutableList != null)
      this.am.setSuggestedContacts(localImmutableList);
    a(this.ak);
    return localView;
  }

  public void a()
  {
    this.aD = true;
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    Context localContext = p();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.orca.ACTION_THREAD_UPDATED_FOR_UI");
    localIntentFilter.addAction("com.facebook.orca.ACTION_READ_THREAD_FOR_UI");
    localIntentFilter.addAction("com.facebook.orca.ACTION_REMOVED_THREAD_FOR_UI");
    localIntentFilter.addAction("com.facebook.orca.ACTION_SMS_ENABLED_CHANGED");
    localIntentFilter.addAction("com.facebook.orca.ACTION_PERSISTENT_CHANNEL_STATE_CHANGED");
    localIntentFilter.addAction("com.facebook.orca.contacts.CONTACTS_UPLOAD_STATE_CHANGED");
    this.ar = new ThreadListFragment.1(this, localContext, localIntentFilter);
  }

  public void a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.a(paramMenu, paramMenuInflater);
    paramMenuInflater.inflate(2131755009, paramMenu);
  }

  public void a(NavigableFragment.Listener paramListener)
  {
    this.az = paramListener;
  }

  public void a(FbTitleBar paramFbTitleBar)
  {
    this.Z = paramFbTitleBar;
  }

  public void a(ThreadListFragment.ThreadListEventListener paramThreadListEventListener)
  {
    this.au = paramThreadListEventListener;
  }

  void a(ThreadSummary paramThreadSummary)
  {
    this.e.a(paramThreadSummary);
    S();
  }

  public void a(Supplier<ThreadItemView> paramSupplier)
  {
    this.an = paramSupplier;
  }

  public void a(String paramString)
  {
    this.aA = paramString;
  }

  public boolean a(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131298008)
    {
      e("refresh");
      b();
    }
    for (boolean bool = true; ; bool = super.a(paramMenuItem))
      return bool;
  }

  void b()
  {
    P();
  }

  void b(ThreadSummary paramThreadSummary)
  {
    new AlertDialog.Builder(p()).setTitle(2131362579).setCancelable(false).setPositiveButton(2131362171, new ThreadListFragment.8(this, paramThreadSummary)).setNegativeButton(2131362172, new ThreadListFragment.7(this)).show();
  }

  void c()
  {
    this.c.a();
    U();
  }

  public void c(ThreadSummary paramThreadSummary)
  {
    if (paramThreadSummary == null);
    while (true)
    {
      return;
      DeleteThreadDialogFragment.a(paramThreadSummary.a()).a(r(), "deleteThreadDialog");
    }
  }

  public ListView d()
  {
    return this.ak;
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    BLog.b(a, "ThreadListFragment.onActivityCreated");
    FbInjector localFbInjector = Q();
    this.b = ((DataCache)localFbInjector.a(DataCache.class));
    this.c = ((OrcaNotificationManager)localFbInjector.a(OrcaNotificationManager.class));
    this.d = ((ThreadListAdapter)localFbInjector.a(ThreadListAdapter.class));
    this.e = ((ArchiveThreadManager)localFbInjector.a(ArchiveThreadManager.class));
    this.f = ((SpamThreadManager)localFbInjector.a(SpamThreadManager.class));
    this.g = ((AnchorableToast)localFbInjector.a(AnchorableToast.class));
    this.h = ((ErrorMessageGenerator)localFbInjector.a(ErrorMessageGenerator.class));
    this.i = ((UiCounters)localFbInjector.a(UiCounters.class));
    this.Y = ((AudioManager)localFbInjector.a(AudioManager.class));
    this.ap = localFbInjector.b(FolderType.class, CurrentFolderType.class);
    this.aa = ((OrcaServiceOperationFactory)localFbInjector.a(OrcaServiceOperationFactory.class));
    this.ay = ((ThreadViewUtil)localFbInjector.a(ThreadViewUtil.class));
    this.ab = ((ThreadListLoader)localFbInjector.a(ThreadListLoader.class));
    this.ab.a(this.aE);
    this.ac = ((ThreadParticipantUtils)Q().a(ThreadParticipantUtils.class));
    this.aB = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.aC = new InteractionLogger(p());
    this.ad = ((LocalBroadcastManager)localFbInjector.a(LocalBroadcastManager.class));
    this.ae = ((DivebarLoaderFactory)localFbInjector.a(DivebarLoaderFactory.class));
    this.af = ((SecureContextHelper)localFbInjector.a(SecureContextHelper.class));
    if (this.an != null)
      this.d.a(this.an);
    this.ak.setAdapter(this.d);
    this.ak.setDividerHeight(0);
    this.ak.setItemsCanFocus(true);
    this.ak.setBroadcastInteractionChanges(true);
    this.ak.setOnItemClickListener(new ThreadListFragment.2(this));
    this.aj.setOnRefreshListener(new ThreadListFragment.3(this));
    this.ak.setOnScrollListener(new ThreadListFragment.MyOnScrollListener(this, null));
    this.ab.a(new ThreadListFragment.4(this));
    f(true);
    M();
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putParcelableArrayList("suggested_contacts_list", Lists.a(this.ag));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadListFragment
 * JD-Core Version:    0.6.0
 */