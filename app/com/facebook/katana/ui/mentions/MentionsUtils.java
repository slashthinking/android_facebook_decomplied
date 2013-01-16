package com.facebook.katana.ui.mentions;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import com.facebook.orca.common.util.StringLocaleUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MentionsUtils
{
  public static final Class<?> a = MentionsUtils.class;

  public static String a(Editable paramEditable)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramEditable);
    MentionSpan[] arrayOfMentionSpan = (MentionSpan[])localSpannableStringBuilder.getSpans(0, localSpannableStringBuilder.length(), MentionSpan.class);
    if (arrayOfMentionSpan == null);
    for (String str1 = localSpannableStringBuilder.toString().trim(); ; str1 = localSpannableStringBuilder.toString().trim())
    {
      return str1;
      int i = arrayOfMentionSpan.length;
      for (int j = 0; j < i; j++)
      {
        MentionSpan localMentionSpan = arrayOfMentionSpan[j];
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Long.valueOf(localMentionSpan.c());
        arrayOfObject[1] = localMentionSpan.a();
        String str2 = StringLocaleUtil.a("@[%d:%s]", arrayOfObject);
        localSpannableStringBuilder.replace(localSpannableStringBuilder.getSpanStart(localMentionSpan), localSpannableStringBuilder.getSpanEnd(localMentionSpan), str2);
      }
    }
  }

  public static String a(String paramString)
  {
    String str1 = "";
    Matcher localMatcher = Pattern.compile("@\\[(\\d+):((\\w|\\s)+)\\]", 64).matcher(paramString);
    for (int i = 0; localMatcher.find(); i = localMatcher.end())
    {
      String str2 = str1 + paramString.subSequence(i, localMatcher.start());
      str1 = str2 + localMatcher.group(2);
    }
    return str1 + paramString.subSequence(i, paramString.length());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.mentions.MentionsUtils
 * JD-Core Version:    0.6.0
 */