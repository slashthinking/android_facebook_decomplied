package com.facebook.katana.friendrequests;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.friends.FriendRequestState;
import com.facebook.friends.model.FriendRequest;
import com.facebook.friends.model.PersonYouMayKnow;
import com.facebook.graphql.model.GraphQLProfile;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Provider;

class FriendRequestsAdapter extends BaseAdapter
{
  private static final Object b = new Object();
  private static final Object c = new Object();
  private static final Object d = new Object();
  private final boolean a;
  private boolean e = false;
  private final List<FriendRequest> f = Lists.a();
  private final Provider<FriendRequestView> g;
  private final List<PersonYouMayKnow> h;
  private final Provider<PersonYouMayKnowView> i;
  private final FriendRequestView.OnResponseListener j;
  private final FriendRequestView.OnRequestListener k;
  private final FriendRequestView.OnIgnoreListener l;
  private final PersonYouMayKnowView.OnResponseListener m;

  FriendRequestsAdapter(Provider<FriendRequestView> paramProvider, Provider<PersonYouMayKnowView> paramProvider1, boolean paramBoolean, FriendRequestView.OnResponseListener paramOnResponseListener, FriendRequestView.OnRequestListener paramOnRequestListener, FriendRequestView.OnIgnoreListener paramOnIgnoreListener, PersonYouMayKnowView.OnResponseListener paramOnResponseListener1)
  {
    this.a = paramBoolean;
    this.h = Lists.a();
    this.g = paramProvider;
    this.i = paramProvider1;
    this.j = paramOnResponseListener;
    this.k = paramOnRequestListener;
    this.l = paramOnIgnoreListener;
    this.m = paramOnResponseListener1;
  }

  private int a(FriendRequestsAdapter.RowType paramRowType)
  {
    int n = 1;
    int i1 = FriendRequestsAdapter.1.a[paramRowType.ordinal()];
    int i2 = 0;
    switch (i1)
    {
    default:
      throw new IllegalArgumentException("Unexpected RowType type");
    case 1:
      Preconditions.checkState(this.f.isEmpty());
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      return i2;
      boolean bool1 = this.h.isEmpty();
      boolean bool2 = false;
      if (!bool1)
        bool2 = n;
      Preconditions.checkState(bool2);
      if (this.f.isEmpty());
      while (true)
      {
        i2 = n;
        break;
        n = this.f.size();
      }
      i2 = 1 + a(FriendRequestsAdapter.RowType.PYMK_HEADER);
      continue;
      Preconditions.checkState(c());
      i2 = -1 + getCount();
    }
  }

  private int a(String paramString)
  {
    int n = 0;
    if (n < this.f.size())
      if (((FriendRequest)this.f.get(n)).profile.id != paramString);
    while (true)
    {
      return n;
      n++;
      break;
      n = -1;
    }
  }

