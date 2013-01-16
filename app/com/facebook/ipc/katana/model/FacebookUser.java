package com.facebook.ipc.katana.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMAutogen;
import com.facebook.common.json.jsonmirror.JMAutogen.ExplicitType;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.common.util.Log;
import com.facebook.ipc.util.StringUtil.JMStrippedString;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookUser
  implements Parcelable, JMStaticKeysDictDestination
{
  public static final Parcelable.Creator<FacebookUser> CREATOR;
  public static final long INVALID_ID = -1L;
  public static final Class<?> TAG = FacebookUser.class;

  @JMAutogen.InferredType(jsonFieldName="can_post")
  public final boolean mCanPost;
  public final boolean mCanPostKnown;

  @JMAutogen.ExplicitType(jsonFieldName="name", type=StringUtil.JMStrippedString.class)
  public final String mDisplayName;

  @JMAutogen.ExplicitType(jsonFieldName="first_name", type=StringUtil.JMStrippedString.class)
  public final String mFirstName;

  @JMAutogen.ExplicitType(jsonFieldName="pic_square", type=StringUtil.JMStrippedString.class)
  public final String mImageUrl;

  @JMAutogen.ExplicitType(jsonFieldName="last_name", type=StringUtil.JMStrippedString.class)
  public final String mLastName;

  @JMAutogen.InferredType(jsonFieldName="uid")
  public final long mUserId;

  static
  {
    CREATOR = new FacebookUser.1();
  }

  protected FacebookUser()
  {
    this.mUserId = -1L;
    this.mFirstName = null;
    this.mLastName = null;
    this.mDisplayName = null;
    this.mImageUrl = null;
    this.mCanPost = false;
    this.mCanPostKnown = false;
  }

  public FacebookUser(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mUserId = paramLong;
    this.mFirstName = paramString1;
    this.mLastName = paramString2;
    this.mDisplayName = paramString3;
    this.mImageUrl = paramString4;
    this.mCanPost = false;
    this.mCanPostKnown = true;
  }

  public FacebookUser(Parcel paramParcel)
  {
    this.mUserId = paramParcel.readLong();
    this.mFirstName = paramParcel.readString();
    this.mLastName = paramParcel.readString();
    this.mDisplayName = paramParcel.readString();
    this.mImageUrl = paramParcel.readString();
    boolean[] arrayOfBoolean = new boolean[2];
    paramParcel.readBooleanArray(arrayOfBoolean);
    this.mCanPost = arrayOfBoolean[0];
    this.mCanPostKnown = arrayOfBoolean[1];
  }

  public static FacebookUser a(Class<? extends FacebookUser> paramClass, JsonParser paramJsonParser)
  {
    Object localObject = JMParser.a(paramJsonParser, JMAutogen.a(paramClass));
    if ((localObject instanceof FacebookUser));
    for (FacebookUser localFacebookUser = (FacebookUser)localObject; ; localFacebookUser = null)
      return localFacebookUser;
  }

  // ERROR //
  public static FacebookUser a(Class<? extends FacebookUser> paramClass, String paramString)
  {
    // Byte code:
    //   0: ldc 101
    //   2: invokestatic 87	com/facebook/common/json/jsonmirror/JMAutogen:a	(Ljava/lang/Class;)Lcom/facebook/common/json/jsonmirror/types/JMDict;
    //   5: astore_2
    //   6: aload_0
    //   7: invokevirtual 107	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   10: checkcast 2	com/facebook/ipc/katana/model/FacebookUser
    //   13: astore 4
    //   15: aload_2
    //   16: aload 4
    //   18: ldc 108
    //   20: aload_1
    //   21: invokevirtual 113	com/facebook/common/json/jsonmirror/types/JMDict:a	(Lcom/facebook/common/json/jsonmirror/JMDictDestination;Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload 4
    //   26: areturn
    //   27: astore 5
    //   29: aconst_null
    //   30: astore 4
    //   32: goto -8 -> 24
    //   35: astore_3
    //   36: aconst_null
    //   37: astore 4
    //   39: goto -15 -> 24
    //   42: astore 6
    //   44: aconst_null
    //   45: astore 4
    //   47: goto -23 -> 24
    //
    // Exception table:
    //   from	to	target	type
    //   6	15	27	java/lang/IllegalAccessException
    //   6	15	35	java/lang/InstantiationException
    //   15	24	42	com/facebook/common/json/jsonmirror/JMException
  }

  public String a()
  {
    if (this.mDisplayName == null)
      Log.a(TAG, "display name was requested, but is null");
    for (String str = ""; ; str = this.mDisplayName)
      return str;
  }

  public JSONObject b()
  {
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("uid", this.mUserId);
      localJSONObject.put("first_name", this.mFirstName);
      localJSONObject.put("last_name", this.mLastName);
      localJSONObject.put("name", this.mDisplayName);
      localJSONObject.put("pic_square", this.mImageUrl);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        JSONObject localJSONObject = new JSONObject();
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return Objects.toStringHelper(getClass()).add("display name", this.mDisplayName).add("uid", Long.valueOf(this.mUserId)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mUserId);
    paramParcel.writeString(this.mFirstName);
    paramParcel.writeString(this.mLastName);
    paramParcel.writeString(this.mDisplayName);
    boolean[] arrayOfBoolean = new boolean[2];
    arrayOfBoolean[0] = this.mCanPost;
    arrayOfBoolean[1] = this.mCanPostKnown;
    paramParcel.writeBooleanArray(arrayOfBoolean);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.katana.model.FacebookUser
 * JD-Core Version:    0.6.0
 */