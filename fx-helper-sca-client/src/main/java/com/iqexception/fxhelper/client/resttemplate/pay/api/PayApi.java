package com.iqexception.fxhelper.client.resttemplate.pay.api;

import com.iqexception.fxhelper.client.resttemplate.pay.ApiClient;
import com.iqexception.fxhelper.client.resttemplate.pay.BaseApi;

import com.iqexception.fxhelper.client.resttemplate.pay.model.Acct2wxRequest;
import com.iqexception.fxhelper.client.resttemplate.pay.model.RequestDepositParam;
import com.iqexception.fxhelper.client.resttemplate.pay.model.RequestWithdrawParam;
import com.iqexception.fxhelper.client.resttemplate.pay.model.ResponseDepositResult;
import com.iqexception.fxhelper.client.resttemplate.pay.model.ResponseInternalAcct2wxResult;
import com.iqexception.fxhelper.client.resttemplate.pay.model.ResponseWithdrawResult;

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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-15T21:27:01.938116+08:00[Asia/Shanghai]", comments = "Generator version: 7.12.0")
@Component("com.iqexception.fxhelper.client.resttemplate.pay.api.PayApi")
public class PayApi extends BaseApi {

    public PayApi() {
        super(new ApiClient());
    }

    @Autowired
    public PayApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param acct2wxRequest  (required)
     * @return ResponseInternalAcct2wxResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseInternalAcct2wxResult acct2wx(Acct2wxRequest acct2wxRequest) throws RestClientException {
        return acct2wxWithHttpInfo(acct2wxRequest).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param acct2wxRequest  (required)
     * @return ResponseEntity&lt;ResponseInternalAcct2wxResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseInternalAcct2wxResult> acct2wxWithHttpInfo(Acct2wxRequest acct2wxRequest) throws RestClientException {
        Object localVarPostBody = acct2wxRequest;
        
        // verify the required parameter 'acct2wxRequest' is set
        if (acct2wxRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'acct2wxRequest' when calling acct2wx");
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

        ParameterizedTypeReference<ResponseInternalAcct2wxResult> localReturnType = new ParameterizedTypeReference<ResponseInternalAcct2wxResult>() {};
        return apiClient.invokeAPI("/internal/acct2wx", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestDepositParam  (required)
     * @return ResponseDepositResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseDepositResult deposit(RequestDepositParam requestDepositParam) throws RestClientException {
        return depositWithHttpInfo(requestDepositParam).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestDepositParam  (required)
     * @return ResponseEntity&lt;ResponseDepositResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseDepositResult> depositWithHttpInfo(RequestDepositParam requestDepositParam) throws RestClientException {
        Object localVarPostBody = requestDepositParam;
        
        // verify the required parameter 'requestDepositParam' is set
        if (requestDepositParam == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestDepositParam' when calling deposit");
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

        ParameterizedTypeReference<ResponseDepositResult> localReturnType = new ParameterizedTypeReference<ResponseDepositResult>() {};
        return apiClient.invokeAPI("/deposit", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param wechatpaySignature  (required)
     * @param wechatpaySerial  (required)
     * @param wechatpayNonce  (required)
     * @param wechatpayTimestamp  (required)
     * @param wechatpaySignatureType  (required)
     * @param body  (required)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String payNotify(String wechatpaySignature, String wechatpaySerial, String wechatpayNonce, String wechatpayTimestamp, String wechatpaySignatureType, String body) throws RestClientException {
        return payNotifyWithHttpInfo(wechatpaySignature, wechatpaySerial, wechatpayNonce, wechatpayTimestamp, wechatpaySignatureType, body).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param wechatpaySignature  (required)
     * @param wechatpaySerial  (required)
     * @param wechatpayNonce  (required)
     * @param wechatpayTimestamp  (required)
     * @param wechatpaySignatureType  (required)
     * @param body  (required)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> payNotifyWithHttpInfo(String wechatpaySignature, String wechatpaySerial, String wechatpayNonce, String wechatpayTimestamp, String wechatpaySignatureType, String body) throws RestClientException {
        Object localVarPostBody = body;
        
        // verify the required parameter 'wechatpaySignature' is set
        if (wechatpaySignature == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'wechatpaySignature' when calling payNotify");
        }
        
        // verify the required parameter 'wechatpaySerial' is set
        if (wechatpaySerial == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'wechatpaySerial' when calling payNotify");
        }
        
        // verify the required parameter 'wechatpayNonce' is set
        if (wechatpayNonce == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'wechatpayNonce' when calling payNotify");
        }
        
        // verify the required parameter 'wechatpayTimestamp' is set
        if (wechatpayTimestamp == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'wechatpayTimestamp' when calling payNotify");
        }
        
        // verify the required parameter 'wechatpaySignatureType' is set
        if (wechatpaySignatureType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'wechatpaySignatureType' when calling payNotify");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling payNotify");
        }
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        if (wechatpaySignature != null)
        localVarHeaderParams.add("Wechatpay-Signature", apiClient.parameterToString(wechatpaySignature));
        if (wechatpaySerial != null)
        localVarHeaderParams.add("Wechatpay-Serial", apiClient.parameterToString(wechatpaySerial));
        if (wechatpayNonce != null)
        localVarHeaderParams.add("Wechatpay-Nonce", apiClient.parameterToString(wechatpayNonce));
        if (wechatpayTimestamp != null)
        localVarHeaderParams.add("Wechatpay-Timestamp", apiClient.parameterToString(wechatpayTimestamp));
        if (wechatpaySignatureType != null)
        localVarHeaderParams.add("Wechatpay-Signature-Type", apiClient.parameterToString(wechatpaySignatureType));

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<String> localReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/pay_notify", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestWithdrawParam  (required)
     * @return ResponseWithdrawResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseWithdrawResult withdraw(RequestWithdrawParam requestWithdrawParam) throws RestClientException {
        return withdrawWithHttpInfo(requestWithdrawParam).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestWithdrawParam  (required)
     * @return ResponseEntity&lt;ResponseWithdrawResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseWithdrawResult> withdrawWithHttpInfo(RequestWithdrawParam requestWithdrawParam) throws RestClientException {
        Object localVarPostBody = requestWithdrawParam;
        
        // verify the required parameter 'requestWithdrawParam' is set
        if (requestWithdrawParam == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestWithdrawParam' when calling withdraw");
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

        ParameterizedTypeReference<ResponseWithdrawResult> localReturnType = new ParameterizedTypeReference<ResponseWithdrawResult>() {};
        return apiClient.invokeAPI("/withdraw", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
