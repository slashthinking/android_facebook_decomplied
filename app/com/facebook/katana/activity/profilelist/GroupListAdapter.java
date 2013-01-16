package com.facebook.katana.activity.profilelist;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.util.DefaultTimeFormatUtil;
import com.facebook.common.util.TimeFormatUtil.TimeFormatStyle;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.ViewHolder;
import com.facebook.katana.binding.ProfileImagesCache;
import com.facebook.katana.model.FacebookGroup;
import java.util.List;

class GroupListAdapter extends ProfileListDynamicAdapter
{
  public GroupListAdapter(Context paramContext, ProfileImagesCache paramProfileImagesCache)
  {
    super(paramContext, paramProfileImagesCache);
  }

  public View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    FacebookGroup localFacebookGroup = (FacebookGroup)a(paramInt1, paramInt2);
    ViewHolder localViewHolder;
    label128: TextView localTextView2;
    int i;
    if (paramView == null)
    {
      paramView = this.b.inflate(2130903241, null);
      localViewHolder = new ViewHolder(paramView, 2131296492);
      this.i.add(localViewHolder);
      paramView.setTag(localViewHolder);
      localViewHolder.a(Long.valueOf(localFacebookGroup.mId));
      String str = localFacebookGroup.mImageUrl;
      if ((str == null) || (str.length() == 0))
        break label267;
      Bitmap localBitmap = this.c.a(this.a, localFacebookGroup.mId, str);
      if (localBitmap == null)
        break label254;
      localViewHolder.a.setImageBitmap(localBitmap);
      ((TextView)paramView.findViewById(2131297004)).setText(localFacebookGroup.mDisplayName);
      TextView localTextView1 = (TextView)paramView.findViewById(2131297005);
      Context localContext = this.a;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = DefaultTimeFormatUtil.a(this.a, TimeFormatUtil.TimeFormatStyle.STREAM_RELATIVE_STYLE, 1000L * localFacebookGroup.mUpdateTime);
      localTextView1.setText(localContext.getString(2131362971, arrayOfObject));
      localTextView2 = (TextView)paramView.findViewById(2131297006);
      i = localFacebookGroup.a();
      if (i != 0)
        break label280;
      localTextView2.setVisibility(8);
    }
    while (true)
    {
      return paramView;
      localViewHolder = (ViewHolder)paramView.getTag();
      break;
      label254: localViewHolder.a.setImageResource(2130838284);
      break label128;
      label267: localViewHolder.a.setImageResource(2130838284);
      break label128;
      label280: localTextView2.setText(Integer.toString(i));
      localTextView2.setVisibility(0);
    }
  }

  public void a(List<? extends FacebookProfile> paramList)
  {
    this.d = paramList;
    j();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.GroupListAdapter
 * JD-Core Version:    0.6.0
 */