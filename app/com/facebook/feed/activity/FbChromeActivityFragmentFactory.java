package com.facebook.feed.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.fragment.IFragmentFactory;
import com.facebook.fragment.IFragmentFactoryInitializer;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Set;

public class FbChromeActivityFragmentFactory
{
  private final ImmutableMap<Integer, IFragmentFactory> a;
  private final Function<IFragmentFactory, Integer> b = new FbChromeActivityFragmentFactory.1(this);

  public FbChromeActivityFragmentFactory(Set<IFragmentFactoryInitializer> paramSet)
  {
    ImmutableMap.Builder localBuilder = ImmutableMap.k();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
      localBuilder.b(Maps.a(((IFragmentFactoryInitializer)localIterator.next()).b(), this.b));
    this.a = localBuilder.b();
  }

  public Fragment a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("target_fragment", 0);
    Object localObject = this.a.get(Integer.valueOf(i));
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(i);
    return ((IFragmentFactory)Preconditions.checkNotNull(localObject, "Undefined content fragment factory identifier %s", arrayOfObject)).a(paramIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.activity.FbChromeActivityFragmentFactory
 * JD-Core Version:    0.6.0
 */