package com.facebook.orca.threadview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.facebook.orca.attachments.AttachmentDataFactory;
import com.facebook.orca.attachments.OtherAttachmentData;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.threads.Message;
import com.google.common.collect.ImmutableList;

public class ThreadViewOtherAttachmentsView extends LinearLayout
{
  private AttachmentDataFactory a;
  private Message b;
  private ImmutableList<OtherAttachmentData> c;
  private int d;

  public ThreadViewOtherAttachmentsView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ThreadViewOtherAttachmentsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = ((AttachmentDataFactory)FbInjector.a(paramContext).a(AttachmentDataFactory.class));
    setOrientation(1);
  }

  private void a()
  {
    while (this.d < this.c.size())
    {
      addView(new ThreadViewOtherAttachmentView(getContext()), this.d);
      this.d = (1 + this.d);
    }
    for (int i = 0; (i < this.d) && (i < this.c.size()); i++)
      a(i);
    while (true)
    {
      if (j < this.d)
      {
        ((ThreadViewOtherAttachmentView)getChildAt(j)).setVisibility(8);
        j++;
        continue;
      }
      return;
      int j = i;
    }
  }

  private void a(int paramInt)
  {
    ((ThreadViewOtherAttachmentView)getChildAt(paramInt)).setAttachmentInfo((OtherAttachmentData)this.c.get(paramInt));
  }

  public Message getMessage()
  {
    return this.b;
  }

  public void setMessage(Message paramMessage)
  {
    this.b = paramMessage;
    this.c = this.a.g(paramMessage);
    a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewOtherAttachmentsView
 * JD-Core Version:    0.6.0
 */