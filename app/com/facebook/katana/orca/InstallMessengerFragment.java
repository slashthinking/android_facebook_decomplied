package com.facebook.katana.orca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.analytics.InteractionLogger;
import com.facebook.katana.util.ApplicationUtils;
import com.facebook.orca.activity.OrcaFragment;
import com.facebook.orca.contacts.favorites.InstallMessengerLoader.Result;
import com.facebook.orca.contacts.favorites.InstallMessengerLoaderFactory;
import com.facebook.orca.contacts.favorites.MobileAppDataCache;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.threadlist.ThreadListActivity;
import com.facebook.orca.users.User;
import java.util.List;

public class InstallMessengerFragment extends OrcaFragment
{
  private static final Class<?> aa = InstallMessengerFragment.class;
  private InstallMessengerLoaderFactory Y;
  private MobileAppDataCache Z;
  private Button a;
  private Button b;
  private TextView c;
  private TextView d;
  private InstallMessengerFragment.ClickThroughDestination e = InstallMessengerFragment.ClickThroughDestination.THREAD_LIST;
  private View.OnClickListener f;
  private ForceMessenger g;
  private InteractionLogger h;
  private List<User> i;

  public InstallMessengerFragment()
  {
  }

  public InstallMessengerFragment(InstallMessengerFragment.ClickThroughDestination paramClickThroughDestination)
  {
    this.e = paramClickThroughDestination;
  }

  private LoaderManager.LoaderCallbacks<InstallMessengerLoader.Result> L()
  {
    return new InstallMessengerFragment.3(this);
  }

  private void M()
  {
    Loader localLoader = z().a(0);
    if (localLoader != null)
    {
      BLog.b(aa, "stopping InstallMessengerLoader");
      localLoader.b(null);
      localLoader.p();
    }
  }

  private void a(InstallMessengerLoader.Result paramResult)
  {
    if (!s());
    while (true)
    {
      return;
      if (paramResult != null)
      {
        this.i = paramResult.b();
        a(this.i);
        continue;
      }
    }
  }

  private void a(List<User> paramList)
  {
    if (this.d == null)
      return;
    String str;
    if ((paramList == null) || (paramList.isEmpty()))
      str = "";
    while (true)
    {
      this.d.setText(str);
      break;
      if (paramList.size() == 1)
      {
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = ((User)paramList.get(0)).e();
        str = a(2131363610, arrayOfObject3);
        continue;
      }
      if (paramList.size() == 2)
      {
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = ((User)paramList.get(0)).e();
        arrayOfObject2[1] = ((User)paramList.get(1)).e();
        str = a(2131363611, arrayOfObject2);
        continue;
      }
      Object[] arrayOfObject1 = new Object[3];
      arrayOfObject1[0] = ((User)paramList.get(0)).e();
      arrayOfObject1[1] = ((User)paramList.get(1)).e();
      arrayOfObject1[2] = Integer.valueOf(-2 + paramList.size());
      str = a(2131363612, arrayOfObject1);
    }
  }

  private void b()
  {
    a(new Intent(n(), ThreadListActivity.class));
  }

  private void c()
  {
    if (this.f != null)
      this.f.onClick(this.a);
    while (true)
    {
      return;
      b();
    }
  }

  private void d()
  {
    switch (InstallMessengerFragment.4.a[this.e.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return;
      if (n().getIntent().hasExtra("canonical_thread_user"))
      {
        Intent localIntent = new Intent(n(), CanonicalThreadLauncherActivity.class);
        localIntent.putExtra("user_id", n().getIntent().getStringExtra("canonical_thread_user"));
        a(localIntent);
        continue;
      }
      c();
      continue;
      b();
    }
  }

  public void B()
  {
    super.B();
    a();
  }

  public void D()
  {
    super.D();
    M();
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.e == InstallMessengerFragment.ClickThroughDestination.THREAD_LIST_JEWEL);
    for (int j = 2130903248; ; j = 2130903247)
    {
      View localView = paramLayoutInflater.inflate(j, paramViewGroup, false);
      this.a = ((Button)localView.findViewById(2131297015));
      this.b = ((Button)localView.findViewById(2131297016));
      this.c = ((TextView)localView.findViewById(2131297013));
      this.d = ((TextView)localView.findViewById(2131297014));
      return localView;
    }
  }

  public void a()
  {
    if (ApplicationUtils.c(n()))
    {
      this.g.a(this.g.c());
      c();
    }
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.h = new InteractionLogger(p());
  }

  public void a(View.OnClickListener paramOnClickListener)
  {
    this.f = paramOnClickListener;
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.g = ((ForceMessenger)Q().a(ForceMessenger.class));
    ForceMessenger.Stage localStage = this.g.c();
    if (localStage == ForceMessenger.Stage.INSTALL_NOW)
    {
      this.a.setVisibility(8);
      this.c.setText(2131363609);
      this.b.setText(2131363615);
    }
    this.g.a(localStage);
    if (n().getIntent().hasExtra("click_through"))
      this.e = ((InstallMessengerFragment.ClickThroughDestination)n().getIntent().getSerializableExtra("click_through"));
    this.a.setOnClickListener(new InstallMessengerFragment.1(this));
    this.b.setOnClickListener(new InstallMessengerFragment.2(this));
    this.Z = ((MobileAppDataCache)Q().a(MobileAppDataCache.class));
    this.i = this.Z.b();
    a(this.i);
    this.Y = ((InstallMessengerLoaderFactory)Q().a(InstallMessengerLoaderFactory.class));
    z().a(0, null, L());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.InstallMessengerFragment
 * JD-Core Version:    0.6.0
 */