package com.facebook.katana;

import android.content.Context;
import android.database.Cursor;
import android.database.MergeCursor;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.activity.profilelist.ProfileListCursorAdapter.Section;
import com.facebook.katana.binding.ProfileImagesCache;
import java.util.List;

public class FriendsActivity$FriendsAndUserSearchAdapter extends FriendsAdapter
{
  Cursor a;
  Cursor b;
  boolean c;

  public FriendsActivity$FriendsAndUserSearchAdapter(FriendsActivity paramFriendsActivity, Context paramContext, ProfileImagesCache paramProfileImagesCache, Cursor paramCursor)
  {
    super(paramContext, paramProfileImagesCache, paramCursor);
    this.a = paramCursor;
    this.c = false;
  }

  public Object a(int paramInt1, int paramInt2)
  {
    int i = paramInt2 + ((ProfileListCursorAdapter.Section)this.f.get(paramInt1)).a();
    this.e.moveToPosition(i);
    if (this.e.getCount() < 1);
    for (FacebookProfile localFacebookProfile = null; ; localFacebookProfile = new FacebookProfile(this.e.getLong(this.e.getColumnIndex("user_id")), this.e.getString(this.e.getColumnIndex("display_name")), this.e.getString(this.e.getColumnIndex("user_image_url")), 0))
      return localFacebookProfile;
  }

  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    a_(this.b);
  }

  public void a_(Cursor paramCursor)
  {
    monitorenter;
    while (true)
    {
      try
      {
        if ((this.f == null) || (this.f.size() <= 0) || (!((ProfileListCursorAdapter.Section)this.f.get(-1 + this.f.size()) instanceof FriendsActivity.EveryoneSection)))
          continue;
        this.f.remove(-1 + this.f.size());
        this.b = paramCursor;
        if ((this.c) && (paramCursor != null) && (paramCursor.getCount() != 0))
          continue;
        this.e = this.a;
        j();
        return;
        if (this.a == null)
        {
          j = 0;
          Cursor[] arrayOfCursor = new Cursor[2];
          arrayOfCursor[0] = this.a;
          arrayOfCursor[1] = paramCursor;
          this.e = new MergeCursor(arrayOfCursor);
          this.f.add(new FriendsActivity.EveryoneSection(this.d, j, paramCursor.getCount()));
          j();
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      int i = this.a.getCount();
      int j = i;
    }
  }

  public void b(Cursor paramCursor)
  {
    monitorenter;
    try
    {
      this.a = paramCursor;
      super.b(paramCursor);
      a_(this.b);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.FriendsActivity.FriendsAndUserSearchAdapter
 * JD-Core Version:    0.6.0
 */