package com.facebook.katana.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.graphql.model.FeedStory;
import com.facebook.ipc.notifications.GQLNotificationsContract;
import com.facebook.ipc.notifications.NotificationsContract;
import com.facebook.katana.activity.notifications.NotificationsAdapter;
import com.facebook.katana.activity.notifications.NotificationsAdapter.FQLNotificationsRenderer;
import com.facebook.katana.activity.notifications.NotificationsAdapter.GraphQLNotificationsRenderer;
import com.facebook.katana.activity.notifications.NotificationsAdapter.NotificationsRenderer;
import com.facebook.katana.annotations.IsFullscreenJewelsEnabled;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.model.NotificationHelper;
import com.facebook.katana.service.method.NotificationsMarkRead;
import com.facebook.katana.util.IntentUtils;
import com.facebook.katana.util.StringUtils;
import com.facebook.notifications.annotations.IsGraphQLNotificationsEnabled;
import com.facebook.notifications.prefs.NotificationsPrefs;
import com.facebook.notifications.provider.GQLNotificationsContentProviderHelper;
import com.facebook.notifications.ui.NotificationFlyoutFragment;
import com.facebook.notifications.util.NotificationsLastUpdatedTimeUtil;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.orca.activity.FbListFragment;
import com.facebook.orca.common.ui.widgets.refreshablelistview.RefreshableListViewContainer;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Provider;

public class NotificationsFragment extends FbListFragment
{
  public static final Class<?> i = NotificationsFragment.class;
  private AppSession Y;
  private AppSessionListener Z;
  private NotificationsAdapter aa;
  private View ab;
  private RefreshableListViewContainer ac;
  private View ad;
  private NotificationHelper ae;
  private NotificationsLastUpdatedTimeUtil af;
  private NotificationsContract ag;
  private GQLNotificationsContract ah;
  private Provider<Boolean> ai;
  private GQLNotificationsContentProviderHelper aj;
  private OrcaSharedPreferences ak;
  private NotificationsUtils al;
  private AndroidThreadUtil am;
  private boolean an = false;

  private void K()
  {
    this.an = false;
    this.ac.d();
    O();
    M();
  }

  private ListenableFuture<OperationResult> L()
  {
    this.an = true;
    return this.al.a(this.Y.b().userId, false);
  }

  private void M()
  {
    long l = this.af.a();
    if (l != -1L)
      this.ac.post(new NotificationsFragment.3(this, l));
  }

  private void N()
  {
    ((TextView)this.ab.findViewById(2131296644)).setText(2131363018);
  }

  private void O()
  {
    int j;
    View localView;
    int k;
    if ((this.aa == null) || (this.aa.isEmpty()))
    {
      j = 1;
      localView = this.ad;
      k = 0;
      if (j == 0)
        break label52;
    }
    while (true)
    {
      localView.setVisibility(k);
      c(this.Y.h());
      return;
      j = 0;
      break;
      label52: k = 8;
    }
  }

  private void a(FeedStory paramFeedStory, View paramView)
  {
    if (this.ak.a(NotificationsPrefs.d, false))
      NotificationFlyoutFragment.a(p(), paramFeedStory, paramView);
    while (true)
    {
      return;
      if (paramFeedStory.w())
        paramFeedStory = paramFeedStory.attachedStory;
      Intent localIntent = ((IFeedIntentBuilder)c().a(IFeedIntentBuilder.class)).a(paramFeedStory);
      if (localIntent == null)
        continue;
      ((SecureContextHelper)c().a(SecureContextHelper.class)).a(localIntent, p());
    }
  }

  public static void a(AppSession paramAppSession, Context paramContext, long[] paramArrayOfLong)
  {
    if (paramAppSession != null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = IntentUtils.a(paramArrayOfLong);
      NotificationsMarkRead.a(paramContext, StringUtils.a(",", arrayOfObject));
      paramAppSession.a(paramContext, paramArrayOfLong);
    }
  }

