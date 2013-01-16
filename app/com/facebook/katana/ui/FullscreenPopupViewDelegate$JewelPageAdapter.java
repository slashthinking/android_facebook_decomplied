package com.facebook.katana.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;
import com.facebook.common.util.Log;
import com.facebook.katana.fragment.NotificationsFragment;
import com.facebook.katana.friendrequests.FriendRequestsFragment;
import com.facebook.orca.threadlist.ThreadListFragment;
import com.google.common.base.Preconditions;

class FullscreenPopupViewDelegate$JewelPageAdapter extends FragmentPagerAdapter
{
  private FragmentManager b;
  private FriendRequestsFragment c;
  private Fragment d;
  private Fragment e;
  private FragmentTransaction f = null;
  private Fragment g = null;
  private final FragmentActivity h;

  public FullscreenPopupViewDelegate$JewelPageAdapter(FullscreenPopupViewDelegate paramFullscreenPopupViewDelegate, FragmentManager paramFragmentManager, FragmentActivity paramFragmentActivity)
  {
    super(paramFragmentManager);
    this.b = ((FragmentManager)Preconditions.checkNotNull(paramFragmentManager));
    this.h = ((FragmentActivity)Preconditions.checkNotNull(paramFragmentActivity));
  }

  private String a(int paramInt, long paramLong)
  {
    return "android:switcher:" + paramInt + ":" + paramLong;
  }

  private void a(int paramInt, Fragment paramFragment)
  {
    if (PopupViewDelegate.PopupState.NOTIFICATIONS.ordinal() == paramInt)
      this.e = paramFragment;
    while (true)
    {
      return;
      if (PopupViewDelegate.PopupState.MESSAGES.ordinal() == paramInt)
      {
        this.d = paramFragment;
        continue;
      }
      if (PopupViewDelegate.PopupState.FRIEND_REQUESTS.ordinal() != paramInt)
        break;
      if (!(paramFragment instanceof FriendRequestsFragment))
        throw new RuntimeException("Tried to put a fragment of type " + paramFragment.getClass().getCanonicalName() + " into the spot reserved for the friend list fragment");
      this.c = ((FriendRequestsFragment)paramFragment);
    }
    throw new IllegalStateException("Cannot save fragment at position " + paramInt);
  }

  public int a(Object paramObject)
  {
    if ((paramObject == this.e) || (paramObject == this.d) || (paramObject == this.c));
    for (int i = -1; ; i = -2)
      return i;
  }

  public Fragment a(int paramInt)
  {
    Object localObject;
    if (PopupViewDelegate.PopupState.NOTIFICATIONS.ordinal() == paramInt)
      localObject = new NotificationsFragment();
    while (true)
    {
      return localObject;
      if (PopupViewDelegate.PopupState.MESSAGES.ordinal() == paramInt)
      {
        localObject = this.a.a(this.h);
        continue;
      }
      if (PopupViewDelegate.PopupState.FRIEND_REQUESTS.ordinal() != paramInt)
        break;
      localObject = new FriendRequestsFragment();
    }
    throw new IllegalStateException("Jewel View Pager cannot view page with index " + paramInt);
  }

  public Object a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.f == null)
      this.f = this.b.a();
    long l = b(paramInt);
    String str = a(paramViewGroup.getId(), l);
    Fragment localFragment = this.b.a(str);
    if (localFragment != null)
    {
      if (!localFragment.t())
        this.f.d(localFragment);
      this.f.e(localFragment);
      if ((localFragment instanceof ThreadListFragment))
        this.a.a((ThreadListFragment)localFragment);
    }
    while (true)
    {
      a(paramInt, localFragment);
      if (localFragment != this.g)
      {
        localFragment.g(false);
        localFragment.h(false);
      }
      return localFragment;
      localFragment = a(paramInt);
      this.f.a(paramViewGroup.getId(), localFragment, a(paramViewGroup.getId(), l));
    }
  }

  public void a(FragmentActivity paramFragmentActivity, Fragment paramFragment)
  {
    if (paramFragment != this.d)
    {
      paramFragmentActivity.g().a().a(this.d).b();
      this.d = paramFragment;
    }
  }

  public void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (this.f == null)
      this.f = this.b.a();
    this.f.d((Fragment)paramObject);
  }

  public int b()
  {
    return -1 + PopupViewDelegate.PopupState.values().length;
  }

  public void b(ViewGroup paramViewGroup)
  {
    if (this.f != null)
    {
      this.f.b();
      this.f = null;
      this.b.b();
    }
  }

  public void b(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    Fragment localFragment = (Fragment)paramObject;
    if (localFragment != this.g)
    {
      if (this.g != null)
      {
        this.g.g(false);
        this.g.h(false);
      }
      if (localFragment != null)
      {
        localFragment.g(true);
        localFragment.h(true);
      }
      this.g = localFragment;
    }
  }

  public Fragment d()
  {
    return this.g;
  }

  public void e()
  {
    if (this.c == null)
      Log.a(FullscreenPopupViewDelegate.b(this.a), "Trying to refresh null friends fragment");
    while (true)
    {
      return;
      this.c.a(false);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.FullscreenPopupViewDelegate.JewelPageAdapter
 * JD-Core Version:    0.6.0
 */