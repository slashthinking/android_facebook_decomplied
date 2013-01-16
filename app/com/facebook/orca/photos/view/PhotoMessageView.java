package com.facebook.orca.photos.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.photos.sizing.CropRegionConstraintsBuilder;
import com.facebook.orca.photos.sizing.GraphicOpConstraints;
import com.facebook.orca.photos.sizing.GraphicOpConstraintsBuilder;
import com.facebook.orca.photos.sizing.GraphicSizerFactory;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.UrlImage;

public class PhotoMessageView extends CustomViewGroup
{
  private UrlImage a;
  private GraphicSizerFactory b;

  public PhotoMessageView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public PhotoMessageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public PhotoMessageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private GraphicOpConstraints a()
  {
    int i = getContext().getResources().getDisplayMetrics().widthPixels;
    int j = getContext().getResources().getDisplayMetrics().heightPixels;
    GraphicOpConstraintsBuilder localGraphicOpConstraintsBuilder = new GraphicOpConstraintsBuilder().a(SizeUtil.a(getContext(), 0.0F)).c(i).b(SizeUtil.a(getContext(), 0.0F)).d(j);
    localGraphicOpConstraintsBuilder.a(new CropRegionConstraintsBuilder().a(1.0F).b(0.0F).c(0.0F).e());
    return localGraphicOpConstraintsBuilder.i();
  }

  private void a(Context paramContext)
  {
    this.b = ((GraphicSizerFactory)getInjector().a(GraphicSizerFactory.class));
    setContentView(2130903389);
    this.a = ((UrlImage)getView(2131297397));
  }

  public void setPhotoMessageItem(PhotoMessageItem paramPhotoMessageItem)
  {
    this.a.setImageParams(paramPhotoMessageItem.a(), this.b.a(a()));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.view.PhotoMessageView
 * JD-Core Version:    0.6.0
 */