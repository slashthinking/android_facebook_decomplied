package com.facebook.apache.http.entity.mime;

import com.facebook.apache.http.entity.mime.content.ContentBody;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class FormBodyPart
{
  private final String a;
  private final Header b;
  private final ContentBody c;

  public FormBodyPart(String paramString, ContentBody paramContentBody)
  {
    if (paramString == null)
      throw new IllegalArgumentException("Name may not be null");
    if (paramContentBody == null)
      throw new IllegalArgumentException("Body may not be null");
    this.a = paramString;
    this.c = paramContentBody;
    this.b = new Header();
    a(paramContentBody);
    b(paramContentBody);
    c(paramContentBody);
  }

  public String a()
  {
    return this.a;
  }

  protected void a(ContentBody paramContentBody)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("form-data; name=\"");
    localStringBuilder.append(a());
    localStringBuilder.append("\"");
    if (paramContentBody.b() != null)
    {
      localStringBuilder.append("; filename=\"");
      localStringBuilder.append(paramContentBody.b());
      localStringBuilder.append("\"");
    }
    a("Content-Disposition", localStringBuilder.toString());
  }

  public void a(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      throw new IllegalArgumentException("Field name may not be null");
    this.b.a(new MinimalField(paramString1, paramString2));
  }

  public ContentBody b()
  {
    return this.c;
  }

  protected void b(ContentBody paramContentBody)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContentBody.a());
    if (paramContentBody.c() != null)
    {
      localStringBuilder.append("; charset=");
      localStringBuilder.append(paramContentBody.c());
    }
    a("Content-Type", localStringBuilder.toString());
  }

  public Header c()
  {
    return this.b;
  }

  protected void c(ContentBody paramContentBody)
  {
    a("Content-Transfer-Encoding", paramContentBody.d());
  }

  public ObjectNode d()
  {
    return new ObjectNode(JsonNodeFactory.instance);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.apache.http.entity.mime.FormBodyPart
 * JD-Core Version:    0.6.0
 */