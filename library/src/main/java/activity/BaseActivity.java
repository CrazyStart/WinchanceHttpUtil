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

package activity;

import android.app.Activity;
import android.content.Context;

import asynctask.WinchanceAsyncTask;
import asynctask.CallEarliest;
import asynctask.Callable;
import asynctask.Callback;
import asynctask.ProgressCallable;


/**
 * 公用Activity,用于存放与业务无关的公用方法
 * @version 1.0
 */
public abstract class BaseActivity extends Activity {

	/**
	 * 封装的异步方法,此方法没有进度条
	 * @param pCallEarliest 运行于主线程，最先执行此方法.
	 * @param mCallable 运行于异步线程,第二执行此方法
	 * @param mCallback callback
	 * @param <T> Callback
	 */
	public <T> void doAsync(final CallEarliest<T> pCallEarliest, final Callable<T> mCallable, final Callback<T> mCallback) {
		WinchanceAsyncTask.doAsync(pCallEarliest, mCallable, mCallback);
	}

	/**
	 * 封装的asynctask方法，此方法拥有进度对话框，并支持定义样式
	 * @param pContext context
	 * @param styleID resId
	 * @param pTitleResID resId
	 * @param pMessageResID resId
	 * @param pCallEarliest callEarliest
	 * @param pCallable see {@link Callable}
	 * @param pCallback see {@link Callback}
	 * @param <T> callback
	 */
	public <T> void doProgressAsync(final Context pContext, final int styleID,
			final String pTitleResID, final String pMessageResID,
			final CallEarliest<T> pCallEarliest, final ProgressCallable<T> pCallable,
			final Callback<T> pCallback) {

		WinchanceAsyncTask.doProgressAsync(pContext, styleID, pTitleResID,
				pMessageResID, pCallEarliest, pCallable, pCallback);
	}
	
	
	/**
	 * 封装的asynctask方法，此方法拥有进度对话框，并支持定义样�?.
	 * @param pContext  上下�?
	 * @param styleID   对话框样�? ProgressDialog.STYLE_HORIZONTAL|ProgressDialog.STYLE_SPINNER
	 * @param pTitleResID    标题,资源id
	 * @param pMessageResID  内容,资源id
	 * @param pCallEarliest  运行于主线程，最先执行此方法.
	 * @param pCallable 运行于异步线�?,用于传�?�对话框进度.
	 * @param pCallback  运行于主线程,�?后执行此方法.
	 */
	public <T> void doProgressAsync(final Context pContext, final int styleID,
			final int pTitleResID, final int pMessageResID,
			final CallEarliest<T> pCallEarliest, final ProgressCallable<T> pCallable,
			final Callback<T> pCallback) {

		WinchanceAsyncTask.doProgressAsync(pContext, styleID, pTitleResID,
				pMessageResID, pCallEarliest, pCallable, pCallback);
	}

	
}
