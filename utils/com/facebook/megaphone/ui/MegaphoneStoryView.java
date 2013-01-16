package com.facebook.megaphone.ui;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.MegaphoneStory;
import com.facebook.graphql.model.MegaphoneStoryAction;
import com.facebook.megaphone.data.MegaphoneStore;
import com.facebook.megaphone.intent.IMegaphoneIntentBuilder;
import com.facebook.megaphone.logger.MegaphoneLogger;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.UrlImage;

public class MegaphoneStoryView extends CustomRelativeLayout
  implements View.OnClickListener
{
  private final UrlImage a;
  private final TextView b;
  private final TextView c;
  private final Button d;
  private final Button e;
  private final ImageButton f;
  private final MegaphoneLogger g = (MegaphoneLogger)getInjector().a(MegaphoneLogger.class);
  private final MegaphoneStore h = (MegaphoneStore)getInjector().a(MegaphoneStore.class);
  private MegaphoneStory i;

  public MegaphoneStoryView(Context paramContext)
  {
    this(paramContext, null);
  }

  public MegaphoneStoryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public MegaphoneStoryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, 2130903277, this);
    this.a = ((UrlImage)findViewById(2131297088));
    this.b = ((TextView)findViewById(2131297089));
    this.c = ((TextView)findViewById(2131297090));
    this.d = ((Button)findViewById(2131297092));
    this.e = ((Button)findViewById(2131297093));
    this.f = ((ImageButton)findViewById(2131297094));
    this.f.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.d.setOnClickListener(this);
  }

  private void a()
  {
    this.g.a(this.i, "ACTION");
    ((IMegaphoneIntentBuilder)getInjector().a(IMegaphoneIntentBuilder.class)).a(getContext(), this.i.action.url);
    if (!this.i.isPersistent)
      this.h.b(this.i.location);
  }

  private void b()
  {
    this.g.a(this.i, "DISMISSAL");
    this.h.b(this.i.location);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.g.a(this.i, "IMPRESSION");
  }

  public void onClick(View paramView)
  {
    if ((paramView == this.f) || (paramView == this.e))
      b();
    while (true)
    {
      return;
      if (paramView == this.d)
        a();
    }
  }

  public void setMegaphoneStory(MegaphoneStory paramMegaphoneStory)
  {
    this.i = paramMegaphoneStory;
    String str1;
    label81: String str2;
    if (paramMegaphoneStory != null)
    {
      this.a.setImageParams(Uri.parse(paramMegaphoneStory.image.uri));
      this.b.setText(paramMegaphoneStory.title);
      TextView localTextView = this.c;
      if (paramMegaphoneStory.content != null)
      {
        str1 = paramMegaphoneStory.content.text;
        localTextView.setText(str1);
        if (this.b.getLineCount() >= 2)
          break label213;
        this.c.setMaxLines(4);
        if (paramMegaphoneStory.action == null)
          break label290;
        this.d.setText(paramMegaphoneStory.action.title);
        str2 = paramMegaphoneStory.action.a();
        if (!str2.equals("PROMINENT"))
          break label224;
        this.d.setBackgroundResource(2130837621);
        this.d.setTextColor(getResources().getColor(2131165184));
        label146: int j = getResources().getDimensionPixelOffset(2131230722);
        this.d.setPadding(j, 0, j, 0);
        this.d.setVisibility(0);
        label178: if (paramMegaphoneStory.closeLabel != null)
          break label302;
        this.e.setVisibility(8);
        this.f.setVisibility(0);
        label202: setVisibility(0);
      }
    }
    while (true)
    {
      return;
      str1 = null;
      break;
      label213: this.c.setMaxLines(3);
      break label81;
      label224: if (str2.equals("SUBDUED"))
      {
        this.d.setBackgroundResource(2130837625);
        this.d.setTextColor(getResources().getColor(2131165187));
        break label146;
      }
      this.d.setBackgroundResource(2130837614);
      this.d.setTextColor(getResources().getColor(2131165184));
      break label146;
      label290: this.d.setVisibility(8);
      break label178;
      label302: this.f.setVisibility(8);
      this.e.setVisibility(0);
      this.e.setText(paramMegaphoneStory.closeLabel);
      break label202;
      setVisibility(8);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.megaphone.ui.MegaphoneStoryView
 * JD-Core Version:    0.6.2
 */