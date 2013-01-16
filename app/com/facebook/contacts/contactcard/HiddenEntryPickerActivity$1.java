package com.facebook.contacts.contactcard;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class HiddenEntryPickerActivity$1
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("entry_position", paramInt);
    this.a.setResult(1, localIntent);
    this.a.finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.HiddenEntryPickerActivity.1
 * JD-Core Version:    0.6.0
 */