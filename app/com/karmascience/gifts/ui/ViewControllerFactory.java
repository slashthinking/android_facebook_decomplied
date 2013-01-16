package com.karmascience.gifts.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.karmascience.gifts.views.AlcoholInfoEntryView;
import com.karmascience.gifts.views.CardFrontView;
import com.karmascience.gifts.views.CustomCardView;
import com.karmascience.gifts.views.KSViewController;
import com.karmascience.gifts.views.OrderConfirmationView;
import com.karmascience.gifts.views.OrderReviewView;
import com.karmascience.gifts.views.ProductDetailsView;
import com.karmascience.gifts.views.ProductSkuSelectorView;
import com.karmascience.gifts.views.ProductsFilterView;
import com.karmascience.gifts.views.ProductsView;
import com.karmascience.gifts.views.ShareGiftChoiceView;
import com.karmascience.gifts.views.iTunesRecommendationView;
import com.karmascience.gifts.views.iTunesSkuSelectionView;

public class ViewControllerFactory
{
  private static int a = 1;

  public static String a()
  {
    monitorenter;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder().append("unique_tag_");
      int i = a;
      a = i + 1;
      String str = Integer.toString(i);
      monitorexit;
      return str;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public final KSViewController a(int paramInt, Activity paramActivity, Handler paramHandler, IViewManager paramIViewManager, Bundle paramBundle)
  {
    Object localObject;
    switch (paramInt)
    {
    case 5:
    case 10:
    case 11:
    default:
      localObject = null;
    case 4:
    case 6:
    case 8:
    case 9:
    case 12:
    case 13:
    case 14:
    case 7:
    case 15:
    case 16:
    case 17:
    case 18:
    }
    while (true)
    {
      return localObject;
      localObject = new CardFrontView(paramActivity, paramHandler, paramIViewManager, paramBundle, a());
      continue;
      localObject = new CustomCardView(paramActivity, paramHandler, paramIViewManager, paramBundle, a());
      continue;
      localObject = new OrderConfirmationView(paramActivity, paramHandler, paramIViewManager, paramBundle, a());
      continue;
      localObject = new OrderReviewView(paramActivity, paramHandler, paramIViewManager, paramBundle, a());
      continue;
      localObject = new ProductDetailsView(paramActivity, paramHandler, paramIViewManager, paramBundle, a());
      continue;
      localObject = new ProductSkuSelectorView(paramActivity, paramHandler, paramIViewManager, paramBundle, a());
      continue;
      localObject = new ProductsView(paramActivity, paramHandler, paramIViewManager, paramBundle, a());
      continue;
      localObject = new ShareGiftChoiceView(paramActivity, paramHandler, paramIViewManager, paramBundle, a());
      continue;
      localObject = new ProductsFilterView(paramActivity, paramHandler, paramIViewManager, paramBundle, a());
      continue;
      localObject = new iTunesSkuSelectionView(paramActivity, paramHandler, paramIViewManager, paramBundle, a());
      continue;
      localObject = new iTunesRecommendationView(paramActivity, paramHandler, paramIViewManager, paramBundle, a());
      continue;
      localObject = new AlcoholInfoEntryView(paramActivity, paramHandler, paramIViewManager, paramBundle, a());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.ui.ViewControllerFactory
 * JD-Core Version:    0.6.0
 */