  private View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903234, paramViewGroup, false);
  }

  private PersonYouMayKnowView a(View paramView)
  {
    if (paramView != null);
    PersonYouMayKnowView localPersonYouMayKnowView;
    for (Object localObject = (PersonYouMayKnowView)paramView; ; localObject = localPersonYouMayKnowView)
    {
      return localObject;
      localPersonYouMayKnowView = (PersonYouMayKnowView)this.i.b();
      localPersonYouMayKnowView.setOnResponseListener(this.m);
    }
  }

  private void a(long paramLong, boolean paramBoolean)
  {
    int n = c(paramLong);
    if (n == -1);
    while (true)
    {
      return;
      this.h.set(n, ((PersonYouMayKnow)this.h.get(n)).a(paramBoolean));
      notifyDataSetChanged();
    }
  }

  private View b(ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    if (this.a);
    for (int n = 2130903299; ; n = 2130903298)
      return localLayoutInflater.inflate(n, paramViewGroup, false);
  }

  private FriendRequestView b(View paramView)
  {
    if (paramView != null);
    FriendRequestView localFriendRequestView;
    for (Object localObject = (FriendRequestView)paramView; ; localObject = localFriendRequestView)
    {
      return localObject;
      localFriendRequestView = (FriendRequestView)this.g.b();
      localFriendRequestView.setOnResponseListener(this.j);
      localFriendRequestView.setOnRequestListener(this.k);
      localFriendRequestView.setOnIgnoreListener(this.l);
    }
  }

  private FriendRequestsAdapter.RowType b(int paramInt)
  {
    FriendRequestsAdapter.RowType localRowType;
    if ((c()) && (paramInt == -1 + getCount()))
      localRowType = FriendRequestsAdapter.RowType.LOAD_MORE;
    while (true)
    {
      return localRowType;
      if ((d()) && (paramInt == 0))
      {
        localRowType = FriendRequestsAdapter.RowType.NO_REQUESTS;
        continue;
      }
      if (d());
      int i1;
      for (int n = -1; ; n = 0)
      {
        i1 = n + paramInt;
        if (i1 >= this.f.size())
          break label83;
        localRowType = FriendRequestsAdapter.RowType.FRIEND_REQUEST;
        break;
      }
      label83: if (i1 == this.f.size())
      {
        localRowType = FriendRequestsAdapter.RowType.PYMK_HEADER;
        continue;
      }
      localRowType = FriendRequestsAdapter.RowType.PERSON_YOU_MAY_KNOW;
    }
  }

  private int c(long paramLong)
  {
    int n = 0;
    if (n < this.h.size())
      if (((PersonYouMayKnow)this.h.get(n)).userId != paramLong);
    while (true)
    {
      return n;
      n++;
      break;
      n = -1;
    }
  }

  private boolean c()
  {
    if ((!this.e) && ((!this.f.isEmpty()) || (!this.h.isEmpty())));
    for (int n = 1; ; n = 0)
      return n;
  }

  private boolean d()
  {
    if ((this.f.isEmpty()) && (!this.h.isEmpty()));
    for (int n = 1; ; n = 0)
      return n;
  }

  public View a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    View localView1;
    View localView2;
    int n;
    if (this.a)
    {
      localView1 = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903478, paramViewGroup, false);
      localView2 = localView1.findViewById(2131297668);
      n = 0;
      if (!paramBoolean)
        break label64;
    }
    while (true)
    {
      localView2.setVisibility(n);
      return localView1;
      localView1 = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903477, paramViewGroup, false);
      break;
      label64: n = 8;
    }
  }

  public void a()
  {
    this.f.clear();
    this.h.clear();
  }

  public void a(long paramLong)
  {
    a(paramLong, true);
  }

  public void a(String paramString, FriendRequestState paramFriendRequestState)
  {
    int n = a(paramString);
    if (n == -1);
    while (true)
    {
      return;
      this.f.set(n, ((FriendRequest)this.f.get(n)).a(paramFriendRequestState));
      notifyDataSetChanged();
    }
  }

  public void a(List<FriendRequest> paramList)
  {
    this.f.addAll(paramList);
    notifyDataSetChanged();
  }

  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }

  public boolean a(int paramInt)
  {
    int n = 1;
    int i1;
    if ((getCount() > 0) && (!this.h.isEmpty()))
      if (this.f.isEmpty())
      {
        i1 = n;
        if (paramInt < i1)
          break label55;
      }
    while (true)
    {
      return n;
      i1 = this.f.size();
      break;
      label55: n = 0;
    }
  }

  public int b()
  {
    return this.h.size();
  }

  public void b(long paramLong)
  {
    a(paramLong, false);
  }

  public void b(List<PersonYouMayKnow> paramList)
  {
    this.h.addAll(paramList);
    notifyDataSetChanged();
  }

  public int getCount()
  {
    int n = 1;
    int i1;
    int i3;
    label38: int i4;
    if (d())
    {
      i1 = n;
      int i2 = i1 + this.f.size();
      if (this.h.isEmpty())
        break label71;
      i3 = n;
      i4 = i3 + i2 + this.h.size();
      if (!c())
        break label77;
    }
    while (true)
    {
      return i4 + n;
      i1 = 0;
      break;
      label71: i3 = 0;
      break label38;
      label77: n = 0;
    }
  }

  public Object getItem(int paramInt)
  {
    FriendRequestsAdapter.RowType localRowType = b(paramInt);
    int n = paramInt - a(localRowType);
    Object localObject;
    switch (FriendRequestsAdapter.1.a[localRowType.ordinal()])
    {
    default:
      throw new IllegalStateException("Unexpected type");
    case 1:
      localObject = d;
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      return localObject;
      localObject = this.f.get(n);
      continue;
      localObject = c;
      continue;
      localObject = this.h.get(n);
      continue;
      localObject = b;
    }
  }

  public long getItemId(int paramInt)
  {
    FriendRequestsAdapter.RowType localRowType = b(paramInt);
    int n = paramInt - a(localRowType);
    long l1;
    switch (FriendRequestsAdapter.1.a[localRowType.ordinal()])
    {
    default:
      throw new IllegalStateException("Unexpected type");
    case 1:
      l1 = -3L;
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      return l1;
      l1 = Long.valueOf(((FriendRequest)this.f.get(n)).profile.id).longValue();
      continue;
      l1 = -1L;
      continue;
      l1 = ((PersonYouMayKnow)this.h.get(n)).userId;
      continue;
      l1 = -2L;
    }
  }

  public int getItemViewType(int paramInt)
  {
    return b(paramInt).ordinal();
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool1 = true;
    FriendRequestsAdapter.RowType localRowType = b(paramInt);
    switch (FriendRequestsAdapter.1.a[localRowType.ordinal()])
    {
    default:
      throw new IllegalStateException("Unexpected type");
    case 1:
      if (paramView == null)
        break;
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      return paramView;
      paramView = b(paramViewGroup);
      continue;
      paramView = b(paramView);
      boolean bool2;
      if (b(paramInt + 1) != FriendRequestsAdapter.RowType.PYMK_HEADER)
      {
        bool2 = bool1;
        label100: paramView.setShowDivider(bool2);
        if (paramInt != 0)
          break label137;
      }
      while (true)
      {
        paramView.setFirst(bool1);
        paramView.a((FriendRequest)getItem(paramInt));
        break;
        bool2 = false;
        break label100;
        label137: bool1 = false;
      }
      if (paramView != null)
        continue;
      paramView = a(paramViewGroup, false);
      continue;
      paramView = a(paramView);
      paramView.a((PersonYouMayKnow)getItem(paramInt));
      continue;
      if (paramView != null)
        continue;
      paramView = a(paramViewGroup);
    }
  }

  public int getViewTypeCount()
  {
    return FriendRequestsAdapter.RowType.values().length;
  }

  public boolean isEnabled(int paramInt)
  {
    FriendRequestsAdapter.RowType localRowType = b(paramInt);
    if ((localRowType == FriendRequestsAdapter.RowType.FRIEND_REQUEST) || (localRowType == FriendRequestsAdapter.RowType.PERSON_YOU_MAY_KNOW));
    for (int n = 1; ; n = 0)
      return n;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.friendrequests.FriendRequestsAdapter
 * JD-Core Version:    0.6.0
 */