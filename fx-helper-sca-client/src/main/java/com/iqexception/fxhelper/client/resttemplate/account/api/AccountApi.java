package com.iqexception.fxhelper.client.resttemplate.account.api;

import com.iqexception.fxhelper.client.resttemplate.account.ApiClient;
import com.iqexception.fxhelper.client.resttemplate.account.BaseApi;

import com.iqexception.fxhelper.client.resttemplate.account.model.BaseRequest;
import com.iqexception.fxhelper.client.resttemplate.account.model.BaseResponse;
import com.iqexception.fxhelper.client.resttemplate.account.model.IncrBalanceRequest;
import com.iqexception.fxhelper.client.resttemplate.account.model.InternalCreateRequest;
import com.iqexception.fxhelper.client.resttemplate.account.model.InternalGetAccountRequest;
import com.iqexception.fxhelper.client.resttemplate.account.model.InternalTransferRequest;
import com.iqexception.fxhelper.client.resttemplate.account.model.ResponseGetAccountResult;
import com.iqexception.fxhelper.client.resttemplate.account.model.ResponseInternalAccountCreateResult;
import com.iqexception.fxhelper.client.resttemplate.account.model.ResponseInternalAccountTransferResult;
import com.iqexception.fxhelper.client.resttemplate.account.model.ResponseInternalGetAccountResult;

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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-15T21:54:00.716180+08:00[Asia/Shanghai]", comments = "Generator version: 7.12.0")
@Component("com.iqexception.fxhelper.client.resttemplate.account.api.AccountApi")
public class AccountApi extends BaseApi {

    public AccountApi() {
        super(new ApiClient());
    }

    @Autowired
    public AccountApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param baseRequest  (required)
     * @return ResponseGetAccountResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseGetAccountResult get(BaseRequest baseRequest) throws RestClientException {
        return getWithHttpInfo(baseRequest).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param baseRequest  (required)
     * @return ResponseEntity&lt;ResponseGetAccountResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseGetAccountResult> getWithHttpInfo(BaseRequest baseRequest) throws RestClientException {
        Object localVarPostBody = baseRequest;
        
        // verify the required parameter 'baseRequest' is set
        if (baseRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'baseRequest' when calling get");
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

        ParameterizedTypeReference<ResponseGetAccountResult> localReturnType = new ParameterizedTypeReference<ResponseGetAccountResult>() {};
        return apiClient.invokeAPI("/get_account", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalCreateRequest  (required)
     * @return ResponseInternalAccountCreateResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseInternalAccountCreateResult internalCreate(InternalCreateRequest internalCreateRequest) throws RestClientException {
        return internalCreateWithHttpInfo(internalCreateRequest).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalCreateRequest  (required)
     * @return ResponseEntity&lt;ResponseInternalAccountCreateResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseInternalAccountCreateResult> internalCreateWithHttpInfo(InternalCreateRequest internalCreateRequest) throws RestClientException {
        Object localVarPostBody = internalCreateRequest;
        
        // verify the required parameter 'internalCreateRequest' is set
        if (internalCreateRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'internalCreateRequest' when calling internalCreate");
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

        ParameterizedTypeReference<ResponseInternalAccountCreateResult> localReturnType = new ParameterizedTypeReference<ResponseInternalAccountCreateResult>() {};
        return apiClient.invokeAPI("/internal/create", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetAccountRequest  (required)
     * @return ResponseInternalGetAccountResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseInternalGetAccountResult internalGet(InternalGetAccountRequest internalGetAccountRequest) throws RestClientException {
        return internalGetWithHttpInfo(internalGetAccountRequest).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetAccountRequest  (required)
     * @return ResponseEntity&lt;ResponseInternalGetAccountResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseInternalGetAccountResult> internalGetWithHttpInfo(InternalGetAccountRequest internalGetAccountRequest) throws RestClientException {
        Object localVarPostBody = internalGetAccountRequest;
        
        // verify the required parameter 'internalGetAccountRequest' is set
        if (internalGetAccountRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'internalGetAccountRequest' when calling internalGet");
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

        ParameterizedTypeReference<ResponseInternalGetAccountResult> localReturnType = new ParameterizedTypeReference<ResponseInternalGetAccountResult>() {};
        return apiClient.invokeAPI("/internal/get_account", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param incrBalanceRequest  (required)
     * @return BaseResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public BaseResponse internalIncrBalance(IncrBalanceRequest incrBalanceRequest) throws RestClientException {
        return internalIncrBalanceWithHttpInfo(incrBalanceRequest).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param incrBalanceRequest  (required)
     * @return ResponseEntity&lt;BaseResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<BaseResponse> internalIncrBalanceWithHttpInfo(IncrBalanceRequest incrBalanceRequest) throws RestClientException {
        Object localVarPostBody = incrBalanceRequest;
        
        // verify the required parameter 'incrBalanceRequest' is set
        if (incrBalanceRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'incrBalanceRequest' when calling internalIncrBalance");
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

        ParameterizedTypeReference<BaseResponse> localReturnType = new ParameterizedTypeReference<BaseResponse>() {};
        return apiClient.invokeAPI("/internal/incr_balance", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalTransferRequest  (required)
     * @return ResponseInternalAccountTransferResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseInternalAccountTransferResult internalTransfer(InternalTransferRequest internalTransferRequest) throws RestClientException {
        return internalTransferWithHttpInfo(internalTransferRequest).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalTransferRequest  (required)
     * @return ResponseEntity&lt;ResponseInternalAccountTransferResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseInternalAccountTransferResult> internalTransferWithHttpInfo(InternalTransferRequest internalTransferRequest) throws RestClientException {
        Object localVarPostBody = internalTransferRequest;
        
        // verify the required parameter 'internalTransferRequest' is set
        if (internalTransferRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'internalTransferRequest' when calling internalTransfer");
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

        ParameterizedTypeReference<ResponseInternalAccountTransferResult> localReturnType = new ParameterizedTypeReference<ResponseInternalAccountTransferResult>() {};
        return apiClient.invokeAPI("/internal/transfer", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
