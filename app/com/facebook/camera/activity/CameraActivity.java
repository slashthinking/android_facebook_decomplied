package com.facebook.camera.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.camera.device.CameraHolder;
import com.facebook.camera.device.CameraHolder.CameraListener;
import com.facebook.camera.device.CameraPreview;
import com.facebook.camera.facetracking.FaceDetectionIndicatorView;
import com.facebook.camera.support.CameraFlowLogger;
import com.facebook.camera.support.CameraGating;
import com.facebook.camera.support.CameraSupport;
import com.facebook.camera.utils.MediaUtil.Orientation;
import com.facebook.camera.utils.RotateLayout;
import com.facebook.camera.utils.Storage;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.content.SecureContextHelper;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.inject.FbInjector;
import com.google.common.base.Preconditions;
import java.lang.ref.SoftReference;

public class CameraActivity extends FbFragmentActivity
  implements CameraHolder.CameraListener
{
  private static SoftReference<CameraActivity.CameraPhotoData> ae;
  private static volatile Uri af;
  private static final Object ag;
  private static final Class<?> n = CameraActivity.class;
  private static final String o = n.getSimpleName();
  private RelativeLayout A;
  private RelativeLayout B;
  private TextView C;
  private TextView D;
  private RotateLayout E;
  private ImageView F;
  private FaceDetectionIndicatorView G;
  private float H;
  private ObjectAnimator I = null;
  private boolean J;
  private boolean K;
  private boolean L;
  private boolean M;
  private boolean N;
  private long O;
  private int P;
  private boolean Q = false;
  private int R = 1;
  private PowerManager.WakeLock S;
  private Storage T;
  private CameraActivity.OrientationListener U;
  private CameraFlowLogger V;
  private CameraSupport W;
  private CameraGating X;
  private final int Y = 40;
  private MediaUtil.Orientation Z = MediaUtil.Orientation.UNINITIALIZED;
  private MediaUtil.Orientation aa = MediaUtil.Orientation.PORTRAIT;
  private CameraHolder ab;
  private Uri ac = null;
  private boolean ad = false;
  private final View.OnTouchListener ah = new CameraActivity.2(this);
  private final View.OnClickListener ai = new CameraActivity.3(this);
  private final View.OnClickListener aj = new CameraActivity.4(this);
  private CameraPreview p;
  private RelativeLayout q;
  private RelativeLayout r;
  private ImageView s;
  private RotateLayout t;
  private Button u;
  private Button v;
  private Button w;
  private CameraActivity.Corner x;
  private Button y;
  private CameraActivity.Corner z;

  static
  {
    ag = new Object();
  }

  private void A()
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    this.ac = this.T.c();
    localIntent.putExtra("output", this.ac);
    startActivityForResult(localIntent, 1339);
  }

  private void B()
  {
    startActivityForResult(new Intent("android.media.action.VIDEO_CAPTURE"), 1336);
  }

  private boolean E()
  {
    boolean bool = true;
    if (this.B.getVisibility() == 0)
    {
      a(this.B, 2130968591);
      this.B.setVisibility(8);
      b(bool);
    }
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  public static Intent a(Activity paramActivity)
  {
    return a(paramActivity, -1L, null);
  }

  public static Intent a(Activity paramActivity, long paramLong)
  {
    return a(paramActivity, paramLong, null);
  }

  public static Intent a(Activity paramActivity, long paramLong, String paramString)
  {
    return new Intent(paramActivity, CameraActivity.class).putExtra("extra_target_id", paramLong).putExtra("source_activity", paramActivity.getLocalClassName()).putExtra("publisher_type", paramString);
  }

  private void a(int paramInt1, int paramInt2)
  {
    if (u())
    {
      a(this.u, paramInt1, paramInt2);
      a(this.s, paramInt1, paramInt2);
      a(this.F, paramInt1, paramInt2);
    }
    while (true)
    {
      return;
      if (this.I != null)
        this.I.cancel();
      this.u.setPivotX(this.u.getWidth() / 2);
      this.u.setPivotY(this.u.getHeight() / 2);
      this.s.setPivotX(this.s.getWidth() / 2);
      this.s.setPivotY(this.s.getHeight() / 2);
      this.F.setPivotX(this.F.getWidth() / 2);
      this.F.setPivotY(this.F.getHeight() / 2);
      if (paramInt1 != paramInt2)
      {
        float[] arrayOfFloat = new float[2];
        arrayOfFloat[0] = paramInt1;
        arrayOfFloat[1] = paramInt2;
        this.I = ObjectAnimator.ofFloat(this, "IconsRotationAngle", arrayOfFloat);
        this.I.setDuration(400L);
        this.I.addListener(new CameraActivity.1(this));
        this.I.start();
        continue;
      }
      setIconsRotationAngle(paramInt2);
    }
  }

  private void a(Uri paramUri, int paramInt)
  {
    boolean bool = this.J;
    Bundle localBundle = null;
    if (!bool)
      localBundle = getIntent().getBundleExtra("composer_extras");
    Intent localIntent = this.W.a(this, paramUri, paramInt, this.J, this.O, localBundle);
    if (localIntent != null)
    {
      this.V.a(localIntent);
      localIntent.putExtra("publisher_type", getIntent().getStringExtra("publisher_type"));
      startActivityForResult(localIntent, 1334);
    }
    while (true)
    {
      return;
      Log.b(o, "no ReviewActivity intent could be created");
    }
  }

  private void a(View paramView, int paramInt)
  {
    paramView.startAnimation(AnimationUtils.loadAnimation(this, paramInt));
  }

  private void a(View paramView, int paramInt1, int paramInt2)
  {
    RotateAnimation localRotateAnimation = new RotateAnimation(paramInt1, paramInt2, paramView.getWidth() / 2, paramView.getHeight() / 2);
    localRotateAnimation.setFillEnabled(true);
    localRotateAnimation.setFillAfter(true);
    long l;
    if (paramInt1 != paramInt2)
      l = 400L;
    while (true)
    {
      localRotateAnimation.setDuration(l);
      paramView.startAnimation(localRotateAnimation);
      return;
      l = 0L;
    }
  }

  private void a(View paramView, int paramInt1, int paramInt2, CameraActivity.Corner paramCorner, boolean paramBoolean)
  {
    float f = 1.0F;
    int i = 0;
    boolean bool;
    AnimationSet localAnimationSet;
    label43: long l;
    if (paramView.getVisibility() == 0)
    {
      bool = true;
      if (!u())
        break label275;
      localAnimationSet = new AnimationSet(true);
      if (paramBoolean)
        break label183;
      if (!bool)
        break label171;
      AlphaAnimation localAlphaAnimation3 = new AlphaAnimation(f, 0.0F);
      if (!bool)
        break label177;
      l = 'È';
      label66: localAlphaAnimation3.setDuration(l);
      localAnimationSet.addAnimation(localAlphaAnimation3);
    }
    while (true)
    {
      RotateAnimation localRotateAnimation = new RotateAnimation(paramInt1, paramInt2, paramView.getWidth() / 2, paramView.getHeight() / 2);
      localRotateAnimation.setStartOffset(i);
      localRotateAnimation.setDuration(1L);
      localRotateAnimation.setAnimationListener(new CameraActivity.IconMover(this, paramView, paramCorner, paramBoolean));
      localAnimationSet.addAnimation(localRotateAnimation);
      localAnimationSet.setFillEnabled(true);
      localAnimationSet.setFillAfter(true);
      paramView.startAnimation(localAnimationSet);
      return;
      bool = false;
      break;
      label171: f = 0.0F;
      break label43;
      label177: l = 0L;
      break label66;
      label183: if ((paramInt1 != paramInt2) && (bool))
      {
        AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(f, 0.0F);
        localAlphaAnimation2.setDuration(200);
        localAlphaAnimation2.setRepeatCount(1);
        localAlphaAnimation2.setRepeatMode(2);
        localAnimationSet.addAnimation(localAlphaAnimation2);
        j = 200;
        continue;
      }
      AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, f);
      localAlphaAnimation1.setDuration(400);
      localAnimationSet.addAnimation(localAlphaAnimation1);
      int j = 0;
    }
    label275: paramView.setPivotX(paramView.getWidth() / 2);
    paramView.setPivotY(paramView.getHeight() / 2);
    ObjectAnimator localObjectAnimator1 = (ObjectAnimator)paramView.getTag();
    if (localObjectAnimator1 != null)
      localObjectAnimator1.cancel();
    Object localObject;
    if (paramBoolean == bool)
      if (paramBoolean)
      {
        ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(paramView, "Alpha", new float[] { 1.0F, 0.0F });
        localObjectAnimator4.setDuration(200L);
        localObjectAnimator4.setRepeatCount(1);
        localObjectAnimator4.setRepeatMode(2);
        localObjectAnimator4.addListener(new CameraActivity.IconMoverRotater(this, paramView, paramInt2, paramCorner, false));
        localObjectAnimator4.start();
        localObject = localObjectAnimator4;
      }
    while (true)
    {
      paramView.setTag(localObject);
      break;
      a(paramView, paramCorner);
      paramView.setRotation(paramInt2);
      localObject = null;
      continue;
      if (paramBoolean)
      {
        paramView.setAlpha(0.0F);
        CameraActivity.IconMoverRotater localIconMoverRotater = new CameraActivity.IconMoverRotater(this, paramView, paramInt2, paramCorner, false);
        CameraActivity.IconMoverRotater.a(localIconMoverRotater);
        paramView.setVisibility(0);
        ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramView, "Alpha", new float[] { 0.0F, 1.0F });
        localObjectAnimator3.setDuration(400L);
        localObjectAnimator3.addListener(localIconMoverRotater);
        localObjectAnimator3.start();
        localObject = localObjectAnimator3;
        continue;
      }
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "Alpha", new float[] { 1.0F, 0.0F });
      localObjectAnimator2.setDuration(400L);
      localObjectAnimator2.addListener(new CameraActivity.IconMoverRotater(this, paramView, paramInt2, paramCorner, true));
      localObjectAnimator2.start();
      localObject = localObjectAnimator2;
    }
  }

  private void a(View paramView, CameraActivity.Corner paramCorner)
  {
    int i = 10 * (int)getApplicationContext().getResources().getDisplayMetrics().density;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    if ((paramCorner == CameraActivity.Corner.TOP_LEFT) || (paramCorner == CameraActivity.Corner.BOTTOM_LEFT))
    {
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = 0;
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      if ((paramCorner != CameraActivity.Corner.TOP_LEFT) && (paramCorner != CameraActivity.Corner.TOP_RIGHT))
        break label144;
      localLayoutParams.topMargin = i;
      localLayoutParams.bottomMargin = 0;
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(12, 0);
    }
    while (true)
    {
      paramView.requestLayout();
      return;
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = i;
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11);
      break;
      label144: localLayoutParams.topMargin = 0;
      localLayoutParams.bottomMargin = i;
      localLayoutParams.addRule(10, 0);
      localLayoutParams.addRule(12);
    }
  }

  private void a(MediaUtil.Orientation paramOrientation)
  {
    switch (CameraActivity.12.a[this.aa.ordinal()])
    {
    default:
      if (paramOrientation != MediaUtil.Orientation.LANDSCAPE)
        break;
      this.z = CameraActivity.Corner.TOP_RIGHT;
      this.x = CameraActivity.Corner.BOTTOM_RIGHT;
    case 2:
    case 3:
    }
    while (true)
    {
      return;
      if (paramOrientation == MediaUtil.Orientation.PORTRAIT)
      {
        this.z = CameraActivity.Corner.TOP_LEFT;
        this.x = CameraActivity.Corner.TOP_RIGHT;
        continue;
      }
      if (paramOrientation == MediaUtil.Orientation.REVERSE_LANDSCAPE)
      {
        this.z = CameraActivity.Corner.BOTTOM_LEFT;
        this.x = CameraActivity.Corner.TOP_LEFT;
        continue;
      }
      this.z = CameraActivity.Corner.TOP_RIGHT;
      this.x = CameraActivity.Corner.TOP_LEFT;
      continue;
      if (paramOrientation == MediaUtil.Orientation.LANDSCAPE)
      {
        this.z = CameraActivity.Corner.TOP_LEFT;
        this.x = CameraActivity.Corner.TOP_RIGHT;
        continue;
      }
      if (paramOrientation == MediaUtil.Orientation.PORTRAIT)
      {
        this.z = CameraActivity.Corner.BOTTOM_LEFT;
        this.x = CameraActivity.Corner.TOP_LEFT;
        continue;
      }
      if (paramOrientation == MediaUtil.Orientation.REVERSE_LANDSCAPE)
      {
        this.z = CameraActivity.Corner.BOTTOM_RIGHT;
        this.x = CameraActivity.Corner.BOTTOM_LEFT;
        continue;
      }
      this.z = CameraActivity.Corner.TOP_LEFT;
      this.x = CameraActivity.Corner.BOTTOM_LEFT;
      continue;
      if (paramOrientation == MediaUtil.Orientation.LANDSCAPE)
      {
        this.z = CameraActivity.Corner.BOTTOM_RIGHT;
        this.x = CameraActivity.Corner.BOTTOM_LEFT;
        continue;
      }
      if (paramOrientation == MediaUtil.Orientation.PORTRAIT)
      {
        this.z = CameraActivity.Corner.TOP_RIGHT;
        this.x = CameraActivity.Corner.BOTTOM_RIGHT;
        continue;
      }
      if (paramOrientation == MediaUtil.Orientation.REVERSE_LANDSCAPE)
      {
        this.z = CameraActivity.Corner.TOP_LEFT;
        this.x = CameraActivity.Corner.TOP_RIGHT;
        continue;
      }
      this.z = CameraActivity.Corner.BOTTOM_RIGHT;
      this.x = CameraActivity.Corner.TOP_RIGHT;
    }
  }

  private void a(MediaUtil.Orientation paramOrientation1, MediaUtil.Orientation paramOrientation2)
  {
    int i = b(paramOrientation1);
    int j = b(paramOrientation2);
    if (j - i >= 270)
      j -= 360;
    while (true)
    {
      a(i, j);
      a(paramOrientation2);
      a(this.w, i, j, this.x, this.ab.p());
      a(this.y, i, j, this.z, this.ab.b());
      this.E.setOrientation(j);
      return;
      if (j - i > -270)
        continue;
      j += 360;
    }
  }

  public static void a(byte[] paramArrayOfByte, int paramInt)
  {
    synchronized (ag)
    {
      ae = new SoftReference(new CameraActivity.CameraPhotoData(paramArrayOfByte, paramInt));
      return;
    }
  }

  private int b(MediaUtil.Orientation paramOrientation)
  {
    return -90 + (paramOrientation.mRotation + this.aa.mReverseRotation);
  }

  public static Intent b(Activity paramActivity)
  {
    return new Intent(paramActivity, CameraActivity.class).putExtra("extra_no_composer", true).putExtra("source_activity", paramActivity.getLocalClassName());
  }

  private void c(Uri paramUri)
  {
    Log.e(o, "launching composer for video due to native camera");
    Intent localIntent1 = new Intent();
    this.V.a(localIntent1);
    localIntent1.putExtra("mediaContentType", 2);
    if (this.J)
    {
      localIntent1.setData(paramUri);
      setResult(2, localIntent1);
      finish();
    }
    while (true)
    {
      return;
      Intent localIntent2 = this.W.a(this, paramUri, localIntent1, this.O);
      if (localIntent2 != null)
      {
        ((SecureContextHelper)C().a(SecureContextHelper.class)).a(localIntent2, 1337, this);
        continue;
      }
      Log.b(o, "no ComposerForVideo intent could be created");
    }
  }

  private void d(int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.PICK");
    if (paramInt == 1)
      localIntent.setType("image/*");
    while (true)
    {
      startActivityForResult(localIntent, 1335);
      do
        return;
      while (paramInt != 2);
      localIntent.setType("video/*");
    }
  }

  private static void d(Uri paramUri)
  {
    synchronized (ag)
    {
      af = paramUri;
      if (paramUri != null)
        ag.notifyAll();
      return;
    }
  }

  private void e(boolean paramBoolean)
  {
    int i = b(r());
    a(this.w, i, i, this.x, paramBoolean);
  }

  private void f(boolean paramBoolean)
  {
    int i = b(r());
    a(this.y, i, i, this.z, paramBoolean);
  }

  private void g(boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2;
    label22: boolean bool3;
    label40: boolean bool4;
    label60: RelativeLayout localRelativeLayout2;
    if (paramBoolean)
    {
      this.v.setBackgroundResource(2130837676);
      if (paramBoolean)
        break label97;
      bool2 = bool1;
      f(bool2);
      Button localButton = this.y;
      if (paramBoolean)
        break label102;
      bool3 = bool1;
      localButton.setClickable(bool3);
      RelativeLayout localRelativeLayout1 = this.r;
      if (paramBoolean)
        break label108;
      bool4 = bool1;
      localRelativeLayout1.setClickable(bool4);
      localRelativeLayout2 = this.A;
      if (paramBoolean)
        break label114;
    }
    while (true)
    {
      localRelativeLayout2.setClickable(bool1);
      return;
      this.v.setBackgroundResource(2130837678);
      break;
      label97: bool2 = false;
      break label22;
      label102: bool3 = false;
      break label40;
      label108: bool4 = false;
      break label60;
      label114: bool1 = false;
    }
  }

  public static CameraActivity.CameraPhotoData i()
  {
    while (true)
    {
      synchronized (ag)
      {
        if (ae != null)
        {
          localCameraPhotoData = (CameraActivity.CameraPhotoData)ae.get();
          return localCameraPhotoData;
        }
      }
      CameraActivity.CameraPhotoData localCameraPhotoData = null;
    }
  }

  public static Uri j()
  {
    synchronized (ag)
    {
      Uri localUri1 = af;
      if (localUri1 != null);
    }
    try
    {
      ag.wait(2000L);
      label23: Uri localUri2 = af;
      monitorexit;
      return localUri2;
      localObject2 = finally;
      monitorexit;
      throw localObject2;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label23;
    }
  }

  private void setIconsRotationAngle(float paramFloat)
  {
    this.H = paramFloat;
    this.u.setRotation(this.H);
    this.s.setRotation(this.H);
    this.F.setRotation(this.H);
  }

  private static void t()
  {
    synchronized (ag)
    {
      ae = null;
      af = null;
      return;
    }
  }

  private boolean u()
  {
    if (Build.VERSION.SDK_INT < 16);
    for (int i = 1; ; i = 0)
      return i;
  }

  private void v()
  {
    startActivityForResult(new Intent(this, CameraFallbackActivity.class), 1338);
  }

  private void w()
  {
    Toast.makeText(this, 2131361985, 0).show();
  }

  private void x()
  {
    Toast.makeText(this, 2131361986, 1).show();
  }

  private void y()
  {
    Toast.makeText(this, 2131361987, 1).show();
  }

  private void z()
  {
    this.q = ((RelativeLayout)findViewById(2131296442));
    this.A = ((RelativeLayout)findViewById(2131296446));
    this.w = ((Button)findViewById(2131296444));
    this.r = ((RelativeLayout)findViewById(2131296451));
    this.t = ((RotateLayout)findViewById(2131296869));
    this.u = ((Button)findViewById(2131296449));
    this.v = ((Button)findViewById(2131296450));
    this.B = ((RelativeLayout)findViewById(2131296453));
    this.C = ((TextView)findViewById(2131296456));
    this.D = ((TextView)findViewById(2131296457));
    this.E = ((RotateLayout)findViewById(2131296454));
    this.F = ((ImageView)findViewById(2131296447));
    this.y = ((Button)findViewById(2131296445));
    this.G = null;
  }

  public void a(Uri paramUri)
  {
    if (paramUri == null)
      y();
    if (!this.Q)
      setResult(6);
    while (true)
    {
      return;
      a(paramUri, 2);
    }
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.V = ((CameraFlowLogger)C().a(CameraFlowLogger.class));
    Preconditions.checkNotNull(this.V);
    String str = getIntent().getStringExtra("source_activity");
    this.V.a(paramBundle, str);
    this.X = ((CameraGating)C().a(CameraGating.class));
    Preconditions.checkNotNull(this.X);
    this.X.a(this);
    this.W = ((CameraSupport)C().a(CameraSupport.class));
    Preconditions.checkNotNull(this.W);
    this.T = ((Storage)C().a(Storage.class));
    Preconditions.checkNotNull(this.T);
    this.aa = k();
    a(this.aa);
    this.V.a(this.aa.toString());
    int i;
    switch (CameraActivity.12.a[this.aa.ordinal()])
    {
    default:
      setRequestedOrientation(1);
      i = 2130903084;
      requestWindowFeature(1);
      getWindow().addFlags(1024);
      getWindow().clearFlags(2048);
      setContentView(i);
      Intent localIntent = getIntent();
      SharedPreferences localSharedPreferences = getPreferences(0);
      getIntent().getBooleanExtra("started_from_launcher", false);
      z();
      this.P = localIntent.getIntExtra("desired_initial_facing", 0);
      this.ab = new CameraHolder(this, this, localSharedPreferences, this.V, this.T, this.X);
      this.U = new CameraActivity.OrientationListener(this, this, 2);
      this.ab.e();
      this.J = localIntent.getBooleanExtra("extra_no_composer", false);
      this.K = localIntent.getBooleanExtra("extra_show_gallery", true);
      this.L = localIntent.getBooleanExtra("return_after_snap", false);
      this.M = localIntent.getBooleanExtra("profile_crop_overlay", false);
      this.O = localIntent.getLongExtra("extra_target_id", -1L);
      this.N = localIntent.getBooleanExtra("extra_disable_video", false);
      this.Q = localIntent.getBooleanExtra("fire_review_after_photo", false);
      this.w.setOnTouchListener(this.ab.o());
      if (!this.K)
        break;
      this.A.setOnClickListener(new CameraActivity.5(this));
      label460: if (this.M)
      {
        View localView = ((LayoutInflater)getApplicationContext().getSystemService("layout_inflater")).inflate(2130903085, null);
        ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.q.addView(localView, 0, localLayoutParams);
      }
      if (!this.ab.b())
      {
        f(false);
        label527: this.B.setOnTouchListener(new CameraActivity.7(this));
        this.u.setOnTouchListener(this.ah);
        this.u.setOnClickListener(this.ai);
        this.v.setOnClickListener(this.aj);
        this.s = ((ImageView)findViewById(2131296452));
        this.s.setClickable(false);
        this.v.setVisibility(8);
        this.u.setVisibility(0);
        if (!this.N)
          break label747;
        this.r.setVisibility(4);
      }
    case 2:
    case 3:
    }
    while (true)
    {
      this.C.setOnClickListener(new CameraActivity.10(this));
      this.D.setOnClickListener(new CameraActivity.11(this));
      this.S = ((PowerManager)getSystemService("power")).newWakeLock(10, "Camera");
      this.S.setReferenceCounted(false);
      return;
      setRequestedOrientation(0);
      i = 2130903083;
      break;
      setRequestedOrientation(8);
      i = 2130903086;
      break;
      this.A.setVisibility(8);
      break label460;
      this.y.setOnClickListener(new CameraActivity.6(this));
      break label527;
      label747: if (this.X.b())
      {
        this.r.setOnClickListener(new CameraActivity.8(this));
        continue;
      }
      this.r.setOnClickListener(new CameraActivity.9(this));
    }
  }

  public void a(CameraPreview paramCameraPreview)
  {
    this.q.addView(paramCameraPreview, 0);
    this.p = paramCameraPreview;
    if (this.Z == MediaUtil.Orientation.UNINITIALIZED)
      a(this.aa, this.aa);
  }

  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
      this.U.enable();
    while (true)
    {
      this.u.setClickable(paramBoolean);
      this.r.setClickable(paramBoolean);
      return;
      this.U.disable();
    }
  }

  public void b(byte[] paramArrayOfByte, int paramInt)
  {
    a(paramArrayOfByte, paramInt);
    if (!this.Q)
    {
      setResult(5);
      if (this.X.b())
      {
        this.ab.k();
        c(true);
      }
    }
    while (true)
    {
      return;
      this.ab.j();
      continue;
      a(null, 1);
    }
  }

  public boolean b(Uri paramUri)
  {
    d(paramUri);
    sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + paramUri.getPath())));
    if (this.X.b())
      b(true);
    if (this.L)
    {
      setResult(5);
      finish();
    }
    return false;
  }

  public void c(int paramInt)
  {
    this.w.setBackgroundResource(paramInt);
  }

  public void c(boolean paramBoolean)
  {
    if (!paramBoolean)
      v();
    while (true)
    {
      return;
      this.V.c();
      if ((this.ab.b()) && (!this.ab.v()))
        f(true);
      this.t.setVisibility(0);
      b(true);
      this.U.enable();
    }
  }

  public void d(boolean paramBoolean)
  {
    e(paramBoolean);
  }

  public MediaUtil.Orientation k()
  {
    MediaUtil.Orientation localOrientation;
    if (this.X.e())
      localOrientation = MediaUtil.Orientation.LANDSCAPE;
    while (true)
    {
      return localOrientation;
      int i = getRequestedOrientation();
      if (i == 1)
      {
        localOrientation = MediaUtil.Orientation.PORTRAIT;
        continue;
      }
      if (i == 0)
      {
        localOrientation = MediaUtil.Orientation.LANDSCAPE;
        continue;
      }
      if (i == 9)
      {
        localOrientation = MediaUtil.Orientation.REVERSE_PORTRAIT;
        continue;
      }
      Display localDisplay = getWindowManager().getDefaultDisplay();
      if (localDisplay.getWidth() <= localDisplay.getHeight());
      int k;
      for (int j = 1; ; j = 0)
      {
        k = getWindowManager().getDefaultDisplay().getRotation();
        if (k != 0)
          break label129;
        if (j == 0)
          break label121;
        localOrientation = MediaUtil.Orientation.PORTRAIT;
        break;
      }
      label121: localOrientation = MediaUtil.Orientation.LANDSCAPE;
      continue;
      label129: if (k == 1)
      {
        if (j != 0)
        {
          localOrientation = MediaUtil.Orientation.PORTRAIT;
          continue;
        }
        localOrientation = MediaUtil.Orientation.LANDSCAPE;
        continue;
      }
      if (k == 3)
      {
        if (j != 0)
        {
          localOrientation = MediaUtil.Orientation.PORTRAIT;
          continue;
        }
        localOrientation = MediaUtil.Orientation.REVERSE_LANDSCAPE;
        continue;
      }
      if (k == 2)
      {
        if (j != 0)
        {
          localOrientation = MediaUtil.Orientation.PORTRAIT;
          continue;
        }
        localOrientation = MediaUtil.Orientation.REVERSE_LANDSCAPE;
        continue;
      }
      if (j != 0)
      {
        localOrientation = MediaUtil.Orientation.PORTRAIT;
        continue;
      }
      localOrientation = MediaUtil.Orientation.LANDSCAPE;
    }
  }

  public void l()
  {
    e(false);
    f(false);
    this.t.setVisibility(4);
    if (this.p != null)
    {
      this.q.removeView(this.p);
      this.p = null;
    }
    b(false);
  }

  public void m()
  {
    b(false);
  }

  public void n()
  {
    b(false);
  }

  public RotateLayout o()
  {
    return this.t;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    t();
    this.ad = false;
    if (paramInt1 == 1338)
    {
      this.ad = true;
      switch (paramInt2)
      {
      default:
      case 4:
      case 3:
      case 2:
      case 1:
      case 0:
      }
    }
    while (true)
    {
      return;
      A();
      continue;
      B();
      continue;
      d(1);
      continue;
      d(2);
      continue;
      finish();
      continue;
      if (paramInt1 == 1336)
        setResult(5);
      if (paramInt2 == 0)
        continue;
      if (paramInt1 == 1337)
      {
        this.ad = true;
        setResult(paramInt2, paramIntent);
        finish();
        continue;
      }
      if (paramInt1 == 1334)
      {
        if (paramInt2 == 4)
          continue;
        this.ad = true;
        setResult(paramInt2, paramIntent);
        finish();
        continue;
      }
      if (paramInt1 == 1335)
      {
        this.ad = true;
        String str1 = getContentResolver().getType(paramIntent.getData());
        if (str1 == null)
        {
          this.ad = false;
          continue;
        }
        Uri localUri2;
        int j;
        label278: Object localObject;
        int i;
        if (str1.startsWith("image/"))
        {
          this.V.a(paramIntent.getData());
          String str3 = this.T.a(paramIntent.getData(), getContentResolver());
          if (str3 != null)
          {
            localUri2 = Uri.parse("file://" + str3);
            j = 0;
            localObject = localUri2;
            i = 1;
          }
        }
        while (true)
        {
          if (j == 0)
            break label451;
          this.ad = false;
          Toast.makeText(this, 2131361988, 1).show();
          break;
          j = 1;
          localUri2 = null;
          break label278;
          if (str1.startsWith("video/"))
          {
            this.V.b(paramIntent.getData());
            String str2 = this.T.b(paramIntent.getData(), getContentResolver());
            Uri localUri1;
            if (str2 != null)
            {
              localUri1 = Uri.parse("file://" + str2);
              j = 0;
            }
            while (true)
            {
              localObject = localUri1;
              i = 2;
              break;
              j = 1;
              localUri1 = null;
            }
          }
          ErrorReporting.a("CameraActivity", "unknown content type:" + str1);
          i = -1;
          j = 0;
          localObject = null;
        }
        label451: if ((localObject == null) || (i == -1))
        {
          this.ad = false;
          Toast.makeText(this, 2131361989, 1).show();
          continue;
        }
        Log.e(o, "URI: " + ((Uri)localObject).toString());
        a((Uri)localObject, i);
        continue;
      }
      if (paramInt1 == 1336)
      {
        this.ad = true;
        c(paramIntent.getData());
        continue;
      }
      if (paramInt1 == 1339)
      {
        this.ad = true;
        if (this.J)
        {
          Intent localIntent = new Intent();
          localIntent.setData(this.ac);
          setResult(1, localIntent);
          finish();
          continue;
        }
        a(this.ac, 1);
        continue;
      }
      if (paramInt1 != 1340)
        continue;
      this.ad = true;
      setResult(paramInt2, paramIntent);
      finish();
    }
  }

  public void onBackPressed()
  {
    if (this.ab.v())
    {
      this.ab.h();
      g(false);
    }
    if (!E())
      super.onBackPressed();
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default:
    case 84:
    }
    for (boolean bool = super.onKeyDown(paramInt, paramKeyEvent); ; bool = true)
      return bool;
  }

  protected void onPause()
  {
    this.U.disable();
    this.ab.l();
    super.onPause();
    this.S.release();
  }

  protected void onResume()
  {
    super.onResume();
    if (this.ad)
      Log.e(o, "blocked onResume() since activity is redirecting");
    while (true)
    {
      this.S.acquire(180000L);
      return;
      if (!this.X.a())
      {
        v();
        continue;
      }
      this.ab.j();
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.V.a(paramBundle);
  }

  public boolean onSearchRequested()
  {
    return false;
  }

  protected void onStop()
  {
    super.onStop();
    SharedPreferences.Editor localEditor = getPreferences(0).edit();
    this.ab.a(localEditor);
    localEditor.commit();
    this.V.b();
  }

  public void onUserInteraction()
  {
    super.onUserInteraction();
    this.S.acquire(180000L);
  }

  public FaceDetectionIndicatorView p()
  {
    return this.G;
  }

  public int q()
  {
    return this.P;
  }

  public MediaUtil.Orientation r()
  {
    if (this.Z == MediaUtil.Orientation.UNINITIALIZED);
    for (MediaUtil.Orientation localOrientation = this.aa; ; localOrientation = this.Z)
      return localOrientation;
  }

  public MediaUtil.Orientation s()
  {
    return this.aa;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.activity.CameraActivity
 * JD-Core Version:    0.6.0
 */