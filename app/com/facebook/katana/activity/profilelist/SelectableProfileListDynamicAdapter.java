package com.facebook.katana.activity.profilelist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.binding.ProfileImagesCache;
import java.util.List;

public class SelectableProfileListDynamicAdapter extends ProfileListDynamicAdapter
{
  private CheckBoxViewAdapter<FacebookProfile> f;

  public SelectableProfileListDynamicAdapter(Context paramContext, ProfileImagesCache paramProfileImagesCache, List<FacebookProfile> paramList)
  {
    super(paramContext, paramProfileImagesCache);
    this.f = new CheckBoxViewAdapter(paramList);
  }

  public View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    View localView = super.a(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
    this.f.a(localView, (FacebookProfile)a(paramInt1, paramInt2));
    return localView;
  }

  protected View a(FacebookProfile paramFacebookProfile)
  {
    return this.f.a(super.a(paramFacebookProfile));
  }

  void a(int paramInt, View paramView)
  {
    this.f.a((FacebookProfile)e(paramInt), paramView);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.SelectableProfileListDynamicAdapter
 * JD-Core Version:    0.6.0
 */