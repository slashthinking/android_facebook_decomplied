package com.facebook.katana.activity.profilelist;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.ViewHolder;
import com.facebook.katana.binding.ProfileImagesCache;
import com.facebook.katana.model.FacebookGroup;
import java.util.List;

class GroupSelectorAdapter extends ProfileListDynamicAdapter
  implements Filterable
{
  private String f;
  private List<? extends FacebookProfile> g;
  private GroupSelectorAdapter.GroupFilter h = new GroupSelectorAdapter.GroupFilter(this, null);

  public GroupSelectorAdapter(Context paramContext, ProfileImagesCache paramProfileImagesCache)
  {
    super(paramContext, paramProfileImagesCache);
  }

  public View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    FacebookGroup localFacebookGroup = (FacebookGroup)a(paramInt1, paramInt2);
    ViewHolder localViewHolder;
    if (paramView == null)
    {
      paramView = this.b.inflate(2130903524, null);
      ((ViewStub)paramView.findViewById(2131297759)).inflate();
      localViewHolder = new ViewHolder(paramView, 2131296492);
      this.i.add(localViewHolder);
      paramView.setTag(localViewHolder);
      String str = localFacebookGroup.mIcon68;
      localViewHolder.a(Long.valueOf(localFacebookGroup.mId));
      if ((str == null) || (str.length() == 0))
        break label189;
      Bitmap localBitmap = this.c.a(this.a, localFacebookGroup.mId, str);
      if (localBitmap == null)
        break label176;
      localViewHolder.a.setImageBitmap(localBitmap);
    }
    while (true)
    {
      ((TextView)paramView.findViewById(2131297752)).setText(localFacebookGroup.mDisplayName);
      return paramView;
      localViewHolder = (ViewHolder)paramView.getTag();
      break;
      label176: localViewHolder.a.setImageResource(2130838284);
      continue;
      label189: localViewHolder.a.setImageResource(2130838284);
    }
  }

  public void a(List<? extends FacebookProfile> paramList)
  {
    this.g = paramList;
    this.h.filter(this.f);
    j();
  }

  public Filter getFilter()
  {
    return this.h;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.GroupSelectorAdapter
 * JD-Core Version:    0.6.0
 */