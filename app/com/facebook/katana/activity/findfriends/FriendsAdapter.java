package com.facebook.katana.activity.findfriends;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.facebook.katana.ViewHolder;
import com.facebook.katana.binding.ProfileImagesCache;
import com.facebook.katana.model.FacebookPhonebookContact;
import com.facebook.katana.model.FacebookPhonebookContactUser;
import java.util.ArrayList;
import java.util.List;

public class FriendsAdapter extends BaseAdapter
{
  protected final ProfileImagesCache h;

  public FriendsAdapter(Context paramContext, ArrayList<? extends FacebookPhonebookContact> paramArrayList, ProfileImagesCache paramProfileImagesCache)
  {
    super(paramContext);
    this.a = paramArrayList;
    this.h = paramProfileImagesCache;
    a(paramArrayList);
  }

  protected long a(FacebookPhonebookContact paramFacebookPhonebookContact)
  {
    return paramFacebookPhonebookContact.userId;
  }

  protected void a(View paramView, FacebookPhonebookContact paramFacebookPhonebookContact, boolean paramBoolean)
  {
    FacebookPhonebookContactUser localFacebookPhonebookContactUser = (FacebookPhonebookContactUser)paramFacebookPhonebookContact;
    ViewHolder localViewHolder;
    if (paramBoolean == true)
    {
      localViewHolder = new ViewHolder(paramView, 2131296492);
      this.i.add(localViewHolder);
      paramView.setTag(localViewHolder);
      localViewHolder.a(Long.valueOf(localFacebookPhonebookContactUser.userId));
      String str = localFacebookPhonebookContactUser.imageUrl;
      if ((str == null) || (str.length() == 0))
        break label135;
      Bitmap localBitmap = this.h.a(this.b, localFacebookPhonebookContactUser.userId, str);
      if (localBitmap == null)
        break label122;
      localViewHolder.a.setImageBitmap(localBitmap);
    }
    while (true)
    {
      return;
      localViewHolder = (ViewHolder)paramView.getTag();
      break;
      label122: localViewHolder.a.setImageResource(2130838447);
      continue;
      label135: localViewHolder.a.setImageResource(2130838447);
    }
  }

  protected String b(FacebookPhonebookContact paramFacebookPhonebookContact)
  {
    return "";
  }

  protected String e()
  {
    return this.b.getString(2131362847);
  }

  protected String h()
  {
    return this.b.getString(2131363394);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.FriendsAdapter
 * JD-Core Version:    0.6.0
 */