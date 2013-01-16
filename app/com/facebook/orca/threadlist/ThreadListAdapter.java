package com.facebook.orca.threadlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.orca.cache.ArchiveThreadManager;
import com.facebook.orca.cache.SpamThreadManager;
import com.facebook.orca.threads.ThreadSummary;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;

public class ThreadListAdapter extends BaseAdapter
{
  public static final Object a = new Object();
  public static final Object b = new Object();
  public static final Object c = new Object();
  public static final Object d = new Object();
  public static final Object e = new Object();
  private final Context f;
  private final LayoutInflater g;
  private final ArchiveThreadManager h;
  private final SpamThreadManager i;
  private ThreadListAdapter.Mode j = ThreadListAdapter.Mode.NORMAL;
  private ThreadListAdapter.LoadMoreState k = ThreadListAdapter.LoadMoreState.NONE;
  private String l;
  private ImmutableList<ThreadSummary> m = ImmutableList.d();
  private ImmutableList<?> n = ImmutableList.d();
  private Supplier<ThreadItemView> o = new ThreadListAdapter.DefaultThreadItemViewSupplier(this, null);

  public ThreadListAdapter(Context paramContext, ArchiveThreadManager paramArchiveThreadManager, SpamThreadManager paramSpamThreadManager, LayoutInflater paramLayoutInflater)
  {
    this.f = paramContext;
    this.h = paramArchiveThreadManager;
    this.i = paramSpamThreadManager;
    this.g = paramLayoutInflater;
  }

  private View a(View paramView)
  {
    if (paramView == null)
    {
      paramView = this.g.inflate(2130903410, null);
      ((TextView)paramView.findViewById(2131297472)).setText(2131362416);
    }
    return paramView;
  }

  private View a(View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = this.g.inflate(2130903352, paramViewGroup, false);
    return paramView;
  }

  private ImmutableList<ThreadSummary> a(ImmutableList<ThreadSummary> paramImmutableList, Predicate<ThreadSummary> paramPredicate)
  {
    Iterator localIterator1 = paramImmutableList.iterator();
    int i1 = 0;
    if (localIterator1.hasNext())
      if (!paramPredicate.apply((ThreadSummary)localIterator1.next()))
        break label116;
    label116: for (int i2 = 1; ; i2 = i1)
    {
      i1 = i2;
      break;
      if (i1 == 0);
      while (true)
      {
        return paramImmutableList;
        ImmutableList.Builder localBuilder = ImmutableList.e();
        Iterator localIterator2 = paramImmutableList.iterator();
        while (localIterator2.hasNext())
        {
          ThreadSummary localThreadSummary = (ThreadSummary)localIterator2.next();
          if (paramPredicate.apply(localThreadSummary))
            continue;
          localBuilder.b(localThreadSummary);
        }
        paramImmutableList = localBuilder.b();
      }
    }
  }

  private void a()
  {
    if (this.j == ThreadListAdapter.Mode.NORMAL)
      b();
    while (true)
    {
      return;
      c();
    }
  }

  private View b(View paramView)
  {
    if (paramView == null)
    {
      paramView = this.g.inflate(2130903409, null);
      TextView localTextView = (TextView)paramView.findViewById(2131297471);
      if (this.l != null)
        localTextView.setText(this.l);
    }
    return paramView;
  }

  private View b(View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = this.g.inflate(2130903351, paramViewGroup, false);
    return paramView;
  }

  private ImmutableList<ThreadSummary> b(ImmutableList<ThreadSummary> paramImmutableList)
  {
    if (!this.h.a());
    while (true)
    {
      return paramImmutableList;
      paramImmutableList = a(paramImmutableList, new ThreadListAdapter.1(this));
    }
  }

  private void b()
  {
    this.n = b(c(this.m));
    notifyDataSetChanged();
  }

  private View c(View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = this.g.inflate(2130903353, paramViewGroup, false);
    return paramView;
  }

