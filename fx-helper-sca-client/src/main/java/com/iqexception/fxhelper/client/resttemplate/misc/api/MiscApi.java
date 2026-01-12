package com.iqexception.fxhelper.client.resttemplate.misc.api;

import com.iqexception.fxhelper.client.resttemplate.misc.ApiClient;
import com.iqexception.fxhelper.client.resttemplate.misc.BaseApi;

import com.iqexception.fxhelper.client.resttemplate.misc.model.BaseRequest;
import com.iqexception.fxhelper.client.resttemplate.misc.model.BaseResponse;
import com.iqexception.fxhelper.client.resttemplate.misc.model.RequestMsgSubsParam;
import com.iqexception.fxhelper.client.resttemplate.misc.model.ResponseGetAccessTokenResult;
import com.iqexception.fxhelper.client.resttemplate.misc.model.ResponseGetUploadPolicyResult;
import com.iqexception.fxhelper.client.resttemplate.misc.model.SendWxMessageRequest;

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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-15T21:25:12.441376+08:00[Asia/Shanghai]", comments = "Generator version: 7.12.0")
@Component("com.iqexception.fxhelper.client.resttemplate.misc.api.MiscApi")
public class MiscApi extends BaseApi {

    public MiscApi() {
        super(new ApiClient());
    }

    @Autowired
    public MiscApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @return ResponseGetAccessTokenResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseGetAccessTokenResult getAccessToken() throws RestClientException {
        return getAccessTokenWithHttpInfo().getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @return ResponseEntity&lt;ResponseGetAccessTokenResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseGetAccessTokenResult> getAccessTokenWithHttpInfo() throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ResponseGetAccessTokenResult> localReturnType = new ParameterizedTypeReference<ResponseGetAccessTokenResult>() {};
        return apiClient.invokeAPI("/wx/get_access_token", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param baseRequest  (required)
     * @return ResponseGetUploadPolicyResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseGetUploadPolicyResult getUploadPolicy(BaseRequest baseRequest) throws RestClientException {
        return getUploadPolicyWithHttpInfo(baseRequest).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param baseRequest  (required)
     * @return ResponseEntity&lt;ResponseGetUploadPolicyResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseGetUploadPolicyResult> getUploadPolicyWithHttpInfo(BaseRequest baseRequest) throws RestClientException {
        Object localVarPostBody = baseRequest;
        
        // verify the required parameter 'baseRequest' is set
        if (baseRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'baseRequest' when calling getUploadPolicy");
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

        ParameterizedTypeReference<ResponseGetUploadPolicyResult> localReturnType = new ParameterizedTypeReference<ResponseGetUploadPolicyResult>() {};
        return apiClient.invokeAPI("/get_upload_policy", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestMsgSubsParam  (required)
     * @return BaseResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public BaseResponse msgSubscribe(RequestMsgSubsParam requestMsgSubsParam) throws RestClientException {
        return msgSubscribeWithHttpInfo(requestMsgSubsParam).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestMsgSubsParam  (required)
     * @return ResponseEntity&lt;BaseResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<BaseResponse> msgSubscribeWithHttpInfo(RequestMsgSubsParam requestMsgSubsParam) throws RestClientException {
        Object localVarPostBody = requestMsgSubsParam;
        
        // verify the required parameter 'requestMsgSubsParam' is set
        if (requestMsgSubsParam == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestMsgSubsParam' when calling msgSubscribe");
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
        return apiClient.invokeAPI("/wx/msg_subscribe", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param sendWxMessageRequest  (required)
     * @return BaseResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public BaseResponse sendMessage(SendWxMessageRequest sendWxMessageRequest) throws RestClientException {
        return sendMessageWithHttpInfo(sendWxMessageRequest).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param sendWxMessageRequest  (required)
     * @return ResponseEntity&lt;BaseResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<BaseResponse> sendMessageWithHttpInfo(SendWxMessageRequest sendWxMessageRequest) throws RestClientException {
        Object localVarPostBody = sendWxMessageRequest;
        
        // verify the required parameter 'sendWxMessageRequest' is set
        if (sendWxMessageRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'sendWxMessageRequest' when calling sendMessage");
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
        return apiClient.invokeAPI("/wx/send_message", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
