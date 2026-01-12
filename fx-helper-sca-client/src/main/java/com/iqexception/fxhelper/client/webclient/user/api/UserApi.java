package com.iqexception.fxhelper.client.webclient.user.api;

import com.iqexception.fxhelper.client.webclient.user.ApiClient;

import com.iqexception.fxhelper.client.webclient.user.model.BaseResponse;
import com.iqexception.fxhelper.client.webclient.user.model.InternalChangePaySecretRequest;
import com.iqexception.fxhelper.client.webclient.user.model.InternalCheckLoginRequest;
import com.iqexception.fxhelper.client.webclient.user.model.InternalGetUserListRequest;
import com.iqexception.fxhelper.client.webclient.user.model.InternalGetUserRequest;
import com.iqexception.fxhelper.client.webclient.user.model.InternalVerifyPaySecretRequest;
import com.iqexception.fxhelper.client.webclient.user.model.RequestUserLoginParam;
import com.iqexception.fxhelper.client.webclient.user.model.ResponseInternalCheckLoginResult;
import com.iqexception.fxhelper.client.webclient.user.model.ResponseInternalGetUserListResult;
import com.iqexception.fxhelper.client.webclient.user.model.ResponseInternalGetUserResult;
import com.iqexception.fxhelper.client.webclient.user.model.ResponseInternalVerifyPaySecretResult;
import com.iqexception.fxhelper.client.webclient.user.model.ResponseUserLoginResult;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-15T21:28:57.577124+08:00[Asia/Shanghai]", comments = "Generator version: 7.12.0")
public class UserApi {
    private ApiClient apiClient;

    public UserApi() {
        this(new ApiClient());
    }