  private ImmutableList<ThreadSummary> c(ImmutableList<ThreadSummary> paramImmutableList)
  {
    if (!this.i.a());
    while (true)
    {
      return paramImmutableList;
      paramImmutableList = a(paramImmutableList, new ThreadListAdapter.2(this));
    }
  }

  private void c()
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    localBuilder.b(b);
    localBuilder.b(d(b(c(this.m))));
    this.n = localBuilder.b();
  }

  private ImmutableList<ThreadSummary> d(ImmutableList<ThreadSummary> paramImmutableList)
  {
    return a(paramImmutableList, new ThreadListAdapter.3(this));
  }

  public View a(ThreadSummary paramThreadSummary, View paramView)
  {
    ThreadItemView localThreadItemView1 = (ThreadItemView)paramView;
    if (localThreadItemView1 == null);
    for (ThreadItemView localThreadItemView2 = (ThreadItemView)this.o.get(); ; localThreadItemView2 = localThreadItemView1)
    {
      localThreadItemView2.a(paramThreadSummary, this.j);
      return localThreadItemView2;
    }
  }

  void a(ThreadListAdapter.LoadMoreState paramLoadMoreState)
  {
    this.k = paramLoadMoreState;
  }

  public void a(ThreadListAdapter.Mode paramMode)
  {
    this.j = paramMode;
  }

  public void a(Supplier<ThreadItemView> paramSupplier)
  {
    this.o = paramSupplier;
  }

  public void a(ImmutableList<ThreadSummary> paramImmutableList)
  {
    this.m = paramImmutableList;
    a();
  }

  public void a(String paramString)
  {
    this.l = paramString;
  }

  public int getCount()
  {
    int i1 = this.n.size();
    if (this.k == ThreadListAdapter.LoadMoreState.NONE);
    for (int i2 = 0; ; i2 = 1)
      return i2 + i1;
  }

  public Object getItem(int paramInt)
  {
    Object localObject;
    if (paramInt < this.n.size())
      localObject = this.n.get(paramInt);
    while (true)
    {
      return localObject;
      if (paramInt == this.n.size())
      {
        if (this.k == ThreadListAdapter.LoadMoreState.LOAD_MORE_PLACEHOLDER)
        {
          localObject = c;
          continue;
        }
        if (this.k == ThreadListAdapter.LoadMoreState.LOAD_MORE)
        {
          localObject = d;
          continue;
        }
        localObject = e;
        continue;
      }
      localObject = null;
    }
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    int i1;
    if (localObject == a)
      i1 = 0;
    while (true)
    {
      return i1;
      if (localObject == b)
      {
        i1 = 2;
        continue;
      }
      if (localObject == c)
      {
        i1 = 4;
        continue;
      }
      if (localObject == d)
      {
        i1 = 5;
        continue;
      }
      if (localObject == e)
      {
        i1 = 6;
        continue;
      }
      if ((localObject instanceof ThreadSummary))
      {
        i1 = 1;
        continue;
      }
      i1 = -1;
    }
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = getItem(paramInt);
    if (localObject == null)
      throw new IllegalArgumentException("Null item");
    View localView;
    if (localObject == a)
      localView = a(paramView);
    while (true)
    {
      return localView;
      if (localObject == b)
      {
        localView = b(paramView);
        continue;
      }
      if (localObject == c)
      {
        localView = a(paramView, paramViewGroup);
        continue;
      }
      if (localObject == d)
      {
        localView = b(paramView, paramViewGroup);
        continue;
      }
      if (localObject == e)
      {
        localView = c(paramView, paramViewGroup);
        continue;
      }
      if (!(localObject instanceof ThreadSummary))
        break;
      localView = a((ThreadSummary)localObject, paramView);
    }
    throw new IllegalArgumentException("Unknown object type " + localObject.getClass());
  }

  public int getViewTypeCount()
  {
    return 7;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadListAdapter
 * JD-Core Version:    0.6.0
 */