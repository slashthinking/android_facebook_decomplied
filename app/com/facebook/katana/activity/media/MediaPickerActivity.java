package com.facebook.katana.activity.media;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.camera.activity.CameraActivity;
import com.facebook.camera.activity.CameraActivity.Extras;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.activity.media.crop.CropManager;
import com.facebook.katana.features.tagging.BaseTagTypeaheadAdapter;
import com.facebook.katana.features.tagging.GroupMembersTagTypeaheadAdapter;
import com.facebook.katana.features.tagging.TagTypeaheadAdapter;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.model.MediaItem.MediaType;
import com.facebook.katana.model.PhotoItem;
import com.facebook.katana.model.VideoItem;
import com.facebook.katana.service.vault.VaultLocalImageFetcher;
import com.facebook.katana.view.vault.PickerGalleryView;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.photos.analytics.PhotoFlowLogger;
import com.facebook.photos.analytics.WaterfallIdGenerator;
import com.facebook.photos.annotation.IsNewGalleryEnabled;
import com.facebook.photos.photogallery.GalleryLauncher;
import com.facebook.photos.photogallery.photogalleries.production.ProductionPhotoGalleryFragmentFactory;
import com.facebook.photos.photogallery.photoviewcontrollers.AdapterViewPhotoViewController;
import com.facebook.widget.CountBadge;
import com.facebook.widget.ExpandablePhoto;
import com.facebook.widget.PhotoToggleButton;
import com.facebook.widget.ViewTransform;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.nineoldandroids.animation.ObjectAnimator;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Lcom.facebook.katana.model.MediaItem;>;

