package com.iqexception.fxhelper.common.config;

import brave.handler.MutableSpan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zipkin2.reporter.BytesEncoder;
import zipkin2.reporter.otel.brave.OtlpProtoV1Encoder;

@Configuration
public class ObservationConfig {
    @Bean
    BytesEncoder<MutableSpan> otlpMutableSpanBytesEncoder() {
        return OtlpProtoV1Encoder.create();
    }

}
