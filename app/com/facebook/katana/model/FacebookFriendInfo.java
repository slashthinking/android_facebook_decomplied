package com.facebook.katana.model;

import com.facebook.common.json.jsonmirror.JMAutogen.ExplicitType;
import com.facebook.common.json.jsonmirror.JMAutogen.ListType;
import com.facebook.common.json.jsonmirror.JMDictDestination.PostProcessable;
import com.facebook.common.json.jsonmirror.types.JMDict;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.util.StringUtils.JMNulledString;
import com.facebook.katana.util.Utils;
import com.google.common.collect.ImmutableList;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FacebookFriendInfo extends FacebookUser
  implements JMDictDestination.PostProcessable
{

  @JMAutogen.ExplicitType(jsonFieldName="birthday_date", type=StringUtils.JMNulledString.class)
  private final String mBirthday = null;
  public final int mBirthdayDay = -1;
  public final int mBirthdayMonth = -1;
  public final int mBirthdayYear = -1;

  @JMAutogen.ExplicitType(jsonFieldName="cell", type=StringUtils.JMNulledString.class)
  public final String mCellPhone = null;

  @JMAutogen.ExplicitType(jsonFieldName="contact_email", type=StringUtils.JMNulledString.class)
  public final String mContactEmail = null;

  @JMAutogen.ExplicitType(jsonFieldName="other_phone", type=StringUtils.JMNulledString.class)
  public final String mOtherPhone = null;
  public final String mSearchToken = null;

  @JMAutogen.ListType(b={StringUtils.JMNulledString.class}, jsonFieldName="search_tokens")
  public final ImmutableList<String> mSearchTokens = null;

  private String a(ImmutableList<String> paramImmutableList)
  {
    if (paramImmutableList.size() == 0);
    StringBuilder localStringBuilder;
    for (String str = ""; ; str = localStringBuilder.toString())
    {
      return str;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" ");
      localStringBuilder.append(StringUtils.a(" ", new Object[] { paramImmutableList }));
    }
  }

  public void a(JMDict paramJMDict)
  {
    Date localDate;
    if (this.mBirthday != null)
    {
      localDate = new SimpleDateFormat("M/d/y", Locale.US).parse(this.mBirthday, new ParsePosition(0));
      if (localDate == null)
        break label107;
    }
    for (int i = 1; ; i = 0)
    {
      if (localDate != null)
      {
        paramJMDict.a(this, "mBirthdayMonth", 1 + localDate.getMonth());
        paramJMDict.a(this, "mBirthdayDay", localDate.getDate());
        if (i != 0)
          paramJMDict.a(this, "mBirthdayYear", 1900 + localDate.getYear());
      }
      paramJMDict.a(this, "mSearchToken", a(this.mSearchTokens));
      return;
      label107: localDate = new SimpleDateFormat("M/d", Locale.US).parse(this.mBirthday, new ParsePosition(0));
    }
  }

  public long c()
  {
    Object[] arrayOfObject = new Object[11];
    arrayOfObject[0] = Long.valueOf(this.mUserId);
    arrayOfObject[1] = this.mFirstName;
    arrayOfObject[2] = this.mLastName;
    arrayOfObject[3] = this.mImageUrl;
    arrayOfObject[4] = this.mCellPhone;
    arrayOfObject[5] = this.mOtherPhone;
    arrayOfObject[6] = this.mContactEmail;
    arrayOfObject[7] = Integer.valueOf(this.mBirthdayMonth);
    arrayOfObject[8] = Integer.valueOf(this.mBirthdayDay);
    arrayOfObject[9] = Integer.valueOf(this.mBirthdayYear);
    arrayOfObject[10] = this.mSearchToken;
    return Utils.c(arrayOfObject);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookFriendInfo
 * JD-Core Version:    0.6.0
 */