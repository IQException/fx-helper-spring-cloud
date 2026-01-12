package com.iqexception.fxhelper.client.resttemplate.shop.api;

import com.iqexception.fxhelper.client.resttemplate.shop.ApiClient;
import com.iqexception.fxhelper.client.resttemplate.shop.BaseApi;

import com.iqexception.fxhelper.client.resttemplate.shop.model.BaseRequest;
import com.iqexception.fxhelper.client.resttemplate.shop.model.BaseResponse;
import com.iqexception.fxhelper.client.resttemplate.shop.model.InternalGetDetailInfoRequest;
import com.iqexception.fxhelper.client.resttemplate.shop.model.InternalGetSerialNoRequest;
import com.iqexception.fxhelper.client.resttemplate.shop.model.InternalGetShopListRequest;
import com.iqexception.fxhelper.client.resttemplate.shop.model.InternalGetUserShopListRequest;
import com.iqexception.fxhelper.client.resttemplate.shop.model.RequestGetDetailInfoParam;
import com.iqexception.fxhelper.client.resttemplate.shop.model.RequestGetPublicShopInfoParam;
import com.iqexception.fxhelper.client.resttemplate.shop.model.RequestGetQrCodesParam;
import com.iqexception.fxhelper.client.resttemplate.shop.model.RequestShopCreateParam;
import com.iqexception.fxhelper.client.resttemplate.shop.model.RequestShopUpdateParam;
import com.iqexception.fxhelper.client.resttemplate.shop.model.RequestSwitchParam;
import com.iqexception.fxhelper.client.resttemplate.shop.model.ResponseGetPublicShopInfoResult;
import com.iqexception.fxhelper.client.resttemplate.shop.model.ResponseGetQrCodesResult;
import com.iqexception.fxhelper.client.resttemplate.shop.model.ResponseGetShopDetailInfoResult;
import com.iqexception.fxhelper.client.resttemplate.shop.model.ResponseGetShopListResult;
import com.iqexception.fxhelper.client.resttemplate.shop.model.ResponseInternalGetSerialNoResult;
import com.iqexception.fxhelper.client.resttemplate.shop.model.ResponseShopCreateResult;

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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-17T02:48:31.789852+08:00[Asia/Shanghai]", comments = "Generator version: 7.12.0")
@Component("com.iqexception.fxhelper.client.resttemplate.shop.api.ShopApi")
public class ShopApi extends BaseApi {

    public ShopApi() {
        super(new ApiClient());
    }