  private void a(boolean paramBoolean)
  {
    Object localObject;
    NotificationsFragment.1 local1;
    LoaderManager localLoaderManager;
    if (paramBoolean)
    {
      localObject = new NotificationsAdapter.GraphQLNotificationsRenderer(p(), this.aj);
      this.aa = new NotificationsAdapter(n(), null, 2, (NotificationsAdapter.NotificationsRenderer)localObject);
      local1 = new NotificationsFragment.1(this);
      localLoaderManager = z();
      if (!paramBoolean)
        break label87;
    }
    label87: for (int j = 100; ; j = 101)
    {
      localLoaderManager.a(j, null, local1);
      return;
      localObject = new NotificationsAdapter.FQLNotificationsRenderer(p());
      break;
    }
  }

  private void b(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("mobile_page");
    if (str1 != null)
    {
      String str2 = str1.split("\\?")[0];
      ((PerformanceLogger)FbInjector.a(n()).a(PerformanceLogger.class)).a("LaunchFromJewelNotification:" + str2, str1);
    }
  }

  private void b(boolean paramBoolean)
  {
    if (!b())
      if (!this.Y.h())
      {
        this.Y.f(n());
        if (paramBoolean)
          this.ac.b();
        O();
        M();
      }
    while (true)
    {
      return;
      if (!this.an)
      {
        ListenableFuture localListenableFuture = L();
        this.am.a(localListenableFuture, new NotificationsFragment.2(this));
        if (this.Y.h())
          continue;
        this.Y.f(n());
        if (paramBoolean)
          this.ac.b();
        O();
        M();
        continue;
      }
    }
  }

  private boolean b()
  {
    if (this.ai == null)
      this.ai = c().b(Boolean.class, IsGraphQLNotificationsEnabled.class);
    return Boolean.TRUE.equals(this.ai.b());
  }

  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ab.findViewById(2131296644).setVisibility(8);
      this.ab.findViewById(2131296645).setVisibility(0);
    }
    while (true)
    {
      return;
      this.ab.findViewById(2131296644).setVisibility(0);
      this.ab.findViewById(2131296645).setVisibility(8);
    }
  }

  private boolean d()
  {
    return ((Boolean)c().a(Boolean.class, IsFullscreenJewelsEnabled.class)).booleanValue();
  }

  public void B()
  {
    super.B();
    O();
    this.Y = AppSession.a(n(), true);
    if (this.Y == null);
    while (true)
    {
      return;
      this.Y.a(this.Z);
    }
  }

  public void C()
  {
    super.C();
    if (this.Y != null)
      this.Y.b(this.Z);
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.ab = paramLayoutInflater.inflate(2130903307, paramViewGroup, false);
    this.ac = ((RefreshableListViewContainer)this.ab.findViewById(2131297170));
    this.ad = this.ab.findViewById(16908292);
    this.ac.setOnRefreshListener(new NotificationsFragment.4(this));
    return this.ab;
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.Y = AppSession.a(n(), true);
    if (this.Y == null);
    while (true)
    {
      return;
      FbInjector localFbInjector = c();
      this.ag = ((NotificationsContract)localFbInjector.a(NotificationsContract.class));
      this.ah = ((GQLNotificationsContract)localFbInjector.a(GQLNotificationsContract.class));
      this.Z = new NotificationsFragment.NotificationsAppSessionListener(this, null);
      this.ae = ((NotificationHelper)localFbInjector.a(NotificationHelper.class));
      this.af = ((NotificationsLastUpdatedTimeUtil)localFbInjector.a(NotificationsLastUpdatedTimeUtil.class));
      this.al = ((NotificationsUtils)localFbInjector.a(NotificationsUtils.class));
      this.am = ((AndroidThreadUtil)localFbInjector.a(AndroidThreadUtil.class));
      this.aj = ((GQLNotificationsContentProviderHelper)localFbInjector.a(GQLNotificationsContentProviderHelper.class));
      this.ak = ((OrcaSharedPreferences)localFbInjector.a(OrcaSharedPreferences.class));
      a(b());
    }
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    N();
    ListView localListView = a();
    if (d())
    {
      Drawable localDrawable = localListView.getDivider();
      Resources localResources = p().getResources();
      int j = localResources.getDimensionPixelSize(2131230933);
      localListView.setDivider(new InsetDrawable(localDrawable, j, 0, j, 0));
      localListView.setDividerHeight(localResources.getDimensionPixelSize(2131230759));
    }
    localListView.setAdapter(this.aa);
    localListView.setOnItemClickListener(new NotificationsFragment.5(this));
    M();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.fragment.NotificationsFragment
 * JD-Core Version:    0.6.0
 */