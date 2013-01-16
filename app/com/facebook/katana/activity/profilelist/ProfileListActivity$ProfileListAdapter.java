package com.facebook.katana.activity.profilelist;

import android.widget.ImageView;
import com.facebook.katana.ViewHolder;
import com.facebook.katana.binding.ProfileImage;
import com.facebook.katana.ui.SectionedListAdapter;
import java.util.Iterator;
import java.util.List;

public abstract class ProfileListActivity$ProfileListAdapter extends SectionedListAdapter
{
  protected List<ViewHolder<Long>> i;

  public void a(ProfileImage paramProfileImage)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      ViewHolder localViewHolder = (ViewHolder)localIterator.next();
      Long localLong = (Long)localViewHolder.a();
      if ((localLong == null) || (!localLong.equals(Long.valueOf(paramProfileImage.a))))
        continue;
      localViewHolder.a.setImageBitmap(paramProfileImage.c());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.ProfileListActivity.ProfileListAdapter
 * JD-Core Version:    0.6.0
 */