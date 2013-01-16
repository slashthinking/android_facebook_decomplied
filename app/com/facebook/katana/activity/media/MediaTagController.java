package com.facebook.katana.activity.media;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.Pair;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.common.util.Log;
import com.facebook.facedetection.Tracker;
import com.facebook.katana.activity.media.detection.DetectFacesTaskManager;
import com.facebook.katana.activity.media.detection.PhotoDetectionData;
import com.facebook.katana.model.FacebookPhotoTag;
import com.facebook.katana.model.FacebookTagLabel;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.model.MediaItem.MediaType;
import com.facebook.katana.model.PhotoItem;
import com.facebook.katana.provider.DetectedPhotoProvider;
import com.facebook.katana.provider.LocalFaceboxProvider;
import com.facebook.katana.provider.LocalPhotoTagProvider;
import com.facebook.katana.provider.VaultImageProvider;
import com.facebook.katana.ui.ImageViewTouchBase;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.SharedPrefKeys;
import com.facebook.photos.analytics.PhotoFlowLogger;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.json.JSONObject;

public class MediaTagController
{
  private static final Class<?> a = MediaTagController.class;
  private static final Map<String, PhotoDetectionData> i = Maps.a();
  private final MediaTagController.FacebookTagLabelSet b = new MediaTagController.FacebookTagLabelSet(this, null);
  private final Map<FacebookPhotoTag, ViewGroup> c = Maps.a();
  private final Map<View, FacebookPhotoTag> d = Maps.a();
  private final MediaTagController.FaceboxesLabelSet e = new MediaTagController.FaceboxesLabelSet(this, null);
  private final Map<Facebox, ViewGroup> f = Maps.a();
  private final Map<View, Facebox> g = Maps.a();
  private final Map<Facebox, View> h = Maps.a();
  private final DetectFacesTaskManager j;
  private Context k;
  private View l;
  private LayoutInflater m;
  private MediaPickerGalleryAdapter n;
  private Tracker o;
  private FrameLayout p;
  private PhotoItem q = null;
  private String r = null;
  private PhotoItem s = null;
  private PhotoItem t = null;
  private boolean u;
  private MediaTagController.FaceboxClickedListener v;
  private PhotoFlowLogger w;

  public MediaTagController(Context paramContext, View paramView, LayoutInflater paramLayoutInflater, MediaPickerGalleryAdapter paramMediaPickerGalleryAdapter, Tracker paramTracker)
  {
    this.k = paramContext;
    this.l = paramView;
    this.m = paramLayoutInflater;
    this.n = paramMediaPickerGalleryAdapter;
    this.o = paramTracker;
    this.j = new DetectFacesTaskManager(this);
    this.w = null;
    this.u = ((OrcaSharedPreferences)FbInjector.a(paramContext).a(OrcaSharedPreferences.class)).a(SharedPrefKeys.x, false);
  }

  public static ContentValues a(MediaItem paramMediaItem, FacebookPhotoTag paramFacebookPhotoTag)
  {
    String str = a(paramMediaItem);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("tagged_id", Long.valueOf(paramFacebookPhotoTag.a()));
    localContentValues.put("x_pos", Double.valueOf(paramFacebookPhotoTag.c()));
    localContentValues.put("y_pos", Double.valueOf(paramFacebookPhotoTag.d()));
    localContentValues.put("created", Long.valueOf(paramFacebookPhotoTag.e()));
    localContentValues.put("text", paramFacebookPhotoTag.f());
    localContentValues.put("image_hash", str);
    return localContentValues;
  }

