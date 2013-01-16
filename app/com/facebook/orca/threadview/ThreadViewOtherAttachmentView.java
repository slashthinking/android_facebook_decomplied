package com.facebook.orca.threadview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.orca.attachments.OtherAttachmentData;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.widget.CustomFrameLayout;

public class ThreadViewOtherAttachmentView extends CustomFrameLayout
{
  private OtherAttachmentData a;
  private ImageView b;
  private TextView c;

  public ThreadViewOtherAttachmentView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ThreadViewOtherAttachmentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ThreadViewOtherAttachmentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903422);
    this.b = ((ImageView)b(2131297508));
    this.c = ((TextView)b(2131297366));
  }

  private void a()
  {
    if (this.a == null)
    {
      this.b.setImageDrawable(null);
      this.c.setText("");
    }
    while (true)
    {
      return;
      this.b.setImageDrawable(getResources().getDrawable(getResourceIdForAttachmentIcon()));
      this.c.setText(this.a.a());
    }
  }

  private int getResourceIdForAttachmentIcon()
  {
    int i = 2130838470;
    if ((this.a == null) || (StringUtil.a(this.a.d())));
    while (true)
    {
      return i;
      String str = this.a.d().toLowerCase();
      if ((str.contains("text")) || (str.contains("rtf")))
      {
        if (str.contains("rtf"))
        {
          i = 2130838473;
          continue;
        }
        i = 2130838474;
        continue;
      }
      if (this.a.d().contains("video"))
      {
        i = 2130838471;
        continue;
      }
      if (!this.a.d().contains("audio"))
        continue;
      i = 2130838472;
    }
  }

  public void setAttachmentInfo(OtherAttachmentData paramOtherAttachmentData)
  {
    this.a = paramOtherAttachmentData;
    a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewOtherAttachmentView
 * JD-Core Version:    0.6.0
 */