    @Autowired
    public ShopApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestShopCreateParam  (required)
     * @return ResponseShopCreateResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseShopCreateResult create(RequestShopCreateParam requestShopCreateParam) throws RestClientException {
        return createWithHttpInfo(requestShopCreateParam).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestShopCreateParam  (required)
     * @return ResponseEntity&lt;ResponseShopCreateResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseShopCreateResult> createWithHttpInfo(RequestShopCreateParam requestShopCreateParam) throws RestClientException {
        Object localVarPostBody = requestShopCreateParam;
        
        // verify the required parameter 'requestShopCreateParam' is set
        if (requestShopCreateParam == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestShopCreateParam' when calling create");
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

        ParameterizedTypeReference<ResponseShopCreateResult> localReturnType = new ParameterizedTypeReference<ResponseShopCreateResult>() {};
        return apiClient.invokeAPI("/create", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestGetDetailInfoParam  (required)
     * @return ResponseGetShopDetailInfoResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseGetShopDetailInfoResult getDetailInfo(RequestGetDetailInfoParam requestGetDetailInfoParam) throws RestClientException {
        return getDetailInfoWithHttpInfo(requestGetDetailInfoParam).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestGetDetailInfoParam  (required)
     * @return ResponseEntity&lt;ResponseGetShopDetailInfoResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseGetShopDetailInfoResult> getDetailInfoWithHttpInfo(RequestGetDetailInfoParam requestGetDetailInfoParam) throws RestClientException {
        Object localVarPostBody = requestGetDetailInfoParam;
        
        // verify the required parameter 'requestGetDetailInfoParam' is set
        if (requestGetDetailInfoParam == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestGetDetailInfoParam' when calling getDetailInfo");
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

        ParameterizedTypeReference<ResponseGetShopDetailInfoResult> localReturnType = new ParameterizedTypeReference<ResponseGetShopDetailInfoResult>() {};
        return apiClient.invokeAPI("/get_detail_info", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestGetPublicShopInfoParam  (required)
     * @return ResponseGetPublicShopInfoResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseGetPublicShopInfoResult getPublicInfo(RequestGetPublicShopInfoParam requestGetPublicShopInfoParam) throws RestClientException {
        return getPublicInfoWithHttpInfo(requestGetPublicShopInfoParam).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestGetPublicShopInfoParam  (required)
     * @return ResponseEntity&lt;ResponseGetPublicShopInfoResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseGetPublicShopInfoResult> getPublicInfoWithHttpInfo(RequestGetPublicShopInfoParam requestGetPublicShopInfoParam) throws RestClientException {
        Object localVarPostBody = requestGetPublicShopInfoParam;
        
        // verify the required parameter 'requestGetPublicShopInfoParam' is set
        if (requestGetPublicShopInfoParam == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestGetPublicShopInfoParam' when calling getPublicInfo");
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

        ParameterizedTypeReference<ResponseGetPublicShopInfoResult> localReturnType = new ParameterizedTypeReference<ResponseGetPublicShopInfoResult>() {};
        return apiClient.invokeAPI("/get_public_info", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestGetQrCodesParam  (required)
     * @return ResponseGetQrCodesResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseGetQrCodesResult getQrCodes(RequestGetQrCodesParam requestGetQrCodesParam) throws RestClientException {
        return getQrCodesWithHttpInfo(requestGetQrCodesParam).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestGetQrCodesParam  (required)
     * @return ResponseEntity&lt;ResponseGetQrCodesResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseGetQrCodesResult> getQrCodesWithHttpInfo(RequestGetQrCodesParam requestGetQrCodesParam) throws RestClientException {
        Object localVarPostBody = requestGetQrCodesParam;
        
        // verify the required parameter 'requestGetQrCodesParam' is set
        if (requestGetQrCodesParam == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestGetQrCodesParam' when calling getQrCodes");
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

        ParameterizedTypeReference<ResponseGetQrCodesResult> localReturnType = new ParameterizedTypeReference<ResponseGetQrCodesResult>() {};
        return apiClient.invokeAPI("/get_qr_codes", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param baseRequest  (required)
     * @return ResponseGetShopListResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseGetShopListResult getShopList(BaseRequest baseRequest) throws RestClientException {
        return getShopListWithHttpInfo(baseRequest).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param baseRequest  (required)
     * @return ResponseEntity&lt;ResponseGetShopListResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseGetShopListResult> getShopListWithHttpInfo(BaseRequest baseRequest) throws RestClientException {
        Object localVarPostBody = baseRequest;
        
        // verify the required parameter 'baseRequest' is set
        if (baseRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'baseRequest' when calling getShopList");
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

        ParameterizedTypeReference<ResponseGetShopListResult> localReturnType = new ParameterizedTypeReference<ResponseGetShopListResult>() {};
        return apiClient.invokeAPI("/get_shop_list", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetDetailInfoRequest  (required)
     * @return ResponseGetShopDetailInfoResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseGetShopDetailInfoResult internalGetDetailInfo(InternalGetDetailInfoRequest internalGetDetailInfoRequest) throws RestClientException {
        return internalGetDetailInfoWithHttpInfo(internalGetDetailInfoRequest).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetDetailInfoRequest  (required)
     * @return ResponseEntity&lt;ResponseGetShopDetailInfoResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseGetShopDetailInfoResult> internalGetDetailInfoWithHttpInfo(InternalGetDetailInfoRequest internalGetDetailInfoRequest) throws RestClientException {
        Object localVarPostBody = internalGetDetailInfoRequest;
        
        // verify the required parameter 'internalGetDetailInfoRequest' is set
        if (internalGetDetailInfoRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'internalGetDetailInfoRequest' when calling internalGetDetailInfo");
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

        ParameterizedTypeReference<ResponseGetShopDetailInfoResult> localReturnType = new ParameterizedTypeReference<ResponseGetShopDetailInfoResult>() {};
        return apiClient.invokeAPI("/internal/get_detail_info", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetSerialNoRequest  (required)
     * @return ResponseInternalGetSerialNoResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseInternalGetSerialNoResult internalGetSerialNo(InternalGetSerialNoRequest internalGetSerialNoRequest) throws RestClientException {
        return internalGetSerialNoWithHttpInfo(internalGetSerialNoRequest).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetSerialNoRequest  (required)
     * @return ResponseEntity&lt;ResponseInternalGetSerialNoResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseInternalGetSerialNoResult> internalGetSerialNoWithHttpInfo(InternalGetSerialNoRequest internalGetSerialNoRequest) throws RestClientException {
        Object localVarPostBody = internalGetSerialNoRequest;
        
        // verify the required parameter 'internalGetSerialNoRequest' is set
        if (internalGetSerialNoRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'internalGetSerialNoRequest' when calling internalGetSerialNo");
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

        ParameterizedTypeReference<ResponseInternalGetSerialNoResult> localReturnType = new ParameterizedTypeReference<ResponseInternalGetSerialNoResult>() {};
        return apiClient.invokeAPI("/internal/get_serial_no", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetShopListRequest  (required)
     * @return ResponseGetShopListResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseGetShopListResult internalGetShopList(InternalGetShopListRequest internalGetShopListRequest) throws RestClientException {
        return internalGetShopListWithHttpInfo(internalGetShopListRequest).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetShopListRequest  (required)
     * @return ResponseEntity&lt;ResponseGetShopListResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseGetShopListResult> internalGetShopListWithHttpInfo(InternalGetShopListRequest internalGetShopListRequest) throws RestClientException {
        Object localVarPostBody = internalGetShopListRequest;
        
        // verify the required parameter 'internalGetShopListRequest' is set
        if (internalGetShopListRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'internalGetShopListRequest' when calling internalGetShopList");
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

        ParameterizedTypeReference<ResponseGetShopListResult> localReturnType = new ParameterizedTypeReference<ResponseGetShopListResult>() {};
        return apiClient.invokeAPI("/internal/get_shop_list", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetUserShopListRequest  (required)
     * @return ResponseGetShopListResult
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseGetShopListResult internalGetUserShopList(InternalGetUserShopListRequest internalGetUserShopListRequest) throws RestClientException {
        return internalGetUserShopListWithHttpInfo(internalGetUserShopListRequest).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param internalGetUserShopListRequest  (required)
     * @return ResponseEntity&lt;ResponseGetShopListResult&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ResponseGetShopListResult> internalGetUserShopListWithHttpInfo(InternalGetUserShopListRequest internalGetUserShopListRequest) throws RestClientException {
        Object localVarPostBody = internalGetUserShopListRequest;
        
        // verify the required parameter 'internalGetUserShopListRequest' is set
        if (internalGetUserShopListRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'internalGetUserShopListRequest' when calling internalGetUserShopList");
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

        ParameterizedTypeReference<ResponseGetShopListResult> localReturnType = new ParameterizedTypeReference<ResponseGetShopListResult>() {};
        return apiClient.invokeAPI("/internal/get_user_shop_list", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestSwitchParam  (required)
     * @return BaseResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public BaseResponse switchFx(RequestSwitchParam requestSwitchParam) throws RestClientException {
        return switchFxWithHttpInfo(requestSwitchParam).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestSwitchParam  (required)
     * @return ResponseEntity&lt;BaseResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<BaseResponse> switchFxWithHttpInfo(RequestSwitchParam requestSwitchParam) throws RestClientException {
        Object localVarPostBody = requestSwitchParam;
        
        // verify the required parameter 'requestSwitchParam' is set
        if (requestSwitchParam == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestSwitchParam' when calling switchFx");
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
        return apiClient.invokeAPI("/switch", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestShopUpdateParam  (required)
     * @return BaseResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public BaseResponse update(RequestShopUpdateParam requestShopUpdateParam) throws RestClientException {
        return updateWithHttpInfo(requestShopUpdateParam).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param requestShopUpdateParam  (required)
     * @return ResponseEntity&lt;BaseResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<BaseResponse> updateWithHttpInfo(RequestShopUpdateParam requestShopUpdateParam) throws RestClientException {
        Object localVarPostBody = requestShopUpdateParam;
        
        // verify the required parameter 'requestShopUpdateParam' is set
        if (requestShopUpdateParam == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestShopUpdateParam' when calling update");
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
        return apiClient.invokeAPI("/update", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
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
