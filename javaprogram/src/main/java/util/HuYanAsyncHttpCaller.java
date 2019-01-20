package util;

import io.netty.handler.ssl.SslContextBuilder;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLException;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.RequestBuilder;
import org.asynchttpclient.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * created by huyanshi on 2019/1/19
 */
public class HuYanAsyncHttpCaller {

  private static final int CONNECT_TIMEOUT = 60000;

  private static final int MAX_CONNECTIONS = 3000;

  private static final int CONNECTION_TTL = 500;

  private static final long DEFAULT_TIMEOUT = 5000L;

  private static final int SUCCESS_CODE = 200;


  private static final Logger LOG = LoggerFactory.getLogger(HuYanAsyncHttpCaller.class);

  private static AsyncHttpClient httpClient = (DefaultAsyncHttpClient) Dsl
      .asyncHttpClient(
          Dsl.config().setConnectTimeout(CONNECT_TIMEOUT).setMaxConnections(MAX_CONNECTIONS)
              .setConnectionTtl(CONNECTION_TTL));

  private static AsyncHttpClient sslHttpClient;

  static {
    try {
      sslHttpClient = Dsl
          .asyncHttpClient(
              Dsl.config().setConnectTimeout(CONNECT_TIMEOUT).setMaxConnections(MAX_CONNECTIONS)
                  .setConnectionTtl(CONNECTION_TTL).setUseOpenSsl(true)
                  .setSslContext(SslContextBuilder.forClient().build()));
    } catch (SSLException e) {
      LOG.warn("init httpclient error:%s", e.getMessage());
    }
  }

  /**
   * get.
   *
   * @param url url
   * @param header header
   * @return AsyncHttpResponse
   */
  public Optional<AsyncHttpResponse> get(String url, Map<String, String> header) {
    return get(url, null, header, DEFAULT_TIMEOUT, false);
  }


  /**
   * get with full param.
   *
   * @param url url
   * @param params params
   * @param header header
   * @param timeout timeout
   * @param useSsl use ssl
   * @return AsyncHttpResponse
   */
  public Optional<AsyncHttpResponse> get(String url, Map<String, String> params,
      Map<String, String> header, long timeout, boolean useSsl) {
    try {
      RequestBuilder requestBuilder = Dsl.get(url);
      buildRequest(requestBuilder, params, header);
      return getResult(requestBuilder, useSsl, timeout, url);
    } catch (Exception e) {
      LOG.warn("http get error:%s", e.getMessage());
      e.printStackTrace();
    }
    return Optional.empty();
  }

  /**
   * post.
   *
   * @param url url
   * @param body body
   * @param header header
   * @return AsyncHttpResponse
   */
  public Optional<AsyncHttpResponse> post(String url, String body, Map<String, String> header) {
    return post(url, null, header, body, DEFAULT_TIMEOUT, false);
  }

  /**
   * post with full param.
   *
   * @param url url
   * @param params params
   * @param header header
   * @param body body
   * @param timeout timeout
   * @param useSsl use ssl
   * @return AsyncHttpResponse
   */
  public Optional<AsyncHttpResponse> post(String url, Map<String, String> params,
      Map<String, String> header, String body, long timeout, boolean useSsl) {
    try {
      RequestBuilder requestBuilder = Dsl.post(url);
      buildRequest(requestBuilder, params, header);
      requestBuilder.setBody(body);
      return getResult(requestBuilder, useSsl, timeout, url);
    } catch (Exception e) {
      LOG.warn("http post error:%s", e.getMessage());
    }
    return Optional.empty();
  }


  /**
   * request with full param
   *
   * @param url url
   * @param method method
   * @param params params
   * @param header header
   * @param body body
   * @param timeout timeout
   * @param useSsl useSsl
   * @return AsyncHttpResponse
   */
  public Optional<AsyncHttpResponse> request(String url, String method,
      Map<String, String> params,
      Map<String, String> header, String body, long timeout, boolean useSsl) {
    try {
      RequestBuilder requestBuilder;
      switch (method) {
        case "GET":
          requestBuilder = Dsl.get(url);
          break;
        case "POST":
          requestBuilder = Dsl.post(url);
          break;
        case "PUT":
          requestBuilder = Dsl.put(url);
          break;
        case "DELETE":
          requestBuilder = Dsl.delete(url);
          break;
        default:
          requestBuilder = Dsl.get(url);
      }
      buildRequest(requestBuilder, params, header);
      requestBuilder.setBody(body);
      return getResult(requestBuilder, useSsl, timeout, url);
    } catch (Exception e) {
      LOG.warn("http post error:%s", e.getMessage());
    }
    return Optional.empty();
  }

  private Optional<AsyncHttpResponse> getResult(RequestBuilder requestBuilder, boolean useSsl,
      long timeout, String url)
      throws InterruptedException, ExecutionException, TimeoutException {
    return useSsl ? covertToTaskResponse(
        sslHttpClient.executeRequest(requestBuilder).get(timeout, TimeUnit.MILLISECONDS),
        url) : covertToTaskResponse(
        httpClient.executeRequest(requestBuilder).get(timeout, TimeUnit.MILLISECONDS), url);
  }

  private void buildRequest(RequestBuilder requestBuilder, Map<String, String> params,
      Map<String, String> header) {
    if (null != params && !params.isEmpty()) {
      params.entrySet().forEach(entry -> {
        requestBuilder.addQueryParam(entry.getKey(), entry.getValue());
      });
    }
    if (null != header &&!header.isEmpty()) {
      header.entrySet().forEach(entry -> {
        requestBuilder.addHeader(entry.getKey(), entry.getValue());
      });
    }
  }

  private Optional<AsyncHttpResponse> covertToTaskResponse(Response response, String url) {
    if (response.getStatusCode() != SUCCESS_CODE) {
      LOG.warn("request url : %s failed with response : %s", url, response);
      return Optional.empty();
    }
    AsyncHttpResponse asyncHttpResponse = new AsyncHttpResponse();
    asyncHttpResponse.errMsg = response.getStatusText();
    asyncHttpResponse.errCode = response.getStatusCode();
    asyncHttpResponse.content = response.getResponseBody();
    return Optional.of(asyncHttpResponse);
  }

}
