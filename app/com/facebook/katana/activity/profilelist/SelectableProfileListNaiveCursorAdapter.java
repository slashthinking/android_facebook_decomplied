package com.facebook.katana.activity.profilelist;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.binding.ProfileImagesCache;
import java.util.Set;

public class SelectableProfileListNaiveCursorAdapter extends ProfileListNaiveCursorAdapter
{
  private CheckBoxViewAdapter<Long> a;

  public SelectableProfileListNaiveCursorAdapter(Context paramContext, ProfileImagesCache paramProfileImagesCache, Cursor paramCursor, Set<Long> paramSet)
  {
    super(paramContext, paramProfileImagesCache, paramCursor);
    this.a = new CheckBoxViewAdapter(paramSet);
  }

  public View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    View localView = super.a(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
    FacebookProfile localFacebookProfile = (FacebookProfile)a(paramInt1, paramInt2);
    this.a.a(localView, Long.valueOf(localFacebookProfile.mId));
    return localView;
  }

  protected View a(FacebookProfile paramFacebookProfile)
  {
    return this.a.a(super.a(paramFacebookProfile));
  }

  void a(int paramInt, View paramView)
  {
    FacebookProfile localFacebookProfile = (FacebookProfile)e(paramInt);
    this.a.a(Long.valueOf(localFacebookProfile.mId), paramView);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.SelectableProfileListNaiveCursorAdapter
 * JD-Core Version:    0.6.0
 */