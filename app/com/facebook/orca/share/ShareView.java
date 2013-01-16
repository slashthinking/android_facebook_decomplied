package com.facebook.orca.share;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.orca.attachments.AttachmentDataFactory;
import com.facebook.orca.attachments.ImageAttachmentData;
import com.facebook.orca.common.ui.widgets.text.MultilineEllipsizeTextView;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.images.UrlImageProcessor;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.photos.sizing.CropRegionConstraintsBuilder;
import com.facebook.orca.photos.sizing.GraphicOpConstraints;
import com.facebook.orca.photos.sizing.GraphicOpConstraintsBuilder;
import com.facebook.orca.photos.sizing.GraphicSizerFactory;
import com.facebook.orca.photos.view.PhotoViewActivity;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.UrlImage;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.List;

public class ShareView extends CustomRelativeLayout
{
  private GraphicSizerFactory a;
  private ShareRenderingLogic b;
  private AttachmentDataFactory c;
  private UrlImage d;
  private MultilineEllipsizeTextView e;
  private TextView f;
  private TextView g;
  private List<TextView> h;
  private Drawable i;
  private UrlImageProcessor j;
  private Share k;
  private int l;

  public ShareView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public ShareView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public ShareView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private static GraphicOpConstraints a(Context paramContext)
  {
    int m = SizeUtil.a(paramContext, 50.0F);
    return new GraphicOpConstraintsBuilder().a(new CropRegionConstraintsBuilder().a(1.0F).b(0.6F).c(0.6F).e()).a(0).b(0).c(m).d(m).i();
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    FbInjector localFbInjector = getInjector();
    this.a = ((GraphicSizerFactory)localFbInjector.a(GraphicSizerFactory.class));
    this.b = ((ShareRenderingLogic)localFbInjector.a(ShareRenderingLogic.class));
    this.c = ((AttachmentDataFactory)localFbInjector.a(AttachmentDataFactory.class));
    setContentView(2130903399);
    this.d = ((UrlImage)findViewById(2131297422));
    this.j = this.a.a(a(paramContext));
    this.e = ((MultilineEllipsizeTextView)findViewById(2131297424));
    this.f = ((TextView)findViewById(2131297425));
    this.g = ((TextView)findViewById(2131297429));
    this.h = ImmutableList.a((TextView)findViewById(2131297426), (TextView)findViewById(2131297427), (TextView)findViewById(2131297428));
    this.i = paramContext.getResources().getDrawable(2130838731);
    this.d.setOnClickListener(new ShareView.1(this));
    this.e.setOnClickListener(new ShareView.2(this));
    setWillNotDraw(false);
    this.l = SizeUtil.a(paramContext, 4.0F);
  }

  private void b()
  {
    if (StringUtil.a(this.k.a()))
    {
      this.e.setVisibility(8);
      if (!StringUtil.a(this.k.b()))
        break label337;
      this.f.setVisibility(8);
      label44: if (!StringUtil.a(this.k.c()))
        break label362;
      this.g.setVisibility(8);
      label66: ShareMedia localShareMedia = this.b.a(this.k);
      if ((localShareMedia == null) || (StringUtil.a(localShareMedia.d())))
        break label410;
      if (!"photo".equals(localShareMedia.c()))
        break label387;
      this.d.setBackgroundResource(2130838627);
      label113: this.d.setVisibility(0);
      Uri localUri = Uri.parse(localShareMedia.d());
      if (!localUri.isAbsolute())
        break label398;
      this.d.setImageParams(localUri, this.j);
    }
    Iterator localIterator;
    while (true)
    {
      Resources localResources = getResources();
      UnmodifiableIterator localUnmodifiableIterator = this.k.f().b();
      localIterator = this.h.iterator();
      while ((localUnmodifiableIterator.hasNext()) && (localIterator.hasNext()))
      {
        ShareProperty localShareProperty = (ShareProperty)localUnmodifiableIterator.next();
        TextView localTextView = (TextView)localIterator.next();
        localTextView.setVisibility(0);
        String str1 = "<font color=\"#888888\">" + TextUtils.htmlEncode(localShareProperty.a()) + "</font>";
        String str2 = localResources.getString(2131362568);
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = str1;
        arrayOfObject[1] = TextUtils.htmlEncode(localShareProperty.b());
        localTextView.setText(Html.fromHtml(String.format(str2, arrayOfObject)));
      }
      this.e.setVisibility(0);
      this.e.setText(this.k.a());
      break;
      label337: this.f.setVisibility(0);
      this.f.setText(this.k.b());
      break label44;
      label362: this.g.setVisibility(0);
      this.g.setText(this.k.c());
      break label66;
      label387: this.d.setBackgroundDrawable(null);
      break label113;
      label398: this.d.setVisibility(8);
      continue;
      label410: this.d.setVisibility(8);
    }
    while (localIterator.hasNext())
      ((TextView)localIterator.next()).setVisibility(8);
  }

  private void c()
  {
    if (!StringUtil.a(this.k.e()))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.k.e()));
      getContext().startActivity(localIntent);
    }
  }

  private void f()
  {
    Context localContext = getContext();
    ShareMedia localShareMedia = this.b.a(this.k);
    if ("link".equals(localShareMedia.c()))
      localContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(localShareMedia.a())));
    while (true)
    {
      return;
      if ("photo".equals(localShareMedia.c()))
      {
        ImageAttachmentData localImageAttachmentData = this.c.a(localShareMedia);
        Intent localIntent2 = new Intent(localContext, PhotoViewActivity.class);
        localIntent2.putExtra("imageData", localImageAttachmentData);
        localContext.startActivity(localIntent2);
        continue;
      }
      if (!"video".equals(localShareMedia.c()))
        continue;
      ShareMediaVideo localShareMediaVideo = localShareMedia.f();
      if (localShareMediaVideo.b() == null)
        continue;
      Uri localUri = Uri.parse(localShareMediaVideo.b().replaceAll("https://", "http://"));
      Intent localIntent1 = new Intent();
      localIntent1.setAction("android.intent.action.VIEW");
      localIntent1.setDataAndType(localUri, "video/*");
      localContext.startActivity(localIntent1);
    }
  }

  private Rect getShareNameRect()
  {
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    this.e.getGlobalVisibleRect(localRect1);
    getGlobalVisibleRect(localRect2);
    localRect1.offset(-localRect2.left, -localRect2.top);
    localRect1.left -= this.l;
    localRect1.top -= this.l;
    localRect1.bottom += this.l;
    localRect1.right += this.l;
    return localRect1;
  }

  void a()
  {
    invalidate(getShareNameRect());
  }

  public Share getShare()
  {
    return this.k;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Rect localRect = getShareNameRect();
    this.i.setState(this.e.getDrawableState());
    this.i.setBounds(localRect);
    this.i.draw(paramCanvas);
  }

  public void setShare(Share paramShare)
  {
    this.k = paramShare;
    b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.share.ShareView
 * JD-Core Version:    0.6.0
 */