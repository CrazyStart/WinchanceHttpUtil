package asynctask;



/**
 * 回调接口,回调方法运行于主线程
 * @ClassName: Callback
 * @version
 * @param <T>
 */
public interface Callback<T> {
	
	public void onCallback(final T pCallbackValue);
}