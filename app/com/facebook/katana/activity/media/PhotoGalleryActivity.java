package com.facebook.katana.activity.media;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.InteractionLogger;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.Log;
import com.facebook.common.util.Toaster;
import com.facebook.content.SecureContextHelper;
import com.facebook.diagnostics.FPSSupport;
import com.facebook.feed.cache.NewsFeedCache;
import com.facebook.feed.flyout.FlyoutAnimationHandler;
import com.facebook.feed.flyout.FlyoutParams;
import com.facebook.feed.photos.AlbumIndexCache;
import com.facebook.feed.photos.FeedPhotoState;
import com.facebook.feed.photos.FeedPhotoStateManager;
import com.facebook.feed.photos.NewsFeedPhotoAnimation;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.model.FeedStoryComments;
import com.facebook.graphql.model.FeedStoryLikers;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLProfileCache;
import com.facebook.katana.AlertDialogs;
import com.facebook.katana.IntentUriHandler;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.features.tagging.BaseTagTypeaheadAdapter;
import com.facebook.katana.features.tagging.TagTypeaheadAdapter;
import com.facebook.katana.model.FacebookPhoto;
import com.facebook.katana.model.FacebookPhotoSet;
import com.facebook.katana.model.FacebookPhotoTag;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.service.method.CropProfilePicture;
import com.facebook.katana.service.method.GraphObjectLike;
import com.facebook.katana.service.method.GraphObjectLike.Operation;
import com.facebook.katana.service.method.PhotosGetPhotos;
import com.facebook.katana.ui.ImageViewTouchBase;
import com.facebook.katana.ui.PhotoGallery;
import com.facebook.katana.util.TempFileManager;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.Actions;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElementsTypes;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.images.ImageCache;
import com.facebook.orca.images.ImageCacheKey;
import com.facebook.orca.inject.FbInjector;
import com.facebook.photos.analytics.PhotoFlowLogger;
import com.facebook.widget.PhotoButton;
import com.facebook.widget.PhotoToggleButton;
import com.facebook.widget.PhotoToggleButton.OnCheckedChangeListener;
import com.facebook.widget.menu.CustomMenuActivity;
import com.facebook.widget.menu.CustomMenuItem;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@FPSSupport
public class PhotoGalleryActivity extends BaseFacebookActivity
  implements View.OnClickListener, AnalyticsActivity, NotNewNavEnabled, PhotoToggleButton.OnCheckedChangeListener, CustomMenuActivity
{
  private static final String n = PhotoGalleryActivity.class.getSimpleName();
  private PhotosetGalleryAdapter A;
  private GestureDetector B;
  private final Handler C = new Handler();
  private LayoutInflater D;
  private long E;
  private PointF F;
  private boolean G;
  private Map<Long, FacebookPhoto> H;
  private String I;
  private FacebookPhotoSet J;
  private String K;
  private AutoCompleteTextView L;
  private View M;
  private long N;
  private String O;
  private String P;
  private PhotoToggleButton Q;
  private PhotoButton R;
  private PhotoButton S;
  private TextView T;
  private TextView U;
  private int V;
  private int W;
  private boolean X;
  private boolean Y = false;
  private boolean Z = false;
  private final AdapterView.OnItemSelectedListener aA = new PhotoGalleryActivity.4(this);
  private final GestureDetector.SimpleOnGestureListener aB = new PhotoGalleryActivity.6(this);
  private boolean aa = false;
  private InteractionLogger ab;
  private PhotoFlowLogger ac;
  private Map<Long, FacebookPhotoTagSet> ad = new HashMap();
  private Map<FacebookPhotoTag, ViewGroup> ae = new HashMap();
  private ImageCache af;
  private FeedPhotoState ag;
  private AlbumIndexCache ah;
  private Uri ai;
  private List<Uri> aj;
  private List<Long> ak;
  private HashMap<Long, String> al;
  private Animation am;
  private Animation an;
  private Animation ao;
  private Animation ap;
  private FeedEventBus aq;
  private PhotoGalleryActivity.SetUpFlyoutEventSubscriber ar;
  private PhotoGalleryActivity.LikeActionResultEventSubscriber as;
  private FlyoutAnimationHandler at;
  private NewsFeedCache au;
  private GraphQLProfile av;
  private FbErrorReporter aw;
  private NewsFeedPhotoAnimation ax;
  private FeedPhotoStateManager ay;
  private final AppSessionListener az = new PhotoGalleryActivity.3(this);
  private AppSession o;
  private TouchBlip p;
  private LinearLayout q;
  private LinearLayout r;
  private TextView s;
  private long t;
  private PhotoGalleryActivity.ViewMode u = PhotoGalleryActivity.ViewMode.DEFAULT;
  private FacebookPhotoTagSet v;
  private String x;
  private final HashMap<Long, PhotoGalleryActivity.FeedbackData> y = new HashMap();
  private PhotoGallery z;

  private void A()
  {
    this.Z = false;
    this.F = null;
    View localView1 = findViewById(2131297987);
    if (localView1.getVisibility() == 0)
    {
      localView1.setAnimation(this.an);
      localView1.setVisibility(4);
    }
    View localView2 = findViewById(2131296461);
    if (localView2.getVisibility() == 0)
      localView2.setVisibility(4);
    if (this.p != null)
      this.p.b();
    n();
  }

  private void B()
  {
    ((PhotoGallery)findViewById(2131297398));
    A();
    H();
    E();
    F();
    n();
  }

  private void E()
  {
    View localView = findViewById(2131296475);
    if (localView.getVisibility() == 0)
    {
      localView.startAnimation(this.ap);
      localView.setVisibility(4);
    }
    this.Q.clearColorFilter();
    this.S.clearColorFilter();
  }

  private void F()
  {
    if (this.q.getVisibility() == 0)
    {
      this.q.setVisibility(8);
      this.q.startAnimation(this.ap);
    }
  }

  private void G()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager != null)
      localInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
  }

  private void H()
  {
    View localView = findViewById(2131296461);
    if (localView.getVisibility() == 0)
    {
      localView.startAnimation(AnimationUtils.loadAnimation(this, 2130968589));
      localView.setVisibility(4);
    }
  }

  private void I()
  {
    View localView = findViewById(2131296461);
    if (localView.getVisibility() != 0)
    {
      localView.setAnimation(this.ao);
      localView.setVisibility(0);
    }
    this.C.postDelayed(new PhotoGalleryActivity.1(this), 2000L);
  }

  private void J()
  {
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131296475);
    ImageViewTouchBase localImageViewTouchBase = l();
    if ((this.v == null) || (localImageViewTouchBase == null) || (this.v.a() == 0));
    while (true)
    {
      return;
      Iterator localIterator = this.v.iterator();
      while (localIterator.hasNext())
      {
        FacebookPhotoTag localFacebookPhotoTag = (FacebookPhotoTag)localIterator.next();
        if (localFacebookPhotoTag.f() == null)
          continue;
        float[] arrayOfFloat = new float[2];
        arrayOfFloat[0] = ((float)localFacebookPhotoTag.c() / 100.0F * localImageViewTouchBase.getDrawable().getIntrinsicWidth());
        arrayOfFloat[1] = ((float)localFacebookPhotoTag.d() / 100.0F * localImageViewTouchBase.getDrawable().getIntrinsicHeight());
        localImageViewTouchBase.getImageMatrix().mapPoints(arrayOfFloat);
        ViewGroup localViewGroup1 = (ViewGroup)this.ae.get(localFacebookPhotoTag);
        if (localViewGroup1 == null)
        {
          ViewGroup localViewGroup2 = (ViewGroup)this.D.inflate(2130903572, null);
          this.ae.put(localFacebookPhotoTag, localViewGroup2);
          ((TextView)localViewGroup2.findViewById(2131296472)).setText(localFacebookPhotoTag.f());
          if (localFacebookPhotoTag.a() > 0L)
          {
            PhotoGalleryActivity.2 local2 = new PhotoGalleryActivity.2(this, localFacebookPhotoTag);
            localViewGroup2.findViewById(2131296472).setOnClickListener(local2);
          }
          localFrameLayout.addView(localViewGroup2, a(localFacebookPhotoTag.f(), localViewGroup2, arrayOfFloat));
          continue;
        }
        localViewGroup1.setLayoutParams(a(localFacebookPhotoTag.f(), localViewGroup1, arrayOfFloat));
        localViewGroup1.requestLayout();
      }
    }
  }

  private void L()
  {
    if (this.T.getVisibility() == 0)
    {
      this.T.setVisibility(4);
      this.U.setVisibility(4);
      this.T.startAnimation(AnimationUtils.loadAnimation(this, 2130968589));
      this.U.startAnimation(AnimationUtils.loadAnimation(this, 2130968589));
    }
  }

  private void M()
  {
    Resources localResources1 = getResources();
    int i = this.V;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Integer.valueOf(this.V);
    String str1 = localResources1.getQuantityString(2131427345, i, arrayOfObject1);
    this.T.setText(str1);
    Resources localResources2 = getResources();
    int j = this.W;
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = Integer.valueOf(this.W);
    String str2 = localResources2.getQuantityString(2131427346, j, arrayOfObject2);
    this.U.setText(str2);
    if (this.V == 0)
      this.T.setVisibility(8);
    if (this.W == 0)
      this.U.setVisibility(8);
    if ((this.T.getVisibility() != 0) && (this.V != 0))
    {
      this.T.setVisibility(0);
      if (!this.aa)
        this.T.startAnimation(AnimationUtils.loadAnimation(this, 2130968584));
    }
    if ((this.U.getVisibility() != 0) && (this.W != 0))
    {
      this.U.setVisibility(0);
      if (!this.aa)
        this.U.startAnimation(AnimationUtils.loadAnimation(this, 2130968584));
    }
  }

  private FacebookPhoto N()
  {
    if (this.H != null);
    for (FacebookPhoto localFacebookPhoto = (FacebookPhoto)this.H.get(Long.valueOf(this.t)); ; localFacebookPhoto = null)
      return localFacebookPhoto;
  }

  private boolean O()
  {
    FacebookPhoto localFacebookPhoto = N();
    if ((localFacebookPhoto != null) && (localFacebookPhoto.l()));
    for (int i = 1; ; i = 0)
      return i;
  }

  private void P()
  {
    FacebookPhoto localFacebookPhoto = N();
    if (localFacebookPhoto != null)
    {
      String str = ((TextView)findViewById(2131297981)).getText().toString().trim();
      this.s.setText(str);
      this.o.b(this, localFacebookPhoto.b(), localFacebookPhoto.a(), str);
      localFacebookPhoto.b(str);
      o();
    }
    a(PhotoGalleryActivity.ViewMode.CONTROLS);
  }

  private void Q()
  {
    boolean bool = ((PhotoToggleButton)findViewById(2131296559)).isChecked();
    GraphObjectLike.Operation localOperation;
    InteractionLogger localInteractionLogger;
    if (bool)
    {
      localOperation = GraphObjectLike.Operation.LIKE;
      GraphObjectLike.a(this, localOperation, Long.valueOf(this.t));
      c(bool);
      localInteractionLogger = this.ab;
      if (!bool)
        break label108;
    }
    label108: for (String str = FB4A_AnalyticEntities.Actions.c; ; str = FB4A_AnalyticEntities.Actions.d)
    {
      localInteractionLogger.b(new HoneyClientEvent(str).f(Long.toString(this.t)).e(FB4A_AnalyticEntities.UIElementsTypes.a));
      this.y.remove(Long.valueOf(this.t));
      return;
      localOperation = GraphObjectLike.Operation.UNLIKE;
      break;
    }
  }

  public static Intent a(Context paramContext, long paramLong)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(paramLong);
    return IntentUriHandler.a(paramContext, StringLocaleUtil.a("fb://photo/%s/", arrayOfObject));
  }

  public static Intent a(Context paramContext, long paramLong, String paramString)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Long.valueOf(paramLong);
    arrayOfObject[1] = paramString;
    return IntentUriHandler.a(paramContext, StringLocaleUtil.a("fb://photo/%s/?set=%s", arrayOfObject));
  }

  private FrameLayout.LayoutParams a(String paramString, ViewGroup paramViewGroup, float[] paramArrayOfFloat)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 0);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131296472);
    Resources localResources = getResources();
    float f1 = 2.0F + (localTextView.getPaint().measureText(paramString) + 2 * localResources.getDimensionPixelOffset(2131230960));
    float f2 = localTextView.getPaint().ascent() + localTextView.getPaint().descent() + 2 * localResources.getDimensionPixelOffset(2131230960);
    localLayoutParams.leftMargin = (int)(paramArrayOfFloat[0] - f1 / 2.0F);
    localLayoutParams.topMargin = (int)(paramArrayOfFloat[1] - f2 / 2.0F + localResources.getDimensionPixelSize(2131230812) / 2);
    localLayoutParams.rightMargin = (int)(getWindowManager().getDefaultDisplay().getWidth() - localLayoutParams.leftMargin - f1);
    return localLayoutParams;
  }

  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 99; ; i = 98)
    {
      this.V = Math.min(paramInt1, i);
      this.W = Math.min(paramInt2, 99);
      this.Q.setChecked(paramBoolean);
      M();
      return;
    }
  }

  private void a(Feedback paramFeedback)
  {
    boolean bool = paramFeedback.doesViewerLike;
    a(paramFeedback.likers.count, paramFeedback.comments.count, bool);
  }

  private void a(PhotoGalleryActivity.ViewMode paramViewMode)
  {
    PhotoGalleryActivity.ViewMode localViewMode = this.u;
    if (localViewMode == PhotoGalleryActivity.ViewMode.CONTROLS)
    {
      B();
      this.u = paramViewMode;
      if (paramViewMode != PhotoGalleryActivity.ViewMode.CONTROLS)
        break label55;
      r();
    }
    while (true)
    {
      o();
      n();
      return;
      if (localViewMode != PhotoGalleryActivity.ViewMode.EDIT_CAPTION)
        break;
      q();
      break;
      label55: if (paramViewMode != PhotoGalleryActivity.ViewMode.EDIT_CAPTION)
        continue;
      p();
    }
  }

  private void a(FacebookPhotoSet paramFacebookPhotoSet)
  {
    this.J = paramFacebookPhotoSet;
    if ((this.H == null) || (this.H.size() != paramFacebookPhotoSet.a().size()))
      this.I = PhotosGetPhotos.a(this, paramFacebookPhotoSet.a());
    this.A.a(paramFacebookPhotoSet);
    PhotosetGalleryAdapter localPhotosetGalleryAdapter = this.A;
    long l;
    if (this.t > 0L)
      l = this.t;
    while (true)
    {
      localPhotosetGalleryAdapter.a(l);
      return;
      l = this.E;
    }
  }

  private void a(Set<Long> paramSet, int paramInt)
  {
    boolean bool = paramSet.contains(Long.valueOf(this.N));
    a(paramSet.size(), paramInt, bool);
  }

  private boolean a(long paramLong)
  {
    if ((paramLong <= 0L) || (this.v == null));
    for (boolean bool = false; ; bool = this.v.b(paramLong))
      return bool;
  }

  private void c(int paramInt)
  {
    View localView = findViewById(paramInt);
    int[] arrayOfInt = new int[2];
    localView.getLocationInWindow(arrayOfInt);
    arrayOfInt[0] += localView.getWidth() / 2;
    arrayOfInt[1] += localView.getHeight() / 2;
    Point localPoint = new Point(arrayOfInt[0], arrayOfInt[1]);
    if (!Strings.isNullOrEmpty(this.ag.h()))
    {
      FlyoutParams localFlyoutParams = new FlyoutParams(this.ag.h());
      this.at.a(this, localFlyoutParams, localPoint);
    }
    while (true)
    {
      this.aa = true;
      FacebookPhoto localFacebookPhoto;
      while (true)
      {
        return;
        localFacebookPhoto = N();
        if (localFacebookPhoto != null)
          break;
        ErrorReporting.a("photoset-gallery", "getCurrentPhoto == null");
      }
      this.at.a(this, String.valueOf(localFacebookPhoto.j()), localPoint);
    }
  }

  private void c(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 1 + this.V; ; i = -1 + this.V)
    {
      this.V = i;
      Resources localResources = getResources();
      int j = this.V;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.V);
      String str = localResources.getQuantityString(2131427345, j, arrayOfObject);
      this.T.setText(str);
      return;
    }
  }

  private void k()
  {
    this.ay = ((FeedPhotoStateManager)C().a(FeedPhotoStateManager.class));
    this.ah = ((AlbumIndexCache)C().a(AlbumIndexCache.class));
    this.af = ((ImageCache)C().a(ImageCache.class));
    this.ac = ((PhotoFlowLogger)C().a(PhotoFlowLogger.class));
    this.at = ((FlyoutAnimationHandler)C().a(FlyoutAnimationHandler.class));
    this.aq = ((FeedEventBus)C().a(FeedEventBus.class));
    this.au = ((NewsFeedCache)C().a(NewsFeedCache.class));
    this.av = ((GraphQLProfileCache)C().a(GraphQLProfileCache.class)).a();
    this.aw = ((FbErrorReporter)C().a(FbErrorReporter.class));
    this.ax = ((NewsFeedPhotoAnimation)C().a(NewsFeedPhotoAnimation.class));
  }

  private ImageViewTouchBase l()
  {
    if (this.z == null);
    for (ImageViewTouchBase localImageViewTouchBase = null; ; localImageViewTouchBase = (ImageViewTouchBase)this.z.findViewById(2131296625))
      return localImageViewTouchBase;
  }

  private void m()
  {
    this.am = AnimationUtils.loadAnimation(this, 2130968625);
    this.an = AnimationUtils.loadAnimation(this, 2130968626);
    this.ao = AnimationUtils.loadAnimation(this, 2130968584);
    this.ap = AnimationUtils.loadAnimation(this, 2130968589);
  }

  private void n()
  {
    if (this.F != null)
      if (this.M.getVisibility() != 0)
      {
        this.M.setVisibility(0);
        this.M.setAnimation(AnimationUtils.loadAnimation(this, 2130968581));
        this.M.requestFocus();
      }
    while (true)
    {
      J();
      return;
      if (this.M.getVisibility() != 0)
        continue;
      this.M.setAnimation(AnimationUtils.loadAnimation(this, 2130968582));
      this.M.setVisibility(4);
    }
  }

  private void o()
  {
    FacebookPhoto localFacebookPhoto = N();
    String str;
    if ((localFacebookPhoto != null) && (localFacebookPhoto.d() != null))
    {
      str = localFacebookPhoto.d();
      if ((this.u != PhotoGalleryActivity.ViewMode.CONTROLS) || (localFacebookPhoto == null) || (str.length() <= 0))
        break label69;
      this.s.setText(localFacebookPhoto.d());
      this.r.setVisibility(0);
    }
    while (true)
    {
      return;
      str = "";
      break;
      label69: this.r.setVisibility(8);
    }
  }

  private void p()
  {
    View localView = findViewById(2131297980);
    if (localView.getVisibility() != 0)
    {
      localView.setAnimation(this.am);
      localView.setVisibility(0);
    }
  }

  private void q()
  {
    View localView = findViewById(2131297980);
    if (localView.getVisibility() == 0)
    {
      localView.setAnimation(this.an);
      localView.setVisibility(8);
    }
  }

  private void r()
  {
    if (this.X)
      s();
    z();
  }

  private void s()
  {
    if (this.G);
    while (true)
    {
      return;
      View localView = findViewById(2131296475);
      if (localView.getVisibility() != 0)
      {
        localView.startAnimation(this.ao);
        localView.setVisibility(0);
      }
      this.Q.setColorFilter(-7829368);
      this.S.setColorFilter(-7829368);
      J();
    }
  }

  private void z()
  {
    if (this.G);
    while (true)
    {
      return;
      if (this.q.getVisibility() != 0)
      {
        this.q.startAnimation(this.ao);
        this.q.setVisibility(0);
        continue;
      }
    }
  }

  public void K()
  {
    FacebookPhoto localFacebookPhoto = N();
    if ((this.J != null) && (this.J.b()))
    {
      a(4, 2131362824, 2130838822);
      if ((localFacebookPhoto == null) || ((localFacebookPhoto.c() != this.o.b().userId) && (!a(this.o.b().userId))))
        break label143;
      a(7, 2131363269, 2130838828);
      label84: if ((localFacebookPhoto == null) || (localFacebookPhoto.c() != this.o.b().userId))
        break label152;
      a(1, 2131363265, 2130838302);
      a(2, 2131363264, 2130838824);
      d(8);
    }
    while (true)
    {
      return;
      d(4);
      break;
      label143: d(7);
      break label84;
      label152: a(8, 2131363272, 2130838312);
      d(1);
      d(2);
    }
  }

  public String a()
  {
    return FB4A_AnalyticEntities.t;
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    k();
    overridePendingTransition(0, 0);
    this.o = AppSession.a(this, true);
    this.N = this.o.b().userId;
    this.ab = new InteractionLogger(this);
    setContentView(2130903632);
    Intent localIntent = getIntent();
    this.P = localIntent.getStringExtra("fragment_id");
    if (this.P != null);
    String[] arrayOfString1;
    for (this.ag = this.ay.a(this.P); ; this.ag = ((FeedPhotoState)C().a(FeedPhotoState.class)))
    {
      String str1 = localIntent.getStringExtra("photo_uri");
      if (str1 != null)
      {
        this.ai = Uri.parse(str1);
        this.ag.a(this.ai);
      }
      this.K = localIntent.getStringExtra("photoset_token");
      this.E = localIntent.getLongExtra("photo_fbid", -1L);
      this.t = this.E;
      this.ag.a(Long.valueOf(this.E));
      this.O = localIntent.getStringExtra("story_cache_id");
      String str2 = localIntent.getStringExtra("feedback_id");
      this.ag.a(str2);
      this.al = Maps.a();
      this.al.put(Long.valueOf(this.t), str2);
      arrayOfString1 = localIntent.getStringArrayExtra("photoset_uris");
      if (arrayOfString1 == null)
        break;
      this.aj = Lists.a();
      int i1 = arrayOfString1.length;
      for (int i2 = 0; i2 < i1; i2++)
      {
        String str5 = arrayOfString1[i2];
        this.aj.add(Uri.parse(str5));
      }
    }
    String[] arrayOfString2 = localIntent.getStringArrayExtra("feedback_ids");
    long[] arrayOfLong = localIntent.getLongArrayExtra("photoset_ids");
    if (arrayOfLong != null)
    {
      this.ak = Lists.a();
      int j = arrayOfLong.length;
      int k = 0;
      int m = 0;
      if (k < j)
      {
        long l = arrayOfLong[k];
        String str4;
        label414: HashMap localHashMap;
        Long localLong;
        if (l == this.E)
        {
          this.ag.a((Uri)this.aj.get(m));
          FeedPhotoState localFeedPhotoState = this.ag;
          if (arrayOfString2 != null)
          {
            str4 = arrayOfString2[m];
            localFeedPhotoState.a(str4);
          }
        }
        else
        {
          this.ak.add(Long.valueOf(l));
          localHashMap = this.al;
          localLong = Long.valueOf(l);
          if (arrayOfString2 == null)
            break label486;
        }
        label486: for (String str3 = arrayOfString2[m]; ; str3 = null)
        {
          localHashMap.put(localLong, str3);
          m++;
          k++;
          break;
          str4 = null;
          break label414;
        }
      }
      this.J = FacebookPhotoSet.a(this.ak);
    }
    if ((arrayOfString1 == null) || (arrayOfLong == null))
      this.ag.b(Long.valueOf(this.E));
    if (this.E <= 0L)
    {
      Log.a("No initial FBID specificied");
      finish();
    }
    while (true)
    {
      return;
      this.z = ((PhotoGallery)findViewById(2131297398));
      this.A = new PhotosetGalleryAdapter(this, this.o, this.z, this.af);
      if (this.ai != null)
        this.A.a(Long.valueOf(this.E), this.ai);
      if (this.aj != null)
        for (int i = 0; i < this.ak.size(); i++)
          this.A.a((Long)this.ak.get(i), (Uri)this.aj.get(i));
      this.z.setAdapter(this.A);
      this.z.setOnItemSelectedListener(this.aA);
      m();
      this.r = ((LinearLayout)findViewById(2131296555));
      this.s = ((TextView)findViewById(2131296556));
      this.q = ((LinearLayout)findViewById(2131296554));
      TagTypeaheadAdapter localTagTypeaheadAdapter = new TagTypeaheadAdapter(this);
      localTagTypeaheadAdapter.a(new PhotoGalleryActivity.DuplicateTagFilter(this, null));
      this.L = ((AutoCompleteTextView)findViewById(2131296472));
      this.L.setAdapter(localTagTypeaheadAdapter);
      this.M = findViewById(2131296471);
      this.L.setDropDownAnchor(2131296474);
      this.L.setDropDownVerticalOffset(0);
      this.L.setOnKeyListener(new PhotoGalleryActivity.TypeaheadStartTypingListener(this, null));
      this.L.setOnItemClickListener(new PhotoGalleryActivity.TypeaheadItemClickListener(this, null));
      this.B = new GestureDetector(this, this.aB);
      this.Q = ((PhotoToggleButton)findViewById(2131296559));
      this.R = ((PhotoButton)findViewById(2131296561));
      this.T = ((TextView)findViewById(2131297985));
      this.U = ((TextView)findViewById(2131297986));
      this.S = ((PhotoButton)findViewById(2131296560));
      this.T.setOnClickListener(this);
      this.U.setOnClickListener(this);
      this.S.setOnClickListener(this);
      findViewById(2131297982).setOnClickListener(this);
      findViewById(2131297983).setOnClickListener(this);
      findViewById(2131296561).setOnClickListener(this);
      findViewById(2131296473).setOnClickListener(this);
      findViewById(2131297987).setOnClickListener(this);
      this.Q.setOnCheckedChangeListener(this);
      E();
      this.X = false;
      this.D = LayoutInflater.from(this);
    }
  }

  public void a(PhotoToggleButton paramPhotoToggleButton, boolean paramBoolean)
  {
    Q();
  }

  public void a(CustomMenuItem paramCustomMenuItem)
  {
    FacebookPhoto localFacebookPhoto = FacebookPhoto.a(this, this.t);
    if (localFacebookPhoto == null);
    while (true)
    {
      return;
      Intent localIntent2;
      Bitmap localBitmap;
      switch (paramCustomMenuItem.c())
      {
      case 3:
      default:
        break;
      case 1:
        ((TextView)findViewById(2131297981)).setText(localFacebookPhoto.d());
        a(PhotoGalleryActivity.ViewMode.EDIT_CAPTION);
        break;
      case 2:
        showDialog(2);
        break;
      case 4:
        startActivity(PhotoSetActivity.a(this, this.K));
        break;
      case 7:
        localIntent2 = new Intent(this, CropImageActivity.class);
        localBitmap = ((BitmapDrawable)((ImageViewTouchBase)this.z.getSelectedView().findViewById(2131296625)).getDrawable()).getBitmap();
      case 5:
      case 6:
      case 8:
        try
        {
          FileOutputStream localFileOutputStream = openFileOutput("upload_croppic.jpg", 0);
          localBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream);
          localFileOutputStream.flush();
          localFileOutputStream.close();
          localIntent2.putExtra("input_image_path_extra", getFilesDir().getAbsolutePath() + "/" + "upload_croppic.jpg");
          startActivityForResult(localIntent2, 1);
          continue;
          String str2 = localFacebookPhoto.k();
          if (str2 == null)
          {
            ImageCacheKey localImageCacheKey = this.A.a(Long.valueOf(this.t));
            if (localImageCacheKey != null)
              str2 = this.af.a(localImageCacheKey).getPath();
          }
          Intent localIntent1;
          String str3;
          if (paramCustomMenuItem.c() == 5)
          {
            if (str2 == null)
              continue;
            Uri localUri = TempFileManager.a(str2);
            if (localUri == null)
              continue;
            localIntent1 = new Intent("android.intent.action.ATTACH_DATA");
            localIntent1.setDataAndType(localUri, "image/jpeg");
            localIntent1.putExtra("mimeType", "image/jpeg");
            str3 = getString(2131363271);
            try
            {
              startActivity(Intent.createChooser(localIntent1, str3));
            }
            catch (ActivityNotFoundException localActivityNotFoundException)
            {
              Toaster.a(this, 2131363270);
            }
            continue;
          }
          if (str2 == null);
          for (Object localObject = null; ; localObject = TempFileManager.a(str2))
          {
            localIntent1 = new Intent("android.intent.action.SEND");
            localIntent1.setType("image/jpeg");
            localIntent1.putExtra("android.intent.extra.STREAM", (Parcelable)localObject);
            localIntent1.putExtra("photo_fbid", this.t);
            str3 = getString(2131363273);
            break;
          }
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Long.valueOf(this.t);
          String str1 = IntentUriHandler.a(Uri.parse(StringLocaleUtil.a("/report/id/?fbid=%1$d", arrayOfObject)));
          ((SecureContextHelper)C().a(SecureContextHelper.class)).a(IntentUriHandler.a(this, str1), this);
        }
        catch (Exception localException)
        {
        }
      }
    }
  }

  public void d()
  {
    a(this);
    a(5, 2131363271, 2130838830);
    a(6, 2131363273, 2130838832);
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.B.onTouchEvent(paramMotionEvent)) || (super.dispatchTouchEvent(paramMotionEvent)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public String i()
  {
    return null;
  }

  public void j()
  {
    J();
    if ((this.p != null) && (this.F != null))
    {
      ImageViewTouchBase localImageViewTouchBase = l();
      if (localImageViewTouchBase != null)
        this.p.a(this.F, localImageViewTouchBase.getImageRect());
    }
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      FacebookPhoto localFacebookPhoto = N();
      if ((paramInt2 == -1) && (localFacebookPhoto != null))
      {
        Rect localRect = (Rect)paramIntent.getExtras().get("image_crop_rect_extra");
        showDialog(1);
        CropProfilePicture.a(this, localFacebookPhoto.c(), localFacebookPhoto.a(), localRect.left, localRect.top, localRect.width(), localRect.height());
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onBackPressed()
  {
    if (y())
      this.aa = false;
    while (true)
    {
      return;
      ImageViewTouchBase localImageViewTouchBase = l();
      if (this.u == PhotoGalleryActivity.ViewMode.EDIT_CAPTION)
      {
        a(PhotoGalleryActivity.ViewMode.CONTROLS);
        continue;
      }
      if ((this.u == PhotoGalleryActivity.ViewMode.CONTROLS) && (this.F != null))
      {
        A();
        continue;
      }
      if ((localImageViewTouchBase != null) && (localImageViewTouchBase.getScale() > 1.0F))
      {
        localImageViewTouchBase.a(1.0F);
        continue;
      }
      super.onBackPressed();
    }
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131297982)
      P();
    while (true)
    {
      return;
      if (i == 2131297983)
      {
        ((TextView)findViewById(2131297981)).setText("");
        continue;
      }
      if ((i == 2131297985) || (i == 2131297986) || (i == 2131296560))
      {
        c(i);
        continue;
      }
      if (i == 2131296561)
      {
        if (!this.X)
        {
          this.ac.d();
          s();
          this.X = true;
          if (!O())
            continue;
          I();
          continue;
        }
        E();
        A();
        this.X = false;
        continue;
      }
      if (i == 2131296473)
      {
        onClickTagX(paramView);
        continue;
      }
      if (i != 2131297987)
        continue;
      onDoneTaggingBtn(paramView);
    }
  }

  public void onClickTagX(View paramView)
  {
    if (this.L.getText().length() > 0)
      this.L.setText("");
    while (true)
    {
      return;
      this.ac.c();
      a(PhotoGalleryActivity.ViewMode.CONTROLS);
    }
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default:
      localObject = super.onCreateDialog(paramInt);
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return localObject;
      localObject = new ProgressDialog(this);
      ((ProgressDialog)localObject).setProgressStyle(0);
      ((ProgressDialog)localObject).setMessage(getText(2131363268));
      ((ProgressDialog)localObject).setIndeterminate(true);
      ((ProgressDialog)localObject).setCancelable(false);
      continue;
      PhotoGalleryActivity.5 local5 = new PhotoGalleryActivity.5(this);
      localObject = AlertDialogs.a(this, getString(2131363036), 17301543, getString(2131363038), getString(2131363280), local5, getString(2131363016), null, null, true);
      continue;
      localObject = new ProgressDialog(this);
      ((ProgressDialog)localObject).setProgressStyle(0);
      ((ProgressDialog)localObject).setMessage(getText(2131363039));
      ((ProgressDialog)localObject).setIndeterminate(true);
      ((ProgressDialog)localObject).setCancelable(false);
    }
  }

  public void onDoneTaggingBtn(View paramView)
  {
    a(PhotoGalleryActivity.ViewMode.CONTROLS);
  }

  protected void onPause()
  {
    overridePendingTransition(0, 0);
    this.G = true;
    if (this.o != null)
      this.o.b(this.az);
    if (this.ar != null)
    {
      this.aq.b(this.ar);
      this.ar = null;
    }
    if (this.as != null)
    {
      this.aq.b(this.as);
      this.as = null;
    }
    super.onPause();
  }

  protected void onResume()
  {
    super.onResume();
    this.ax.a(true);
    if (this.aj == null)
      this.ag.b(Long.valueOf(this.E));
    this.ag.a(Long.valueOf(this.t));
    ImageCacheKey localImageCacheKey = this.A.a(Long.valueOf(this.t));
    this.ag.a(localImageCacheKey);
    if ((this.O != null) && (localImageCacheKey != null) && (this.ah.a(this.O) != null))
      this.ah.a(this.O, localImageCacheKey.a());
    overridePendingTransition(0, 0);
    this.G = false;
    this.o = AppSession.b(this, true);
    if (this.o == null)
    {
      Log.a(n, "Invalid session");
      finish();
    }
    while (true)
    {
      return;
      this.o.a(this.az);
      if ((this.x != null) && (!this.o.a(this.x)))
      {
        removeDialog(3);
        this.x = null;
      }
      FacebookPhotoSet localFacebookPhotoSet = this.J;
      if (this.K != null)
      {
        localFacebookPhotoSet = FacebookPhotoSet.a(this, this.K);
        if ((localFacebookPhotoSet != null) && (!localFacebookPhotoSet.a().contains(Long.valueOf(this.E))) && (!this.Y))
        {
          FacebookPhotoSet.b(this, this.K);
          localFacebookPhotoSet = FacebookPhotoSet.a(this, this.K);
          this.Y = true;
        }
      }
      if (localFacebookPhotoSet == null)
        localFacebookPhotoSet = FacebookPhotoSet.c(this.E);
      a(localFacebookPhotoSet);
      this.ar = new PhotoGalleryActivity.SetUpFlyoutEventSubscriber(this, null);
      this.aq.a(this.ar);
      this.as = new PhotoGalleryActivity.LikeActionResultEventSubscriber(this, null);
      this.aq.a(this.as);
    }
  }

  protected void onStop()
  {
    super.onStop();
    if (isFinishing())
      TempFileManager.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotoGalleryActivity
 * JD-Core Version:    0.6.0
 */