package com.facebook.katana.activity.profilelist;

import android.content.Context;
import android.database.Cursor;
import android.widget.Filter;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.binding.ProfileImagesCache;
import java.util.ArrayList;
import java.util.List;

public class ProfileListNaiveCursorAdapter extends ProfileListImageCacheAdapter
{
  public final Filter k = new ProfileListNaiveCursorAdapter.1(this);

  public ProfileListNaiveCursorAdapter(Context paramContext, ProfileImagesCache paramProfileImagesCache, Cursor paramCursor)
  {
    super(paramContext, paramProfileImagesCache, paramCursor);
  }

  public Object a(int paramInt1, int paramInt2)
  {
    this.e.moveToPosition(d(paramInt1, paramInt2));
    return new FacebookProfile(this.e.getLong(this.e.getColumnIndex("user_id")), this.e.getString(this.e.getColumnIndex("display_name")), this.e.getString(this.e.getColumnIndex("user_image_url")), 0);
  }

  protected Object a(Cursor paramCursor)
  {
    return paramCursor.getString(paramCursor.getColumnIndex("display_name")).substring(0, 1);
  }

  protected String a(Object paramObject)
  {
    return (String)paramObject;
  }

  public void b(Cursor paramCursor)
  {
    this.e = paramCursor;
    this.f = new ArrayList();
    if (paramCursor == null);
    while (true)
    {
      return;
      Object localObject = "";
      int i = -1;
      int j = paramCursor.getCount();
      int m = paramCursor.getColumnIndex("display_name");
      paramCursor.moveToFirst();
      int n = 0;
      int i1 = 0;
      if (n < j)
      {
        String str = paramCursor.getString(m).substring(0, 1);
        if (((String)localObject).equals(str));
        while (true)
        {
          n++;
          i1++;
          paramCursor.moveToNext();
          break;
          if (i1 > 0)
            this.f.add(new ProfileListCursorAdapter.Section((String)localObject, i, i1));
          i = n;
          localObject = str;
          i1 = 0;
        }
      }
      if (i1 > 0)
        this.f.add(new ProfileListCursorAdapter.Section((String)localObject, i, i1));
      j();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.ProfileListNaiveCursorAdapter
 * JD-Core Version:    0.6.0
 */