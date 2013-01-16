package com.facebook.katana.activity.photos;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.content.SecureContextHelper;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.media.CreateEditAlbumActivity;
import com.facebook.katana.activity.media.vault.VaultSettingsActivity;
import com.facebook.katana.activity.media.vault.VaultSyncScreenFragment;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.model.FacebookPhotoSet;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.service.vault.VaultHelpers;
import com.facebook.katana.view.tabs.BlueTabIndicatorView;
import com.facebook.orca.common.ui.tabs.FragmentTabManager;
import com.facebook.orca.common.ui.tabs.FragmentTabManager.FragmentStrategy;
import com.facebook.orca.common.ui.titlebar.FbTitleBarUtil;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.photos.photogallery.GalleryLauncher;
import com.facebook.photos.photogallery.GalleryLauncherHost;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Map;

public class PhotosTabActivity extends BaseFacebookActivity
  implements TabHost.OnTabChangeListener, GalleryLauncherHost
{
  private Map<String, Integer> n;
  private int o;
  private SecureContextHelper p;
  private FragmentTabManager q;
  private TabHost r;
  private AppSession s;
  private long t;
  private int u = -1;
  private String v = null;
  private GalleryLauncher x;
  private String y;

  private void a(String paramString)
  {
    this.n = Maps.a();
    this.o = 0;
    this.r = ((TabHost)f(2131297672));
    this.r.setup();
    this.q = new FragmentTabManager(g(), this.r, 2131297673, FragmentTabManager.FragmentStrategy.ATTACH_DETACH);
    this.q.a(this);
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("set_token", FacebookPhotoSet.a(this.t));
    a("photos_of", 2131363086, PhotoSetGridFragment.class, localBundle1);
    Bundle localBundle2 = new Bundle();
    localBundle2.putLong("extra_profile", this.t);
    a("albums", 2131363087, AlbumsFragment.class, localBundle2);
    if (getIntent().getBooleanExtra("from_fburl", false))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("vault", Boolean.TRUE);
      Gatekeeper.a(this, localHashMap);
    }
    if (l())
    {
      this.u = this.o;
      Bundle localBundle3 = new Bundle();
      localBundle3.putBoolean("from_nux", getIntent().getBooleanExtra("from_nux", false));
      String str2 = getIntent().getStringExtra("nux_ref");
      if (str2 != null)
        localBundle3.putString("nux_ref", str2);
      a("sync", 2131363088, VaultSyncScreenFragment.class, localBundle3);
    }
    for (boolean bool = true; ; bool = false)
    {
      if (paramString != null)
      {
        if ((Integer)this.n.get(paramString) == null)
          break label302;
        this.r.setCurrentTab(((Integer)this.n.get(paramString)).intValue());
      }
      while (true)
      {
        this.r.getTabWidget().setDividerDrawable(null);
        return;
        label302: FbErrorReporter localFbErrorReporter = (FbErrorReporter)C().a(FbErrorReporter.class);
        String str1 = PhotosTabActivity.class.getSimpleName();
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramString;
        arrayOfObject[1] = Boolean.valueOf(bool);
        localFbErrorReporter.a(str1, StringLocaleUtil.a("non existent tab tabToShow=\"%s\" syncTabAdded=\"%s\"", arrayOfObject), true);
      }
    }
  }

  private void a(String paramString, int paramInt, Class<? extends Fragment> paramClass, Bundle paramBundle)
  {
    TabHost.TabSpec localTabSpec = this.r.newTabSpec(paramString).setIndicator(c(paramInt));
    this.q.a(localTabSpec, paramClass, paramBundle);
    this.n.put(paramString, Integer.valueOf(this.o));
    this.o = (1 + this.o);
  }

  private View c(int paramInt)
  {
    BlueTabIndicatorView localBlueTabIndicatorView = new BlueTabIndicatorView(this);
    localBlueTabIndicatorView.setText(getResources().getString(paramInt));
    return localBlueTabIndicatorView;
  }

  private void j()
  {
    a(TitleBarButtonSpec.newBuilder().b(2130837507).i());
  }

  private void k()
  {
    a(null);
  }

  private boolean l()
  {
    if ((m()) && (VaultHelpers.a(this)));
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean m()
  {
    if ((this.t <= 0L) || (this.t == this.s.b().userId));
    for (int i = 1; ; i = 0)
      return i;
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903487);
    this.x = ((GalleryLauncher)findViewById(2131296902));
    this.x.a(g(), findViewById(2131297672));
    this.s = AppSession.b(this, true);
    this.t = getIntent().getLongExtra("extra_profile", this.s.b().userId);
    FbTitleBarUtil.a(this);
    a(getIntent().getStringExtra("tab_to_show"));
    this.p = ((SecureContextHelper)FbInjector.a(this).a(SecureContextHelper.class));
  }

  public void i()
  {
    a(TitleBarButtonSpec.newBuilder().b(2130838273).i());
  }

  public GalleryLauncher n()
  {
    return this.x;
  }

  public void onBackPressed()
  {
    if (this.x.a())
      this.x.b();
    while (true)
    {
      return;
      super.onBackPressed();
    }
  }

  public void onNewIntent(Intent paramIntent)
  {
    this.v = paramIntent.getStringExtra("tab_to_show");
  }

  public void onResume()
  {
    super.onResume();
    if (this.v != null)
    {
      this.r.setCurrentTab(((Integer)this.n.get(this.v)).intValue());
      this.v = null;
    }
  }

  public void onTabChanged(String paramString)
  {
    this.y = paramString;
    if ((paramString.equals("albums")) && (m()))
      j();
    while (true)
    {
      return;
      if ((paramString.equals("sync")) && (!VaultHelpers.f(this)))
      {
        i();
        continue;
      }
      k();
    }
  }

  public void titleBarPrimaryActionClickHandler(View paramView)
  {
    if ("albums".equals(this.y))
    {
      Intent localIntent2 = new Intent(this, CreateEditAlbumActivity.class).setAction("");
      this.p.a(localIntent2, this);
    }
    while (true)
    {
      return;
      if ("sync".equals(this.y))
      {
        Intent localIntent1 = new Intent(this, VaultSettingsActivity.class);
        this.p.a(localIntent1, this);
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.photos.PhotosTabActivity
 * JD-Core Version:    0.6.0
 */