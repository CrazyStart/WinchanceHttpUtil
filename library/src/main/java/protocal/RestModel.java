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

package protocal;

public class RestModel<T> {
    private String version = "1.0";
    private String encoding = "UTF-8";

    private Long errorCode = null;
    private String errorMsg = null;

    private Entity<T> entity = null;
    private Feed<T> feed = null;

    public RestModel(Entity<T> entity, Feed<T> feed) {
        this.entity = entity;
        this.feed = feed;
    }

    public String getVersion() {
        return version;
    }

    public String getEncoding() {
        return encoding;
    }

    public Long getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public Entity<T> getEntity() {
        return entity;
    }

    public Feed<T> getFeed() {
        return feed;
    }
}
