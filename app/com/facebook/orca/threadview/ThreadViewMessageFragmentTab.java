package com.facebook.orca.threadview;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView.AdapterContextMenuInfo;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.common.util.TriState;
import com.facebook.orca.activity.OrcaFragment;
import com.facebook.orca.annotations.IsDeliveredReadReceiptEnabled;
import com.facebook.orca.annotations.MeUserId;
import com.facebook.orca.attachments.AttachmentDataFactory;
import com.facebook.orca.attachments.AudioRecorder;
import com.facebook.orca.audio.AudioClipPlayerQueue;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.cache.SaveDraftManager;
import com.facebook.orca.cache.SendMessageManager;
import com.facebook.orca.cache.ThreadDisplayCache;
import com.facebook.orca.cache.ThreadDisplayCache.ThreadSnippet;
import com.facebook.orca.common.dialogs.ErrorDialogBuilder;
import com.facebook.orca.common.ui.widgets.SlidingOutSuggestionView;
import com.facebook.orca.common.ui.widgets.listview.ListViewScrollStateHelper;
import com.facebook.orca.common.ui.widgets.listview.ScrollState;
import com.facebook.orca.common.ui.widgets.listview.ScrollState.ScrollPosition;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.compose.ComposeFragment;
import com.facebook.orca.compose.ComposeMode;
import com.facebook.orca.compose.LocationNuxController;
import com.facebook.orca.compose.MessageDraft;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.messageview.MessageViewActivity;
import com.facebook.orca.mutators.DeleteMessagesActivity;
import com.facebook.orca.notify.NotificationSettingsUtil;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.presence.PresenceState;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.threads.ThreadSnippetUtil;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.CanonicalThreadPresenceHelper;
import com.facebook.orca.users.CanonicalThreadPresenceHelper.Listener;
import com.facebook.orca.users.UserKey;
import com.facebook.widget.BetterListView;
import com.facebook.widget.animatablelistview.AnimatingListAdapter;
import com.facebook.widget.animatablelistview.AnimatingListTransactionBuilder;
import com.facebook.widget.animatablelistview.AnimatingListViewScrollStateController;
import com.facebook.widget.listview.EmptyListViewItem;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.facebook.orca.threadview.RowItem;>;
import java.util.Map;
import javax.inject.Provider;

public class ThreadViewMessageFragmentTab extends OrcaFragment
{
  private static final Class<?> a = ThreadViewMessageFragmentTab.class;
  private DataCache Y;
  private Handler Z;
  private PresenceState aA = PresenceState.a;
  private CanonicalThreadPresenceHelper.Listener aB;
  private MessagesCollection aC;
  private ThreadSummary aD;
  private List<Message> aE;
  private String aF;
  private Drawable aG;
  private Drawable aH;
  private AttachmentDataFactory aa;
  private ThreadDisplayCache ab;
  private SaveDraftManager ac;
  private ThreadSnippetUtil ad;
  private Provider<String> ae;
  private AnalyticsLogger af;
  private AudioClipPlayerQueue ag;
  private AudioRecorder ah;
  private ViewGroup ai;
  private View aj;
  private BetterListView ak;
  private EmptyListViewItem al;
  private ViewGroup am;
  private SlidingOutSuggestionView an;
  private SlidingOutSuggestionView ao;
  private MuteThreadWarningController ap;
  private SmsUpsellController aq;
  private ComposeFragment ar;
  private View as;
  private LocationNuxController at;
  private ThreadMessageFragmentHost au;
  private String av;
  private ComposeMode aw = ComposeMode.SHRUNK;
  private TriState ax;
  private boolean ay = false;
  private CanonicalThreadPresenceHelper az;
  private AnimatingListAdapter<RowItem> b;
  private InputMethodManager c;
  private SendMessageManager d;
  private ClipboardManager e;
  private MessageDeliveredReadStateDisplayUtil f;
  private AnimatingListViewScrollStateController<RowItem> g;
  private ListViewScrollStateHelper h;
  private Provider<Boolean> i;

