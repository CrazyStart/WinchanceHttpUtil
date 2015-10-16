package asynctask;


/**
 * 回调接口,回调方法运行于异步线程
 * @version 1.0.0
 * @param <T> callable
 */
public interface Callable<T> {
	
	public T call() throws Exception;
}