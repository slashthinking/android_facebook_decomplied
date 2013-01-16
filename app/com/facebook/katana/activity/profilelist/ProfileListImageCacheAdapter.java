package com.facebook.katana.activity.profilelist;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.ViewHolder;
import com.facebook.katana.binding.ProfileImagesCache;
import java.util.ArrayList;
import java.util.List;

public abstract class ProfileListImageCacheAdapter extends ProfileListCursorAdapter
{
  protected final Context g;
  protected final LayoutInflater h;
  protected final ProfileImagesCache j;

  public ProfileListImageCacheAdapter(Context paramContext, ProfileImagesCache paramProfileImagesCache, Cursor paramCursor)
  {
    this.g = paramContext;
    this.h = LayoutInflater.from(paramContext);
    this.j = paramProfileImagesCache;
    this.i = new ArrayList();
    b(paramCursor);
  }

  public View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    FacebookProfile localFacebookProfile = (FacebookProfile)a(paramInt1, paramInt2);
    ViewHolder localViewHolder;
    if (paramView == null)
    {
      paramView = a(localFacebookProfile);
      localViewHolder = new ViewHolder(paramView, 2131296492);
      this.i.add(localViewHolder);
      paramView.setTag(localViewHolder);
      localViewHolder.a(Long.valueOf(localFacebookProfile.mId));
      String str = localFacebookProfile.mImageUrl;
      if ((str == null) || (str.length() == 0))
        break label171;
      Bitmap localBitmap = this.j.a(this.g, localFacebookProfile.mId, str);
      if (localBitmap == null)
        break label158;
      localViewHolder.a.setImageBitmap(localBitmap);
    }
    while (true)
    {
      ((TextView)paramView.findViewById(2131297752)).setText(localFacebookProfile.mDisplayName);
      return paramView;
      localViewHolder = (ViewHolder)paramView.getTag();
      break;
      label158: localViewHolder.a.setImageResource(2130838447);
      continue;
      label171: localViewHolder.a.setImageResource(2130838447);
    }
  }

  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null);
    for (View localView = this.h.inflate(2130903239, null); ; localView = paramView)
    {
      ((TextView)localView).setText(((ProfileListCursorAdapter.Section)this.f.get(paramInt)).c());
      return localView;
    }
  }

  protected View a(FacebookProfile paramFacebookProfile)
  {
    View localView = this.h.inflate(2130903524, null);
    ((ViewStub)localView.findViewById(2131297759)).inflate();
    return localView;
  }

  protected abstract Object a(Cursor paramCursor);

  protected abstract String a(Object paramObject);

  public void b(Cursor paramCursor)
  {
    this.e = paramCursor;
    this.f = new ArrayList();
    if (paramCursor == null);
    while (true)
    {
      return;
      Object localObject1 = null;
      int i = -1;
      int k = paramCursor.getCount();
      paramCursor.moveToFirst();
      int m = 0;
      int n = 0;
      if (m < k)
      {
        Object localObject2 = a(paramCursor);
        if (localObject2.equals(localObject1));
        while (true)
        {
          m++;
          n++;
          paramCursor.moveToNext();
          break;
          if (n > 0)
            this.f.add(new ProfileListCursorAdapter.Section(a(localObject1), i, n));
          i = m;
          localObject1 = localObject2;
          n = 0;
        }
      }
      if (n > 0)
        this.f.add(new ProfileListCursorAdapter.Section(a(localObject1), i, n));
      j();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.ProfileListImageCacheAdapter
 * JD-Core Version:    0.6.0
 */