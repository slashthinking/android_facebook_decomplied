package com.facebook.katana.activity.places;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.katana.model.PageTopic;
import com.facebook.katana.service.method.PageTopicsGet;
import com.facebook.katana.ui.SectionedListAdapter;
import com.facebook.katana.util.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SelectPageTopicAdapter extends SectionedListAdapter
{
  private static Map<Long, PageTopic> g;
  private static Map<PageTopic, List<PageTopic>> h;
  private final Context a;
  private final int b;
  private final long c;
  private final PageTopic d;
  private final boolean e;
  private List<PageTopic> f;

  public SelectPageTopicAdapter(Context paramContext, int paramInt, long paramLong)
  {
    this.a = paramContext;
    this.b = paramInt;
    this.c = paramLong;
    boolean bool;
    if (this.b > 0)
    {
      bool = true;
      this.e = bool;
      this.f = new ArrayList();
      if (this.b != 0)
        break label86;
      e();
    }
    while (true)
    {
      this.d = ((PageTopic)g.get(Long.valueOf(this.c)));
      return;
      bool = false;
      break;
      label86: f();
    }
  }

  private void a(PageTopic paramPageTopic1, PageTopic paramPageTopic2)
  {
    Object localObject = (List)h.get(paramPageTopic1);
    if (localObject == null)
    {
      localObject = new ArrayList();
      h.put(paramPageTopic1, localObject);
    }
    ((List)localObject).add(paramPageTopic2);
  }

  private String b(long paramLong)
  {
    List localList = a(paramLong);
    ArrayList localArrayList;
    if ((localList != null) && (localList.size() > 0))
    {
      Collections.sort(localList, new SelectPageTopicAdapter.1(this));
      localArrayList = new ArrayList();
      int i = Math.min(3, localList.size());
      for (int j = 0; j < i; j++)
        localArrayList.add(((PageTopic)localList.get(j)).displayName);
    }
    for (String str = StringUtils.a(", ", new Object[] { localArrayList }); ; str = null)
      return str;
  }

  private void f()
  {
    this.f = a(this.c);
  }

  public int a(int paramInt)
  {
    return 0;
  }

  public View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = LayoutInflater.from(this.a).inflate(2130903474, null);
    if ((this.e) && (paramInt1 == 0))
    {
      ((TextView)paramView.findViewById(2131297662)).setText(this.d.displayName);
      paramView.findViewById(2131297663).setVisibility(8);
      paramView.findViewById(2131297664).setVisibility(8);
    }
    while (true)
    {
      return paramView;
      ((TextView)paramView.findViewById(2131297662)).setText(((PageTopic)this.f.get(paramInt2)).displayName);
      if (b(((PageTopic)this.f.get(paramInt2)).id) == null)
      {
        paramView.findViewById(2131297663).setVisibility(8);
        paramView.findViewById(2131297664).setVisibility(8);
        continue;
      }
      paramView.findViewById(2131297664).setVisibility(0);
      if (this.b == 0)
      {
        paramView.findViewById(2131297663).setVisibility(0);
        ((TextView)paramView.findViewById(2131297663)).setText(b(((PageTopic)this.f.get(paramInt2)).id));
        continue;
      }
      paramView.findViewById(2131297663).setVisibility(8);
    }
  }

  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (!this.e)
    {
      localObject = new View(this.a);
      return localObject;
    }
    if (paramView == null);
    for (View localView = LayoutInflater.from(this.a).inflate(2130903475, null); ; localView = paramView)
    {
      switch (paramInt)
      {
      default:
        ((TextView)localView.findViewById(2131296432)).setText(this.a.getString(2131363475));
      case 0:
      }
      while (true)
      {
        localObject = localView;
        break;
        ((TextView)localView.findViewById(2131296432)).setText(this.a.getString(2131363474));
      }
    }
  }

  public Object a(int paramInt1, int paramInt2)
  {
    if ((!this.e) || ((this.e) && (paramInt1 == 1)));
    for (Object localObject = this.f.get(paramInt2); ; localObject = this.d)
      return localObject;
  }

  public List<PageTopic> a(long paramLong)
  {
    PageTopic localPageTopic = (PageTopic)g.get(Long.valueOf(paramLong));
    List localList = (List)h.get(localPageTopic);
    if (localList != null);
    for (ArrayList localArrayList = new ArrayList(localList); ; localArrayList = new ArrayList())
      return localArrayList;
  }

  public int b(int paramInt)
  {
    int i;
    if (this.e)
      if (paramInt == 0)
        i = 1;
    while (true)
    {
      return i;
      i = this.f.size();
      continue;
      i = this.f.size();
    }
  }

  public int b(int paramInt1, int paramInt2)
  {
    return 1;
  }

  public int c()
  {
    return 2;
  }

  public Object c(int paramInt)
  {
    return null;
  }

  public boolean c(int paramInt1, int paramInt2)
  {
    return true;
  }

  public boolean d()
  {
    return false;
  }

  public int d_()
  {
    if (this.e);
    for (int i = 2; ; i = 1)
      return i;
  }

  public void e()
  {
    List localList = PageTopicsGet.a(this.a);
    g = new HashMap();
    h = new HashMap();
    Iterator localIterator1 = localList.iterator();
    while (localIterator1.hasNext())
    {
      PageTopic localPageTopic2 = (PageTopic)localIterator1.next();
      g.put(Long.valueOf(localPageTopic2.id), localPageTopic2);
    }
    Iterator localIterator2 = localList.iterator();
    while (localIterator2.hasNext())
    {
      PageTopic localPageTopic1 = (PageTopic)localIterator2.next();
      if ((localPageTopic1.parentIds == null) || (localPageTopic1.parentIds.size() == 0))
      {
        a(null, localPageTopic1);
        continue;
      }
      Iterator localIterator4 = localPageTopic1.parentIds.iterator();
      while (localIterator4.hasNext())
      {
        Long localLong = (Long)localIterator4.next();
        a((PageTopic)g.get(localLong), localPageTopic1);
      }
    }
    Iterator localIterator3 = h.values().iterator();
    while (localIterator3.hasNext())
      Collections.sort((List)localIterator3.next(), new SelectPageTopicAdapter.2(this));
    f();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.SelectPageTopicAdapter
 * JD-Core Version:    0.6.0
 */