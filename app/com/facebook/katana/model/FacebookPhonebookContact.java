package com.facebook.katana.model;

import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.common.util.Log;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookPhonebookContact
  implements JMStaticKeysDictDestination
{
  private static final Class<?> TAG = FacebookPhonebookContact.class;

  @JMAutogen.InferredType(jsonFieldName="email")
  public final String email;
  public List<String> emails;
  public long incomingCallCount = 0L;
  public long incomingCallDuration = 0L;

  @JMAutogen.InferredType(jsonFieldName="is_friend")
  public final boolean isFriend;

  @JMAutogen.InferredType(jsonFieldName="name")
  public String name;

  @JMAutogen.InferredType(jsonFieldName="ordinal")
  public final long ordinal;
  public long outgoingCallCount = 0L;
  public long outgoingCallDuration = 0L;

  @JMAutogen.InferredType(jsonFieldName="cell")
  public final String phone;
  public List<String> phones;

  @JMAutogen.InferredType(jsonFieldName="record_id")
  public final long recordId;

  @JMAutogen.InferredType(jsonFieldName="uid")
  public final long userId;

  private FacebookPhonebookContact()
  {
    this.name = null;
    this.recordId = -1L;
    this.isFriend = false;
    this.userId = -1L;
    this.phone = null;
    this.phones = null;
    this.email = null;
    this.emails = null;
    this.ordinal = 0L;
  }

  public FacebookPhonebookContact(String paramString, long paramLong, List<String> paramList1, List<String> paramList2)
  {
    this.name = paramString;
    this.recordId = paramLong;
    this.emails = paramList1;
    if ((this.emails != null) && (this.emails.size() > 0))
    {
      this.email = ((String)this.emails.get(0));
      this.phones = paramList2;
      if ((this.phones == null) || (this.phones.size() <= 0))
        break label144;
    }
    label144: for (this.phone = ((String)this.phones.get(0)); ; this.phone = null)
    {
      this.userId = -1L;
      this.isFriend = false;
      this.ordinal = 0L;
      return;
      this.email = null;
      break;
    }
  }

  protected FacebookPhonebookContact(String paramString1, long paramLong1, boolean paramBoolean, long paramLong2, String paramString2, String paramString3, long paramLong3)
  {
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add(paramString3);
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(paramString2);
    this.name = paramString1;
    this.recordId = paramLong1;
    this.isFriend = paramBoolean;
    this.userId = paramLong2;
    this.phone = paramString2;
    this.phones = localArrayList2;
    this.email = paramString3;
    this.emails = localArrayList1;
    this.ordinal = paramLong3;
  }

  public static int a(FacebookPhonebookContact paramFacebookPhonebookContact)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramFacebookPhonebookContact);
    return a(localArrayList).hashCode();
  }

  public static String a(List<FacebookPhonebookContact> paramList)
  {
    JSONArray localJSONArray1;
    FacebookPhonebookContact localFacebookPhonebookContact;
    JSONObject localJSONObject;
    JSONArray localJSONArray3;
    Object localObject;
    try
    {
      localJSONArray1 = new JSONArray();
      Iterator localIterator1 = paramList.iterator();
      if (localIterator1.hasNext())
      {
        localFacebookPhonebookContact = (FacebookPhonebookContact)localIterator1.next();
        localJSONObject = new JSONObject();
        if (localFacebookPhonebookContact.name != null)
          localJSONObject.put("name", localFacebookPhonebookContact.name);
        List localList1 = localFacebookPhonebookContact.emails;
        if ((localList1 != null) && (localList1.size() > 0))
        {
          localJSONArray3 = new JSONArray();
          Iterator localIterator3 = localList1.iterator();
          while (localIterator3.hasNext())
            localJSONArray3.put((String)localIterator3.next());
        }
      }
    }
    catch (JSONException localJSONException)
    {
      Class localClass = TAG;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localJSONException.getMessage();
      Log.a(localClass, StringLocaleUtil.a("How do we get a JSONException when *encoding* data? %s", arrayOfObject));
      localObject = "";
    }
    while (true)
    {
      return localObject;
      localJSONObject.put("emails", localJSONArray3);
      List localList2 = localFacebookPhonebookContact.phones;
      if ((localList2 != null) && (localList2.size() > 0))
      {
        JSONArray localJSONArray2 = new JSONArray();
        Iterator localIterator2 = localList2.iterator();
        while (localIterator2.hasNext())
          localJSONArray2.put((String)localIterator2.next());
        localJSONObject.put("phones", localJSONArray2);
      }
      if (localFacebookPhonebookContact.recordId != -1L)
        localJSONObject.put("record_id", String.valueOf(localFacebookPhonebookContact.recordId));
      if ((localFacebookPhonebookContact.incomingCallCount > 0L) || (localFacebookPhonebookContact.outgoingCallCount > 0L))
      {
        localJSONObject.put("calls_in", localFacebookPhonebookContact.incomingCallCount);
        localJSONObject.put("calls_out", localFacebookPhonebookContact.outgoingCallCount);
        localJSONObject.put("calls_in_duration", localFacebookPhonebookContact.incomingCallDuration);
        localJSONObject.put("calls_out_duration", localFacebookPhonebookContact.outgoingCallDuration);
      }
      localJSONArray1.put(localJSONObject);
      break;
      String str = localJSONArray1.toString();
      localObject = str;
    }
  }

  public String a()
  {
    String str = "";
    if (this.email != null)
      str = this.email;
    while (true)
    {
      return str;
      if (this.phone == null)
        continue;
      str = this.phone;
    }
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    while (true)
    {
      return i;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        i = 0;
        continue;
      }
      FacebookPhonebookContact localFacebookPhonebookContact = (FacebookPhonebookContact)paramObject;
      if (this.incomingCallCount != localFacebookPhonebookContact.incomingCallCount)
      {
        i = 0;
        continue;
      }
      if (this.incomingCallDuration != localFacebookPhonebookContact.incomingCallDuration)
      {
        i = 0;
        continue;
      }
      if (this.isFriend != localFacebookPhonebookContact.isFriend)
      {
        i = 0;
        continue;
      }
      if (this.ordinal != localFacebookPhonebookContact.ordinal)
      {
        i = 0;
        continue;
      }
      if (this.outgoingCallCount != localFacebookPhonebookContact.outgoingCallCount)
      {
        i = 0;
        continue;
      }
      if (this.outgoingCallDuration != localFacebookPhonebookContact.outgoingCallDuration)
      {
        i = 0;
        continue;
      }
      if (this.recordId != localFacebookPhonebookContact.recordId)
      {
        i = 0;
        continue;
      }
      if (this.userId != localFacebookPhonebookContact.userId)
      {
        i = 0;
        continue;
      }
      if (!this.emails.equals(localFacebookPhonebookContact.emails))
      {
        i = 0;
        continue;
      }
      if (!this.name.equals(localFacebookPhonebookContact.name))
      {
        i = 0;
        continue;
      }
      if (this.phones.equals(localFacebookPhonebookContact.phones))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[11];
    arrayOfObject[0] = this.name;
    arrayOfObject[1] = Long.valueOf(this.recordId);
    arrayOfObject[2] = Long.valueOf(this.userId);
    arrayOfObject[3] = Boolean.valueOf(this.isFriend);
    arrayOfObject[4] = Long.valueOf(this.ordinal);
    arrayOfObject[5] = this.phones;
    arrayOfObject[6] = this.emails;
    arrayOfObject[7] = Long.valueOf(this.incomingCallCount);
    arrayOfObject[8] = Long.valueOf(this.incomingCallDuration);
    arrayOfObject[9] = Long.valueOf(this.outgoingCallCount);
    arrayOfObject[10] = Long.valueOf(this.outgoingCallDuration);
    return Objects.hashCode(arrayOfObject);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookPhonebookContact
 * JD-Core Version:    0.6.0
 */