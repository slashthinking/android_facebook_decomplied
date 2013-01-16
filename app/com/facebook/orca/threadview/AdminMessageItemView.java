package com.facebook.orca.threadview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.orca.attachments.AttachmentDataFactory;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.threads.Message;
import com.facebook.widget.CustomViewGroup;

public class AdminMessageItemView extends CustomViewGroup
{
  private AttachmentDataFactory a;
  private Message b;
  private ImageView c;
  private TextView d;
  private ThreadViewImageAttachmentView e;

  public AdminMessageItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public AdminMessageItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public AdminMessageItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    this.a = ((AttachmentDataFactory)getInjector().a(AttachmentDataFactory.class));
    setContentView(2130903311);
    this.c = ((ImageView)findViewById(2131297180));
    this.d = ((TextView)findViewById(2131297181));
    this.e = ((ThreadViewImageAttachmentView)findViewById(2131297182));
  }

  public Message getMessage()
  {
    return this.b;
  }

  public void setMessage(Message paramMessage)
  {
    this.b = paramMessage;
    switch (this.b.r())
    {
    default:
      this.c.setImageDrawable(null);
      this.d.setText(paramMessage.h());
      if (!this.a.a(paramMessage))
        break;
      this.e.setVisibility(0);
      this.e.setMessage(paramMessage);
    case 1:
    case 2:
    case 3:
    case 4:
    case 7:
    case 5:
    case 6:
    case 100:
    case 101:
    case 102:
    }
    while (true)
    {
      return;
      this.c.setImageResource(2130838454);
      break;
      this.c.setImageResource(2130838458);
      break;
      this.c.setImageResource(2130838456);
      break;
      this.c.setImageResource(2130838455);
      break;
      this.c.setImageResource(2130838461);
      break;
      this.c.setImageResource(2130838459);
      break;
      this.c.setImageResource(2130838457);
      break;
      this.c.setImageResource(2130838459);
      break;
      this.c.setImageResource(2130838460);
      break;
      this.e.setVisibility(8);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.AdminMessageItemView
 * JD-Core Version:    0.6.0
 */