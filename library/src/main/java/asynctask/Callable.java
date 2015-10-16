package asynctask;


/**
 * 回调接口,回调方法运行于异步线程
 * @ClassName: Callable
 * @version
 * @param <T>
 */
public interface Callable<T> {
	
	public T call() throws Exception;
}