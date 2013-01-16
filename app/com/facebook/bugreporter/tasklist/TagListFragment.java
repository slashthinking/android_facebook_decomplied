package com.facebook.bugreporter.tasklist;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.facebook.bugreporter.BugReporterConfig;
import com.facebook.fragment.NavigableFragment;
import com.facebook.fragment.NavigableFragment.Listener;
import com.facebook.orca.activity.FbNestedFragment;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.common.ui.titlebar.FbTitleBarUtil;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import com.facebook.orca.inject.FbInjector;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;

public class TagListFragment extends FbNestedFragment
  implements NavigableFragment
{
  private static final Class<?> a = TagListFragment.class;
  private BugReporterConfig b;
  private TagListAdapter c;
  private NavigableFragment.Listener d;
  private FbTitleBar e;
  private ListView f;

  private void b()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("checked_tags", c());
    this.d.a(this, localIntent);
  }

  private long[] c()
  {
    ImmutableList localImmutableList = this.c.a();
    long[] arrayOfLong = new long[localImmutableList.size()];
    for (int i = 0; i < arrayOfLong.length; i++)
      arrayOfLong[i] = ((TagListItem)localImmutableList.get(i)).b();
    return arrayOfLong;
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903570, paramViewGroup, false);
  }

  public void a(NavigableFragment.Listener paramListener)
  {
    this.d = paramListener;
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    FbInjector localFbInjector = a();
    this.b = ((BugReporterConfig)localFbInjector.a(BugReporterConfig.class));
    this.c = ((TagListAdapter)localFbInjector.a(TagListAdapter.class));
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = this.b.c().iterator();
    while (localIterator.hasNext())
      localBuilder.b(new TagListItem((TagInfo)localIterator.next()));
    this.c.a(localBuilder.b());
    this.f = ((ListView)f(16908298));
    this.f.setAdapter(this.c);
    FbTitleBarUtil.a(A());
    this.e = ((FbTitleBar)f(2131296299));
    this.e.setTitle(2131362014);
    TitleBarButtonSpec localTitleBarButtonSpec = TitleBarButtonSpec.newBuilder().a(1).b(e(2131362015)).i();
    this.e.setButtonSpecs(ImmutableList.a(localTitleBarButtonSpec));
    this.e.setOnToolbarButtonListener(new TagListFragment.1(this));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.tasklist.TagListFragment
 * JD-Core Version:    0.6.0
 */