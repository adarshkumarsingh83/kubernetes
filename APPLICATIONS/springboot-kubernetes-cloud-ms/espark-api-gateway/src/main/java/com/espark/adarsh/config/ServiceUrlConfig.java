package com.espark.adarsh.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.util.List;

/*
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 9/7/20 12:12 AM#$
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.cloud.gateway")
public class ServiceUrlConfig {

    @NotNull
    private List<ServiceUrl> services;

    public List<ServiceUrl> getServices() {
        return services;
    }

    public void setServices(List<ServiceUrl> services) {
        this.services = services;
    }

    public static class ServiceUrl {

        @NotNull
        private String serviceId;
        @NotNull
        private String urlPattern;
        @NotNull
        private String forwardUrl;
        @Nullable
        private List<Header> requestHeader;
        @Nullable
        private List<Header> responseHeader;

        public ServiceUrl() {
        }

        public ServiceUrl(String serviceId, String urlPattern, String forwardUrl,
                          List<Header> requestHeader, List<Header> responseHeader) {
            this.serviceId = serviceId;
            this.urlPattern = urlPattern;
            this.forwardUrl = forwardUrl;
            this.requestHeader = requestHeader;
            this.responseHeader = responseHeader;
        }

        public String getServiceId() {
            return serviceId;
        }

        public void setServiceId(String serviceId) {
            this.serviceId = serviceId;
        }

        public String getUrlPattern() {
            return urlPattern;
        }

        public void setUrlPattern(String urlPattern) {
            this.urlPattern = urlPattern;
        }

        public String getForwardUrl() {
            return forwardUrl;
        }

        public void setForwardUrl(String forwardUrl) {
            this.forwardUrl = forwardUrl;
        }

        public List<Header> getRequestHeader() {
            return requestHeader;
        }

        public void setRequestHeader(List<Header> requestHeader) {
            this.requestHeader = requestHeader;
        }

        public List<Header> getResponseHeader() {
            return responseHeader;
        }

        public void setResponseHeader(List<Header> responseHeader) {
            this.responseHeader = responseHeader;
        }

        public static class Header {

            @NotNull
            private String headerName;
            @NotNull
            private String headerValue;

            public Header() {
            }

            public Header(String headerName, String headerValue) {
                this.headerName = headerName;
                this.headerValue = headerValue;
            }

            public String getHeaderName() {
                return headerName;
            }

            public void setHeaderName(String headerName) {
                this.headerName = headerName;
            }

            public String getHeaderValue() {
                return headerValue;
            }

            public void setHeaderValue(String headerValue) {
                this.headerValue = headerValue;
            }
        }

    }

}

