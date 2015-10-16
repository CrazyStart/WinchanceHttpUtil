package asynctask;



/**
 * 回调接口,回调方法运行于主线程
 * @version 1.0.0
 * @param <T> T
 */
public interface Callback<T> {
	
	public void onCallback(final T pCallbackValue);
}