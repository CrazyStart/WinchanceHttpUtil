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

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

/**
 * 异步操作工具类
 *
 * @version 1.0.0
 */
public class WinchanceAsyncTask {

    /**
     * 封装的asynctask方法，此方法没有进度框.
     *
     * @param pCallEarliest pCallEarliest
     * @param pCallable     pCallable
     * @param pCallback     pCallback
     * @param <T>           T
     */
    public static <T> void doAsync(final CallEarliest<T> pCallEarliest, final Callable<T> pCallable, final Callback<T> pCallback) {

        new AsyncTask<Void, Void, T>() {

            /**
             * 首先运行此方法,运行于主线程
             */
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                try {
                    pCallEarliest.onCallEarliest();
                } catch (Exception e) {
                    Log.e("error", e.toString());
                }
            }

            /**
             * 第二步执行这个方法，这个方法运行在异步线程中
             */
            @Override
            protected T doInBackground(Void... params) {

                try {
                    return pCallable.call();
                } catch (Exception e) {
                    Log.e("error", e.toString());
                }
                return null;
            }

            /**
             * 第三步执行这个方法，运行于主线程
             */
            protected void onPostExecute(T result) {
                pCallback.onCallback(result);
            }
        }.execute((Void[]) null);
    }

    /**
     * 封装的asynctask方法，此方法拥有进度对话框，并支持定义样式.
     *
     * @param pContext         上下文
     * @param styleID          对话框样式
     *                         ProgressDialog.STYLE_HORIZONTAL|ProgressDialog.STYLE_SPINNER
     * @param pTitle           标题
     * @param pMessage         内容
     * @param pCallEarliest    运行于主线程，最先执行此方法.
     * @param progressCallable 运行于异步线程,用于传递对话框进度.
     * @param pCallback        运行于主线程,最后执行此方法.
     */
    public static <T> void doProgressAsync(final Context pContext,
                                           final int styleID, final String pTitle, final String pMessage,
                                           final CallEarliest<T> pCallEarliest,
                                           final ProgressCallable<T> progressCallable,
                                           final Callback<T> pCallback) {

        new AsyncTask<Void, Void, T>() {

            private ProgressDialog mProgressDialog;

            /**
             * 首先运行此方法,运行于主线程
             */
            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                mProgressDialog = new ProgressDialog(pContext);
                mProgressDialog.setProgressStyle(styleID);
                mProgressDialog.setTitle(pTitle);
                mProgressDialog.setMax(100);
                mProgressDialog.setMessage(pMessage);
                mProgressDialog.setIndeterminate(false);
                mProgressDialog.show();
                try {
                    pCallEarliest.onCallEarliest();
                } catch (Exception e) {
                    Log.e("error", e.toString());
                }
            }

            /**
             * 第二步执行这个方法，这个方法运行在异步线程中
             */
            @Override
            protected T doInBackground(Void... params) {
                try {
                    return progressCallable.call(new IProgressListener() {

                        @Override
                        public void onProgressChanged(int pProgress) {
                            // TODO Auto-generated method stub
                            onProgressUpdate(pProgress);
                        }
                    });
                } catch (Exception e) {
                    Log.e("error", e.toString());
                }

                return null;
            }

            /**
             * 更新进度框
             */
            protected void onProgressUpdate(final Integer... values) {
                mProgressDialog.setProgress(values[0]);
            }

            ;

            /**
             * 第三步执行这个方法，运行于主线程
             */
            protected void onPostExecute(T result) {
                if (mProgressDialog != null)
                    mProgressDialog.dismiss();
                pCallback.onCallback(result);

            }

        }.execute((Void[]) null);

    }

    /**
     * 封装的asynctask方法，此方法拥有进度对话框，并支持定义样式.
     *
     * @param pContext         上下文
     * @param styleID          话框样式 ProgressDialog.STYLE_HORIZONTAL|ProgressDialog.STYLE_SPINNER
     * @param pTitleResId      title resId
     * @param pMessageResId    message resId
     * @param pCallEarliest    运行于主线程，最先执行此方法.
     * @param progressCallable 运行于异步线程,用于传递对话框进度.
     * @param pCallback        运行于主线程,最后执行此方法.
     * @param <T>              type
     */
    public static <T> void doProgressAsync(final Context pContext,
                                           final int styleID, final int pTitleResId, final int pMessageResId,
                                           final CallEarliest<T> pCallEarliest,
                                           final ProgressCallable<T> progressCallable,
                                           final Callback<T> pCallback) {
        WinchanceAsyncTask.doProgressAsync(pContext, styleID,
                pContext.getString(pTitleResId),
                pContext.getString(pMessageResId), pCallEarliest,
                progressCallable, pCallback);
    }

}
