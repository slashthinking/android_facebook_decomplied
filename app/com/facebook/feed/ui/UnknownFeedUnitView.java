package com.facebook.feed.ui;

import android.content.Context;
import android.widget.TextView;
import com.facebook.common.util.Log;
import com.facebook.feed.renderer.FeedUnitViewStyle;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FeedUnitEdge;
import com.facebook.graphql.model.GraphQLObjectType;
import com.facebook.graphql.model.UnknownFeedUnit;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomViewGroup;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class UnknownFeedUnitView extends CustomViewGroup
  implements BindableFeedUnitView<Object>
{
  private final TextView a;

  public UnknownFeedUnitView(Context paramContext)
  {
    super(paramContext);
    setContentView(2130903615);
    this.a = ((TextView)getView(2131297927));
  }

  private String a(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Beta only: unknown data object type: ");
    String str;
    if (paramObject == null)
      str = "null";
    while (true)
    {
      localStringBuilder.append(str);
      localStringBuilder.append(". ");
      ObjectMapper localObjectMapper;
      if ((paramObject instanceof FeedUnitEdge))
      {
        FeedUnit localFeedUnit = ((FeedUnitEdge)paramObject).b();
        if ((paramObject instanceof UnknownFeedUnit))
        {
          localStringBuilder.append("New FeedUnit type: ");
          localStringBuilder.append(((UnknownFeedUnit)localFeedUnit).getType().c());
          localStringBuilder.append(". ");
        }
        localStringBuilder.append("JSON: ");
        localObjectMapper = (ObjectMapper)getInjector().a(ObjectMapper.class);
      }
      try
      {
        localStringBuilder.append(localObjectMapper.writeValueAsString((FeedUnitEdge)paramObject));
        return localStringBuilder.toString();
        str = paramObject.getClass().getName();
      }
      catch (IOException localIOException)
      {
        while (true)
          Log.a("UnknownFeedUnitView", localIOException.getMessage(), localIOException);
      }
    }
  }

  public void a(Object paramObject, FeedUnitViewStyle paramFeedUnitViewStyle, boolean paramBoolean)
  {
    this.a.setText(a(paramObject));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.UnknownFeedUnitView
 * JD-Core Version:    0.6.0
 */