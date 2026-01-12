package com.iqexception.fxhelper.client.resttemplate.user.api;

import com.iqexception.fxhelper.client.resttemplate.user.ApiClient;
import com.iqexception.fxhelper.client.resttemplate.user.BaseApi;

import com.iqexception.fxhelper.client.resttemplate.user.model.BaseResponse;
import com.iqexception.fxhelper.client.resttemplate.user.model.InternalChangePaySecretRequest;
import com.iqexception.fxhelper.client.resttemplate.user.model.InternalCheckLoginRequest;
import com.iqexception.fxhelper.client.resttemplate.user.model.InternalGetUserListRequest;
import com.iqexception.fxhelper.client.resttemplate.user.model.InternalGetUserRequest;
import com.iqexception.fxhelper.client.resttemplate.user.model.InternalVerifyPaySecretRequest;
import com.iqexception.fxhelper.client.resttemplate.user.model.RequestUserLoginParam;
import com.iqexception.fxhelper.client.resttemplate.user.model.ResponseInternalCheckLoginResult;
import com.iqexception.fxhelper.client.resttemplate.user.model.ResponseInternalGetUserListResult;
import com.iqexception.fxhelper.client.resttemplate.user.model.ResponseInternalGetUserResult;
import com.iqexception.fxhelper.client.resttemplate.user.model.ResponseInternalVerifyPaySecretResult;
import com.iqexception.fxhelper.client.resttemplate.user.model.ResponseUserLoginResult;

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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-15T21:23:05.087091+08:00[Asia/Shanghai]", comments = "Generator version: 7.12.0")
@Component("com.iqexception.fxhelper.client.resttemplate.user.api.UserApi")
public class UserApi extends BaseApi {

    public UserApi() {
        super(new ApiClient());
    }

    @Autowired
    public UserApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalChangePaySecretRequest  (required)
     * @return BaseResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public BaseResponse internalChangePaySecret(InternalChangePaySecretRequest internalChangePaySecretRequest) throws RestClientException {
        return internalChangePaySecretWithHttpInfo(internalChangePaySecretRequest).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalChangePaySecretRequest  (required)
     * @return ResponseEntity&lt;BaseResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<BaseResponse> internalChangePaySecretWithHttpInfo(InternalChangePaySecretRequest internalChangePaySecretRequest) throws RestClientException {
        Object localVarPostBody = internalChangePaySecretRequest;
        
        // verify the required parameter 'internalChangePaySecretRequest' is set
        if (internalChangePaySecretRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'internalChangePaySecretRequest' when calling internalChangePaySecret");
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
        return apiClient.invokeAPI("/internal/change_pay_secret", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalCheckLoginRequest  (required)
     * @return ResponseInternalCheckLoginResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseInternalCheckLoginResult internalCheckLogin(InternalCheckLoginRequest internalCheckLoginRequest) throws RestClientException {
        return internalCheckLoginWithHttpInfo(internalCheckLoginRequest).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalCheckLoginRequest  (required)
     * @return ResponseEntity&lt;ResponseInternalCheckLoginResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseInternalCheckLoginResult> internalCheckLoginWithHttpInfo(InternalCheckLoginRequest internalCheckLoginRequest) throws RestClientException {
        Object localVarPostBody = internalCheckLoginRequest;
        
        // verify the required parameter 'internalCheckLoginRequest' is set
        if (internalCheckLoginRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'internalCheckLoginRequest' when calling internalCheckLogin");
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

        ParameterizedTypeReference<ResponseInternalCheckLoginResult> localReturnType = new ParameterizedTypeReference<ResponseInternalCheckLoginResult>() {};
        return apiClient.invokeAPI("/internal/check_login", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetUserRequest  (required)
     * @return ResponseInternalGetUserResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseInternalGetUserResult internalGet(InternalGetUserRequest internalGetUserRequest) throws RestClientException {
        return internalGetWithHttpInfo(internalGetUserRequest).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetUserRequest  (required)
     * @return ResponseEntity&lt;ResponseInternalGetUserResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseInternalGetUserResult> internalGetWithHttpInfo(InternalGetUserRequest internalGetUserRequest) throws RestClientException {
        Object localVarPostBody = internalGetUserRequest;
        
        // verify the required parameter 'internalGetUserRequest' is set
        if (internalGetUserRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'internalGetUserRequest' when calling internalGet");
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

        ParameterizedTypeReference<ResponseInternalGetUserResult> localReturnType = new ParameterizedTypeReference<ResponseInternalGetUserResult>() {};
        return apiClient.invokeAPI("/internal/get", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetUserListRequest  (required)
     * @return ResponseInternalGetUserListResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseInternalGetUserListResult internalGetUserList(InternalGetUserListRequest internalGetUserListRequest) throws RestClientException {
        return internalGetUserListWithHttpInfo(internalGetUserListRequest).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetUserListRequest  (required)
     * @return ResponseEntity&lt;ResponseInternalGetUserListResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseInternalGetUserListResult> internalGetUserListWithHttpInfo(InternalGetUserListRequest internalGetUserListRequest) throws RestClientException {
        Object localVarPostBody = internalGetUserListRequest;
        
        // verify the required parameter 'internalGetUserListRequest' is set
        if (internalGetUserListRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'internalGetUserListRequest' when calling internalGetUserList");
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

        ParameterizedTypeReference<ResponseInternalGetUserListResult> localReturnType = new ParameterizedTypeReference<ResponseInternalGetUserListResult>() {};
        return apiClient.invokeAPI("/internal/get_user_list", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalVerifyPaySecretRequest  (required)
     * @return ResponseInternalVerifyPaySecretResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseInternalVerifyPaySecretResult internalVerifyPaySecret(InternalVerifyPaySecretRequest internalVerifyPaySecretRequest) throws RestClientException {
        return internalVerifyPaySecretWithHttpInfo(internalVerifyPaySecretRequest).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalVerifyPaySecretRequest  (required)
     * @return ResponseEntity&lt;ResponseInternalVerifyPaySecretResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseInternalVerifyPaySecretResult> internalVerifyPaySecretWithHttpInfo(InternalVerifyPaySecretRequest internalVerifyPaySecretRequest) throws RestClientException {
        Object localVarPostBody = internalVerifyPaySecretRequest;
        
        // verify the required parameter 'internalVerifyPaySecretRequest' is set
        if (internalVerifyPaySecretRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'internalVerifyPaySecretRequest' when calling internalVerifyPaySecret");
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

        ParameterizedTypeReference<ResponseInternalVerifyPaySecretResult> localReturnType = new ParameterizedTypeReference<ResponseInternalVerifyPaySecretResult>() {};
        return apiClient.invokeAPI("/internal/verify_pay_secret", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestUserLoginParam  (required)
     * @return ResponseUserLoginResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseUserLoginResult login(RequestUserLoginParam requestUserLoginParam) throws RestClientException {
        return loginWithHttpInfo(requestUserLoginParam).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestUserLoginParam  (required)
     * @return ResponseEntity&lt;ResponseUserLoginResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseUserLoginResult> loginWithHttpInfo(RequestUserLoginParam requestUserLoginParam) throws RestClientException {
        Object localVarPostBody = requestUserLoginParam;
        
        // verify the required parameter 'requestUserLoginParam' is set
        if (requestUserLoginParam == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestUserLoginParam' when calling login");
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

        ParameterizedTypeReference<ResponseUserLoginResult> localReturnType = new ParameterizedTypeReference<ResponseUserLoginResult>() {};
        return apiClient.invokeAPI("/login", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
