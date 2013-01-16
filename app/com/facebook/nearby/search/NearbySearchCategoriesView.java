package com.facebook.nearby.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.facebook.nearby.model.NearbyTopic;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class NearbySearchCategoriesView extends CustomLinearLayout
{
  private final ImmutableMap<Integer, NearbyTopic> a;

  public NearbySearchCategoriesView(Context paramContext)
  {
    this(paramContext, null);
  }

  public NearbySearchCategoriesView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903289);
    NearbySearchCategoryList localNearbySearchCategoryList = NearbySearchCategoryList.a(getContext());
    this.a = ImmutableMap.k().b(Integer.valueOf(2131297141), localNearbySearchCategoryList.a).b(Integer.valueOf(2131297143), localNearbySearchCategoryList.c).b(Integer.valueOf(2131297142), localNearbySearchCategoryList.b).b(Integer.valueOf(2131297144), localNearbySearchCategoryList.d).b(Integer.valueOf(2131297146), localNearbySearchCategoryList.f).b(Integer.valueOf(2131297147), localNearbySearchCategoryList.g).b(Integer.valueOf(2131297148), localNearbySearchCategoryList.h).b(Integer.valueOf(2131297145), localNearbySearchCategoryList.e).b();
    Iterator localIterator = this.a.a().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((Button)findViewById(((Integer)localEntry.getKey()).intValue())).setText(((NearbyTopic)localEntry.getValue()).a);
    }
  }

  public void setOnCategoryClickedListener(NearbySearchCategoriesView.OnCategoryClickedListener paramOnCategoryClickedListener)
  {
    Iterator localIterator = this.a.a().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      findViewById(((Integer)localEntry.getKey()).intValue()).setOnClickListener(new NearbySearchCategoriesView.1(this, paramOnCategoryClickedListener, localEntry));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.search.NearbySearchCategoriesView
 * JD-Core Version:    0.6.0
 */