package com.karmascience.gifts.views;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.facebook.widget.UrlImage;
import com.karmascience.gifts.content.model.Image;
import java.util.ArrayList;
import java.util.List;

class ProductDetailsView$ProductImagePageAdapter extends PagerAdapter
{
  private final List<Image> b;
  private final LayoutInflater c;
  private final ArrayList<View> d;

  public ProductDetailsView$ProductImagePageAdapter(List<Image> paramList)
  {
    Object localObject;
    this.b = localObject;
    this.c = LayoutInflater.from(paramList.g());
    this.d = new ArrayList();
  }

  public Object a(ViewGroup paramViewGroup, int paramInt)
  {
    int i = this.d.size();
    View localView1 = null;
    if (i > 0)
    {
      localView1 = (View)this.d.remove(0);
      paramViewGroup.addView(localView1);
    }
    View localView3;
    if (localView1 == null)
    {
      localView3 = this.c.inflate(2130903505, paramViewGroup, false);
      UrlImage localUrlImage = (UrlImage)localView3.findViewById(2131297724);
      localUrlImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localUrlImage.setPlaceHolderDrawable(ProductDetailsView.b(this.a));
      localUrlImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramViewGroup.addView(localView3);
    }
    for (View localView2 = localView3; ; localView2 = localView1)
    {
      ((UrlImage)localView2.findViewById(2131297724)).setImageParams(((Image)this.b.get(paramInt)).a());
      return localView2;
    }
  }

  public void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    View localView = (View)paramObject;
    paramViewGroup.removeView(localView);
    this.d.add(localView);
  }

  public boolean a(View paramView, Object paramObject)
  {
    if (paramView == paramObject);
    for (int i = 1; ; i = 0)
      return i;
  }

  public int b()
  {
    return this.b.size();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.ProductDetailsView.ProductImagePageAdapter
 * JD-Core Version:    0.6.0
 */