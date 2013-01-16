package com.facebook.orca.common.ui.util;

import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.Editable;
import android.text.Spannable.Factory;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.emoji.EmojiUtil;
import com.facebook.orca.location.GeolocationInfo;
import com.facebook.orca.share.Share;
import com.facebook.orca.share.ShareMedia;
import com.facebook.orca.share.ShareRenderingLogic;
import com.facebook.orca.threads.Message;
import com.google.common.base.Objects;
import java.util.Locale;

public class MessageRenderingUtil
{
  private final Resources a;
  private final ShareRenderingLogic b;
  private final EmojiUtil c;

  public MessageRenderingUtil(Resources paramResources, ShareRenderingLogic paramShareRenderingLogic, EmojiUtil paramEmojiUtil)
  {
    this.a = paramResources;
    this.b = paramShareRenderingLogic;
    this.c = paramEmojiUtil;
  }

  private String a(String paramString, Message paramMessage)
  {
    Share localShare = this.b.a(paramMessage);
    if (localShare == null)
      return paramString;
    ShareMedia localShareMedia = this.b.a(localShare);
    if (localShare.e() != null);
    for (String str = a(paramString, localShare.e()); ; str = paramString)
    {
      if ((localShareMedia != null) && (localShareMedia.a() != null))
        str = a(str, localShareMedia.a());
      if (StringUtil.a(str))
      {
        if (localShareMedia == null)
          break label153;
        if (!"photo".equals(localShareMedia.c()))
          break label112;
        str = this.a.getString(2131362569);
      }
      while (true)
      {
        paramString = str;
        break;
        label112: if ("video".equals(localShareMedia.c()))
        {
          str = this.a.getString(2131362570);
          continue;
        }
        str = this.a.getString(2131362571);
        continue;
        label153: str = this.a.getString(2131362571);
      }
    }
  }

  private String a(String paramString1, String paramString2)
  {
    if (paramString2 == null);
    while (true)
    {
      return paramString1;
      if (paramString1.startsWith(paramString2))
      {
        paramString1 = paramString1.substring(paramString2.length()).trim();
        continue;
      }
      Uri localUri = Uri.parse(paramString2);
      if ("http".equals(localUri.getScheme()))
      {
        String str2 = localUri.buildUpon().scheme("https").build().toString();
        if (!paramString1.startsWith(str2))
          continue;
        paramString1 = b(paramString1, str2);
        continue;
      }
      if (!"https".equals(localUri.getScheme()))
        continue;
      String str1 = localUri.buildUpon().scheme("http").build().toString();
      if (!paramString1.startsWith(str1))
        continue;
      paramString1 = b(paramString1, str1);
    }
  }

  private String[] a(GeolocationInfo paramGeolocationInfo)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = paramGeolocationInfo.d();
    arrayOfString[1] = paramGeolocationInfo.g();
    return arrayOfString;
  }

  private String[] a(String paramString, GeolocationInfo paramGeolocationInfo)
  {
    String[] arrayOfString = a(paramGeolocationInfo);
    if (Objects.equal(paramString, paramGeolocationInfo.f()))
      arrayOfString[1] = b(paramGeolocationInfo);
    return arrayOfString;
  }

  private Spanned b(Message paramMessage)
  {
    String str1 = a(StringUtil.b(paramMessage.h()).trim(), paramMessage);
    SpannableStringBuilder localSpannableStringBuilder;
    if (!StringUtil.a(paramMessage.g()))
    {
      String str2 = StringUtil.b(paramMessage.g()).trim();
      String str3 = this.a.getString(2131362710, new Object[] { str2 });
      localSpannableStringBuilder = new SpannableStringBuilder(Spannable.Factory.getInstance().newSpannable(str3));
      localSpannableStringBuilder.insert(0, "<");
      localSpannableStringBuilder.append("> ");
      localSpannableStringBuilder.setSpan(new StyleSpan(2), 0, localSpannableStringBuilder.length(), 33);
      localSpannableStringBuilder.append(Spannable.Factory.getInstance().newSpannable(str1));
    }
    while (true)
    {
      int i = SizeUtil.b(this.a, 14.0F);
      this.c.a(localSpannableStringBuilder, i);
      return localSpannableStringBuilder;
      localSpannableStringBuilder = new SpannableStringBuilder(Spannable.Factory.getInstance().newSpannable(str1));
    }
  }

  private String b(GeolocationInfo paramGeolocationInfo)
  {
    if ((Objects.equal(paramGeolocationInfo.f(), "CA")) || (Objects.equal(paramGeolocationInfo.f(), "US")));
    for (String str = paramGeolocationInfo.e(); ; str = null)
      return str;
  }

  private String b(String paramString1, String paramString2)
  {
    String str1 = paramString1.substring(paramString2.length());
    int i = 0;
    if ((i >= str1.length()) || (Character.isWhitespace(str1.charAt(i))))
      if (i != str1.length())
        break label55;
    label55: for (String str2 = ""; ; str2 = str1.substring(i).trim())
    {
      return str2;
      i++;
      break;
    }
  }

  private String[] b(GeolocationInfo paramGeolocationInfo1, GeolocationInfo paramGeolocationInfo2)
  {
    String[] arrayOfString = a(paramGeolocationInfo2);
    if (Objects.equal(paramGeolocationInfo1.f(), paramGeolocationInfo2.f()))
    {
      arrayOfString[1] = b(paramGeolocationInfo2);
      if (Objects.equal(paramGeolocationInfo1.d(), paramGeolocationInfo2.d()))
      {
        arrayOfString[1] = null;
        if (!StringUtil.a(paramGeolocationInfo2.c()))
        {
          arrayOfString[0] = paramGeolocationInfo2.c();
          arrayOfString[1] = paramGeolocationInfo2.d();
          if (arrayOfString[0].contains(arrayOfString[1]))
            arrayOfString[1] = null;
        }
      }
    }
    return arrayOfString;
  }

  public Spanned a(Message paramMessage)
  {
    return b(paramMessage);
  }

  public String a(GeolocationInfo paramGeolocationInfo1, GeolocationInfo paramGeolocationInfo2)
  {
    String str;
    if ((paramGeolocationInfo1 == null) || (StringUtil.a(paramGeolocationInfo1.d())))
      str = null;
    while (true)
    {
      return str;
      String[] arrayOfString;
      if (paramGeolocationInfo2 != null)
        arrayOfString = b(paramGeolocationInfo2, paramGeolocationInfo1);
      while (true)
      {
        if (!StringUtil.a(arrayOfString[1]))
          break label111;
        Resources localResources2 = this.a;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = arrayOfString[0];
        str = localResources2.getString(2131362688, arrayOfObject2);
        break;
        if (!StringUtil.a(Locale.getDefault().getISO3Country()))
        {
          arrayOfString = a(Locale.getDefault().getCountry(), paramGeolocationInfo1);
          continue;
        }
        arrayOfString = a(paramGeolocationInfo1);
      }
      label111: Resources localResources1 = this.a;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = arrayOfString[0];
      arrayOfObject1[1] = arrayOfString[1];
      str = localResources1.getString(2131362689, arrayOfObject1);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.util.MessageRenderingUtil
 * JD-Core Version:    0.6.0
 */