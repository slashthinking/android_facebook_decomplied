package android_src.mms.model;

import android_src.drm.mobile1.DrmException;
import android_src.mms.ContentType;
import android_src.mms.MmsException;
import android_src.mms.dom.smil.SmilDocumentImpl;
import android_src.mms.dom.smil.parser.SmilXmlParser;
import android_src.mms.drm.DrmWrapper;
import android_src.mms.pdu.PduBody;
import android_src.mms.pdu.PduPart;
import com.facebook.orca.debug.BLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import org.w3c.dom.smil.SMILDocument;
import org.w3c.dom.smil.SMILElement;
import org.w3c.dom.smil.SMILLayoutElement;
import org.w3c.dom.smil.SMILMediaElement;
import org.w3c.dom.smil.SMILParElement;
import org.xml.sax.SAXException;

public class SmilHelper
{
  public static String a(String paramString)
  {
    return paramString.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;").replaceAll("'", "&apos;");
  }

  public static SMILDocument a(PduBody paramPduBody)
  {
    PduPart localPduPart = b(paramPduBody);
    SMILDocument localSMILDocument = null;
    if (localPduPart != null)
      localSMILDocument = a(localPduPart);
    if (localSMILDocument == null)
      localSMILDocument = c(paramPduBody);
    return localSMILDocument;
  }

  private static SMILDocument a(PduPart paramPduPart)
  {
    try
    {
      byte[] arrayOfByte = paramPduPart.a();
      if (arrayOfByte != null)
      {
        ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
        SMILDocument localSMILDocument2 = b(new SmilXmlParser().a(localByteArrayInputStream));
        localSMILDocument1 = localSMILDocument2;
        return localSMILDocument1;
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        BLog.d("fb-mms:Mms/smil", "Failed to parse SMIL document.", localIOException);
        SMILDocument localSMILDocument1 = null;
      }
    }
    catch (SAXException localSAXException)
    {
      while (true)
        BLog.d("fb-mms:Mms/smil", "Failed to parse SMIL document.", localSAXException);
    }
    catch (MmsException localMmsException)
    {
      while (true)
        BLog.d("fb-mms:Mms/smil", "Failed to parse SMIL document.", localMmsException);
    }
  }

  public static SMILMediaElement a(String paramString1, SMILDocument paramSMILDocument, String paramString2)
  {
    SMILMediaElement localSMILMediaElement = (SMILMediaElement)paramSMILDocument.createElement(paramString1);
    localSMILMediaElement.a(a(paramString2));
    return localSMILMediaElement;
  }

  public static SMILParElement a(SMILDocument paramSMILDocument)
  {
    SMILParElement localSMILParElement = (SMILParElement)paramSMILDocument.createElement("par");
    localSMILParElement.a(8.0F);
    paramSMILDocument.c().appendChild(localSMILParElement);
    return localSMILParElement;
  }

  private static PduPart b(PduBody paramPduBody)
  {
    int i = paramPduBody.b();
    int j = 0;
    PduPart localPduPart;
    if (j < i)
    {
      localPduPart = paramPduBody.a(j);
      if (!Arrays.equals(localPduPart.g(), "application/smil".getBytes()));
    }
    while (true)
    {
      return localPduPart;
      j++;
      break;
      localPduPart = null;
    }
  }

  private static SMILDocument b(SMILDocument paramSMILDocument)
  {
    return paramSMILDocument;
  }

  private static SMILDocument c(PduBody paramPduBody)
  {
    SmilDocumentImpl localSmilDocumentImpl1 = new SmilDocumentImpl();
    SMILElement localSMILElement1 = (SMILElement)localSmilDocumentImpl1.createElement("smil");
    localSMILElement1.setAttribute("xmlns", "http://www.w3.org/2001/SMIL20/Language");
    localSmilDocumentImpl1.appendChild(localSMILElement1);
    SMILElement localSMILElement2 = (SMILElement)localSmilDocumentImpl1.createElement("head");
    localSMILElement1.appendChild(localSMILElement2);
    localSMILElement2.appendChild((SMILLayoutElement)localSmilDocumentImpl1.createElement("layout"));
    localSMILElement1.appendChild((SMILElement)localSmilDocumentImpl1.createElement("body"));
    Object localObject1 = a(localSmilDocumentImpl1);
    int i = paramPduBody.b();
    if (i == 0);
    for (SmilDocumentImpl localSmilDocumentImpl2 = localSmilDocumentImpl1; ; localSmilDocumentImpl2 = localSmilDocumentImpl1)
    {
      return localSmilDocumentImpl2;
      int j = 0;
      int k = 0;
      int m = 0;
      while (true)
        if (j < i)
        {
          if ((localObject1 == null) || ((k != 0) && (m != 0)))
          {
            SMILParElement localSMILParElement = a(localSmilDocumentImpl1);
            m = 0;
            localObject1 = localSMILParElement;
            k = 0;
          }
          PduPart localPduPart = paramPduBody.a(j);
          Object localObject2 = new String(localPduPart.g());
          if (ContentType.h((String)localObject2));
          try
          {
            String str = new DrmWrapper((String)localObject2, localPduPart.b(), localPduPart.a()).b();
            localObject2 = str;
            if ((((String)localObject2).equals("text/plain")) || (((String)localObject2).equalsIgnoreCase("application/vnd.wap.xhtml+xml")) || (((String)localObject2).equals("text/html")))
            {
              ((SMILParElement)localObject1).appendChild(a("text", localSmilDocumentImpl1, localPduPart.k()));
              m = 1;
              j++;
            }
          }
          catch (DrmException localDrmException)
          {
            while (true)
              BLog.d("fb-mms:Mms/smil", localDrmException.getMessage(), localDrmException);
          }
          catch (IOException localIOException)
          {
            while (true)
            {
              BLog.d("fb-mms:Mms/smil", localIOException.getMessage(), localIOException);
              continue;
              if (ContentType.e((String)localObject2))
              {
                ((SMILParElement)localObject1).appendChild(a("img", localSmilDocumentImpl1, localPduPart.k()));
                k = 1;
                continue;
              }
              if (ContentType.g((String)localObject2))
              {
                ((SMILParElement)localObject1).appendChild(a("video", localSmilDocumentImpl1, localPduPart.k()));
                k = 1;
                continue;
              }
              if (ContentType.f((String)localObject2))
              {
                ((SMILParElement)localObject1).appendChild(a("audio", localSmilDocumentImpl1, localPduPart.k()));
                k = 1;
                continue;
              }
              BLog.d("fb-mms:Mms/smil", "unsupport media type");
            }
          }
        }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.model.SmilHelper
 * JD-Core Version:    0.6.0
 */