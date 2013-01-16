package com.facebook.appcenter.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.R.styleable;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.UrlImage;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.List;

public class AppDetailScreenshotGalleryView extends CustomViewGroup
{
  private HorizontalImageGallery a;
  private HorizontalImageGalleryItemIndicator b;
  private int c;

  public AppDetailScreenshotGalleryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public AppDetailScreenshotGalleryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903055);
    this.a = ((HorizontalImageGallery)getView(2131296386));
    this.b = ((HorizontalImageGalleryItemIndicator)getView(2131296387));
    paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AppDetailScreenshotGalleryView);
  }

  public int getItemWidthPercentage()
  {
    return this.c;
  }

  public void setItemWidthPercentage(int paramInt)
  {
    this.c = paramInt;
  }

  public void setScreenshots(List<GraphQLImage> paramList)
  {
    int i;
    DisplayMetrics localDisplayMetrics;
    int j;
    int k;
    int m;
    int i3;
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.a.a();
      i = getContext().getResources().getDimensionPixelSize(2131230746);
      localDisplayMetrics = new DisplayMetrics();
      Preconditions.checkNotNull(((Activity)getContext()).getWindowManager());
      Preconditions.checkNotNull(((Activity)getContext()).getWindowManager().getDefaultDisplay());
      ((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      j = (int)Math.floor(0.75F * localDisplayMetrics.heightPixels);
      k = localDisplayMetrics.widthPixels - i * 8;
      Iterator localIterator1 = paramList.iterator();
      m = 0;
      if (localIterator1.hasNext())
      {
        GraphQLImage localGraphQLImage2 = (GraphQLImage)localIterator1.next();
        i3 = (int)(localGraphQLImage2.height / localGraphQLImage2.width * k);
        if (i3 <= m)
          break label453;
      }
    }
    while (true)
    {
      m = i3;
      break;
      int i2;
      if (m > j)
      {
        float f = m / j;
        i2 = (int)(k / f);
      }
      for (int n = (localDisplayMetrics.widthPixels - i2) / 8; ; n = i)
      {
        this.a.getItemsContainer().setPadding(n * 3, n * 2, n * 3, 0);
        this.a.setItemWidth(localDisplayMetrics.widthPixels - n * 6);
        Iterator localIterator2 = paramList.iterator();
        while (localIterator2.hasNext())
        {
          GraphQLImage localGraphQLImage1 = (GraphQLImage)localIterator2.next();
          LinearLayout localLinearLayout = (LinearLayout)inflate(getContext(), 2130903056, null);
          UrlImage localUrlImage = (UrlImage)localLinearLayout.findViewById(2131296388);
          localUrlImage.setPlaceHolderDrawable(null);
          localUrlImage.getImageView().setAdjustViewBounds(true);
          localUrlImage.setShowProgressBar(true);
          localUrlImage.setImageParams(Uri.parse(localGraphQLImage1.uri));
          localUrlImage.setVisibility(0);
          int i1 = localDisplayMetrics.widthPixels - n * 8;
          localUrlImage.setLayoutParams(new LinearLayout.LayoutParams(i1, (int)(localGraphQLImage1.height / localGraphQLImage1.width * i1)));
          localUrlImage.setScaleType(ImageView.ScaleType.FIT_XY);
          localLinearLayout.setPadding(n, 0, n, 0);
          this.a.addView(localLinearLayout);
        }
        this.a.setItemIndicator(this.b);
        return;
      }
      label453: i3 = m;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.AppDetailScreenshotGalleryView
 * JD-Core Version:    0.6.0
 */