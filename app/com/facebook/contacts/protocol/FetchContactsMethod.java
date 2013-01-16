package com.facebook.contacts.protocol;

import com.facebook.contacts.graphql.ContactGraphQL;
import com.facebook.contacts.graphql.GraphQLQuery;
import com.facebook.contacts.graphql.GraphQLQueryBuilder;
import com.facebook.contacts.models.ContactSummaryBuilder;
import com.facebook.contacts.server.FetchContactsParams;
import com.facebook.contacts.server.FetchContactsResult;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.orca.server.DataFreshnessResult;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

public class FetchContactsMethod
  implements ApiMethod<FetchContactsParams, FetchContactsResult>
{
  private static final Class<?> a = FetchContactsMethod.class;
  private final ContactGraphQL b;

  @Inject
  public FetchContactsMethod(ContactGraphQL paramContactGraphQL)
  {
    this.b = paramContactGraphQL;
  }

  private String a(Iterable<String> paramIterable)
  {
    GraphQLQueryBuilder localGraphQLQueryBuilder = GraphQLQuery.a(paramIterable);
    this.b.a(localGraphQLQueryBuilder);
    return localGraphQLQueryBuilder.f().toString();
  }

  public FetchContactsResult a(FetchContactsParams paramFetchContactsParams, ApiResponse paramApiResponse)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramApiResponse.c().fields();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      JsonNode localJsonNode = (JsonNode)localEntry.getValue();
      try
      {
        ContactSummaryBuilder localContactSummaryBuilder = this.b.a(localJsonNode);
        localBuilder.b(localContactSummaryBuilder.q());
      }
      catch (IOException localIOException)
      {
        BLog.e(a, "Couldn't deserialize contact: " + str + ", error: " + localIOException);
        throw localIOException;
      }
    }
    ImmutableList localImmutableList = localBuilder.b();
    BLog.b(a, "Got result: " + localImmutableList);
    return new FetchContactsResult(DataFreshnessResult.FROM_SERVER, System.currentTimeMillis(), localImmutableList);
  }

  public ApiRequest a(FetchContactsParams paramFetchContactsParams)
  {
    ArrayList localArrayList = Lists.a();
    String str = a(paramFetchContactsParams.a());
    BLog.b(a, "Sending query: " + str);
    localArrayList.add(new BasicNameValuePair("q", str));
    return new ApiRequest("fetchContacts", "GET", "graphql", localArrayList, ApiResponseType.JSON);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.protocol.FetchContactsMethod
 * JD-Core Version:    0.6.0
 */