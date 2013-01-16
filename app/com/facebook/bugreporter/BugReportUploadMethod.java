package com.facebook.bugreporter;

import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.apache.http.entity.mime.FormBodyPart;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.protocol.base.DataStreamBody;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;

public class BugReportUploadMethod
  implements ApiMethod<BugReportUploadParams, Boolean>
{
  private static final Class<?> a = BugReportUploadMethod.class;
  private final BugReporterConfig b;

  public BugReportUploadMethod(BugReporterConfig paramBugReporterConfig)
  {
    this.b = paramBugReporterConfig;
  }

  public ApiRequest a(BugReportUploadParams paramBugReportUploadParams)
  {
    int i = 0;
    ArrayList localArrayList1 = Lists.a();
    localArrayList1.add(new BasicNameValuePair("desc", paramBugReportUploadParams.a()));
    localArrayList1.add(new BasicNameValuePair("log", paramBugReportUploadParams.c()));
    localArrayList1.add(new BasicNameValuePair("format", "json-strings"));
    localArrayList1.add(new BasicNameValuePair("subscriber_ids", StringLocaleUtil.b("[%s]", new Object[] { "303504926414896" })));
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    localObjectNode.put("Git_Hash", paramBugReportUploadParams.e());
    localObjectNode.put("Build_Num", paramBugReportUploadParams.f());
    localObjectNode.put("OS_Version", Build.VERSION.RELEASE);
    localObjectNode.put("Manufacturer", Build.MANUFACTURER);
    localObjectNode.put("Model", Build.MODEL);
    localObjectNode.put("Locale", Locale.getDefault().getDisplayName(Locale.US));
    localArrayList1.add(new BasicNameValuePair("info", localObjectNode.toString()));
    ArrayNode localArrayNode = new ArrayNode(JsonNodeFactory.instance);
    localArrayNode.add(393081277401836L);
    Iterator localIterator1 = this.b.b().iterator();
    while (localIterator1.hasNext())
      localArrayNode.add((Long)localIterator1.next());
    if (paramBugReportUploadParams.d() != null)
    {
      Iterator localIterator3 = paramBugReportUploadParams.d().iterator();
      while (localIterator3.hasNext())
        localArrayNode.add((Long)localIterator3.next());
    }
    localArrayList1.add(new BasicNameValuePair("tag_ids", localArrayNode.toString()));
    ArrayList localArrayList2 = new ArrayList();
    if ((paramBugReportUploadParams.b() != null) && (!paramBugReportUploadParams.b().isEmpty()))
    {
      Iterator localIterator2 = paramBugReportUploadParams.b().iterator();
      File localFile;
      int j;
      while (true)
      {
        if (!localIterator2.hasNext())
          break label518;
        Uri localUri = (Uri)localIterator2.next();
        try
        {
          localFile = new File(new URI(localUri.toString()));
          if ((!localFile.exists()) || (!localFile.canRead()))
            BLog.d(a, "Ignoring invalid screen shot file");
        }
        catch (URISyntaxException localURISyntaxException)
        {
          BLog.d(a, "Ignoring invalid screen shot", localURISyntaxException);
          j = i;
        }
      }
      while (true)
      {
        i = j;
        break;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(i);
        String str = StringLocaleUtil.a("screenshot-%d.png", arrayOfObject);
        localArrayList2.add(new FormBodyPart(str, new DataStreamBody(localFile, "image/png", str)));
        j = i + 1;
      }
    }
    label518: return new ApiRequest("bugReportUpload", "POST", "method/bug.create", localArrayList1, ApiResponseType.JSON, localArrayList2);
  }

  public Boolean a(BugReportUploadParams paramBugReportUploadParams, ApiResponse paramApiResponse)
  {
    boolean bool = false;
    if (paramApiResponse.a() != 200)
    {
      Class localClass = a;
      Object[] arrayOfObject1 = new Object[1];
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(paramApiResponse.a());
      arrayOfObject2[1] = paramApiResponse.e().toString();
      arrayOfObject1[0] = StringLocaleUtil.a("error code: %d, msg: %s", arrayOfObject2);
      BLog.e(localClass, StringLocaleUtil.b("Bug report upload failed: %s", arrayOfObject1));
    }
    while (true)
    {
      return Boolean.valueOf(bool);
      bool = true;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.BugReportUploadMethod
 * JD-Core Version:    0.6.0
 */