public class MediaPickerActivity extends BaseFacebookActivity
  implements View.OnClickListener, NotNewNavEnabled
{
  private static final String[] o = { "_id", "_data", "_display_name", "mime_type", "datetaken" };
  private Map<Long, MediaItem> A;
  private View B;
  private ImageView C;
  private ImageView D;
  private ImageView E;
  private ImageView F;
  private ImageView G;
  private ImageView H;
  private ViewTransform I;
  private ViewTransform J;
  private SelectionState K;
  private long L = -1L;
  private MediaPickerActivity.ViewMode M = MediaPickerActivity.ViewMode.GRID;
  private CountBadge N;
  private RelativeLayout O;
  private LinearLayout P;
  private MediaPickerActivity.ViewMode Q = null;
  private MediaPickerActivity.SelectedMode R = MediaPickerActivity.SelectedMode.ALL;
  private Button S;
  private Button T;
  private ExpandablePhoto U;
  private String V;
  private boolean W = true;
  private Rect X;
  private int Y = -1;
  private int Z = -1;
  private float aa = -1.0F;
  private float ab = -1.0F;
  private List<ObjectAnimator> ac;
  private GalleryLauncher ad;
  private boolean ae;
  private PhotoFlowLogger af;
  private CropManager ag;
  private boolean ah = false;
  final String[] n = { "tagged_id", "x_pos", "y_pos", "created", "text", "image_hash" };
  private boolean p = false;
  private boolean q = false;
  private long r = -1L;
  private boolean s;
  private boolean t = false;
  private LinearLayout u;
  private PickerGalleryView v;
  private MediaPickerGridAdapter x;
  private GridView y;
  private MediaPickerEnvironment z;

  private int A()
  {
    float f = getResources().getDimensionPixelSize(2131230926);
    return (int)Math.floor(this.y.getWidth() / f);
  }

  private void B()
  {
    if (this.A == null);
    while (true)
    {
      return;
      if (this.K.b() == 0)
        switch (MediaPickerActivity.6.a[this.M.ordinal()])
        {
        case 1:
        default:
        case 2:
        }
      ArrayList localArrayList;
      Bundle localBundle1;
      while (true)
      {
        if ((this.M == MediaPickerActivity.ViewMode.GALLERY) && (this.z.a()))
        {
          this.K.a();
          this.v.a(true);
        }
        localArrayList = E();
        localBundle1 = new Bundle();
        localBundle1.putParcelableArrayList("extra_media_items", localArrayList);
        if (!this.s)
          break label148;
        setResult(-1, new Intent().putExtras(localBundle1));
        finish();
        break;
        this.v.a(true);
      }
      label148: Bundle localBundle2 = getIntent().getBundleExtra("composer_extras");
      if (localBundle2 != null)
        localBundle1.putAll(localBundle2);
      localBundle1.putParcelable("extra_environment", this.z);
      localBundle1.putString("camera_session_id", this.V);
      this.af.c(localArrayList.size());
      String str = this.z.d();
      if (("group".equals(str)) || ("event".equals(str)))
      {
        localBundle1.putString("publisher_type", str);
        localBundle1.putLong("target_id", this.z.b());
      }
      a(null, localBundle1, Integer.valueOf(101), this.L);
    }
  }

  private ArrayList<MediaItem> E()
  {
    ArrayList localArrayList1 = Lists.a();
    if (this.A == null);
    for (ArrayList localArrayList2 = localArrayList1; ; localArrayList2 = localArrayList1)
    {
      return localArrayList2;
      Iterator localIterator = this.K.iterator();
      while (localIterator.hasNext())
      {
        long l = ((Long)localIterator.next()).longValue();
        MediaItem localMediaItem = (MediaItem)this.A.get(Long.valueOf(l));
        if (localMediaItem == null)
          continue;
        localArrayList1.add(localMediaItem);
      }
    }
  }

  private void F()
  {
    p();
  }

  private void G()
  {
    PhotoItem localPhotoItem = (PhotoItem)this.v.getCurrentItem();
    int i = RotationManager.a(localPhotoItem.b(), localPhotoItem);
    RotationManager.a(getApplicationContext(), localPhotoItem, (i + 270) % 360);
    this.v.setOrientation((i + 270) % 360);
    this.v.b();
    this.v.a();
    this.x.b(this.v.getCurrentItem());
    this.af.f();
  }

  private void H()
  {
    this.R = MediaPickerActivity.SelectedMode.SELECTED;
    L();
    if (this.K.b() > 0)
    {
      this.x.a(MediaPickerActivity.SelectedMode.SELECTED);
      this.v.setMode(MediaPickerActivity.SelectedMode.SELECTED);
    }
    while (true)
    {
      return;
      this.O.setVisibility(0);
      this.y.setVisibility(8);
    }
  }

  private void I()
  {
    this.R = MediaPickerActivity.SelectedMode.ALL;
    this.y.setVisibility(0);
    this.O.setVisibility(8);
    L();
    this.x.a(MediaPickerActivity.SelectedMode.ALL);
    this.v.setMode(MediaPickerActivity.SelectedMode.ALL);
  }

  private void J()
  {
    Intent localIntent = CameraActivity.a(this, this.L);
    Bundle localBundle = getIntent().getBundleExtra("composer_extras");
    if (localBundle != null)
      localIntent.putExtra("composer_extras", localBundle);
    localIntent.putExtra(CameraActivity.Extras.a, false);
    startActivityForResult(localIntent, 1330);
  }

  private void K()
  {
    this.N.setCount(this.K.b());
    M();
  }

  private void L()
  {
    boolean bool1 = true;
    Button localButton1 = this.S;
    boolean bool2;
    Button localButton2;
    if (this.R != MediaPickerActivity.SelectedMode.ALL)
    {
      bool2 = bool1;
      localButton1.setEnabled(bool2);
      localButton2 = this.T;
      if (this.R == MediaPickerActivity.SelectedMode.SELECTED)
        break label52;
    }
    while (true)
    {
      localButton2.setEnabled(bool1);
      return;
      bool2 = false;
      break;
      label52: bool1 = false;
    }
  }

  private void M()
  {
    boolean bool = true;
    if (this.K.b() > 0)
    {
      if (!this.C.isEnabled())
        this.C.setEnabled(bool);
      return;
    }
    ImageView localImageView = this.C;
    if (this.M == MediaPickerActivity.ViewMode.GALLERY);
    while (true)
    {
      localImageView.setEnabled(bool);
      break;
      bool = false;
    }
  }

  private Map<String, MediaItem> a(Context paramContext)
  {
    Object localObject = ((VaultLocalImageFetcher)FbInjector.a(paramContext).a(VaultLocalImageFetcher.class)).d();
    if (localObject == null)
    {
      this.p = true;
      localObject = Maps.a();
    }
    return (Map<String, MediaItem>)localObject;
  }

  private void a(Rect paramRect, MediaItem paramMediaItem, View paramView, MediaPickerActivity.ExpandType paramExpandType)
  {
    Bitmap localBitmap;
    float f1;
    float f2;
    float f3;
    float f4;
    if (this.K.c(paramMediaItem))
    {
      localBitmap = BitmapFactory.decodeResource(getResources(), 2130838846);
      this.E.setImageBitmap(localBitmap);
      Object localObject1 = null;
      Object localObject2 = null;
      if (paramView != null)
      {
        PhotoToggleButton localPhotoToggleButton2 = (PhotoToggleButton)paramView.findViewById(2131297065);
        ViewTransform localViewTransform2 = new ViewTransform(localPhotoToggleButton2);
        localObject2 = localPhotoToggleButton2;
        localObject1 = localViewTransform2;
      }
      if ((this.aa == -1.0F) && (localObject1 != null) && (localObject2 != null))
        this.aa = (localObject1.getX() + localObject2.getPaddingLeft());
      if ((this.ab == -1.0F) && (localObject1 != null) && (localObject2 != null))
        this.ab = (localObject1.getY() + localObject2.getPaddingTop());
      if ((this.aa != -1.0F) && (this.ab != -1.0F))
      {
        f1 = paramRect.left + this.aa;
        f2 = paramRect.top + this.ab;
        PhotoToggleButton localPhotoToggleButton1 = this.v.getCheck();
        ViewTransform localViewTransform1 = new ViewTransform(localPhotoToggleButton1);
        f3 = localViewTransform1.getX() + localPhotoToggleButton1.getPaddingLeft();
        f4 = localViewTransform1.getY() + localPhotoToggleButton1.getPaddingTop();
        this.I.setVisibility(0);
        this.ac.clear();
        if (paramExpandType != MediaPickerActivity.ExpandType.EXPAND)
          break label370;
        this.ac.add(ObjectAnimator.a(this.E, "translationX", new float[] { f1, f3 }));
        this.ac.add(ObjectAnimator.a(this.E, "translationY", new float[] { f2, f4 }));
      }
    }
    while (true)
    {
      this.U.a(this.ac);
      this.U.setOnPhotoAnimationStartListener(new MediaPickerActivity.5(this));
      return;
      localBitmap = BitmapFactory.decodeResource(getResources(), 2130838845);
      break;
      label370: this.ac.add(ObjectAnimator.a(this.E, "translationX", new float[] { f3, f1 }));
      this.ac.add(ObjectAnimator.a(this.E, "translationY", new float[] { f4, f2 }));
    }
  }

  private void a(View paramView)
  {
    if (this.Y == -1)
    {
      this.Y = paramView.getMeasuredWidth();
      this.F.getLayoutParams().width = this.Y;
    }
    if (this.Z == -1)
    {
      this.Z = paramView.getMeasuredHeight();
      this.F.getLayoutParams().height = this.Z;
    }
    this.X.set(paramView.getLeft(), paramView.getTop(), paramView.getLeft() + this.Y, paramView.getTop() + this.Z);
  }

  private void a(MediaItem paramMediaItem, int paramInt, MediaPickerActivity.ExpandType paramExpandType)
  {
    View localView = this.x.a(paramMediaItem);
    this.J.setVisibility(0);
    if (localView != null)
      a(localView);
    while (true)
    {
      a(paramMediaItem, localView, paramExpandType);
      return;
      c(paramInt);
    }
  }

  private void a(MediaItem paramMediaItem, View paramView, MediaPickerActivity.ExpandType paramExpandType)
  {
    this.J.setX(this.X.left);
    this.J.setY(this.X.top);
    Bitmap localBitmap = this.x.c(paramMediaItem);
    if (localBitmap != null)
    {
      if (!this.z.a())
        a(this.X, paramMediaItem, paramView, paramExpandType);
      if (paramExpandType == MediaPickerActivity.ExpandType.EXPAND)
      {
        this.v.setCurrentBitmap(localBitmap);
        this.U.a(localBitmap, this.X);
      }
    }
    while (true)
    {
      return;
      this.U.b(localBitmap, this.X);
      continue;
      z();
    }
  }

  private void a(MediaItem paramMediaItem, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.v.a(this.v.a(paramMediaItem));
    if (paramBoolean1)
      q();
    this.S.setVisibility(8);
    this.T.setVisibility(8);
    this.D.setImageResource(2130838849);
    if (paramMediaItem != null)
    {
      if (paramMediaItem.e() == MediaItem.MediaType.PHOTO)
        this.G.setVisibility(0);
      this.v.b(paramMediaItem);
      if ((!paramBoolean2) || (this.v.getCurrentPosition() == -1))
        break label112;
      a(paramMediaItem, this.v.getCurrentPosition(), MediaPickerActivity.ExpandType.EXPAND);
    }
    while (true)
    {
      return;
      label112: z();
    }
  }

  private void a(VideoItem paramVideoItem)
  {
    Uri localUri = Uri.fromFile(new File(paramVideoItem.b()));
    Intent localIntent = CameraReviewActivity.a(this, localUri, 2, false, this.L);
    localIntent.putExtra("camera_session_id", this.V);
    localIntent.putExtra("publisher_type", getIntent().getStringExtra("publisher_type"));
    this.af.b(localUri);
    Bundle localBundle = getIntent().getBundleExtra("composer_extras");
    if (localBundle != null)
      localIntent.putExtra("composer_extras", localBundle);
    localIntent.putExtra("extra_no_composer", this.s);
    startActivityForResult(localIntent, 101);
  }

  private void c(int paramInt)
  {
    int i = getResources().getDimensionPixelSize(2131230924);
    if (paramInt < s());
    for (int j = 0; ; j = this.y.getHeight() - (1 + (r() - g(paramInt))) * (i + this.Z))
    {
      int k = (i + this.Y) * e(paramInt);
      this.X.set(k, j, k + this.Y, j + this.Z);
      return;
    }
  }

  private void c(Bundle paramBundle)
  {
    this.M = ((MediaPickerActivity.ViewMode)paramBundle.getSerializable("view_state"));
    long[] arrayOfLong = paramBundle.getLongArray("selection_state");
    if (arrayOfLong != null)
      this.K = new SelectionState(arrayOfLong);
  }

  private void c(boolean paramBoolean)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    if (paramBoolean);
    for (int i = 2131362827; ; i = 2131362828)
    {
      localBuilder.setMessage(2131363261).setTitle(i).setCancelable(false).setPositiveButton(2131361888, new MediaPickerActivity.4(this));
      localBuilder.create().show();
      return;
    }
  }

  private void d(Bundle paramBundle)
  {
    this.af = ((PhotoFlowLogger)FbInjector.a(getApplicationContext()).a(PhotoFlowLogger.class));
    String str = getIntent().getStringExtra("camera_session_id");
    if (str != null)
      this.V = str;
    for (int i = 0; ; i = 1)
    {
      if (StringUtil.a(this.V))
        this.V = ((WaterfallIdGenerator)FbInjector.a(getApplicationContext()).a(WaterfallIdGenerator.class)).a();
      this.af.a(this.V);
      if (i != 0)
        this.af.a(getIntent().getStringExtra("extra_source_activity"), Long.toString(this.L));
      return;
      if (paramBundle == null)
        continue;
      this.V = paramBundle.getString("camera_session_id");
    }
  }

  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
      q();
    this.S.setVisibility(0);
    this.T.setVisibility(0);
    this.G.setVisibility(8);
    this.y.setVisibility(0);
    this.H.setVisibility(8);
    this.D.setImageResource(2130837646);
    this.v.setVisibility(4);
    MediaItem localMediaItem = this.v.getCurrentItem();
    int i = this.x.d(localMediaItem);
    if ((this.y.getFirstVisiblePosition() > i) || (this.y.getLastVisiblePosition() < i))
      this.y.setSelection(i);
    if (this.z.a())
      this.K.a();
    a(localMediaItem, i, MediaPickerActivity.ExpandType.SHRINK);
  }

  private int e(int paramInt)
  {
    return paramInt % A();
  }

  private int g(int paramInt)
  {
    return paramInt / A();
  }

  private int h(int paramInt)
  {
    if (paramInt % A() == 0);
    while (true)
    {
      return paramInt;
      paramInt = (1 + paramInt / A()) * A();
    }
  }

  private void l()
  {
    this.u = ((LinearLayout)findViewById(2131297069));
    this.y = ((GridView)findViewById(2131297070));
    this.v = ((PickerGalleryView)findViewById(2131297071));
    this.B = this.u.findViewById(2131296627);
    this.C = ((ImageView)findViewById(2131297085));
    this.C.setOnClickListener(this);
    this.G = ((ImageView)findViewById(2131297080));
    this.G.setOnClickListener(this);
    this.H = ((ImageView)findViewById(2131297079));
    this.H.setOnClickListener(this);
    this.S = ((Button)findViewById(2131297083));
    this.T = ((Button)findViewById(2131297084));
    this.D = ((ImageView)findViewById(2131297081));
    this.D.setOnClickListener(this);
    this.O = ((RelativeLayout)findViewById(2131297072));
    this.P = ((LinearLayout)findViewById(2131297075));
    this.S.setOnClickListener(this);
    this.T.setOnClickListener(this);
    this.N = ((CountBadge)findViewById(2131297086));
    this.F = ((ImageView)findViewById(2131297076));
    this.J = new ViewTransform(this.F);
    this.U = ((ExpandablePhoto)findViewById(2131297077));
    this.E = ((ImageView)findViewById(2131297078));
    this.I = new ViewTransform(this.E);
  }

  private void m()
  {
    this.ag = ((CropManager)(CropManager)g().a(2131297068));
    this.ag.a(new MediaPickerActivity.1(this));
    this.ag.a(new MediaPickerActivity.2(this));
  }

  private boolean n()
  {
    if ((this.M == MediaPickerActivity.ViewMode.GALLERY) || (this.r != -1L));
    for (int i = 1; ; i = 0)
      return i;
  }

  private void o()
  {
    AdapterViewPhotoViewController localAdapterViewPhotoViewController = new AdapterViewPhotoViewController(getWindow(), this.y);
    ForwardingGridAdapterPhotoSource localForwardingGridAdapterPhotoSource = new ForwardingGridAdapterPhotoSource(this.x);
    ProductionPhotoGalleryFragmentFactory localProductionPhotoGalleryFragmentFactory = new ProductionPhotoGalleryFragmentFactory(localForwardingGridAdapterPhotoSource, g(), new MediaPickerActivity.ProductionPhotoDataAdapterImpl(this, null));
    this.ad = ((GalleryLauncher)findViewById(2131296902));
    this.ad.a(g(), findViewById(2131297070));
    this.ad.a(localAdapterViewPhotoViewController, localForwardingGridAdapterPhotoSource, localProductionPhotoGalleryFragmentFactory);
  }

  private void p()
  {
    this.u.setVisibility(8);
    this.ag.a((PhotoItem)this.v.getCurrentItem());
    this.ag.f(0);
    this.ah = true;
  }

  private void q()
  {
    if (this.Q == null);
    for (this.Q = this.M; ; this.Q = null)
      return;
  }

  private int r()
  {
    return (-1 + this.y.getCount()) / A();
  }

  private int s()
  {
    int i = this.y.getHeight() / this.Z;
    return h(this.x.getCount()) - i * A();
  }

  private void z()
  {
    this.J.setVisibility(8);
    this.I.setVisibility(8);
    if (this.M == MediaPickerActivity.ViewMode.GRID)
    {
      this.y.setVisibility(4);
      this.v.setVisibility(0);
    }
    for (this.M = MediaPickerActivity.ViewMode.GALLERY; ; this.M = MediaPickerActivity.ViewMode.GRID)
    {
      this.W = true;
      K();
      if (this.M == MediaPickerActivity.ViewMode.GALLERY)
        this.v.c();
      return;
    }
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903276);
    l();
    if (Build.VERSION.SDK_INT < 14)
      this.T.setPadding(getResources().getDimensionPixelSize(2131230925), 0, 0, 0);
    m();
    this.X = new Rect();
    this.U.setOnPhotoAnimationEndListener(new MediaPickerActivity.3(this));
    this.ac = Lists.a();
    this.s = getIntent().getBooleanExtra("extra_for_result", false);
    this.z = ((MediaPickerEnvironment)getIntent().getParcelableExtra("extra_environment"));
    if (this.z == null)
      this.z = MediaPickerEnvironment.a;
    this.L = this.z.b();
    Object localObject;
    ArrayList localArrayList;
    if ("group".equals(this.z.d()))
    {
      localObject = new GroupMembersTagTypeaheadAdapter(this, this.L);
      this.v.setTypeAheadAdapter((BaseTagTypeaheadAdapter)localObject);
      localArrayList = getIntent().getParcelableArrayListExtra("extra_selection");
      if (paramBundle == null)
        break label469;
      c(paramBundle);
    }
    while (true)
    {
      d(paramBundle);
      if (this.K == null)
        this.K = new SelectionState();
      this.K.a(new MediaPickerActivity.MediaSelectionStateListener(this, null));
      this.v.setSelectionState(this.K);
      this.v.setPickerEnvironment(this.z);
      this.x = new MediaPickerGridAdapter(new ImageGridAdapter(getApplicationContext(), this.y), this, this.z, this.af);
      this.y.setAdapter(this.x);
      this.x.a(this.K);
      this.x.a(new MediaPickerActivity.ItemClickListener(this, null));
      this.v.setCameraFlowLogger(this.af);
      if (n())
        a(null, false, false);
      if (this.z.a())
      {
        findViewById(2131297082).setVisibility(8);
        this.N.setVisibility(8);
      }
      o();
      if (!this.z.f())
        this.B.setVisibility(8);
      M();
      this.ae = ((Boolean)C().a(Boolean.class, IsNewGalleryEnabled.class)).booleanValue();
      new MediaPickerActivity.LocalMediaLoader(this, null).execute(new Context[] { this });
      return;
      localObject = new TagTypeaheadAdapter(this);
      break;
      label469: if (localArrayList != null)
      {
        this.K = new SelectionState();
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          MediaItem localMediaItem2 = (MediaItem)localIterator.next();
          this.K.a(localMediaItem2);
        }
      }
      MediaItem localMediaItem1 = (MediaItem)getIntent().getParcelableExtra("extra_focused_item");
      if (localMediaItem1 == null)
        continue;
      this.r = localMediaItem1.a();
    }
  }

  public Object c()
  {
    return this.v.getCustomNonConfigurationState();
  }

  public String i()
  {
    return getString(2131363010);
  }

  public void j()
  {
    this.O.setVisibility(0);
    this.G.setVisibility(8);
    this.H.setVisibility(8);
    this.S.setVisibility(0);
    this.T.setVisibility(0);
    this.y.setVisibility(4);
    this.v.setVisibility(4);
    this.M = MediaPickerActivity.ViewMode.GRID;
    this.D.setImageResource(2130837646);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == 0) || (paramInt2 == 4))
      if (paramIntent != null)
      {
        ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("extra_media_items");
        if (localArrayList != null)
        {
          this.t = true;
          this.K.a();
          Iterator localIterator = localArrayList.iterator();
          while (localIterator.hasNext())
          {
            MediaItem localMediaItem = (MediaItem)localIterator.next();
            this.K.a(localMediaItem);
          }
          this.t = false;
          if (this.R == MediaPickerActivity.SelectedMode.SELECTED)
            H();
          this.N.setCount(this.K.b());
          M();
        }
      }
    while (true)
    {
      return;
      if ((paramInt1 == 100) || (paramInt1 == 101) || ((paramInt1 == 1330) && (paramInt2 == -1)))
      {
        setResult(paramInt2, paramIntent);
        finish();
        continue;
      }
      if ((paramInt2 != 5) && (paramInt2 != 6))
        continue;
      new MediaPickerActivity.LocalMediaLoader(this, null).execute(new Context[] { this });
    }
  }

  public void onBackPressed()
  {
    if (this.ae)
      if (this.ad.a())
        this.ad.b();
    while (true)
    {
      return;
      super.onBackPressed();
      continue;
      if (this.ah)
      {
        this.ag.a();
        continue;
      }
      if ((this.v.getVisibility() == 0) && (this.v.e()))
        continue;
      if (this.Q != null)
        break;
      ArrayList localArrayList = E();
      Bundle localBundle = new Bundle();
      localBundle.putParcelableArrayList("extra_media_items", localArrayList);
      setResult(-1, new Intent().putExtras(localBundle));
      super.onBackPressed();
    }
    switch (MediaPickerActivity.6.a[this.Q.ordinal()])
    {
    default:
    case 1:
      while (true)
      {
        this.Q = null;
        break;
        d(false);
      }
    case 2:
    }
    if (this.r > 0L);
    for (MediaItem localMediaItem = (MediaItem)this.A.get(Long.valueOf(this.r)); ; localMediaItem = null)
    {
      a(localMediaItem, false, false);
      break;
    }
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131297085)
      B();
    while (true)
    {
      return;
      if (i == 2131297081)
      {
        if (this.M == MediaPickerActivity.ViewMode.GRID)
        {
          J();
          continue;
        }
        d(true);
        continue;
      }
      if (i == 2131297083)
      {
        I();
        continue;
      }
      if (i == 2131297084)
      {
        H();
        continue;
      }
      if (i == 2131297079)
      {
        F();
        continue;
      }
      if (i != 2131297080)
        continue;
      G();
    }
  }

  protected void onResume()
  {
    super.onResume();
    if ((this.M == MediaPickerActivity.ViewMode.GALLERY) && (this.v.getVisibility() != 0))
      a(null, false, false);
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putSerializable("view_state", this.M);
    paramBundle.putLongArray("selection_state", this.K.c());
    paramBundle.putString("camera_session_id", this.V);
  }

  protected void onStart()
  {
    super.onStart();
    if (this.x != null)
      this.x.c();
  }

  protected void onStop()
  {
    super.onStop();
    this.x.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.MediaPickerActivity
 * JD-Core Version:    0.6.0
 */