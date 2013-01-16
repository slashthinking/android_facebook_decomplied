package com.facebook.timeline;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.feed.renderer.FeedUnitViewStyle;
import com.facebook.feed.ui.attachments.StoryAttachmentsSection;
import com.facebook.feed.ui.footer.StoryFooterSection;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.FeedStoryAttachmentBuilder;
import com.facebook.graphql.model.FeedStoryAttachmentType.KnownAttachmentType;
import com.facebook.graphql.model.FeedStoryBuilder;
import com.facebook.graphql.model.GraphQLIcon;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.LifeEventFeedUnit;
import com.facebook.widget.UrlImage;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TimelineLifeEventUnitView extends LinearLayout
{
  private final int a = 250;
  private final String b = getResources().getString(2131362072);
  private final String c = getResources().getString(2131362109);

  public TimelineLifeEventUnitView(Context paramContext)
  {
    this(paramContext, null);
  }

  public TimelineLifeEventUnitView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void a(int paramInt, CharSequence paramCharSequence)
  {
    TextView localTextView = (TextView)findViewById(paramInt);
    if (localTextView != null)
    {
      if (paramCharSequence == null)
        break label35;
      localTextView.setVisibility(0);
      localTextView.setText(paramCharSequence);
      localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
    while (true)
    {
      return;
      label35: localTextView.setVisibility(8);
    }
  }

  private FeedStoryAttachment b(LifeEventFeedUnit paramLifeEventFeedUnit)
  {
    FeedStoryAttachment localFeedStoryAttachment;
    if ((paramLifeEventFeedUnit.unitPhotos == null) || (paramLifeEventFeedUnit.unitPhotos.isEmpty()))
      localFeedStoryAttachment = null;
    while (true)
    {
      return localFeedStoryAttachment;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramLifeEventFeedUnit.unitPhotos.iterator();
      while (localIterator.hasNext())
      {
        GraphQLMedia localGraphQLMedia = (GraphQLMedia)localIterator.next();
        FeedStoryAttachmentBuilder localFeedStoryAttachmentBuilder2 = new FeedStoryAttachmentBuilder();
        localFeedStoryAttachmentBuilder2.a(localGraphQLMedia);
        localFeedStoryAttachmentBuilder2.a(localGraphQLMedia.image.uri);
        localFeedStoryAttachmentBuilder2.c(ImmutableList.a(FeedStoryAttachmentType.KnownAttachmentType.PHOTO.toString()));
        localArrayList.add(localFeedStoryAttachmentBuilder2.k());
      }
      if (paramLifeEventFeedUnit.unitPhotos.size() == 1)
      {
        localFeedStoryAttachment = (FeedStoryAttachment)localArrayList.get(0);
        continue;
      }
      FeedStoryAttachmentBuilder localFeedStoryAttachmentBuilder1 = new FeedStoryAttachmentBuilder();
      localFeedStoryAttachmentBuilder1.b(localArrayList);
      localFeedStoryAttachmentBuilder1.c(ImmutableList.a(FeedStoryAttachmentType.KnownAttachmentType.ALBUM.toString()));
      localFeedStoryAttachment = localFeedStoryAttachmentBuilder1.k();
    }
  }

  private FeedStory c(LifeEventFeedUnit paramLifeEventFeedUnit)
  {
    ArrayList localArrayList = new ArrayList();
    FeedStoryAttachment localFeedStoryAttachment = b(paramLifeEventFeedUnit);
    if (localFeedStoryAttachment != null)
      localArrayList.add(localFeedStoryAttachment);
    return new FeedStoryBuilder().c(paramLifeEventFeedUnit.id).a(paramLifeEventFeedUnit.id).a(paramLifeEventFeedUnit.S()).c(localArrayList).G();
  }

  public void a(LifeEventFeedUnit paramLifeEventFeedUnit)
  {
    UrlImage localUrlImage = (UrlImage)findViewById(2131297052);
    Spannable localSpannable;
    SpannableString localSpannableString2;
    if (paramLifeEventFeedUnit.icon != null)
    {
      localUrlImage.setImageParams(Uri.parse(paramLifeEventFeedUnit.icon.uri));
      FeedStory localFeedStory = c(paramLifeEventFeedUnit);
      ((StoryAttachmentsSection)findViewById(2131297057)).a(localFeedStory);
      ((StoryFooterSection)findViewById(2131297058)).a(localFeedStory, FeedUnitViewStyle.TIMELINE_STORY);
      a(2131297053, paramLifeEventFeedUnit.a());
      a(2131297054, paramLifeEventFeedUnit.c());
      a(2131297055, paramLifeEventFeedUnit.d());
      TextView localTextView = (TextView)findViewById(2131297056);
      localSpannable = paramLifeEventFeedUnit.e();
      if ((localSpannable == null) || (localSpannable.length() <= 250))
        break label248;
      SpannableString localSpannableString1 = SpannableString.valueOf(this.c);
      localSpannableString1.setSpan(new TimelineLifeEventUnitView.SeeMoreSpan(this, getContext(), localTextView, localSpannable), 0, this.c.length(), 33);
      CharSequence[] arrayOfCharSequence = new CharSequence[3];
      arrayOfCharSequence[0] = localSpannable.subSequence(0, 250);
      arrayOfCharSequence[1] = this.b;
      arrayOfCharSequence[2] = localSpannableString1;
      localSpannableString2 = SpannableString.valueOf(TextUtils.concat(arrayOfCharSequence));
      localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
    label248: for (Object localObject = localSpannableString2; ; localObject = localSpannable)
    {
      a(2131297056, (CharSequence)localObject);
      return;
      localUrlImage.setVisibility(8);
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineLifeEventUnitView
 * JD-Core Version:    0.6.0
 */