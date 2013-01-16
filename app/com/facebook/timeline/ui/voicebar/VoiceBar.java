package com.facebook.timeline.ui.voicebar;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.widget.CustomViewGroup;

public class VoiceBar extends CustomViewGroup
{
  public VoiceBar(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public VoiceBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  public VoiceBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }

  private void a()
  {
    setContentView(2130903476);
  }

  public void setVoice(String paramString)
  {
    TextView localTextView = (TextView)findViewById(2131297667);
    String str = "<b>" + Html.fromHtml(paramString).toString() + "</b>";
    localTextView.setText(Html.fromHtml(getContext().getString(2131361809, new Object[] { str })));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.ui.voicebar.VoiceBar
 * JD-Core Version:    0.6.0
 */