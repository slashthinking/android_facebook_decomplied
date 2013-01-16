package com.facebook.katana.activity.media.vault;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.activity.media.SelectionState;
import com.facebook.katana.activity.photos.PhotosTabActivity;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.service.vault.VaultHelpers;
import com.facebook.katana.service.vault.VaultLocalImageFetcher;
import com.facebook.katana.service.vault.VaultNotificationManager;
import com.facebook.katana.service.vault.VaultTable;
import com.facebook.katana.util.logging.VaultLogger;
import com.facebook.orca.inject.FbInjector;
import com.facebook.photos.grid.UrlImageGridAdapterPhotoSource;
import com.facebook.photos.photogallery.GalleryLauncher;
import com.facebook.photos.photogallery.GalleryLauncherHost;
import com.facebook.photos.photogallery.photogalleries.vault.VaultPhotoGalleryFragmentFactory;
import com.facebook.photos.photogallery.photos.VaultLocalPhoto;
import com.facebook.photos.photogallery.photos.VaultPhoto;
import com.facebook.photos.photogallery.photoviewcontrollers.AdapterViewPhotoViewController;
import com.nineoldandroids.animation.ValueAnimator;
import java.util.HashSet;
import java.util.Set;

public class VaultSyncScreenFragment extends Fragment
  implements VaultFailedPhotoFragment.OnFailedPhotoOptionSelectedListener, VaultSyncedPhotoFragment.OnSyncedPhotoOptionSelectedListener
{
  private VaultFailedPhotoFragment Y;
  private VaultSyncedPhotoFragment Z;
  private VaultGridAdapter a;
  private VaultOptInFragment aa;
  private Set<String> ab;
  private int ac = 0;
  private int ad = 0;
  private View ae;
  private VaultGridView af;
  private GridView ag;
  private RelativeLayout ah;
  private VaultSyncScreenPrivacyBar ai;
  private VaultSyncScreenErrorBar aj;
  private GalleryLauncher ak;
  private VaultSyncScreenFragment.VaultChromeVisibility al;
  private final GestureDetector am = new GestureDetector(new VaultSyncScreenFragment.1(this));
  private VaultNotificationManager b;
  private SelectionState c;
  private BroadcastReceiver d;
  private VaultTable e;
  private VaultLocalImageFetcher f;
  private Context g;
  private VaultPhoto h;
  private FragmentManager i;

  private void a()
  {
    this.ak = ((GalleryLauncherHost)n()).n();
    AdapterViewPhotoViewController localAdapterViewPhotoViewController = new AdapterViewPhotoViewController(n().getWindow(), this.ag);
    UrlImageGridAdapterPhotoSource localUrlImageGridAdapterPhotoSource = new UrlImageGridAdapterPhotoSource(this.a);
    VaultPhotoGalleryFragmentFactory localVaultPhotoGalleryFragmentFactory = new VaultPhotoGalleryFragmentFactory(localUrlImageGridAdapterPhotoSource, n().g(), new VaultSyncScreenFragment.4(this));
    if (this.ak != null)
      this.ak.a(localAdapterViewPhotoViewController, localUrlImageGridAdapterPhotoSource, localVaultPhotoGalleryFragmentFactory);
    while (true)
    {
      return;
      ErrorReporting.a("mGalleryLauncher is null", "mGalleryLauncher is null when initGallery() is called", true);
    }
  }

  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      this.al = VaultSyncScreenFragment.VaultChromeVisibility.VISIBLE;
      paramInt1 = 0;
    }
    label110: 
    while (true)
    {
      if (this.ad == paramInt1);
      while (true)
      {
        return;
        if (paramInt1 > this.ai.getHeight())
          break label110;
        this.al = VaultSyncScreenFragment.VaultChromeVisibility.HIDDEN;
        paramInt1 = -this.ai.getHeight();
        break;
        this.ad = paramInt1;
        VaultSyncScreenFragment.TopMarginEvaluator localTopMarginEvaluator = new VaultSyncScreenFragment.TopMarginEvaluator(this, this.ai);
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(this.ad);
        arrayOfObject[1] = Integer.valueOf(paramInt1);
        ValueAnimator.a(localTopMarginEvaluator, arrayOfObject).b(paramInt2).c();
      }
    }
  }

  private void a(Fragment paramFragment)
  {
    this.i.a().a(null).a(2131297671, paramFragment).a();
  }

  private void a(VaultLocalPhoto paramVaultLocalPhoto)
  {
    Intent localIntent = new Intent();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramVaultLocalPhoto.b();
    localIntent.putExtra("photo_hashes", arrayOfString);
    VaultHelpers.a(this.g, localIntent, 11);
  }

  private VaultOptInFragment b()
  {
    return new VaultOptInControlFragment().f(2130903625);
  }

  private void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("vault.row_upload_key");
    int j = paramIntent.getIntExtra("vault.upload_percentage", 0);
    MediaItem localMediaItem;
    if (str != null)
    {
      localMediaItem = this.f.b(str);
      if (!paramIntent.getBooleanExtra("vault.upload_completed", false))
        break label104;
      this.a.a(Uri.parse("file://" + localMediaItem.b()));
    }
    while (true)
    {
      if (!this.ab.contains(str))
        new VaultSyncScreenFragment.RefreshGridTask(this).execute(new Void[0]);
      return;
      label104: this.a.a(Uri.parse("file://" + localMediaItem.b()), j);
    }
  }

  private void c()
  {
    if (this.aa != null)
      this.i.a().a(this.aa).a();
    ((PhotosTabActivity)n()).i();
  }

  private void d()
  {
    if (this.aa == null)
      this.aa = b();
    String str = "none";
    if ((m() != null) && (m().getString("nux_ref") != null))
      str = m().getString("nux_ref");
    new VaultLogger(this.g).d(str);
    this.aa.a(str);
    this.aa.a(new VaultSyncScreenFragment.5(this));
    this.i.a().b(2131297962, this.aa).a();
  }

  public void B()
  {
    super.B();
    this.aj.b();
    this.ai.d();
    if (!VaultHelpers.f(this.g))
      this.af.b();
    if (VaultHelpers.a(this.g, 12))
    {
      if (!this.b.d().equals("end_vault_upload"))
        break label105;
      new VaultSyncScreenFragment.RefreshVaultTableTask(this, true).execute(new Void[0]);
    }
    while (true)
    {
      LocalBroadcastManager.a(this.g).a(this.d, new IntentFilter("vault.intent.action.SyncStatus"));
      return;
      label105: new VaultSyncScreenFragment.RefreshGridTask(this, true).execute(new Void[0]);
    }
  }

  public void C()
  {
    super.C();
    LocalBroadcastManager.a(this.g).a(this.d);
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.ae = paramLayoutInflater.inflate(2130903629, paramViewGroup, false);
    this.ah = ((RelativeLayout)this.ae.findViewById(2131297965));
    this.ai = ((VaultSyncScreenPrivacyBar)this.ae.findViewById(2131297953));
    this.aj = ((VaultSyncScreenErrorBar)this.ae.findViewById(2131297959));
    this.aj.setOnClickListener(new VaultSyncScreenFragment.2(this));
    this.al = VaultSyncScreenFragment.VaultChromeVisibility.VISIBLE;
    return this.ae;
  }

  public void a(VaultSyncScreenFragment.PhotoOption paramPhotoOption)
  {
    if (paramPhotoOption == VaultSyncScreenFragment.PhotoOption.TRY_AGAIN)
      a((VaultLocalPhoto)this.h);
    this.i.d();
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int j = 0; ; j = -this.ai.getHeight())
    {
      a(j, 100);
      return;
    }
  }

  public void b(VaultSyncScreenFragment.PhotoOption paramPhotoOption)
  {
    if (paramPhotoOption == VaultSyncScreenFragment.PhotoOption.REMOVE_PHOTO)
    {
      VaultSyncScreenFragment.DeleteImageTask localDeleteImageTask = new VaultSyncScreenFragment.DeleteImageTask(this, null);
      VaultPhoto[] arrayOfVaultPhoto = new VaultPhoto[1];
      arrayOfVaultPhoto[0] = this.h;
      localDeleteImageTask.execute(arrayOfVaultPhoto);
    }
    this.i.d();
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.g = n();
    this.ag = ((GridView)this.ae.findViewById(2131297964));
    this.af = ((VaultGridView)this.ae.findViewById(2131297963));
    this.a = ((VaultGridAdapter)this.af.getAdapter());
    this.a.a(new VaultSyncScreenFragment.VaultImageClickListener(this, null));
    if (VaultHelpers.f(this.g))
      this.a.a(new VaultSyncScreenFragment.VaultGridPopulatedListener(this, null));
    this.e = ((VaultTable)FbInjector.a(this.g).a(VaultTable.class));
    this.f = ((VaultLocalImageFetcher)FbInjector.a(this.g).a(VaultLocalImageFetcher.class));
    this.i = n().g();
    this.aa = null;
    this.b = ((VaultNotificationManager)FbInjector.a(this.g).a(VaultNotificationManager.class));
    this.ab = new HashSet();
    this.Y = new VaultFailedPhotoFragment();
    this.Y.a(this);
    this.Z = new VaultSyncedPhotoFragment();
    this.Z.a(this);
    if (this.c == null)
      this.c = new SelectionState();
    this.ag.setOnTouchListener(new VaultSyncScreenFragment.3(this));
    this.d = new VaultSyncScreenFragment.SyncStatusReceiver(this, null);
    a();
    int j = ViewConfiguration.get(this.g).getScaledMinimumFlingVelocity();
    this.ac = (int)Math.max(0.05D * ViewConfiguration.get(this.g).getScaledMaximumFlingVelocity(), j);
  }

  public void f()
  {
    super.f();
    if (VaultHelpers.f(this.g))
      d();
    while (true)
    {
      return;
      c();
      this.af.b();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultSyncScreenFragment
 * JD-Core Version:    0.6.0
 */