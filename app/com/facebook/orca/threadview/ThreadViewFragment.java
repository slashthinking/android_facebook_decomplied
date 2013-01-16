package com.facebook.orca.threadview;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentHost;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.contacts.contactcard.ContactCardFragment;
import com.facebook.contacts.contactcard.GroupContactCardFragment;
import com.facebook.fragment.NavigableFragment;
import com.facebook.fragment.NavigableFragment.Listener;
import com.facebook.orca.activity.DivebarEnabledActivity;
import com.facebook.orca.activity.ExportMenuToFbHostActivity;
import com.facebook.orca.activity.ExportMenuToFbHostActivity.CustomFbHostMenuItem;
import com.facebook.orca.activity.OrcaFragment;
import com.facebook.orca.attachments.AudioRecorder;
import com.facebook.orca.audio.AudioClipPlayerQueue;
import com.facebook.orca.cache.ArchiveThreadManager;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.cache.ReadThreadManager;
import com.facebook.orca.cache.SpamThreadManager;
import com.facebook.orca.common.dialogs.ErrorDialogBuilder;
import com.facebook.orca.common.dialogs.ErrorMessageGenerator;
import com.facebook.orca.common.ui.overlay.OverlayLayout;
import com.facebook.orca.common.ui.titlebar.DivebarController;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import com.facebook.orca.common.ui.widgets.AnchorableToast;
import com.facebook.orca.common.ui.widgets.AnchorableToast.ToastType;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.compose.ComposeFragment;
import com.facebook.orca.compose.ComposeFragment.InitParams;
import com.facebook.orca.compose.ComposeMode;
import com.facebook.orca.compose.LocationDisabledNuxView;
import com.facebook.orca.compose.LocationNuxController;
import com.facebook.orca.compose.LocationNuxView;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.mutators.DeleteThreadDialogFragment;
import com.facebook.orca.mutators.LeaveThreadDialogFragment;
import com.facebook.orca.notify.NotificationSetting;
import com.facebook.orca.notify.NotificationSettingsUtil;
import com.facebook.orca.notify.OrcaNotificationManager;
import com.facebook.orca.nux.OrcaNuxManager;
import com.facebook.orca.nux.ThreadNuxController;
import com.facebook.orca.nux.ThreadTitleNuxView;
import com.facebook.orca.ops.DialogBasedProgressIndicator;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.UiCounters;
import com.facebook.orca.server.ModifyThreadParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.RemoveMemberParams;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.threads.ThreadParticipantUtils;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threadview.upsell.MergedThreadsUpsellController;
import com.facebook.orca.users.User;
import com.facebook.widget.ConfirmationView;
import com.facebook.widget.listview.EmptyListViewItem;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;

