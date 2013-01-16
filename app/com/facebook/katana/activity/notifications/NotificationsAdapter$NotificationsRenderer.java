package com.facebook.katana.activity.notifications;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.util.DefaultTimeFormatUtil;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.TimeFormatUtil.TimeFormatStyle;
import com.facebook.graphql.model.GraphQLEntityRange;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.katana.annotations.IsFullscreenJewelsEnabled;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.UrlImage;
import java.util.Iterator;
import java.util.List;

public abstract class NotificationsAdapter$NotificationsRenderer
{
  private final Context a;
  private final StyleSpan b;
  private final FbErrorReporter c;
  private final boolean d;

  public NotificationsAdapter$NotificationsRenderer(Context paramContext)
  {
    this.a = paramContext;
    FbInjector localFbInjector = FbInjector.a(paramContext);
    this.c = ((FbErrorReporter)localFbInjector.a(FbErrorReporter.class));
    this.d = ((Boolean)localFbInjector.a(Boolean.class, IsFullscreenJewelsEnabled.class)).booleanValue();
    this.b = new StyleSpan(1);
  }

  private Uri a(String paramString)
  {
    Object localObject = null;
    if (paramString == null);
    while (true)
    {
      return localObject;
      Uri localUri = Uri.parse(paramString);
      boolean bool = localUri.isAbsolute();
      localObject = null;
      if (!bool)
        continue;
      localObject = localUri;
    }
  }

  Spannable a(GraphQLTextWithEntities paramGraphQLTextWithEntities)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramGraphQLTextWithEntities.text);
    Iterator localIterator = paramGraphQLTextWithEntities.ranges.iterator();
    while (localIterator.hasNext())
    {
      GraphQLEntityRange localGraphQLEntityRange = (GraphQLEntityRange)localIterator.next();
      localSpannableStringBuilder.setSpan(new StyleSpan(1), localGraphQLEntityRange.offset, localGraphQLEntityRange.offset + localGraphQLEntityRange.length, 18);
    }
    return localSpannableStringBuilder;
  }

  Spannable a(String paramString1, String paramString2)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString1);
    localSpannableStringBuilder.setSpan(this.b, 0, paramString1.length(), 33);
    if (paramString2 != null)
    {
      if (!paramString2.startsWith(paramString1))
        break label51;
      localSpannableStringBuilder.append(paramString2.substring(paramString1.length()));
    }
    while (true)
    {
      return localSpannableStringBuilder;
      label51: localSpannableStringBuilder = new SpannableStringBuilder(paramString2);
    }
  }

  public View a()
  {
    LayoutInflater localLayoutInflater = (LayoutInflater)this.a.getSystemService("layout_inflater");
    if (this.d);
    for (int i = 2130903303; ; i = 2130903302)
    {
      View localView = localLayoutInflater.inflate(i, null);
      NotificationsAdapter.NotificationsRenderer.ViewHolder localViewHolder = new NotificationsAdapter.NotificationsRenderer.ViewHolder(null);
      localViewHolder.a = ((UrlImage)localView.findViewById(2131297162));
      localViewHolder.d = ((TextView)localView.findViewById(2131297163));
      localViewHolder.c = ((TextView)localView.findViewById(2131297165));
      localViewHolder.b = ((UrlImage)localView.findViewById(2131297164));
      if (this.d)
        localViewHolder.e = ((UrlImage)localView.findViewById(2131297166));
      localView.setTag(localViewHolder);
      return localView;
    }
  }

  abstract void a(View paramView, Context paramContext, Cursor paramCursor);

  protected void a(View paramView, Context paramContext, boolean paramBoolean, String paramString1, String paramString2, Spannable paramSpannable, long paramLong, String paramString3)
  {
    int i;
    NotificationsAdapter.NotificationsRenderer.ViewHolder localViewHolder;
    if (paramBoolean)
    {
      i = 0;
      paramView.setBackgroundResource(i);
      localViewHolder = (NotificationsAdapter.NotificationsRenderer.ViewHolder)paramView.getTag();
      localViewHolder.a.setImageParams(Uri.parse(paramString1));
      if (a(paramString2) == null)
        break label137;
      localViewHolder.b.setImageParams(Uri.parse(paramString2));
      label57: localViewHolder.d.setText(paramSpannable);
      String str = DefaultTimeFormatUtil.a(this.a, TimeFormatUtil.TimeFormatStyle.STREAM_RELATIVE_STYLE, 1000L * paramLong);
      localViewHolder.c.setText(str);
      if ((!this.d) || (paramString3 == null))
        break label181;
      localViewHolder.e.setImageParams(Uri.parse(paramString3));
      localViewHolder.e.setVisibility(0);
    }
    while (true)
    {
      return;
      i = 2130839011;
      break;
      label137: localViewHolder.b.setPlaceholderBackgroundResourceId(2130838451);
      this.c.a("notification", "invalid url for notification icon : " + paramString2);
      break label57;
      label181: if (localViewHolder.e == null)
        continue;
      localViewHolder.e.setVisibility(8);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.notifications.NotificationsAdapter.NotificationsRenderer
 * JD-Core Version:    0.6.0
 */