package com.facebook.katana.activity.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.katana.ViewHolder;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.ProfileImage;
import com.facebook.katana.binding.ProfileImagesCache;

public class DropdownTagUsersAdapter extends ArrayAdapter<UserHolder>
{
  private final Context a;
  private AppSession b;
  private final ProfileImagesCache c;
  private DropdownTagUsersAdapter.DropdownAppSessionListener d;
  private final Filter e;

  public DropdownTagUsersAdapter(Context paramContext, ProfileImagesCache paramProfileImagesCache)
  {
    super(paramContext, 2130903558);
    this.a = paramContext;
    this.c = paramProfileImagesCache;
    this.e = new DropdownTagUsersAdapter.1(this);
    this.b = AppSession.a(paramContext, false);
    this.d = new DropdownTagUsersAdapter.DropdownAppSessionListener(this);
    if (this.b != null)
      this.b.a(this.d);
  }

  public void a()
  {
    if (this.b != null)
      this.b.b(this.d);
  }

  protected void a(ProfileImage paramProfileImage)
  {
    for (int i = 0; i < getCount(); i++)
    {
      UserHolder localUserHolder = (UserHolder)getItem(i);
      Long localLong = Long.valueOf(localUserHolder.a());
      if ((localLong == null) || (!localLong.equals(Long.valueOf(paramProfileImage.a))))
        continue;
      ViewHolder localViewHolder = localUserHolder.d();
      if (localViewHolder == null)
        continue;
      localViewHolder.a.setImageBitmap(paramProfileImage.c());
    }
  }

  public Filter getFilter()
  {
    return this.e;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = ((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(2130903558, null);
    UserHolder localUserHolder = (UserHolder)getItem(paramInt);
    ViewHolder localViewHolder = new ViewHolder(paramView, 2131297162);
    paramView.setTag(localViewHolder);
    localUserHolder.a(localViewHolder);
    localViewHolder.a(Long.valueOf(localUserHolder.a()));
    String str1 = localUserHolder.c();
    String str2;
    if (str1 != null)
    {
      Bitmap localBitmap = this.c.a(this.a, localUserHolder.a(), str1);
      if (localBitmap != null)
      {
        localViewHolder.a.setImageBitmap(localBitmap);
        str2 = localUserHolder.b();
        if (str2 != null)
          break label183;
      }
    }
    label183: for (String str3 = this.a.getString(2131362934); ; str3 = str2)
    {
      ((TextView)paramView.findViewById(2131296493)).setText(str3);
      return paramView;
      localViewHolder.a.setImageResource(2130838447);
      break;
      localViewHolder.a.setImageResource(2130838447);
      break;
    }
  }

  public boolean isEmpty()
  {
    if (getCount() == 0);
    for (boolean bool = true; ; bool = super.isEmpty())
      return bool;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.DropdownTagUsersAdapter
 * JD-Core Version:    0.6.0
 */