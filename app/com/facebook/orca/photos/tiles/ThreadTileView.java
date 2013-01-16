package com.facebook.orca.photos.tiles;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView.ScaleType;
import com.facebook.R.styleable;
import com.facebook.orca.attachments.AttachmentDataFactory;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.cache.ThreadDisplayCache;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.debug.WtfToken;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.photos.sizing.CropRegionConstraintsBuilder;
import com.facebook.orca.photos.sizing.GraphicOpConstraints;
import com.facebook.orca.photos.sizing.GraphicOpConstraintsBuilder;
import com.facebook.orca.photos.sizing.GraphicSizerFactory;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.threads.ThreadParticipantUtils;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.UrlImage;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class ThreadTileView extends CustomViewGroup
{
  private static final Class<?> a = ThreadTileView.class;
  private static final WtfToken b = new WtfToken();
  private final DataCache c;
  private final ThreadDisplayCache d;
  private final GraphicSizerFactory e;
  private final UserTileViewLogic f;
  private final DefaultTiles g;
  private final AttachmentDataFactory h;
  private final ThreadParticipantUtils i;
  private final ColorDrawable j;
  private final List<UrlImage> k;
  private final List<Rect> l;
  private ThreadSummary m;
  private int n;
  private final float o;
  private int p;

  public ThreadTileView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public ThreadTileView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ThreadTileView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    FbInjector localFbInjector = getInjector();
    this.c = ((DataCache)localFbInjector.a(DataCache.class));
    this.d = ((ThreadDisplayCache)localFbInjector.a(ThreadDisplayCache.class));
    this.e = ((GraphicSizerFactory)localFbInjector.a(GraphicSizerFactory.class));
    this.f = ((UserTileViewLogic)localFbInjector.a(UserTileViewLogic.class));
    this.g = ((DefaultTiles)localFbInjector.a(DefaultTiles.class));
    this.h = ((AttachmentDataFactory)localFbInjector.a(AttachmentDataFactory.class));
    this.i = ((ThreadParticipantUtils)localFbInjector.a(ThreadParticipantUtils.class));
    TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ThreadTileView);
    this.n = localTypedArray.getDimensionPixelSize(0, -1);
    if (this.n == -1)
      this.n = SizeUtil.a(paramContext, 50.0F);
    this.o = localTypedArray.getFloat(1, 0.6666667F);
    localTypedArray.recycle();
    if (getBackground() == null)
      setBackgroundDrawable(new ColorDrawable(2131165396));
    this.j = new ColorDrawable(DefaultTiles.a);
    this.k = Lists.c(3);
    this.l = Lists.c(3);
  }

  private void a()
  {
    this.p = 0;
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext())
      ((UrlImage)localIterator.next()).setVisibility(8);
    if (this.m == null);
    while (true)
    {
      return;
      a(1);
      UrlImage localUrlImage = (UrlImage)this.k.get(0);
      localUrlImage.setVisibility(0);
      localUrlImage.setPlaceHolderScaleType(ImageView.ScaleType.FIT_CENTER);
      Uri localUri;
      int i1;
      if ((this.m.q()) || (this.m.s()))
      {
        localUri = this.h.a(this.m);
        if (localUri.isRelative())
          BLog.a(b, a, "Uri is not absolute - Uri: " + localUri.toString() + " TID: " + this.m.a());
      }
      else
      {
        i1 = this.d.c(this.m);
        if (i1 != 1)
          break label301;
        ThreadParticipant localThreadParticipant2 = (ThreadParticipant)this.m.i().get(0);
        localUrlImage.setImageParams(this.f.a(UserTileViewParams.a(localThreadParticipant2), this.n, this.n));
        localUrlImage.setPlaceHolderDrawable(this.g.b(this.m, this.n, this.n));
        this.p = 1;
        continue;
      }
      localUrlImage.setImageParams(localUri, this.e.a(b(this.n)));
      localUrlImage.setPlaceHolderDrawable(this.g.a(this.n, this.n));
      this.p = 1;
      continue;
      label301: if (i1 == 2)
      {
        ThreadParticipant localThreadParticipant1 = this.i.a(this.m);
        localUrlImage.setImageParams(this.f.a(UserTileViewParams.a(localThreadParticipant1), this.n, this.n));
        localUrlImage.setPlaceHolderDrawable(this.g.b(this.m, this.n, this.n));
        this.p = 1;
        continue;
      }
      if (MessagingIdUtil.g(this.m.a()))
      {
        localUrlImage.setImageParams(UrlImage.a);
        localUrlImage.setPlaceHolderDrawable(this.g.b(this.n, this.n));
        this.p = 1;
        continue;
      }
      List localList = this.d.b(this.m);
      if (localList.size() < 2)
      {
        localUrlImage.setImageParams(UrlImage.a);
        localUrlImage.setPlaceHolderDrawable(this.g.a(this.m, this.n, this.n));
        this.p = 1;
        continue;
      }
      a(localUrlImage, localList);
    }
  }

  private void a(int paramInt)
  {
    for (int i1 = this.k.size(); i1 < paramInt; i1++)
    {
      UrlImage localUrlImage = new UrlImage(getContext());
      localUrlImage.setBackgroundDrawable(this.j);
      addView(localUrlImage);
      this.k.add(localUrlImage);
      this.l.add(new Rect());
    }
  }

  private void a(UrlImage paramUrlImage, ParticipantInfo paramParticipantInfo, Rect paramRect)
  {
    if (paramParticipantInfo.b())
      paramUrlImage.setPlaceHolderDrawable(this.j);
    while (true)
    {
      return;
      paramUrlImage.setPlaceHolderDrawable(this.g.a(paramParticipantInfo, paramRect.width(), paramRect.height()));
    }
  }

  private void a(UrlImage paramUrlImage, List<ParticipantInfo> paramList)
  {
    a(3);
    int i1 = SizeUtil.a(getContext(), 1.0F);
    int i2 = (int)((this.n - i1) * this.o);
    int i3 = (this.n - i1) / 2;
    Rect localRect1 = (Rect)this.l.get(0);
    localRect1.set(0, 0, i2, this.n);
    Rect localRect2 = (Rect)this.l.get(1);
    localRect2.set(i2 + i1, 0, this.n, i3);
    Rect localRect3 = (Rect)this.l.get(2);
    localRect3.set(i2 + i1, i1 + i3, this.n, this.n);
    paramUrlImage.setImageParams(this.f.a(UserTileViewParams.a(((ParticipantInfo)paramList.get(0)).e()), localRect1.width(), localRect1.height()));
    a(paramUrlImage, (ParticipantInfo)paramList.get(0), localRect1);
    UrlImage localUrlImage1 = (UrlImage)this.k.get(1);
    localUrlImage1.setImageParams(this.f.a(UserTileViewParams.a(((ParticipantInfo)paramList.get(1)).e()), localRect2.width(), localRect2.height()));
    a(localUrlImage1, (ParticipantInfo)paramList.get(1), localRect2);
    localUrlImage1.setVisibility(0);
    UrlImage localUrlImage2 = (UrlImage)this.k.get(2);
    if (paramList.size() == 2)
    {
      localUrlImage2.setImageParams(this.f.a(UserTileViewParams.a(this.c.b()), localRect3.width(), localRect3.height()));
      a(localUrlImage2, new ParticipantInfo(this.c.b(), null), localRect3);
    }
    while (true)
    {
      localUrlImage2.setVisibility(0);
      this.p = 3;
      return;
      localUrlImage2.setImageParams(this.f.a(UserTileViewParams.a(((ParticipantInfo)paramList.get(2)).e()), localRect3.width(), localRect3.height()));
      a(localUrlImage2, (ParticipantInfo)paramList.get(2), localRect3);
    }
  }

  private static GraphicOpConstraints b(int paramInt)
  {
    return new GraphicOpConstraintsBuilder().a(new CropRegionConstraintsBuilder().a(1.0F).b(1.0F).c(1.0F).e()).a(paramInt / 2).b(paramInt / 2).c(paramInt).d(paramInt).i();
  }

  public ThreadSummary getThreadSummary()
  {
    return this.m;
  }

  public int getTileSizePx()
  {
    return this.n;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Tracer localTracer = Tracer.a("ThreadTileView.onLayout");
    int i1 = getPaddingLeft();
    (getRight() - getLeft() - getPaddingRight());
    int i2 = getPaddingTop();
    (getBottom() - getTop() - getPaddingBottom());
    if (this.p == 1)
    {
      UrlImage localUrlImage2 = (UrlImage)this.k.get(0);
      int i4 = localUrlImage2.getMeasuredWidth();
      int i5 = localUrlImage2.getMeasuredHeight();
      localUrlImage2.layout(i1, i2, i4 + i1, i5 + i2);
    }
    while (true)
    {
      localTracer.a();
      return;
      if (this.p != 3)
        continue;
      for (int i3 = 0; i3 < this.p; i3++)
      {
        UrlImage localUrlImage1 = (UrlImage)this.k.get(i3);
        Rect localRect = (Rect)this.l.get(i3);
        localUrlImage1.layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
      }
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    Tracer localTracer = Tracer.a("ThreadTileView.onMeasure");
    int i2 = 0 + (getPaddingLeft() + getPaddingRight());
    int i3 = 0 + (getPaddingTop() + getPaddingBottom());
    UrlImage localUrlImage2;
    int i4;
    if (this.p == 1)
    {
      a(1);
      localUrlImage2 = (UrlImage)this.k.get(0);
      measureChildWithMargins(localUrlImage2, paramInt1, 0, paramInt2, 0);
      i4 = Math.max(i2, localUrlImage2.getMeasuredWidth());
    }
    for (int i5 = Math.max(i3, localUrlImage2.getMeasuredHeight()); ; i5 = i3)
    {
      int i6 = Math.max(i5, getSuggestedMinimumHeight());
      setMeasuredDimension(resolveSize(Math.max(i4, getSuggestedMinimumWidth()), paramInt1), resolveSize(i6, paramInt2));
      localTracer.a();
      return;
      if (this.p == 3)
      {
        a(this.p);
        while (i1 < this.p)
        {
          UrlImage localUrlImage1 = (UrlImage)this.k.get(i1);
          Rect localRect = (Rect)this.l.get(i1);
          localUrlImage1.measure(View.MeasureSpec.makeMeasureSpec(localRect.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(localRect.height(), 1073741824));
          i1++;
        }
      }
      i4 = i2;
    }
  }

  public void setThreadSummary(ThreadSummary paramThreadSummary)
  {
    this.m = paramThreadSummary;
    a();
    requestLayout();
    invalidate();
  }

  public void setTileSizePx(int paramInt)
  {
    this.n = paramInt;
    a();
    requestLayout();
    invalidate();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.tiles.ThreadTileView
 * JD-Core Version:    0.6.0
 */