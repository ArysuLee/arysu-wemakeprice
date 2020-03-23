package net.arysu.wemakeprice;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OperationTO {

	@NotBlank
	private String url;
	
	@NotNull
	private Boolean excludeTag;
	
	@NotNull
	@Min(value = 1)
	private Integer bundleCount;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getExcludeTag() {
		return excludeTag;
	}

	public void setExcludeTag(Boolean excludeTag) {
		this.excludeTag = excludeTag;
	}

	public Integer getBundleCount() {
		return bundleCount;
	}

	public void setBundleCount(Integer bundleCount) {
		this.bundleCount = bundleCount;
	}
	
}
