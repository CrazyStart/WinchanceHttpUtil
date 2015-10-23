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

package asynctask;

/**
 * 被观察者
 * @version 1.0.0
 * @param <T> T
 */
public interface ProgressCallable<T> {

	/**
	 * 注册观察者对象
	 * @param pProgressListener see {@link IProgressListener}
	 * @throws Exception Exception
	 * @return T
	 */
	public T call(final IProgressListener pProgressListener) throws Exception;
}