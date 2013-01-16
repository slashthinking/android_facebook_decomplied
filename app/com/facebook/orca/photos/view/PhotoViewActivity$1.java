package com.facebook.orca.photos.view;

import android.text.SpannableString;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.emoji.EmojiUtil;
import com.facebook.orca.photos.tiles.UserTileView;
import com.facebook.orca.photos.tiles.UserTileViewParams;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadDateUtil;

class PhotoViewActivity$1
  implements AdapterView.OnItemSelectedListener
{
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    PhotoViewActivity.a(this.a);
    if (PhotoViewActivity.b(this.a).getSelectedItem() != null)
    {
      PhotoMessageItem localPhotoMessageItem = (PhotoMessageItem)PhotoViewActivity.b(this.a).getSelectedItem();
      if (localPhotoMessageItem.b() == null)
        break label247;
      SpannableString localSpannableString = new SpannableString(StringUtil.a(localPhotoMessageItem.b().h(), 120));
      PhotoViewActivity.d(this.a).a(localSpannableString, (int)PhotoViewActivity.c(this.a).getTextSize());
      PhotoViewActivity.c(this.a).setText(localSpannableString);
      PhotoViewActivity.e(this.a).setParams(UserTileViewParams.a(localPhotoMessageItem.b().f().e()));
      PhotoViewActivity.f(this.a).setText(localPhotoMessageItem.b().f().d());
      PhotoViewActivity.h(this.a).setText(PhotoViewActivity.g(this.a).a(localPhotoMessageItem.b().c()));
      PhotoViewActivity.i(this.a).setVisibility(0);
    }
    while (true)
    {
      TextView localTextView = PhotoViewActivity.j(this.a);
      PhotoViewActivity localPhotoViewActivity = this.a;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(paramInt + 1);
      arrayOfObject[1] = Integer.valueOf(PhotoViewActivity.b(this.a).getCount());
      localTextView.setText(localPhotoViewActivity.getString(2131362476, arrayOfObject));
      return;
      label247: PhotoViewActivity.i(this.a).setVisibility(8);
    }
  }

  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.view.PhotoViewActivity.1
 * JD-Core Version:    0.6.0
 */