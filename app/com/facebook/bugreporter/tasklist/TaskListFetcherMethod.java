package com.facebook.bugreporter.tasklist;

import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class TaskListFetcherMethod
  implements ApiMethod<TaskListFetcherParams, ImmutableList<Task>>
{
  private static final Class<?> a = TaskListFetcherMethod.class;

  public ApiRequest a(TaskListFetcherParams paramTaskListFetcherParams)
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("app", "android"));
    localArrayList.add(new BasicNameValuePair("format", "json-strings"));
    localArrayList.add(new BasicNameValuePair("limit", "10"));
    ArrayNode localArrayNode = new ArrayNode(JsonNodeFactory.instance);
    Iterator localIterator = paramTaskListFetcherParams.a().iterator();
    while (localIterator.hasNext())
      localArrayNode.add((Long)localIterator.next());
    localArrayList.add(new BasicNameValuePair("tag_ids", localArrayNode.toString()));
    return new ApiRequest("taskListFetcher", "POST", "method/bug.searchbytags", localArrayList, ApiResponseType.STRING);
  }

  public ImmutableList<Task> a(TaskListFetcherParams paramTaskListFetcherParams, ApiResponse paramApiResponse)
  {
    if (paramApiResponse.a() != 200)
    {
      Class localClass = a;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(paramApiResponse.a());
      arrayOfObject[1] = paramApiResponse.e();
      BLog.d(localClass, "TaskListFetching failed: error code: %d, msg: %s", arrayOfObject);
    }
    for (ImmutableList localImmutableList = ImmutableList.d(); ; localImmutableList = ImmutableList.a(JMParser.b(new JsonFactory().createJsonParser(paramApiResponse.b()), Task.class)))
      return localImmutableList;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.tasklist.TaskListFetcherMethod
 * JD-Core Version:    0.6.0
 */