package com.facebook.katana;

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
import com.facebook.katana.activity.profilelist.ProfileListCursorAdapter;
import com.facebook.katana.activity.profilelist.ProfileListCursorAdapter.Section;
import com.facebook.katana.binding.StreamPhotosCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ProfileSearchResultsAdapter extends ProfileListCursorAdapter
{
  protected final Context a;
  protected final StreamPhotosCache b;
  protected final LayoutInflater c;
  private final List<ViewHolder<String>> d;

  public ProfileSearchResultsAdapter(Context paramContext, Cursor paramCursor, StreamPhotosCache paramStreamPhotosCache)
  {
    this.a = paramContext;
    this.b = paramStreamPhotosCache;
    this.c = LayoutInflater.from(paramContext);
    this.f = new ArrayList();
    this.d = new ArrayList();
    a(paramCursor);
  }

  public View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    FacebookProfile localFacebookProfile = (FacebookProfile)a(paramInt1, paramInt2);
    ViewHolder localViewHolder;
    if (paramView == null)
    {
      paramView = a(localFacebookProfile);
      localViewHolder = new ViewHolder(paramView, 2131296492);
      this.d.add(localViewHolder);
      paramView.setTag(localViewHolder);
      String str = localFacebookProfile.mImageUrl;
      localViewHolder.a(str);
      if ((str == null) || (str.length() == 0))
        break label161;
      Bitmap localBitmap = this.b.a(this.a, str, 2);
      if (localBitmap == null)
        break label148;
      localViewHolder.a.setImageBitmap(localBitmap);
    }
    while (true)
    {
      ((TextView)paramView.findViewById(2131297752)).setText(localFacebookProfile.mDisplayName);
      return paramView;
      localViewHolder = (ViewHolder)paramView.getTag();
      break;
      label148: localViewHolder.a.setImageResource(2130838447);
      continue;
      label161: localViewHolder.a.setImageResource(2130838447);
    }
  }

  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (((ProfileListCursorAdapter.Section)this.f.get(paramInt)).c() == null)
    {
      localView = new View(this.a);
      return localView;
    }
    if (paramView == null);
    for (View localView = this.c.inflate(2130903239, null); ; localView = paramView)
    {
      ((TextView)localView).setText(((ProfileListCursorAdapter.Section)this.f.get(paramInt)).c());
      break;
    }
  }

  protected View a(FacebookProfile paramFacebookProfile)
  {
    View localView = this.c.inflate(2130903524, null);
    ((ViewStub)localView.findViewById(2131297759)).inflate();
    return localView;
  }

  public abstract void a(Cursor paramCursor);

  public void a(Bitmap paramBitmap, String paramString)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      ViewHolder localViewHolder = (ViewHolder)localIterator.next();
      String str = (String)localViewHolder.a();
      if ((str == null) || (!str.equals(paramString)))
        continue;
      localViewHolder.a.setImageBitmap(paramBitmap);
    }
  }

  public int b()
  {
    if (e() == null);
    for (int i = 0; ; i = e().getCount())
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ProfileSearchResultsAdapter
 * JD-Core Version:    0.6.0
 */