  private RowItem P()
  {
    if (this.b.isEmpty());
    for (RowItem localRowItem = null; ; localRowItem = null)
      do
      {
        return localRowItem;
        localRowItem = (RowItem)this.b.getItem(0);
      }
      while ((localRowItem == MessageListAdapter.a) || (localRowItem == MessageListAdapter.b) || (localRowItem == MessageListAdapter.c));
  }

  private void R()
  {
    MessageDraft localMessageDraft;
    if (this.ac.a(this.av))
      localMessageDraft = this.ac.b(this.av);
    while (true)
    {
      if (localMessageDraft != null)
        this.ar.a(localMessageDraft);
      return;
      ThreadSummary localThreadSummary = this.aD;
      localMessageDraft = null;
      if (localThreadSummary == null)
        continue;
      localMessageDraft = this.aD.y();
    }
  }

  private void S()
  {
    MessageDraft localMessageDraft = this.ar.b();
    this.ac.a(this.av, localMessageDraft);
  }

  private void T()
  {
    if (this.ar.L())
      ErrorDialogBuilder.a(p()).a(2131362339).b(2131362538).a();
    while (true)
    {
      return;
      Message localMessage = this.ar.d();
      this.d.a(localMessage, "thread_view", this.aF);
      U();
      this.ar.M();
      this.ar.N();
      if (this.at == null)
        continue;
      this.at.a();
    }
  }

  private void U()
  {
    int j = this.ak.getCount();
    if ((j > 0) && (this.ak.getLastVisiblePosition() < j - 1))
      this.ak.smoothScrollToPosition(j - 1);
  }

  private boolean V()
  {
    if (this.b.isEmpty());
    ImmutableList localImmutableList;
    for (boolean bool = false; ; bool = (RowItem)localImmutableList.get(-1 + localImmutableList.size()) instanceof RowTypingItem)
    {
      return bool;
      localImmutableList = this.b.d();
    }
  }

