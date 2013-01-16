package com.facebook.katana.activity;

import android.view.View;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.facebook.katana.MyTabHost;

class BaseFacebookTabActivity$1
  implements RadioGroup.OnCheckedChangeListener
{
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    String str = (String)paramRadioGroup.findViewById(paramInt).getTag();
    BaseFacebookTabActivity.a(this.a).setCurrentTabByTag(str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.BaseFacebookTabActivity.1
 * JD-Core Version:    0.6.0
 */