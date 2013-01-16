package com.facebook.appcenter.util;

import android.text.TextPaint;
import android.text.style.URLSpan;

class AppCenterInlineGDPHelper$URLSpanNoUnderline extends URLSpan
{
  public AppCenterInlineGDPHelper$URLSpanNoUnderline(String paramString)
  {
    super(paramString);
  }

  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.util.AppCenterInlineGDPHelper.URLSpanNoUnderline
 * JD-Core Version:    0.6.0
 */