  private List<RowItem> a(MessagesCollection paramMessagesCollection, List<Message> paramList, ThreadSummary paramThreadSummary, boolean paramBoolean)
  {
    ArrayList localArrayList = Lists.a();
    Iterator localIterator1 = paramList.iterator();
    RowMessageItem localRowMessageItem2;
    for (Object localObject1 = null; localIterator1.hasNext(); localObject1 = localRowMessageItem2)
    {
      Message localMessage2 = (Message)localIterator1.next();
      localRowMessageItem2 = new RowMessageItem(localMessage2, (String)this.ae.b());
      localArrayList.add(localRowMessageItem2);
      a((RowMessageItem)localObject1, localMessage2);
    }
    if (((Boolean)this.i.b()).booleanValue())
    {
      Map localMap = this.f.a(paramMessagesCollection, paramThreadSummary);
      Iterator localIterator3 = paramMessagesCollection.b().iterator();
      Object localObject2 = localObject1;
      if (localIterator3.hasNext())
      {
        Message localMessage1 = (Message)localIterator3.next();
        MessageDeliveredReadInfo localMessageDeliveredReadInfo = (MessageDeliveredReadInfo)localMap.get(localMessage1.a());
        RowReceiptItem localRowReceiptItem = null;
        if (localMessageDeliveredReadInfo != null)
        {
          int j = ThreadViewMessageFragmentTab.8.a[localMessageDeliveredReadInfo.d().ordinal()];
          localRowReceiptItem = null;
          switch (j)
          {
          default:
          case 1:
          case 2:
          case 3:
          }
        }
        while (true)
        {
          RowMessageItem localRowMessageItem1 = new RowMessageItem(localMessage1, (String)this.ae.b(), this.aa.b(localMessage1), this.aa.e(localMessage1), localRowReceiptItem);
          localArrayList.add(localRowMessageItem1);
          a(localObject2, localMessage1);
          localObject2 = localRowMessageItem1;
          break;
          if (paramThreadSummary.g())
          {
            localRowReceiptItem = RowReceiptItem.a(localMessageDeliveredReadInfo.a(), localMessage1, localMessageDeliveredReadInfo.e());
            continue;
          }
          boolean bool1 = localMessage1.q();
          boolean bool2 = false;
          if (!bool1)
          {
            boolean bool3 = Objects.equal(localMessage1.f().e(), this.Y.b());
            bool2 = false;
            if (bool3)
              bool2 = true;
          }
          localRowReceiptItem = RowReceiptItem.a(localMessageDeliveredReadInfo.a(), localMessage1, bool2, paramThreadSummary.i().size());
          continue;
          localRowReceiptItem = RowReceiptItem.a(localMessageDeliveredReadInfo.b(), localMessage1);
          continue;
          localRowReceiptItem = RowReceiptItem.b(localMessageDeliveredReadInfo.c(), localMessage1);
        }
      }
    }
    else
    {
      Iterator localIterator2 = paramMessagesCollection.b().iterator();
      while (localIterator2.hasNext())
        localArrayList.add(new RowMessageItem((Message)localIterator2.next(), null));
    }
    if ((paramBoolean) && (this.aA.c()) && (this.az.b()))
      localArrayList.add(0, new RowTypingItem(this.az.a().a()));
    return (List<RowItem>)localArrayList;
  }

  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.ay);
    while (true)
    {
      return;
      if ((paramInt1 == 0) && (paramInt2 > 0) && (paramInt3 > 0))
      {
        RowItem localRowItem = (RowItem)this.b.getItem(0);
        if (((localRowItem != MessageListAdapter.b) && (localRowItem != MessageListAdapter.a)) || (this.au == null))
          continue;
        this.au.a(false);
        continue;
      }
    }
  }

  private void a(View paramView1, View paramView2)
  {
    ViewParent localViewParent;
    if (paramView2 != null)
    {
      localViewParent = paramView2.getParent();
      if (localViewParent == null)
        break label49;
      if (localViewParent != this.as)
        break label39;
    }
    label39: label49: for (int j = 1; ; j = 0)
    {
      if (j != 0)
        c();
      return;
      localViewParent = null;
      break;
      localViewParent = localViewParent.getParent();
      break;
    }
  }

  private void a(ScrollState paramScrollState)
  {
    if (paramScrollState.a() == ScrollState.ScrollPosition.BOTTOM)
      U();
    label82: 
    while (true)
    {
      return;
      for (int j = 0; ; j++)
      {
        if (j >= this.b.getCount())
          break label82;
        long l = this.b.getItemId(j);
        Integer localInteger = (Integer)paramScrollState.b().get(Long.valueOf(l));
        if (localInteger == null)
          continue;
        if (j <= 0)
          break;
        this.ak.setSelectionFromTop(j, localInteger.intValue());
        break;
      }
    }
  }

  private void a(ComposeMode paramComposeMode)
  {
    this.ar.a(paramComposeMode);
    this.au.a(paramComposeMode);
    this.ai.requestLayout();
  }

  private void a(PresenceState paramPresenceState)
  {
    if (this.aA == paramPresenceState);
    while (true)
    {
      return;
      b(paramPresenceState);
    }
  }

  private void a(ThreadSummary paramThreadSummary)
  {
    ThreadSummary localThreadSummary = this.aD;
    this.aD = paramThreadSummary;
    if (localThreadSummary == null)
      R();
  }

  private void a(RowItem paramRowItem)
  {
    RowItem localRowItem = P();
    AnimatingListTransactionBuilder localAnimatingListTransactionBuilder = this.b.a();
    if ((localRowItem == MessageListAdapter.a) || (localRowItem == MessageListAdapter.b) || (localRowItem == MessageListAdapter.c))
      localAnimatingListTransactionBuilder.a(0);
    if (paramRowItem != null)
      localAnimatingListTransactionBuilder.a(0, paramRowItem);
    localAnimatingListTransactionBuilder.b();
  }

  private void a(RowMessageItem paramRowMessageItem, Message paramMessage)
  {
    if (paramRowMessageItem != null)
      paramRowMessageItem.a(a(3600000L, paramRowMessageItem.b(), paramMessage));
  }

  private void a(boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = V();
    boolean bool3;
    if ((!bool2) && (this.aA.c()))
    {
      bool3 = bool1;
      if ((!bool2) || (this.aA.c()))
        break label72;
      label38: if ((!bool1) || (!paramBoolean))
        break label77;
      this.ak.postDelayed(new ThreadViewMessageFragmentTab.7(this), 1000L);
    }
    while (true)
    {
      return;
      bool3 = false;
      break;
      label72: bool1 = false;
      break label38;
      label77: if ((!bool3) && (!bool1))
        continue;
      List localList = a(this.aC, this.aE, this.aD, false);
      new ThreadViewMessagesAdapterUpdater(this.b).a(bool3, Lists.a(localList), this.az.a().a());
    }
  }

  private boolean a(long paramLong, Message paramMessage1, Message paramMessage2)
  {
    if (paramMessage1.c() - paramMessage2.c() > paramLong);
    for (int j = 1; ; j = 0)
      return j;
  }

  private void b(PresenceState paramPresenceState)
  {
    this.aA = paramPresenceState;
    a(true);
  }

  private void b(RowItem paramRowItem)
  {
    if (this.aw == ComposeMode.EXPANDED)
      d();
    while (true)
    {
      return;
      if ((paramRowItem instanceof RowMessageItem))
      {
        RowMessageItem localRowMessageItem = (RowMessageItem)paramRowItem;
        Message localMessage = localRowMessageItem.b();
        if (localMessage.q())
          continue;
        Intent localIntent = new Intent(p(), MessageViewActivity.class);
        localIntent.setAction("android.intent.action.VIEW");
        localIntent.putExtra("thread_id", this.av);
        localIntent.putExtra("message", localMessage);
        RowReceiptItem localRowReceiptItem = localRowMessageItem.d();
        if ((localRowReceiptItem != null) && (localRowReceiptItem.b() == RowReceiptItem.Type.GROUP_READ))
          localIntent.putParcelableArrayListExtra("readers", Lists.a(localRowReceiptItem.c()));
        if (!this.aD.g())
        {
          ArrayList localArrayList = f(this.b.c().indexOf(paramRowItem));
          if (!localArrayList.isEmpty())
            localIntent.putParcelableArrayListExtra("other_readers", localArrayList);
        }
        this.af.a(new HoneyClientEvent("click").e("message").f(localMessage.a()).b("threadid", localMessage.b()));
        a(localIntent);
        continue;
      }
      if ((paramRowItem != MessageListAdapter.b) && (paramRowItem != MessageListAdapter.a))
        continue;
      this.au.a(true);
    }
  }

  private Message c(MenuItem paramMenuItem)
  {
    AdapterView.AdapterContextMenuInfo localAdapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
    Object localObject = this.b.getItem(localAdapterContextMenuInfo.position);
    if ((localObject instanceof RowMessageItem));
    for (Message localMessage = ((RowMessageItem)localObject).b(); ; localMessage = null)
      return localMessage;
  }

  private void c(Bundle paramBundle)
  {
    this.aw = ((ComposeMode)paramBundle.getSerializable("composeMode"));
    this.ax = ((TriState)paramBundle.getSerializable("canReplyTo"));
    if (this.aw != ComposeMode.SHRUNK)
      c();
  }

  private ArrayList<ParticipantInfo> f(int paramInt)
  {
    HashMap localHashMap = Maps.a();
    for (int j = paramInt + 1; j < this.b.getCount(); j++)
    {
      Object localObject = this.b.getItem(j);
      if (!(localObject instanceof RowMessageItem))
        continue;
      RowMessageItem localRowMessageItem = (RowMessageItem)localObject;
      if ((localRowMessageItem.d() != null) && (localRowMessageItem.d().b() == RowReceiptItem.Type.GROUP_READ))
      {
        Iterator localIterator = localRowMessageItem.d().c().iterator();
        while (localIterator.hasNext())
        {
          RowReceiptParticipant localRowReceiptParticipant = (RowReceiptParticipant)localIterator.next();
          UserKey localUserKey2 = localRowReceiptParticipant.a().e();
          if (localHashMap.containsKey(localUserKey2))
            continue;
          localHashMap.put(localUserKey2, localRowReceiptParticipant.a());
        }
      }
      if (localRowMessageItem.b().r() != 0)
        continue;
      UserKey localUserKey1 = localRowMessageItem.b().f().e();
      if ((localHashMap.containsKey(localUserKey1)) || (Objects.equal(localUserKey1, this.Y.b().c())))
        continue;
      localHashMap.put(localUserKey1, localRowMessageItem.b().f());
    }
    return Lists.a(localHashMap.values());
  }

  public void B()
  {
    super.B();
    this.ap.a();
    if (this.aq != null)
      this.aq.a();
  }

  public void C()
  {
    super.C();
    S();
    this.Z.removeCallbacksAndMessages(null);
  }

  public void D()
  {
    super.D();
    this.au = null;
  }

  void L()
  {
    this.as.setVisibility(8);
    a(ComposeMode.SHRUNK);
    this.aj.requestFocus();
    this.c.hideSoftInputFromWindow(this.aj.getWindowToken(), 0);
    this.am.setVisibility(0);
  }

  public ComposeFragment M()
  {
    return this.ar;
  }

  public void N()
  {
    a(MessageListAdapter.b);
    this.ay = true;
  }

  public void O()
  {
    if (this.b != null)
      this.b.b();
    if (this.ar != null)
      this.ar.O();
    this.aD = null;
    this.aC = null;
    this.aE = null;
    this.av = null;
    this.aA = PresenceState.a;
    if (this.az != null)
      this.az.a(null);
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903420, paramViewGroup, false);
  }

  public void a()
  {
    this.az.a(false);
    this.ar.P();
    S();
    if (this.aw == ComposeMode.EXPANDED)
      d();
  }

  public void a(LocationNuxController paramLocationNuxController)
  {
    this.at = paramLocationNuxController;
    if (this.ar != null)
      this.ar.a(paramLocationNuxController);
  }

  public void a(ThreadMessageFragmentHost paramThreadMessageFragmentHost)
  {
    this.au = paramThreadMessageFragmentHost;
  }

  public void a(ThreadViewLoader.Result paramResult)
  {
    if ((paramResult.a == this.aD) && (paramResult.b == this.aC) && (paramResult.c == this.aE))
      return;
    if ((this.aD == null) || (!Objects.equal(paramResult.a.a(), this.aD.a())));
    for (int j = 1; ; j = 0)
    {
      a(paramResult.a);
      this.aC = paramResult.b;
      this.aE = paramResult.c;
      this.az.a(this.aD);
      TriState localTriState;
      label112: ScrollState localScrollState;
      label143: List localList;
      if (this.aD.u())
      {
        localTriState = TriState.YES;
        this.ax = localTriState;
        if ((this.ax != TriState.YES) || (this.as.getVisibility() != 8))
          break label380;
        d();
        localScrollState = this.h.c(this.ak);
        localList = a(this.aC, this.aE, this.aD, true);
        if ((!this.aC.e()) && (!this.aC.d()))
        {
          if (!this.ay)
            break label409;
          localList.add(MessageListAdapter.b);
        }
      }
      while (true)
      {
        Message localMessage = this.aC.c();
        if (localMessage != null)
        {
          long l = Math.max(localMessage.c(), localMessage.e());
          ThreadDisplayCache.ThreadSnippet localThreadSnippet = this.ab.b(this.av);
          if (localThreadSnippet != null)
            l = Math.max(l, localThreadSnippet.c());
          this.ab.a(this.av, new ThreadDisplayCache.ThreadSnippet(this.ad.a(localMessage), localMessage.f(), l));
        }
        new ThreadViewMessagesAdapterUpdater(this.b).a(Lists.a(localList));
        this.ak.setEmptyView(this.al);
        a(localScrollState);
        this.ay = false;
        if (j == 0)
          break;
        this.az.a(true);
        b(this.az.c());
        break;
        localTriState = TriState.NO;
        break label112;
        label380: if ((this.ax != TriState.NO) || (this.as.getVisibility() == 8))
          break label143;
        L();
        break label143;
        label409: localList.add(MessageListAdapter.a);
      }
    }
  }

  public void a(String paramString)
  {
    if (Objects.equal(paramString, this.av));
    while (true)
    {
      return;
      O();
      this.av = paramString;
      if (this.ap != null)
        this.ap.a(paramString);
      if (this.ar == null)
        continue;
      this.ar.a(paramString);
    }
  }

  public void b()
  {
    a(MessageListAdapter.c);
  }

  public boolean b(MenuItem paramMenuItem)
  {
    int j = 1;
    if (paramMenuItem.getGroupId() != 2131296337)
      j = super.b(paramMenuItem);
    while (true)
    {
      return j;
      if (paramMenuItem.getItemId() == 0)
      {
        Message localMessage2 = c(paramMenuItem);
        if (localMessage2 != null)
        {
          this.af.a(new HoneyClientEvent("click").e("context_menu_item").f("MENU_ITEM_COPY"));
          this.e.setText(localMessage2.h());
          continue;
        }
      }
      else if (paramMenuItem.getItemId() == j)
      {
        Message localMessage1 = c(paramMenuItem);
        if (localMessage1 != null)
        {
          Intent localIntent = new Intent(p(), DeleteMessagesActivity.class);
          localIntent.putExtra("thread_id", localMessage1.b());
          localIntent.putExtra("message_ids", ImmutableList.a(localMessage1.a()));
          this.af.a(new HoneyClientEvent("click").e("context_menu_item").f("MENU_ITEM_DELETE"));
          a(localIntent);
        }
      }
      boolean bool = super.b(paramMenuItem);
    }
  }

  public void c()
  {
    if (this.ax == TriState.NO);
    while (true)
    {
      return;
      this.as.setVisibility(0);
      a(ComposeMode.EXPANDED);
      this.aw = ComposeMode.EXPANDED;
      this.ak.setSelector(this.aH);
      this.am.setVisibility(8);
      U();
    }
  }

  public void c(String paramString)
  {
    this.aF = paramString;
  }

  public void d()
  {
    if ((this.ax == TriState.NO) || ((this.aw == ComposeMode.SHRUNK) && (this.as.getVisibility() != 8)));
    while (true)
    {
      return;
      this.as.setVisibility(0);
      a(ComposeMode.SHRUNK);
      this.aw = ComposeMode.SHRUNK;
      this.aj.requestFocus();
      this.c.hideSoftInputFromWindow(this.aj.getWindowToken(), 0);
      this.ak.setSelector(this.aG);
      this.am.setVisibility(0);
    }
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    FbInjector localFbInjector = Q();
    MessageListAdapter localMessageListAdapter = (MessageListAdapter)localFbInjector.a(MessageListAdapter.class);
    this.c = ((InputMethodManager)localFbInjector.a(InputMethodManager.class));
    this.d = ((SendMessageManager)localFbInjector.a(SendMessageManager.class));
    this.e = ((ClipboardManager)localFbInjector.a(ClipboardManager.class));
    this.f = ((MessageDeliveredReadStateDisplayUtil)localFbInjector.a(MessageDeliveredReadStateDisplayUtil.class));
    this.az = ((CanonicalThreadPresenceHelper)localFbInjector.a(CanonicalThreadPresenceHelper.class));
    this.i = localFbInjector.b(Boolean.class, IsDeliveredReadReceiptEnabled.class);
    this.Y = ((DataCache)localFbInjector.a(DataCache.class));
    this.aa = ((AttachmentDataFactory)localFbInjector.a(AttachmentDataFactory.class));
    this.ab = ((ThreadDisplayCache)localFbInjector.a(ThreadDisplayCache.class));
    this.ac = ((SaveDraftManager)localFbInjector.a(SaveDraftManager.class));
    this.ad = ((ThreadSnippetUtil)localFbInjector.a(ThreadSnippetUtil.class));
    this.ae = localFbInjector.b(String.class, MeUserId.class);
    this.af = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.ag = ((AudioClipPlayerQueue)localFbInjector.a(AudioClipPlayerQueue.class));
    this.ah = ((AudioRecorder)localFbInjector.a(AudioRecorder.class));
    this.ai = ((ViewGroup)g(2131297501));
    this.aj = g(2131297502);
    this.ak = ((BetterListView)g(2131297506));
    this.al = ((EmptyListViewItem)g(2131297507));
    this.am = ((ViewGroup)g(2131297503));
    this.an = ((SlidingOutSuggestionView)g(2131297504));
    this.ao = ((SlidingOutSuggestionView)g(2131297505));
    this.ar = ((ComposeFragment)K().a(2131297493));
    if (this.at != null)
      this.ar.a(this.at);
    this.as = this.ar.A();
    localMessageListAdapter.a(new ThreadViewMessageFragmentTab.1(this));
    this.ak.setOnItemClickListener(new ThreadViewMessageFragmentTab.2(this));
    this.b = new AnimatingListAdapter(p(), localMessageListAdapter);
    this.ak.setAdapter(this.b);
    this.ak.setDividerHeight(0);
    this.ak.setStackFromBottom(true);
    this.ak.setTranscriptMode(1);
    this.ak.setItemsCanFocus(true);
    this.ak.setOnScrollListener(new ThreadViewMessageFragmentTab.3(this));
    this.ak.setEmptyView(this.al);
    this.h = new ListViewScrollStateHelper();
    this.g = new AnimatingListViewScrollStateController(this.ak, this.b);
    a(this.ak);
    this.aG = this.ak.getSelector();
    this.aH = q().getDrawable(2130838995);
    this.al.setMessage(q().getString(2131362434));
    if ((this.av != null) && (MessagingIdUtil.g(this.av)))
      this.aq = new SmsUpsellController((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class), this.ao);
    while (true)
    {
      this.ap = new MuteThreadWarningController((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class), (NotificationSettingsUtil)localFbInjector.a(NotificationSettingsUtil.class), this.an);
      this.ap.a(this.av);
      A().getViewTreeObserver().addOnGlobalFocusChangeListener(new ThreadViewMessageFragmentTab.4(this));
      if (this.av != null)
        this.ar.a(this.av);
      this.ar.a(ComposeMode.SHRUNK);
      this.ar.a(new ThreadViewMessageFragmentTab.5(this));
      this.aB = new ThreadViewMessageFragmentTab.6(this);
      this.az.a(this.aB);
      this.Z = new Handler();
      if (paramBundle != null)
        c(paramBundle);
      return;
      this.ao.setVisibility(8);
    }
  }

  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ag.a();
      this.ah.a();
    }
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putSerializable("composeMode", this.aw);
    paramBundle.putSerializable("canReplyTo", this.ax);
  }

  public void f()
  {
    super.f();
    this.az.a(true);
    b(this.az.c());
  }

  public void g()
  {
    super.g();
    this.az.a(false);
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    if (paramView == this.ak)
    {
      AdapterView.AdapterContextMenuInfo localAdapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      Object localObject = this.b.getItem(localAdapterContextMenuInfo.position);
      if ((localObject instanceof RowMessageItem))
      {
        paramContextMenu.setHeaderTitle(2131362428);
        if (!StringUtil.a(((RowMessageItem)localObject).b().h()))
          paramContextMenu.add(2131296337, 0, 0, 2131362429);
        paramContextMenu.add(2131296337, 1, 1, 2131362430);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewMessageFragmentTab
 * JD-Core Version:    0.6.0
 */