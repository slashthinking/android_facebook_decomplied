package com.facebook.katana.activity.profilelist;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import com.facebook.katana.binding.ProfileImagesCache;
import java.util.Set;

class FriendSingleSelectorActivity$1 extends SelectableProfileListNaiveCursorAdapter
{
  public View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    View localView = super.a(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
    ((CheckBox)localView.findViewById(2131296491)).setVisibility(8);
    return localView;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.FriendSingleSelectorActivity.1
 * JD-Core Version:    0.6.0
 */