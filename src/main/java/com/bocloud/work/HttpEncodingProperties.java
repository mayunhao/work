package com.bocloud.work;

import java.nio.charset.Charset;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * 配置编码参数
 * 
 * @author DZG
 * @since V1.0 2017年7月11日
 */
@ConfigurationProperties(prefix = "spring.http.encoding")
public class HttpEncodingProperties {

	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	private Charset charset = DEFAULT_CHARSET;
	private boolean force = true;

	public boolean isForce() {
		return force;
	}

	public void setForce(boolean force) {
		this.force = force;
	}

	public Charset getCharset() {
		return charset;
	}

	public void setCharset(Charset charset) {
		this.charset = charset;
	}

}