  private FrameLayout.LayoutParams a(ImageViewTouchBase paramImageViewTouchBase, String paramString, ViewGroup paramViewGroup, float[] paramArrayOfFloat)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 0);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131296472);
    Resources localResources = this.k.getResources();
    float f1 = localTextView.getPaint().measureText(paramString) + localResources.getDimensionPixelOffset(2131230962) + localResources.getDimensionPixelOffset(2131230963) + localResources.getDimensionPixelOffset(2131230964) + localResources.getDimensionPixelSize(2131230958);
    float f2 = localTextView.getPaint().ascent() + localTextView.getPaint().descent() + 2 * localResources.getDimensionPixelOffset(2131230961) + localResources.getDimensionPixelSize(2131230959);
    localLayoutParams.leftMargin = (int)(paramArrayOfFloat[0] - f1 / 2.0F);
    if (localLayoutParams.leftMargin < localResources.getDimensionPixelOffset(2131230962))
      localLayoutParams.leftMargin = localResources.getDimensionPixelOffset(2131230962);
    Rect localRect = new Rect();
    Point localPoint = new Point();
    paramImageViewTouchBase.getGlobalVisibleRect(localRect, localPoint);
    if ((localPoint != null) && ((localRect.left < 0) || (localRect.right > paramImageViewTouchBase.getWidth())))
      localRect.offset(-localPoint.x, -localPoint.y);
    int i1 = localLayoutParams.leftMargin + (int)f1 - paramImageViewTouchBase.getWidth() - localRect.left;
    if (i1 >= 0)
      localLayoutParams.leftMargin -= i1 + localResources.getDimensionPixelOffset(2131230964);
    localLayoutParams.rightMargin = (int)(((Activity)this.k).getWindowManager().getDefaultDisplay().getWidth() - localLayoutParams.leftMargin - f1);
    localLayoutParams.topMargin = (int)(paramArrayOfFloat[1] - f2 / 2.0F + localResources.getDimensionPixelSize(2131230812) / 2);
    int i2 = localLayoutParams.topMargin + (int)f2 - paramImageViewTouchBase.getHeight();
    if (i2 >= 0)
      localLayoutParams.topMargin -= 17 + (i2 + localResources.getDimensionPixelOffset(2131230961));
    return localLayoutParams;
  }

  public static String a(MediaItem paramMediaItem)
  {
    return VaultImageProvider.a(paramMediaItem.c(), paramMediaItem.d());
  }

  public static Map<String, PhotoDetectionData> a()
  {
    return i;
  }

  private void a(View paramView)
  {
    a((Facebox)this.g.get(paramView));
    j();
  }

  private void a(Facebox paramFacebox)
  {
    this.e.b(paramFacebox);
    b(paramFacebox);
    paramFacebox.a(a(this.q), this.k);
  }

  public static boolean a(Context paramContext, MediaItem paramMediaItem, long paramLong)
  {
    int i1 = 1;
    if ((paramContext == null) || (paramMediaItem == null) || (paramMediaItem.e() != MediaItem.MediaType.PHOTO))
      i1 = 0;
    while (true)
    {
      return i1;
      String str1 = a(paramMediaItem);
      PhotoItem localPhotoItem = (PhotoItem)paramMediaItem;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = "image_hash";
      arrayOfObject[i1] = "tagged_id";
      String str2 = StringLocaleUtil.a("%s = ? AND %s = ?", arrayOfObject);
      String[] arrayOfString = new String[2];
      arrayOfString[0] = str1;
      arrayOfString[i1] = (paramLong + "");
      paramContext.getContentResolver().delete(LocalPhotoTagProvider.a, str2, arrayOfString);
      localPhotoItem.k().a(paramLong);
    }
  }

  public static boolean a(Context paramContext, MediaItem paramMediaItem, FacebookPhotoTag paramFacebookPhotoTag)
  {
    int i1 = 1;
    if ((paramContext == null) || (paramMediaItem == null) || (paramFacebookPhotoTag == null) || (paramMediaItem.e() != MediaItem.MediaType.PHOTO))
      i1 = 0;
    while (true)
    {
      return i1;
      String str1 = a(paramMediaItem);
      PhotoItem localPhotoItem = (PhotoItem)paramMediaItem;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = "image_hash";
      arrayOfObject[i1] = "x_pos";
      arrayOfObject[2] = "y_pos";
      String str2 = StringLocaleUtil.a("%s = ? AND %s = ? AND %s = ?", arrayOfObject);
      String[] arrayOfString = new String[3];
      arrayOfString[0] = str1;
      arrayOfString[i1] = (paramFacebookPhotoTag.c() + "");
      arrayOfString[2] = (paramFacebookPhotoTag.d() + "");
      paramContext.getContentResolver().delete(LocalPhotoTagProvider.a, str2, arrayOfString);
      localPhotoItem.k().b(paramFacebookPhotoTag);
    }
  }

  private static boolean a(Context paramContext, MediaItem paramMediaItem, FacebookPhotoTag paramFacebookPhotoTag, double paramDouble1, double paramDouble2, ContentValues paramContentValues)
  {
    int i1 = 1;
    if ((paramContext == null) || (paramMediaItem == null) || (paramFacebookPhotoTag == null) || (paramMediaItem.e() != MediaItem.MediaType.PHOTO))
      i1 = 0;
    while (true)
    {
      return i1;
      String str1 = a(paramMediaItem);
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = "image_hash";
      arrayOfObject[i1] = "x_pos";
      arrayOfObject[2] = "y_pos";
      String str2 = StringLocaleUtil.a("%s = ? AND %s = ? AND %s = ?", arrayOfObject);
      String[] arrayOfString = new String[3];
      arrayOfString[0] = str1;
      arrayOfString[i1] = String.valueOf(paramDouble1);
      arrayOfString[2] = String.valueOf(paramDouble2);
      paramContext.getContentResolver().update(LocalPhotoTagProvider.a, paramContentValues, str2, arrayOfString);
    }
  }

  public static boolean a(Context paramContext, MediaItem paramMediaItem, FacebookPhotoTag paramFacebookPhotoTag, PointF paramPointF)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("x_pos", Double.valueOf(paramPointF.x));
    localContentValues.put("y_pos", Double.valueOf(paramPointF.y));
    boolean bool = a(paramContext, paramMediaItem, paramFacebookPhotoTag, paramFacebookPhotoTag.c(), paramFacebookPhotoTag.d(), localContentValues);
    ((PhotoItem)paramMediaItem).k().a(paramFacebookPhotoTag, paramPointF);
    return bool;
  }

  private void b(View paramView)
  {
    FacebookPhotoTag localFacebookPhotoTag = (FacebookPhotoTag)this.d.get(paramView);
    this.b.b(localFacebookPhotoTag);
    String str2;
    if (localFacebookPhotoTag.a() > 0L)
      if (!a(this.k, this.q, localFacebookPhotoTag.a()))
      {
        if (localFacebookPhotoTag != null)
          break label104;
        str2 = "NULL tag";
        Log.a(a, "Error removing persistent tag by uid: " + str2);
      }
    label104: 
    do
    {
      n().removeView((View)paramView.getParent());
      i();
      return;
      str2 = localFacebookPhotoTag.i().toString();
      break;
    }
    while (a(this.k, this.q, localFacebookPhotoTag));
    if (localFacebookPhotoTag == null);
    for (String str1 = "NULL tag"; ; str1 = localFacebookPhotoTag.i().toString())
    {
      Log.a(a, "Error removing persistent tag: " + str1);
      break;
    }
  }

  private void b(Facebox paramFacebox)
  {
    this.f.remove(paramFacebox);
    this.e.b(paramFacebox);
    String str = a(this.q);
    PhotoDetectionData localPhotoDetectionData = (PhotoDetectionData)i.get(str);
    localPhotoDetectionData.a(paramFacebox);
    i.put(str, localPhotoDetectionData);
  }

  private void c(Facebox paramFacebox)
  {
    if (this.v != null)
      this.v.a(paramFacebox.a());
  }

  private FrameLayout n()
  {
    if (this.p == null)
      this.p = ((FrameLayout)this.l.findViewById(2131296475));
    return this.p;
  }

  private void o()
  {
    a(this.b);
  }

  private void p()
  {
    a(this.e);
  }

  private void q()
  {
    this.e.a();
    this.e.k();
    i.remove(a(this.q));
    String str = StringLocaleUtil.a("%s = ?", new Object[] { "image_hash" });
    String[] arrayOfString = new String[1];
    arrayOfString[0] = a(this.q);
    this.k.getContentResolver().delete(LocalFaceboxProvider.a, str, arrayOfString);
    this.k.getContentResolver().delete(DetectedPhotoProvider.a, str, arrayOfString);
  }

  private void r()
  {
    if (this.v != null)
      this.v.a();
  }

  public void a(PointF paramPointF)
  {
    Facebox localFacebox = this.e.a(paramPointF);
    if (localFacebox != null)
      a(localFacebox);
  }

  public void a(Pair<MediaItem, MediaItem> paramPair)
  {
    MediaItem localMediaItem1 = (MediaItem)paramPair.first;
    MediaItem localMediaItem2 = (MediaItem)paramPair.second;
    PhotoItem localPhotoItem1;
    if ((localMediaItem1 != null) && (localMediaItem1.e() == MediaItem.MediaType.PHOTO))
    {
      localPhotoItem1 = (PhotoItem)localMediaItem1;
      this.t = localPhotoItem1;
      if ((localMediaItem2 == null) || (localMediaItem2.e() != MediaItem.MediaType.PHOTO))
        break label75;
    }
    label75: for (PhotoItem localPhotoItem2 = (PhotoItem)localMediaItem2; ; localPhotoItem2 = null)
    {
      this.s = localPhotoItem2;
      return;
      localPhotoItem1 = null;
      break;
    }
  }

  public void a(FacebookPhotoTagSet paramFacebookPhotoTagSet)
  {
    o();
    this.b.a(paramFacebookPhotoTagSet);
    if (this.n == null);
    while (true)
    {
      return;
      if (this.q.e() == MediaItem.MediaType.PHOTO)
      {
        p();
        ArrayList localArrayList = Lists.a();
        localArrayList.add(this.q);
        if (this.s != null)
          localArrayList.add(this.s);
        if (this.t != null)
          localArrayList.add(this.t);
        this.j.a(localArrayList);
        continue;
      }
    }
  }

  public void a(MediaTagController.FaceboxClickedListener paramFaceboxClickedListener)
  {
    this.v = paramFaceboxClickedListener;
  }

  public void a(MediaTagController.LabelSet paramLabelSet)
  {
    ListIterator localListIterator = paramLabelSet.f();
    while (localListIterator.hasNext())
    {
      FacebookTagLabel localFacebookTagLabel = (FacebookTagLabel)localListIterator.next();
      localListIterator.remove();
      paramLabelSet.a(localFacebookTagLabel);
    }
    paramLabelSet.k();
  }

  public void a(FacebookPhotoTag paramFacebookPhotoTag)
  {
    this.b.a(paramFacebookPhotoTag);
  }

  public void a(PhotoItem paramPhotoItem)
  {
    this.q = paramPhotoItem;
    this.r = a(this.q);
  }

  public boolean a(long paramLong)
  {
    if (paramLong <= 0L);
    for (boolean bool = false; ; bool = this.b.b(paramLong))
      return bool;
  }

  public Tracker b()
  {
    return this.o;
  }

  public void b(MediaTagController.LabelSet paramLabelSet)
  {
    if ((this.l == null) || (this.n == null) || (this.n.f() == null));
    while (true)
    {
      return;
      ImageViewTouchBase localImageViewTouchBase = this.n.f().getImageView();
      if (localImageViewTouchBase == null)
        continue;
      Rect localRect = new Rect();
      Point localPoint = new Point();
      localImageViewTouchBase.getGlobalVisibleRect(localRect, localPoint);
      if ((localPoint != null) && ((localRect.left < 0) || (localRect.right > localImageViewTouchBase.getWidth())))
        localRect.offset(-localPoint.x, -localPoint.y);
      RectF localRectF1 = localImageViewTouchBase.getDisplayedImageRect();
      if (localRectF1 == null)
        continue;
      float f1 = localRectF1.right - localRectF1.left;
      float f2 = localRectF1.bottom - localRectF1.top;
      RectF localRectF2 = new RectF(localRectF1.left + localRect.left, localRectF1.top + localRect.top, f1 + (localRectF1.left + localRect.left), f2 + (localRectF1.top + localRect.top));
      if ((paramLabelSet instanceof MediaTagController.FaceboxesLabelSet))
        ((MediaTagController.FaceboxesLabelSet)paramLabelSet).b();
      Iterator localIterator = paramLabelSet.iterator();
      while (localIterator.hasNext())
      {
        FacebookTagLabel localFacebookTagLabel = (FacebookTagLabel)localIterator.next();
        String str = localFacebookTagLabel.a(this.k);
        float[] arrayOfFloat = localFacebookTagLabel.a(localRectF2);
        ViewGroup localViewGroup1 = (ViewGroup)paramLabelSet.g().get(localFacebookTagLabel);
        if (localViewGroup1 == null)
        {
          ViewGroup localViewGroup2 = (ViewGroup)this.m.inflate(2130903536, null);
          localViewGroup2.setBackgroundResource(paramLabelSet.j());
          paramLabelSet.g().put(localFacebookTagLabel, localViewGroup2);
          TextView localTextView = (TextView)localViewGroup2.findViewById(2131296472);
          localTextView.setText(str);
          localTextView.setOnClickListener(paramLabelSet.b(localFacebookTagLabel));
          View localView1 = localViewGroup2.findViewById(2131297803);
          paramLabelSet.h().put(localView1, localFacebookTagLabel);
          localView1.setOnClickListener(paramLabelSet.i());
          n().addView(localViewGroup2, a(localImageViewTouchBase, str, localViewGroup2, arrayOfFloat));
          if ((!(localFacebookTagLabel instanceof Facebox)) || (!this.u))
            continue;
          View localView2 = ((Facebox)localFacebookTagLabel).a(localRectF1, this.k);
          n().addView(localView2);
          this.h.put((Facebox)localFacebookTagLabel, localView2);
          continue;
        }
        localViewGroup1.setLayoutParams(a(localImageViewTouchBase, str, localViewGroup1, arrayOfFloat));
        localViewGroup1.requestLayout();
      }
    }
  }

  public boolean b(PointF paramPointF)
  {
    Facebox localFacebox = this.e.b(paramPointF);
    if (localFacebox != null)
      c(localFacebox);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public Context c()
  {
    return this.k;
  }

  public int d()
  {
    MediaTagController.FacebookTagLabelSet localFacebookTagLabelSet = this.b;
    int i1 = 0;
    if (localFacebookTagLabelSet == null)
      return i1;
    Iterator localIterator = this.b.iterator();
    int i2 = 0;
    label24: if (localIterator.hasNext())
    {
      long l1 = ((FacebookPhotoTag)localIterator.next()).a();
      if ((l1 != -1L) && (l1 < 0L))
        break label82;
    }
    label82: for (int i3 = i2 + 1; ; i3 = i2)
    {
      i2 = i3;
      break label24;
      i1 = i2;
      break;
    }
  }

  public void e()
  {
    o();
    p();
  }

  public FacebookPhotoTag[] f()
  {
    FacebookPhotoTag[] arrayOfFacebookPhotoTag = new FacebookPhotoTag[this.b.a()];
    return (FacebookPhotoTag[])this.b.b().toArray(arrayOfFacebookPhotoTag);
  }

  public FacebookPhotoTagSet g()
  {
    return this.b;
  }

  public void h()
  {
    this.q = null;
    this.r = null;
  }

  public void i()
  {
    b(this.b);
  }

  public void j()
  {
    b(this.e);
  }

  public void k()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      FacebookPhotoTag localFacebookPhotoTag = (FacebookPhotoTag)localIterator.next();
      float f1 = (float)localFacebookPhotoTag.d();
      float f2 = 100.0F - (float)localFacebookPhotoTag.c();
      a(this.k, this.q, localFacebookPhotoTag, new PointF(f1, f2));
      localFacebookPhotoTag.b(f1);
      localFacebookPhotoTag.a(f2);
    }
    q();
  }

  public void l()
  {
    if (this.v != null)
      this.v.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.MediaTagController
 * JD-Core Version:    0.6.0
 */