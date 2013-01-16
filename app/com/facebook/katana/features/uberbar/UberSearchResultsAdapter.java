package com.facebook.katana.features.uberbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.ipc.data.uberbar.UberbarResult;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Collections;
import java.util.List;
import javax.inject.Provider;

class UberSearchResultsAdapter extends BaseAdapter
{
  private static final Object a = new Object();
  private static final Object b = new Object();
  private final Provider<UberbarResultView> c;
  private final LayoutInflater d;
  private List<UberbarResult> e = Collections.emptyList();
  private UberSearchResultsAdapter.FetchStatus f;
  private UberbarResultView.CommunicationButtonListener g;
  private UberbarResultView.AddFriendButtonListener h;

  public UberSearchResultsAdapter(LayoutInflater paramLayoutInflater, Provider<UberbarResultView> paramProvider)
  {
    this.d = ((LayoutInflater)Preconditions.checkNotNull(paramLayoutInflater));
    this.f = UberSearchResultsAdapter.FetchStatus.NO_QUERY;
    this.c = paramProvider;
  }

  private View a(ViewGroup paramViewGroup)
  {
    return this.d.inflate(2130903612, paramViewGroup, false);
  }

  private UberSearchResultsAdapter.RowType a(int paramInt)
  {
    UberSearchResultsAdapter.RowType localRowType;
    if ((this.f == UberSearchResultsAdapter.FetchStatus.ONGOING) && (paramInt == this.e.size()))
      localRowType = UberSearchResultsAdapter.RowType.LOADING_MORE;
    while (true)
    {
      return localRowType;
      if ((this.f == UberSearchResultsAdapter.FetchStatus.COMPLETED) && (this.e.size() == 0))
      {
        localRowType = UberSearchResultsAdapter.RowType.NO_RESULTS;
        continue;
      }
      localRowType = UberSearchResultsAdapter.RowType.RESULT;
    }
  }

  private UberbarResultView a(View paramView)
  {
    UberbarResultView localUberbarResultView;
    if (paramView == null)
    {
      localUberbarResultView = (UberbarResultView)this.c.b();
      localUberbarResultView.a(this.g);
      localUberbarResultView.a(this.h);
    }
    while (true)
    {
      return localUberbarResultView;
      localUberbarResultView = (UberbarResultView)paramView;
    }
  }

  private View b(ViewGroup paramViewGroup)
  {
    return this.d.inflate(2130903613, paramViewGroup, false);
  }

  public List<UberbarResult> a()
  {
    return this.e;
  }

  public void a(UberbarResultView.AddFriendButtonListener paramAddFriendButtonListener)
  {
    this.h = paramAddFriendButtonListener;
  }

  public void a(UberbarResultView.CommunicationButtonListener paramCommunicationButtonListener)
  {
    this.g = paramCommunicationButtonListener;
  }

  public void a(List<UberbarResult> paramList)
  {
    a(paramList, this.f);
  }

  public void a(List<UberbarResult> paramList, UberSearchResultsAdapter.FetchStatus paramFetchStatus)
  {
    this.e = ImmutableList.a(paramList);
    this.f = paramFetchStatus;
    notifyDataSetChanged();
  }

  public int getCount()
  {
    int i;
    if (this.f == UberSearchResultsAdapter.FetchStatus.ONGOING)
      i = 1 + this.e.size();
    while (true)
    {
      return i;
      if ((this.f == UberSearchResultsAdapter.FetchStatus.COMPLETED) && (this.e.size() == 0))
      {
        i = 1;
        continue;
      }
      i = this.e.size();
    }
  }

  public Object getItem(int paramInt)
  {
    UberSearchResultsAdapter.RowType localRowType = a(paramInt);
    Object localObject;
    switch (UberSearchResultsAdapter.1.a[localRowType.ordinal()])
    {
    default:
      throw new IllegalStateException("Unexpected type");
    case 1:
      localObject = b;
    case 2:
    case 3:
    }
    while (true)
    {
      return localObject;
      localObject = a;
      continue;
      localObject = this.e.get(paramInt);
    }
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    return a(paramInt).ordinal();
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    UberSearchResultsAdapter.RowType localRowType = a(paramInt);
    if (localRowType == UberSearchResultsAdapter.RowType.LOADING_MORE)
      if (paramView == null)
        paramView = a(paramViewGroup);
    while (true)
    {
      return paramView;
      if (localRowType == UberSearchResultsAdapter.RowType.NO_RESULTS)
      {
        if (paramView != null)
          continue;
        paramView = b(paramViewGroup);
        continue;
      }
      UberbarResult localUberbarResult = (UberbarResult)getItem(paramInt);
      paramView = a(paramView);
      paramView.a(localUberbarResult);
    }
  }

  public int getViewTypeCount()
  {
    return UberSearchResultsAdapter.RowType.values().length;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberSearchResultsAdapter
 * JD-Core Version:    0.6.0
 */