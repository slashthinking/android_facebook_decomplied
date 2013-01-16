package com.facebook.katana.service.method;

import com.facebook.common.json.FbJsonChecker;
import com.facebook.katana.model.FacebookApiException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.util.TokenBuffer;

public class JsonResponseVerifier
{
  public static JsonParser a(JsonParser paramJsonParser)
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.START_OBJECT)
    {
      TokenBuffer localTokenBuffer = new TokenBuffer(paramJsonParser.getCodec());
      localTokenBuffer.copyCurrentStructure(paramJsonParser);
      JsonParser localJsonParser1 = localTokenBuffer.asParser();
      FbJsonChecker.a(localJsonParser1);
      if (FbJsonChecker.a(localJsonParser1) == JsonToken.END_OBJECT)
        throw new FacebookApiException(-1, "Malformed JSON: received an empty object in scalar response");
      JsonParser localJsonParser2 = localTokenBuffer.asParser();
      FbJsonChecker.a(localJsonParser2);
      throw new FacebookApiException(localJsonParser2);
    }
    if (localJsonToken == JsonToken.START_ARRAY)
      throw new FacebookApiException(-1, "Malformed JSON: received an array in scalar response");
    return paramJsonParser;
  }

  public static JsonParser verifyContainsArray(JsonParser paramJsonParser)
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.START_ARRAY);
    while (true)
    {
      return paramJsonParser;
      if (localJsonToken != JsonToken.START_OBJECT)
        break;
      TokenBuffer localTokenBuffer1 = new TokenBuffer(paramJsonParser.getCodec());
      localTokenBuffer1.copyCurrentStructure(paramJsonParser);
      JsonParser localJsonParser1 = localTokenBuffer1.asParser();
      FbJsonChecker.a(localJsonParser1);
      if (FbJsonChecker.a(localJsonParser1) == JsonToken.END_OBJECT)
      {
        TokenBuffer localTokenBuffer2 = new TokenBuffer(localJsonParser1.getCodec());
        localTokenBuffer2.writeStartArray();
        localTokenBuffer2.writeEndArray();
        paramJsonParser = localTokenBuffer2.asParser();
        FbJsonChecker.a(paramJsonParser);
        continue;
      }
      JsonParser localJsonParser2 = localTokenBuffer1.asParser();
      FbJsonChecker.a(localJsonParser2);
      throw new FacebookApiException(localJsonParser2);
    }
    throw new FacebookApiException(-1, "Malformed JSON in FQL response");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.JsonResponseVerifier
 * JD-Core Version:    0.6.0
 */