package com.facebook.orca.photos.tiles;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.facebook.R.styleable;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.images.FetchImageParams;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.UrlImage;

public class UserTileView extends FrameLayout
{
  private UserTileViewLogic a;
  private DefaultTiles b;
  private UrlImage c;
  private UserTileViewParams d;
  private int e;

  public UserTileView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public UserTileView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public UserTileView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private void a()
  {
    FetchImageParams localFetchImageParams = this.a.a(this.d, this.e, this.e);
    this.c.setImageParams(localFetchImageParams);
    if (this.d == null)
      this.c.setPlaceHolderDrawable(this.b.c(this.e, this.e));
    while (true)
    {
      return;
      this.c.setPlaceHolderDrawable(this.b.a(this.d.c(), this.e, this.e));
    }
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    Tracer localTracer = Tracer.a("UserTileView.init");
    FbInjector localFbInjector = FbInjector.a(paramContext);
    this.a = ((UserTileViewLogic)localFbInjector.a(UserTileViewLogic.class));
    this.b = ((DefaultTiles)localFbInjector.a(DefaultTiles.class));
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ThreadTileView);
    this.e = localTypedArray.getDimensionPixelSize(0, -1);
    if (this.e == -1)
      this.e = SizeUtil.a(paramContext, 50.0F);
    localTypedArray.recycle();
    this.c = new UrlImage(getContext());
    this.c.setPlaceHolderDrawable(this.b.c(50, 50));
    addView(this.c);
    localTracer.a();
  }

  public UserTileViewParams getParams()
  {
    return this.d;
  }

  public UserTileViewParams getUserTileViewParams()
  {
    return this.d;
  }

  public void setParams(UserTileViewParams paramUserTileViewParams)
  {
    this.d = paramUserTileViewParams;
    a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.tiles.UserTileView
 * JD-Core Version:    0.6.0
 */