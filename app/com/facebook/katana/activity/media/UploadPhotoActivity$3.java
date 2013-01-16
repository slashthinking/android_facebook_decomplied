package com.facebook.katana.activity.media;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.katana.ui.TagUsersAutoCompleteTextView;
import com.facebook.katana.ui.TagView;
import com.facebook.katana.ui.TaggableView;

class UploadPhotoActivity$3
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView != null)
    {
      UserHolder localUserHolder = (UserHolder)paramAdapterView.getItemAtPosition(paramInt);
      long l = localUserHolder.a();
      String str = localUserHolder.b();
      this.a.setText("");
      UploadPhotoActivity.a(this.b, false);
      TagView localTagView = ((TaggableView)this.b.findViewById(2131297931)).a(l, UploadPhotoActivity.d(this.b), UploadPhotoActivity.e(this.b), str);
      localTagView.setOnLongClickListener(new UploadPhotoActivity.3.1(this, localTagView));
    }
    while (true)
    {
      return;
      this.a.setText("");
      UploadPhotoActivity.a(this.b, false);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.UploadPhotoActivity.3
 * JD-Core Version:    0.6.0
 */