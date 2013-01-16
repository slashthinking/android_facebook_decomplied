package com.facebook.katana.view.vault;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import com.facebook.photos.analytics.PhotoFlowLogger;

class PickerGalleryView$4
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (PickerGalleryView.h(this.a).getText().length() > 0)
      PickerGalleryView.h(this.a).setText("");
    while (true)
    {
      return;
      PickerGalleryView.d(this.a).a();
      PickerGalleryView.j(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.vault.PickerGalleryView.4
 * JD-Core Version:    0.6.0
 */