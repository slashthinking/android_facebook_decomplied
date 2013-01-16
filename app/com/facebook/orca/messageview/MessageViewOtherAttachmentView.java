package com.facebook.orca.messageview;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.common.util.FileSizeUtil;
import com.facebook.orca.attachments.OtherAttachmentData;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;

public class MessageViewOtherAttachmentView extends CustomFrameLayout
{
  private FileSizeUtil a;
  private OtherAttachmentData b;
  private Button c;
  private TextView d;
  private TextView e;

  public MessageViewOtherAttachmentView(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public MessageViewOtherAttachmentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  public MessageViewOtherAttachmentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }

  private void a()
  {
    this.a = ((FileSizeUtil)getInjector().a(FileSizeUtil.class));
    setContentView(2130903378);
    this.c = ((Button)b(2131297365));
    this.d = ((TextView)b(2131297366));
    this.e = ((TextView)b(2131297367));
    this.c.setOnClickListener(new MessageViewOtherAttachmentView.1(this));
  }

  private void b()
  {
    if (this.b == null)
    {
      this.d.setText("");
      this.e.setText("");
    }
    while (true)
    {
      return;
      this.d.setText(this.b.a());
      this.e.setText(this.a.a(this.b.b()));
    }
  }

  private void c()
  {
    Uri localUri;
    String str;
    Context localContext;
    if (this.b != null)
    {
      localUri = this.b.c();
      str = this.b.d();
      localContext = getContext();
    }
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setDataAndType(localUri, str);
      localContext.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      while (true)
        localContext.startActivity(new Intent("android.intent.action.VIEW", localUri));
    }
  }

  public OtherAttachmentData getAttachmentInfo()
  {
    return this.b;
  }

  public void setAttachmentInfo(OtherAttachmentData paramOtherAttachmentData)
  {
    this.b = paramOtherAttachmentData;
    b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.messageview.MessageViewOtherAttachmentView
 * JD-Core Version:    0.6.0
 */