    @Autowired
    public UserApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalChangePaySecretRequest The internalChangePaySecretRequest parameter
     * @return BaseResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec internalChangePaySecretRequestCreation(InternalChangePaySecretRequest internalChangePaySecretRequest) throws WebClientResponseException {
        Object postBody = internalChangePaySecretRequest;
        // verify the required parameter 'internalChangePaySecretRequest' is set
        if (internalChangePaySecretRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'internalChangePaySecretRequest' when calling internalChangePaySecret", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<BaseResponse> localVarReturnType = new ParameterizedTypeReference<BaseResponse>() {};
        return apiClient.invokeAPI("/internal/change_pay_secret", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalChangePaySecretRequest The internalChangePaySecretRequest parameter
     * @return BaseResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<BaseResponse> internalChangePaySecret(InternalChangePaySecretRequest internalChangePaySecretRequest) throws WebClientResponseException {
        ParameterizedTypeReference<BaseResponse> localVarReturnType = new ParameterizedTypeReference<BaseResponse>() {};
        return internalChangePaySecretRequestCreation(internalChangePaySecretRequest).bodyToMono(localVarReturnType);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalChangePaySecretRequest The internalChangePaySecretRequest parameter
     * @return ResponseEntity&lt;BaseResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<BaseResponse>> internalChangePaySecretWithHttpInfo(InternalChangePaySecretRequest internalChangePaySecretRequest) throws WebClientResponseException {
        ParameterizedTypeReference<BaseResponse> localVarReturnType = new ParameterizedTypeReference<BaseResponse>() {};
        return internalChangePaySecretRequestCreation(internalChangePaySecretRequest).toEntity(localVarReturnType);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalChangePaySecretRequest The internalChangePaySecretRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec internalChangePaySecretWithResponseSpec(InternalChangePaySecretRequest internalChangePaySecretRequest) throws WebClientResponseException {
        return internalChangePaySecretRequestCreation(internalChangePaySecretRequest);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalCheckLoginRequest The internalCheckLoginRequest parameter
     * @return ResponseInternalCheckLoginResult
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec internalCheckLoginRequestCreation(InternalCheckLoginRequest internalCheckLoginRequest) throws WebClientResponseException {
        Object postBody = internalCheckLoginRequest;
        // verify the required parameter 'internalCheckLoginRequest' is set
        if (internalCheckLoginRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'internalCheckLoginRequest' when calling internalCheckLogin", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ResponseInternalCheckLoginResult> localVarReturnType = new ParameterizedTypeReference<ResponseInternalCheckLoginResult>() {};
        return apiClient.invokeAPI("/internal/check_login", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalCheckLoginRequest The internalCheckLoginRequest parameter
     * @return ResponseInternalCheckLoginResult
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseInternalCheckLoginResult> internalCheckLogin(InternalCheckLoginRequest internalCheckLoginRequest) throws WebClientResponseException {
        ParameterizedTypeReference<ResponseInternalCheckLoginResult> localVarReturnType = new ParameterizedTypeReference<ResponseInternalCheckLoginResult>() {};
        return internalCheckLoginRequestCreation(internalCheckLoginRequest).bodyToMono(localVarReturnType);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalCheckLoginRequest The internalCheckLoginRequest parameter
     * @return ResponseEntity&lt;ResponseInternalCheckLoginResult&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ResponseInternalCheckLoginResult>> internalCheckLoginWithHttpInfo(InternalCheckLoginRequest internalCheckLoginRequest) throws WebClientResponseException {
        ParameterizedTypeReference<ResponseInternalCheckLoginResult> localVarReturnType = new ParameterizedTypeReference<ResponseInternalCheckLoginResult>() {};
        return internalCheckLoginRequestCreation(internalCheckLoginRequest).toEntity(localVarReturnType);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalCheckLoginRequest The internalCheckLoginRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec internalCheckLoginWithResponseSpec(InternalCheckLoginRequest internalCheckLoginRequest) throws WebClientResponseException {
        return internalCheckLoginRequestCreation(internalCheckLoginRequest);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetUserRequest The internalGetUserRequest parameter
     * @return ResponseInternalGetUserResult
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec internalGetRequestCreation(InternalGetUserRequest internalGetUserRequest) throws WebClientResponseException {
        Object postBody = internalGetUserRequest;
        // verify the required parameter 'internalGetUserRequest' is set
        if (internalGetUserRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'internalGetUserRequest' when calling internalGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ResponseInternalGetUserResult> localVarReturnType = new ParameterizedTypeReference<ResponseInternalGetUserResult>() {};
        return apiClient.invokeAPI("/internal/get", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetUserRequest The internalGetUserRequest parameter
     * @return ResponseInternalGetUserResult
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseInternalGetUserResult> internalGet(InternalGetUserRequest internalGetUserRequest) throws WebClientResponseException {
        ParameterizedTypeReference<ResponseInternalGetUserResult> localVarReturnType = new ParameterizedTypeReference<ResponseInternalGetUserResult>() {};
        return internalGetRequestCreation(internalGetUserRequest).bodyToMono(localVarReturnType);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetUserRequest The internalGetUserRequest parameter
     * @return ResponseEntity&lt;ResponseInternalGetUserResult&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ResponseInternalGetUserResult>> internalGetWithHttpInfo(InternalGetUserRequest internalGetUserRequest) throws WebClientResponseException {
        ParameterizedTypeReference<ResponseInternalGetUserResult> localVarReturnType = new ParameterizedTypeReference<ResponseInternalGetUserResult>() {};
        return internalGetRequestCreation(internalGetUserRequest).toEntity(localVarReturnType);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetUserRequest The internalGetUserRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec internalGetWithResponseSpec(InternalGetUserRequest internalGetUserRequest) throws WebClientResponseException {
        return internalGetRequestCreation(internalGetUserRequest);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetUserListRequest The internalGetUserListRequest parameter
     * @return ResponseInternalGetUserListResult
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec internalGetUserListRequestCreation(InternalGetUserListRequest internalGetUserListRequest) throws WebClientResponseException {
        Object postBody = internalGetUserListRequest;
        // verify the required parameter 'internalGetUserListRequest' is set
        if (internalGetUserListRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'internalGetUserListRequest' when calling internalGetUserList", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ResponseInternalGetUserListResult> localVarReturnType = new ParameterizedTypeReference<ResponseInternalGetUserListResult>() {};
        return apiClient.invokeAPI("/internal/get_user_list", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetUserListRequest The internalGetUserListRequest parameter
     * @return ResponseInternalGetUserListResult
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseInternalGetUserListResult> internalGetUserList(InternalGetUserListRequest internalGetUserListRequest) throws WebClientResponseException {
        ParameterizedTypeReference<ResponseInternalGetUserListResult> localVarReturnType = new ParameterizedTypeReference<ResponseInternalGetUserListResult>() {};
        return internalGetUserListRequestCreation(internalGetUserListRequest).bodyToMono(localVarReturnType);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetUserListRequest The internalGetUserListRequest parameter
     * @return ResponseEntity&lt;ResponseInternalGetUserListResult&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ResponseInternalGetUserListResult>> internalGetUserListWithHttpInfo(InternalGetUserListRequest internalGetUserListRequest) throws WebClientResponseException {
        ParameterizedTypeReference<ResponseInternalGetUserListResult> localVarReturnType = new ParameterizedTypeReference<ResponseInternalGetUserListResult>() {};
        return internalGetUserListRequestCreation(internalGetUserListRequest).toEntity(localVarReturnType);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetUserListRequest The internalGetUserListRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec internalGetUserListWithResponseSpec(InternalGetUserListRequest internalGetUserListRequest) throws WebClientResponseException {
        return internalGetUserListRequestCreation(internalGetUserListRequest);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalVerifyPaySecretRequest The internalVerifyPaySecretRequest parameter
     * @return ResponseInternalVerifyPaySecretResult
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec internalVerifyPaySecretRequestCreation(InternalVerifyPaySecretRequest internalVerifyPaySecretRequest) throws WebClientResponseException {
        Object postBody = internalVerifyPaySecretRequest;
        // verify the required parameter 'internalVerifyPaySecretRequest' is set
        if (internalVerifyPaySecretRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'internalVerifyPaySecretRequest' when calling internalVerifyPaySecret", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ResponseInternalVerifyPaySecretResult> localVarReturnType = new ParameterizedTypeReference<ResponseInternalVerifyPaySecretResult>() {};
        return apiClient.invokeAPI("/internal/verify_pay_secret", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalVerifyPaySecretRequest The internalVerifyPaySecretRequest parameter
     * @return ResponseInternalVerifyPaySecretResult
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseInternalVerifyPaySecretResult> internalVerifyPaySecret(InternalVerifyPaySecretRequest internalVerifyPaySecretRequest) throws WebClientResponseException {
        ParameterizedTypeReference<ResponseInternalVerifyPaySecretResult> localVarReturnType = new ParameterizedTypeReference<ResponseInternalVerifyPaySecretResult>() {};
        return internalVerifyPaySecretRequestCreation(internalVerifyPaySecretRequest).bodyToMono(localVarReturnType);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalVerifyPaySecretRequest The internalVerifyPaySecretRequest parameter
     * @return ResponseEntity&lt;ResponseInternalVerifyPaySecretResult&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ResponseInternalVerifyPaySecretResult>> internalVerifyPaySecretWithHttpInfo(InternalVerifyPaySecretRequest internalVerifyPaySecretRequest) throws WebClientResponseException {
        ParameterizedTypeReference<ResponseInternalVerifyPaySecretResult> localVarReturnType = new ParameterizedTypeReference<ResponseInternalVerifyPaySecretResult>() {};
        return internalVerifyPaySecretRequestCreation(internalVerifyPaySecretRequest).toEntity(localVarReturnType);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalVerifyPaySecretRequest The internalVerifyPaySecretRequest parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec internalVerifyPaySecretWithResponseSpec(InternalVerifyPaySecretRequest internalVerifyPaySecretRequest) throws WebClientResponseException {
        return internalVerifyPaySecretRequestCreation(internalVerifyPaySecretRequest);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestUserLoginParam The requestUserLoginParam parameter
     * @return ResponseUserLoginResult
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec loginRequestCreation(RequestUserLoginParam requestUserLoginParam) throws WebClientResponseException {
        Object postBody = requestUserLoginParam;
        // verify the required parameter 'requestUserLoginParam' is set
        if (requestUserLoginParam == null) {
            throw new WebClientResponseException("Missing the required parameter 'requestUserLoginParam' when calling login", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ResponseUserLoginResult> localVarReturnType = new ParameterizedTypeReference<ResponseUserLoginResult>() {};
        return apiClient.invokeAPI("/login", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestUserLoginParam The requestUserLoginParam parameter
     * @return ResponseUserLoginResult
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseUserLoginResult> login(RequestUserLoginParam requestUserLoginParam) throws WebClientResponseException {
        ParameterizedTypeReference<ResponseUserLoginResult> localVarReturnType = new ParameterizedTypeReference<ResponseUserLoginResult>() {};
        return loginRequestCreation(requestUserLoginParam).bodyToMono(localVarReturnType);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestUserLoginParam The requestUserLoginParam parameter
     * @return ResponseEntity&lt;ResponseUserLoginResult&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ResponseUserLoginResult>> loginWithHttpInfo(RequestUserLoginParam requestUserLoginParam) throws WebClientResponseException {
        ParameterizedTypeReference<ResponseUserLoginResult> localVarReturnType = new ParameterizedTypeReference<ResponseUserLoginResult>() {};
        return loginRequestCreation(requestUserLoginParam).toEntity(localVarReturnType);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestUserLoginParam The requestUserLoginParam parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec loginWithResponseSpec(RequestUserLoginParam requestUserLoginParam) throws WebClientResponseException {
        return loginRequestCreation(requestUserLoginParam);
    }
}
