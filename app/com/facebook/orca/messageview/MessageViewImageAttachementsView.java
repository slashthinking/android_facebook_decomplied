package com.facebook.orca.messageview;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.orca.attachments.AttachmentDataFactory;
import com.facebook.orca.attachments.ImageAttachmentData;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.photos.view.PhotoViewActivity;
import com.facebook.orca.threads.Message;
import com.facebook.widget.UrlImage;
import com.google.common.collect.ImmutableList;

public class MessageViewImageAttachementsView extends LinearLayout
{
  private AttachmentDataFactory a;
  private Message b;
  private ImmutableList<ImageAttachmentData> c;
  private int d;
  private int e;

  public MessageViewImageAttachementsView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public MessageViewImageAttachementsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  private void a()
  {
    int k;
    while (true)
    {
      int i = this.d;
      int j = this.c.size();
      k = 0;
      if (i >= j)
        break;
      UrlImage localUrlImage = new UrlImage(getContext());
      localUrlImage.setShowProgressBar(false);
      localUrlImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      localUrlImage.setBackgroundResource(2130838627);
      localUrlImage.setClickable(true);
      addView(localUrlImage, this.d);
      this.d = (1 + this.d);
    }
    while ((k < this.d) && (k < this.c.size()))
    {
      a(k);
      k++;
    }
    while (true)
    {
      if (m < this.d)
      {
        ((UrlImage)getChildAt(m)).setVisibility(8);
        m++;
        continue;
      }
      return;
      int m = k;
    }
  }

  private void a(int paramInt)
  {
    UrlImage localUrlImage = (UrlImage)getChildAt(paramInt);
    ImageAttachmentData localImageAttachmentData = (ImageAttachmentData)this.c.get(paramInt);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, this.e);
    localLayoutParams.bottomMargin = SizeUtil.a(getContext(), 10.0F);
    localUrlImage.setLayoutParams(localLayoutParams);
    localUrlImage.setImageParams(localImageAttachmentData.a());
    localUrlImage.setVisibility(0);
    localUrlImage.setOnClickListener(new MessageViewImageAttachementsView.1(this, localImageAttachmentData));
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.a = ((AttachmentDataFactory)FbInjector.a(paramContext).a(AttachmentDataFactory.class));
    this.e = SizeUtil.a(paramContext, 150.0F);
    setOrientation(1);
  }

  private void a(ImageAttachmentData paramImageAttachmentData)
  {
    Context localContext = getContext();
    Intent localIntent = new Intent(localContext, PhotoViewActivity.class);
    localIntent.putExtra("imageData", paramImageAttachmentData);
    localIntent.putExtra("message", this.b);
    localContext.startActivity(localIntent);
  }

  public Message getMessage()
  {
    return this.b;
  }

  public void setMessage(Message paramMessage)
  {
    this.b = paramMessage;
    this.c = this.a.b(paramMessage);
    a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.messageview.MessageViewImageAttachementsView
 * JD-Core Version:    0.6.0
 */