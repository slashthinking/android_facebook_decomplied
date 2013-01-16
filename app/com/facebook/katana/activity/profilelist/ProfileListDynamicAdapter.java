package com.facebook.katana.activity.profilelist;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.debug.Assert;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.ViewHolder;
import com.facebook.katana.binding.ProfileImagesCache;
import java.util.ArrayList;
import java.util.List;

public class ProfileListDynamicAdapter extends ProfileListActivity.ProfileListAdapter
{
  protected final Context a;
  protected final LayoutInflater b;
  protected final ProfileImagesCache c;
  protected List<? extends FacebookProfile> d;
  protected AsyncTask<List<? extends FacebookProfile>, Integer, List<? extends FacebookProfile>> e;

  public ProfileListDynamicAdapter(Context paramContext, ProfileImagesCache paramProfileImagesCache)
  {
    this.a = paramContext;
    this.b = LayoutInflater.from(paramContext);
    this.c = paramProfileImagesCache;
    this.i = new ArrayList();
  }

  public int a(int paramInt)
  {
    return 0;
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
      Bitmap localBitmap = this.c.a(this.a, localFacebookProfile.mId, str);
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
    if (paramView == null)
      paramView = new View(this.a);
    return paramView;
  }

  protected View a(FacebookProfile paramFacebookProfile)
  {
    View localView = this.b.inflate(2130903524, null);
    ((ViewStub)localView.findViewById(2131297759)).inflate();
    return localView;
  }

  public Object a(int paramInt1, int paramInt2)
  {
    Assert.a(0, paramInt1);
    return this.d.get(paramInt2);
  }

  public void a(List<? extends FacebookProfile> paramList)
  {
    this.e = new ProfileListDynamicAdapter.SortProfilesTask(this, null);
    this.e.execute(new List[] { paramList });
  }

  public int b(int paramInt)
  {
    Assert.a(0, paramInt);
    return this.d.size();
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
    return null;
  }

  public boolean c(int paramInt1, int paramInt2)
  {
    return true;
  }

  public boolean d()
  {
    if ((this.d == null) || (this.d.size() == 0));
    for (int i = 1; ; i = 0)
      return i;
  }

  public int d_()
  {
    return 1;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.ProfileListDynamicAdapter
 * JD-Core Version:    0.6.0
 */