public class ThreadViewFragment extends OrcaFragment
  implements AnalyticsActivity, NavigableFragment, ExportMenuToFbHostActivity, ThreadMessageFragmentHost
{
  private static final Class<?> a = ThreadViewFragment.class;
  private NotificationSettingsUtil Y;
  private ArchiveThreadManager Z;
  private ThreadViewMessageFragmentTab aA;
  private ThreadViewMapFragmentTab aB;
  private ContactCardFragment aC;
  private GroupContactCardFragment aD;
  private boolean aE;
  private boolean aF;
  private boolean aG;
  private boolean aH;
  private boolean aI;
  private boolean aJ;
  private ThreadViewFragment.State aK;
  private String aL;
  private ThreadViewLoader.Result aM = ThreadViewLoader.a;
  private boolean aN;
  private boolean aO;
  private ComposeFragment.InitParams aP;
  private boolean aQ;
  private NavigableFragment.Listener aR;
  private SpamThreadManager aa;
  private ReadThreadManager ab;
  private AnalyticsLogger ac;
  private ThreadParticipantUtils ad;
  private UiCounters ae;
  private AudioClipPlayerQueue af;
  private AudioRecorder ag;
  private ThreadTitleNuxView ah;
  private ThreadNuxController ai;
  private OrcaServiceOperationFactory aj;
  private ListenableFuture<OperationResult> ak;
  private ListenableFuture<OperationResult> al;
  private FbTitleBar am;
  private EmptyListViewItem an;
  private ThreadAlertRateLimitView ao;
  private MergedThreadsUpsellController ap;
  private LocationNuxController aq;
  private LocationNuxView ar;
  private LocationDisabledNuxView as;
  private String at;
  private ThreadViewFragmentBroadcastReceiver au;
  private List<TitleBarButtonSpec> av;
  private List<TitleBarButtonSpec> aw;
  private List<TitleBarButtonSpec> ax;
  private List<TitleBarButtonSpec> ay;
  private ThreadViewTitleHelper az;
  private ThreadViewLoader b;
  private DataCache c;
  private OrcaNotificationManager d;
  private OrcaSharedPreferences e;
  private FragmentManager f;
  private AnchorableToast g;
  private ErrorMessageGenerator h;
  private InputMethodManager i;

  private void R()
  {
    FbInjector localFbInjector = Q();
    this.b = ((ThreadViewLoader)localFbInjector.a(ThreadViewLoader.class));
    this.c = ((DataCache)localFbInjector.a(DataCache.class));
    this.d = ((OrcaNotificationManager)localFbInjector.a(OrcaNotificationManager.class));
    this.e = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
    this.f = K();
    this.g = ((AnchorableToast)localFbInjector.a(AnchorableToast.class));
    this.h = ((ErrorMessageGenerator)localFbInjector.a(ErrorMessageGenerator.class));
    this.i = ((InputMethodManager)localFbInjector.a(InputMethodManager.class));
    this.Y = ((NotificationSettingsUtil)localFbInjector.a(NotificationSettingsUtil.class));
    this.Z = ((ArchiveThreadManager)localFbInjector.a(ArchiveThreadManager.class));
    this.aa = ((SpamThreadManager)localFbInjector.a(SpamThreadManager.class));
    this.ab = ((ReadThreadManager)localFbInjector.a(ReadThreadManager.class));
    this.ac = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.ad = ((ThreadParticipantUtils)localFbInjector.a(ThreadParticipantUtils.class));
    this.az = ((ThreadViewTitleHelper)localFbInjector.a(ThreadViewTitleHelper.class));
    this.ae = ((UiCounters)localFbInjector.a(UiCounters.class));
    this.af = ((AudioClipPlayerQueue)localFbInjector.a(AudioClipPlayerQueue.class));
    this.ag = ((AudioRecorder)localFbInjector.a(AudioRecorder.class));
    this.aj = ((OrcaServiceOperationFactory)localFbInjector.a(OrcaServiceOperationFactory.class));
  }

  private void S()
  {
    this.an = ((EmptyListViewItem)g(2131297492));
    this.ar = ((LocationNuxView)g(2131297251));
    this.as = ((LocationDisabledNuxView)g(2131297252));
    this.ao = ((ThreadAlertRateLimitView)g(2131297494));
    ConfirmationView localConfirmationView = (ConfirmationView)g(2131297489);
    this.ap = new MergedThreadsUpsellController(p(), z(), localConfirmationView);
  }

  private void T()
  {
    if (this.am == null);
    while (true)
    {
      return;
      Resources localResources = q();
      TitleBarButtonSpec localTitleBarButtonSpec1 = TitleBarButtonSpec.newBuilder().a(1).a(localResources.getDrawable(2130838635)).a("back_side_button").i();
      TitleBarButtonSpec localTitleBarButtonSpec2 = TitleBarButtonSpec.newBuilder().a(2).b(q().getString(2131362446)).a("edit_contact_button").i();
      TitleBarButtonSpec localTitleBarButtonSpec3 = TitleBarButtonSpec.newBuilder().a(3).b(q().getString(2131362447)).a("edit_done_contact_button").i();
      this.av = ImmutableList.a(localTitleBarButtonSpec1);
      this.aw = ImmutableList.a(localTitleBarButtonSpec2);
      this.ax = ImmutableList.a(localTitleBarButtonSpec3);
      this.ay = ImmutableList.d();
      this.am.setButtonSpecs(this.av);
      this.am.setOnToolbarButtonListener(new ThreadViewFragment.3(this));
      this.am.setTitle(e(2131362436));
      this.am.setHasProgressBar(true);
      this.am.setHasBackButton(true);
      this.az.a(this.am);
    }
  }

  private void U()
  {
    if (this.at != null)
      this.b.a(this.at);
    if (!w())
    {
      T();
      an();
    }
    this.aA.a(this.at);
    this.ao.setThreadId(this.at);
    this.au.a(this.at);
    W();
    aq();
  }

  private void V()
  {
    ThreadSummary localThreadSummary = this.aM.a;
    ThreadParticipant localThreadParticipant = this.ad.b(localThreadSummary);
    if (localThreadParticipant != null)
      this.aC.a(localThreadParticipant.d(), true);
  }

  private void W()
  {
    if (!this.Y.a(this.at).c());
    while (true)
    {
      return;
      PrefKey localPrefKey = MessagesPrefKeys.a(this.at);
      OrcaSharedPreferences.Editor localEditor = this.e.b();
      localEditor.a(localPrefKey, NotificationSetting.a.d());
      localEditor.a();
    }
  }

  private void X()
  {
    if ((!this.aF) || (!this.aJ));
    while (true)
    {
      return;
      if (this.aQ)
      {
        this.aQ = false;
        Window localWindow = o().d();
        if (localWindow != null)
          localWindow.setSoftInputMode(4);
        Y();
        continue;
      }
    }
  }

  private void Y()
  {
    if ((this.aM.a != null) && (this.aA != null))
    {
      this.aA.c();
      this.aA.M().a();
    }
  }

  private ThreadSummary Z()
  {
    ThreadSummary localThreadSummary = this.aM.a;
    if (localThreadSummary != null);
    while (true)
    {
      return localThreadSummary;
      localThreadSummary = this.c.b(this.at);
    }
  }

  private void a(HoneyClientEvent paramHoneyClientEvent)
  {
    paramHoneyClientEvent.d(a());
    paramHoneyClientEvent.b("thread_id", M());
    this.ac.a(paramHoneyClientEvent);
  }

  private void a(ServiceException paramServiceException)
  {
    ErrorDialogBuilder.a(p()).a(2131362339).a(paramServiceException).a();
  }

  private void a(ServiceException paramServiceException, boolean paramBoolean)
  {
    this.g.a(5000L);
    this.g.a(true);
    View localView;
    if (paramBoolean)
    {
      localView = this.aA.M().A();
      this.g.a(48);
    }
    while (true)
    {
      this.g.a(localView, this.h.a(paramServiceException, false, true), AnchorableToast.ToastType.WARNING);
      return;
      localView = (View)this.am;
      this.g.a(80);
    }
  }

  private void a(OperationResult paramOperationResult)
  {
    ae();
  }

  private void a(ThreadSummary paramThreadSummary)
  {
    this.az.a(paramThreadSummary);
  }

  private void a(ThreadSummary paramThreadSummary, User paramUser)
  {
    if (this.al != null);
    while (true)
    {
      return;
      RemoveMemberParams localRemoveMemberParams = new RemoveMemberParams(paramThreadSummary.a(), paramUser.b());
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("removeMemberParams", localRemoveMemberParams);
      OrcaServiceOperationFactory.OrcaServiceOperation localOrcaServiceOperation = this.aj.a("remove_member", localBundle);
      localOrcaServiceOperation.a(new DialogBasedProgressIndicator(p(), 2131362505));
      this.al = localOrcaServiceOperation.d();
      a(new HoneyClientEvent("leave_conversation"));
      Futures.a(this.al, new ThreadViewFragment.11(this));
    }
  }

  private void a(ThreadViewFragment.State paramState)
  {
    if (this.aK == ThreadViewFragment.State.MESSAGES)
      this.i.hideSoftInputFromWindow(this.aA.A().getWindowToken(), 0);
    Object localObject;
    switch (ThreadViewFragment.13.a[paramState.ordinal()])
    {
    default:
      throw new IllegalArgumentException("cannot transition to that state");
    case 2:
      aa();
      V();
      localObject = this.aC;
      b(paramState);
      Fragment localFragment = al();
      FragmentTransaction localFragmentTransaction = this.f.a();
      localFragmentTransaction.a(null);
      localFragmentTransaction.a(2130968595, 2130968605, 2130968594, 2130968606);
      localFragmentTransaction.b(localFragment);
      localFragmentTransaction.c((Fragment)localObject);
      localFragmentTransaction.a();
      ThreadSummary localThreadSummary = this.aM.a;
      MessagesCollection localMessagesCollection = this.aM.b;
      if (paramState == ThreadViewFragment.State.MAP)
      {
        if ((localThreadSummary == null) || (localMessagesCollection == null))
          break;
        ac();
        this.aB.a(localThreadSummary, localMessagesCollection.b());
      }
    case 4:
    case 3:
    }
    while (true)
    {
      this.aK = paramState;
      y();
      aj();
      an();
      a(this.ac.c(paramState.toString(), false));
      return;
      ab();
      this.aD.a(this.at);
      localObject = this.aD;
      break;
      ac();
      localObject = this.aB;
      break;
      if (paramState == ThreadViewFragment.State.CONTACTCARD)
      {
        aa();
        this.aC.N();
        continue;
      }
      if (paramState != ThreadViewFragment.State.GROUP_CONTACTCARD)
        continue;
      ab();
      this.aD.a();
    }
  }

  private void a(ThreadViewLoader.LoadType paramLoadType)
  {
    this.g.a();
    if (paramLoadType == ThreadViewLoader.LoadType.THREAD_VIEW)
    {
      this.an.setMessage(q().getString(2131362433));
      this.an.a(true);
      ah();
    }
    while (true)
    {
      return;
      this.aA.b();
    }
  }

  private void a(ThreadViewLoader.LoadType paramLoadType, ThreadViewLoader.Error paramError)
  {
    if (this.at == null);
    while (true)
    {
      return;
      ai();
      if (paramLoadType == ThreadViewLoader.LoadType.THREAD_VIEW)
      {
        if ((this.aM.a == null) || (this.aM.b == null))
        {
          this.an.a(false);
          this.an.setMessage(null);
        }
        while (true)
        {
          if (!paramError.b)
            break label84;
          a(paramError.a, true);
          break;
          c(true);
          aj();
        }
        label84: continue;
      }
      if (paramError.b)
        a(paramError.a, false);
      this.aA.N();
    }
  }

  private void a(ThreadViewLoader.LoadType paramLoadType, ThreadViewLoader.Result paramResult)
  {
    if (this.at == null);
    while (true)
    {
      return;
      this.aM = paramResult;
      c(this.an.a());
      aj();
    }
  }

  private void aa()
  {
    if (this.aG);
    while (true)
    {
      return;
      this.aC = ((ContactCardFragment)this.f.a("contactCard"));
      if (this.aC == null)
      {
        this.aC = new ContactCardFragment();
        FragmentTransaction localFragmentTransaction = this.f.a();
        localFragmentTransaction.a(2131297490, this.aC, "contactCard");
        localFragmentTransaction.b(this.aC);
        localFragmentTransaction.a();
        this.f.b();
        this.aC.P();
      }
      this.aC.a(new ThreadViewFragment.4(this));
      this.aG = true;
    }
  }

  private void ab()
  {
    if (this.aH)
      this.aD.a(this.at);
    while (true)
    {
      return;
      this.aD = ((GroupContactCardFragment)this.f.a("groupContactCard"));
      if (this.aD == null)
      {
        this.aD = new GroupContactCardFragment();
        FragmentTransaction localFragmentTransaction = this.f.a();
        localFragmentTransaction.a(2131297490, this.aD, "groupContactCard");
        localFragmentTransaction.b(this.aD);
        localFragmentTransaction.a();
      }
      this.aD.a(this.at);
      this.aD.a(new ThreadViewFragment.5(this));
      this.aH = true;
    }
  }

  private void ac()
  {
    if (this.aI);
    while (true)
    {
      return;
      Preconditions.checkState(ThreadViewMapActivityTabShim.a());
      this.aB = ((ThreadViewMapFragmentTab)this.f.a("mapForContactCard"));
      if (this.aB == null)
      {
        this.aB = new ThreadViewMapFragmentTab();
        FragmentTransaction localFragmentTransaction = this.f.a();
        localFragmentTransaction.a(2131297490, this.aB, "mapForContactCard");
        localFragmentTransaction.b(this.aB);
        localFragmentTransaction.a();
      }
      this.aI = true;
    }
  }

  private void ad()
  {
    i(false);
  }

  private void ae()
  {
    i(true);
  }

  private void af()
  {
    ThreadSummary localThreadSummary = this.aM.a;
    User localUser = this.c.a();
    if ((localThreadSummary == null) || (localUser == null));
    while (true)
    {
      return;
      LeaveThreadDialogFragment localLeaveThreadDialogFragment = new LeaveThreadDialogFragment();
      localLeaveThreadDialogFragment.a(new ThreadViewFragment.6(this, localThreadSummary, localUser));
      localLeaveThreadDialogFragment.a(r(), "leaveThreadDialog");
    }
  }

  private void ag()
  {
    ThreadSummary localThreadSummary = this.aM.a;
    if (localThreadSummary == null);
    while (true)
    {
      return;
      DeleteThreadDialogFragment.a(localThreadSummary.a()).a(r(), "deleteThreadDialog");
    }
  }

  private void ah()
  {
    if (this.b.a())
      this.az.a(true);
  }

  private void ai()
  {
    this.az.a(false);
  }

  private void aj()
  {
    if (this.at == null);
    while (true)
    {
      return;
      ThreadSummary localThreadSummary = this.aM.a;
      MessagesCollection localMessagesCollection = this.aM.b;
      if ((localMessagesCollection != null) && (localMessagesCollection.c() != null))
      {
        String str = localMessagesCollection.c().b();
        this.aA.a(str);
      }
      this.az.a(localThreadSummary);
      if ((p() != null) && ((p() instanceof Activity)))
        this.ap.a(localThreadSummary);
      if ((this.aC != null) && (this.aC.v()))
        V();
      switch (ThreadViewFragment.13.a[this.aK.ordinal()])
      {
      default:
        break;
      case 1:
        if (this.aA == null)
          continue;
        if (this.aM != ThreadViewLoader.a)
          this.aA.a(this.aM);
        this.az.a(localThreadSummary);
        break;
      case 2:
        if (this.aC != null)
        {
          this.aC.a(localThreadSummary, localMessagesCollection);
          continue;
        }
        if (this.aD == null)
          continue;
        this.aD.a(localThreadSummary, localMessagesCollection);
        break;
      case 3:
        if ((this.aB == null) || (localMessagesCollection == null))
          continue;
        this.aB.a(localThreadSummary, localMessagesCollection.b());
      }
    }
  }

  private void ak()
  {
    if (!this.f.c());
    while (true)
    {
      return;
      while (this.f.f() > 0)
        this.f.e();
      this.aK = ThreadViewFragment.State.MESSAGES;
      y();
      if (this.aR == null)
        continue;
      this.aR.a(this, null);
    }
  }

  private Fragment al()
  {
    Object localObject;
    if ((this.aB != null) && (this.aB.v()))
      localObject = this.aB;
    while (true)
    {
      return localObject;
      if ((this.aD != null) && (this.aD.v()))
      {
        localObject = this.aD;
        continue;
      }
      if ((this.aC != null) && (this.aC.v()))
      {
        localObject = this.aC;
        continue;
      }
      if ((this.aA != null) && (this.aA.v()))
      {
        localObject = this.aA;
        continue;
      }
      localObject = null;
    }
  }

  private void am()
  {
    if ((this.aB != null) && (this.aB.v()))
      this.aK = ThreadViewFragment.State.MAP;
    while (true)
    {
      y();
      b(this.aK);
      return;
      if ((this.aD != null) && (this.aD.v()))
      {
        this.aK = ThreadViewFragment.State.GROUP_CONTACTCARD;
        continue;
      }
      if ((this.aC != null) && (this.aC.v()))
      {
        this.aK = ThreadViewFragment.State.CONTACTCARD;
        continue;
      }
      if ((this.aA == null) || (!this.aA.v()))
        continue;
      this.aK = ThreadViewFragment.State.MESSAGES;
    }
  }

  private void an()
  {
    if (this.am == null);
    while (true)
    {
      return;
      switch (ThreadViewFragment.13.a[this.aK.ordinal()])
      {
      default:
        break;
      case 1:
        this.am.setButtonSpecs(this.av);
        break;
      case 2:
        if (this.aC.a())
        {
          if (this.aC.L())
          {
            this.am.setButtonSpecs(this.ax);
            continue;
          }
          this.am.setButtonSpecs(this.aw);
          continue;
        }
        this.am.setButtonSpecs(this.ay);
        break;
      case 3:
      case 4:
        this.am.setButtonSpecs(this.ay);
      }
    }
  }

  private void ao()
  {
    if ((!this.aJ) || (!this.aE) || (this.at == null) || (this.aM == ThreadViewLoader.a));
    while (true)
    {
      return;
      long l = this.c.a(this.at);
      ThreadSummary localThreadSummary = this.aM.a;
      if ((localThreadSummary == null) || (localThreadSummary.b() <= l))
        continue;
      this.ab.a(localThreadSummary);
    }
  }

  private void ap()
  {
    if ((this.ah != null) && (this.ai != null))
      return;
    if ((p() instanceof ThreadViewActivity))
      this.ah = ((ThreadTitleNuxView)((Activity)p()).findViewById(2131297486));
    while (true)
    {
      this.ai = new ThreadNuxController((OrcaNuxManager)Q().a(OrcaNuxManager.class));
      break;
      LayoutInflater localLayoutInflater = LayoutInflater.from(p());
      ViewGroup localViewGroup = (ViewGroup)((Activity)p()).findViewById(2131297441);
      this.ah = ((ThreadTitleNuxView)localLayoutInflater.inflate(2130903421, localViewGroup, false));
      localViewGroup.addView(this.ah);
    }
  }

  private void aq()
  {
    if (this.at == null);
    while (true)
    {
      return;
      ap();
      this.ai.a(p(), this.at, this.ah);
    }
  }

  private void b(ServiceException paramServiceException)
  {
    ErrorDialogBuilder.a(p()).a(2131362339).a(paramServiceException).a(new ThreadViewFragment.12(this)).a();
  }

  private void b(ThreadSummary paramThreadSummary)
  {
    new AlertDialog.Builder(p()).setTitle(2131362579).setCancelable(false).setPositiveButton("Yes", new ThreadViewFragment.10(this, paramThreadSummary)).setNegativeButton("No", new ThreadViewFragment.9(this)).show();
  }

  private void b(ThreadViewFragment.State paramState)
  {
    DivebarController localDivebarController;
    if ((p() instanceof DivebarEnabledActivity))
    {
      localDivebarController = ((DivebarEnabledActivity)p()).m();
      if (ThreadViewFragment.State.MAP != paramState)
        break label35;
      localDivebarController.l();
    }
    while (true)
    {
      return;
      label35: localDivebarController.m();
    }
  }

  private void b(ThreadViewLoader.LoadType paramLoadType)
  {
    this.an.a(false);
    this.an.setMessage(null);
    ai();
  }

  private void c(ThreadSummary paramThreadSummary)
  {
    e("mark_as_spam");
    this.aa.a(paramThreadSummary);
  }

  private void c(boolean paramBoolean)
  {
    if (this.aF);
    while (true)
    {
      return;
      this.an.setVisibility(8);
      if (paramBoolean)
      {
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(400L);
        localAlphaAnimation.setFillAfter(true);
        localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
        this.aA.A().setAnimation(localAlphaAnimation);
      }
      this.aF = true;
      if (this.aP != null)
      {
        this.aA.c();
        this.aA.M().a(this.aP);
      }
      X();
    }
  }

  private void e(String paramString)
  {
    a(new HoneyClientEvent("click").e("opt_menu_item").f(paramString));
  }

  private void i(boolean paramBoolean)
  {
    if (paramBoolean);
    for (ThreadViewLoader.Params localParams = new ThreadViewLoader.Params(true, true); ; localParams = new ThreadViewLoader.Params(false, false))
    {
      if (this.at != null)
      {
        this.b.a(this.at);
        this.b.a(localParams);
      }
      return;
    }
  }

  public void B()
  {
    super.B();
    this.aE = true;
    if (this.at == null)
      return;
    if (this.aO)
    {
      this.aO = false;
      ae();
    }
    while (true)
    {
      this.d.b(this.at);
      ao();
      break;
      ad();
    }
  }

  public void C()
  {
    super.C();
    this.aE = false;
    this.g.a();
  }

  public void D()
  {
    super.D();
    this.au.b();
    if (this.g != null)
      this.g.a();
  }

  public void L()
  {
    if (this.d != null)
    {
      this.d.b(this.at);
      ao();
    }
  }

  public String M()
  {
    return this.at;
  }

  public boolean N()
  {
    int j = 1;
    if (this.aK == ThreadViewFragment.State.CONTACTCARD)
      if (this.aC.L())
        this.aC.d();
    while (true)
    {
      return j;
      this.aC.M();
      if (this.f.e())
      {
        am();
        an();
        aj();
        continue;
      }
      j = 0;
    }
  }

  public void O()
  {
    this.az.a();
    if (this.ai != null)
      this.ai.b();
    this.aA.a();
    if (this.b != null)
      this.b.a(null);
    this.at = null;
    this.aM = ThreadViewLoader.a;
  }

  void P()
  {
    this.aA.A().postDelayed(new ThreadViewFragment.8(this), 300L);
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903417, paramViewGroup, false);
  }

  public String a()
  {
    return "thread_view";
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.au = new ThreadViewFragment.1(this, p());
  }

  public void a(Menu paramMenu)
  {
    super.a(paramMenu);
    if ((this.aK == ThreadViewFragment.State.MESSAGES) && (MessagingIdUtil.g(M())))
      paramMenu.removeItem(2131298011);
  }

  public void a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.a(paramMenu, paramMenuInflater);
    if (this.aK == ThreadViewFragment.State.MESSAGES)
      paramMenuInflater.inflate(2131755011, paramMenu);
  }

  public void a(NavigableFragment.Listener paramListener)
  {
    this.aR = paramListener;
  }

  public void a(FbTitleBar paramFbTitleBar)
  {
    this.am = paramFbTitleBar;
  }

  public void a(ComposeFragment.InitParams paramInitParams)
  {
    this.aP = paramInitParams;
  }

  public void a(ComposeMode paramComposeMode)
  {
    this.aq.a(paramComposeMode);
    this.ao.setComposeMode(paramComposeMode);
  }

  public void a(ModifyThreadParams paramModifyThreadParams)
  {
    if (this.ak != null);
    while (true)
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("modifyThreadParams", paramModifyThreadParams);
      OrcaServiceOperationFactory.OrcaServiceOperation localOrcaServiceOperation = this.aj.a("modify_thread", localBundle);
      localOrcaServiceOperation.a(new DialogBasedProgressIndicator(p(), 2131362481));
      this.ak = localOrcaServiceOperation.d();
      Futures.a(this.ak, new ThreadViewFragment.7(this));
    }
  }

  public void a(String paramString)
  {
    this.at = paramString;
    if (!this.aN);
    while (true)
    {
      return;
      this.aA.O();
      this.aF = false;
      this.an.setVisibility(0);
      this.aM = ThreadViewLoader.a;
      if (this.aC != null)
        this.aC.P();
      U();
      ad();
      ao();
      y();
    }
  }

  public void a(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
  }

  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 31))
      Y();
    for (int j = 1; ; j = 0)
      return j;
  }

  public boolean a(MenuItem paramMenuItem)
  {
    boolean bool = true;
    int j = paramMenuItem.getItemId();
    if (j == 2131298008)
    {
      e("refresh");
      ae();
    }
    while (true)
    {
      return bool;
      ThreadSummary localThreadSummary = this.aM.a;
      if (j == 2131298010)
      {
        if (localThreadSummary == null)
          continue;
        e("archive");
        this.Z.a(localThreadSummary);
        continue;
      }
      if (j == 2131298011)
      {
        if (localThreadSummary == null)
          continue;
        e("mark_as_spam");
        b(localThreadSummary);
        continue;
      }
      if (j == 2131298007)
      {
        if (localThreadSummary == null)
          continue;
        e("delete");
        ag();
        continue;
      }
      bool = super.a(paramMenuItem);
    }
  }

  public void a_(int paramInt)
  {
    if (paramInt == 2131298008)
      ae();
    while (true)
    {
      return;
      ThreadSummary localThreadSummary = this.aM.a;
      if (paramInt == 2131298010)
      {
        if (localThreadSummary == null)
          continue;
        e("archive");
        this.Z.a(localThreadSummary);
        continue;
      }
      if (paramInt == 2131298011)
      {
        if (localThreadSummary == null)
          continue;
        e("mark_as_spam");
        b(localThreadSummary);
        continue;
      }
      if ((paramInt != 2131298007) || (localThreadSummary == null))
        continue;
      e("delete");
      ag();
    }
  }

  public List<ExportMenuToFbHostActivity.CustomFbHostMenuItem> b()
  {
    ArrayList localArrayList1 = new ArrayList();
    if (StringUtil.a(M()));
    for (ArrayList localArrayList2 = localArrayList1; ; localArrayList2 = localArrayList1)
    {
      return localArrayList2;
      localArrayList1.add(new ExportMenuToFbHostActivity.CustomFbHostMenuItem(2131298008, 2131362572, 2130838625, true, null));
      localArrayList1.add(new ExportMenuToFbHostActivity.CustomFbHostMenuItem(2131298010, 2131362577, 2130838619, true, null));
      if (!MessagingIdUtil.g(M()))
        localArrayList1.add(new ExportMenuToFbHostActivity.CustomFbHostMenuItem(2131298011, 2131362578, 2130838626, true, null));
      localArrayList1.add(new ExportMenuToFbHostActivity.CustomFbHostMenuItem(2131298007, 2131362580, 2130838621, true, null));
    }
  }

  public void b(boolean paramBoolean)
  {
    this.aJ = paramBoolean;
    ao();
    X();
  }

  public void c()
  {
    this.aO = true;
  }

  public void c(String paramString)
  {
    this.aL = paramString;
  }

  public void d()
  {
    this.aQ = true;
  }

  public void d(Bundle paramBundle)
  {
    if (this.at == null)
      BLog.e(a, "threadID wasn't set before fragment was attached to activity!");
    R();
    S();
    ((OverlayLayout)g(2131297488)).setBackgroundDrawable(new ColorDrawable(-1));
    this.aq = new LocationNuxController(this.ae);
    this.aq.a(this.ar, this.as);
    this.aA = ((ThreadViewMessageFragmentTab)this.f.a(2131297491));
    this.aA.a(this.aq);
    this.aA.a(this);
    if ((paramBundle != null) && (paramBundle.containsKey("state")));
    for (this.aK = ((ThreadViewFragment.State)Enum.valueOf(ThreadViewFragment.State.class, paramBundle.getString("state"))); ; this.aK = ThreadViewFragment.State.MESSAGES)
    {
      this.b.b(this.aL);
      if (this.f.a("groupContactCard") != null)
      {
        ab();
        if (this.aK != ThreadViewFragment.State.GROUP_CONTACTCARD)
        {
          this.aD.a(this.at);
          FragmentTransaction localFragmentTransaction3 = this.f.a();
          localFragmentTransaction3.b(this.aD);
          localFragmentTransaction3.a();
        }
      }
      if (this.f.a("contactCard") != null)
      {
        aa();
        if (this.aK != ThreadViewFragment.State.CONTACTCARD)
        {
          V();
          FragmentTransaction localFragmentTransaction2 = this.f.a();
          localFragmentTransaction2.b(this.aC);
          localFragmentTransaction2.a();
        }
      }
      if (this.f.a("mapForContactCard") != null)
      {
        ac();
        if (this.aK != ThreadViewFragment.State.MAP)
        {
          FragmentTransaction localFragmentTransaction1 = this.f.a();
          localFragmentTransaction1.b(this.aB);
          localFragmentTransaction1.a();
        }
      }
      b(this.aK);
      this.b.a(new ThreadViewFragment.2(this));
      this.au.a();
      this.aN = true;
      U();
      f(true);
      super.d(paramBundle);
      return;
    }
  }

  public void d(String paramString)
  {
    if (this.aA != null)
      this.aA.c(paramString);
  }

  public void d(boolean paramBoolean)
  {
    super.d(paramBoolean);
    if (!paramBoolean)
    {
      T();
      an();
    }
    while (true)
    {
      return;
      if (this.af != null)
        this.af.a();
      if (this.ag == null)
        continue;
      this.ag.a();
    }
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putString("state", this.aK.toString());
  }

  public void f()
  {
    super.f();
    this.au.a(true);
  }

  public void g()
  {
    super.g();
    this.au.a(false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewFragment
 * JD-Core Version:    0.6.0
 */