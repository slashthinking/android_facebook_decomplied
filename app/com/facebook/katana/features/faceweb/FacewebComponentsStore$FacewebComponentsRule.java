package com.facebook.katana.features.faceweb;

import android.net.Uri;
import com.facebook.common.json.jsonmirror.JMAutogen.DynamicKeyDictType;
import com.facebook.common.json.jsonmirror.JMAutogen.ExplicitType;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.common.json.jsonmirror.types.JMForcedString;
import com.facebook.common.util.ErrorReporting;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

public class FacewebComponentsStore$FacewebComponentsRule
  implements JMStaticKeysDictDestination, Serializable
{
  private static final long serialVersionUID = -1980626292213325598L;

  @JMAutogen.ExplicitType(jsonFieldName="componentsId", type=JMForcedString.class)
  private String mComponentsId;

  @JMAutogen.InferredType(jsonFieldName="continueSearch")
  private boolean mContinueSearch;

  @JMAutogen.DynamicKeyDictType(jsonFieldName="parameters", valueElementType=JMForcedString.class)
  private Map<String, String> mParameters;

  @JMAutogen.ExplicitType(jsonFieldName="path", type=JMForcedString.class)
  private String mPathRegex;

  public boolean a(String paramString)
  {
    Uri localUri = Uri.parse(paramString);
    label35: String str1;
    Object localObject;
    int i;
    if (this.mPathRegex == null)
    {
      if (this.mParameters == null)
        break label212;
      Iterator localIterator = this.mParameters.entrySet().iterator();
      if (!localIterator.hasNext())
        break label212;
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      str1 = (String)localEntry.getKey();
      localObject = localEntry.getValue();
      if (localObject != null)
        break label135;
      ErrorReporting.a(FacewebComponentsStore.c(), "Null regex for param in rule" + toString(), true);
      i = 0;
    }
    while (true)
    {
      return i;
      if (Pattern.matches(this.mPathRegex, localUri.getPath()))
        break;
      i = 0;
      continue;
      label135: if (!(localObject instanceof String))
        ErrorReporting.a(FacewebComponentsStore.c(), "Non-string regex for param in rule" + toString(), true);
      String str2 = localObject.toString();
      String str3 = localUri.getQueryParameter(str1);
      if (str3 == null)
      {
        i = 0;
        continue;
      }
      if (Pattern.matches(str2, str3))
        break label35;
      i = 0;
      continue;
      label212: i = 1;
    }
  }

  public String toString()
  {
    return "Rule<path=" + this.mPathRegex + ", components=" + this.mComponentsId + ", params=" + String.valueOf(this.mParameters) + ">";
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.faceweb.FacewebComponentsStore.FacewebComponentsRule
 * JD-Core Version:    0.6.0
 */