package com.facebook.katana;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.activity.profilelist.ProfileListNaiveCursorAdapter;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.ProfileImagesCache;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.platform.PlatformFastTrack;

public class FriendsAdapter extends ProfileListNaiveCursorAdapter
{
  public FriendsAdapter(Context paramContext, ProfileImagesCache paramProfileImagesCache, Cursor paramCursor)
  {
    super(paramContext, paramProfileImagesCache, paramCursor);
  }

  public View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    View localView = super.a(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
    if (PlatformFastTrack.a(this.g))
    {
      FacebookProfile localFacebookProfile = (FacebookProfile)a(paramInt1, paramInt2);
      PlatformFastTrack.a(localView.findViewById(2131296492), AppSession.a(this.g, false).b().username, localFacebookProfile.mId, new String[] { "vnd.android.cursor.item/vnd.facebook.profile" });
    }
    return localView;
  }

  protected View a(FacebookProfile paramFacebookProfile)
  {
    if (!PlatformFastTrack.a(this.g));
    View localView;
    for (Object localObject = super.a(paramFacebookProfile); ; localObject = localView)
    {
      return localObject;
      localView = this.h.inflate(2130903524, null);
      ((ViewStub)localView.findViewById(2131297760)).inflate();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.FriendsAdapter
 * JD-Core Version:    0.6.0
 */