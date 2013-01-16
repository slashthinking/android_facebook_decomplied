package com.facebook.katana.activity.media;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.facebook.analytics.AnalyticsSubModuleActivity;
import com.facebook.camera.activity.CameraActivity;
import com.facebook.common.util.Log;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.features.tagging.BaseTagTypeaheadAdapter;
import com.facebook.katana.features.tagging.GroupMembersTagTypeaheadAdapter;
import com.facebook.katana.features.tagging.TagTypeaheadAdapter;
import com.facebook.katana.model.FacebookPhotoTag;
import com.facebook.katana.ui.ListenableRelativeLayout;
import com.facebook.katana.ui.ListenableRelativeLayout.LayoutChangedListener;
import com.facebook.katana.util.ImageUtils;
import com.facebook.katana.util.ImageUtils.ImageOutOfMemoryException;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;
import com.facebook.orca.inject.FbInjector;
import com.facebook.photos.analytics.PhotoFlowLogger;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CameraReviewActivity extends BaseFacebookActivity
  implements AnalyticsSubModuleActivity, NotNewNavEnabled, ListenableRelativeLayout.LayoutChangedListener
{
  private TouchBlip A;
  private final Map<FacebookPhotoTag, ViewGroup> B = Maps.a();
  private final Map<View, FacebookPhotoTag> C = Maps.a();
  private Uri D;
  private long E;
  private String F;
  private VideoView G;
  private Button H;
  private LinearLayout I;
  private String J;
  private ListenableRelativeLayout K;
  private int L;
  private long M;
  private PhotoFlowLogger N;
  private Context n;
  private ImageView o;
  private Bitmap p;
  private LinearLayout q;
  private LinearLayout r;
  private View s;
  private ProgressBar t;
  private View u;
  private AutoCompleteTextView v;
  private final FacebookPhotoTagSet x = new FacebookPhotoTagSet();
  private PointF y;
  private boolean z;

  private TouchBlip A()
  {
    if (this.A == null)
      this.A = new TouchBlip(this, (RelativeLayout)findViewById(2131296460));
    return this.A;
  }

  public static Intent a(Context paramContext, Uri paramUri, int paramInt, boolean paramBoolean, long paramLong)
  {
    return a(paramContext, null, paramUri, paramInt, paramBoolean, paramLong);
  }

  public static Intent a(Context paramContext, Uri paramUri, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    Intent localIntent = a(paramContext, paramUri, 3, paramBoolean, paramLong1);
    localIntent.putExtra("extra_vault_fbid", paramLong2);
    return localIntent;
  }

  public static Intent a(Context paramContext, FacebookPhotoTag[] paramArrayOfFacebookPhotoTag, Uri paramUri, int paramInt, boolean paramBoolean, long paramLong)
  {
    return new Intent(paramContext, CameraReviewActivity.class).putExtra("result_tags", paramArrayOfFacebookPhotoTag).putExtra("mediaContentType", paramInt).putExtra("extra_no_composer", paramBoolean).setData(paramUri).putExtra("extra_target_id", paramLong);
  }

  private FrameLayout.LayoutParams a(String paramString, ViewGroup paramViewGroup, float[] paramArrayOfFloat)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 0);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131296472);
    Resources localResources = getResources();
    float f1 = localTextView.getPaint().measureText(paramString) + localResources.getDimensionPixelOffset(2131230962) + localResources.getDimensionPixelOffset(2131230963) + localResources.getDimensionPixelOffset(2131230964) + localResources.getDimensionPixelSize(2131230958);
    float f2 = localTextView.getPaint().ascent() + localTextView.getPaint().descent() + 2 * localResources.getDimensionPixelOffset(2131230961) + localResources.getDimensionPixelSize(2131230959);
    localLayoutParams.leftMargin = (int)(paramArrayOfFloat[0] - f1 / 2.0F);
    if (localLayoutParams.leftMargin < localResources.getDimensionPixelOffset(2131230962))
      localLayoutParams.leftMargin = localResources.getDimensionPixelOffset(2131230962);
    Rect localRect = new Rect();
    this.o.getGlobalVisibleRect(localRect);
    int i = localLayoutParams.leftMargin + (int)f1 - this.o.getWidth() - localRect.left;
    if (i >= 0)
      localLayoutParams.leftMargin -= i + localResources.getDimensionPixelOffset(2131230964);
    localLayoutParams.rightMargin = (int)(getWindowManager().getDefaultDisplay().getWidth() - localLayoutParams.leftMargin - f1);
    localLayoutParams.topMargin = (int)(paramArrayOfFloat[1] - f2 / 2.0F + localResources.getDimensionPixelSize(2131230812) / 2);
    return localLayoutParams;
  }

  private void a(Intent paramIntent)
  {
    Parcelable[] arrayOfParcelable = paramIntent.getParcelableArrayExtra("result_tags");
    if ((arrayOfParcelable != null) && (arrayOfParcelable.length > 0))
    {
      int i = arrayOfParcelable.length;
      for (int j = 0; j < i; j++)
      {
        FacebookPhotoTag localFacebookPhotoTag = (FacebookPhotoTag)arrayOfParcelable[j];
        this.x.a(localFacebookPhotoTag);
      }
    }
  }

  private void a(CameraReviewActivity.RetainedData paramRetainedData)
  {
    this.x.a(CameraReviewActivity.RetainedData.a(paramRetainedData));
    this.y = CameraReviewActivity.RetainedData.b(paramRetainedData);
  }

  private void j()
  {
    this.q = ((LinearLayout)findViewById(2131296467));
    this.r = ((LinearLayout)findViewById(2131296469));
    this.H = ((Button)findViewById(2131296465));
    this.o = ((ImageView)findViewById(2131296463));
    this.G = ((VideoView)findViewById(2131296464));
    this.I = ((LinearLayout)findViewById(2131296466));
    this.v = ((AutoCompleteTextView)findViewById(2131296472));
    this.s = findViewById(2131296461);
    this.t = ((ProgressBar)findViewById(2131296462));
    this.u = findViewById(2131296471);
    this.K = ((ListenableRelativeLayout)findViewById(2131296460));
  }

  private void k()
  {
    if (this.y != null)
    {
      TouchBlip localTouchBlip = A();
      Rect localRect = new Rect();
      this.o.getGlobalVisibleRect(localRect);
      new RectF(localRect);
      Matrix localMatrix = this.o.getImageMatrix();
      float[] arrayOfFloat = { 0.0F, 0.0F };
      localMatrix.mapPoints(arrayOfFloat);
      float f1 = this.o.getWidth() - 2.0F * arrayOfFloat[0];
      float f2 = this.o.getHeight() - 2.0F * arrayOfFloat[1];
      RectF localRectF = new RectF(arrayOfFloat[0] + localRect.left, arrayOfFloat[1] + localRect.top, f1 + (arrayOfFloat[0] + localRect.left), f2 + (arrayOfFloat[1] + localRect.top));
      localTouchBlip.a(this.y, localRectF);
    }
  }

  private void l()
  {
    Intent localIntent = new Intent();
    FacebookPhotoTag[] arrayOfFacebookPhotoTag = new FacebookPhotoTag[this.x.a()];
    localIntent.putExtra("result_tags", (FacebookPhotoTag[])this.x.b().toArray(arrayOfFacebookPhotoTag));
    localIntent.putExtra("camera_session_id", this.J);
    if (this.z)
    {
      localIntent.setData(n());
      setResult(this.L, localIntent);
      finish();
      return;
    }
    Bundle localBundle = getIntent().getBundleExtra("composer_extras");
    if (localBundle != null)
      localIntent.putExtras(localBundle);
    if (this.L == 2)
      localIntent.putExtra("extra_video_request_code", this.L);
    while (true)
    {
      if ("group".equals(this.F))
      {
        localIntent.putExtra("publisher_type", "group");
        localIntent.putExtra("target_id", this.E);
      }
      a(n(), localIntent.getExtras(), Integer.valueOf(1337), this.E);
      break;
      localIntent.putExtra("extra_photo_request_code", this.L);
      if (!m())
        continue;
      localIntent.putExtra("vault_image_fbid", this.M);
      int i = getResources().getDimensionPixelSize(2131230909);
      try
      {
        localIntent.putExtra("vault_preview_bytes", ImageUtils.a(this.p, i));
      }
      catch (ImageUtils.ImageOutOfMemoryException localImageOutOfMemoryException)
      {
        Log.a("Ran out of memory resizing bitmap!");
      }
    }
  }

  private boolean m()
  {
    if ((this.L == 3) && (this.M > 0L));
    for (int i = 1; ; i = 0)
      return i;
  }

  private Uri n()
  {
    if (this.D != null);
    for (Uri localUri = this.D; ; localUri = this.D)
    {
      return localUri;
      this.D = CameraActivity.j();
    }
  }

  private void o()
  {
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131296475);
    ImageView localImageView = this.o;
    if ((this.x == null) || (localImageView == null) || (this.x.a() == 0) || (localImageView.getDrawable() == null));
    while (true)
    {
      return;
      LayoutInflater localLayoutInflater = LayoutInflater.from(this);
      Rect localRect = new Rect();
      float[] arrayOfFloat1 = { 0.0F, 0.0F };
      localImageView.getGlobalVisibleRect(localRect);
      this.o.getImageMatrix().mapPoints(arrayOfFloat1);
      int i = (int)(localImageView.getWidth() - 2.0F * arrayOfFloat1[0]);
      int j = (int)(localImageView.getHeight() - 2.0F * arrayOfFloat1[1]);
      Iterator localIterator = this.x.iterator();
      while (localIterator.hasNext())
      {
        FacebookPhotoTag localFacebookPhotoTag = (FacebookPhotoTag)localIterator.next();
        float[] arrayOfFloat2 = new float[2];
        arrayOfFloat2[0] = ((float)localFacebookPhotoTag.c() / 100.0F * i + localRect.left + arrayOfFloat1[0]);
        arrayOfFloat2[1] = ((float)localFacebookPhotoTag.d() / 100.0F * j + localRect.top + arrayOfFloat1[1]);
        ViewGroup localViewGroup1 = (ViewGroup)this.B.get(localFacebookPhotoTag);
        if (localViewGroup1 == null)
        {
          ViewGroup localViewGroup2 = (ViewGroup)localLayoutInflater.inflate(2130903536, null);
          this.B.put(localFacebookPhotoTag, localViewGroup2);
          ((TextView)localViewGroup2.findViewById(2131296472)).setText(localFacebookPhotoTag.f());
          View localView = localViewGroup2.findViewById(2131297803);
          this.C.put(localView, localFacebookPhotoTag);
          localView.setOnClickListener(new CameraReviewActivity.8(this, localFrameLayout));
          localFrameLayout.addView(localViewGroup2, a(localFacebookPhotoTag.f(), localViewGroup2, arrayOfFloat2));
          continue;
        }
        localViewGroup1.setLayoutParams(a(localFacebookPhotoTag.f(), localViewGroup1, arrayOfFloat2));
        localViewGroup1.requestLayout();
      }
    }
  }

  private void p()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager != null)
      localInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
  }

  private void q()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager != null)
      localInputMethodManager.showSoftInput(this.v, 2);
  }

  // ERROR //
  private void r()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 373	com/facebook/katana/activity/media/CameraReviewActivity:L	I
    //   4: iconst_3
    //   5: if_icmpne +35 -> 40
    //   8: new 579	com/facebook/katana/activity/media/CameraReviewActivity$LoadPhotoFromUrlTask
    //   11: dup
    //   12: aload_0
    //   13: aconst_null
    //   14: invokespecial 582	com/facebook/katana/activity/media/CameraReviewActivity$LoadPhotoFromUrlTask:<init>	(Lcom/facebook/katana/activity/media/CameraReviewActivity;Lcom/facebook/katana/activity/media/CameraReviewActivity$1;)V
    //   17: astore_1
    //   18: iconst_1
    //   19: anewarray 402	java/lang/String
    //   22: astore_2
    //   23: aload_2
    //   24: iconst_0
    //   25: aload_0
    //   26: getfield 458	com/facebook/katana/activity/media/CameraReviewActivity:D	Landroid/net/Uri;
    //   29: invokevirtual 587	android/net/Uri:toString	()Ljava/lang/String;
    //   32: aastore
    //   33: aload_1
    //   34: aload_2
    //   35: invokevirtual 591	com/facebook/katana/activity/media/CameraReviewActivity$LoadPhotoFromUrlTask:execute	([Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   38: pop
    //   39: return
    //   40: aload_0
    //   41: getfield 458	com/facebook/katana/activity/media/CameraReviewActivity:D	Landroid/net/Uri;
    //   44: ifnull +92 -> 136
    //   47: aload_0
    //   48: aload_0
    //   49: aload_0
    //   50: getfield 458	com/facebook/katana/activity/media/CameraReviewActivity:D	Landroid/net/Uri;
    //   53: iconst_1
    //   54: invokestatic 594	com/facebook/katana/util/ImageUtils:a	(Landroid/content/Context;Landroid/net/Uri;Z)Landroid/graphics/Bitmap;
    //   57: putfield 132	com/facebook/katana/activity/media/CameraReviewActivity:p	Landroid/graphics/Bitmap;
    //   60: aload_0
    //   61: getfield 194	com/facebook/katana/activity/media/CameraReviewActivity:o	Landroid/widget/ImageView;
    //   64: aload_0
    //   65: getfield 132	com/facebook/katana/activity/media/CameraReviewActivity:p	Landroid/graphics/Bitmap;
    //   68: invokevirtual 598	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   71: aload_0
    //   72: getfield 194	com/facebook/katana/activity/media/CameraReviewActivity:o	Landroid/widget/ImageView;
    //   75: new 600	com/facebook/katana/activity/media/CameraReviewActivity$PhotoTouchListener
    //   78: dup
    //   79: aload_0
    //   80: aconst_null
    //   81: invokespecial 601	com/facebook/katana/activity/media/CameraReviewActivity$PhotoTouchListener:<init>	(Lcom/facebook/katana/activity/media/CameraReviewActivity;Lcom/facebook/katana/activity/media/CameraReviewActivity$1;)V
    //   84: invokevirtual 605	android/widget/ImageView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   87: aload_0
    //   88: getfield 301	com/facebook/katana/activity/media/CameraReviewActivity:s	Landroid/view/View;
    //   91: invokevirtual 608	android/view/View:getVisibility	()I
    //   94: ifne -55 -> 39
    //   97: aload_0
    //   98: getfield 301	com/facebook/katana/activity/media/CameraReviewActivity:s	Landroid/view/View;
    //   101: invokevirtual 611	android/view/View:bringToFront	()V
    //   104: goto -65 -> 39
    //   107: astore 5
    //   109: aload_0
    //   110: invokevirtual 613	com/facebook/katana/activity/media/CameraReviewActivity:x	()Ljava/lang/String;
    //   113: ldc_w 615
    //   116: aload 5
    //   118: invokestatic 618	com/facebook/common/util/Log:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   121: aload_0
    //   122: invokevirtual 613	com/facebook/katana/activity/media/CameraReviewActivity:x	()Ljava/lang/String;
    //   125: ldc_w 615
    //   128: aload 5
    //   130: invokestatic 621	com/facebook/common/util/ErrorReporting:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   133: goto -94 -> 39
    //   136: invokestatic 624	com/facebook/camera/activity/CameraActivity:i	()Lcom/facebook/camera/activity/CameraActivity$CameraPhotoData;
    //   139: astore 7
    //   141: aload 7
    //   143: ifnull +29 -> 172
    //   146: aload 7
    //   148: getfield 629	com/facebook/camera/activity/CameraActivity$CameraPhotoData:a	[B
    //   151: ifnull +21 -> 172
    //   154: aload_0
    //   155: aload 7
    //   157: getfield 629	com/facebook/camera/activity/CameraActivity$CameraPhotoData:a	[B
    //   160: aload 7
    //   162: getfield 631	com/facebook/camera/activity/CameraActivity$CameraPhotoData:b	I
    //   165: iconst_1
    //   166: invokestatic 634	com/facebook/katana/util/ImageUtils:a	([BIZ)Landroid/graphics/Bitmap;
    //   169: putfield 132	com/facebook/katana/activity/media/CameraReviewActivity:p	Landroid/graphics/Bitmap;
    //   172: aload_0
    //   173: getfield 132	com/facebook/katana/activity/media/CameraReviewActivity:p	Landroid/graphics/Bitmap;
    //   176: ifnonnull -116 -> 60
    //   179: aload_0
    //   180: invokespecial 371	com/facebook/katana/activity/media/CameraReviewActivity:n	()Landroid/net/Uri;
    //   183: ifnonnull +33 -> 216
    //   186: aload_0
    //   187: invokevirtual 613	com/facebook/katana/activity/media/CameraReviewActivity:x	()Ljava/lang/String;
    //   190: ldc_w 636
    //   193: invokestatic 639	com/facebook/common/util/Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: goto -157 -> 39
    //   199: astore 4
    //   201: aload_0
    //   202: invokevirtual 613	com/facebook/katana/activity/media/CameraReviewActivity:x	()Ljava/lang/String;
    //   205: ldc_w 636
    //   208: aload 4
    //   210: invokestatic 618	com/facebook/common/util/Log:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   213: goto -174 -> 39
    //   216: aload_0
    //   217: aload_0
    //   218: aload_0
    //   219: invokespecial 371	com/facebook/katana/activity/media/CameraReviewActivity:n	()Landroid/net/Uri;
    //   222: iconst_1
    //   223: invokestatic 594	com/facebook/katana/util/ImageUtils:a	(Landroid/content/Context;Landroid/net/Uri;Z)Landroid/graphics/Bitmap;
    //   226: putfield 132	com/facebook/katana/activity/media/CameraReviewActivity:p	Landroid/graphics/Bitmap;
    //   229: goto -169 -> 60
    //   232: astore 6
    //   234: goto -62 -> 172
    //
    // Exception table:
    //   from	to	target	type
    //   40	104	107	com/facebook/katana/util/ImageUtils$ImageOutOfMemoryException
    //   172	196	107	com/facebook/katana/util/ImageUtils$ImageOutOfMemoryException
    //   216	229	107	com/facebook/katana/util/ImageUtils$ImageOutOfMemoryException
    //   40	104	199	com/facebook/katana/util/ImageUtils$ImageException
    //   136	172	199	com/facebook/katana/util/ImageUtils$ImageException
    //   172	196	199	com/facebook/katana/util/ImageUtils$ImageException
    //   216	229	199	com/facebook/katana/util/ImageUtils$ImageException
    //   136	172	232	com/facebook/katana/util/ImageUtils$ImageOutOfMemoryException
  }

  private void s()
  {
    if (this.s.getVisibility() == 0)
      this.s.setVisibility(4);
  }

  private void z()
  {
    if (this.y != null)
    {
      if (this.u.getVisibility() != 0)
      {
        this.u.setVisibility(0);
        this.u.setAnimation(AnimationUtils.loadAnimation(this, 2130968581));
        this.u.requestFocus();
        this.u.bringToFront();
      }
      q();
    }
    while (true)
    {
      o();
      return;
      if (this.u.getVisibility() != 0)
        continue;
      this.u.setAnimation(AnimationUtils.loadAnimation(this, 2130968582));
      this.u.setVisibility(4);
    }
  }

  public String a()
  {
    return FB4A_AnalyticEntities.p;
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.n = getApplicationContext();
    Intent localIntent = getIntent();
    this.N = ((PhotoFlowLogger)FbInjector.a(this.n).a(PhotoFlowLogger.class));
    if (this.x.a() == 0)
      a(localIntent);
    getWindow().addFlags(1024);
    setContentView(2130903087);
    j();
    this.K.setOnLayoutChangedListener(this);
    this.D = localIntent.getData();
    this.M = localIntent.getLongExtra("extra_vault_fbid", 0L);
    this.L = localIntent.getIntExtra("mediaContentType", -1);
    if (this.L == -1)
      throw new IllegalArgumentException("CONTENT_TYPE is not set");
    this.J = localIntent.getExtras().getString("camera_session_id");
    this.N.a(this.J);
    this.N.h();
    this.z = localIntent.getBooleanExtra("extra_no_composer", false);
    this.E = localIntent.getLongExtra("extra_target_id", -1L);
    this.F = localIntent.getStringExtra("publisher_type");
    this.o.setVisibility(0);
    if (this.L == 2)
    {
      this.s.setVisibility(4);
      this.G.setVideoURI(this.D);
      this.G.setClickable(true);
      this.H.setVisibility(0);
      new CameraReviewActivity.VideoPreviewTask(this, this, this.D).execute(new Void[0]);
      this.I.setVisibility(0);
      this.I.bringToFront();
      findViewById(2131296473).setOnClickListener(new CameraReviewActivity.1(this));
      this.G.setOnCompletionListener(new CameraReviewActivity.2(this));
      this.G.setOnTouchListener(new CameraReviewActivity.3(this));
      this.H.setOnTouchListener(new CameraReviewActivity.4(this));
      this.q.setOnClickListener(new CameraReviewActivity.5(this));
      this.r.setOnClickListener(new CameraReviewActivity.6(this));
      if (!"group".equals(this.F))
        break label488;
    }
    label488: for (Object localObject = new GroupMembersTagTypeaheadAdapter(this, this.E); ; localObject = new TagTypeaheadAdapter(this))
    {
      ((BaseTagTypeaheadAdapter)localObject).a(new CameraReviewActivity.DuplicateTagFilter(this));
      this.v.setAdapter((ListAdapter)localObject);
      this.v.setDropDownAnchor(2131296474);
      this.v.setDropDownVerticalOffset(0);
      this.v.setOnItemClickListener(new CameraReviewActivity.7(this));
      return;
      if (m())
      {
        this.t.setVisibility(0);
        break;
      }
      this.s.setVisibility(0);
      break;
    }
  }

  public Object c()
  {
    return new CameraReviewActivity.RetainedData(this.x, this.y);
  }

  public void g_()
  {
    k();
    z();
  }

  public String i()
  {
    return null;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
  }

  public void onPause()
  {
    super.onPause();
    if (!isFinishing())
      n();
    if ((!m()) || (isFinishing()))
    {
      if (this.o != null)
        this.o.setImageBitmap(null);
      if (this.p != null)
      {
        this.p.recycle();
        this.p = null;
      }
    }
  }

  protected void onResume()
  {
    super.onResume();
    if (this.L == 2)
      new CameraReviewActivity.VideoPreviewTask(this, this, this.D).execute(new Void[0]);
    while (true)
    {
      return;
      if (m())
      {
        this.t.setVisibility(0);
        this.s.setVisibility(4);
      }
      r();
    }
  }

  protected void onStart()
  {
    super.onStart();
    CameraReviewActivity.RetainedData localRetainedData = (CameraReviewActivity.RetainedData)f_();
    if (localRetainedData != null)
    {
      s();
      a(localRetainedData);
      if (this.y != null)
      {
        if (this.u.getVisibility() != 0)
        {
          this.u.setVisibility(0);
          this.u.setAnimation(AnimationUtils.loadAnimation(this, 2130968581));
          this.u.requestFocus();
          this.u.bringToFront();
        }
        getWindow().setSoftInputMode(5);
        q();
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.CameraReviewActivity
 * JD-Core Version:    0.6.0
 */