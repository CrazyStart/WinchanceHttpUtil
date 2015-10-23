/*
 * Copyright 2015 LuMeng
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package http;

public class PostParameter<T> {
	
	private static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";
	
    private String paramName;
	private String contentType;
	private T value;

	public PostParameter(String paramName, T value) {
	    this(paramName, value, DEFAULT_CONTENT_TYPE);
	}
	
	public PostParameter(String paramName, T value, String contentType) {
        this.paramName = paramName;
        this.value = value;
        this.contentType = contentType;
    }

	public String getParamName() {
		return paramName;
	}

	public T getValue() {
		return value;
	}

    public void setValue(T value) {
        this.value = value;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    
}
