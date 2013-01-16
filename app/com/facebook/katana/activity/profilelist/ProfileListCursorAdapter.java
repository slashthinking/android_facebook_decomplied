package com.facebook.katana.activity.profilelist;

import android.database.Cursor;
import java.util.List;

public abstract class ProfileListCursorAdapter extends ProfileListActivity.ProfileListAdapter
{
  protected Cursor e;
  protected List<ProfileListCursorAdapter.Section> f;

  public int a(int paramInt)
  {
    return 0;
  }

  public int b(int paramInt)
  {
    return ((ProfileListCursorAdapter.Section)this.f.get(paramInt)).b();
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
    return this.f.get(paramInt);
  }

  public boolean c(int paramInt1, int paramInt2)
  {
    return true;
  }

  protected int d(int paramInt1, int paramInt2)
  {
    return paramInt2 + ((ProfileListCursorAdapter.Section)this.f.get(paramInt1)).a();
  }

  public boolean d()
  {
    return false;
  }

  public int d_()
  {
    return this.f.size();
  }

  public Cursor e()
  {
    return this.e;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.ProfileListCursorAdapter
 * JD-Core Version:    0.6.0
 */