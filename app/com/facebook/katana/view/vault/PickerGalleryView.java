package com.facebook.katana.view.vault;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.katana.activity.media.FacebookPhotoTagSet;
import com.facebook.katana.activity.media.MediaPickerActivity.SelectedMode;
import com.facebook.katana.activity.media.MediaPickerEnvironment;
import com.facebook.katana.activity.media.MediaPickerGalleryAdapter;
import com.facebook.katana.activity.media.PhotoPage;
import com.facebook.katana.activity.media.SelectionState;
import com.facebook.katana.activity.media.SelectionState.SelectionListener;
import com.facebook.katana.activity.media.TagTypeaheadFilters;
import com.facebook.katana.activity.media.TouchBlip;
import com.facebook.katana.features.tagging.BaseTagTypeaheadAdapter;
import com.facebook.katana.features.tagging.TagTypeaheadAdapter;
import com.facebook.katana.model.FacebookPhotoTag;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.model.MediaItem.MediaType;
import com.facebook.katana.model.PhotoItem;
import com.facebook.katana.ui.ImageViewTouchBase;
import com.facebook.katana.util.Utils;
import com.facebook.photos.analytics.PhotoFlowLogger;
import com.facebook.widget.PhotoToggleButton;
import com.facebook.widget.PhotoToggleButton.OnCheckedChangeListener;
import java.util.List;

