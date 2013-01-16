package com.facebook.katana.ui.mentions;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import com.facebook.common.util.Log;
import com.facebook.widget.tagging.TaggingProfile;
import com.facebook.widget.tagging.TaggingProfile.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MentionsSpannableStringBuilder extends SpannableStringBuilder
{
  public static final Class<?> a = MentionsSpannableStringBuilder.class;

  public static MentionsSpannableStringBuilder a(CharSequence paramCharSequence, Resources paramResources)
  {
    MentionsSpannableStringBuilder localMentionsSpannableStringBuilder = new MentionsSpannableStringBuilder();
    Matcher localMatcher = Pattern.compile("@\\[(\\d+):(\\d+:)?((\\w|\\s)+)\\]", 64).matcher(paramCharSequence);
    for (int i = 0; localMatcher.find(); i = localMatcher.end())
    {
      localMentionsSpannableStringBuilder.append(paramCharSequence.subSequence(i, localMatcher.start()));
      long l = Long.parseLong(localMatcher.group(1));
      TaggingProfile localTaggingProfile = new TaggingProfile(localMatcher.group(3), l, "", TaggingProfile.Type.UNKNOWN);
      int j = localMentionsSpannableStringBuilder.length();
      localMentionsSpannableStringBuilder.append(localTaggingProfile.a());
      MentionSpan localMentionSpan = new MentionSpan(localTaggingProfile);
      localMentionsSpannableStringBuilder.setSpan(localMentionSpan, j, localMentionsSpannableStringBuilder.length(), 33);
      localMentionSpan.a(localMentionsSpannableStringBuilder, j);
      localMentionsSpannableStringBuilder.setSpan(new BackgroundColorSpan(paramResources.getColor(2131165509)), j, localMentionsSpannableStringBuilder.length(), 33);
    }
    localMentionsSpannableStringBuilder.append(paramCharSequence.subSequence(i, paramCharSequence.length()));
    return localMentionsSpannableStringBuilder;
  }

  public int a()
  {
    return ((MentionSpan[])getSpans(0, length(), MentionSpan.class)).length;
  }

  public MentionsSpannableStringBuilder a(int paramInt1, int paramInt2, TaggingProfile paramTaggingProfile, Resources paramResources)
  {
    delete(paramInt1, paramInt2);
    insert(paramInt1, paramTaggingProfile.a());
    MentionSpan localMentionSpan = new MentionSpan(paramTaggingProfile);
    setSpan(localMentionSpan, paramInt1, paramInt1 + paramTaggingProfile.a().length(), 33);
    localMentionSpan.a(this, paramInt1);
    setSpan(new BackgroundColorSpan(paramResources.getColor(2131165509)), paramInt1, paramInt1 + paramTaggingProfile.a().length(), 33);
    return this;
  }

  public boolean a(int paramInt)
  {
    if (((MentionSpan[])getSpans(paramInt, paramInt + 1, MentionSpan.class)).length > 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public List<Long> b()
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    MentionSpan[] arrayOfMentionSpan = (MentionSpan[])getSpans(0, length(), MentionSpan.class);
    int j = arrayOfMentionSpan.length;
    while (i < j)
    {
      localArrayList.add(Long.valueOf(arrayOfMentionSpan[i].c()));
      i++;
    }
    return localArrayList;
  }

  public SpannableStringBuilder replace(int paramInt1, int paramInt2, CharSequence paramCharSequence, int paramInt3, int paramInt4)
  {
    MentionSpan[] arrayOfMentionSpan = (MentionSpan[])getSpans(paramInt1, paramInt2, MentionSpan.class);
    super.replace(paramInt1, paramInt2, paramCharSequence, paramInt3, paramInt4);
    int i = arrayOfMentionSpan.length;
    int j = 0;
    if (j < i)
    {
      MentionSpan localMentionSpan = arrayOfMentionSpan[j];
      BackgroundColorSpan[] arrayOfBackgroundColorSpan = (BackgroundColorSpan[])getSpans(getSpanStart(localMentionSpan), getSpanEnd(localMentionSpan), BackgroundColorSpan.class);
      if ((arrayOfBackgroundColorSpan == null) || (arrayOfBackgroundColorSpan.length != 1))
        Log.a(a, "unexpected number of style spans to invalidate");
      while (true)
      {
        j++;
        break;
        BackgroundColorSpan localBackgroundColorSpan = arrayOfBackgroundColorSpan[0];
        removeSpan(localMentionSpan);
        removeSpan(localBackgroundColorSpan);
        if (localMentionSpan.c(this))
          continue;
        setSpan(localBackgroundColorSpan, localMentionSpan.a(this), localMentionSpan.b(this), 33);
        setSpan(localMentionSpan, localMentionSpan.a(this), localMentionSpan.b(this), 33);
      }
    }
    return this;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.mentions.MentionsSpannableStringBuilder
 * JD-Core Version:    0.6.0
 */