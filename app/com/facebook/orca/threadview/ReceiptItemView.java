package com.facebook.orca.threadview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.orca.common.ui.util.MessageRenderingUtil;
import com.facebook.orca.common.ui.widgets.text.RowReceiptTextView;
import com.facebook.orca.common.ui.widgets.text.RowReceiptTextView.Data;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.location.Coordinates;
import com.facebook.orca.location.GeocodingCache;
import com.facebook.orca.location.GeocodingForMessageLocationExecutor;
import com.facebook.orca.location.GeocodingForMessageLocationResult;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadDateUtil;
import com.facebook.orca.threads.ThreadSourceUtil;
import com.facebook.widget.CustomViewGroup;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public class ReceiptItemView extends CustomViewGroup
{
  private static final Class<?> a = ReceiptItemView.class;
  private RowReceiptTextView b;
  private ImageView c;
  private ThreadSourceUtil d;
  private ThreadDateUtil e;
  private AndroidThreadUtil f;
  private GeocodingForMessageLocationExecutor g;
  private ListenableFuture<GeocodingForMessageLocationResult> h;
  private MessageRenderingUtil i;
  private GeocodingCache j;

  public ReceiptItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public ReceiptItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public ReceiptItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    setContentView(2130903397);
    FbInjector localFbInjector = getInjector();
    this.d = ((ThreadSourceUtil)localFbInjector.a(ThreadSourceUtil.class));
    this.f = ((AndroidThreadUtil)localFbInjector.a(AndroidThreadUtil.class));
    this.e = ((ThreadDateUtil)localFbInjector.a(ThreadDateUtil.class));
    this.g = ((GeocodingForMessageLocationExecutor)localFbInjector.a(GeocodingForMessageLocationExecutor.class));
    this.i = ((MessageRenderingUtil)localFbInjector.a(MessageRenderingUtil.class));
    this.j = ((GeocodingCache)localFbInjector.a(GeocodingCache.class));
    this.c = ((ImageView)getView(2131297353));
    this.b = ((RowReceiptTextView)getView(2131297354));
  }

  private void setDeliveredReceipt(RowReceiptItem paramRowReceiptItem)
  {
    this.c.setVisibility(0);
    this.b.setData(new RowReceiptTextView.Data(getContext().getString(2131362681)));
    if (!StringUtil.a(paramRowReceiptItem.d()))
      this.c.setImageResource(this.d.a(paramRowReceiptItem.d()));
    while (true)
    {
      return;
      this.c.setImageDrawable(null);
    }
  }

  private void setGroupReadReceipt(RowReceiptItem paramRowReceiptItem)
  {
    this.c.setVisibility(0);
    this.c.setImageResource(2130838712);
    int k = paramRowReceiptItem.c().size();
    if (!paramRowReceiptItem.i())
      k++;
    if ((-1 + paramRowReceiptItem.j() == k) && (paramRowReceiptItem.j() == 3) && (paramRowReceiptItem.c().size() == 1))
    {
      RowReceiptParticipant localRowReceiptParticipant = (RowReceiptParticipant)paramRowReceiptItem.c().get(0);
      StringBuilder localStringBuilder = new StringBuilder(30);
      localStringBuilder.append(localRowReceiptParticipant.a().d());
      long l = localRowReceiptParticipant.b();
      if (l != -1L)
        localStringBuilder.append(" ").append(this.e.c(l));
      RowReceiptTextView localRowReceiptTextView = this.b;
      Context localContext = getContext();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localStringBuilder.toString();
      localRowReceiptTextView.setData(new RowReceiptTextView.Data(localContext.getString(2131362685, arrayOfObject)));
    }
    while (true)
    {
      return;
      if (-1 + paramRowReceiptItem.j() == k)
      {
        this.b.setData(new RowReceiptTextView.Data(getContext().getString(2131362684)));
        continue;
      }
      this.b.setData(new RowReceiptTextView.Data(paramRowReceiptItem.c()));
    }
  }

  private void setReadReceipt(RowReceiptItem paramRowReceiptItem)
  {
    this.c.setVisibility(0);
    this.c.setImageResource(2130838712);
    long l = paramRowReceiptItem.g();
    String str = "";
    if (l != -1L)
      str = this.e.c(l);
    this.b.setData(new RowReceiptTextView.Data(getContext().getString(2131362682, new Object[] { str })));
  }

  private void setSentReceipt(RowReceiptItem paramRowReceiptItem)
  {
    Coordinates localCoordinates = paramRowReceiptItem.h();
    this.c.setVisibility(8);
    if (StringUtil.a(paramRowReceiptItem.d()))
    {
      this.b.setData(new RowReceiptTextView.Data(this.d.b("chat")));
      if (localCoordinates != null)
        break label104;
    }
    while (true)
    {
      return;
      String str = null;
      if (localCoordinates != null)
        str = this.j.c(localCoordinates);
      if (StringUtil.a(str))
        str = this.d.b(paramRowReceiptItem.d());
      this.b.setData(new RowReceiptTextView.Data(str));
      break;
      label104: this.h = this.g.a(localCoordinates);
      this.f.a(this.h, new ReceiptItemView.1(this, localCoordinates));
    }
  }

  public void setRowReceiptItem(RowReceiptItem paramRowReceiptItem)
  {
    if (this.h != null)
    {
      this.h.cancel(false);
      this.h = null;
    }
    switch (ReceiptItemView.2.a[paramRowReceiptItem.b().ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return;
      setSentReceipt(paramRowReceiptItem);
      continue;
      setReadReceipt(paramRowReceiptItem);
      continue;
      setDeliveredReceipt(paramRowReceiptItem);
      continue;
      setGroupReadReceipt(paramRowReceiptItem);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ReceiptItemView
 * JD-Core Version:    0.6.0
 */