public class PickerGalleryView extends RelativeLayout
  implements SelectionState.SelectionListener, PhotoToggleButton.OnCheckedChangeListener
{
  private final MediaPickerGalleryAdapter a;
  private PhotoToggleButton b;
  private MediaItem c;
  private ViewPager d;
  private SelectionState e;
  private Context f;
  private PhotoFlowLogger g;
  private PointF h;
  private TouchBlip i;
  private MediaPickerEnvironment j = MediaPickerEnvironment.a;
  private View k;
  private View l;
  private AutoCompleteTextView m;
  private boolean n = false;
  private boolean o = false;
  private boolean p = true;
  private GestureDetector q;
  private PickerGalleryView.PhotoTouchListener r;
  private TagTypeaheadFilters s;
  private TextView t;
  private FrameLayout u;
  private int v = -1;
  private boolean w = false;
  private Handler x;
  private final long y = 3000L;
  private final int z = 2;

  public PickerGalleryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflate(paramContext, 2130903489, this);
    this.d = ((ViewPager)findViewById(2131297398));
    this.d.setPageMargin(20);
    this.d.setOffscreenPageLimit(2);
    ViewTreeObserver localViewTreeObserver = this.d.getViewTreeObserver();
    if (localViewTreeObserver.isAlive())
      localViewTreeObserver.addOnGlobalLayoutListener(new PickerGalleryView.1(this));
    this.a = new MediaPickerGalleryAdapter(paramContext, this.d);
    this.a.a(new PickerGalleryView.PhotoLoadedListener(this, null));
    this.a.a(new PickerGalleryView.FaceboxEditHandler(this, null));
    this.b = ((PhotoToggleButton)findViewById(2131297065));
    this.b.setOnCheckedChangeListener(this);
    this.x = new Handler();
    this.m = ((AutoCompleteTextView)findViewById(2131296472));
    this.k = findViewById(2131296461);
    k();
    this.p = true;
    this.u = ((FrameLayout)findViewById(2131297674));
    this.u.setOnClickListener(new PickerGalleryView.TaggingDisableListener(this, null));
    this.l = findViewById(2131296471);
    this.f = paramContext;
    this.t = ((TextView)findViewById(2131297675));
    this.q = new GestureDetector(this.f, new PickerGalleryView.PhotoTouchGestureListener(this, null));
    this.r = new PickerGalleryView.PhotoTouchListener(this, null);
    this.g = null;
    this.s = new TagTypeaheadFilters(new PickerGalleryView.PickerTagTypeaheadAdapter(this));
    setTypeAheadAdapter(new TagTypeaheadAdapter(this.f));
    this.m.setDropDownAnchor(2131296474);
    this.m.setDropDownVerticalOffset(0);
    this.m.setOnKeyListener(new PickerGalleryView.2(this));
    this.m.setOnItemClickListener(new PickerGalleryView.3(this));
    findViewById(2131296473).setOnClickListener(new PickerGalleryView.4(this));
  }

  private void a(PickerGalleryView.RetainedData paramRetainedData)
  {
    this.a.a(PickerGalleryView.RetainedData.a(paramRetainedData));
    this.h = PickerGalleryView.RetainedData.b(paramRetainedData);
  }

  private void b(int paramInt)
  {
    Resources localResources = getResources();
    if (getMode() == MediaPickerActivity.SelectedMode.SELECTED);
    for (int i1 = 2131363239; ; i1 = 2131363238)
    {
      TextView localTextView = this.t;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(paramInt + 1);
      arrayOfObject[1] = Integer.valueOf(this.a.b());
      localTextView.setText(localResources.getString(i1, arrayOfObject));
      return;
    }
  }

  private boolean c(MediaItem paramMediaItem)
  {
    if ((!this.j.a()) && (paramMediaItem.e() == MediaItem.MediaType.PHOTO));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  private void f()
  {
    this.h = null;
    this.m.setText("");
    n();
    m();
    if (this.i != null)
      this.i.b();
    this.u.setVisibility(4);
    this.w = false;
  }

  private void g()
  {
    if (this.h != null)
    {
      float f1 = this.h.y;
      float f2 = 100.0F - this.h.x;
      this.h.x = f1;
      this.h.y = f2;
    }
  }

  private TouchBlip getBlip()
  {
    if (this.i == null)
      this.i = new TouchBlip(this.f, this);
    return this.i;
  }

  private void h()
  {
    this.a.l();
  }

  private void i()
  {
    if (this.c != null)
    {
      FacebookPhotoTagSet localFacebookPhotoTagSet = ((PhotoItem)this.c).k();
      if (localFacebookPhotoTagSet != null)
      {
        this.a.a(localFacebookPhotoTagSet);
        h();
      }
    }
    for (int i1 = 1; ; i1 = 0)
    {
      if (i1 == 0)
        this.a.i();
      return;
    }
  }

  private void j()
  {
    if (this.h != null)
    {
      TouchBlip localTouchBlip = getBlip();
      ImageViewTouchBase localImageViewTouchBase = this.a.f().getImageView();
      Rect localRect = new Rect();
      localImageViewTouchBase.getGlobalVisibleRect(localRect);
      Matrix localMatrix = localImageViewTouchBase.getImageMatrix();
      float[] arrayOfFloat = { 0.0F, 0.0F };
      localMatrix.mapPoints(arrayOfFloat);
      float f1 = localImageViewTouchBase.getWidth() - 2.0F * arrayOfFloat[0];
      float f2 = localImageViewTouchBase.getHeight() - 2.0F * arrayOfFloat[1];
      RectF localRectF = new RectF(arrayOfFloat[0] + localRect.left, arrayOfFloat[1] + localRect.top, f1 + (arrayOfFloat[0] + localRect.left), f2 + (arrayOfFloat[1] + localRect.top));
      localTouchBlip.a(this.h, localRectF);
    }
  }

  private void k()
  {
    if (this.k.getVisibility() == 0)
    {
      this.k.setVisibility(4);
      this.p = false;
    }
  }

  private void l()
  {
    if ((this.k.getVisibility() == 4) && (this.p))
    {
      this.k.setVisibility(0);
      this.x.postDelayed(new PickerGalleryView.6(this), 3000L);
    }
  }

  private void m()
  {
    if (this.h != null)
    {
      if (this.l.getVisibility() != 0)
      {
        this.l.setVisibility(0);
        this.u.setVisibility(0);
        this.l.setAnimation(AnimationUtils.loadAnimation(this.f, 2130968581));
        this.l.requestFocus();
        this.l.bringToFront();
      }
      o();
    }
    while (true)
    {
      this.a.l();
      return;
      if (this.l.getVisibility() != 0)
        continue;
      this.l.setAnimation(AnimationUtils.loadAnimation(this.f, 2130968582));
      this.l.setVisibility(4);
      this.u.setVisibility(4);
    }
  }

  private void n()
  {
    Utils.b((Activity)this.f);
  }

  private void o()
  {
    Utils.a(this.f, this.m);
  }

  private void setChecked(boolean paramBoolean)
  {
    this.b.setOnCheckedChangeListener(null);
    this.b.setChecked(paramBoolean);
    this.b.setOnCheckedChangeListener(this);
  }

  public int a(MediaItem paramMediaItem)
  {
    return this.a.b(paramMediaItem);
  }

  public void a()
  {
    this.a.m();
  }

  public void a(int paramInt)
  {
    b(paramInt);
    MediaItem localMediaItem = this.a.a(paramInt);
    if (localMediaItem != null)
    {
      this.c = localMediaItem;
      if (!c(localMediaItem))
        break label60;
      setChecked(this.e.c(localMediaItem));
      this.b.setEnabled(true);
      this.b.setVisibility(0);
    }
    while (true)
    {
      return;
      label60: this.b.setEnabled(false);
      this.b.setVisibility(8);
    }
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    if ((this.c != null) && (this.c.a() == paramLong) && (this.b.isChecked() != paramBoolean))
      setChecked(paramBoolean);
    this.a.a(paramLong, paramBoolean);
  }

  public void a(PhotoToggleButton paramPhotoToggleButton, boolean paramBoolean)
  {
    if (this.c == null);
    label277: 
    while (true)
    {
      return;
      boolean bool = this.c.g();
      if (bool);
      for (String str = Long.toString(this.c.f()); ; str = this.c.b())
      {
        if (!paramBoolean)
          break label105;
        if (this.e.a(this.c))
          break label81;
        this.e.a(getContext());
        paramPhotoToggleButton.setChecked(false);
        break;
      }
      label81: if (this.g == null)
        continue;
      this.g.a(true, bool, false, false, str);
      continue;
      label105: int i1;
      MediaItem localMediaItem;
      if (getMode() == MediaPickerActivity.SelectedMode.SELECTED)
      {
        i1 = this.a.b(this.c);
        if ((i1 == -1 + this.a.b()) && (i1 > 0))
        {
          localMediaItem = this.a.a(i1 - 1);
          label160: this.a.a(this.c);
          this.e.b(this.c);
          if (localMediaItem != null)
          {
            this.c = localMediaItem;
            b(localMediaItem);
            a(getCurrentPosition());
          }
        }
      }
      while (true)
      {
        if (this.g == null)
          break label277;
        this.g.a(false, bool, false, false, str);
        break;
        int i2 = this.a.b();
        localMediaItem = null;
        if (i2 <= 1)
          break label160;
        localMediaItem = this.a.a(i1 + 1);
        break label160;
        this.e.b(this.c);
      }
    }
  }

  public void a(Object paramObject)
  {
    PickerGalleryView.RetainedData localRetainedData = (PickerGalleryView.RetainedData)paramObject;
    if (localRetainedData != null)
    {
      k();
      a(localRetainedData);
      if (this.h != null)
      {
        if (this.l.getVisibility() != 0)
        {
          this.l.setVisibility(0);
          this.u.setVisibility(0);
          this.l.setAnimation(AnimationUtils.loadAnimation(this.f, 2130968581));
          this.l.requestFocus();
          this.l.bringToFront();
        }
        ((Activity)this.f).getWindow().setSoftInputMode(5);
        o();
      }
      this.o = true;
    }
  }

  public void a(boolean paramBoolean)
  {
    boolean bool;
    PhotoFlowLogger localPhotoFlowLogger;
    if (this.c != null)
    {
      this.e.a(this.c);
      if (this.g != null)
      {
        bool = this.c.g();
        localPhotoFlowLogger = this.g;
        if (!bool)
          break label69;
      }
    }
    label69: for (String str = Long.toString(this.c.f()); ; str = this.c.b())
    {
      localPhotoFlowLogger.a(true, bool, paramBoolean, false, str);
      return;
    }
  }

  public void b()
  {
    this.a.n();
    g();
  }

  public void b(MediaItem paramMediaItem)
  {
    for (int i1 = 0; ; i1++)
    {
      if (i1 < this.a.b())
      {
        if (this.a.a(i1).a() != paramMediaItem.a())
          continue;
        this.d.setCurrentItem(i1, false);
        b(i1);
        i();
      }
      return;
    }
  }

  public void c()
  {
    h();
  }

  public void d()
  {
    j();
    m();
  }

  public boolean e()
  {
    if (this.l.getVisibility() == 0)
      f();
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public PhotoToggleButton getCheck()
  {
    return this.b;
  }

  public MediaItem getCurrentItem()
  {
    return this.c;
  }

  public int getCurrentPosition()
  {
    return this.d.getCurrentItem();
  }

  public Object getCustomNonConfigurationState()
  {
    return new PickerGalleryView.RetainedData(this.a.k(), this.h);
  }

  public MediaPickerActivity.SelectedMode getMode()
  {
    return this.a.g();
  }

  public FacebookPhotoTag[] getTags()
  {
    return this.a.j();
  }

  public void setCameraFlowLogger(PhotoFlowLogger paramPhotoFlowLogger)
  {
    this.g = paramPhotoFlowLogger;
  }

  public void setCurrentBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
      this.a.f().setBitmapIfNotLoaded(paramBitmap, 0);
  }

  public void setMedia(List<MediaItem> paramList)
  {
    this.a.a(paramList);
    this.d.setAdapter(this.a);
    this.d.setOnPageChangeListener(new PickerGalleryView.5(this));
    if (this.a.b() > 0)
      this.c = this.a.a(0);
  }

  public void setMode(MediaPickerActivity.SelectedMode paramSelectedMode)
  {
    this.a.a(paramSelectedMode);
    this.d.setAdapter(this.a);
  }

  public void setOrientation(int paramInt)
  {
    if (getCurrentItem().e() == MediaItem.MediaType.PHOTO)
      ((PhotoItem)getCurrentItem()).a(paramInt);
  }

  public void setPickerEnvironment(MediaPickerEnvironment paramMediaPickerEnvironment)
  {
    this.j = paramMediaPickerEnvironment;
    PhotoToggleButton localPhotoToggleButton = this.b;
    if (paramMediaPickerEnvironment.a());
    for (int i1 = 8; ; i1 = 0)
    {
      localPhotoToggleButton.setVisibility(i1);
      return;
    }
  }

  public void setSelectionState(SelectionState paramSelectionState)
  {
    if (this.e != null)
      this.e.b(this);
    this.e = paramSelectionState;
    this.e.a(this);
    this.a.a(paramSelectionState);
  }

  public void setTypeAheadAdapter(BaseTagTypeaheadAdapter paramBaseTagTypeaheadAdapter)
  {
    paramBaseTagTypeaheadAdapter.a(this.s.a());
    this.m.setAdapter(paramBaseTagTypeaheadAdapter);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.vault.PickerGalleryView
 * JD-Core Version:    0.6.0
 */