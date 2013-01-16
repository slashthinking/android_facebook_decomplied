package com.facebook.katana;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.binding.ProfileImagesCache;
import com.facebook.katana.model.FacebookSessionInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RequestsAdapter extends BaseAdapter
{
  boolean a;
  private Context b;
  private ArrayList<RequestsAdapter.FriendRequest> c;
  private AppSession d;
  private Map<Long, RequestsAdapter.FriendRequest> e = new HashMap();
  private AppSessionListener f = new RequestsAdapter.1(this);

  public RequestsAdapter(Context paramContext, AppSession paramAppSession, Map<Long, FacebookUser> paramMap)
  {
    this.b = paramContext;
    this.d = paramAppSession;
    this.a = false;
    this.d.a(this.f);
    a(paramMap);
  }

  public void a()
  {
    this.d.b(this.f);
  }

  public void a(Map<Long, FacebookUser> paramMap)
  {
    this.c = new ArrayList(paramMap.size());
    Iterator localIterator1 = paramMap.values().iterator();
    while (localIterator1.hasNext())
    {
      FacebookUser localFacebookUser2 = (FacebookUser)localIterator1.next();
      RequestsAdapter.FriendRequest localFriendRequest = new RequestsAdapter.FriendRequest(this, localFacebookUser2);
      this.c.add(localFriendRequest);
      this.e.put(Long.valueOf(localFacebookUser2.mUserId), localFriendRequest);
    }
    this.d.b(this.b, this.d.b().userId);
    ProfileImagesCache localProfileImagesCache = this.d.j();
    Iterator localIterator2 = paramMap.values().iterator();
    while (localIterator2.hasNext())
    {
      FacebookUser localFacebookUser1 = (FacebookUser)localIterator2.next();
      ((RequestsAdapter.FriendRequest)this.e.get(Long.valueOf(localFacebookUser1.mUserId))).d = localProfileImagesCache.a(this.b, localFacebookUser1.mUserId, localFacebookUser1.mImageUrl);
    }
  }

  public boolean areAllItemsEnabled()
  {
    return true;
  }

  public int getCount()
  {
    return this.c.size();
  }

  public Object getItem(int paramInt)
  {
    return ((RequestsAdapter.FriendRequest)this.c.get(paramInt)).b;
  }

  public long getItemId(int paramInt)
  {
    return ((RequestsAdapter.FriendRequest)this.c.get(paramInt)).b.mUserId;
  }

  public int getItemViewType(int paramInt)
  {
    return 0;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    RequestsAdapter.FriendRequest localFriendRequest = (RequestsAdapter.FriendRequest)this.c.get(paramInt);
    if (localFriendRequest.e == null)
      localFriendRequest.e = ((LayoutInflater)this.b.getSystemService("layout_inflater")).inflate(2130903538, null);
    localFriendRequest.b();
    return localFriendRequest.e;
  }

  public int getViewTypeCount()
  {
    return 1;
  }

  public boolean hasStableIds()
  {
    return true;
  }

  public boolean isEmpty()
  {
    return this.c.isEmpty();
  }

  public boolean isEnabled(int paramInt)
  {
    if (this.c.get(paramInt) != null);
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.RequestsAdapter
 * JD-Core Version:    0.6.0
 */