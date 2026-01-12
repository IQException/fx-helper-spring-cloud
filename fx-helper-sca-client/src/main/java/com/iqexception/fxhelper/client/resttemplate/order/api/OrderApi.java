package com.iqexception.fxhelper.client.resttemplate.order.api;

import com.iqexception.fxhelper.client.resttemplate.order.ApiClient;
import com.iqexception.fxhelper.client.resttemplate.order.BaseApi;

import com.iqexception.fxhelper.client.resttemplate.order.model.InternalGetOrderCountRequest;
import com.iqexception.fxhelper.client.resttemplate.order.model.InternalGetOrderListRequest;
import com.iqexception.fxhelper.client.resttemplate.order.model.InternalGetOrderTotalAmountRequest;
import com.iqexception.fxhelper.client.resttemplate.order.model.RequestOrderCreateParam;
import com.iqexception.fxhelper.client.resttemplate.order.model.RequestOrderPayParam;
import com.iqexception.fxhelper.client.resttemplate.order.model.ResponseInternalGetOrderCountResult;
import com.iqexception.fxhelper.client.resttemplate.order.model.ResponseInternalGetOrderListResult;
import com.iqexception.fxhelper.client.resttemplate.order.model.ResponseInternalGetOrderTotalAmountResult;
import com.iqexception.fxhelper.client.resttemplate.order.model.ResponseOrderCreateResult;
import com.iqexception.fxhelper.client.resttemplate.order.model.ResponseOrderPayResult;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-15T21:54:52.457772+08:00[Asia/Shanghai]", comments = "Generator version: 7.12.0")
@Component("com.iqexception.fxhelper.client.resttemplate.order.api.OrderApi")
public class OrderApi extends BaseApi {

    public OrderApi() {
        super(new ApiClient());
    }

    @Autowired
    public OrderApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestOrderCreateParam  (required)
     * @return ResponseOrderCreateResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseOrderCreateResult create(RequestOrderCreateParam requestOrderCreateParam) throws RestClientException {
        return createWithHttpInfo(requestOrderCreateParam).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestOrderCreateParam  (required)
     * @return ResponseEntity&lt;ResponseOrderCreateResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseOrderCreateResult> createWithHttpInfo(RequestOrderCreateParam requestOrderCreateParam) throws RestClientException {
        Object localVarPostBody = requestOrderCreateParam;
        
        // verify the required parameter 'requestOrderCreateParam' is set
        if (requestOrderCreateParam == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestOrderCreateParam' when calling create");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ResponseOrderCreateResult> localReturnType = new ParameterizedTypeReference<ResponseOrderCreateResult>() {};
        return apiClient.invokeAPI("/create", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetOrderCountRequest  (required)
     * @return ResponseInternalGetOrderCountResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseInternalGetOrderCountResult internalGetOrderCount(InternalGetOrderCountRequest internalGetOrderCountRequest) throws RestClientException {
        return internalGetOrderCountWithHttpInfo(internalGetOrderCountRequest).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetOrderCountRequest  (required)
     * @return ResponseEntity&lt;ResponseInternalGetOrderCountResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseInternalGetOrderCountResult> internalGetOrderCountWithHttpInfo(InternalGetOrderCountRequest internalGetOrderCountRequest) throws RestClientException {
        Object localVarPostBody = internalGetOrderCountRequest;
        
        // verify the required parameter 'internalGetOrderCountRequest' is set
        if (internalGetOrderCountRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'internalGetOrderCountRequest' when calling internalGetOrderCount");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ResponseInternalGetOrderCountResult> localReturnType = new ParameterizedTypeReference<ResponseInternalGetOrderCountResult>() {};
        return apiClient.invokeAPI("/internal/get_order_count", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetOrderListRequest  (required)
     * @return ResponseInternalGetOrderListResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseInternalGetOrderListResult internalGetOrderList(InternalGetOrderListRequest internalGetOrderListRequest) throws RestClientException {
        return internalGetOrderListWithHttpInfo(internalGetOrderListRequest).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetOrderListRequest  (required)
     * @return ResponseEntity&lt;ResponseInternalGetOrderListResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseInternalGetOrderListResult> internalGetOrderListWithHttpInfo(InternalGetOrderListRequest internalGetOrderListRequest) throws RestClientException {
        Object localVarPostBody = internalGetOrderListRequest;
        
        // verify the required parameter 'internalGetOrderListRequest' is set
        if (internalGetOrderListRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'internalGetOrderListRequest' when calling internalGetOrderList");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ResponseInternalGetOrderListResult> localReturnType = new ParameterizedTypeReference<ResponseInternalGetOrderListResult>() {};
        return apiClient.invokeAPI("/internal/get_order_list", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetOrderTotalAmountRequest  (required)
     * @return ResponseInternalGetOrderTotalAmountResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseInternalGetOrderTotalAmountResult internalGetTotalAmount(InternalGetOrderTotalAmountRequest internalGetOrderTotalAmountRequest) throws RestClientException {
        return internalGetTotalAmountWithHttpInfo(internalGetOrderTotalAmountRequest).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetOrderTotalAmountRequest  (required)
     * @return ResponseEntity&lt;ResponseInternalGetOrderTotalAmountResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseInternalGetOrderTotalAmountResult> internalGetTotalAmountWithHttpInfo(InternalGetOrderTotalAmountRequest internalGetOrderTotalAmountRequest) throws RestClientException {
        Object localVarPostBody = internalGetOrderTotalAmountRequest;
        
        // verify the required parameter 'internalGetOrderTotalAmountRequest' is set
        if (internalGetOrderTotalAmountRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'internalGetOrderTotalAmountRequest' when calling internalGetTotalAmount");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ResponseInternalGetOrderTotalAmountResult> localReturnType = new ParameterizedTypeReference<ResponseInternalGetOrderTotalAmountResult>() {};
        return apiClient.invokeAPI("/internal/get_order_total_amount", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestOrderPayParam  (required)
     * @return ResponseOrderPayResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseOrderPayResult pay(RequestOrderPayParam requestOrderPayParam) throws RestClientException {
        return payWithHttpInfo(requestOrderPayParam).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestOrderPayParam  (required)
     * @return ResponseEntity&lt;ResponseOrderPayResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseOrderPayResult> payWithHttpInfo(RequestOrderPayParam requestOrderPayParam) throws RestClientException {
        Object localVarPostBody = requestOrderPayParam;
        
        // verify the required parameter 'requestOrderPayParam' is set
        if (requestOrderPayParam == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestOrderPayParam' when calling pay");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ResponseOrderPayResult> localReturnType = new ParameterizedTypeReference<ResponseOrderPayResult>() {};
        return apiClient.invokeAPI("/pay", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    @Override
    public <T> ResponseEntity<T> invokeAPI(String url, HttpMethod method, Object request, ParameterizedTypeReference<T> returnType) throws RestClientException {
        String localVarPath = url.replace(apiClient.getBasePath(), "");
        Object localVarPostBody = request;

        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        return apiClient.invokeAPI(localVarPath, method, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, returnType);
    }
}
